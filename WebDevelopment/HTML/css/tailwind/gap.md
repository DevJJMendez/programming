# Gap
gap es la separación interna entre hijos directos de un contenedor Flex o Grid.

* Flexbox: Espacio entre los ítems flexibles (horizontal o vertical).
* Grid: Espacio entre las celdas de una cuadrícula.

**Importante: *gap actúa sólo sobre los hijos directos. No aplica a nietos o descendientes más profundos.***

## ¿Por qué usar gap en vez de margin?
* Simplifica el HTML (no tienes que poner mr- o mb- manualmente en cada hijo).
* Mantiene la separación siempre consistente.
* Mejor manejo responsivo (puedes cambiar el gap por sm:, md:, lg:).
* Evitas problemas de últimos elementos (no tienes que quitar el margen en el último ítem).
* Es semántico: "el padre define cómo se separan los hijos".

## gap en Tailwind
1. Activar gap en Flexbox o Grid
```html
<div class="flex gap-6">
  <div>Elemento 1</div>
  <div>Elemento 2</div>
  <div>Elemento 3</div>
</div>
```
* gap-6 = 1.5rem = 24px de separación entre los hijos.

2. Direcciones de gap específicas

| Clase   | Qué afecta                                              |
| ------- | ------------------------------------------------------- |
| gap-4   | Espaciado en ambas direcciones (horizontal y vertical). |
| gap-x-6 | Solo espaciado horizontal (entre columnas).             |
| gap-y-2 | Solo espaciado vertical (entre filas).                  |


3. Gap en Grid
```html
<div class="grid grid-cols-2 gap-4">
  <div>Elemento 1</div>
  <div>Elemento 2</div>
  <div>Elemento 3</div>
  <div>Elemento 4</div>
</div>
```
* grid-cols-2: dos columnas.
* gap-4: separación de 1rem (16px) entre filas y columnas.

## Combinaciones avanzadas
Puedes combinar gap con padding en el padre para controlar todo el espaciado:
```html
<section class="p-6 grid grid-cols-3 gap-8">
  <div>Card 1</div>
  <div>Card 2</div>
  <div>Card 3</div>
</section>
```
* p-6: espacio interno respecto a los bordes del contenedor.
* gap-8: separación grande entre las cards.

## Gap responsivo
Puedes hacer que el gap cambie según el tamaño de pantalla:
```html
<div class="grid grid-cols-1 md:grid-cols-3 gap-4 md:gap-8">
  <!-- elementos -->
</div>
```
* En mobile (grid-cols-1, gap-4).
* En desktop (grid-cols-3, gap-8).

## Buenas prácticas con gap
* Siempre que puedas, usa gap en lugar de margin entre ítems flexibles o de grid.
* No pongas gap en layouts que no son Flex ni Grid: no tendrá efecto.
* Cuida la proporción visual: no pongas gap-20 en ítems pequeños. Mantén relación lógica entre tamaño y separación.
* Prefiere gap-y- en listas verticales (flex-col) y gap-x- en filas horizontales (flex-row).