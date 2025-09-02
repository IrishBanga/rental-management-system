package com.ib.rentalManagementApplication.model;

public class VehicleDetails {
    private String model;
    private String make;
    private String type;
    private int year;

    public VehicleDetails(String model, String make, String type, int year) {
        this.model = model;
        this.make = make;
        this.type = type;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Overridden function to display object information in custom format
    @Override
    public String toString() {
        return "Model: " + getModel() + ", Make: " + getMake() + ", Type: " + getType() + ", Year: " + getYear();
    }
}
