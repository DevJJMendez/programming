### File Class

La clase File en Java es parte del paquete java.io y proporciona una abstracción para los nombres de archivo y directorio en el sistema de archivos. La clase File permite crear, eliminar, inspeccionar y manipular archivos y directorios.

**Creación de un Objeto File**

Para crear un objeto `File`, puedes usar uno de los constructores disponibles:
```java
import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        // Crear un objeto File para un archivo
        File file = new File("ruta/al/archivo.txt");

        // Crear un objeto File para un directorio
        File directory = new File("ruta/al/directorio");
    }
}
```

### Operaciones Comunes con la Clase `File`

1. Comprobación de Existencia:
    ```java
    if (file.exists()) {
        System.out.println("El archivo existe.");
    } else {
        System.out.println("El archivo no existe.");
    }
    ```
2. Creación de Archivos y Directorios:
    ```java
    try {
        if (file.createNewFile()) {
            System.out.println("Archivo creado exitosamente.");
        } else {
            System.out.println("El archivo ya existe.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    if (directory.mkdir()) {
        System.out.println("Directorio creado exitosamente.");
    } else {
        System.out.println("El directorio ya existe o no se pudo crear.");
    }
    ```
3. Eliminación de Archivos y Directorios:
    ```java
    if (file.delete()) {
        System.out.println("Archivo eliminado exitosamente.");
    } else {
        System.out.println("No se pudo eliminar el archivo.");
    }

    if (directory.delete()) {
        System.out.println("Directorio eliminado exitosamente.");
    } else {
        System.out.println("No se pudo eliminar el directorio.");
    }
    ```
4. Inspección de Propiedades de Archivos y Directorios:
    ```java
    System.out.println("Nombre del archivo: " + file.getName());
    System.out.println("Ruta absoluta: " + file.getAbsolutePath());
    System.out.println("Es un directorio: " + file.isDirectory());
    System.out.println("Es un archivo: " + file.isFile());
    System.out.println("Tamaño del archivo: " + file.length() + " bytes");
    ```
5. Listar Archivos y Directorios:
    ```java
    File[] files = directory.listFiles();
    if (files != null) {
        for (File f : files) {
            System.out.println(f.getName());
        }
    }
    ```

**Ejemplo Completo**
```java
import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("archivo.txt");
        File directory = new File("directorio");

        // Crear un archivo
        try {
            if (file.createNewFile()) {
                System.out.println("Archivo creado exitosamente: " + file.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crear un directorio
        if (directory.mkdir()) {
            System.out.println("Directorio creado exitosamente: " + directory.getName());
        } else {
            System.out.println("El directorio ya existe o no se pudo crear.");
        }

        // Comprobar propiedades del archivo
        System.out.println("Nombre del archivo: " + file.getName());
        System.out.println("Ruta absoluta: " + file.getAbsolutePath());
        System.out.println("Es un directorio: " + file.isDirectory());
        System.out.println("Es un archivo: " + file.isFile());
        System.out.println("Tamaño del archivo: " + file.length() + " bytes");

        // Listar archivos en el directorio
        File[] files = directory.listFiles();
        if (files != null) {
            System.out.println("Archivos en el directorio:");
            for (File f : files) {
                System.out.println(f.getName());
            }
        }

        // Eliminar el archivo
        if (file.delete()) {
            System.out.println("Archivo eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo.");
        }

        // Eliminar el directorio
        if (directory.delete()) {
            System.out.println("Directorio eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar el directorio.");
        }
    }
}
```