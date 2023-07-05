package org.wcci.virtualpet;

public class RoboticCat extends RoboticPet implements Cat {

    public RoboticCat(String name) {
        super(name);
    }

    @Override
    public void shineLaserPointer() {
        changeCharge(-1);
        changeOilLevel(-2);
    }
}
