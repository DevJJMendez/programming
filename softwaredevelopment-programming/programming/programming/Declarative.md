# Declarativo
El paradigma declarativo es una forma de programar donde describes **qué quieres obtener**, no cómo obtenerlo. Le dices al sistema el resultado deseado y dejas que él decida el proceso para lograrlo.

La palabra viene del latín *declarare* — **anunciar, proclamar, hacer evidente**.
```
IMPERATIVO:   "Ve a la nevera, abre la puerta, toma el jugo,
               cierra la puerta, ve al gabinete, toma un vaso,
               sirve el jugo en el vaso"

DECLARATIVO:  "Quiero un vaso de jugo"
```
No describes los pasos. Describes el estado final que deseas.

## ¿Qué resuelve?
El problema fundamental del imperativo: la complejidad accidental.
```
Complejidad esencial:    la dificultad inherente del problema
Complejidad accidental:  la dificultad que introduces tú
                         al describir CÓMO resolverlo
```
En imperativo, la mitad del código no resuelve el problema. Administra el proceso:
```java
// Imperativo: 6 líneas, solo 1 resuelve el problema real
List<String> resultado = new ArrayList<>();      // estructura auxiliar
for (int i = 0; i < usuarios.size(); i++) {     // control del loop
    Usuario u = usuarios.get(i);                // acceso al elemento
    if (u.getEdad() >= 18) {                    // ← esta línea resuelve el problema
        resultado.add(u.getNombre());            // construcción del resultado
    }
}
return resultado;                               // retorno

// Declarativo: 1 línea, toda ella resuelve el problema
return usuarios.stream()
               .filter(u -> u.getEdad() >= 18)
               .map(Usuario::getNombre)
               .toList();
```
El declarativo **elimina la complejidad accidental** y deja solo la esencial.

## La esencia filosófica
```
IMPERATIVO:    el programa ES el proceso
DECLARATIVO:   el programa ES la descripción del resultado

Imperativo:    "para encontrar al usuario, recorre la lista,
                compara cada elemento, retorna cuando coincida"

Declarativo:   "el usuario cuyo id sea igual a X"
```

## Las dos formas del declarativo
El declarativo no es un solo estilo, tiene dos grandes ramas:
```
DECLARATIVO
    │
    ├── FUNCIONAL
    │   → describe transformaciones de datos
    │   → funciones puras, sin estado mutable
    │   → Java Streams, Haskell, Clojure
    │
    └── LÓGICO
        → describe hechos y reglas
        → el motor infiere las respuestas
        → SQL, Prolog, Datalog
```
En la práctica cotidiana trabajarás principalmente con:
* **SQL**       →  declarativo lógico
* **Streams**   →  declarativo funcional en Java
* **HTML/CSS**  →  declarativo de presentación

## Ejemplo de lenguaje declarativo: SQL — el declarativo más puro y usado
**SQL** es el ejemplo más claro de programación declarativa. Describes exactamente qué datos quieres y la base de datos decide cómo obtenerlos.

```sql
-- IMPERATIVO equivalente (pseudocódigo):
-- recorre tabla empleados
-- para cada fila, verifica si departamento es 'Ingeniería'
-- si es así, calcula el salario anual
-- guarda en lista temporal
-- ordena la lista por salario descendente
-- toma solo los primeros 5
-- retorna

-- DECLARATIVO en SQL:
SELECT
    nombre,
    salario * 12 AS salario_anual
FROM empleados
WHERE departamento = 'Ingeniería'
ORDER BY salario_anual DESC
LIMIT 5;
```
No dijiste cómo recorrer la tabla, qué índice usar, cómo ordenar. Solo dijiste qué quieres. El motor de base de datos decide el plan de ejecución más eficiente.

## Java Streams — declarativo funcional
Los Streams de Java son la implementación del paradigma declarativo dentro de un lenguaje imperativo. Permiten describir transformaciones de datos como una pipeline.
```
Fuente          Operaciones intermedias         Operación terminal
   │                      │                           │
   ▼                      ▼                           ▼
lista.stream() .filter().map().sorted()  .collect() / .reduce() / .forEach()
```
Cada operación intermedia devuelve un nuevo Stream (lazy), La operación terminal dispara la ejecución.

### Comparación directa: imperativo vs declarativo
```java
List<Empleado> empleados = obtenerEmpleados();

// ─────────────────────────────────────────
// IMPERATIVO
// ─────────────────────────────────────────
List<String> resultado = new ArrayList<>();

for (Empleado e : empleados) {
    if (e.getDepartamento().equals("Ingeniería")
            && e.getSalario() > 50000) {
        String nombreMayusculas = e.getNombre().toUpperCase();
        resultado.add(nombreMayusculas);
    }
}

Collections.sort(resultado);


// ─────────────────────────────────────────
// DECLARATIVO con Streams
// ─────────────────────────────────────────
List<String> resultado = empleados.stream()
    .filter(e -> e.getDepartamento().equals("Ingeniería"))
    .filter(e -> e.getSalario() > 50000)
    .map(Empleado::getNombre)
    .map(String::toUpperCase)
    .sorted()
    .toList();
```

## Cuándo usar declarativo vs imperativo
```
USA DECLARATIVO cuando:
  ✅ Transformas o consultas colecciones de datos
  ✅ El problema es una pipeline de transformaciones
  ✅ Quieres código más legible y expresivo
  ✅ Necesitas paralelismo fácil
  ✅ Trabajas con bases de datos (siempre SQL)

USA IMPERATIVO cuando:
  ✅ Necesitas control explícito del flujo
  ✅ El algoritmo requiere múltiples variables de estado
  ✅ Hay lógica compleja de iteración (índices, dobles loops)
  ✅ Rendimiento crítico con operaciones muy específicas
  ✅ El problema no es una transformación de datos
```