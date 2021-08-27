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
        output = ListHelper.searchForPatternToAddGoal(list, output, "Bikesharing", "BIKE_RENTAL, ");
        output = ListHelper.searchForPatternToAddGoal(list, output, "walk", "WALK, ");
        output = ListHelper.searchForPatternToAddGoal(list, output, "bike", "BIKE, BIKE_TO_PARK, ");
        output = ListHelper.searchForPatternToAddGoal(list, output, "public transport", "FLEXIBLE, ");
        output = ListHelper.searchForPatternToAddGoal(list, output, "car", "CAR, CAR_TO_PARK, ");
        output = ListHelper.searchForPatternToAddGoal(list, output, "carsharing", "CAR_PICKUP, ");
        return output;
    }
}
