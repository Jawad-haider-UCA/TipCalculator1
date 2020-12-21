package Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    Float data = 0f;
    int operation = -1;

    @FXML   private Button nine;
    @FXML   private Button decimal;
    @FXML    private Button six;
    @FXML    private Button one;
    @FXML    private TextField display;
    @FXML    private Button clear;
    @FXML    private Button seven;
    @FXML    private Label label;
    @FXML    private Button two;
    @FXML    private Button three;
    @FXML    private Button SignChange;
    @FXML    private Button mod;
    @FXML    private Button plus;
    @FXML    private Button mul;
    @FXML    private Button eight;
    @FXML    private Button zero;
    @FXML    private Button div;
    @FXML    private Button four;
    @FXML    private Button equals;
    @FXML    private Button five;
    @FXML    private Button sub;
    @FXML   void handleButtonAction(ActionEvent event) {
        if (event.getSource() == one) {
            display.setText(display.getText() + "1");
        } else if (event.getSource() == two) {
            display.setText(display.getText() + "2");
        } else if (event.getSource() == three) {
            display.setText(display.getText() + "3");
        } else if (event.getSource() == four) {
            display.setText(display.getText() + "4");
        } else if (event.getSource() == five) {
            display.setText(display.getText() + "5");
        } else if (event.getSource() == six) {
            display.setText(display.getText() + "6");
        } else if (event.getSource() == seven) {
            display.setText(display.getText() + "7");
        } else if (event.getSource() == eight) {
            display.setText(display.getText() + "8");
        } else if (event.getSource() == nine) {
            display.setText(display.getText() + "9");
        } else if (event.getSource() == zero) {
            display.setText(display.getText() + "0");
        } else if (event.getSource() == clear) {
            display.setText("c");
        } else if (event.getSource() == plus) {
            data = Float.parseFloat(display.getText());
            operation = 1; //Addition
            display.setText("+");
        } else if (event.getSource() == div) {
            data = Float.parseFloat(display.getText());
            operation = 5; //Division
            display.setText("/");
        }
        else if (event.getSource() == sub) {
            data = Float.parseFloat(display.getText());
            operation = 2;
            display.setText("-");
        }
        else if (event.getSource() == mod) {
            data = Float.parseFloat(display.getText());
            operation = 4;
            display.setText("%");
        }
        else if (event.getSource() == mul) {
            data = Float.parseFloat(display.getText());
            operation = 3;
            display.setText("x");
        } else if (event.getSource() == decimal) {
            data = Float.parseFloat(display.getText());
         //No operation for decimal
            display.setText(".");
        }
        else if (event.getSource() == SignChange) {
            data = Float.parseFloat(display.getText());
      //No operation defined
            display.setText("+/-");
        }
        else if (event.getSource() == equals) {
            Float secondOperand = Float.parseFloat(display.getText());
            switch (operation) {
                case 1: //Addition
                    Float ans = data + secondOperand;
                    display.setText(String.valueOf(ans));
                    break;
                case 2:
                    Float subi = data - secondOperand;
                    display.setText(String.valueOf(subi));
                    break;
                case 3:
                    Float muli = data * secondOperand;
                    display.setText(String.valueOf(muli));
                    break;
                case 4:
                    Float modi = data % secondOperand;
                    display.setText(String.valueOf(modi));
                    break;
                case 5: //Div
                    ans = 0f;
                    try {
                        ans = data / secondOperand;
                    }catch(Exception e){display.setText("Error");}
                    display.setText(String.valueOf(ans));
                    break;
            }
        }
    }

    public void initialize() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}