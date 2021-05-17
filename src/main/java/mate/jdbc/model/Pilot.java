package mate.jdbc.model;

public class Pilot {
    private Long id;
    private String name;
    private String flightNumber;
    private String carrier;
    private Long manufacturer;

    public Pilot() {
    }

    public Pilot(String name, String flightNumber, String carrier, Long manufacturer) {
        this.name = name;
        this.carrier = carrier;
        this.flightNumber = flightNumber;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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
        return "Pilot{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", flightNumber='" + flightNumber + '\''
                + ", carrier='" + carrier + '\''
                + ", manufacturer=" + manufacturer
                + '}';
    }
}
