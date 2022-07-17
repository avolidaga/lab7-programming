package model.enumtype;

import java.io.Serializable;

public enum UnitOfMeasure implements Serializable {

    CENTIMETERS("centimeters"),
    MILLILITERS("milliliters"),
    MILLIGRAMS("milligrams");



    private final String unitOfMeasure;

    UnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }


    public static void showUnitOfMeasureList(){
        for ( UnitOfMeasure unitOfMeasure : values()){
            System.out.println(unitOfMeasure);
        }
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
