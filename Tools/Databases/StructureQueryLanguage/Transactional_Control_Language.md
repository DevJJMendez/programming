# Transactional Control Language
Transactional Control Language (**TCL**) es una parte del lenguaje **SQL** que se utiliza para gestionar las transacciones dentro de una base de datos. Las transacciones son conjuntos de operaciones **SQL** que se ejecutan como una unidad de trabajo única y coherente. **TCL** te permite definir, confirmar o deshacer una transacción según sea necesario, garantizando la integridad de los datos.

## ¿Para qué se utiliza?
**TCL** se utiliza para controlar el comportamiento de las transacciones en la base de datos. Las transacciones aseguran que las operaciones **SQL** se realicen de manera atómica, lo que significa que o bien todas las operaciones dentro de una transacción se completan correctamente, o ninguna de ellas se aplica a la base de datos. **TCL** se utiliza para:

* Confirmar las transacciones exitosas.

* Revertir transacciones en caso de error.

* Asegurar la consistencia de los datos.

## ¿Qué resuelve?
**TCL** resuelve el problema de consistencia e integridad de los datos cuando se realizan múltiples operaciones **SQL** que dependen unas de otras. Imagina un sistema de pagos, en el cual se debita una cantidad de una cuenta bancaria y se acredita en otra. Sin **TCL**, si una de las dos operaciones falla, podrías terminar en un estado inconsistente, por ejemplo, con el dinero deducido de la cuenta A, pero no acreditado en la cuenta B.

## ¿Cómo lo resuelve?
**TCL** gestiona las transacciones con comandos clave que permiten controlar qué operaciones se aplican permanentemente a la base de datos o cuáles se deshacen si ocurre un error. Los principales comandos son:

1. `COMMIT`
   * **Propósito**: Guarda los cambios realizados en una transacción de manera permanente en la base de datos.
   
   * **Resolución**: Cuando ejecutas **COMMIT**, estás confirmando que todos los cambios realizados dentro de la transacción se completaron con éxito y deben aplicarse permanentemente.

   * **Ejemplo**
```sql
START TRANSACTION;
UPDATE cuentas SET saldo = saldo - 100 WHERE cuenta_id = 1;
UPDATE cuentas SET saldo = saldo + 100 WHERE cuenta_id = 2;
COMMIT;
```

2. `ROLLBACK`: Deshace todos los cambios realizados dentro de una transacción en curso, devolviendo la base de datos al estado anterior a la transacción.

   * Si algo sale mal durante una transacción (por ejemplo, una operación falla), puedes ejecutar `ROLLBACK` para deshacer cualquier cambio parcial que se haya realizado hasta ese punto, asegurando que la base de datos no quede en un estado inconsistente.

   * **Ejemplo**
```sql
START TRANSACTION;
UPDATE cuentas SET saldo = saldo - 100 WHERE cuenta_id = 1;
-- Algo sale mal aquí
ROLLBACK;
```

1. `SAVEPOINT`:

   * **Propósito**: Define puntos intermedios dentro de una transacción que permiten realizar un ROLLBACK parcial hasta ese punto, sin deshacer toda la transacción.

   * **Resolución**: SAVEPOINT permite un mayor control sobre una transacción, ya que puedes definir lugares específicos a los que podrías querer retroceder en caso de error sin tener que cancelar toda la transacción.

   * **Ejemplo**
```sql
START TRANSACTION;
SAVEPOINT punto1;
UPDATE cuentas SET saldo = saldo - 100 WHERE cuenta_id = 1;
SAVEPOINT punto2;
UPDATE cuentas SET saldo = saldo + 100 WHERE cuenta_id = 2;
ROLLBACK TO punto1; -- Regresa al estado en "punto1"
COMMIT; -- Confirma los cambios hasta el punto de rollback
```

1. `SET TRANSACTION`:

   * **Propósito**: Configura las características de una transacción, como el nivel de aislamiento (cómo se manejan las lecturas y escrituras concurrentes entre diferentes transacciones).

   * **Resolución**: Ayuda a definir cómo una transacción interactúa con otras operaciones concurrentes, mejorando el control sobre la consistencia y la concurrencia de los datos.

   * **Ejemplo**:
```sql
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
START TRANSACTION;
```

## ¿Cómo lo resuelve TCL?
1. **Atomicidad**: Asegura que todas las operaciones dentro de una transacción se realicen por completo o no se realicen en absoluto, resolviendo el problema de estados intermedios inconsistentes.

2. **Consistencia**: Mantiene la base de datos en un estado consistente antes y después de la transacción, asegurando que todas las reglas de integridad se respeten.

3. **Aislamiento**: Las transacciones pueden ejecutarse de manera aislada unas de otras, lo que significa que los cambios realizados en una transacción no son visibles para otras hasta que se confirme con `COMMIT`.

4. **Durabilidad**: Una vez que una transacción es confirmada con `COMMIT`, los cambios son permanentes, incluso si el sistema falla inmediatamente después.

## Casos de uso
* **Sistemas de pago**: En un sistema de transferencia bancaria, es crucial que tanto el débito de una cuenta como el crédito en otra se realicen correctamente. Si cualquiera de las dos operaciones falla, un `ROLLBACK` aseguraría que no se aplique ningún cambio.

* **Sistemas de inventarios**: Al realizar múltiples actualizaciones en un inventario (por ejemplo, al procesar un pedido), si alguna actualización falla, un `ROLLBACK` puede asegurar que el inventario no quede en un estado incorrecto.

* **Bases de datos distribuidas**: En escenarios donde se ejecutan múltiples transacciones simultáneas, los comandos de **TCL** permiten aislar una transacción de otra, asegurando que los cambios no sean visibles hasta que estén completos.

# ACID
El acrónimo ACID se refiere a un conjunto de propiedades fundamentales que garantizan la fiabilidad y consistencia de las transacciones en una base de datos. Estas propiedades son cruciales para asegurar que las bases de datos manejen las transacciones de manera segura, incluso en condiciones de errores, fallos o concurrencia. Las propiedades ACID son: Atomicidad, Consistencia, Aislamiento (Isolation) y Durabilidad.

1. **Atomicidad (Atomicity)**
   * ¿Qué es? La atomicidad asegura que una transacción es una unidad indivisible de trabajo. Todas las operaciones en una transacción deben completarse con éxito; de lo contrario, ninguna de ellas será aplicada a la base de datos.

   * ¿Para qué se utiliza? Garantiza que las transacciones parciales no afecten el estado de la base de datos. En caso de fallo, todos los cambios realizados durante la transacción se revierten (usando ROLLBACK), asegurando que la base de datos vuelva a su estado original.

   * ¿Qué resuelve? Elimina el riesgo de dejar la base de datos en un estado inconsistente debido a fallos parciales. Por ejemplo, en una transacción bancaria, si se debita dinero de una cuenta pero no se acredita en otra debido a un fallo, la base de datos revertirá el débito.

   * ¿Cómo lo resuelve? Mediante el uso de controles transaccionales como COMMIT y ROLLBACK, la base de datos asegura que todas las operaciones se completen o se deshagan por completo si algo falla.

2. **Consistencia (Consistency)**
   * ¿Qué es? La consistencia garantiza que una transacción lleve a la base de datos de un estado válido a otro estado válido, preservando todas las reglas de integridad y restricciones definidas en la base de datos (como claves primarias, claves foráneas, unicidad, etc.).

   * ¿Para qué se utiliza? Se utiliza para asegurarse de que después de una transacción, la base de datos siga cumpliendo con todas las reglas de integridad definidas. Si una transacción viola estas reglas, será revertida.

   * ¿Qué resuelve? Previene que las transacciones dejen datos corruptos o inválidos en la base de datos, lo cual podría causar problemas graves a nivel de integridad de los datos.

   * ¿Cómo lo resuelve? Cada transacción debe garantizar que las reglas de negocio y restricciones de la base de datos se mantengan antes y después de la ejecución. Si una transacción falla, MySQL ejecutará un ROLLBACK para evitar que datos inválidos queden en la base.

3. **Aislamiento (Isolation)**
   * ¿Qué es? El aislamiento garantiza que las operaciones de una transacción sean invisibles para otras transacciones hasta que la transacción haya sido confirmada. En otras palabras, cada transacción debe ejecutarse como si fuera la única que se está ejecutando en la base de datos en ese momento.

   * ¿Para qué se utiliza? Se utiliza para evitar que las transacciones que se ejecutan simultáneamente afecten el resultado de otras. Esto asegura que las transacciones no interfieran entre sí, evitando problemas como lecturas sucias, lecturas no repetibles y lecturas fantasma.

   * ¿Qué resuelve? Resuelve los problemas derivados de la concurrencia cuando varias transacciones acceden y modifican los mismos datos al mismo tiempo.

   * ¿Cómo lo resuelve? MySQL y otros sistemas de bases de datos implementan diferentes niveles de aislamiento (como **`Read Uncommitted`**, **`Read Committed`**, **`Repeatable Read`**, **`Serializable`**) que controlan la visibilidad de los datos entre transacciones concurrentes.

     * **Lectura sucia**: Una transacción puede leer datos que no han sido confirmados por otra transacción.

     * **Lectura no repetible**: Una transacción puede obtener diferentes valores al leer el mismo dato en diferentes momentos debido a actualizaciones concurrentes.

     * **Lectura fantasma**: Una transacción podría ver nuevas filas insertadas por otra transacción mientras se ejecuta.

4. **Durabilidad (Durability)**
   * ¿Qué es? La durabilidad asegura que una vez que una transacción ha sido confirmada (COMMIT), los cambios realizados son permanentes y sobrevivirán a cualquier fallo del sistema, como cortes de energía o fallos de hardware.

   * ¿Para qué se utiliza? Se utiliza para asegurar que los datos confirmados no se pierdan en caso de un fallo inesperado. Una vez que una transacción es confirmada, los datos deben estar almacenados de manera segura, incluso si el sistema se apaga inmediatamente después.

   * ¿Qué resuelve? Resuelve el problema de la pérdida de datos en caso de fallos del sistema. Garantiza que los datos sean persistentes y recuperables después de un fallo.

   * ¿Cómo lo resuelve? Los sistemas de bases de datos utilizan métodos como la escritura en disco o el uso de logs de transacciones para asegurar que los datos confirmados se puedan recuperar incluso si el sistema falla.

## Ejemplo práctico de ACID
Supongamos que tenemos un sistema de transferencia de dinero entre cuentas bancarias. El proceso incluye las siguientes operaciones:

* Restar una cantidad de dinero de la cuenta del cliente A.

* Añadir esa cantidad de dinero a la cuenta del cliente B.

* Si ambas operaciones se realizan dentro de una transacción:

  * **Atomicidad**: Si una de las dos operaciones falla (por ejemplo, si el sistema falla después de debitar la cuenta A pero antes de acreditar la cuenta B), la transacción se revierte por completo.

  * **Consistencia**: Al final de la transacción, ambas cuentas deben tener saldos válidos. Si no es posible debitar o acreditar, la transacción se anula.

  * **Aislamiento**: Mientras la transacción se ejecuta, otros usuarios no pueden ver la cuenta A con el dinero debitado antes de que se complete la transacción y se refleje el cambio en la cuenta B.

  * **Durabilidad**: Una vez confirmada la transacción, el cambio en ambas cuentas es permanente, incluso si el sistema se apaga inmediatamente después de la confirmación.