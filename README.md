[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/NBVXLiSy)
# Actividad: Desarrollo de Proyecto Software en Kotlin

**ID actividad:** 2324_PRO_u4u5u6_libre

**Agrupamiento de la actividad**: Individual 

---

### Descripción:

La actividad consiste en el desarrollo de un proyecto software en Kotlin, permitiendo al estudiante elegir la temática. Este proyecto debe demostrar la comprensión y aplicación de los conceptos de programación orientada a objetos (POO), incluyendo la definición y uso de clases, herencia, interfaces, genericos, principios SOLID y el uso de librerías externas.

**Objetivo:**

- Demostrar comprensión de los fundamentos de POO mediante la instanciación y uso de objetos.
- Aplicar conceptos avanzados de POO como herencia, clases abstractas, e interfaces.
- Crear y usar clases que hagan uso de genéricos. 
- Aplicar principios SOLID.
- Integrar y utilizar librerías de clases externas para extender la funcionalidad del proyecto.
- Documentar y presentar el código de manera clara y comprensible.

**Trabajo a realizar:**

1. **Selección de la Temática:** Elige un tema de tu interés que pueda ser abordado mediante una aplicación software. Esto podría ser desde una aplicación de gestión para una pequeña empresa, una herramienta para ayudar en la educación, hasta un juego simple. Define claramente el problema que tu aplicación pretende resolver.

2. **Planificación:** Documenta brevemente cómo tu aplicación solucionará el problema seleccionado, incluyendo las funcionalidades principales que desarrollarás.

3. **Desarrollo:**
   - **Instancia de Objetos:** Tu aplicación debe crear y utilizar objetos, demostrando tu comprensión de la instanciación y el uso de constructores, métodos, y propiedades.
   - **Métodos Estáticos:** Define y utiliza al menos un método estático, explicando por qué es necesario en tu aplicación.
   - **Uso de IDE:** Desarrolla tu proyecto utilizando un IDE, aprovechando sus herramientas para escribir, compilar, y probar tu código.
   - **Definición de Clases:** Crea clases personalizadas con sus respectivas propiedades, métodos, y constructores.
   - **Clases con genéricos:** Define y utiliza al menos una clase que haga uso de genéricos en tu aplicación.
   - **Herencia y Polimorfismo:** Implementa herencia y/o interfaces en tu proyecto para demostrar la reutilización de código y la flexibilidad de tu diseño.  **Usa los principios SOLID:** Ten presente durante el desarrollo los principios SOLID y úsalos durante el diseño para mejorar tu aplicación.
   - **Librerías de Clases:** Integra y utiliza una o más librerías externas que enriquezcan la funcionalidad de tu aplicación.
   - **Documentación:** Comenta tu código de manera efectiva, facilitando su comprensión y mantenimiento.

4. **Prueba y Depuración:** Realiza pruebas para asegurarte de que tu aplicación funciona como se espera y depura cualquier error encontrado.
5. **Contesta a las preguntas** ver el punto **Preguntas para la Evaluación**

### Recursos

- Apuntes dados en clase sobre programación orientada a objetos, Kotlin, uso de IDEs, y manejo de librerías.
- Recursos vistos en clase, incluyendo ejemplos de código, documentación de Kotlin, y guías de uso de librerías.

### Evaluación y calificación

**RA y CE evaluados**: Resultados de Aprendizaje 2, 4, 6, 7 y Criterios de Evaluación asociados.

**Conlleva presentación**: SI

**Rubrica**: Mas adelante se mostrará la rubrica.

### Entrega

> **La entrega tiene que cumplir las condiciones de entrega para poder ser calificada. En caso de no cumplirlas podría calificarse como no entregada.**
>
- **Conlleva la entrega de URL a repositorio:** El contenido se entregará en un repositorio GitHub. 
- **Respuestas a las preguntas:** Deben contestarse en este fichero, README.md


# Preguntas para la Evaluación

**Planificación:** Este software solucionara el problema de gestionar un concesionario a nivel informatico. Aporta soluciones tales como gestionar(añadir, eliminar, etc...) los vehiculos que estan en el concesionario, tanto los que se venden como los que estan para repararse. 
A su vez, gestiona el inventario de piezas disponible y su uso (añadir piezas, hacer un pedido etc...).
Tambien permite gestionar los arreglos que se hacen en la seccion del Taller, y entre otras cosas, crear facturas y obtener analisis de estas.

Este conjunto de preguntas está diseñado para ayudarte a reflexionar sobre cómo has aplicado los criterios de evaluación en tu proyecto. Al responderlas, **asegúrate de hacer referencia y enlazar al código relevante** en tu `README.md`, facilitando así la evaluación de tu trabajo.

#### **Criterio global 1: Instancia objetos y hacer uso de ellos**
- **(2.a, 2.b, 2.c, 2.d, 2.f, 2.h, 4.f, 4.a)**: Describe cómo has instanciado y utilizado objetos en tu proyecto. ¿Cómo has aplicado los constructores y pasado parámetros a los métodos? Proporciona ejemplos específicos de tu código.

Uno de los ejemplos de como he instanciado y usado mis objetos es lo que he hecho con Coche y Motocicleta.

Estos son los metodos que les he pasado a el onjeto Coche en concreto, los cuales me sirven para tener informacion de cada uno de ellos, asi como poder localizarlos facilmente en cualquier punto del software.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/Coche.kt#L3-L60

Como se puede ver en el codigo, creo los objetos usando el constructor definido en la propia clase dentro del companion object, lo que me permite hacer esto en cada tipo de Vehiculo especifico, y tener un mayor control y organizacion.

#### **Criterio global 2: Crear y llamar métodos estáticos**
- **(4.i)**: ¿Has definido algún método/propiedad estático en tu proyecto? ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?

He definido varios metodos estaticos en mi proyecto. Por ejemplo, los que contiene el objeto GestionConsola:

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/GestionConsola.kt#L4-L53

Como se puede ver, tengo varios metodos y propiedades, los cuales puedo usar en cualquier parte de mi codigo sin necesidad de crear una instancia de este GestorConsola.

  
- **(2.e)**: ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?

A lo largo de mi proyecto lo uso en numerosas ocasiones, ya que se encarga de todo lo relacionado con la consola, tanto pedir datos, como mostrarlos, por lo que hacer estos metodos estaticos es una buena practica.

Por ejemplo:

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/GestorInventario.kt#L74-L83

Hago uso de el metodo imprimirTexto para mostrar por pantalla lo deseado.


O tambien:

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/GestorInventario.kt#L114-L121

En este caso hago uso de el metodo solicitarDato para que se inserte un valor.


Otro ejemplo es el que vimos anteriormente en la clase Coche:

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/Coche.kt#L30-L59

Este metodo estatico, me sirve para poder crear un Coche (o cualquier vehiculo, ya que en cada vehiculo especifico, como motocilceta, se deberia de hacer de la misma forma) en cualquier parte de mi codigo.

#### **Criterio global 3: Uso de entornos**
- **(2.i)**: ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? Describe el proceso de creación, compilación, y prueba de tu programa.

El proceso de creacion, compilacion y prueba lo he llevado a cabo usando el IDE IntelliJ IDEA.
He creado el proyecto seleccionando el lenguaje Kotlin ya que era el adecuado para mi software.
Durante el proceso de creacion del codigo, el IDE me proporciono bastantes recursos, tanto como para hacerme ver los errores, como para verificaciones en tiempo real y sugerencias.
A la hora de compilar, si hay algun error me lo marca claramente, permitiendo navegar hasta el lugar del error con un solo click.
Tambien me permite depurar de una forma relativamente sencilla, pudiendo ver valores concretos en tiempo de ejecucion, avanzando paso a paso y a mi gusto y medida, gracias a los puntos de ruptura.
Por ultimo, he usado un control de versiones Git, el cual esta integrado de una manera muy intutitiva en el IDE, facilitando la tarea de llevar un registro y control de mi proyecto.


#### **Criterio global 4: Definir clases y su contenido**
- **(4.b, 4.c, 4.d, 4.g)**: Explica sobre un ejemplo de tu código, cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, métodos y constructores y modificadores del control de acceso a métodos y propiedades, para representar al objeto del mundo real. ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda?

En mi proyecto, he difinido varias clases que representan objetos del mundo real. 
Un ejemplo es Pieza: 

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/Pieza.kt#L3-L36

Identificar sus propiedades me ha sido facil, ya que me he basado en la informacion que seria util guardar en el sistema sobre cada pieza. Basandome en ello, he considerado oportuno establecer dichas propiedades, permitiendo identificar rapidamente cada pieza, y tener cierta informacion de cada una de ellas.


Otro ejemplo, para el cual me baso en lo mismo es Factura:

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/Factura.kt#L5-L49


#### **Criterio global 5: Herencia y uso de clases abstractas e interfaces**
- **(4.h, 4.j, 7.a, 7.b, 7.c)**: Describe sobre tu código cómo has implementado la herencia o utilizado interfaces en tu proyecto. ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? ¿Mostrando tu código, contesta a qué principios has utilizado y qué beneficio has obtenido?

He usado interfaces a la hora de usar los gestores de inventario:

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/GestorInventario.kt#L3-L13


Cada inventario, en este caso dos, extienden esta interfaz por lo que implementan todos sus metodos, permitiendo aplicar las mismas operaciones comunes a diferentes tipo de inventarios, lo que hace el codigo mas flexible y reutilizable. Si en un futuro se necesita gestionar otro inventario de cualquier otro tipo, se podra hacer usando esta interfaz.

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/GestorInventario.kt#L20

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/GestorInventario.kt#L295


He usado los principios SOLID SRP, OCP Y LSP, ya que cada clase e interfaz tiene una unica responsabilidad; el diseño permite que nuevas clases de inventarios sean implementadas sin tener que modificar el codigo existente; y las clases que implementen esta interfaz pueden usarse de forma intercambiable en cualquier lugar donde se requiera un objeto que gestione un inventario.


#### **Criterio global 6: Diseño de jerarquía de clases**
- **(7.d, 7.e, 7.f, 7.g)**: Presenta la jerarquía de clases que diseñaste. ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción?

Mi clase base es Vehiculo:

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/Vehiculo.kt#L4-L271

De la cual heredan 2 vehiculos, un coche y una motocicleta:

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/Coche.kt#L3-L61


https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/Motocicleta.kt#L3-L115

He usado un tipo de herencia que especializa a su clase padre, la cual es abstracta, ya que no me interesa crear ningun objeto que sea Vehiculo en sí.

Para probar esta herencia si funcionaba correctamente, he instanciado vehiculos de tipo coche y de tipo moto y he realizado pruebas con sus metodos y propiedades, tanto ejecutando el programa como depurandolo.

Ademas, en el resto del programa hago comprobaciones para verificar sobre que tipo de vehiculo estoy trabajando en cada momento, ya que tambien tengo una enum class con esta informacion:

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/TipoVehiculo.kt#L3-L10



#### **Criterio global 7: Librerías de clases**
- **(2.g, 4.k)**: Describe cualquier librería externa que hayas incorporado en tu proyecto. Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto.

He elegido una libreria de analisis de datos, ya que mi programa contiene facturasm, por lo que realiza analisis de estas facturas de forma mensual, mostrando una serie de operaciones concretas, como el precio total de ventas o la desviacion estandar de precios.

Lo realizo de esta forma:

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/UtilidadesTaller.kt#L80-L127


#### **Criterio global 8: Documentado**
- **(7.h)**: Muestra ejemplos de cómo has documentado y comentado tu código. ¿Que herramientas has utilizado? ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código?

Como he mostrado en todo el codigo anteriormente explicado, he documentado todas las clases, fucniones, etc para la correcta compresion del software.

Mas ejemplos de la documentacion:

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/Menu.kt#L8C5-L28C6


https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/Motocicleta.kt#L3-L32



https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/Taller.kt#L4-L110



#### **Criterio global 9: Genéricos**
- **(6.f)**: Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. ¿Qué beneficio has obtenido?

Uso de generico:

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/GestionConsola.kt#L55-L111

Como podemos ver, he usado los genericos en la GestionConsola, ya que me es muy util para solicitar datos y devolver el dato del tipo que me interesa en cada momento.

Por ejemplo, aqui me interesa devolver el dato de tipo Double, pues simplemente debo de llamar a la funcion solicitarDato, y pasarle como parametro una lambda que indique el dato de salida:

https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-agadrian/blob/43a949c2299a7352b37870a99c86502add2127ba/src/main/kotlin/GestorInventario.kt#L156-L163

A su vez, en la fucnion de solicitarDato, permito que se ingrese un dato vacio. En este caso, se llama a otra fucnion que lo que hace es dependiendo del dato deseado de salida, nos devuelve un valor por defecto, para poder trabajar en nuestro programa teniendo en cuenta que si el valor de salida es el por defecto, significaria que no se ha introducido nada por consola en este caso.
