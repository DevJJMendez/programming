# Stored Procedures
Los Stored Procedures (Procedimientos Almacenados) son una de las herramientas más poderosas en SQL para mejorar la eficiencia, seguridad y organización del código en bases de datos. 

## ¿Qué son los Stored Procedures?
Un Stored Procedure (SP) es un conjunto de instrucciones SQL precompiladas y almacenadas en el servidor de la base de datos.

* Se ejecutan con un solo comando, sin necesidad de escribir nuevamente la lógica SQL.

* Se pueden reutilizar en varias partes de la aplicación, evitando código repetitivo.

* Son más rápidos porque se ejecutan en el motor de la base de datos.

Ejemplo básico de un Stored Procedure:
```sql
CREATE PROCEDURE ObtenerClientes()
BEGIN
    SELECT * FROM clientes;
END;
```
Este procedimiento obtiene todos los clientes de la base de datos.

## ¿Para qué sirven los Stored Procedures?
* **Automatización de procesos**: Se pueden programar para ejecutarse en momentos específicos.

* **Reutilización de código**: Evita repetir la misma consulta en varias partes del código.

* **Mejora del rendimiento**: Se ejecutan en el servidor, reduciendo la carga en la aplicación cliente.

* **Mayor seguridad**: Se pueden restringir permisos a ciertos usuarios.

* **Facilitan el mantenimiento**: Modificar un **SP** afecta a todas las aplicaciones que lo usan.

Ejemplo: Un SP para calcular el total de ventas de un cliente sin repetir la lógica en diferentes consultas.
```sql
CREATE PROCEDURE TotalVentasCliente(IN cliente_id INT)
BEGIN
    SELECT SUM(total) AS total_ventas
    FROM ventas
    WHERE id_cliente = cliente_id;
END;
```

## ¿Qué problemas resuelven los Stored Procedures?
* Código repetitivo en consultas SQL
  * Se encapsula en un solo procedimiento.

* Bajo rendimiento por múltiples consultas desde la aplicación
  * Se ejecutan en el servidor, reduciendo tráfico de datos.

* Falta de seguridad en el acceso a datos
  * Se restringe acceso a las tablas directas.

* Mantenimiento difícil en consultas largas
  * Se centraliza la lógica SQL en el SP.

## ¿Cómo se implementan los Stored Procedures?
1. Creación de un Stored Procedure: La sintaxis puede variar según el motor de base de datos (MySQL, PostgreSQL, SQL Server), pero la estructura general es:
```sql
CREATE PROCEDURE nombre_procedimiento (parámetros)
BEGIN
    -- Instrucciones SQL
END;
```
Ejemplo en MySQL:
```sql
DELIMITER $$

CREATE PROCEDURE ListarClientes()
BEGIN
    SELECT * FROM clientes;
END$$

DELIMITER ;
```
`DELIMITER $$` se usa en MySQL para definir el final del bloque del SP.

**Ejecución de un Stored Procedure**
```sql
CALL ListarClientes();
```

Stored Procedures con Parámetros
Los SP pueden recibir parámetros de entrada y salida.

1. Parámetros de Entrada (IN)
```sql
CREATE PROCEDURE BuscarCliente(IN cliente_id INT)
BEGIN
    SELECT * FROM clientes WHERE id = cliente_id;
END;
```
Uso
```sql
CALL BuscarCliente(5);
```
Esto devuelve el cliente con id = 5.

2. Parámetros de Salida (OUT)
```sql
CREATE PROCEDURE TotalClientes(OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total FROM clientes;
END;
```
Uso
```sql
CALL TotalClientes(@resultado);
SELECT @resultado;
```
Esto almacena el número total de clientes en @resultado.

Parámetros de Entrada y Salida (INOUT)
```sql
CREATE PROCEDURE DuplicarValor(INOUT numero INT)
BEGIN
    SET numero = numero * 2;
END;
```
Uso
```sql
SET @mi_numero = 10;
CALL DuplicarValor(@mi_numero);
SELECT @mi_numero; -- Resultado: 20
```

tored Procedures con Estructuras de Control
También pueden contener estructuras como IF, LOOP, WHILE y CASE.

1 Uso de IF... ELSE
```sql
CREATE PROCEDURE EstadoPedido(IN pedido_id INT, OUT estado VARCHAR(50))
BEGIN
    DECLARE total DECIMAL(10,2);

    SELECT SUM(total) INTO total FROM pedidos WHERE id = pedido_id;

    IF total > 500 THEN
        SET estado = 'Pedido grande';
    ELSE
        SET estado = 'Pedido pequeño';
    END IF;
END;
```
Uso
```sql
CALL EstadoPedido(3, @estado);
SELECT @estado;
```
Muestra si un pedido es grande o pequeño.

Uso de LOOP
```sql
CREATE PROCEDURE Contador()
BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= 5 DO
        SELECT CONCAT('Iteración: ', i);
        SET i = i + 1;
    END WHILE;
END;
```
Esto imprimirá "Iteración: 1" hasta "Iteración: 5".

## Modificación y Eliminación de Stored Procedures
Modificar un SP
La mayoría de los motores de base de datos no permiten modificar un SP directamente, por lo que debes eliminarlo y crearlo de nuevo.
```sql
DROP PROCEDURE IF EXISTS ListarClientes;
```
Luego, se crea nuevamente con las modificaciones necesarias.

## Mejoras y Buenas Prácticas
* Usa nombres descriptivos para los procedimientos.

* Evita lógica compleja dentro de los SP (usa funciones en su lugar).

* Usa OUT solo cuando sea necesario (evita modificar variables globales).

* Controla errores con BEGIN... END y mensajes de error personalizados.

* Usa índices en las tablas para mejorar la velocidad de los SP.