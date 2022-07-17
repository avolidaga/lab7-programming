package model.enumtype;

import java.io.Serializable;

public enum HairColor implements Serializable {
    BLACK("black"),
    BLUE("blue"),
    YELLOW("yellow"),
    BROWN("brown");

    private final String hairColor;

    HairColor(String hairColor) {
        this.hairColor = hairColor;
    }


    static public void showHairColorList() {
        for (HairColor color : values()){
            System.out.println(color);
        }
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

}
