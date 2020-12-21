package TargetedHeartRates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Double.*;

public class TargetedHeartRatesController implements Initializable {

    @FXML
    private Button calculateButton;

    @FXML
    private Label ageLabel;

    @FXML
    private Label maxHeartRateLabel;

    @FXML
    private Label tRangeLabel;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField maxHeartRateTextField;

    @FXML
    private TextField targetHeartRateRangeTextField;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try{
            Double maxHeartRate;
            //Double age= new Double(ageTextField.setText());
            Double age = new Double(ageTextField.getText());

            Double lowerRange;
            Double upperRange;
            maxHeartRate= 220-age;


            maxHeartRateTextField.setText(String.format("%.2f",maxHeartRate));
            lowerRange=0.5*maxHeartRate;
            upperRange=0.85*maxHeartRate;
            targetHeartRateRangeTextField.setText(String.format("%.2f-%.2f",lowerRange,upperRange));
        }
        catch (NumberFormatException nf){
//            weightTextField.setText("Enter valid value");
            ageTextField.setText("Enter a Valid age;)");
            ageTextField.selectAll();
            ageTextField.requestFocus();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
