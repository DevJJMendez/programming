# Canalizaciones
Las canalizaciones (o pipes en inglés) son una característica poderosa de los sistemas Unix y Linux que permiten encadenar comandos para que la salida de un comando sea la entrada de otro. Esto se logra mediante el uso del carácter `|`, que conecta los comandos en una secuencia, creando un flujo de datos continuo entre ellos.

## ¿Cómo funcionan las canalizaciones?
Cuando utilizas una canalización, la shell ejecuta el primer comando y redirige su salida estándar (**`stdout`**) al siguiente comando como su entrada estándar (**`stdin`**). Este proceso continúa a lo largo de toda la cadena de comandos.

**Sintaxis básica**
```bash
comando1 | comando2 | comando3
```
En este caso:
* La salida de `comando1` se envía como entrada a `comando2`.

* La salida de `comando2` se envía como entrada a `comando3`.

## jemplos de uso de canalizaciones
1. Filtrado de texto con `grep`:
```bash
ls -l | grep ".txt"
```
Este comando lista los archivos en el directorio actual y luego filtra aquellos que tienen la extensión `.txt`.

2. Visualización paginada con `less`:
```bash
cat archivo_grande.txt | less
```
El contenido de `archivo_grande.txt` se muestra de forma paginada usando `less`, lo que permite navegar por el archivo grande de manera más manejable.

3. Ordenación de la salida con sort:
```bash
cat nombres.txt | sort
```
Este comando ordena alfabéticamente los nombres listados en `nombres.txt`.

5. Eliminación de duplicados con `uniq`:
```bash
cat archivo.txt | sort | uniq
```
Primero, `archivo.txt` se ordena con `sort`, y luego `uniq` elimina las líneas duplicadas.

6. Extracción de campos específicos con `cut`:
```bash
cat archivo.csv | cut -d',' -f2
```
Este comando extrae el segundo campo de cada línea en un archivo CSV, donde los campos están delimitados por comas.

## Comandos útiles en canalizaciones
* **`grep`**: Filtra líneas que coinciden con un patrón.

* **`sort`**: Ordena las líneas.

* **`uniq`**: Elimina duplicados.

* **`wc`**: Cuenta palabras, líneas, y caracteres.

* **`cut`**: Corta secciones de cada línea.

* **`awk`**: Procesa y analiza textos basados en patrones.

* **`sed`**: Realiza ediciones en el texto.

* **`tee`**: Lee de stdin y escribe tanto en stdout como en archivos, permitiendo dividir la salida.

## Ventajas de las canalizaciones
* Eficiencia: Permiten procesar datos sin la necesidad de crear archivos intermedios, ahorrando tiempo y recursos.

* Flexibilidad: Puedes combinar comandos simples para realizar tareas complejas.

* Modularidad: Facilitan la creación de scripts que son fáciles de leer y mantener.

## Desventajas y limitaciones
* Manejo de datos binarios: Algunas herramientas están diseñadas para procesar solo texto, lo que limita el uso de canalizaciones con datos binarios.

* Complejidad en scripts largos: Aunque las canalizaciones simplifican tareas complejas, las sec