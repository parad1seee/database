package Model;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;


public class Document {

    private int id;

    private String name;

    private String series;

    private String number;

    private LocalDate dateOfIssue;

    private String issuedBy;

    public Document() {
        name = "";
        series = "";
        number = "";
        dateOfIssue = null;
        issuedBy = "";
    }

    public Document(String name, String series, String number, LocalDate dateOfIssue, String issuedBy)
    {
        this.name = name;
        this.series = series;
        this.number = number;
        this.dateOfIssue = dateOfIssue;
        this.issuedBy = issuedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", series='" + series + '\'' +
                ", number=" + number +
                ", dateOfIssue=" + dateOfIssue +
                ", issuedBy='" + issuedBy + '\'' +
                '}';
    }
}
