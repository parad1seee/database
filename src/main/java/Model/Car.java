package Model;

import java.time.LocalDate;

public class Car {

    private int id;

    private String mark;

    private String type;

    private String registrationMark;

    private long vin;

    private LocalDate dateOfIssue;

    private String cityOfRegistration;

    public Car(String mark, String type, String registrationMark, long vin, LocalDate dateOfIssue, String cityOfRegistration) {
        this.mark = mark;
        this.type = type;
        this.registrationMark = registrationMark;
        this.vin = vin;
        this.dateOfIssue = dateOfIssue;
        this.cityOfRegistration = cityOfRegistration;
    }

    public Car() {
        this(null,null,null,0,null, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String  getRegistrationMark() {
        return registrationMark;
    }

    public void setRegistrationMark(String registrationMark) {
        this.registrationMark = registrationMark;
    }

    public long getVin() {
        return vin;
    }

    public void setVin(long vin) {
        this.vin = vin;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getCityOfRegistration() {
        return cityOfRegistration;
    }

    public void setCityOfRegistration(String cityOfRegistration) {
        this.cityOfRegistration = cityOfRegistration;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", type='" + type + '\'' +
                ", registrationMark='" + registrationMark + '\'' +
                ", vin=" + vin +
                ", dateOfIssue=" + dateOfIssue +
                ", cityOfRegistration=" + cityOfRegistration + '\'' +
                '}';
    }


}
