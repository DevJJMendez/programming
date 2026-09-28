# Comunicación entre Componentes
✅ Es el proceso de enviar datos de un componente a otro.
✅ Permite construir aplicaciones dinámicas donde los componentes interactúan entre sí.
✅ React NO tiene un sistema de comunicación automático como otros frameworks, por lo que debemos manejarlo manualmente.

## Tipos de Comunicación entre Componentes
| Tipo                             | Origen → Destino    | Uso común                                     | Ejemplo                               |
| -------------------------------- | ------------------- | --------------------------------------------- | ------------------------------------- |
| Props                            | Padre → Hijo        | Pasar datos y funciones                       | <Componente prop={dato} />            |
| Lifting State Up                 | Hijo → Padre        | Formularios, eventos                          | Función en el padre que el hijo llama |
| Context API                      | Global              | Estado compartido sin prop drilling           | useContext                            |
| Redux / Zustand                  | Global              | Aplicaciones grandes                          | Store centralizado                    |
| Eventos personalizados (Pub/Sub) | Cualquier dirección | Comunicación entre componentes independientes | useEffect, EventEmitter               |