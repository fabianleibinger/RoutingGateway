package com.routinggateway.clients.travelinformationapp.mappings.nominhelpers;

import com.routinggateway.clients.travelinformationapp.controller.models.preferences.ModePreferences;

import java.util.List;

public class HelperRoutingRequestToOpenTripPlannerParameters {
    public static String toModes(ModePreferences modePreferences) {
        String modes = "";
        modes = searchListForPatterns(modePreferences.getPreferredModes(), modes);
        if (modes.isEmpty()) {
            searchListForPatterns(modePreferences.getNeutralModes(), modes);
        }
        return modes;
    }

    /**
     * Adds to [output] if patterns are found in [list].
     *
     * @param list
     * @param output
     * @return output
     */
    private static String searchListForPatterns(List<String> list, String output) {
        output = searchForPatternToAddGoal(list, output, "Bikesharing", "BIKE_RENTAL, ");
        output = searchForPatternToAddGoal(list, output, "walk", "WALK, ");
        output = searchForPatternToAddGoal(list, output, "bike", "BIKE, BIKE_TO_PARK, ");
        output = searchForPatternToAddGoal(list, output, "public transport", "FLEXIBLE, ");
        output = searchForPatternToAddGoal(list, output, "car", "CAR, CAR_TO_PARK, ");
        output = searchForPatternToAddGoal(list, output, "carsharing", "CAR_PICKUP, ");
        return output;
    }

    /**
     * Adds goal to output if a pattern is found in the list.
     *
     * @param list
     * @param output
     * @param pattern
     * @param goal
     * @return output
     */
    private static String searchForPatternToAddGoal(List<String> list, String output, String pattern, String goal) {
        if (list.stream().anyMatch(s -> s.equals(pattern))) {
            output += goal;
        }
        return output;
    }
}
