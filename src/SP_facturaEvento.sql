CREATE PROCEDURE sp_CrearNuevoEventoFactura 
( 
@documento varchar(50), 
@tipoDocumento varchar(50), 
@nombreEvento varchar(20),
@descripcion varchar(500), 
@servicios varchar(100), 
@estado varchar(50), 
@fecha Date, 
@Subtotal numeric(10,2)
) 
AS BEGIN 
SET NOCOUNT ON;

DECLARE @clienteId int; 
DECLARE @id_evento int; 
DECLARE @valor_total numeric(10,2);
DECLARE @SubtotalT numeric(10,2);

BEGIN 
TRY 
BEGIN 
TRANSACTION;

-- Verificar existencia del cliente 
SELECT @clienteId = clienteID FROM Clientes WHERE numeroDocumento = @documento AND tipoDocumento = @tipoDocumento;


IF @clienteId IS NULL 
BEGIN 
RAISERROR('No es posible encontrar al cliente que se busca.', 16, 1); 
ROLLBACK TRANSACTION; 
RETURN; 
END;

-- Verificar estado del evento 
IF ISNULL(@estado, '') = '' 
BEGIN 
RAISERROR('El estado no debe ser vacio.', 16, 1); 
ROLLBACK TRANSACTION; 
RETURN; 
END;

-- Insertar el evento en la tabla Eventos 
INSERT INTO Eventos (nombre, fecha, descripcion, Estado) 
VALUES (@nombreEvento, @fecha, @descripcion, @estado);

SET @id_evento = SCOPE_IDENTITY();

IF @id_evento IS NULL 
BEGIN 
RAISERROR('No es posible capturar el id del último evento creado.', 16, 1);
ROLLBACK TRANSACTION; 
RETURN; 
END;

-- Insertar los servicios relacionados al evento 
INSERT INTO ServiciosEventos (Id_evento, id_servicio) 
SELECT @id_evento, value FROM STRING_SPLIT(@servicios, ',');
COMMIT TRANSACTION;

IF @estado = 'facturado' OR @estado = 'pendiente' OR @estado = 'cotizado'
BEGIN 
SELECT @valor_total = SUM(s.valor), @SubtotalT = CASE WHEN @Subtotal > 0 THEN SUM(s.valor) - @Subtotal ELSE 0 END 
FROM ServiciosEventos se JOIN Eventos e ON e.eventoID = se.Id_evento JOIN Servicios s ON s.servicioID = se.id_servicio 
WHERE e.eventoID = @id_evento;

IF @valor_total > 0 
BEGIN 
INSERT INTO Facturas (id_evento, id_cliente, fecha, valor_total, subTotal) 
VALUES (@id_evento, @clienteId, GETUTCDATE(), @valor_total, @SubtotalT); 
END 
ELSE 
BEGIN RAISERROR('No es posible identificar valor de factura.', 16, 1); 
ROLLBACK TRANSACTION; 
RETURN; 
END 
END 
END 
TRY 
BEGIN 
CATCH 
ROLLBACK TRANSACTION; 
RAISERROR('No es posible insertar el nuevo evento: ', 16, 1); 
RETURN; 
END CATCH;
END 


select * from ServiciosEventos


select * from Clientes

drop procedure sp_CrearNuevoEvento

select * from Eventos

select * from Facturas