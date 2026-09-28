# Sistems Numéricos
Un sistema numérico es un conjunto de símbolos y reglas para representar cantidades. No existe una sola forma de representar un número, existen múltiples sistemas, cada uno con un propósito específico.

El número que tú llamas "diez" puede escribirse así:
```
Decimal:      10
Binario:      1010
Octal:        12
Hexadecimal:  A
```
Todos representan la misma cantidad. Solo cambia el sistema.

## ¿Qué resuelven?
El problema de representar información en diferentes contextos:
```
Binario       →  lo que entiende el hardware (voltaje alto/bajo)
Octal         →  agrupación compacta de bits (sistemas Unix)
Decimal       →  lo que entienden los humanos
Hexadecimal   →  representación compacta de memoria y colores
```
Sin sistemas numéricos alternativos, trabajar con memoria, colores, permisos de archivos o protocolos de red sería imposible o extremadamente tedioso.

## ¿Cómo lo resuelven?
Cada sistema usa una base distinta. La base define cuántos símbolos únicos existen y cuánto vale cada posición:
```
Base 2   →  Binario      →  símbolos: 0, 1
Base 8   →  Octal        →  símbolos: 0, 1, 2, 3, 4, 5, 6, 7
Base 10  →  Decimal      →  símbolos: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
Base 16  →  Hexadecimal  →  símbolos: 0-9, A, B, C, D, E, F
```

### Valor Posicional
Este es el concepto núcleo de todo sistema numérico. Cada posición tiene un peso basado en la base elevada a una potencia.

En decimal ya lo usas sin pensarlo:
```
Número:   3 4 5 7
          │ │ │ └── 7 × 10⁰  =  7 × 1     =      7
          │ │ └──── 5 × 10¹  =  5 × 10    =     50
          │ └────── 4 × 10²  =  4 × 100   =    400
          └──────── 3 × 10³  =  3 × 1000  =   3000
                                           ─────────
                                              3457  ✅
```
La misma lógica aplica a cualquier base. Solo cambia el valor de la base.

### Sistema Binario (Base 2)
**¿Por qué existe?** -> Los transistores en un procesador solo tienen dos estados:
```
0V  →  apagado  →  0
5V  →  encendido →  1
```
Todo en una computadora, en el fondo, es binario.

### Símbolos: `0, 1`
Valor posicional:
```
Número binario:  1 0 1 1 0 1
Posiciones:      5 4 3 2 1 0   ← potencias de 2

1 × 2⁵  =  1 × 32  =  32
0 × 2⁴  =  0 × 16  =   0
1 × 2³  =  1 × 8   =   8
1 × 2²  =  1 × 4   =   4
0 × 2¹  =  0 × 2   =   0
1 × 2⁰  =  1 × 1   =   1
                    ─────────
                       45  ✅
```
Potencias de 2 que debes memorizar:
```
2⁰  =   1
2¹  =   2
2²  =   4
2³  =   8
2⁴  =  16
2⁵  =  32
2⁶  =  64
2⁷  = 128
2⁸  = 256
2⁹  = 512
2¹⁰ = 1024   ← 1 kilobyte
```

### Decimal a Binario — método de divisiones sucesivas:
Convierte 45 a binario:
```
45 ÷ 2  =  22  residuo  1  ← bit menos significativo (LSB)
22 ÷ 2  =  11  residuo  0
11 ÷ 2  =   5  residuo  1
 5 ÷ 2  =   2  residuo  1
 2 ÷ 2  =   1  residuo  0
 1 ÷ 2  =   0  residuo  1  ← bit más significativo (MSB)

Lees los residuos de abajo hacia arriba:
45 en binario = 101101  ✅
```

### Sistema Octal (Base 8)
`¿Por qué existe?` -> Agrupar bits de 3 en 3. Históricamente usado en sistemas Unix para permisos de archivos.
```
chmod 755   →  7=111  5=101  5=101  (en binario)
```

Símbolos: 0, 1, 2, 3, 4, 5, 6, 7

Valor posicional:
```
Número octal:  3 7 2

3 × 8²  =  3 × 64  =  192
7 × 8¹  =  7 × 8   =   56
2 × 8⁰  =  2 × 1   =    2
                    ────────
                      250  ✅
```

Decimal a Octal:
Convierte 250 a octal:
```
250 ÷ 8  =  31  residuo  2
 31 ÷ 8  =   3  residuo  7
  3 ÷ 8  =   0  residuo  3

Lees de abajo hacia arriba:
250 en octal = 372  ✅
```

Binario a Octal — agrupas de 3 en 3 desde la derecha:
```
Binario:  1 0 1 1 0 1

Agrupas:  101  101
            5    5   ← no alcanza para 3 bits al inicio, se rellena con 0

Correcto:  010  110  101  (rellenas con ceros a la izquierda)
             2    6    5

101101 en octal = 55

Verificación:
5 × 8¹  =  40
5 × 8⁰  =   5
          ─────
            45  ✅  (mismo número que antes)
```

### Sistema Hexadecimal (Base 16)
**¿Por qué existe?** -> Representar bytes de forma compacta. Un byte tiene 8 bits, que en binario es largo:
```
11111111  →  en binario (8 caracteres)
FF        →  en hexadecimal (2 caracteres)
255       →  en decimal
```
Se usa en colores, direcciones de memoria, hashes, valores ASCII.

Símbolos: 0-9, A, B, C, D, E, F
```
0=0   1=1   2=2   3=3   4=4   5=5
6=6   7=7   8=8   9=9   A=10  B=11
C=12  D=13  E=14  F=15
```

Valor posicional:
```
Número hex:  2 A F

2 × 16²  =  2 × 256  =  512
A × 16¹  =  10 × 16  =  160
F × 16⁰  =  15 × 1   =   15
                      ───────
                        687  ✅
```

Decimal a Hexadecimal:
Convierte 687 a hexadecimal:
```
687 ÷ 16  =  42  residuo  15  →  F
 42 ÷ 16  =   2  residuo  10  →  A
  2 ÷ 16  =   0  residuo   2  →  2

Lees de abajo hacia arriba:
687 en hexadecimal = 2AF  ✅
```

Binario a Hexadecimal — agrupas de 4 en 4 desde la derecha:
```
Binario:   1010 1111 0011

Agrupas:   1010  1111  0011
             A     F     3

= AF3 en hexadecimal

Verificación:
A × 16²  =  10 × 256  =  2560
F × 16¹  =  15 × 16   =   240
3 × 16⁰  =   3 × 1    =     3
                        ──────
                          2803  ✅
```

### Tabla de equivalencias — memoriza esto
```
Decimal │ Binario │ Octal │ Hexadecimal
────────┼─────────┼───────┼────────────
   0    │  0000   │   0   │     0
   1    │  0001   │   1   │     1
   2    │  0010   │   2   │     2
   3    │  0011   │   3   │     3
   4    │  0100   │   4   │     4
   5    │  0101   │   5   │     5
   6    │  0110   │   6   │     6
   7    │  0111   │   7   │     7
   8    │  1000   │  10   │     8
   9    │  1001   │  11   │     9
  10    │  1010   │  12   │     A
  11    │  1011   │  13   │     B
  12    │  1100   │  14   │     C
  13    │  1101   │  15   │     D
  14    │  1110   │  16   │     E
  15    │  1111   │  17   │     F
  16    │ 10000   │  20   │    10
```

### Conversiones directas Binario ↔ Octal ↔ Hex
```
Binario → Octal:        agrupa bits de 3 en 3
Binario → Hex:          agrupa bits de 4 en 4
Octal   → Binario:      expande cada dígito a 3 bits
Hex     → Binario:      expande cada dígito a 4 bits
Octal   → Hex:          Octal→Binario→Hex
Hex     → Octal:        Hex→Binario→Octal
```

Ejemplo Hex → Binario → Octal:
```
Hex:     B 3 F
Binario: 1011 0011 1111

Agrupas de 3 en 3 (rellenas a la izquierda):
001 011 001 111 111

Octal: 1 3 1 7 7  =  13177

Verificación:
B3F en decimal:
11×256 + 3×16 + 15 = 2816 + 48 + 15 = 2879

13177 en octal:
1×8⁴ + 3×8³ + 1×8² + 7×8¹ + 7×8⁰
= 4096 + 1536 + 64 + 56 + 7 = 2879  ✅
```

### Conexión con Java
```java
// Literales en diferentes bases
int decimal     = 255;
int binario     = 0b11111111;   // prefijo 0b
int octal       = 0377;         // prefijo 0
int hexadecimal = 0xFF;         // prefijo 0x

// Todos valen lo mismo: 255
System.out.println(decimal);      // 255
System.out.println(binario);      // 255
System.out.println(octal);        // 255
System.out.println(hexadecimal);  // 255

// Conversiones en Java
int numero = 255;

// Decimal a Binario
String bin = Integer.toBinaryString(numero);   // "11111111"

// Decimal a Octal
String oct = Integer.toOctalString(numero);    // "377"

// Decimal a Hexadecimal
String hex = Integer.toHexString(numero);      // "ff"
String HEX = Integer.toHexString(numero).toUpperCase();  // "FF"

// String binario a decimal
int desdeBin = Integer.parseInt("11111111", 2);  // 255

// String hex a decimal
int desdeHex = Integer.parseInt("FF", 16);       // 255

// Colores en Java (uso real de hex)
Color rojo = Color.decode("#FF0000");

// Operaciones a nivel de bits (bitwise) — binario puro
int a = 0b1010;   // 10
int b = 0b1100;   // 12

int and = a & b;  // 0b1000 = 8
int or  = a | b;  // 0b1110 = 14
int xor = a ^ b;  // 0b0110 = 6
int not = ~a;     // complemento
int shl = a << 1; // desplazamiento izquierda = multiplicar por 2
int shr = a >> 1; // desplazamiento derecha  = dividir por 2
```
### Casos de uso reales
```
Binario        →  operaciones bitwise, flags, máscaras
               →  int flags = 0b00001111;

Octal          →  permisos Unix
               →  chmod 755 archivo.sh

Hexadecimal    →  colores CSS/web
               →  #FF5733
               →  direcciones de memoria
               →  0x7FFE4B3A
               →  valores hash y checksums
               →  UUID: 550e8400-e29b-41d4-a716-446655440000
               →  depuración a bajo nivel
```