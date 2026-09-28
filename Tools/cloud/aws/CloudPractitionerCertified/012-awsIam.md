## AWS IAM
AWS IAM (Identity and Access Management) es un servicio de Amazon Web Services que permite gestionar el acceso a los recursos de AWS de manera segura. IAM te ayuda a controlar quién puede hacer qué en tu entorno de AWS, asegurando que solo los usuarios y servicios autorizados tengan acceso a los recursos necesarios y solo a esos recursos.

## Características Clave de AWS IAM
1. **Control de Acceso Granular**

   * **Usuarios y Roles**: IAM permite crear y gestionar usuarios y roles dentro de tu cuenta de AWS. Los usuarios **representan personas o aplicaciones que necesitan acceso a los recursos**, mientras que los roles pueden ser asumidos por usuarios o servicios para **obtener permisos específicos**.

2. **Políticas de Permisos**

   * **Políticas Basadas en JSON**: Puedes definir políticas en formato JSON que especifican permisos detallados sobre qué acciones pueden realizarse en qué recursos. Las políticas se adjuntan a usuarios, grupos o roles.

   * **Políticas Administradas**: AWS proporciona políticas administradas predefinidas que puedes utilizar, como `AmazonS3ReadOnlyAccess` o `AdministratorAccess`.

3. **Autenticación Multifactor (MFA)**

   * **Seguridad Adicional**: IAM soporta autenticación multifactor (MFA), añadiendo una capa extra de seguridad mediante un segundo factor de autenticación además de la contraseña.

4. **Control de Acceso Basado en Roles (RBAC)**

   * **Roles de IAM**: Permiten a los usuarios o servicios asumir roles con permisos específicos en lugar de asignar permisos directamente a usuarios individuales. Esto es útil para tareas temporales o para servicios de AWS que necesitan permisos para interactuar con otros servicios.

5. **Gestión de Claves de Acceso**

   * **Acceso Programático**: Para acceder a los servicios de AWS mediante la CLI o SDK, puedes crear claves de acceso que consisten en un ID de clave de acceso y una clave secreta.

6. **Permisos Basados en Recursos**

   * **Control Detallado**: Puedes usar políticas basadas en recursos para definir quién puede acceder a los recursos específicos, como buckets de S3 o tablas de DynamoDB.

7. **Auditoría y Monitoreo**

   * **`AWS CloudTrail`**: IAM trabaja en conjunto con AWS CloudTrail para registrar y monitorear las actividades de los usuarios y servicios, lo que facilita la auditoría de seguridad.

## Componentes Principales de AWS IAM

### **Usuarios**
Los usuarios de IAM representan a individuos o aplicaciones que necesitan acceso a los recursos de AWS. Cada usuario tiene credenciales únicas que les permiten autenticarse y acceder a los recursos de acuerdo con los permisos que se les han concedido.

**Ejemplo de uso**: Crear un nuevo usuario

```bash
aws iam create-user --user-name NuevoUsuario
```

## **Roles**
Los roles son entidades de IAM que permiten definir un conjunto de permisos que pueden ser asumidos por usuarios, servicios o aplicaciones. Los roles son útiles para permitir a los servicios de AWS interactuar entre sí y para proporcionar permisos temporales a entidades externas.

**Ejemplo de Comando**: Crear un nuevo rol

```bash
aws iam create-role --role-name MiRol --assume-role-policy-document file://policy.json
```
**Política de Confianza (Trust Policy)**: Define quién puede asumir el rol (por ejemplo, una instancia EC2 o un usuario).

## **Grupos**
Los grupos son colecciones de usuarios que se pueden usar para aplicar políticas de permisos a varios usuarios a la vez. En lugar de asignar permisos a cada usuario individualmente, puedes asignar permisos a un grupo y agregar usuarios a ese grupo.

**Ejemplo de Comando**: Crear un nuevo grupo

```bash
aws iam create-group --group-name MiGrupo
```
  
## **Políticas**
Las políticas en IAM son documentos en formato JSON que definen los permisos que se conceden a usuarios, roles o grupos. Una política especifica qué acciones están permitidas en qué recursos y bajo qué condiciones.

**Ejemplo de Comando**: Crear una nueva política

```bash
aws iam create-policy --policy-name MiPolitica --policy-document file://politica.json
```
**Políticas Administradas**: AWS proporciona políticas predefinidas que puedes usar directamente, como `AmazonS3ReadOnlyAccess` o `AdministratorAccess`.

### Estructura Básica de una IAM Policy
Una política de IAM se compone de varios elementos clave:

1. **`Version`**: Define la versión del lenguaje de políticas de IAM. Generalmente, se utiliza 2012-10-17 para la versión más reciente y recomendada.

2. **`Statement`**: Contiene una o más declaraciones que describen los permisos específicos. Cada declaración puede incluir:

   * **`Effect`**: El efecto de la política, que puede ser Allow (permitir) o Deny (denegar).

   * **`Action`**: Las acciones permitidas o denegadas (por ejemplo, `s3:ListBucket`, `ec2:StartInstances`).

   * **`Resource`**: Los recursos a los que se aplican las acciones (por ejemplo, un bucket específico de S3 o una instancia EC2).

   * **`Condition`** (opcional): Condiciones bajo las cuales la política se aplica (por ejemplo, restricciones basadas en IP, hora del día, etc.).

#### Ejemplo de un IAM Policy

Ejemplo de una política de IAM que permite a un usuario leer objetos en un bucket de S3 específico:
```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "s3:GetObject",
        "s3:ListBucket"
      ],
      "Resource": [
        "arn:aws:s3:::mi-bucket",
        "arn:aws:s3:::mi-bucket/*"
      ]
    }
  ]
}
```

### Tipos de Políticas
1. **Políticas Administradas por AWS**:

   * Proporcionadas y mantenidas por AWS. Puedes usar estas políticas directamente sin necesidad de editarlas.

2. **Políticas Administradas por el Usuario**:

   * Creadas y mantenidas por el usuario. Puedes definir permisos personalizados basados en tus necesidades específicas.

3. **Políticas Basadas en Recursos**:

   * Asociadas directamente con los recursos y definen quién puede acceder al recurso y bajo qué condiciones.


### Cómo Adjuntar una Política
Puedes adjuntar políticas a usuarios, grupos o roles mediante la consola de administración de AWS, la CLI o la API. 

```bash
aws iam attach-user-policy --user-name NombreDelUsuario --policy-arn arn:aws:iam::123456789012:policy/NombreDeLaPolitica
```
## Actions
En AWS, las acciones (actions) son operaciones específicas que se pueden realizar en los recursos de un servicio. Cada servicio de AWS define un conjunto de acciones que puedes permitir o denegar mediante políticas de IAM. Estas acciones están documentadas y se utilizan para controlar el acceso a los recursos.

### Tipos de Acciones
Las acciones en las políticas de IAM pueden incluir operaciones como:

* Leer datos (por ejemplo, obtener información de un bucket S3).

* Escribir datos (por ejemplo, cargar un archivo en un bucket S3).

* Administrar recursos (por ejemplo, crear o eliminar una instancia EC2).

* Configurar servicios (por ejemplo, modificar configuraciones de una base de datos RDS).

### Cómo Encontrar Acciones Disponibles
Para cada servicio, AWS proporciona una lista completa de acciones disponibles en su documentación. Aquí tienes cómo encontrar y utilizar estas acciones:

1. **Documentación de AWS**:

   * AWS proporciona una documentación exhaustiva para cada servicio que incluye las acciones disponibles.

2. **AWS CLI y SDK**:

   * Puedes usar comandos de AWS CLI para obtener detalles sobre las acciones disponibles. Por ejemplo:

      ```bash
      aws iam list-policies --query "Policies[*].{Name:PolicyName, ARN:Arn}"
      ```

3. **Políticas Administradas por AWS**:

   * AWS proporciona políticas predefinidas que incluyen acciones comunes para diferentes servicios. Puedes ver las acciones incluidas en estas políticas desde la consola de IAM.

### Ejemplos de Acciones
1. **Amazon S3**:
   
   * `s3:ListBucket`: Permite listar los objetos en un bucket.
   
   * `s3:GetObject`: Permite leer un objeto en un bucket.
   
   * `s3:PutObject`: Permite cargar un objeto en un bucket.
   
   * `s3:DeleteObject`: Permite eliminar un objeto de un bucket.

2. **Amazon EC2**:


   * `ec2:StartInstances`: Permite iniciar una instancia EC2.

   * `ec2:StopInstances`: Permite detener una instancia EC2.

   * `ec2:TerminateInstances`: Permite terminar una instancia EC2.

   * `ec2:DescribeInstances`: Permite obtener información sobre las instancias EC2.

3. **Amazon RDS**:

   * `rds:CreateDBInstance`: Permite crear una instancia de base de datos RDS.

   * `rds:ModifyDBInstance`: Permite modificar una instancia de base de datos RDS.

   * `rds:DeleteDBInstance`: Permite eliminar una instancia de base de datos RDS.

   * `rds:DescribeDBInstances`: Permite obtener información sobre las instancias de base de datos RDS.

4. **AWS IAM**:

   * `iam:CreateUser`: Permite crear un nuevo usuario IAM.

   * `iam:DeleteUser`: Permite eliminar un usuario IAM.

   * `iam:AttachUserPolicy`: Permite adjuntar una política a un usuario IAM.

   * `iam:ListUsers`: Permite listar los usuarios IAM en una cuenta


## Conditions
Las Conditions en las políticas de AWS (IAM Policies) son una poderosa característica que permite aplicar restricciones adicionales y especificar condiciones bajo las cuales se conceden o deniegan permisos. Las condiciones permiten una granularidad y flexibilidad mayores en el control del acceso a los recursos de AWS, más allá de lo que se puede definir solo con las acciones y recursos.

### Estructura de las Conditions
Las condiciones se definen dentro de una declaración (Statement) en una política de IAM y utilizan una serie de operadores y claves específicas para definir los criterios bajo los cuales se aplican los permisos. La estructura general de una condición en una política es la siguiente:

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": "s3:GetObject",
      "Resource": "arn:aws:s3:::mi-bucket/*",
      "Condition": {
        "IpAddress": {
          "aws:SourceIp": "192.168.1.1"
        }
      }
    }
  ]
}
```
#### Componentes de una Condición
1. **Condition Operator**: Define el tipo de comparación que se realiza. Los operadores comunes incluyen:
   * `StringEquals`, `StringLike`, `StringNotEquals`, `StringNotLike`

   * `NumericEquals`, `NumericLessThan`, `NumericGreaterThan`

   * `DateEquals`, DateBefore,`` `DateAfter`

   * `IpAddress`, `NotIpAddress`

   * Bool, Null
  
2. **Condition Key**: La clave que se utiliza para especificar el criterio de la condición. AWS tiene un conjunto de claves predeterminadas (por ejemplo, `aws:SourceIp`, `aws:RequestTag`, `aws:PrincipalTag`) y cada servicio puede tener claves adicionales específicas.

3. **Condition Value**: Los valores que se comparan contra el Condition Key para cumplir la condición.

#### Ejemplos de Uso de Conditions
1. **Restricción por IP**: Permitir el acceso a un bucket de S3 solo desde una dirección IP específica:

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Condition": {
        "IpAddress": {
          "aws:SourceIp": "192.168.1.1"
        }
      }
    }
  ]
}
```
2. **Restricción por Hora del Día**: Permitir el acceso a un recurso solo durante un horario específico:

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Condition": {
        "DateGreaterThan": {
          "aws:CurrentTime": "2024-08-14T09:00:00Z"
        },
        "DateLessThan": {
          "aws:CurrentTime": "2024-08-14T17:00:00Z"
        }
      }
    }
  ]
}
```
3. **Restricción por Etiquetas de Recursos**: Permitir acciones solo si los recursos tienen una etiqueta específica:

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Condition": {
        "StringEquals": {
          "aws:RequestTag/Project": "MyProject"
        }
      }
    }
  ]
}
```
4. **Condición para Acceso Basado en Etiquetas de Usuario**: Permitir acceso a recursos basados en etiquetas de usuario:

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Condition": {
        "StringEquals": {
          "aws:RequestTag/Department": "Finance"
        }
      }
    }
  ]
}
```
## **Claves de Acceso**
Las AWS Access Keys son credenciales que permiten la autenticación programática para acceder a los servicios de AWS a través de la CLI (Command Line Interface) o SDKs (Software Development Kits). Consisten en un ID de clave de acceso y una clave secreta.

* **Componentes**
  
  * **ID de Clave de Acceso (Access Key ID)**: Un identificador único para la clave de acceso.
  
  * **Clave Secreta (Secret Access Key)**: Una clave secreta utilizada junto con el ID de clave de acceso para firmar solicitudes a los servicios de AWS.

**Ejemplo**: Crear una nueva clave de acceso

```bash
aws iam create-access-key --user-name MiUsuario
```

**Configuración de AWS CLI**
```bash
aws configure
```
Durante la configuración, se te pedirá ingresar el ID de clave de acceso y la clave secreta.

## **Multi-Factor Authentication**
La Autenticación Multifactor (MFA) es un mecanismo de seguridad que añade una capa adicional de protección más allá de las credenciales básicas de usuario, como contraseñas o claves de acceso. MFA requiere que los usuarios proporcionen dos o más factores de autenticación para acceder a sus cuentas o servicios. Estos factores generalmente se dividen en tres categorías:

1. **Algo que sabes**: Esto puede ser una contraseña, un PIN o una respuesta a una pregunta de seguridad.

2. **Algo que tienes**: Un dispositivo físico como un teléfono móvil, una tarjeta inteligente o un token generador de códigos.

3. **Algo que eres**: Factores biométricos como huellas dactilares, reconocimiento facial o iris.

### ¿Cómo Funciona MFA en AWS?
AWS ofrece soporte para MFA a través de varias opciones para proteger tus cuentas y recursos:

1. **Autenticación con Aplicaciones Móviles**: Utiliza aplicaciones de autenticación, como Google Authenticator, Authy o Microsoft Authenticator, que generan códigos de un solo uso (OTP) basados en el tiempo.

2. **Tokens de Hardware**: Dispositivos físicos que generan códigos de un solo uso (OTP). Estos tokens son pequeños dispositivos que se sincronizan con el servicio de autenticación de AWS.

3. **Autenticación por SMS**: Envía códigos de un solo uso a través de mensajes de texto a tu número de teléfono móvil.

**Ejemplo de Comando**: Activar MFA para un usuario
```bash
aws iam enable-mfa-device --user-name MiUsuario --serial-number arn:aws:iam::123456789012:mfa/MiMFA --authentication-code1 123456 --authentication-code2 654321
```

## Amazon Resource Names
Los Amazon Resource Names (ARNs) son identificadores únicos utilizados en AWS para referirse a recursos específicos. Los ARNs permiten especificar de manera precisa y unívoca un recurso dentro del ecosistema de AWS, lo que es esencial para la gestión de permisos, políticas y operaciones.

### Estructura de un ARN
Un ARN tiene la siguiente estructura básica:

```bash
arn:partition:service:region:account-id:resource
```
1. `arn`: El prefijo constante que indica que se trata de un ARN.

2. `partition`: La partición de AWS en la que se encuentra el recurso. Los valores comunes son:

   * `aws` para AWS estándar.

   * `aws-cn` para la región de **AWS China**.

   * `aws-us-gov` para la región de **AWS GovCloud (EE.UU.)**.

3. `service`: El servicio de AWS que proporciona el recurso. Por ejemplo, `s3` para Amazon S3, `ec2` para Amazon EC2, `iam` para AWS IAM, etc.

4. `region`: La región de AWS en la que se encuentra el recurso. Para algunos servicios, esto puede ser un valor vacío si el recurso no está asociado con una región específica (por ejemplo, IAM).

5. `account-id`: El ID de cuenta de AWS que posee el recurso. Este campo puede ser vacío para recursos globales (como IAM).

6. `resource`: El identificador del recurso específico. La estructura del identificador varía según el servicio. Puede incluir nombres de recursos, IDs o rutas.

#### Ejemplos de ARNs
1. Amazon S3 Bucket:

   * **ARN**: `arn:aws:s3:::mi-bucket`

   * **Service**: `s3`

   * **Resource**: `mi-bucket` (nombre del bucket)

2. Amazon S3 Object:

   * **ARN**: `arn:aws:s3:::mi-bucket/mi-objeto.txt`

   * **Service**: `s3`

   * **Resource**: `mi-bucket/mi-objeto.txt` (nombre del bucket y la clave del objeto)

3. Amazon EC2 Instance:

   * **ARN**: `arn:aws:ec2:us-west-2:123456789012:instance/i-0abcd1234efgh5678`

   * **Service**: `ec2`

   * **Region**: `us-west-2`

   * **Account-id**: `123456789012`

   * **Resource**: `instance/i-0abcd1234efgh5678` (ID de la instancia)

4. IAM User:

   * **ARN**: `arn:aws:iam::123456789012:user/NuevoUsuario`

   * **Service**: `iam`

   * **Account**-id: `123456789012`

   * **Resource**: `user/NuevoUsuario` (nombre del usuario)

#### Identificación de ARNs
Para identificar ARNs en AWS, considera los siguientes métodos:

1. **Consola de AWS**:

   * Al trabajar con recursos a través de la consola de AWS, muchas veces verás el ARN del recurso en la interfaz de usuario. Por ejemplo, al ver las propiedades de un bucket de S3 o una instancia de EC2.

2. **AWS CLI**:

   * Puedes obtener el ARN de un recurso usando comandos de la CLI que proporcionan detalles sobre el recurso.

      ```bash
      aws s3api list-buckets --query "Buckets[*].{Name:Name,ARN:Arn}"

      aws ec2 describe-instances --query "Reservations[*].Instances[*].[InstanceId,InstanceArn]"
      ```
    
3. **Documentación de AWS**:

   * La documentación de AWS para cada servicio especifica cómo se construyen los ARNs para ese servicio en particular. Por ejemplo, la documentación de Amazon S3 detalla cómo se construyen los ARNs para buckets y objetos.

4. **SDKs y APIs**:

   * Cuando interactúas con recursos a través de SDKs o APIs, a menudo se te proporcionará el ARN del recurso como parte de la respuesta.

## IAM Identity Center
IAM Identity Center (anteriormente conocido como AWS SSO - Single Sign-On) es un servicio de AWS que facilita la administración de identidades y el acceso a múltiples aplicaciones y recursos dentro de la infraestructura de AWS y otras aplicaciones en la nube. IAM Identity Center proporciona una solución centralizada para gestionar el acceso y la autenticación en entornos de AWS y aplicaciones externas.

### Características Clave de IAM Identity Center
1. **Inicio de Sesión Único (SSO)**:

   * Permite a los usuarios iniciar sesión una vez y obtener acceso a múltiples aplicaciones y recursos sin necesidad de volver a autenticarse. Esto simplifica la experiencia del usuario y mejora la seguridad al reducir la necesidad de múltiples credenciales.

2. **Gestión de Acceso Centralizada**:

   * Proporciona una interfaz centralizada para gestionar usuarios y permisos. Puedes definir y aplicar políticas de acceso a nivel de organización, grupos o usuarios individuales desde un único lugar.

3. **Integración con AWS y Aplicaciones de Terceros**:

   * IAM Identity Center se integra fácilmente con otros servicios de AWS, como AWS Management Console, AWS CLI, y AWS SDKs. También soporta la integración con aplicaciones externas y servicios SaaS utilizando estándares de autenticación como SAML 2.0 y OpenID Connect (OIDC).

4. **Gestión de Identidades**:

   * Permite importar usuarios desde sistemas de identidad existentes (como Active Directory) o crear y gestionar identidades directamente en IAM Identity Center. También soporta la sincronización de identidades con directorios externos.

5. **Políticas de Acceso Basadas en Roles**:

   * Puedes asignar a los usuarios roles específicos con permisos definidos para acceder a recursos de AWS o aplicaciones. Las políticas se pueden aplicar a nivel de rol, grupo o usuario.

6. **Auditoría y Reportes**:

   * Proporciona capacidades de auditoría y reportes para rastrear el acceso y las actividades de los usuarios, lo que es útil para cumplir con las normativas y mantener la seguridad.

### Cómo Funciona IAM Identity Center
1. **Configuración de Aplicaciones y Recursos**:

   * Configuras las aplicaciones y recursos que deseas que los usuarios accedan a través de IAM Identity Center. Esto puede incluir aplicaciones en la nube, servicios de AWS, y otros recursos protegidos.

2. **Asignación de Roles y Permisos**:

   * Creas roles y asignas permisos a estos roles, luego asignas estos roles a los usuarios o grupos de usuarios. Los roles determinan qué recursos y acciones están disponibles para los usuarios.

3. **Inicio de Sesión y Acceso**:

   * Los usuarios inician sesión en IAM Identity Center usando sus credenciales. Una vez autenticados, pueden acceder a todas las aplicaciones y recursos a los que tienen permiso sin necesidad de volver a iniciar sesión.

4. **Integración con Directorios Externos**:

   * Si estás utilizando un directorio externo como Active Directory, IAM Identity Center puede sincronizarse con este directorio para importar y gestionar identidades de usuarios.

## Grant Least Privilege Access
Granting Least Privilege Access es un principio fundamental en la administración de la seguridad de la información y el acceso a recursos. Se refiere a la práctica de otorgar a los usuarios, roles y servicios solo los permisos mínimos necesarios para realizar sus tareas específicas. Este enfoque ayuda a reducir el riesgo de acceso no autorizado y la exposición a vulnerabilidades.

Se basa en la idea de que cada entidad (usuario, grupo, rol, aplicación) debe tener solo los permisos que necesita para realizar su trabajo, y nada más. Este principio es crucial para minimizar el impacto de errores humanos, mal uso o ataques maliciosos.

### Cómo Implementar el Principio de Menor Privilegio en AWS
1. **Definir Requisitos de Permisos**:

   * Antes de asignar permisos, identifica y define claramente qué acciones son necesarias para cada usuario o rol. Analiza las tareas y recursos a los que se necesita acceso y determina los permisos específicos requeridos.

2. **Utilizar Políticas de IAM Detalladas**:

   * Crea políticas de IAM específicas que otorguen solo los permisos necesarios. Evita el uso de políticas amplias como AdministratorAccess si no es necesario. En su lugar, usa políticas más granulares que limitan el acceso a solo las acciones y recursos específicos requeridos.
  
   Ejemplo de política con permisos mínimos para un usuario de Amazon S3 que solo necesita leer objetos en un bucket específico:

    ```json
    {
      "Version": "2012-10-17",
      "Statement": [
        {
          "Effect": "Allow",
          "Action": "s3:GetObject",
          "Resource": "arn:aws:s3:::mi-bucket/*"
        }
      ]
    }
    ```

3. **Asignar Roles Específicos**:

   * Utiliza roles con permisos limitados y asigna estos roles a usuarios o servicios en lugar de proporcionar permisos directamente. Esto facilita la gestión y el control del acceso.
4. **Revisar y Auditar Permisos Regularmente**:

   * Realiza auditorías periódicas de las políticas y permisos asignados para asegurarte de que aún se ajustan a las necesidades actuales. Revoca permisos innecesarios o no utilizados para minimizar riesgos.

5. **Aplicar Permisos Condicionales**:

   * Utiliza condiciones en las políticas de IAM para limitar el acceso basado en factores como la IP de origen, el tiempo del día o el estado de la solicitud. Esto añade una capa adicional de control sobre cuándo y cómo se pueden usar los permisos.

6. **Utilizar Políticas de Gestión Basada en Etiquetas**:

   * Aprovecha las políticas basadas en etiquetas para aplicar permisos a recursos etiquetados de manera coherente, facilitando la gestión de acceso a gran escala.

7. **Implementar la Separación de Funciones (SoD)**:

   * Divide las responsabilidades entre diferentes usuarios o roles para evitar que una sola entidad tenga control total sobre una operación crítica. Esto ayuda a prevenir fraudes y errores.

## Cross-Account Role
El concepto de Cross-Account Role (Rol entre cuentas) en AWS permite a una entidad en una cuenta de AWS (como un usuario, un servicio o una aplicación) acceder a recursos en otra cuenta de AWS mediante el uso de roles de IAM (Identity and Access Management). Esto es especialmente útil cuando tienes varios entornos o cuentas dentro de una organización, o cuando trabajas con terceros que necesitan acceso limitado a tus recursos.

Un Cross-Account Role es un rol de IAM que se define en una cuenta de AWS (la cuenta de destino) pero es asumido por usuarios, aplicaciones o servicios en otra cuenta (la cuenta de origen). Este tipo de rol permite delegar acceso a los recursos en la cuenta de destino sin compartir credenciales, manteniendo la seguridad y la gobernanza centralizada.

### Beneficios del Cross-Account Role
1. **Seguridad Mejorada**:

   * Permite controlar el acceso entre cuentas de forma segura sin necesidad de compartir credenciales o crear usuarios redundantes.

2. **Acceso Temporal**:

   * Los roles en AWS son asumidos de manera temporal, lo que significa que se pueden conceder permisos durante una duración limitada, reduciendo el riesgo de abuso o acceso no autorizado.

3. **Facilita la Gestión Multi-Cuenta**:

   * Si manejas varias cuentas de AWS dentro de una organización, puedes centralizar la gestión de permisos y recursos sin duplicar usuarios o crear configuraciones redundantes.

4. **Interacción Segura con Terceros**:

   * Si necesitas conceder acceso a un socio o cliente a recursos específicos en tu cuenta, puedes crear un rol en tu cuenta que ellos puedan asumir sin necesidad de compartir tus credenciales de usuario.

### Cómo Funciona el Cross-Account Role
1. **Cuenta de Origen (Source Account)**:

   * Es la cuenta en la que se encuentra el usuario, servicio o entidad que necesita acceder a otra cuenta. En esta cuenta, el usuario o entidad debe tener permisos para asumir un rol en la cuenta de destino.

2. **Cuenta de Destino (Target Account)**:

   * Es la cuenta que contiene los recursos a los que se quiere acceder. En esta cuenta, se define un rol de IAM que permite ser asumido por una entidad de la cuenta de origen.

3. **Política de Confianza (Trust Policy)**:

   * El rol en la cuenta de destino tiene una política de confianza que especifica qué entidad (usuario, rol o cuenta) está autorizada para asumir el rol. Esta política se configura para confiar en la cuenta de origen.

4. **Asunción de Rol (AssumeRole)**:

   * La entidad en la cuenta de origen utiliza la acción sts:AssumeRole (del servicio AWS Security Token Service, STS) para asumir el rol definido en la cuenta de destino. Una vez que el rol es asumido, la entidad temporalmente obtiene permisos para interactuar con los recursos en la cuenta de destino según los permisos otorgados por el rol.

### Ejemplo de Cross-Account Role
1. **Definir un Rol en la Cuenta de Destino**
   
   * En la cuenta de destino, se define un rol con una política de confianza que permite que un usuario o entidad de la cuenta de origen asuma el rol:

    ```json
    {
      "Version": "2012-10-17",
      "Statement": [
        {
          "Effect": "Allow",
          "Principal": {
            "AWS": "arn:aws:iam::123456789012:root"  // Cuenta de origen
          },
          "Action": "sts:AssumeRole",
          "Condition": {}
        }
      ]
    }
    ```
    En este caso, la cuenta con el ID 123456789012 es la cuenta de origen que puede asumir este rol.

2. **Asignar Permisos al Rol en la Cuenta de Destino**

   * Se asignan permisos al rol para que, una vez asumido, la entidad tenga acceso a los recursos deseados. Por ejemplo, si el rol tiene acceso a un bucket de S3 en la cuenta de destino:

    ```json
    {
      "Version": "2012-10-17",
      "Statement": [
        {
          "Effect": "Allow",
          "Action": "s3:ListBucket",
          "Resource": "arn:aws:s3:::mi-bucket-en-la-cuenta-de-destino"
        }
      ]
    }
    ```

3. **Asumir el Rol en la Cuenta de Origen**
   
   * En la cuenta de origen, la entidad (usuario, servicio o aplicación) debe tener permisos para asumir el rol de la cuenta de destino:

    ```json
    {
      "Version": "2012-10-17",
      "Statement": [
        {
          "Effect": "Allow",
          "Action": "sts:AssumeRole",
          "Resource": "arn:aws:iam::098765432109:role/mi-cross-account-role"
        }
      ]
    }
    ```
    El usuario o servicio en la cuenta de origen puede entonces utilizar AWS STS para asumir el rol y obtener credenciales temporales que le permitan interactuar con los recursos en la cuenta de destino.