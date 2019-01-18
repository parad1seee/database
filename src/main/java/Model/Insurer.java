package Model;

import java.time.LocalDate;

public class Insurer {

    private int id;

    private String name;

    private String surname;

    private String patronymic;

    private Residence residence;

    private int postIndex;

    private String identificationCode;

    private String telephone;

    private LocalDate birthDate;

    public Insurer(String name, String surname, String patronymic, Residence residence, int postIndex, String identificationCode, String telephone, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.residence = residence;
        this.postIndex = postIndex;
        this.identificationCode = identificationCode;
        this.telephone = telephone;
        this.birthDate = birthDate;
    }

    public Insurer() {
        this.name = "";
        this.surname = "";
        this.patronymic = "";
        this.residence = new Residence();
        this.postIndex = 0;
        this.identificationCode = "";
        this.telephone = "";
        this.birthDate = null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(int postIndex) {
        this.postIndex = postIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "Insurer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", postIndex=" + postIndex +
                ", identificationCode='" + identificationCode + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
