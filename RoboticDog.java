package org.wcci.virtualpet;

public class RoboticDog extends RoboticPet implements Dog {
    public RoboticDog(String name) {
        super(name);
    }

    @Override
    public void playFetch() {
        changeCharge(-1);
        changeOilLevel(-2);
    }
}
