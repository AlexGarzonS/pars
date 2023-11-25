CREATE TRIGGER TR_AuditarTablaFacturas
ON Facturas
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
--Controla si se devuelve un mensaje que muestra el recuento del número de filas afectadas por una instrucción
SET NOCOUNT ON;
DECLARE @Tabla VARCHAR(100);
DECLARE @Operacion VARCHAR(10);
DECLARE @ValoresAnteriores VARCHAR(MAX);
DECLARE @ValoresNuevos VARCHAR(MAX);
DECLARE @FechaHora DATETIME;
SET @Tabla = 'Facturas';
SET @FechaHora = GETDATE();
-- se verifica operaciones realizadas
IF EXISTS (SELECT * FROM inserted)
BEGIN
IF EXISTS (SELECT * FROM deleted)
BEGIN
SET @Operacion = 'UPDATE';
-- Obtener valores anteriores
-- El modo RAW transforma cada fila del conjunto de resultados de la consulta en un elemento XML
SELECT @ValoresAnteriores = (SELECT * FROM deleted FOR XML RAW);
-- Obtener valores nuevos
SELECT @ValoresNuevos = (SELECT * FROM inserted FOR XML RAW);
END
ELSE
BEGIN
SET @Operacion = 'INSERT';
-- Obtener valores nuevos
SELECT @ValoresNuevos = (SELECT * FROM inserted FOR XML RAW);
END
END
ELSE
BEGIN
SET @Operacion = 'DELETE';
-- Obtener valores anteriores
SELECT @ValoresAnteriores = (SELECT * FROM deleted FOR XML RAW);
END
-- se realiza inserción a la tabla auditoria
INSERT INTO dbo.Auditoria (Tabla, Operacion, ValoresAnteriores, ValoresNuevos, FechaHora)
VALUES (@Tabla, @Operacion, @ValoresAnteriores, @ValoresNuevos, @FechaHora);
END