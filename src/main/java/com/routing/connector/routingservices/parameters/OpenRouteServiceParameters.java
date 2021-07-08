package com.routing.connector.routingservices.parameters;

import com.routing.connector.models.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class OpenRouteServiceParameters {

    //required
    private List<double[]> coordinates = new ArrayList<>();
    private String alternative_routes = "";
        private float share_factor;
        private Integer target_count;
        private float weight_factor;
    private List<String> attributes = new ArrayList<>();

    private List<float[]> bearings = new ArrayList<>();
    private boolean continue_straight = false;
    private boolean elevation = false;
    private List<String> extra_info = new ArrayList<>();
    private boolean geometry_simplify = false;
    private String id = "";
    private boolean instructions = true;
    private String instructions_format = "text";
    private String language = "en";
    private boolean maneuvers = false;
    private String options = "";
        private String avoid_borders = "controlled";
        private List<Integer> avoid_countries = new ArrayList<>();
        private List<String> avoid_features = new ArrayList<>();
        private String avoid_polygons = "";
        private String profile_params = "";
            private String restrictions = "";
                private float axleload;
                private boolean hazmat = false;
                private float height;
                private float length;
                private Integer maximum_incline = 6;
                private float maximum_sloped_kerb = 0.6f;
                private float minimum_width;
                private String smoothness_type = "good";
                private String surface_type = "cobblestone:flattened";
                private String track_type = "grade1";
                private float weight;
                private float width;
            private String weightings = "";
                private float green;
                private float quiet;
                private Integer steepness_difficulty;
        private String round_trip = "";
            //private float length;
            private Integer points;
            private Integer seed;
        private String vehicle_type = "hgv";
    private String preference = "recommended";
    private boolean roundabout_exits = false;
    private List<Integer> skip_segments = new ArrayList<>();
    private boolean suppress_warnings = false;
    private String units = "m";
    private boolean geometry = true;
    private Integer maximum_speed = 130;

    public OpenRouteServiceParameters(List<Coordinate> coordinates) {
        for (Coordinate coo : coordinates) {
            this.addCoordinate(coo);
        }
    }

    public String toJson() {
        return "{\"coordinates\":[[8.681495,49.41461],[8.686507,49.41943],[8.687872,49.420318]]}";
    }

    public void addCoordinate(Coordinate coordinate) {
        double[] newCoordinate = new double[]{coordinate.getLatitude(), coordinate.getLongitude()};
        coordinates.add(newCoordinate);
    }

    public List<double[]> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<double[]> coordinates) {
        this.coordinates = coordinates;
    }

    public String getAlternativeRoutes() {
        return alternative_routes;
    }

    public void setAlternativeRoutes(String alternative_routes) {
        this.alternative_routes = alternative_routes;
    }

    public float getShareFactor() {
        return share_factor;
    }

    public void setShareFactor(Integer share_factor) {
        this.share_factor = share_factor;
    }

    public Integer getTargetCount() {
        return target_count;
    }

    public void setTargetCount(Integer target_count) {
        this.target_count = target_count;
    }

    public float getWeightFactor() {
        return weight_factor;
    }

    public void setWeightFactor(float weight_factor) {
        this.weight_factor = weight_factor;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public List<float[]> getBearings() {
        return bearings;
    }

    public void setBearings(List<float[]> bearings) {
        this.bearings = bearings;
    }

    public boolean isContinueStraight() {
        return continue_straight;
    }

    public void setContinueStraight(boolean continue_straight) {
        this.continue_straight = continue_straight;
    }

    public boolean isElevation() {
        return elevation;
    }

    public void setElevation(boolean elevation) {
        this.elevation = elevation;
    }

    public List<String> getExtraInfo() {
        return extra_info;
    }

    public void setExtraInfo(List<String> extra_info) {
        this.extra_info = extra_info;
    }

    public boolean isGeometrySimplify() {
        return geometry_simplify;
    }

    public void setGeometrySimplify(boolean geometry_simplify) {
        this.geometry_simplify = geometry_simplify;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isInstructions() {
        return instructions;
    }

    public void setInstructions(boolean instructions) {
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

    public boolean isManeuvers() {
        return maneuvers;
    }

    public void setManeuvers(boolean maneuvers) {
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

    public float getAxleload() {
        return axleload;
    }

    public void setAxleload(float axleload) {
        this.axleload = axleload;
    }

    public boolean isHazmat() {
        return hazmat;
    }

    public void setHazmat(boolean hazmat) {
        this.hazmat = hazmat;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public Integer getMaximumIncline() {
        return maximum_incline;
    }

    public void setMaximumIncline(Integer maximum_incline) {
        this.maximum_incline = maximum_incline;
    }

    public float getMaximumSlopedKerb() {
        return maximum_sloped_kerb;
    }

    public void setMaximumSlopedKerb(float maximum_sloped_kerb) {
        this.maximum_sloped_kerb = maximum_sloped_kerb;
    }

    public float getMinimumWidth() {
        return minimum_width;
    }

    public void setMinimumWidth(float minimum_width) {
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public String getWeightings() {
        return weightings;
    }

    public void setWeightings(String weightings) {
        this.weightings = weightings;
    }

    public float getGreen() {
        return green;
    }

    public void setGreen(float green) {
        this.green = green;
    }

    public float getQuiet() {
        return quiet;
    }

    public void setQuiet(float quiet) {
        this.quiet = quiet;
    }

    public Integer getSteepnessDifficulty() {
        return steepness_difficulty;
    }

    public void setSteepnessDifficulty(Integer steepness_difficulty) {
        this.steepness_difficulty = steepness_difficulty;
    }

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

    public boolean isSuppressWarnings() {
        return suppress_warnings;
    }

    public void setSuppressWarnings(boolean suppress_warnings) {
        this.suppress_warnings = suppress_warnings;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public boolean isRoundaboutExits() {
        return roundabout_exits;
    }

    public void setRoundaboutExits(boolean roundabout_exits) {
        this.roundabout_exits = roundabout_exits;
    }

    public Integer getMaximumSpeed() {
        return maximum_speed;
    }

    public void setMaximumSpeed(Integer maximum_speed) {
        this.maximum_speed = maximum_speed;
    }

    public boolean isGeometry() {
        return geometry;
    }

    public void setGeometry(boolean geometry) {
        this.geometry = geometry;
    }
}
