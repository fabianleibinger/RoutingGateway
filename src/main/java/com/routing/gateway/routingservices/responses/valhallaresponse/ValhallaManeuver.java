package com.routing.gateway.routingservices.responses.valhallaresponse;

import java.util.ArrayList;
import java.util.List;

public class ValhallaManeuver {
    private String type;
    private String instruction;
    private String verbal_transition_alert_instruction;
    private String verbal_pre_transition_instruction;
    private String verbal_post_transition_instruction;
    private List<String> street_names;
    private List<String> begin_street_names;
    private Integer time;
    private Double length;
    private Integer begin_shape_index;
    private Integer end_shape_index;
    private Boolean toll;
    private Boolean rough;
    private Boolean gate;
    private Boolean ferry;
    private ValhallaSign sign;
    private Integer roundabout_exit_count;
    private String depart_instruction;
    private String verbal_depart_instruction;
    private String arrive_instruction;
    private String verbal_arrive_instruction;
    private ValhallaTransitInfo transit_info;
    private Boolean verbal_multi_cue;
    private String travel_mode;
    private String travel_type;
    private String bss_maneuver_type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getVerbal_transition_alert_instruction() {
        return verbal_transition_alert_instruction;
    }

    public void setVerbal_transition_alert_instruction(String verbal_transition_alert_instruction) {
        this.verbal_transition_alert_instruction = verbal_transition_alert_instruction;
    }

    public String getVerbal_pre_transition_instruction() {
        return verbal_pre_transition_instruction;
    }

    public void setVerbal_pre_transition_instruction(String verbal_pre_transition_instruction) {
        this.verbal_pre_transition_instruction = verbal_pre_transition_instruction;
    }

    public String getVerbal_post_transition_instruction() {
        return verbal_post_transition_instruction;
    }

    public void setVerbal_post_transition_instruction(String verbal_post_transition_instruction) {
        this.verbal_post_transition_instruction = verbal_post_transition_instruction;
    }

    public List<String> getStreet_names() {
        if (this.street_names == null) {
            this.street_names = new ArrayList<>();
        }
        return street_names;
    }

    public void setStreet_names(List<String> street_names) {
        this.street_names = street_names;
    }

    public List<String> getBegin_street_names() {
        if (this.begin_street_names == null) {
            this.begin_street_names = new ArrayList<>();
        }
        return begin_street_names;
    }

    public void setBegin_street_names(List<String> begin_street_names) {
        this.begin_street_names = begin_street_names;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getBegin_shape_index() {
        return begin_shape_index;
    }

    public void setBegin_shape_index(Integer begin_shape_index) {
        this.begin_shape_index = begin_shape_index;
    }

    public Integer getEnd_shape_index() {
        return end_shape_index;
    }

    public void setEnd_shape_index(Integer end_shape_index) {
        this.end_shape_index = end_shape_index;
    }

    public Boolean getToll() {
        return toll;
    }

    public void setToll(Boolean toll) {
        this.toll = toll;
    }

    public Boolean getRough() {
        return rough;
    }

    public void setRough(Boolean rough) {
        this.rough = rough;
    }

    public Boolean getGate() {
        return gate;
    }

    public void setGate(Boolean gate) {
        this.gate = gate;
    }

    public Boolean getFerry() {
        return ferry;
    }

    public void setFerry(Boolean ferry) {
        this.ferry = ferry;
    }

    public ValhallaSign getSign() {
        if (this.sign == null) {
            this.sign = new ValhallaSign();
        }
        return sign;
    }

    public void setSign(ValhallaSign sign) {
        this.sign = sign;
    }

    public Integer getRoundabout_exit_count() {
        return roundabout_exit_count;
    }

    public void setRoundabout_exit_count(Integer roundabout_exit_count) {
        this.roundabout_exit_count = roundabout_exit_count;
    }

    public String getDepart_instruction() {
        return depart_instruction;
    }

    public void setDepart_instruction(String depart_instruction) {
        this.depart_instruction = depart_instruction;
    }

    public String getVerbal_depart_instruction() {
        return verbal_depart_instruction;
    }

    public void setVerbal_depart_instruction(String verbal_depart_instruction) {
        this.verbal_depart_instruction = verbal_depart_instruction;
    }

    public String getArrive_instruction() {
        return arrive_instruction;
    }

    public void setArrive_instruction(String arrive_instruction) {
        this.arrive_instruction = arrive_instruction;
    }

    public String getVerbal_arrive_instruction() {
        return verbal_arrive_instruction;
    }

    public void setVerbal_arrive_instruction(String verbal_arrive_instruction) {
        this.verbal_arrive_instruction = verbal_arrive_instruction;
    }

    public ValhallaTransitInfo getTransit_info() {
        if (this.transit_info == null) {
            this.transit_info = new ValhallaTransitInfo();
        }
        return transit_info;
    }

    public void setTransit_info(ValhallaTransitInfo transit_info) {
        this.transit_info = transit_info;
    }

    public Boolean getVerbal_multi_cue() {
        return verbal_multi_cue;
    }

    public void setVerbal_multi_cue(Boolean verbal_multi_cue) {
        this.verbal_multi_cue = verbal_multi_cue;
    }

    public String getTravel_mode() {
        return travel_mode;
    }

    public void setTravel_mode(String travel_mode) {
        this.travel_mode = travel_mode;
    }

    public String getTravel_type() {
        return travel_type;
    }

    public void setTravel_type(String travel_type) {
        this.travel_type = travel_type;
    }

    public String getBss_maneuver_type() {
        return bss_maneuver_type;
    }

    public void setBss_maneuver_type(String bss_maneuver_type) {
        this.bss_maneuver_type = bss_maneuver_type;
    }
}
