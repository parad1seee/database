import java.net.URL;
import java.util.ResourceBundle;
import Model.Policy;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class PolicyEditController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField policyNumberField;

    @FXML
    private TextField policyNameField;

    @FXML
    private TextField insurerSurnameField;

    @FXML
    private TextField insurerNameField;

    @FXML
    private TextField insurerPatronymicField;

    @FXML
    private TextField residenceRegionField;

    @FXML
    private TextField residenceDistrictField;

    @FXML
    private TextField documentSeriesField;

    @FXML
    private TextArea documentIssuedByField;

    @FXML
    private TextField documentNameField;

    @FXML
    private TextField insurerTelephoneField;

    @FXML
    private TextField documentNumberField;

    @FXML
    private TextField insurerIdentificationCodeField;

    @FXML
    private TextField insurerPostIndexField;

    @FXML
    private TextField residenceStreetField;

    @FXML
    private TextField residenceCityField;

    @FXML
    private TextField carCityOfRegistrationField;

    @FXML
    private TextField carVinField;

    @FXML
    private TextField carRegistrationNumberField;

    @FXML
    private TextField carTypeField;

    @FXML
    private TextField carMarkField;

    @FXML
    private DatePicker documentDateOfIssuePicker;

    @FXML
    private DatePicker policyStartDatePicker;

    @FXML
    private DatePicker policyEndDatePicker;

    @FXML
    private DatePicker insurerBirthDatePicker;

    @FXML
    private DatePicker policySigningDatePicker;

    @FXML
    private DatePicker carDateOfIssuePicker;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    private Stage dialogStage;
    private Policy policy;
    private boolean okClicked = false;

    @FXML
    void initialize() {


    }

    public boolean isOkClicked() {
        return okClicked;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPolicy(Policy policy){
        this.policy = policy;

        if(policy.getPolicyNumber() == 0)
        {
            policyNumberField.setText("");
            insurerPostIndexField.setText("");
            carVinField.setText("");
        }
        else
        {
            policyNumberField.setText(Integer.toString(policy.getPolicyNumber()));
            insurerPostIndexField.setText(Integer.toString(policy.getInsurer().getPostIndex()));
            carVinField.setText(Long.toString(policy.getCar().getVin()));
        }

        policyStartDatePicker.setValue(policy.getBeginDate());
        policyEndDatePicker.setValue(policy.getEndDate());
        policyNameField.setText(policy.getPolicyName());
        insurerNameField.setText(policy.getInsurer().getName());
        insurerSurnameField.setText(policy.getInsurer().getSurname());
        insurerPatronymicField.setText(policy.getInsurer().getPatronymic());
        residenceRegionField.setText(policy.getInsurer().getResidence().getRegion());
        residenceDistrictField.setText(policy.getInsurer().getResidence().getDistrict());
        residenceCityField.setText(policy.getInsurer().getResidence().getCity());
        residenceStreetField.setText(policy.getInsurer().getResidence().getStreet());
        insurerIdentificationCodeField.setText(policy.getInsurer().getIdentificationCode());
        insurerTelephoneField.setText(policy.getInsurer().getTelephone());
        insurerBirthDatePicker.setValue(policy.getInsurer().getBirthDate());
        documentNameField.setText(policy.getDocument().getName());
        documentSeriesField.setText(policy.getDocument().getSeries());
        documentNumberField.setText(policy.getDocument().getNumber());
        documentDateOfIssuePicker.setValue(policy.getDocument().getDateOfIssue());
        documentIssuedByField.setText(policy.getDocument().getIssuedBy());
        carMarkField.setText(policy.getCar().getMark());
        carTypeField.setText(policy.getCar().getType());
        carRegistrationNumberField.setText(policy.getCar().getRegistrationMark());
        carDateOfIssuePicker.setValue(policy.getCar().getDateOfIssue());
        carCityOfRegistrationField.setText(policy.getCar().getCityOfRegistration());
        policySigningDatePicker.setValue(policy.getSigningDate());
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            policy.setPolicyNumber(Integer.parseInt(policyNumberField.getText()));
            policy.setPolicyName(policyNameField.getText());
            policy.setBeginDate(policyStartDatePicker.getValue());
            policy.setEndDate(policyEndDatePicker.getValue());
            policy.getInsurer().setName(insurerNameField.getText());
            policy.getInsurer().setSurname(insurerSurnameField.getText());
            policy.getInsurer().setPatronymic(insurerPatronymicField.getText());
            policy.getInsurer().getResidence().setRegion(residenceRegionField.getText());
            policy.getInsurer().getResidence().setDistrict(residenceDistrictField.getText());
            policy.getInsurer().getResidence().setCity(residenceCityField.getText());
            policy.getInsurer().getResidence().setStreet(residenceStreetField.getText());
            policy.getInsurer().setPostIndex(Integer.parseInt(insurerPostIndexField.getText()));
            policy.getInsurer().setIdentificationCode(insurerIdentificationCodeField.getText());
            policy.getInsurer().setTelephone(insurerTelephoneField.getText());
            policy.getInsurer().setBirthDate(insurerBirthDatePicker.getValue());
            policy.getDocument().setName(documentNameField.getText());
            policy.getDocument().setSeries(documentSeriesField.getText());
            policy.getDocument().setNumber(documentNumberField.getText());
            policy.getDocument().setDateOfIssue(documentDateOfIssuePicker.getValue());
            policy.getDocument().setIssuedBy(documentIssuedByField.getText());
            policy.getCar().setMark(carMarkField.getText());
            policy.getCar().setType(carTypeField.getText());
            policy.getCar().setRegistrationMark(carRegistrationNumberField.getText());
            policy.getCar().setVin(Long.parseLong(carVinField.getText()));
            policy.getCar().setDateOfIssue(carDateOfIssuePicker.getValue());
            policy.getCar().setCityOfRegistration(carCityOfRegistrationField.getText());
            policy.setSigningDate(policySigningDatePicker.getValue());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

                if (policyNumberField.getText() == null || policyNumberField.getText().length() == 0) {
                    errorMessage += "Неверный номер полиса!\n";
                } else {
                    try {
                        Integer.parseInt(policyNumberField.getText());
                    } catch (NumberFormatException e) {
                        errorMessage += "Номер полиса должен быть целым числом!\n";
                    }
                }

                if (policyStartDatePicker.getValue() == null) {
                    errorMessage += "Неверная дата начала действия полиса!\n";
                }

                if (policyEndDatePicker.getValue() == null) {
                    errorMessage += "Неверный срок действия полиса!\n";
                }

                if(policyStartDatePicker.getValue().isAfter(policyEndDatePicker.getValue())){
                    errorMessage += "Дата начала действия полиса не может быть больше даты конца!\n";
                }

                if (policyNameField.getText() == null || policyNameField.getText().length() == 0) {
                    errorMessage += "Неверное имя полиса!\n";
                }

                if (insurerSurnameField.getText() == null || insurerSurnameField.getText().length() == 0) {
                    errorMessage += "Неверная фамилия!\n";
                }

                if (insurerNameField.getText() == null || insurerNameField.getText().length() == 0) {
                    errorMessage += "Неверное имя!\n";
                }

                if (insurerPatronymicField.getText() == null || insurerPatronymicField.getText().length() == 0) {
                    errorMessage += "Неверное отчество!\n";
                }

                if (residenceRegionField.getText() == null || residenceRegionField.getText().length() == 0) {
                    errorMessage += "Неверная область!\n";
                }

                if (residenceDistrictField.getText() == null || residenceDistrictField.getText().length() == 0) {
                    errorMessage += "Неверный район!\n";
                }

                if (residenceCityField.getText() == null || residenceCityField.getText().length() == 0) {
                    errorMessage += "Неверный город!\n";
                }

                if (residenceStreetField.getText() == null || residenceStreetField.getText().length() == 0) {
                    errorMessage += "Неверная улица!\n";
                }

                if (insurerPostIndexField.getText() == null || insurerPostIndexField.getText().length() == 0) {
                    errorMessage += "Неверный почтовый индекс!\n";
                } else {
                    try {
                        Integer.parseInt(insurerPostIndexField.getText());
                    } catch (NumberFormatException e) {
                        errorMessage += "Почтовый индекс должен быть целым числом!\n";
                    }
                }

                if (insurerIdentificationCodeField.getText() == null || insurerIdentificationCodeField.getText().length() == 0) {
                    errorMessage += "Неверный идентификационный код!\n";
                }

                if (insurerTelephoneField.getText() == null || insurerTelephoneField.getText().length() == 0) {
                    errorMessage += "Неверный телефон!\n";
                }

                if (insurerBirthDatePicker.getValue() == null) {
                    errorMessage += "Неверная дата рождения!\n";
                }

                if (documentNameField.getText() == null || documentNameField.getText().length() == 0) {
                    errorMessage += "Неверное название документа!\n";
                }

                if (documentSeriesField.getText() == null || documentSeriesField.getText().length() == 0) {
                    errorMessage += "Неверная серия документа!\n";
                }

                if (documentNumberField.getText() == null || documentNumberField.getText().length() == 0) {
                    errorMessage += "Неверный номер документа!\n";
                }

                if (documentDateOfIssuePicker.getValue() == null) {
                    errorMessage += "Неверная дата выдачи документа!\n";
                }

                if (documentIssuedByField.getText() == null || documentIssuedByField.getText().length() == 0) {
                    errorMessage += "Неверный источник выдачи документа!\n";
                }

                if (carMarkField.getText() == null || carMarkField.getText().length() == 0) {
                    errorMessage += "Неверная марка машины!\n";
                }

                if (carTypeField.getText() == null || carTypeField.getText().length() == 0) {
                    errorMessage += "Неверный тип машины!\n";
                }

                if (carRegistrationNumberField.getText() == null || carRegistrationNumberField.getText().length() == 0) {
                    errorMessage += "Неверный номерной знак машины!\n";
                }

                if (insurerTelephoneField.getText() == null || insurerTelephoneField.getText().length() == 0) {
                    errorMessage += "Неверный телефон!\n";
                }

                if (carVinField.getText() == null || carVinField.getText().length() == 0) {
                    errorMessage += "Неверный вин код!\n";
                } else {
                    try {
                        Long.parseLong(carVinField.getText());
                    } catch (NumberFormatException e) {
                        errorMessage += "Вин код должен быть целым числом!\n";
                    }
                }

                if (carDateOfIssuePicker.getValue() == null) {
                    errorMessage += "Неверная дата выдачи машины!\n";
                }

                if (carCityOfRegistrationField.getText() == null || carCityOfRegistrationField.getText().length() == 0) {
                    errorMessage += "Неверное место регистрации машины!\n";
                }

                if (policySigningDatePicker.getValue() == null) {
                    errorMessage += "Неверная дата подписания полиса!\n";
                }

                /*If there is no errors in input,returning true and adding/updating record*/

                if (errorMessage.length() == 0) {
                    return true;
                } else {
                    /* Else, showing error message */
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initOwner(dialogStage);
                    alert.setTitle("Неверный ввод");
                    alert.setHeaderText("Пожалуйста скорректируйте вводимую информацию");
                    alert.setContentText(errorMessage);

                    alert.showAndWait();

                    return false;
                }
            }
        }
