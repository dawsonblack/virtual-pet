package org.wcci.virtualpet;

import java.util.HashMap;

abstract class Pet {

    private String name;
    protected double ageInMonths;
    protected HashMap<String, Double> tricks;

    public Pet(String name) {
        this.name = name;
        this.ageInMonths = 0;

        this.tricks = new HashMap<>();
    }

    public Integer ageInYears() {
        return (int) (ageInMonths / 12);
    }

    public double getAgeInMonths() {
        return ageInMonths;
    }

    public void setAgeInMonths(double months) {
        ageInMonths = months;
    }

    public String getName() {
        return name;
    }

    public Double chanceOfTrick(String trickName) {
        return tricks.getOrDefault(trickName, 0.5);
    }
}
