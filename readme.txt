201710_CSOF5101_01 - CONCEPTOS AVANZADOS DE INGENIER�A DE SOFTWARE
Tarea 5 - Integral num�rica con reglas de Simpson
JUAN PABLO OSPINO SOLANO
20170403
repositorio: https://github.com/jpospino/tarea5.git

0. Clonar el repositorio
para clonar ejecute el siguiente comando en DOS
 	
	git clone https://github.com/jpospino/tarea5.git
	
a continuaci�n vaya a la ruta de las fuentes con el siguiente comando
	
	cd tarea4\src\tarea4\

1. Compilaci�n en maven
ubicado en la ruta donde se encuenrtan las fuentes ejecute los siguientes comandos para compilar

	mvn clean
	mvn package

tambi�n puede compilar utilizando el siguiente comando como lo sugiere heroku
	
	mvn clean install

y el comando para correr local:
	
	heroku local web

y en un navegador web o un cliente de servicios rest como Postman enviar el siguiente request

	http://localhost:5000/numericalIntegration?intervalo=2.750&DOF=30&error=0.00001	
	
se adjunta dentro de las carpeta de test el resultado de la compilaci�n y pruebas unitarias ver compilacion.txt.


2. Acceso a heroku


el programa est� publicado en heroku como un servicio REST para su ejecuci�n. 

https://damp-sands-70615.herokuapp.com/numericalIntegration?intervalo=2.750&DOF=30&error=0.00001

cambie los parametros segun los valores que se quiera introducir
intervalo
DOF
error

3. Accesos a JAVADOC
Entre a la ruta \Tarea5\src\tarea5\target\site\apidocs\index.html


***************************************