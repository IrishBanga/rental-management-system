package com.ib.rentalManagementApplication.controller;

import com.ib.rentalManagementApplication.model.MaintenanceRecords;
import com.ib.rentalManagementApplication.model.UsageLogs;
import com.ib.rentalManagementApplication.model.VehicleDetails;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class VehicleRecordsController {
    @FXML // fx:id="categoryCombobox"
    private ComboBox<String> categoryCombobox; // Value injected by FXMLLoader

    @FXML // fx:id="kilometersDrivenField"
    private TextField kilometersDrivenField; // Value injected by FXMLLoader

    @FXML // fx:id="serviceCost"
    private TextField serviceCostField; // Value injected by FXMLLoader

    @FXML // fx:id="serviceDate"
    private DatePicker serviceDateDatePicker; // Value injected by FXMLLoader

    @FXML // fx:id="serviceDescription"
    private TextField serviceDescriptionField; // Value injected by FXMLLoader

    @FXML // fx:id="summaryTab"
    private Tab summaryTab; // Value injected by FXMLLoader

    @FXML // fx:id="tabPane"
    private TabPane tabPane; // Value injected by FXMLLoader

    @FXML // fx:id="textAreaSummaryTab"
    private TextArea textAreaSummaryTab; // Value injected by FXMLLoader

    @FXML // fx:id="usageEndDateDatePicker"
    private DatePicker usageEndDateDatePicker; // Value injected by FXMLLoader

    @FXML // fx:id="usageStartDateDatePicker"
    private DatePicker usageStartDateDatePicker; // Value injected by FXMLLoader

    @FXML // fx:id="vehicleMakeField"
    private TextField vehicleMakeField; // Value injected by FXMLLoader

    @FXML // fx:id="vehicleModelField"
    private TextField vehicleModelField; // Value injected by FXMLLoader

    @FXML // fx:id="vehicleTypeCombobox"
    private ComboBox<String> vehicleTypeCombobox; // Value injected by FXMLLoader

    @FXML // fx:id="vehicleYearField"
    private TextField vehicleYearField; // Value injected by FXMLLoader


    private final ArrayList<VehicleDetails> vehiclesList = new ArrayList<>();
    private final ArrayList<UsageLogs> usageLogsList = new ArrayList<>();
    private final ArrayList<MaintenanceRecords> maintenanceRecordsList = new ArrayList<>();

    private final ArrayList<String> vehicleTypes = new ArrayList<>(Arrays.asList("Gasoline", "Electric", "Hybrid"));
    private final ArrayList<String> categories = new ArrayList<>(Arrays.asList("Vehicle Info", "Usage Logs", "Maintenance Records"));

    public void initialize() {
        vehicleTypeCombobox.getItems().addAll(vehicleTypes);
        categoryCombobox.getItems().addAll(categories);

        categoryCombobox.setOnAction(event -> {
            if (categoryCombobox.getValue() != null) {
                StringBuilder text = new StringBuilder();
                switch (categoryCombobox.getValue()) {
                    case "Vehicle Info":
                        for (VehicleDetails vehicleDetails : vehiclesList) {
                            text.append(vehicleDetails.toString()).append("\n");
                        }
                        break;
                    case "Usage Logs":
                        for (UsageLogs usageLogs : usageLogsList) {
                            text.append(usageLogs.toString()).append("\n");
                        }
                        break;
                    case "Maintenance Records":
                        for (MaintenanceRecords maintenanceRecords : maintenanceRecordsList) {
                            text.append(maintenanceRecords.toString()).append("\n");
                        }
                        break;
                }
                textAreaSummaryTab.setText(text.toString());
            }
        });
    }

    @FXML
    void clearMaintenanceRecord(ActionEvent event) {
        serviceCostField.setText(null);
        serviceDateDatePicker.setValue(null);
        serviceDescriptionField.setText(null);
    }

    @FXML
    void clearUsageLog(ActionEvent event) {
        usageStartDateDatePicker.setValue(null);
        usageEndDateDatePicker.setValue(null);
        kilometersDrivenField.setText(null);
    }

    @FXML
    void clearVehicleDetails(ActionEvent event) {
        vehicleMakeField.setText(null);
        vehicleModelField.setText(null);
        vehicleTypeCombobox.setValue(null);
        vehicleYearField.setText(null);
    }

    // Helper function to show alerts to user
    private void showAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    void saveMaintenanceRecord(ActionEvent event) {
        if (!serviceDescriptionField.getText().isEmpty() && !serviceCostField.getText().isEmpty()
                && serviceDateDatePicker.getValue() != null) {
            double cost;
            try {
                cost = Double.parseDouble(serviceCostField.getText());
            } catch (NumberFormatException e) {
                showAlert("Please enter a valid number for the service cost.");
                serviceCostField.requestFocus();
                return;
            }
            maintenanceRecordsList.add(new MaintenanceRecords(
                    serviceDescriptionField.getText(), cost,
                    Date.from((serviceDateDatePicker.getValue()).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
            ));
        } else {
            // Show informative alerts to user
            if (serviceDescriptionField.getText().isEmpty()) {
                showAlert("Please enter a service description!");
                serviceDescriptionField.requestFocus();
            } else if (serviceCostField.getText().isEmpty()) {
                showAlert("Please enter a valid service cost!");
                serviceCostField.requestFocus();
            } else if (serviceDateDatePicker.getValue() == null) {
                showAlert("Please enter a valid service date!");
                serviceDateDatePicker.requestFocus();
            }
        }
    }

    @FXML
    void saveUsageLog(ActionEvent event) {
        if (usageStartDateDatePicker.getValue() != null
                && usageEndDateDatePicker.getValue() != null
                && !kilometersDrivenField.getText().isEmpty()
        ) {
            double kilometers;
            try {
                kilometers = Double.parseDouble(kilometersDrivenField.getText());
            } catch (NumberFormatException e) {
                showAlert("Please enter a valid number for the kilometers driven");
                kilometersDrivenField.requestFocus();
                return;
            }
            usageLogsList.add(new UsageLogs(
                    Date.from((usageStartDateDatePicker.getValue()).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                    Date.from((usageEndDateDatePicker.getValue()).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                    kilometers));
        } else {
            // Show informative alerts to user
            if (usageStartDateDatePicker.getValue() == null) {
                showAlert("Please enter a valid start date!");
                usageStartDateDatePicker.requestFocus();
            } else if (usageEndDateDatePicker.getValue() == null) {
                showAlert("Please enter a valid end date!");
                usageEndDateDatePicker.requestFocus();
            } else if (kilometersDrivenField.getText().isEmpty()) {
                showAlert("Please enter a valid kilometer metric!");
                kilometersDrivenField.requestFocus();
            }
        }
    }


    @FXML
    void saveVehicleDetails(ActionEvent event) {
        if (!vehicleMakeField.getText().isEmpty() && !vehicleModelField.getText().isEmpty() && vehicleTypeCombobox.getValue() != null
                && !vehicleYearField.getText().isEmpty()) {
            int year;
            try {
                year = Integer.parseInt(vehicleYearField.getText());
            } catch (NumberFormatException e) {
                showAlert("Please enter a valid number for the vehicle year.");
                vehicleYearField.requestFocus();
                return;
            }
            vehiclesList.add(new VehicleDetails(vehicleMakeField.getText(), vehicleModelField.getText(), vehicleTypeCombobox.getValue(),
                    year));
        } else {
            // Show informative alerts to user
            if (vehicleModelField.getText().isEmpty()) {
                showAlert("Please enter the vehicle model!");
                vehicleModelField.requestFocus();
            } else if (vehicleMakeField.getText().isEmpty()) {
                showAlert("Please enter the vehicle make!");
                vehicleMakeField.requestFocus();
            } else if (vehicleTypeCombobox.getValue() == null) {
                showAlert("Please select a vehicle type!");
                vehicleTypeCombobox.requestFocus();
            } else if (vehicleYearField.getText().isEmpty()) {
                showAlert("Please enter the vehicle year!");
                vehicleYearField.requestFocus();
            }
        }
    }

    @FXML
    void viewSummary(ActionEvent event) {
        tabPane.getSelectionModel().select(summaryTab);
        // Reset selection for category
        categoryCombobox.setValue(null);
        // Reset text area
        textAreaSummaryTab.setText(null);
    }

}
