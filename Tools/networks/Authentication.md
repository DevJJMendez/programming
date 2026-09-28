# Authentication
La autenticación es el proceso de verificar la identidad de un usuario, dispositivo o sistema. Su objetivo es asegurarse de que la entidad que está intentando acceder a un recurso es quien dice ser. Esto se realiza a través de la verificación de credenciales, que pueden incluir nombres de usuario, contraseñas, tokens o cualquier otra forma de prueba de identidad.

La autenticación es un paso crucial en la seguridad de sistemas, aplicaciones y redes, ya que establece un filtro de acceso, permitiendo que solo las entidades autenticadas (y autorizadas) interactúen con recursos sensibles.

## ¿Por qué es importante la Autenticación?
Acceso Controlado:

Asegura que solo los usuarios o dispositivos correctos tengan acceso a un sistema o servicio, protegiendo información sensible y evitando el acceso no autorizado.

Prevención de Fraude:

Previene que personas no autorizadas (como hackers o usuarios malintencionados) utilicen recursos o datos que no les pertenecen.

Base para Otras Medidas de Seguridad:

La autenticación es el primer paso antes de aplicar otros controles de seguridad, como la autorización, la auditoría o la encriptación.

## Cómo Funciona la Autenticación?
La autenticación implica verificar la identidad de un usuario, y se realiza comúnmente a través de tres factores de autenticación:

Conocimiento (Algo que sabes):

Normalmente, esto es una contraseña o un PIN. El sistema verifica que la entidad que solicita acceso sabe la clave secreta asociada con su identidad.

Posesión (Algo que tienes):

Implica que el usuario posea algo físico, como un token de seguridad, una tarjeta inteligente, o un dispositivo móvil. Los sistemas pueden enviar un código único a un dispositivo, y el usuario debe ingresarlo para confirmar su identidad.

Inherencia (Algo que eres):

Esto se refiere a características biométricas del usuario, como una huella dactilar, reconocimiento facial, o escaneo de iris. Este tipo de autenticación se conoce como biometría.

Un sistema puede utilizar una autenticación de un solo factor (por ejemplo, solo una contraseña) o autenticación multifactor (MFA), que combina dos o más de estos factores para proporcionar una capa adicional de seguridad.

## Tipos Comunes de Autenticación
1. Autenticación Básica (HTTP Basic Authentication)
Es el tipo más simple de autenticación.

El usuario ingresa su nombre de usuario y contraseña, que se envían como texto plano en las cabeceras HTTP.

Ventajas:

Sencillo de implementar.

Funciona en casi todos los sistemas y lenguajes.

Desventajas:

No es seguro si no se usa en conjunto con HTTPS.

La contraseña se envía en cada solicitud, lo que puede ser riesgoso.

2. Autenticación con Token (JWT - JSON Web Token)
En este sistema, después de que el usuario se autentica (normalmente con nombre de usuario y contraseña), el servidor emite un token (usualmente un JWT) que el cliente debe enviar con cada solicitud subsiguiente.

El token tiene un tiempo de vida limitado y generalmente contiene información de identidad codificada (de forma segura).

Ventajas:

No requiere que el usuario envíe credenciales repetidamente.

Es eficiente y escalable, ideal para APIs y aplicaciones distribuidas.

Desventajas:

Si el token se ve comprometido, el atacante podría acceder a los recursos hasta que el token expire.

3. Autenticación Multifactor (MFA)
Combina dos o más factores de autenticación para verificar la identidad de un usuario. Por ejemplo, la combinación de una contraseña (algo que sabes) y un código enviado al teléfono móvil (algo que tienes).

Es una de las mejores formas de aumentar la seguridad.

Ventajas:

Aumenta significativamente la seguridad, protegiendo contra ataques como el robo de contraseñas.

Desventajas:

Puede ser más complejo de implementar y gestionar, especialmente en sistemas grandes.

4. Autenticación Basada en Biometría
Se basa en características físicas del usuario, como huellas dactilares, reconocimiento facial o escaneo de iris, para verificar su identidad.

Ventajas:

Muy difícil de suplantar.

Comodidad para el usuario, ya que no necesita recordar contraseñas.

Desventajas:

Puede ser costoso en términos de hardware (si se usa escaneo de iris o reconocimiento facial).

Las bases de datos biométricas pueden ser un blanco atractivo para ataques.

5. Autenticación en Dos Pasos (2FA)
Utiliza un factor adicional después de la contraseña, como un código enviado a través de SMS o un código generado por una aplicación de autenticación (como Google Authenticator o Authy).

Ventajas:

Aumenta la seguridad sin necesidad de invertir en biometría.

Es bastante fácil de implementar.

Desventajas:

El envío de SMS puede ser vulnerable a ciertos ataques (como el SIM swapping).

## ¿Qué Resuelve la Autenticación?
Verificación de Identidad:

La autenticación resuelve el problema de determinar si una entidad (usuario, dispositivo, sistema) es quien dice ser.

Prevención de Acceso No Autorizado:

Protege los recursos y datos sensibles, permitiendo solo que los usuarios autenticados accedan a ellos.

Establecimiento de Confianza:

La autenticación establece un nivel de confianza entre un usuario y un sistema, asegurando que las acciones del usuario sean atribuibles a su identidad verificada.

## ¿Cómo Implementar la Autenticación en una API?
La implementación de autenticación en una API se puede hacer de diversas maneras. 

Autenticación con JWT (JSON Web Tokens)
Inicio de sesión:

El usuario envía su nombre de usuario y contraseña al servidor.

El servidor verifica las credenciales y, si son correctas, emite un JWT firmado y lo devuelve al usuario.

2. Acceso con JWT:

El usuario incluye el JWT en el encabezado de las solicitudes subsiguientes:
```bash
Authorization: Bearer <token>
```
3. Verificación del Token:

El servidor verifica la firma del token y valida su autenticidad en cada solicitud para asegurarse de que el usuario esté autenticado.

Autenticación Básica (HTTP Basic Authentication)
El usuario envía sus credenciales codificadas en base64:
```bash
Authorization: Basic <username:password in base64>
```
El servidor valida las credenciales enviadas en cada solicitud.

## Ventajas de la Autenticación
Seguridad:

La autenticación ayuda a prevenir el acceso no autorizado a aplicaciones y recursos.

Simplicidad:

Existen múltiples formas de implementación, algunas de las cuales son fáciles de aplicar, como la autenticación básica.

Escalabilidad:

Las soluciones modernas como JWT permiten escalar de manera eficiente, especialmente en arquitecturas distribuidas.

## Desventajas y Consideraciones de la Autenticación
Vulnerabilidades:

Las contraseñas pueden ser robadas o comprometidas si no se gestionan adecuadamente.

Las soluciones de autenticación multifactor (MFA) pueden ser vulnerables a ciertos tipos de ataques (p. ej., SIM swapping).

Complejidad en la Implementación:

Las soluciones más seguras, como MFA y biometría, pueden ser más complejas de implementar.

Experiencia del Usuario:

Requiere que los usuarios recuerden credenciales o usen dispositivos adicionales (en el caso de MFA o tokens), lo cual puede afectar la experiencia del usuario.

# Auth Types
Existen diferentes tipos de autenticación que se utilizan para verificar la identidad de un usuario o entidad en aplicaciones, sistemas o APIs. Estos tipos varían dependiendo del mecanismo utilizado y los requisitos de seguridad de la aplicación.

Autenticación Básica (Basic Authentication)
Descripción:

La autenticación básica es uno de los métodos más simples. Consiste en enviar el nombre de usuario y la contraseña como parte de los encabezados HTTP. La información se codifica en Base64 y se incluye en el encabezado Authorization.

Formato:
```bash
Authorization: Basic <base64(username:password)>
```
Pros:

Fácil de implementar.

Funciona con cualquier cliente HTTP.

Contras:

Inseguro si no se utiliza con HTTPS, ya que las credenciales pueden ser interceptadas.

Requiere enviar las credenciales en cada solicitud, lo que puede ser riesgoso.

Uso Común: Se utiliza en sistemas más simples, como para acceder a servicios internos o en situaciones donde la seguridad no es tan crítica.

2. Autenticación con Tokens (Token-Based Authentication)
Descripción:

La autenticación basada en tokens es un enfoque más moderno y seguro que la autenticación básica. En este tipo, el servidor genera un token (generalmente un JWT - JSON Web Token) después de que el usuario inicie sesión y el usuario lo incluye en los encabezados de las solicitudes subsecuentes.

JWT es muy popular porque es compacto, seguro y puede almacenar información del usuario (como roles y permisos) de forma codificada.

Formato:
```bash
Authorization: Bearer <jwt_token>
```
Pros:

El token se usa solo una vez para la autenticación, y luego se puede reutilizar hasta que expire.

Es más seguro, ya que las credenciales no se envían en cada solicitud.

Es adecuado para aplicaciones distribuidas y sistemas sin estado (stateless).

Contras:

Los tokens pueden ser robados si no se manejan adecuadamente (como en un almacenamiento no seguro).

Los tokens de larga duración pueden ser un riesgo si no se revocan adecuadamente.

Uso Común: Muy utilizado en APIs RESTful y aplicaciones móviles modernas.

3. Autenticación Multifactor (MFA - Multi-Factor Authentication)
Descripción:

La autenticación multifactor (MFA) es un enfoque que requiere múltiples factores para verificar la identidad de un usuario. Generalmente, combina al menos dos de los siguientes factores:

Conocimiento (algo que sabes, como una contraseña).

Posesión (algo que tienes, como un token o dispositivo de autenticación).

Inherencia (algo que eres, como una huella dactilar o un escaneo facial).

Ejemplo:

Primer factor: Contraseña.

Segundo factor: Código enviado por SMS o generado por una aplicación de autenticación (como Google Authenticator).

Pros:

Aumenta considerablemente la seguridad.

Hace que sea más difícil que un atacante obtenga acceso, incluso si conoce la contraseña.

Contras:

Requiere pasos adicionales, lo que puede ser una barrera para algunos usuarios.

Puede resultar más costoso o difícil de implementar dependiendo de los factores utilizados.

Uso Común: Muy utilizado en aplicaciones bancarias, servicios de correo electrónico y otros servicios donde la seguridad es crítica.

4. Autenticación Basada en OAuth 2.0
Descripción:

OAuth 2.0 es un protocolo de autorización que permite a los usuarios autorizar aplicaciones de terceros para acceder a sus recursos en un servidor sin compartir sus credenciales. El sistema otorga a la aplicación de terceros un token de acceso que la aplicación usa para realizar solicitudes en nombre del usuario.

OAuth no es una forma de autenticación en sí misma, sino una forma de autorización, pero comúnmente se usa en conjunto con otras formas de autenticación (por ejemplo, autenticación básica o JWT).

Flujo Básico:

El usuario se autentica en el servidor de autorización.

El servidor de autorización emite un token de acceso que la aplicación usa para interactuar con los recursos protegidos.

Pros:

Permite delegar la autorización sin comprometer las credenciales del usuario.

Soporta acceso limitado y controlado a los recursos (por ejemplo, puede otorgar permisos solo para leer, pero no para modificar).

Contras:

Requiere configuración compleja.

Requiere que el servidor de autorización esté implementado correctamente.

Uso Común: Muy común en plataformas de terceros, como Google, Facebook, Twitter, donde los usuarios pueden iniciar sesión a través de su cuenta de redes sociales.

5. Autenticación mediante SSO (Single Sign-On)
Descripción:

Single Sign-On (SSO) es un sistema que permite a un usuario autenticarse una vez y obtener acceso a varios sistemas o aplicaciones sin tener que iniciar sesión repetidamente. SSO suele utilizarse en sistemas con múltiples aplicaciones o servicios que requieren autenticación.

Flujo Básico:

El usuario se autentica una vez en un servidor de autenticación (por ejemplo, utilizando un servicio como Okta, Auth0, o un proveedor corporativo).

El servidor de autenticación emite un token (como un JWT) que puede ser usado para acceder a las diferentes aplicaciones sin necesidad de reautenticarse.

Pros:

Mejora la experiencia del usuario, ya que solo necesita iniciar sesión una vez.

Reduce la sobrecarga de gestionar múltiples contraseñas.

Contras:

Si el sistema SSO se ve comprometido, un atacante podría tener acceso a todas las aplicaciones conectadas.

Puede ser complejo de implementar correctamente.

Uso Común: Utilizado en grandes organizaciones que tienen múltiples aplicaciones internas y en plataformas que requieren una experiencia de usuario fluida y consistente.

6. Autenticación con API Keys (Claves de API)
Descripción:

Las API Keys son cadenas únicas que los clientes deben incluir en sus solicitudes para acceder a una API. Son especialmente útiles para identificar a un usuario o aplicación que hace uso de una API.

Formato:
```bash
Authorization: APIKey <api_key>
```
Pros:

Sencillo de implementar y útil para identificar aplicaciones o servicios.

Puede combinarse con otras formas de autenticación (como el uso de OAuth).

Contras:

No es tan segura como otras formas de autenticación, ya que la clave puede ser robada si no se gestiona adecuadamente.

Si la clave no se revoca correctamente, un atacante puede seguir accediendo a la API.

Uso Común: Común en servicios de API que necesitan identificar y autenticar aplicaciones de clientes, como servicios de AWS o Google Cloud.

7. Autenticación Basada en Certificados
Descripción:

En este tipo de autenticación, el servidor y el cliente utilizan certificados digitales (generalmente basados en PKI - Infraestructura de Clave Pública) para autenticarse entre sí. El cliente presenta un certificado al servidor para probar su identidad.

Pros:

Muy segura, ya que utiliza criptografía para verificar la identidad.

Ideal para sistemas con alta seguridad o en redes privadas.

Contras:

Requiere una infraestructura de gestión de claves (PKI), lo que puede ser complejo de implementar.

Requiere que los usuarios o sistemas posean certificados válidos.

Uso Común: Utilizado en sistemas donde se requieren altos niveles de seguridad, como en VPNs, banca en línea o comunicaciones internas en una empresa.

# Authorization
La autorización es el proceso de determinar si un usuario o entidad autenticada tiene los permisos adecuados para acceder a un recurso o realizar una acción específica dentro de un sistema. Mientras que la autenticación (authentication) verifica la identidad del usuario, la autorización establece qué puede hacer ese usuario o entidad una vez que ha sido identificado.

En términos simples:

Autenticación (Authentication): ¿Quién eres?

Autorización (Authorization): ¿Qué puedes hacer?

## Proceso de Autorización
La autorización generalmente ocurre después de que el usuario ha pasado por el proceso de autenticación. Una vez que un sistema ha verificado que un usuario es quien dice ser (autenticación), el siguiente paso es determinar qué recursos o acciones puede acceder o realizar ese usuario (autorización).

El proceso de autorización puede implicar la asignación de diferentes roles y permisos a los usuarios. Dependiendo del sistema, la autorización puede basarse en diferentes métodos, como listas de control de acceso (ACLs), roles, atributos o políticas basadas en permisos.

## Métodos Comunes de Autorización
Control de Acceso Basado en Roles (RBAC - Role-Based Access Control)

Descripción:

En RBAC, los usuarios se agrupan en roles y se les asignan permisos basados en esos roles. Los roles se definen según las necesidades del sistema y los permisos asociados a cada uno dictan lo que un usuario con ese rol puede hacer.

Ejemplo:

En una aplicación de gestión de usuarios:

Rol de administrador: puede crear, editar y eliminar usuarios.

Rol de usuario estándar: solo puede ver los perfiles, pero no puede modificarlos.

Ventajas:

Simplifica la gestión de permisos, ya que se asignan a roles y no a usuarios individuales.

Facilita la administración de acceso a gran escala.

Control de Acceso Basado en Atributos (ABAC - Attribute-Based Access Control)

Descripción:

En ABAC, las decisiones de autorización se toman basándose en atributos de los usuarios, recursos, y el entorno. Estos atributos pueden incluir cosas como el nombre de usuario, el rol, la hora del día, la ubicación, etc.

Ejemplo:

Un usuario solo podría acceder a ciertos recursos si tiene el atributo isAdmin: true y está accediendo desde una ubicación segura.

Ventajas:

Flexible y dinámico, ya que no depende solo de los roles.

Puede tomar en cuenta el contexto y las condiciones externas para la autorización.

Control de Acceso Basado en Listas (ACL - Access Control List)

Descripción:

En el control de acceso basado en listas (ACL), se asignan permisos a un conjunto de usuarios o grupos para cada recurso o archivo específico. La ACL puede definir qué acciones (lectura, escritura, eliminación, etc.) pueden realizar los usuarios en un recurso determinado.

Ejemplo:

Un archivo específico tiene una ACL que dice que el usuario A puede leerlo y escribirlo, mientras que el usuario B solo puede leerlo.

Ventajas:

Ofrece un control granular de acceso a recursos específicos.

Permite gestionar permisos para cada recurso de manera detallada.

Control de Acceso Basado en Políticas (PBAC - Policy-Based Access Control)

Descripción:

En PBAC, las decisiones de autorización se basan en políticas predefinidas que determinan quién puede hacer qué bajo ciertas condiciones. Estas políticas se definen generalmente en forma de reglas que combinan roles, atributos de usuarios y condiciones adicionales.

Ejemplo:

Una política podría dictar que los usuarios con el rol "administrador" solo puedan realizar ciertas acciones dentro de un intervalo horario de 9 AM a 5 PM.

Ventajas:

Muy flexible y extensible.

Permite gestionar acceso de forma más compleja y dinámica.

## Componentes de la Autorización
Roles:

Un rol define un conjunto de permisos asociados a un conjunto de usuarios. Por ejemplo, un "administrador" tiene permisos completos sobre todos los recursos, mientras que un "usuario" solo tiene permisos de lectura.

Permisos:

Los permisos son las acciones específicas que un usuario puede realizar sobre un recurso, como leer, escribir, eliminar, etc.

Recursos:

Los recursos son las entidades o datos sobre los que se aplican los permisos. Pueden ser archivos, registros de bases de datos, servicios API, etc.

Políticas de Acceso:

Las políticas definen cómo se toman las decisiones de autorización basadas en condiciones, reglas, o atributos específicos.

## Ejemplo de Autorización en una API REST
Supongamos que tienes una API de gestión de productos y deseas controlar el acceso a las funciones de crear, editar y eliminar productos, dependiendo del rol del usuario.

Autenticación:

El usuario se autentica utilizando JWT (JSON Web Token). Esto asegura que el usuario es quien dice ser.

Autorización:

Una vez que el usuario es autenticado, el servidor comprueba el rol asociado al token JWT y le asigna permisos.

Si el usuario es un "Administrador", se le permite crear, editar y eliminar productos.

Si el usuario es un "Vendedor", solo se le permite ver y editar los productos que haya creado, pero no puede eliminarlos.

Control de Acceso:

Se comprueba el rol del usuario y sus permisos asociados antes de permitir que realice la acción solicitada en la API.

## Importancia de la Autorización
Seguridad:

La autorización garantiza que solo los usuarios adecuados tengan acceso a ciertos recursos. Esto es crucial para proteger datos sensibles o funcionalidades críticas en una aplicación.

Cumplimiento Normativo:

Muchas industrias requieren una gestión de acceso basada en roles o políticas para cumplir con normativas de seguridad (por ejemplo, HIPAA, GDPR, etc.).

Facilidad de Gestión:

Al tener un sistema de autorización bien implementado, la administración de permisos se vuelve más fácil. Se puede añadir, eliminar o modificar roles y permisos sin comprometer la seguridad del sistema.

## Desafíos Comunes en la Autorización
Escalabilidad: A medida que el número de usuarios y recursos crece, gestionar permisos de forma eficiente se vuelve más desafiante. Por lo tanto, es fundamental usar una arquitectura que permita escalar de manera eficiente, como RBAC o ABAC.

Simplicidad vs. Complejidad: En algunos sistemas, la autorización puede volverse compleja si no se define bien la estrategia (por ejemplo, demasiados roles y permisos). Encontrar el balance adecuado es clave para garantizar tanto la seguridad como la facilidad de uso.