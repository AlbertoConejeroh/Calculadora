# Calculator
Calculadora con las funciones básicas de suma y resta. 

### Requisitos previos
Java 17 y Maven 3.9.3
Descargar el codigo del repositorio de GitHub
Ejecutar el comando `mvn clean install` en la carpeta raíz del proyecto
Ejecutar el jar que se ha generado en la carpeta `/target` con el comando
 `java -jar target/calculadora-0.0.1-SNAPSHOT.jar`

El puerto configurado es 8081, se puede cambiar antes de generar el jar en el `application.properties`

### Ejecución y pruebas

Para probar la calculadora, puede hacerse mendiante el Swagger

http://localhost:8081/swagger-ui/index.html

Los valores a introducir en el campo operations son 'suma' o 'resta' (no case sensitive)

EJEMPLOS:

firstParam 1; secondParam  1; operation suma; --> Value calculate: 2
firstParam 2; secondParam  1; operation resta; --> Value calculate: 1

Si la operación introducida no está entre las operaciones válidas, se muestra el siguiente error
{
  "statusCode": 400,
  "message": "CALC0001 Error unavalible operation",
  "requestUri": "/rest/calculator/calculate"
}

### Añadir nueva fucionalidad

Para añadir nuevas funcionalidades bastará con crear un componente nuevo con el nombre OperationImpl`Nuevafuncionalidad`  que implemente la clase IOperationsComponent
e implementar el método calculate con la función que queramos realizar, debemos tener en cuenta que el literal que entra en el campo operation debe ser nuestro `Nuevafuncionalidad`




