package com.routing.connector.routingservices.parameters.OpenRouteServiceParameters;

import com.google.gson.Gson;
import com.routing.connector.models.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class OpenRouteServiceParameters {

    //required
    private List<Double[]> coordinates = new ArrayList<>();
    private OpenRouteServiceAlternativeRoutes alternative_routes;
    private List<String> attributes = new ArrayList<>();
    private List<Float[]> bearings = new ArrayList<>();
    private Boolean continue_straight = false;
    private Boolean elevation = false;
    private List<String> extra_info = new ArrayList<>();
    private Boolean geometry_simplify = false;
    private String id;
    private Boolean instructions = true;
    private String instructions_format = "text";
    private String language = "en";
    private Boolean maneuvers = false;
    private String options;
        private String avoid_borders = "controlled";
        private List<Integer> avoid_countries = new ArrayList<>();
        private List<String> avoid_features = new ArrayList<>();
        private String avoid_polygons;
        private String profile_params;
            private String restrictions;
                private Float axleload;
                private Boolean hazmat = false;
                private Float height;
                private Float length;
                private Integer maximum_incline = 6;
                private Float maximum_sloped_kerb = 0.6f;
                private Float minimum_width;
                private String smoothness_type = "good";
                private String surface_type = "cobblestone:flattened";
                private String track_type = "grade1";
                private Float weight;
                private Float width;
            private String weightings;
                private Float green;
                private Float quiet;
                private Integer steepness_difficulty;
        private String round_trip;
            //private Float length;
            private Integer points;
            private Integer seed;
        private String vehicle_type = "hgv";
    private String preference = "recommended";
    private Boolean roundabout_exits = false;
    private List<Integer> skip_segments = new ArrayList<>();
    private Boolean suppress_warnings = false;
    private String units = "m";
    private Boolean geometry = true;
    private Integer maximum_speed;

    public OpenRouteServiceParameters(List<Coordinate> coordinates) {
        for (Coordinate coo : coordinates) {
            this.addCoordinate(coo);
        }
    }

    public String toJson() {
        return "{\"coordinates\":[[8.681495,49.41461],[8.686507,49.41943],[8.687872,49.420318]]}";
    }

    public String toJSON() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        System.out.println(json);
        return json;
    }

    public void addCoordinate(Coordinate coordinate) {
        Double[] newCoordinate = new Double[]{coordinate.getLatitude(), coordinate.getLongitude()};
        coordinates.add(newCoordinate);
    }

    public List<Double[]> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double[]> coordinates) {
        this.coordinates = coordinates;
    }

    public OpenRouteServiceAlternativeRoutes getAlternativeRoutes() {
        if (alternative_routes == null) {
            alternative_routes = new OpenRouteServiceAlternativeRoutes();
        }
        return alternative_routes;
    }

    public void setAlternativeRoutes(OpenRouteServiceAlternativeRoutes alternative_routes) {
        this.alternative_routes = alternative_routes;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public List<Float[]> getBearings() {
        return bearings;
    }

    public void setBearings(List<Float[]> bearings) {
        this.bearings = bearings;
    }

    public Boolean isContinueStraight() {
        return continue_straight;
    }

    public void setContinueStraight(Boolean continue_straight) {
        this.continue_straight = continue_straight;
    }

    public Boolean isElevation() {
        return elevation;
    }

    public void setElevation(Boolean elevation) {
        this.elevation = elevation;
    }

    public List<String> getExtraInfo() {
        return extra_info;
    }

    public void setExtraInfo(List<String> extra_info) {
        this.extra_info = extra_info;
    }

    public Boolean isGeometrySimplify() {
        return geometry_simplify;
    }

    public void setGeometrySimplify(Boolean geometry_simplify) {
        this.geometry_simplify = geometry_simplify;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isInstructions() {
        return instructions;
    }

    public void setInstructions(Boolean instructions) {
        this.instructions = instructions;
    }

    public String getInstructionsFormat() {
        return instructions_format;
    }

    public void setInstructionsFormat(String instructions_format) {
        this.instructions_format = instructions_format;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean isManeuvers() {
        return maneuvers;
    }

    public void setManeuvers(Boolean maneuvers) {
        this.maneuvers = maneuvers;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getAvoidBorders() {
        return avoid_borders;
    }

    public void setAvoidBorders(String avoid_borders) {
        this.avoid_borders = avoid_borders;
    }

    public List<Integer> getAvoidCountries() {
        return avoid_countries;
    }

    public void setAvoidCountries(List<Integer> avoid_countries) {
        this.avoid_countries = avoid_countries;
    }

    public List<String> getAvoidFeatures() {
        return avoid_features;
    }

    public void setAvoidFeatures(List<String> avoid_features) {
        this.avoid_features = avoid_features;
    }

    public String getAvoidPolygons() {
        return avoid_polygons;
    }

    public void setAvoidPolygons(String avoid_polygons) {
        this.avoid_polygons = avoid_polygons;
    }

    public String getProfileParams() {
        return profile_params;
    }

    public void setProfileParams(String profile_params) {
        this.profile_params = profile_params;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public Float getAxleload() {
        return axleload;
    }

    public void setAxleload(Float axleload) {
        this.axleload = axleload;
    }

    public Boolean isHazmat() {
        return hazmat;
    }

    public void setHazmat(Boolean hazmat) {
        this.hazmat = hazmat;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Integer getMaximumIncline() {
        return maximum_incline;
    }

    public void setMaximumIncline(Integer maximum_incline) {
        this.maximum_incline = maximum_incline;
    }

    public Float getMaximumSlopedKerb() {
        return maximum_sloped_kerb;
    }

    public void setMaximumSlopedKerb(Float maximum_sloped_kerb) {
        this.maximum_sloped_kerb = maximum_sloped_kerb;
    }

    public Float getMinimumWidth() {
        return minimum_width;
    }

    public void setMinimumWidth(Float minimum_width) {
        this.minimum_width = minimum_width;
    }

    public String getSmoothnessType() {
        return smoothness_type;
    }

    public void setSmoothnessType(String smoothness_type) {
        this.smoothness_type = smoothness_type;
    }

    public String getSurfaceType() {
        return surface_type;
    }

    public void setSurfaceType(String surface_type) {
        this.surface_type = surface_type;
    }

    public String getTrackType() {
        return track_type;
    }

    public void setTrackType(String track_type) {
        this.track_type = track_type;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public String getWeightings() {
        return weightings;
    }

    public void setWeightings(String weightings) {
        this.weightings = weightings;
    }

    public Float getGreen() {
        return green;
    }

    public void setGreen(Float green) {
        this.green = green;
    }

    public Float getQuiet() {
        return quiet;
    }

    public void setQuiet(Float quiet) {
        this.quiet = quiet;
    }

    public Integer getSteepnessDifficulty() {
        return steepness_difficulty;
    }

    public void setSteepnessDifficulty(Integer steepness_difficulty) { this.steepness_difficulty = steepness_difficulty; }

    public String getRoundTrip() {
        return round_trip;
    }

    public void setRoundTrip(String round_trip) {
        this.round_trip = round_trip;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getSeed() {
        return seed;
    }

    public void setSeed(Integer seed) {
        this.seed = seed;
    }

    public String getVehicleType() {
        return vehicle_type;
    }

    public void setVehicleType(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public List<Integer> getSkipSegments() {
        return skip_segments;
    }

    public void setSkipSegments(List<Integer> skip_segments) {
        this.skip_segments = skip_segments;
    }

    public Boolean isSuppressWarnings() {
        return suppress_warnings;
    }

    public void setSuppressWarnings(Boolean suppress_warnings) {
        this.suppress_warnings = suppress_warnings;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Boolean isRoundaboutExits() {
        return roundabout_exits;
    }

    public void setRoundaboutExits(Boolean roundabout_exits) {
        this.roundabout_exits = roundabout_exits;
    }

    public Integer getMaximumSpeed() {
        return maximum_speed;
    }

    public void setMaximumSpeed(Integer maximum_speed) {
        this.maximum_speed = maximum_speed;
    }

    public Boolean isGeometry() {
        return geometry;
    }

    public void setGeometry(Boolean geometry) {
        this.geometry = geometry;
    }
}
