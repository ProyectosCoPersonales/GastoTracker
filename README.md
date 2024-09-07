1.	Requisitos previos
NetBeans 8.2 en adelante 
 
Pueden presentar advertencias por incompatibilidad de versiones usando NetBeans 8.2 pero esto no afecta en nada la ejecución del programa.
JDK 8 en adelante
SQLite Studio 3.4.4 (Para poder divisar la base de datos)
Sqlite-jdbc-3.23.1(Librería necesaria para poder interactuar con la base de datos)
2.	Instaladores
Dentro de la carpeta del proyecto encontrará Aplicaciones utilizadas dentro usted encontrará tanto NetBeans 8.2 así como el JDK 8, la librería jdbc utilizada en este proyecto.
3.	Botones
 
Descripción: Permite mostrar todos los registros almacenados en la base de datos en el orden en que fueron insertados.
 
Descripción: Permite ingresar nuevos registros a la base de datos.
 
Descripción: En el campo de texto de Producto admite TEXT si por algún motivo llega a introducir algún decimal se lo guardará como cadena de texto, Cantidad solo admite entero, PrecioUnitario solo admite números reales es decir 0.10 está permitido, el campo Total solo admite decimales.
 
Descripción: Solo utilizar en caso de que tenga una tabla presente es decir, no funciona si la tabla se encuentra vacía, Si desea emplea este botón de clic en el botón “Mostrar” también funciona después de aplicar métodos como Filtrar, Añadir.
 
Descripción: El botón filtrar actúa sobre la tabla presente, en caso de no existir solo marcará error. Si desea emplea este botón de clic en el botón “Mostrar” y aplique los filtros que desee, también funciona después de aplicar métodos como Ordenar, Añadir.
 
Descripción: El botón Ordenar actúa sobre la tabla presente, en caso de no existir solo marcará error. Si desea emplea este botón de clic en el botón “Mostrar” y se ordenarán de acuerdo a la categoría en orden ascendente.
