# `INSERT INTO SELECT`
El comando INSERT INTO SELECT en SQL permite insertar datos en una tabla seleccionando filas de otra tabla (o la misma tabla). Es una técnica eficiente para copiar o mover datos de una tabla a otra, transformarlos durante el proceso, o agregar datos de manera dinámica sin tener que escribir valores explícitamente.

## ¿Qué es INSERT INTO SELECT?
Es una combinación de dos operaciones:

* `INSERT INTO`: Que agrega nuevas filas a una tabla.

* `SELECT`: Que selecciona los datos a insertar desde otra tabla.

En lugar de proporcionar valores explícitos en la cláusula `VALUES`, el comando toma los valores de una consulta `SELECT`.

## ¿Para qué se utiliza?
* Copiar datos de una tabla a otra.

* Poblar una tabla nueva basada en datos existentes.

* Transferir datos entre tablas en diferentes esquemas o bases de datos (cuando es compatible).

* Agregar datos dinámicamente en función de condiciones específicas.

## ¿Qué resuelve?
* **Automatización**: Inserta datos dinámicamente basados en una consulta sin tener que especificar manualmente cada fila.

* **Reducción de código repetitivo**: Evita múltiples sentencias `INSERT INTO` individuales.

* **Procesamiento masivo**: Inserta grandes volúmenes de datos de manera eficiente.

* **Transformación de datos**: Puedes usar funciones y expresiones dentro de la consulta `SELECT` para modificar los datos antes de insertarlos.

## ¿Cómo lo resuelve?
* Combina los resultados de una consulta `SELECT` con la operación de inserción, copiando los datos directamente en la tabla objetivo.

* La estructura de la tabla destino y los datos seleccionados deben coincidir en número de columnas, tipos de datos y orden.

* Se puede filtrar, transformar y calcular datos en el proceso de inserción utilizando expresiones, cláusulas `WHERE`, funciones agregadas, etc.

## Sintaxis
Copiando datos de una tabla a otra:
```sql
INSERT INTO tabla_destino (columna1, columna2, ...)
SELECT columna1, columna2, ...
FROM tabla_origen
WHERE condicion;
```
* **`tabla_destino`**: Es la tabla donde se insertarán los datos.

* **`(columna1, columna2, ...)`**: Es opcional; si no se especifica, se espera que la tabla destino tenga el mismo número de columnas y en el mismo orden que las columnas seleccionadas.

* **`tabla_origen`**: Es la tabla desde donde se seleccionan los datos.

* **`condicion`**: Es opcional y permite filtrar los datos antes de insertarlos.

Copiar todos los datos de una tabla:
```sql
INSERT INTO tabla_destino
SELECT * FROM tabla_origen;
```

## Ejemplos prácticos:
**Ejemplo 1: Copiar datos de una tabla a otra**: Supongamos que tienes dos tablas: `clientes_backup` y `clientes`. Quieres copiar los datos de clientes a `clientes_backup`.
```sql
INSERT INTO clientes_backup (id, nombre, correo)
SELECT id, nombre, correo
FROM clientes;
```
**Esto copiará todas las filas de la tabla clientes a la tabla `clientes_backup`.**


Ejemplo 2: Insertar solo ciertos datos: Ahora, queremos insertar únicamente clientes cuyo país sea "México".
```sql
INSERT INTO clientes_backup (id, nombre, correo)
SELECT id, nombre, correo
FROM clientes
WHERE pais = 'México';
```

Ejemplo 3: Transformar datos al insertarlos: Supongamos que quieres insertar datos en una tabla llamada ventas_anuales, pero con un cálculo adicional basado en los datos de la tabla ventas.
```sql
INSERT INTO ventas_anuales (producto_id, total_anual)
SELECT producto_id, SUM(total_venta)
FROM ventas
GROUP BY producto_id;
```
Aquí, estás calculando el total anual de ventas por producto (SUM(total_venta)) y luego insertando estos datos en la tabla ventas_anuales.

Ejemplo 4: Copiar entre tablas con diferentes nombres de columnas
Si las columnas de las tablas no tienen el mismo nombre, puedes mapearlas manualmente.

Tabla de origen: empleados
Tabla de destino: personas
```sql
INSERT INTO personas (id, nombre_completo, correo_electronico)
SELECT id, CONCAT(nombre, ' ', apellido), correo
FROM empleados;
```
En este caso, concatenas el nombre y apellido para llenar la columna nombre_completo.

Ejemplo 5: Usar con tablas vacías y diseño idéntico: Si tabla_destino y tabla_origen tienen el mismo diseño, puedes omitir los nombres de las columnas:
```sql
INSERT INTO tabla_destino
SELECT * FROM tabla_origen;
```
Esto es común al migrar datos entre tablas idénticas.

## Consideraciones importantes
Coincidencia de columnas:

El número de columnas seleccionadas en el SELECT debe coincidir con el número de columnas de la tabla destino, ya sea explícita o implícitamente.
Los tipos de datos de las columnas deben ser compatibles.
Orden de las columnas:

Si no especificas las columnas en la tabla destino, se asumirá que las columnas están en el mismo orden que las seleccionadas en el SELECT.
Rendimiento:

Insertar grandes volúmenes de datos puede afectar el rendimiento. Si trabajas con muchas filas, considera usar índices desactivados temporalmente o técnicas de particionamiento.
Subconsultas:

El SELECT dentro de INSERT INTO puede incluir subconsultas, expresiones complejas y funciones agregadas.
Restricciones:

Si la tabla destino tiene restricciones como claves primarias o únicas, asegúrate de que los datos insertados no violen estas reglas.

## Ejemplo en una aplicación real: Migración de usuarios
Supongamos que tienes una tabla de usuarios usuarios y quieres mover solo aquellos que se registraron en 2024 a una tabla de usuarios archivados llamada usuarios_archivados.

```sql
INSERT INTO usuarios_archivados (id, nombre, correo, fecha_registro)
SELECT id, nombre, correo, fecha_registro
FROM usuarios
WHERE YEAR(fecha_registro) = 2024;
```
Este comando selecciona los usuarios que se registraron en 2024 y los inserta en la tabla usuarios_archivados.