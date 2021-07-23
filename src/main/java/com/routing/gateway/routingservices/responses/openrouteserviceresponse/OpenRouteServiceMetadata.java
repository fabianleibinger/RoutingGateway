package com.routing.gateway.routingservices.responses.openrouteserviceresponse;

public class OpenRouteServiceMetadata {
    private String attribution;
    private OpenRouteServiceEngine engine;
    private String id;
    private String osm_file_md5_hash;

    public Object getQuery() {
        if (this.query == null) {
            this.query = new Object();
        }
        return query;
    }

    public void setQuery(Object query) {
        this.query = query;
    }

    private Object query;
    private String service;
    private String system_message;
    private Long timestamp;

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public OpenRouteServiceEngine getEngine() {
        if (this.engine == null) {
            this.engine = new OpenRouteServiceEngine();
        }
        return engine;
    }

    public void setEngine(OpenRouteServiceEngine engine) {
        this.engine = engine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOsm_file_md5_hash() {
        return osm_file_md5_hash;
    }

    public void setOsm_file_md5_hash(String osm_file_md5_hash) {
        this.osm_file_md5_hash = osm_file_md5_hash;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSystem_message() {
        return system_message;
    }

    public void setSystem_message(String system_message) {
        this.system_message = system_message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
