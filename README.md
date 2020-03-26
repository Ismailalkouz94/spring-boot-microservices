# Weather guess application using microservices spring boot cloud

## Technologies
* spring boot\
* spring cloud netflix\
* restfull API\
* mysql database\
* maven


## Contents

The repository contains five folders, one for each component of the system:

* **User-Managment** is one of the backend services. It has a REST API to get and provide results to simple Users managment.
* **Weather API** is the second backend service. It provides a REST API to get weathers.
* **Service-Registry** is the Eureka Server, which is contacted by backend services and the gateway.
* **Api-Gateway** is the Routing Service, implemented with Zuul. It connects with Eureka for service discovery, and performs load balancing with Ribbon.
* **postman collection** contains the API samples.

## How to execute the application

These are the instructions:

* **postman collection**. Using postman software [POSTMAN](https://www.postman.com/).
* **User-Managment, Weather API, service-registry and Api-gateway**. You need to start all these services using the command line. Navigate to each folder and execute for every one of them: `./mvnw spring-boot:run`. If you want to try load balancing you can execute more than one instance of the User-Managment or Weather API service. To do that, override the port number to avoid clashing: `./mvnw spring-boot:run -Drun.arguments="--server.port=A_FREE_PORT"` ex:`mvnw spring-boot:run -Drun.arguments="--server.port=8081`

## Notes
* if you want to see your registered services go to [Eureka](http://localhost:8761/) Dashboard
