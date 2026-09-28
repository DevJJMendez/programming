# Java Database Connectivity
**JDBC** es una API de Java que permite conectar aplicaciones Java con bases de datos relacionales, como MySQL, PostgreSQL, Oracle, entre otras. **JDBC** proporciona una interfaz estándar para ejecutar operaciones en bases de datos, simplificando la integración de bases de datos con aplicaciones Java.

**JDBC** es un conjunto de interfaces y clases en Java que permite a las aplicaciones:

* Conectarse a una base de datos.

* Ejecutar consultas y operaciones de actualización en dicha base de datos.

* Recuperar y manipular datos.

Es una de las API clave de Java para la persistencia de datos, y se encuentra en el paquete `java.sql` de la biblioteca estándar de Java.

**¿Para qué sirve JDBC?**, **JDBC** permite la comunicación directa entre una aplicación Java y una base de datos relacional, ofreciendo métodos y clases para:

* Conectar y autenticarse en una base de datos.

* Ejecutar sentencias SQL.

* Procesar los resultados obtenidos de la base de datos.

* Controlar transacciones (commit, rollback).

**¿Qué resuelve JDBC?**, **JDBC** resuelve el problema de conectar aplicaciones Java con bases de datos de forma estándar y estructurada, permitiendo que una aplicación pueda:

* Almacenar, recuperar, modificar y eliminar datos en una base de datos relacional.

* Ejecutar consultas SQL sin tener que depender de características específicas de un proveedor de base de datos.

* Manejar conexiones a base de datos de forma eficiente y segura.

Sin **JDBC**, los desarrolladores tendrían que crear conexiones y ejecutar consultas mediante interfaces o bibliotecas específicas de cada base de datos, lo que aumenta la complejidad y reduce la portabilidad del código.

**¿Cómo resuelve JDBC estos problemas?**, JDBC resuelve la comunicación entre Java y las bases de datos mediante una arquitectura de 4 componentes clave:

1. **Driver JDBC**: Actúa como un intermediario entre Java y la base de datos. Cada base de datos necesita su propio driver JDBC. Java usa los drivers para enviar instrucciones SQL a la base de datos y recibir resultados.

   * **`Driver Manager`**: Administra una lista de controladores de bases de datos. Se asegura de que la correcta sea utilizada para una conexión de base de datos dada.

   * **`Driver`**: Se comunica directamente con el DBMS y maneja los detalles de la conexión.

2. **`Connection`**: Es la conexión activa entre la aplicación Java y la base de datos. La clase `Connection` permite establecer, cerrar y manejar la conexión con la base de datos.

3. **`Statement`**: Representa una sentencia SQL. JDBC proporciona tres tipos de sentencias: `Statement`, `PreparedStatement` (para consultas precompiladas) y `CallableStatement` (para procedimientos almacenados).

4. **`ResultSet`**: Almacena los datos devueltos por una consulta SQL. ResultSet permite iterar por los registros obtenidos y obtener datos específicos.

**Ademas**
* **`SQLException`**: Maneja cualquier error que ocurra en la interacción con la base de datos.

## Ejemplo Básico de JDBC
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";
        
        try {
            // Cargar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecer la conexión
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            
            // Crear un Statement
            Statement statement = connection.createStatement();
            
            // Ejecutar una consulta
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);
            
            // Procesar el ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }
            
            // Cerrar el ResultSet, Statement y Connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

## Buenas prácticas en JDBC:
* Usar `PreparedStatement` en lugar de `Statement` para evitar inyección SQL.

* Cerrar siempre las conexiones para liberar recursos.
  * Asegúrate de cerrar todas las conexiones, sentencias y **result sets** en un bloque `finally` o usando `try-with-resources`.

* Manejar transacciones explícitamente si es necesario (`commit`, `rollback`).
  * Maneja transacciones utilizando `connection.setAutoCommit(false)` y `connection.commit()`.

* Utilizar un pool de conexiones en aplicaciones de gran escala.
  * Utiliza un pool de conexiones como **HikariCP** para gestionar las conexiones de manera eficiente.

* **Logging**: Implementa **logging** para monitorear las operaciones de la base de datos.