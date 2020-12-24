package TipCalculator;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class TipCalculatorController {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent=NumberFormat.getPercentInstance();
    private BigDecimal tipPercentage = new BigDecimal(0.15);//default value

    @FXML
    private Label amountLabel;

    @FXML
    private Label tipLabel;

    @FXML
    private Label tipPercentageLabel;

    @FXML
    private Label totalLabel;

    @FXML
    private Button calculateButton;

    @FXML
    private ScrollBar tipPercentageSlider;

    @FXML
    private TextField amountTexField;

    @FXML
    private TextField tipTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private Label peopleLabel;

    @FXML
    private Label amountEachLabel;

    @FXML
    private TextField peopleTextField;

    @FXML
    private TextField amountEachTextField;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try{

            BigDecimal amount = new BigDecimal(amountTexField.getText());
            BigDecimal tip= amount.multiply(tipPercentage);
            BigDecimal total=amount.add(tip);

            tipTextField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));

        }catch (NumberFormatException ex){
            amountTexField.setText("Enter the amount");
            amountTexField.selectAll();
            amountTexField.requestFocus();
        }

    }

    public void initialize(){

        currency.setRoundingMode(RoundingMode.HALF_UP);
        tipPercentageSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
                tipPercentageLabel.setText(percent.format(tipPercentage));
            }
        });
    }

}
