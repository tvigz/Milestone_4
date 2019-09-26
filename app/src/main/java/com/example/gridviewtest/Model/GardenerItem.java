package com.example.gridviewtest.Model;

//This class represents all gardeners, shovels, and carts. Gardener ID should be displayed
//In info shown on screen. You can calculate the gardener ID by using integer % / operator

public class GardenerItem extends GridCell {
    int gardenerID = 0;
    public GardenerItem() {
        super();
    }

    @Override
    public String getCellInfo(){
        return super.getCellInfo() + " Gardener ID: " + gardenerID;
    }

    public void setGardenerID( int newID ) {
        gardenerID = newID;
    }
}
