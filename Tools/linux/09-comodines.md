# Comodines
Los comodines (o wildcards en inglés) son caracteres especiales que se utilizan en la línea de comandos de Unix/Linux para representar uno o varios caracteres en nombres de archivos o directorios. Son herramientas poderosas que permiten trabajar con múltiples archivos o directorios al mismo tiempo, sin necesidad de especificar cada uno individualmente.

## Tipos de Comodines
1. Asterisco (`*`)
   * Descripción: Representa cualquier número de caracteres, incluidos cero caracteres.

   * Ejemplos:
     * `*.txt`: Coincide con todos los archivos que terminan en `.txt` (`archivo.txt`, `otro.txt`, etc.).

     * `doc*`: Coincide con todos los archivos o directorios que comienzan con "doc" (`documento.txt`, `doc1.docx`, etc.).

2. Corchetes (`[ ]`)
   * Descripción: Coincide con cualquiera de los caracteres especificados entre los corchetes.

   * Ejemplos:
     * `archivo[12].txt`: Coincide con archivo1.txt y archivo2.txt.

     * `doc[abc].txt`: Coincide con doca.txt, docb.txt, y docc.txt.

   * **Rangos en corchetes:**
     * `archivo[1-3].txt`: Coincide con archivo1.txt, archivo2.txt, y archivo3.txt.

     * `letra[a-z]`: Coincide con cualquier archivo cuyo nombre empiece con "letra" seguido de una letra minúscula.

3. Negación en Corchetes (`[!]`)
   * Descripción: Coincide con cualquier carácter que no esté entre los corchetes.

   * Ejemplos:
     * `archivo[!0-9].txt`: Coincide con archivos como archivoA.txt, pero no con archivo1.txt, archivo2.txt, etc.

     * `file[!aeiou]*`: Coincide con archivos que empiezan con "file" y no siguen con una vocal.

4. Llaves (`{ }`)
   * Descripción: Permiten crear listas de cadenas para que coincidan con múltiples patrones.

   * Ejemplos:
     * `archivo{1,2,3}.txt`: Coincide con archivo1.txt, archivo2.txt, y archivo3.txt.

     * `{doc,pdf}*`: Coincide con cualquier archivo que comience con "doc" o "pdf".

## Ejemplos Prácticos
1. Eliminar todos los archivos `.log` en un directorio:
```bash
rm *.log
```
Esto elimina todos los archivos con extensión .log en el directorio actual.

2. Listar todos los archivos que comienzan con "test" y tienen exactamente 5 caracteres:
```bash
ls test??
```
Esto lista archivos como test01, testAB, pero no test123 ni test.

3. Copiar todos los archivos con nombres que empiezan por "report" seguidos de cualquier carácter y terminan en ".txt":
```bash
cp report?.txt /ruta/destino/
```
Esto copia archivos como report1.txt y reportA.txt a otro directorio.

4. Mover archivos que comienzan con cualquier carácter entre "a" y "f" seguido de "ile" y tienen la extensión ".txt":
```bash
mv [a-f]ile.txt /ruta/destino/
```
Esto mueve archivos como afile.txt y cile.txt

5. Renombrar múltiples archivos usando corchetes:
```bash
mv archivo{1,2}.txt nuevo_archivo{1,2}.txt
```
Esto renombra archivo1.txt a nuevo_archivo1.txt y archivo2.txt a nuevo_archivo2.txt.

## Uso Avanzado con find y grep
Los comodines son útiles no solo en comandos básicos como ls, cp, y mv, sino también en comandos más avanzados como find y grep:

1. Buscar archivos con find:
```bash
find . -name "*.sh"
```
Esto encuentra todos los archivos con la extensión .sh en el directorio actual y sus subdirectorios.

2. Buscar patrones en archivos con grep:
```bash
grep "error" *.log
```
Esto busca la palabra "error" en todos los archivos .log del directorio actual.

### Consideraciones
* Escape de Comodines: Si deseas usar un carácter comodín literalmente, debes escaparlo con una barra invertida (\) o entrecomillarlo.
  
  * Ejemplo: ls \*.txt o ls "*.txt" buscará un archivo llamado literalmente *.txt, en lugar de usar el comodín *.

* Combinación de Comodines: Puedes combinar comodines para realizar búsquedas más complejas.
  
  * Ejemplo: ls [a-z]*.{txt,log} listará todos los archivos que comienzan con una letra minúscula y tienen la extensión .txt o .log.