# Consultas Preparadas

Las consultas preparadas son un mecanismo para ejecutar consultas SQL de manera segura y eficiente en bases de datos. En lugar de concatenar directamente los valores de los parámetros en la cadena de consulta SQL, las consultas preparadas utilizan marcadores de posición para los valores que serán proporcionados más adelante. Esto separa la lógica de la consulta de los datos que se están utilizando, lo que brinda varios beneficios:

- **Seguridad contra la inyección SQL**: Al separar los datos de la consulta SQL, las consultas preparadas ayudan a prevenir los ataques de inyección SQL. Los valores de los parámetros no son interpretados como parte de la consulta, evitando así que los usuarios malintencionados manipulen la consulta.

- **Mejor rendimiento**: Al ejecutar una consulta preparada varias veces con diferentes valores de parámetros, el servidor de la base de datos puede compilar la consulta una vez y reutilizar el plan de ejecución para consultas futuras con diferentes valores de parámetros. Esto puede mejorar significativamente el rendimiento, especialmente en aplicaciones con consultas frecuentes.