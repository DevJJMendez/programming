# .NET Framework (2002)
* **Qué es**:
  * Fue la primera implementación de .NET lanzada por Microsoft. Diseñada exclusivamente para Windows.
  * Introdujo el CLR (Common Language Runtime) y la FCL (Framework Class Library).

* **Ventajas**:
  * Ideal para desarrollar aplicaciones de escritorio (WinForms, WPF), aplicaciones web (ASP.NET), y servicios Windows.
  * Uso sencillo en entornos corporativos con Windows.

* **Limitaciones**:
  * **No multiplataforma**: Solo funciona en Windows.
  
  * **Monolítico y pesado**: Incluye demasiadas bibliotecas que no siempre se necesitan.
  
  * Depende de versiones específicas instaladas en el sistema operativo.

# .NET Core (2016)
* **Por qué surge**: Con la necesidad de competir en un mundo de desarrollo moderno (que demandaba aplicaciones multiplataforma, contenedores y microservicios), Microsoft lanzó .NET Core como una plataforma moderna, ligera y modular.

* **Qué es**:
  * Un nuevo marco de desarrollo completamente independiente de .NET Framework.
  
  * Diseñado para ser multiplataforma (Windows, Linux y macOS).
  
  * Modular y de código abierto (open-source).

* **Ventajas**:
  * **Ligero y flexible**: Puedes incluir solo las bibliotecas necesarias para tu aplicación.
  
  * **Rendimiento mejorado**: Ideal para aplicaciones de alto rendimiento.
  
  * **Multiplataforma**: Soporta Windows, Linux y macOS.
  
  * **Open Source**: Comunidad activa que mejora continuamente la plataforma.

* **Limitaciones**:
  * Inicialmente, no tenía soporte completo para todas las características del .NET Framework
  * Algunas tecnologías, como Windows Forms y WPF, no estaban disponibles en las primeras versiones.

# .NET (Unificación desde 2020 con .NET 5 en adelante)
* **Por qué surge**: Con .NET Framework y .NET Core coexistiendo, Microsoft decide unificar ambas plataformas en una sola versión de .NET. Esta nueva plataforma elimina la confusión y aprovecha lo mejor de ambas.

* **Qué es**:
  * Desde .NET 5 (lanzado en noviembre de 2020), se unificaron .NET Core y .NET Framework en una única plataforma simplemente llamada .NET.

  * Incluye las mejores características de .NET Framework (como WinForms y WPF) y .NET Core (multiplataforma, modular y eficiente).

* **Ventajas**:
  * **Unificación total**: Todo el desarrollo se centra en una única plataforma moderna.
  
  * **Multiplataforma**: Sigue soportando Windows, Linux y macOS.
  
  * **Compatibilidad con el pasado**: Puedes migrar aplicaciones existentes del .NET Framework a las versiones modernas de .NET.
  
  * **Enfoque en el futuro**: Orientado a contenedores, aplicaciones en la nube, microservicios y sistemas distribuidos.

* **Limitaciones**: Para proyectos heredados muy antiguos, es posible que no sea compatible directamente y necesites esfuerzo adicional para migrarlos.

---
[](DotNetFramework.md)
[](DotNetCore.md)
[]()