package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.HashMap;
import java.util.Map;


public class Controller {
    private final Map<String, Integer> uniqCheckMap = new HashMap<>();

    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

//int a = 0;
//String b = "";
    public void sendMsg() {
            String warning = validate();
            if (warning == null) {
                textArea.appendText(textField.getText() + "\n");
                textField.clear();
            } else {
                new Alert(Alert.AlertType.WARNING, warning, ButtonType.OK).showAndWait();
            }

            textField.requestFocus();
//        if (textField.getText() == "") {
//            ErrorWindow.newWindow("Нельзя отправлять пустые сообщения");
//            textArea.appendText("Нельзя отправлять пустые сообщения" + "\n");
//        } else if (a == 1) {
//            ErrorWindow.newWindow("Нельзя отправлять повторяющиеся сообщения");
//            textArea.appendText("Нельзя отправлять повторяющиеся сообщения" + "\n");
//            a = 0;
//
//        } else if (textField.getText().equals(b)) {
//                textArea.appendText(textField.getText() + "\n" );
//                textField.clear();
//                textField.requestFocus();
//                a += 1;
//
//        } else {
//            b = textField.getText();
//            textArea.appendText(textField.getText() + "\n");
//            textField.clear();
//            textField.requestFocus();
//            a = 0;
//        }

    }

    private String validate() {
        String textFromField = textField.getText();
        String warning = null;
        if (textFromField.isEmpty()) {
            warning = "Нельзя отправлять пустые сообщения";
        } else {
            Integer count = uniqCheckMap.getOrDefault(textFromField, 0);
            if (count.equals(0)) {
                uniqCheckMap.clear();
            }
            uniqCheckMap.put(textFromField, ++count);
            if (count > 3 ) {
                warning = "Нельзя отправлять больше 3 одинаковых сообщений, номер вашей попытки: " + count;
            }
        }

        return warning;
    }


}
