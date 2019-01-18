import java.net.URL;
import java.util.ResourceBundle;

import Util.DaoFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class SelectAllByPolicyEndDateController {

    private Stage dialogStage;

    private MainApp mainApp;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    void initialize() {


    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public void setMainApp(MainApp mainApp)
    {
        this.mainApp = mainApp;
    }

    @FXML
    public void handleOk() {
        if (fromDatePicker.getValue() != null && toDatePicker.getValue() != null) {
            mainApp.setPolicyData(DaoFactory.getInstance().getPolicyDAO().
                    selectAllByPolicyEndDate(fromDatePicker.getValue(),
                    toDatePicker.getValue()));
            if(mainApp.getPolicyData() == null)
            System.out.println("Kaef");
            dialogStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Неверный ввод");
            alert.setContentText("Введите информацию!");

            alert.showAndWait();
        }
    }

    @FXML
    public void handleCancel()
    {
        dialogStage.close();
    }
}
