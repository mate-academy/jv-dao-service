package mate.jdbc.model;

public class Flight {
    private Long id;
    private String number;
    private String carrier;
    private Long manufacturer;

    public Flight() {
    }

    public Flight(String carrier, String number, Long manufacturer) {
        this.carrier = carrier;
        this.number = number;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Long getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Long manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Flight{"
                + "id=" + id
                + ", number='" + number + '\''
                + ", carrier='" + carrier + '\''
                + ", manufacturer=" + manufacturer
                + '}';
    }

}
