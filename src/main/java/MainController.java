import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import Model.*;
import Util.DaoFactory;
import Util.DateUtil;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    private MainApp mainApp;

    private ObservableList<String> select = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Policy> previewTableView;

    @FXML
    private TableColumn<Policy, String> nameColumn;

    @FXML
    private TableColumn<Policy, String> surnameColumn;

    @FXML
    private TableColumn<Policy, String> patronymicColumn;

    @FXML
    private TableColumn<Policy, String> policyNameColumn;

    @FXML
    private Label policyValidityLabel;

    @FXML
    private Label policyNameLabel;

    @FXML
    private Label insurerFIOLabel;

    @FXML
    private Label insurerRegionLabel;

    @FXML
    private Label policyNumberLabel;

    @FXML
    private Label policySigningDateLabel;

    @FXML
    private Label carCityOfRegistrationLabel;

    @FXML
    private Label carDateOfIssueLabel;

    @FXML
    private Label carVINLabel;

    @FXML
    private Label carRegistrationMarkLabel;

    @FXML
    private Label carTypeLabel;

    @FXML
    private Label carMarkLabel;

    @FXML
    private Label documentIssuedByLabel;

    @FXML
    private Label documentDateOfIssueLabel;

    @FXML
    private Label documentNumberLabel;

    @FXML
    private Label documentSeriesLabel;

    @FXML
    private Label documentNameLabel;

    @FXML
    private Label insurerBirthDayLabel;

    @FXML
    private Label insurerTelephoneLabel;

    @FXML
    private Label insurerRegistrationCodeLabel;

    @FXML
    private Label insurerPostIndexLabel;

    @FXML
    private Label insurerStreetLabel;

    @FXML
    private Label insurerCityLabel;

    @FXML
    private Label insurerDistrictLabel;

    @FXML
    private Button exitButton;

    @FXML
    private Button editButton;

    @FXML
    private Button addButton;

    @FXML
    private ComboBox<String> selectComboBox;

    @FXML
    private Button selectRunButton;

    public MainController() {

    }

    @FXML
    void initialize() {

        documentIssuedByLabel.setWrapText(true);

        nameColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getInsurer().getName()));
        surnameColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getInsurer().getSurname()));
        patronymicColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getInsurer().getPatronymic()));
        policyNameColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPolicyName()));

        ShowDetails(null);

        previewTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> ShowDetails(newValue));

        select.add("Дата окончания полиса");
        selectComboBox.setItems(select);

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        previewTableView.setItems(mainApp.getPolicyData());
    }

    private void ShowDetails(Policy policy) {
        if (policy != null) {
            policyNumberLabel.setText(Integer.toString(policy.getPolicyNumber()));
            policyValidityLabel.setText(DateUtil.format(policy.getBeginDate()) + "-" + DateUtil.format(policy.getEndDate()));
            policyNameLabel.setText(policy.getPolicyName());
            insurerFIOLabel.setText(policy.getInsurer().getSurname() + " "
                    + policy.getInsurer().getName() + " "
                    + policy.getInsurer().getPatronymic());
            insurerRegionLabel.setText(policy.getInsurer().getResidence().getRegion());
            insurerDistrictLabel.setText(policy.getInsurer().getResidence().getDistrict());
            insurerCityLabel.setText(policy.getInsurer().getResidence().getCity());
            insurerStreetLabel.setText(policy.getInsurer().getResidence().getStreet());
            insurerPostIndexLabel.setText(Integer.toString(policy.getInsurer().getPostIndex()));
            insurerRegistrationCodeLabel.setText(policy.getInsurer().getIdentificationCode());
            insurerTelephoneLabel.setText(policy.getInsurer().getTelephone());
            insurerBirthDayLabel.setText(DateUtil.format(policy.getInsurer().getBirthDate()));
            documentNameLabel.setText(policy.getDocument().getName());
            documentSeriesLabel.setText(policy.getDocument().getSeries());
            documentNumberLabel.setText(policy.getDocument().getNumber());
            documentDateOfIssueLabel.setText(DateUtil.format(policy.getDocument().getDateOfIssue()));
            documentIssuedByLabel.setText(policy.getDocument().getIssuedBy());
            carMarkLabel.setText(policy.getCar().getMark());
            carTypeLabel.setText(policy.getCar().getType());
            carRegistrationMarkLabel.setText(policy.getCar().getRegistrationMark());
            carVINLabel.setText(Long.toString(policy.getCar().getVin()));
            carDateOfIssueLabel.setText(DateUtil.format(policy.getCar().getDateOfIssue()));
            carCityOfRegistrationLabel.setText(policy.getCar().getCityOfRegistration());
            policySigningDateLabel.setText(DateUtil.format(policy.getSigningDate()));
        } else {
            carTypeLabel.setText("");
            policyNameLabel.setText("");
            policyNumberLabel.setText("");
            policyValidityLabel.setText("");
            insurerFIOLabel.setText("");
            insurerRegionLabel.setText("");
            insurerDistrictLabel.setText("");
            insurerCityLabel.setText("");
            insurerStreetLabel.setText("");
            insurerPostIndexLabel.setText("");
            insurerRegistrationCodeLabel.setText("");
            insurerTelephoneLabel.setText("");
            insurerBirthDayLabel.setText("");
            documentNameLabel.setText("");
            documentSeriesLabel.setText("");
            documentNumberLabel.setText("");
            documentDateOfIssueLabel.setText("");
            documentIssuedByLabel.setText("");
            carMarkLabel.setText("");
            carRegistrationMarkLabel.setText("");
            carVINLabel.setText("");
            carDateOfIssueLabel.setText("");
            carCityOfRegistrationLabel.setText("");
            policySigningDateLabel.setText("");
        }
    }

    @FXML
    void handleDeletePolicy() {
        int selectedIndex = previewTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Удалить запись");
            alert.setHeaderText("Вы уверены что хотите удалить эту запись?");
            alert.setContentText("");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get() == ButtonType.OK) {
                DaoFactory.getInstance().getPolicyDAO().delete(previewTableView.getSelectionModel().getSelectedItem());
                previewTableView.getItems().remove(selectedIndex);
                if(previewTableView.getItems().size() == 0)
                {
                    ShowDetails(null);
                }
            } else if (option.get() == ButtonType.CANCEL) {
                return;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ничего не выбрано");
            alert.setHeaderText("Не выбрана запись");
            alert.setContentText("Пожалуйста,выберите запись которую хотите удалить.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewPolicy() {
        Policy tempPolicy = new Policy();
        boolean okClicked = mainApp.showPolicyEditDialog(tempPolicy);
        if (okClicked) {
            mainApp.getPolicyData().add(tempPolicy);
            DaoFactory.getInstance().getPolicyDAO().create(tempPolicy);
        }
    }

    @FXML
    private void handleEditPolicy() {
        Policy selectedPolicy = previewTableView.getSelectionModel().getSelectedItem();
        if (selectedPolicy != null) {
            boolean okClicked = mainApp.showPolicyEditDialog(selectedPolicy);
            if (okClicked) {
                previewTableView.refresh();
                ShowDetails(selectedPolicy);
                DaoFactory.getInstance().getPolicyDAO().update(selectedPolicy);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Ничего не выбрано");
            alert.setContentText("Пожалуйста выберите запись в таблице");

            alert.showAndWait();
        }
    }

    @FXML
    public void handleSelectRun()
    {
        if(selectComboBox.getValue() == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Не выбрана выборка");
            alert.setContentText("Пожалуйста выберите выборку");

            alert.showAndWait();
            return;
        }
        switch (selectComboBox.getValue())
        {
            case "Дата окончания полиса":
                mainApp.showSelectByEndDateDialog();
                previewTableView.setItems(mainApp.getPolicyData());
                break;
        }
    }
}