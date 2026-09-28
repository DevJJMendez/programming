# LIKE
Se utiliza para realizar búsquedas de patrones dentro de valores de texto en una columna de una tabla. Es una herramienta poderosa que te permite buscar y recuperar filas que contienen ciertos patrones de caracteres en lugar de buscar una coincidencia exacta.

- **Ejemplo**
  ```sql
  SELECT 
    name, age, email
  FROM
      users
  WHERE
      name LIKE 'Antone Johns V';
  ```

# Wilcards / Comodines
Son caracteres especiales que se utilizan en combinación con la cláusula **LIKE** en SQL para representar patrones de búsqueda flexibles. 

## `%` se utiliza para representar cero, uno o varios caracteres en una posición en el patrón de búsqueda.

* **caracteres%**:  Buscara todos los valores que comienzen por el caracter especificado.
    ```sql
      SELECT 
        name, age, email
      FROM
          users
      WHERE
          name LIKE 'Al%';
      
      -- Ejemplo: Alberto, Alvaro, Almendra 
    ```
* **%caracteres**: Buscara todos los valores que terminen en el caracter especificado. 
    ```sql
    SELECT 
        name, age, email
      FROM
          users
      WHERE
          name LIKE '%AN';
      
      -- Ejemplo: Nathan, Juan ...
    ```
  
* **%caracteres%** Buscara todos los nombres que contengan las letras ANT como parte del nombre
  ```sql
  SELECT 
      name, age, email
    FROM
        users
    WHERE
        name LIKE '%ANT%';

  -- Ejemplo: Antone, Antonio, Santina, Stanton
  ```

* `-` (subrayado o guio bajo): 
  se utiliza como un comodín en combinación con la cláusula `LIKE` en SQL para representar un solo carácter en una posición específica de un patrón de búsqueda.

  Cuando se usa `_` en un patrón de búsqueda con `LIKE`, estás buscando valores que coincidan con el patrón en el que `_` representa **cualquier** carácter en esa posición. Por ejemplo:

  - `_A` buscará valores que tengan un carácter seguido de "A". Por ejemplo, "BA", "CA", "DA", etc.
 
  - `A_` buscará valores que tengan "A" seguido de cualquier carácter. Por ejemplo, "AB", "AC", "AD", etc.
  
  - `_A_` buscará valores que tengan cualquier carácter seguido de "A" y seguido de otro carácter. Por ejemplo, "BAN", "CAN", "DAM", etc.

- `[]` (corchetes):
  se utilizan como parte de la cláusula `LIKE` en SQL para representar un conjunto de caracteres posibles en una posición específica dentro de un patrón de búsqueda. Esto te permite buscar valores que contengan cualquier carácter que esté dentro del conjunto especificado en esa posición.

  Al utilizar `[ ]` en un patrón de búsqueda con `LIKE`, estás indicando que la posición 05-likecorrespondiente puede contener cualquiera de los caracteres dentro de los corchetes.

  - Por ejemplo:

  - '`[JM]`ohn' buscará valores que comiencen con "J" o "M" seguido de "ohn". Por ejemplo, "John", "Mohn", etc.
  
  - `V[aeiou]n` buscará valores que comiencen con "V" seguido de cualquier vocal y luego "n". Por ejemplo, "Van", "Ven", "Vin", "Von", "Vun", etc.
  
  - `[0-9]%` buscará valores que comiencen con cualquier dígito del 0 al 9. Por ejemplo, "1abc", "2xyz", etc.