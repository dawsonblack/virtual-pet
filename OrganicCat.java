package org.wcci.virtualpet;

public class OrganicCat extends OrganicPet implements Cat {

    public OrganicCat(String name) {
        super(name);
    }

    @Override
    public void shineLaserPointer() {
        changeTiredness(2);
        changeThirst(2);
    }
}
