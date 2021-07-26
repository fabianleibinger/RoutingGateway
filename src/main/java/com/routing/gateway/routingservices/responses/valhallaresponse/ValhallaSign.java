package com.routing.gateway.routingservices.responses.valhallaresponse;

import java.util.ArrayList;
import java.util.List;

public class ValhallaSign {
    private List<ValhallaSignElement> exit_number_elements;
    private List<ValhallaSignElement> exit_branch_elements;
    private List<ValhallaSignElement> exit_toward_elements;
    private List<ValhallaSignElement> exit_name_elements;

    public List<ValhallaSignElement> getExit_number_elements() {
        if (this.exit_number_elements == null) {
            this.exit_number_elements = new ArrayList<>();
        }
        return exit_number_elements;
    }

    public void setExit_number_elements(List<ValhallaSignElement> exit_number_elements) {
        this.exit_number_elements = exit_number_elements;
    }

    public List<ValhallaSignElement> getExit_branch_elements() {
        if (this.exit_branch_elements == null) {
            this.exit_branch_elements = new ArrayList<>();
        }
        return exit_branch_elements;
    }

    public void setExit_branch_elements(List<ValhallaSignElement> exit_branch_elements) {
        this.exit_branch_elements = exit_branch_elements;
    }

    public List<ValhallaSignElement> getExit_toward_elements() {
        if (this.exit_toward_elements == null) {
            this.exit_toward_elements = new ArrayList<>();
        }
        return exit_toward_elements;
    }

    public void setExit_toward_elements(List<ValhallaSignElement> exit_toward_elements) {
        this.exit_toward_elements = exit_toward_elements;
    }

    public List<ValhallaSignElement> getExit_name_elements() {
        if (this.exit_name_elements == null) {
            this.exit_name_elements = new ArrayList<>();
        }
        return exit_name_elements;
    }

    public void setExit_name_elements(List<ValhallaSignElement> exit_name_elements) {
        this.exit_name_elements = exit_name_elements;
    }
}
