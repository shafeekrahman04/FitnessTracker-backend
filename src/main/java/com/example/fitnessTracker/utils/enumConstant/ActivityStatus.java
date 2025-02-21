package com.example.fitnessTracker.utils.enumConstant;

public enum ActivityStatus {

    IN_ACTIVE("1", "In Active"),
    ACTIVE("2", "Active"),
    COMPLETED("3", "Completed");

    private String status;
    private String display;

    ActivityStatus(String status, String display) {
        this.status = status;
        this.display = display;
    }

    public String getStatus() {
        return status;
    }

    public String getDisplay() {
        return display;
    }

    public static ActivityStatus statusMatch(String status) {

        for (ActivityStatus ynStatus : ActivityStatus.values()) {
            if (ynStatus.getStatus().equalsIgnoreCase(status)) {
                return ynStatus;
            }
        }
        return IN_ACTIVE;
    }
}
