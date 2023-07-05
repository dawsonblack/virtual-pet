package org.wcci.virtualpet;

public interface Organic {
    public void changeHunger(int i);

    public void feed(int i);

    public void giveSnack();

    public boolean isHungry();

    public boolean isStarving();

    public boolean isOverfed();

    public void changeThirst(int i);

    public void water(int i);

    public boolean isThirsty();

    public boolean isDehydrated();

    public boolean isOverwatered();

    public void changeTiredness(int i);

    public boolean isTired();
}
