package hellojpa;


import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String city;
    private String street;
    private String zipcodes;

    public Address(String city, String street, String zipcodes) {
        this.city = city;
        this.street = street;
        this.zipcodes = zipcodes;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcodes() {
        return zipcodes;
    }

    public void setZipcodes(String zipcodes) {
        this.zipcodes = zipcodes;
    }

    public Address() {
    }
}
