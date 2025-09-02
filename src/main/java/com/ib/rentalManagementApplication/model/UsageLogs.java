package com.ib.rentalManagementApplication.model;

import java.util.Date;

public class UsageLogs {
    private Date startDate;
    private Date endDate;
    private double kilometersDriven;

    public UsageLogs(Date startDate, Date endDate, double kilometersDriven) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.kilometersDriven = kilometersDriven;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getKilometersDriven() {
        return kilometersDriven;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setKilometersDriven(double kilometersDriven) {
        this.kilometersDriven = kilometersDriven;
    }

    // Overridden function to display object information in custom format
    @Override
    public String toString() {
        return "Start Date: " + getStartDate() + " , End Date: " + getEndDate()
                + " , Kilometer Driven: " + getKilometersDriven();
    }
}
