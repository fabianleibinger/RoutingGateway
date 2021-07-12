package com.routing.connector.routingservices.parameters.OpenTripPlannerParameters;

import com.routing.connector.routingservices.parameters.QueryStringParameters;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Parameters for OpenTripPlanner.
 */
public class OpenTripPlannerParameters extends QueryStringParameters {
    private Integer alightSlack;
    private Boolean arriveBy;
    private String bannedAgencies;
    private String bannedRoutes;
    private String bannedStops;
    private String bannedStopsHard;
    private String bannedTrips;
    private Boolean batch;
    private Integer bikeBoardCost;
    private Double bikeSpeed;
    private Integer bikeSwitchCost;
    private Integer bikeSwitchTime;
    private Integer boardSlack;
    private Long clampInitialWait;
    private String date;
    private Boolean disableRemainingWeightHeuristic;
    private String fromPlace;
    private Boolean ignoreRealtimeUpdates;
    private String intermediatePlaces;
    private String locale;
    private String maxHours;
    private Integer maxPreTransitTime;
    private Integer maxTransfers;
    private Double maxWalkDistance;
    private Integer minTransferTime;
    private String mode;
    private Integer nonpreferredTransferPenalty;
    private Integer numItineraries;
    private String optimize;
    private Integer otherThanPreferredRoutesPenalty;
    private String preferredAgencies;
    private String preferredRoutes;
    private Boolean reverseOptimizeOnTheFly;
    private String showIntermediateStops;
    private String startTransitStopId;
    private String startTransitTripId;
    private String time;
    private String toPlace;
    private Integer transferPenalty;
    private Double triangleSafetyFactor;
    private Double triangleSlopeFactor;
    private Double triangleTimeFactor;
    private String unpreferredAgencies;
    private String unpreferredRoutes;
    private Double waitAtBeginningFactor;
    private Double waitReluctance;
    private Integer walkBoardCost;
    private Double walkReluctance;
    private Double walkSpeed;
    private Double wheelchair;

    @Override
    public Map<String, String> toStringKeyValueMap() {
        Map<String, String> keyValueMap = new HashMap<>();

        keyValueMap.put("alightSlack", toString(alightSlack));
        keyValueMap.put("arriveBy", toString(arriveBy));
        keyValueMap.put("bannedAgencies", bannedAgencies);
        keyValueMap.put("bannedRoutes", bannedRoutes);
        keyValueMap.put("bannedStopsHard", bannedStopsHard);
        keyValueMap.put("bannedTrips", bannedTrips);
        keyValueMap.put("batch", toString(batch));
        keyValueMap.put("bikeBoardCost", toString(bikeBoardCost));
        keyValueMap.put("bikeSpeed", toString(bikeSpeed));
        keyValueMap.put("bikeSwitchCost", toString(bikeSwitchCost));
        keyValueMap.put("bikeSwitchTime", toString(bikeSwitchTime));
        keyValueMap.put("boardSlack", toString(boardSlack));
        keyValueMap.put("clampInitialWait", toString(clampInitialWait));
        keyValueMap.put("date", date);
        keyValueMap.put("disableRemainingWeightHeuristic", toString(disableRemainingWeightHeuristic));
        keyValueMap.put("fromPlace", fromPlace);
        keyValueMap.put("ignoreRealtimeUpdates", toString(ignoreRealtimeUpdates));
        keyValueMap.put("intermediatePlaces", intermediatePlaces);
        keyValueMap.put("locale", locale);
        keyValueMap.put("maxHours", maxHours);
        keyValueMap.put("maxPreTransitTime", toString(maxPreTransitTime));
        keyValueMap.put("maxTransfers", toString(maxTransfers));
        keyValueMap.put("maxWalkDistance", toString(maxWalkDistance));
        keyValueMap.put("minTransferTime", toString(minTransferTime));
        keyValueMap.put("mode", mode);
        keyValueMap.put("toPlace", toPlace);
        keyValueMap.put("nonpreferredTransferPenalty", toString(nonpreferredTransferPenalty));
        keyValueMap.put("numItineraries", toString(numItineraries));
        keyValueMap.put("otherThanPreferredRoutesPenalty", toString(otherThanPreferredRoutesPenalty));
        keyValueMap.put("preferredAgencies", preferredAgencies);
        keyValueMap.put("preferredRoutes", preferredRoutes);
        keyValueMap.put("reverseOptimizeOnTheFly", toString(reverseOptimizeOnTheFly));
        keyValueMap.put("showIntermediateStops", showIntermediateStops);
        keyValueMap.put("startTransitStopId", startTransitStopId);
        keyValueMap.put("time", time);
        keyValueMap.put("startTransitTripId", startTransitTripId);
        keyValueMap.put("transferPenalty", toString(transferPenalty));
        keyValueMap.put("optimize", optimize);
        keyValueMap.put("triangleSafetyFactor", toString(triangleSafetyFactor));
        keyValueMap.put("triangleSlopeFactor", toString(triangleSlopeFactor));
        keyValueMap.put("triangleTimeFactor", toString(triangleTimeFactor));
        keyValueMap.put("unpreferredAgencies", unpreferredAgencies);
        keyValueMap.put("unpreferredRoutes", unpreferredRoutes);
        keyValueMap.put("waitAtBeginningFactor", toString(waitAtBeginningFactor));
        keyValueMap.put("waitReluctance", toString(waitReluctance));
        keyValueMap.put("walkBoardCost", toString(walkBoardCost));
        keyValueMap.put("walkReluctance", toString(walkReluctance));
        keyValueMap.put("walkSpeed", toString(walkSpeed));
        keyValueMap.put("wheelchair", toString(wheelchair));

        return keyValueMap.entrySet().stream().filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(Entry<String, String>::getKey, Entry<String, String>::getValue));
    }


    public Integer getAlightSlack() {
        return alightSlack;
    }

    public void setAlightSlack(Integer alightSlack) {
        this.alightSlack = alightSlack;
    }

    public Boolean getArriveBy() {
        return arriveBy;
    }

    public void setArriveBy(Boolean arriveBy) {
        this.arriveBy = arriveBy;
    }

    public String getBannedAgencies() {
        return bannedAgencies;
    }

    public void setBannedAgencies(String bannedAgencies) {
        this.bannedAgencies = bannedAgencies;
    }

    public String getBannedRoutes() {
        return bannedRoutes;
    }

    public void setBannedRoutes(String bannedRoutes) {
        this.bannedRoutes = bannedRoutes;
    }

    public String getBannedStops() {
        return bannedStops;
    }

    public void setBannedStops(String bannedStops) {
        this.bannedStops = bannedStops;
    }

    public String getBannedStopsHard() {
        return bannedStopsHard;
    }

    public void setBannedStopsHard(String bannedStopsHard) {
        this.bannedStopsHard = bannedStopsHard;
    }

    public String getBannedTrips() {
        return bannedTrips;
    }

    public void setBannedTrips(String bannedTrips) {
        this.bannedTrips = bannedTrips;
    }

    public Boolean getBatch() {
        return batch;
    }

    public void setBatch(Boolean batch) {
        this.batch = batch;
    }

    public Integer getBikeBoardCost() {
        return bikeBoardCost;
    }

    public void setBikeBoardCost(Integer bikeBoardCost) {
        this.bikeBoardCost = bikeBoardCost;
    }

    public Double getBikeSpeed() {
        return bikeSpeed;
    }

    public void setBikeSpeed(Double bikeSpeed) {
        this.bikeSpeed = bikeSpeed;
    }

    public Integer getBikeSwitchCost() {
        return bikeSwitchCost;
    }

    public void setBikeSwitchCost(Integer bikeSwitchCost) {
        this.bikeSwitchCost = bikeSwitchCost;
    }

    public Integer getBikeSwitchTime() {
        return bikeSwitchTime;
    }

    public void setBikeSwitchTime(Integer bikeSwitchTime) {
        this.bikeSwitchTime = bikeSwitchTime;
    }

    public Integer getBoardSlack() {
        return boardSlack;
    }

    public void setBoardSlack(Integer boardSlack) {
        this.boardSlack = boardSlack;
    }

    public Long getClampInitialWait() {
        return clampInitialWait;
    }

    public void setClampInitialWait(Long clampInitialWait) {
        this.clampInitialWait = clampInitialWait;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getDisableRemainingWeightHeuristic() {
        return disableRemainingWeightHeuristic;
    }

    public void setDisableRemainingWeightHeuristic(Boolean disableRemainingWeightHeuristic) {
        this.disableRemainingWeightHeuristic = disableRemainingWeightHeuristic;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public Boolean getIgnoreRealtimeUpdates() {
        return ignoreRealtimeUpdates;
    }

    public void setIgnoreRealtimeUpdates(Boolean ignoreRealtimeUpdates) {
        this.ignoreRealtimeUpdates = ignoreRealtimeUpdates;
    }

    public String getIntermediatePlaces() {
        return intermediatePlaces;
    }

    public void setIntermediatePlaces(String intermediatePlaces) {
        this.intermediatePlaces = intermediatePlaces;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getMaxHours() {
        return maxHours;
    }

    public void setMaxHours(String maxHours) {
        this.maxHours = maxHours;
    }

    public Integer getMaxPreTransitTime() {
        return maxPreTransitTime;
    }

    public void setMaxPreTransitTime(Integer maxPreTransitTime) {
        this.maxPreTransitTime = maxPreTransitTime;
    }

    public Integer getMaxTransfers() {
        return maxTransfers;
    }

    public void setMaxTransfers(Integer maxTransfers) {
        this.maxTransfers = maxTransfers;
    }

    public Double getMaxWalkDistance() {
        return maxWalkDistance;
    }

    public void setMaxWalkDistance(Double maxWalkDistance) {
        this.maxWalkDistance = maxWalkDistance;
    }

    public Integer getMinTransferTime() {
        return minTransferTime;
    }

    public void setMinTransferTime(Integer minTransferTime) {
        this.minTransferTime = minTransferTime;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getNonpreferredTransferPenalty() {
        return nonpreferredTransferPenalty;
    }

    public void setNonpreferredTransferPenalty(Integer nonpreferredTransferPenalty) {
        this.nonpreferredTransferPenalty = nonpreferredTransferPenalty;
    }

    public Integer getNumItineraries() {
        return numItineraries;
    }

    public void setNumItineraries(Integer numItineraries) {
        this.numItineraries = numItineraries;
    }

    public String getOptimize() {
        return optimize;
    }

    public void setOptimize(String optimize) {
        this.optimize = optimize;
    }

    public Integer getOtherThanPreferredRoutesPenalty() {
        return otherThanPreferredRoutesPenalty;
    }

    public void setOtherThanPreferredRoutesPenalty(Integer otherThanPreferredRoutesPenalty) {
        this.otherThanPreferredRoutesPenalty = otherThanPreferredRoutesPenalty;
    }

    public String getPreferredAgencies() {
        return preferredAgencies;
    }

    public void setPreferredAgencies(String preferredAgencies) {
        this.preferredAgencies = preferredAgencies;
    }

    public String getPreferredRoutes() {
        return preferredRoutes;
    }

    public void setPreferredRoutes(String preferredRoutes) {
        this.preferredRoutes = preferredRoutes;
    }

    public Boolean getReverseOptimizeOnTheFly() {
        return reverseOptimizeOnTheFly;
    }

    public void setReverseOptimizeOnTheFly(Boolean reverseOptimizeOnTheFly) {
        this.reverseOptimizeOnTheFly = reverseOptimizeOnTheFly;
    }

    public String getShowIntermediateStops() {
        return showIntermediateStops;
    }

    public void setShowIntermediateStops(String showIntermediateStops) {
        this.showIntermediateStops = showIntermediateStops;
    }

    public String getStartTransitStopId() {
        return startTransitStopId;
    }

    public void setStartTransitStopId(String startTransitStopId) {
        this.startTransitStopId = startTransitStopId;
    }

    public String getStartTransitTripId() {
        return startTransitTripId;
    }

    public void setStartTransitTripId(String startTransitTripId) {
        this.startTransitTripId = startTransitTripId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public Integer getTransferPenalty() {
        return transferPenalty;
    }

    public void setTransferPenalty(Integer transferPenalty) {
        this.transferPenalty = transferPenalty;
    }

    public Double getTriangleSafetyFactor() {
        return triangleSafetyFactor;
    }

    public void setTriangleSafetyFactor(Double triangleSafetyFactor) {
        this.triangleSafetyFactor = triangleSafetyFactor;
    }

    public Double getTriangleSlopeFactor() {
        return triangleSlopeFactor;
    }

    public void setTriangleSlopeFactor(Double triangleSlopeFactor) {
        this.triangleSlopeFactor = triangleSlopeFactor;
    }

    public Double getTriangleTimeFactor() {
        return triangleTimeFactor;
    }

    public void setTriangleTimeFactor(Double triangleTimeFactor) {
        this.triangleTimeFactor = triangleTimeFactor;
    }

    public String getUnpreferredAgencies() {
        return unpreferredAgencies;
    }

    public void setUnpreferredAgencies(String unpreferredAgencies) {
        this.unpreferredAgencies = unpreferredAgencies;
    }

    public String getUnpreferredRoutes() {
        return unpreferredRoutes;
    }

    public void setUnpreferredRoutes(String unpreferredRoutes) {
        this.unpreferredRoutes = unpreferredRoutes;
    }

    public Double getWaitAtBeginningFactor() {
        return waitAtBeginningFactor;
    }

    public void setWaitAtBeginningFactor(Double waitAtBeginningFactor) {
        this.waitAtBeginningFactor = waitAtBeginningFactor;
    }

    public Double getWaitReluctance() {
        return waitReluctance;
    }

    public void setWaitReluctance(Double waitReluctance) {
        this.waitReluctance = waitReluctance;
    }

    public Integer getWalkBoardCost() {
        return walkBoardCost;
    }

    public void setWalkBoardCost(Integer walkBoardCost) {
        this.walkBoardCost = walkBoardCost;
    }

    public Double getWalkReluctance() {
        return walkReluctance;
    }

    public void setWalkReluctance(Double walkReluctance) {
        this.walkReluctance = walkReluctance;
    }

    public Double getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(Double walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public Double getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(Double wheelchair) {
        this.wheelchair = wheelchair;
    }
}
