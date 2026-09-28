# `CASE`
El operador `CASE` en SQL es una estructura condicional similar a `if-else`, que permite evaluar condiciones y devolver valores diferentes en función de estas evaluaciones.

Se usa dentro de consultas SQL para modificar los datos de salida sin alterar los datos originales en la base de datos.

## ¿Para qué se utiliza?
* Para crear **columnas calculadas** en una consulta.

* Para transformar valores (por ejemplo, convertir códigos numéricos en descripciones).

* Para agrupar datos en categorías.

* Para evitar múltiples consultas separadas y consolidar la lógica en una sola consulta.

* Para establecer valores predeterminados en casos donde una columna puede ser `NULL`.

## ¿Qué resuelve?
* **Personalización de resultados**: Permite cambiar la forma en que se presentan los datos sin modificar los registros originales.

* **Mayor legibilidad**: En lugar de usar varias consultas `IF`, se puede utilizar CASE en una sola consulta.

* **Eficiencia**: Reduce la necesidad de múltiples `JOIN` o consultas separadas.

## ¿Cómo lo resuelve?
* Evalúa condiciones en orden y devuelve el primer valor que coincida.

* Si ninguna condición se cumple, puede devolver un valor `ELSE` o `NULL`.

## Sintaxis
Existen dos formas principales de utilizar CASE:

1. `CASE` con múltiples condiciones (`CASE WHEN THEN`)
```sql
SELECT columna,
       CASE
           WHEN condicion_1 THEN resultado_1
           WHEN condicion_2 THEN resultado_2
           ELSE resultado_por_defecto
       END AS nombre_columna_calculada
FROM tabla;
```
* Evalúa condicion_1, si es TRUE, devuelve resultado_1.

* Si condicion_1 es FALSE, evalúa condicion_2, si es TRUE, devuelve resultado_2.

* Si ninguna condición se cumple, devuelve el valor en ELSE (opcional).

2. CASE con comparación directa (`CASE columna WHEN THEN`)
```sql
SELECT columna,
       CASE columna
           WHEN valor_1 THEN resultado_1
           WHEN valor_2 THEN resultado_2
           ELSE resultado_por_defecto
       END AS nombre_columna_calculada
FROM tabla;
```
* Similar a SWITCH en otros lenguajes.

* Compara el valor de una columna con múltiples valores.

## Ejemplos Prácticos de CASE en SQL
Ejemplo 1: Clasificación de edades
Supongamos que tenemos una tabla clientes con una columna edad y queremos categorizar a los clientes por rango de edad.
```sql
SELECT nombre, edad,
       CASE
           WHEN edad < 18 THEN 'Menor de edad'
           WHEN edad BETWEEN 18 AND 65 THEN 'Adulto'
           ELSE 'Adulto mayor'
       END AS categoria_edad
FROM clientes;
```
Salida
```bash
nombre	  edad	  categoria_edad
Juan	    17	    Menor de edad
Ana	      30	    Adulto
Luis	    70	    Adulto mayor
```

Ejemplo 2: Cambio de códigos por descripciones
Tenemos una tabla pedidos con una columna estado que almacena códigos (1=Pendiente, 2=Enviado, 3=Entregado). Queremos mostrar los estados con nombres.
```sql
SELECT id_pedido, cliente,
       CASE estado
           WHEN 1 THEN 'Pendiente'
           WHEN 2 THEN 'Enviado'
           WHEN 3 THEN 'Entregado'
           ELSE 'Desconocido'
       END AS estado_pedido
FROM pedidos;
```
Salida
```bash
id_pedido	  cliente	    estado_pedido
101	        Juan	      Pendiente
102	        Ana	        Enviado
103	        Pedro	      Entregado
```

Ejemplo 3: Uso de CASE dentro de ORDER BY
Queremos ordenar a los empleados según su cargo, pero mostrando primero los gerentes (Gerente), luego los supervisores (Supervisor), y al final los empleados (Empleado).
```sql
SELECT nombre, cargo
FROM empleados
ORDER BY 
    CASE cargo
        WHEN 'Gerente' THEN 1
        WHEN 'Supervisor' THEN 2
        ELSE 3
    END;
```
Salida
```bash
Laura	Gerente
Pedro	Gerente
Ana	Supervisor
Luis	Empleado
```

Ejemplo 4: Uso de CASE con GROUP BY y HAVING
Queremos contar cuántos pedidos tienen cada estado (Pendiente, Enviado, Entregado).
```sql
SELECT 
    CASE estado
        WHEN 1 THEN 'Pendiente'
        WHEN 2 THEN 'Enviado'
        WHEN 3 THEN 'Entregado'
        ELSE 'Desconocido'
    END AS estado_pedido, 
    COUNT(*) AS total_pedidos
FROM pedidos
GROUP BY estado;
```
Salida
```bash
estado_pedido	total_pedidos
Pendiente	    5
Enviado	      8
Entregado	    12
```

Ejemplo 5: Uso de CASE con UPDATE
Si queremos actualizar el estado de pedidos basado en la fecha de entrega, podemos usar CASE en un UPDATE.
```sql
UPDATE pedidos
SET estado = CASE 
                WHEN fecha_entrega IS NULL THEN 1  -- Pendiente
                WHEN fecha_entrega <= NOW() THEN 3 -- Entregado
                ELSE 2  -- Enviado
             END;
```
* Si fecha_entrega es NULL, el estado se actualiza a 1 (Pendiente).

* Si fecha_entrega es hoy o antes, el estado se actualiza a 3 (Entregado).

* En otro caso, el estado se actualiza a 2 (Enviado).

## Consideraciones importantes
* **El orden de las condiciones importa** Se evalúan de arriba hacia abajo, la primera condición que se cumpla se ejecuta y las demás se ignoran.

* **`ELSE` es opcional pero recomendable**. Si no se usa `ELSE`, y ninguna condición se cumple, el resultado será `NULL`.

* **Usar `CASE` dentro de funciones agregadas (`SUM`, `COUNT`, etc.)** Se puede usar dentro de SUM() o COUNT() para contar o sumar solo ciertos valores.

* **Rendimiento**: En consultas con muchas filas, `CASE` puede afectar el rendimiento si las condiciones son complejas.