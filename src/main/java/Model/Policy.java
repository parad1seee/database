package Model;

import java.time.LocalDate;

public class Policy {
    private int id;

    private String policyNumber;

    private LocalDate beginDate;

    private LocalDate endDate;

    private String policyName;

    private Insurer insurer;

    private Document document;

    private Car car;

    private LocalDate signingDate;

    public Policy(String policyNumber, LocalDate beginDate, LocalDate endDate, String policyName, Insurer insurer, Document document, Car car, LocalDate signingDate) {
        this.policyNumber = policyNumber;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.policyName = policyName;
        this.insurer = insurer;
        this.document = document;
        this.car = car;
        this.signingDate = signingDate;
    }

    public Policy() {
        this.policyNumber = null;
        this.beginDate = null;
        this.endDate = null;
        this.policyName = "";
        this.insurer = new Insurer();
        this.document = new Document();
        this.car = new Car();
        this.signingDate = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public Insurer getInsurer() {
        return insurer;
    }

    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(LocalDate signingDate) {
        this.signingDate = signingDate;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", policyNumber=" + policyNumber +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", policyName='" + policyName + '\'' +
                ", signingDate=" + signingDate +
                '}';
    }
}
