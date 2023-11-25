CREATE PROCEDURE sp_EliminarEventoFactura
( @id_evento int ) 
AS 
BEGIN 
SET NOCOUNT ON;

BEGIN TRY BEGIN TRANSACTION;

-- Verificar si el evento existe 
IF NOT EXISTS(SELECT 1 FROM Eventos WHERE eventoID = @id_evento) 
BEGIN 
RAISERROR('No es posible encontrar el evento que se busca.', 16, 1); 
ROLLBACK TRANSACTION; 
RETURN; 
END

-- Eliminar ServiciosEventos relacionados con el evento 
DELETE FROM ServiciosEventos WHERE Id_evento = @id_evento;

-- Eliminar Facturas relacionadas con el evento 
DELETE FROM Facturas WHERE id_evento = @id_evento;

-- Eliminar el evento 
DELETE FROM Eventos WHERE eventoID = @id_evento;

COMMIT TRANSACTION; 
END TRY 
BEGIN CATCH 
-- Deshacer la transacción en caso de error 
ROLLBACK TRANSACTION;

RAISERROR('No es posible eliminar el evento: %d', 16, 1, @id_evento);
RETURN; END CATCH; 
END