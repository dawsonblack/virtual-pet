package org.wcci.virtualpet;

abstract class RoboticPet extends Pet implements Robotic {
    private int charge;
    private int oilLevel;

    public RoboticPet(String name) {
        super(name);
        this.charge = 8;
        this.oilLevel = 8;
    }

    @Override
    public void changeCharge(int i) {
        charge += i;
        if (charge < 0)
            charge = 0;
    }

    @Override
    public void charge(int i) {
        changeCharge(8 * i);
    }

    @Override
    public boolean needsCharging() {
        return charge <= 8;
    }

    @Override
    public boolean isDead() {
        return charge == 0;
    }

    @Override
    public boolean isOverCharged() {
        return charge > 16;
    }

    @Override
    public void changeOilLevel(int i) {
        oilLevel += i;
        if (oilLevel < 0)
            oilLevel = 0;
    }

    @Override
    public void oil(int i) {
        changeOilLevel(8 * i);
    }

    @Override
    public boolean needsOil() {
        return oilLevel <= 8;
    }

    @Override
    public boolean outOfOil() {
        return oilLevel == 0;
    }

    @Override
    public boolean isOverOiled() {
        return oilLevel > 16;
    }

    public Double chanceOfTrick(String trickName) {
        return tricks.getOrDefault(trickName, 0.5);
    }

    public void train(String trickName) {
        if (!(isDead() || outOfOil())) {
            Double newChance = (chanceOfTrick(trickName) + 1) / 2;
            tricks.put(trickName, newChance);
        }
        changeOilLevel(-4);
        changeCharge(-4);
    }
}
