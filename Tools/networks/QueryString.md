# Query String
Un Query String es la parte de una URL que permite enviar parámetros al servidor o recurso solicitado. Se utiliza para filtrar, buscar, ordenar, o pasar información adicional en una petición HTTP (especialmente GET).

Se coloca después del signo de interrogación `?` y está compuesto por pares clave-valor separados por `&`.

**Ejemplo**
```bash
https://miapp.com/productos?categoria=ropa&orden=asc&disponible=true
```
**`?categoria=ropa&orden=asc&disponible=true`** Se interpreta como:
```json
{
  "categoria": "ropa",
  "orden": "asc",
  "disponible": "true"
}
```

## Estructura del Query String
```bash
?clave1=valor1&clave2=valor2&clave3=valor3
```
* `?` → Inicia el query string.
* `clave=valor` → Par clave-valor.
* `&` → Separador entre pares clave-valor.

## ¿Qué resuelve?
| Problema          | Solución con Query String    |
| ----------------- | ---------------------------- |
| Filtros           | `/productos?categoria=ropa`  |
| Ordenamiento      | `/productos?orden=asc`       |
| Paginación        | `/productos?page=2&limit=10` |
| Búsqueda          | `/buscar?q=zapatos`          |
| Control de vistas | `/dashboard?modo=admin`      |

## Operadores
| Símbolo | Nombre                     | Uso                                                   | Ejemplo                        |
| ------- | -------------------------- | ----------------------------------------------------- | ------------------------------ |
| ?       | Inicio de query string     | Marca el inicio del query string                      | /productos?categoria=ropa      |
| =       | Asignación                 | Asocia una clave con un valor                         | orden=asc                      |
| &       | Separador de parámetros    | Separa múltiples pares clave-valor                    | categoria=ropa&orden=asc       |
| %20     | Espacio codificado         | Representa un espacio en URLs                         | busqueda=ropa%20deportiva      |
| +       | Alternativa a %20          | También representa espacios, según el contexto        | q=ropa+deportiva               |
| %xx     | Codificación de caracteres | Para caracteres especiales (UTF-8)                    | q=camiseta%2Fblusa (/)         |
| #       | Fragmento                  | No forma parte del query string, indica una ancla     | /pagina?seccion=ayuda#contacto |
| []      | Arreglos (convención)      | Representar arrays (no estándar, depende del backend) | colores[]=rojo&colores[]=verde |

### Operadores adicionales (por convención en APIs modernas)
Aunque no son operadores “oficiales” del query string (según la especificación URI), muchas APIs RESTful o frameworks los utilizan para funcionalidades avanzadas:
| Operador | Significado común           | Ejemplo                                        |
| -------- | --------------------------- | ---------------------------------------------- |
| `,`      | Lista de valores            | /productos?categorias=ropa,zapatos,electronica |
| `:`      | Filtro por campo o rango    | /productos?precio:gte=100&precio:lte=500       |
| `_`      | Convención para operaciones | precio_min=100&precio_max=500                  |
| **`**    | `                           | OR lógico entre valores (poco usado)           |
| `!`      | Negación (poco común)       | estado!=inactivo (varía según backend)         |

### Qué pasa si quieres usar un operador como > o = en un valor?
Tienes que codificar esos caracteres especiales:
| Carácter |       |                       |
| -------- | ----- | --------------------- |
| `=`      | `%3D` | `filtro=precio%3D100` |
| `>`      | `%3E` | `precio=%3E100`       |
| `<`      | `%3C` | `precio=%3C500`       |
| `:`      | `%3A` | `filtro=precio%3Agte` |

## Ciclo de vida del query string:
1. El navegador o cliente hace una petición como:
```bash
GET /api/usuarios?rol=admin&activo=true
```

2. El servidor parsea los parámetros:
   * En Node.js (Express): **`req.query.rol → "admin"`**

   * En Java (Spring): `@RequestParam String rol`

3. El backend usa esos valores para:
   * Filtrar resultados en una base de datos

   * Modificar la lógica de respuesta

   * Construir respuestas dinámicas

