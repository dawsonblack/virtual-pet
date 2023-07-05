package org.wcci.virtualpet;

abstract class OrganicPet extends Pet implements Organic {

    private int hunger;
    private int thirst;
    private int tiredness;

    public OrganicPet(String name) {
        super(name);
        this.hunger = 8;
        this.thirst = 8;
        this.tiredness = -8;
    }

    @Override
    public void changeHunger(int i) {
        hunger += i;
        if (hunger > 16)
            hunger = 16;

        if (hunger < -8)
            hunger = -8;
    }

    @Override
    public void feed(int i) {
        changeHunger(-(8 * i));
    }

    @Override
    public void giveSnack() {
        changeHunger(-2);
    }

    @Override
    public boolean isHungry() {
        return hunger >= 8;
    }

    @Override
    public boolean isStarving() {
        return hunger >= 16;
    }

    @Override
    public boolean isOverfed() {
        return hunger < 0;
    }

    @Override
    public void changeThirst(int i) {
        thirst += i;
        if (thirst > 16)
            thirst = 16;

        if (thirst < -8)
            thirst = -8;
    }

    @Override
    public void water(int i) {
        changeThirst(-(8 * i));
    }

    @Override
    public boolean isThirsty() {
        return thirst >= 8;
    }

    @Override
    public boolean isDehydrated() {
        return thirst >= 16;
    }

    @Override
    public boolean isOverwatered() {
        return thirst < 0;
    }

    @Override
    public void changeTiredness(int i) {
        tiredness += i;
        if (tiredness > 16)
            tiredness = 16;

        if (tiredness < -8)
            tiredness = -8;
    }

    @Override
    public boolean isTired() {
        return tiredness >= 8;
    }

    public void train(String trickName) {
        if (!(isHungry() || isTired() || ageInMonths < 6)) {
            Double newChance = (chanceOfTrick(trickName) + 1) / 2;
            tricks.put(trickName, newChance);
        }
        changeThirst(8);
        changeTiredness(4);
    }
    
}
