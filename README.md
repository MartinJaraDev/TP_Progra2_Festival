ConjuntoAsistentesTDA se creó para guardar el DNI de los asistentes.
DiccionarioSimpleA se creó para guardar el DNI de los asistentes como clave y el valor sera la clase Asistente (tiene DNI, nombre y tipo de entrada como atributos).
El paquete ConjuntoInfo es el TDA y la implementación de conjunto vista en clase, se utiliza para que al recuperar el conjunto de claves del diccionario, pueda devolver un conjunto de DNI(datos de tipo int).



 

##Análisis de Costos 



Diccionario (DiccionarioSimpleA)

Agregar: El costo de esta operación es O(N). 
Eliminar: El costo de esta operación es O(N). 
Recuperar: El costo de esta operación es O(N). 
Claves: El costo de esta operación es O(N²). 

Conjuntos (ConjuntoA y ConjuntoLD)

Agregar: El costo es O(N).
Sacar: El costo es O(N).
Pertenece: El costo es O(N).
Elegir y ConjuntoVacio: El costo es O(1).

Cola (ColaAsistente)

Acolar: El costo de esta operación es O(1). 
Desacolar: El costo de esta operación es O(1).
Primero y ColaVacia: El costo de estas operaciones es O(1), 
