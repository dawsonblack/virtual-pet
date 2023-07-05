package org.wcci.virtualpet;

public interface Robotic {
    public void changeCharge(int i);

    public void charge(int i);

    public boolean needsCharging();

    public boolean isDead();

    public boolean isOverCharged();

    public void changeOilLevel(int i);

    public void oil(int i);

    public boolean needsOil();

    public boolean outOfOil();

    public boolean isOverOiled();
}
