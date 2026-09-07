# Garbage Collector
El Garbage Collector es el componente de la JVM que: **Detecta objetos que ya no son accesibles y libera su memoria automáticamente.** 

Java no tiene `free()`, no tiene delete -> La JVM se encarga.

## ¿QUÉ PROBLEMA RESUELVE?
Antes del **GC** (C/C++) los problemas eran:

* Memory leaks
* Dangling pointers
* Double free
* Crashes impredecibles

El **GC** elimina una categoría completa de bugs.

**IDEA CLAVE**: No libera memoria por tiempo, la libera por alcanzabilidad.

## ¿CUÁNDO UN OBJETO ES "BASURA"?
Un objeto es basura cuando -> NO es alcanzable desde ningún **GC Root**

## GC Roots (raíces reales)
* Variables locales en el stack
* Variables estáticas
* Threads activos
* JNI references

**Si no puedes llegar a un objeto desde aquí → es candidato a GC.**