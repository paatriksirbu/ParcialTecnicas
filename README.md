# Parcial Técnicas de Programación

En este proyecto encontramos tres carpetas donde la primera corresponde al ejercicio 5 y 6 del examen, la segunda carpeta corresponde al ejercicio de las tablas hash y la ultima carpeta corresponde al ejercicoi de los grafos.

## Ejercicio 5 y 6
Este ejercicio es una extension del juego del barco de tocado y hundido. En este caso creamos 3 tipos de barcos (Battleship, Frigate, Canoe) donde cada uno de ellos tiene una serie de atributos diferentes. El battleship y el frigate por ejemplo, tienen un atributo extra que son las secciones aisladas. Para conseguir hundir uno de estos barcos, necesitamos hundir todas sus secciones y de esta manera conseguiremos hundir el barco en su totalidad.

Tambien incluye una nueva enum orientacion para decidir la orientacion de los barcos (Vertical, horizontal) y tambien diferentes estrategias de posicionamiento para conseguir poner los barcos en posiciones consecutivas/adyacentes.

Refactorizamos el codigo con el patron Abstract Factory, donde creamos una clase fabrica y una interfaz.

En el main, pedimos al usuario que introduzca su configuracion, creamos barcos, cuadriculas y los jugadores se van turnando hasta que uno hunde el barco del otro y se muestra quien es el ganador.

## Ejercicio 7 
La clase Barco define las propiedades y métodos para manejar información de barcos.
El método cargarBarco en Main crea instancias de Barco y las almacena en hashmaps.
Se utilizan tres hashmaps para organizar los barcos por tipo, número y nombre.
Incluye un método principal que inicializa y carga algunos barcos como ejemplos.
Proporciona métodos para establecer y obtener atributos de los barcos.

## Ejercicio 8 
La clase Puerto representa un nodo con un nombre.
Arista define una conexión entre puertos, incluyendo la distancia.
Grafo gestiona la red, permitiendo agregar puertos y aristas.
Incluye algoritmos para barrido en profundidad y el camino más corto (Dijkstra).
Permite eliminar el puerto con más conexiones, actualizando el grafo adecuadamente.
Se enfoca en la representación y manipulación de grafos para modelar conexiones entre puertos.

## Contacto

Patrik Paul Sirbu - https://github.com/paatriksirbu

Mail: patrikpsirbu@gmail.com

Enlace del proyecto: https://github.com/paatriksirbu/ParcialTecnicas.git
