package org.wcci.virtualpet;

public class OrganicDog extends OrganicPet implements Dog {

    public OrganicDog(String name) {
        super(name);
    }

    @Override
    public void playFetch() {
        changeTiredness(2);
        changeThirst(2);
    }
}
