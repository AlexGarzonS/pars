CREATE PROCEDURE sp_InsertarServicio 
(
    @NombreServicio VARCHAR(50),
	@descricionServicio VARCHAR(500),
	@valor numeric(10,2)
)
AS
BEGIN
DECLARE @errorMessage varchar(max);
SET NOCOUNT ON;

    -- Verificar si el nuevo registro ya existe
    IF EXISTS (SELECT 1 FROM Servicios WHERE nombre_Servicio = @NombreServicio)
    BEGIN
        SET @errorMessage = 'un servicio ya se encuentra creado con es nombre :'+@NombreServicio;
		RAISERROR(@errorMessage, 16, 1);
		RETURN;
    END
    ELSE
    BEGIN
        -- Insertar el nuevo registro
        INSERT INTO Servicios (nombre_Servicio, descripcion,valor)
        VALUES (@NombreServicio, @descricionServicio,@valor);
    END
END