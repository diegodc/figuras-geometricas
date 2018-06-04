# figuras-geometricas
Ejercicio: Servicio REST de ingreso y registro de Figuras Geometricas. El servicio utiliza un cluster en MongoDB Atlas como repositorio.

Frameworks utilizados:
- Spring Boot
- Spring Boot Data (MongoDB)

Testing:
- JUnit 5
- Mockito

Instrucciones para ejecutar localmente

Requisitos:
- Java 8 o posterior
- Maven

Comando:

    mvn spring-boot:run
    
    
Api REST:

Ingresar Figuras

    URL: http://localhost:8080/figuras
    METODO: POST
    Request Body:
        {
            "tipo" : "cuadrado",
            "parametros" : [2.5]
        }
    Response Body:
        {
            "id": "5b15b7421300f43494fa8ecc",
            "superficie": 6.25,
            "base": 2.5,
            "tipo": "Cuadrado",
            "altura": 2.5,
            "diametro": null
        }
        
    URL: http://localhost:8080/figuras
    METODO: POST
    Request Body:
        {
            "tipo" : "triangulo",
            "parametros" : [2.5, 10.0]
        }
    Response Body:
        {
            "id": "5b15b9e01300f43494fa8ecd",
            "superficie": 12.5,
            "base": 2.5,
            "altura": 10,
            "tipo": "Triangulo",
            "diametro": null
        }

Obtener Figura por id

    URL: http://localhost:8080/figuras/{idFigura}
    METODO: GET
    Response Body:
        {
            "id": "5b15b7421300f43494fa8ecc",
            "superficie": 6.25,
            "base": 2.5,
            "tipo": "Cuadrado",
            "altura": 2.5,
            "diametro": null
        }
        
 Obtener todas las Figuras registradas

    URL: http://localhost:8080/figuras
    METODO: GET
    Response Body:
    [
        {
            "id": "5b14fbd91300f46badaaca99",
            "superficie": 1.3892908112337463,
            "diametro": 1.33,
            "tipo": "Circulo",
            "base": null,
            "altura": null
        },
        {
            "id": "5b14fe1b1300f46d1234eae5",
            "superficie": 123.28099999999999,
            "base": 202.1,
            "altura": 1.22,
            "tipo": "Triangulo",
            "diametro": null
        },
        {
            "id": "5b15b7421300f43494fa8ecc",
            "superficie": 6.25,
            "base": 2.5,
            "tipo": "Cuadrado",
            "altura": 2.5,
            "diametro": null
        }
    ]
    

Request Body para ingresar Figuras

Tipos permitidos: "cuadrado", "circulo", "triangulo"

Parametros para cada tipo (los parametros se pasan en un array):

Cuadrado: 1 solo parametro indicando la longitud de los lados.

Circulo: 1 solo parametro indicando la longitud del diametro.

Triangulo: 2 parametros indicando la base y la altura del triangulo respectivamente.
