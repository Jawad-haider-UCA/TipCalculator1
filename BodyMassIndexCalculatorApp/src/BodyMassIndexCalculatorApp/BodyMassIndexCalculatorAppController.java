package BodyMassIndexCalculatorApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BodyMassIndexCalculatorAppController implements Initializable {

    @FXML
    private Button calculateButton;

    @FXML
    private Label heightLabel;

    @FXML
    private Label weightLabel;

    @FXML
    private Label matricUnitsLabel;

    @FXML
    private Label englishUnitsLabel;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField matricUnitsTextField;

    @FXML
    private TextField englishUnitsTextField;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try {
            Double w = new Double(weightTextField.getText());
            Double h = new Double(heightTextField.getText());
            Double bmiKG;
            Double bmiLbs;
            bmiKG = w / (h * h);
            matricUnitsTextField.setText(String.format("%.2f", bmiKG));
            bmiLbs=(w*703.0)/(h*h);
            englishUnitsTextField.setText(String.format("%.2f",bmiLbs));

        }
        catch (NumberFormatException nf) {
            weightTextField.setText("Enter valid value");
            weightTextField.selectAll();
            weightTextField.requestFocus();
            heightTextField.setText("Enter valid value");
            heightTextField.selectAll();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

