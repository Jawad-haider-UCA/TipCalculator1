package EnhancedTipCalculator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class EnchancedTipCalculatorController {

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent=NumberFormat.getPercentInstance();
    private BigDecimal tipPercentage = new BigDecimal(0.15);//default value

    @FXML
    private Button calculateButton;

    @FXML
    private Label totalLabel;

    @FXML
    private Label tipLabel;

    @FXML
    private Label tipPercentageLabel;

    @FXML
    private Label amountLabel;

    @FXML
    private Slider tipPercentageSlider;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField tipPercentageTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private Label peopleLabel;

    @FXML
    private TextField peopleTextField;

    @FXML
    private TextField amountEachTextField;

    @FXML
    private Label amountEachLabel;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try{

            BigDecimal amount = new BigDecimal(amountTextField.getText());
            BigDecimal people = new BigDecimal(peopleTextField.getText());

            BigDecimal tip= amount.multiply(tipPercentage);
            BigDecimal total=amount.add(tip);
            BigDecimal amountEach=total.divide(people);

            tipPercentageTextField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));
            amountEachTextField.setText(currency.format(amountEach));

        }catch (NumberFormatException ex){
            amountTextField.setText("Enter the amount");
            amountTextField.selectAll();
            amountTextField.requestFocus();
        }

    }
    public void initialize(){
        currency.setRoundingMode(RoundingMode.HALF_UP);

        tipPercentageSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
                tipPercentageLabel.setText(percent.format(tipPercentage));
                amountEachLabel.setText(percent.format(amountEachLabel));
            }
        });
    }

}
