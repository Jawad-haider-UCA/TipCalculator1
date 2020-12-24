package MiniBrowser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MiniBrowserController  implements Initializable {

    String https = "https://";
    String addressLink;
    WebEngine engine;
    ArrayList<String> history = new ArrayList<String>();
    int currPage = 0;

    @FXML private Button backButton;

    @FXML private Button nextButton;

    @FXML private TextField goTextField;

    @FXML private Button goButton;

    @FXML private WebView web;

    @FXML
    void backButtonPressed(ActionEvent event) {
        engine.load(history.get(--currPage));
        nextButton.setDisable(false);
        if(currPage == 0) backButton.setDisable(true);
        goTextField.setText(history.get(currPage));

    }

    @FXML
    void nextButtonPressed(ActionEvent event) {
        engine.load(history.get(++currPage));
        backButton.setDisable(false);
        if(currPage == history.size() - 1) nextButton.setDisable(true);
        goTextField.setText(history.get(currPage));

    }

    @FXML
    void search(ActionEvent event) {
        addressLink = goTextField.getText();
        engine.load(https+addressLink);
        history.add(https + addressLink);
        currPage = history.size() - 1;
        backButton.setDisable(false);
        nextButton.setDisable(true);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = web.getEngine();
        engine.load(https+"www.google.com");
        history.add(https+"www.google.com");

    }
}
