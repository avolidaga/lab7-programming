package model.enumtype;

import java.io.Serializable;

public enum Country implements Serializable {
    FRANCE("france"),
    INDIA("india"),
    ITALY("italy");

    private final String country;

    Country(String country) {
        this.country = country;
    }

    public static void showCountryList(){
        for ( Country country : values()){
            System.out.println(country);
        }
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
