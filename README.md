# figuras-geometricas
### Servicio REST de ingreso y registro de Figuras Geometricas.

#### **Frameworks utilizados:**
* Spring Boot
* Spring Boot Data (MongoDB)

#### **Repositorio:**
* Cluster en MongoDB Atlas

#### **Testing:**
* JUnit 5
* Mockito




### Aplicacion desplegada en Heroku

[figuras-geometricas-rest](https://figuras-geometricas-rest.herokuapp.com/figuras)




### Instrucciones para ejecutar localmente

**Requisitos:**
- Java 8 o posterior
- Maven

**Descargar el proyecto y ejecutar este comando de Maven:**

    mvn spring-boot:run


## Api REST

        
#### Obtener todas las Figuras registradas

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
    
 
#### Obtener Figura por id

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

#### Ingresar Figuras

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


Otro ejemplo:

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

#### Detalle del Request Body

    {
        "tipo" : <tipo>,
        "parametros" : [parametros...]
     }

  Nota: Los parametros para crear la figura se pasan en un array.
  

| Tipos     | Parametros    | Ejemplo    |
|-----------|---------------|------------|
| Circulo   | diametro      | [1.2]      |
| Cuadrado  | lado          | [3.4]      |
| Triangulo | base y altura | [5.6, 7.8] |
