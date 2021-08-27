package com.routinggateway.clients.travelinformationapp.mappings.nominhelpers;

import java.util.List;

public class ListHelper {
    /**
     * Adds goal to output if a pattern is found in the list.
     *
     * @param list
     * @param output
     * @param pattern
     * @param goal
     * @return output
     */
    public static String searchForPatternToAddGoal(List<String> list, String output, String pattern, String goal) {
        if (list.stream().anyMatch(s -> s.equals(pattern))) {
            output += goal;
        }
        return output;
    }
}
