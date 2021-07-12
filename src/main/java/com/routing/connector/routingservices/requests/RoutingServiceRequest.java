package com.routing.connector.routingservices.requests;

/**
 * Interface for Routing Requests.
 */
public interface RoutingServiceRequest<RequestFormat> {
    RequestFormat toCorrectFormat();
}
