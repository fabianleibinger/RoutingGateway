# RoutingGateway

This is a project developed by Fabian Leibinger in terms of his bachelor thesis at Karlruhe Institut für Technologie (KIT) in cooperation with Forschungszentrum Informatik (FZI).
A Java Spring Boot project.

The RoutingGateway serves as the routing component of the travel information system, and therefore accesses Routing Services via Http.
By mapping a routing request including mobility preferences to the various routing specifications of the Routing Services, 
the RoutingGateway enables calculation of routes with multiple different services by using only one routing request specification.
This is done without losing flexibility in the functionality of the Routing Services. 

## clients

The RoutingGateway offers controller classes for each client using personalized routing request specifications.
In this implementation, the only client is the travel_information_app. RoutingController enables sending routing requests to the RoutingGateway, while RoutingServiceController lists all available Routing Services.
Data transfer objects including the routing request and response specifications of the travel_information_app can be found under models.

adapters hosts adapter classes for each Routing Service, that is integrated into the RoutingGateway. 
An adapter enables the connection to the specific Routing Service and handles all communication. 
By implementing the IRoutingService interface, you can add an adapter for a RoutingService, that should be integrated into the system.

Using semantic mappings, the adapter classes map request and response specifications between Routing Service and client. 
Mapping rules can be formalized with Java or Nomin, which uses Groovy closures. Nomin Mappings can be found under resources. 

## exceptions

Meaningful exceptions can be implemented by extending RuntimeException class. The exception will be thrown if added to the ApiExceptionHandler and creating an exception message (ApiException).

## routingservices

This folder saves data transfer objects of the Routing Services: request and response specifications. 
By extending Parameters class, the data transfer object classes can be serialized into Json, XML or Query String without implementing any code on their own.
This feature comes in handy for implementing the request classes for the Routing Services.
