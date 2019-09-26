package com.example.gridviewtest.Model;

import android.content.Context;
import android.widget.GridView;
import android.widget.ImageView;

public class GridCell {

    private int resourceID;
    private String cellType;
    private String cellInfo;
    private int gardenerID = 0;
    private int row;
    private int col;
    private int JSONValue;

    public GridCell( ) {
        resourceID = 0;
        cellType = "";
        cellInfo = "";
    }

    public Integer getResourceID(){
        return resourceID; }

    public void setResourceID( int newID ){
        resourceID = newID; }

    public void setCellType( String newCellType ){
        cellType = newCellType; }

    public String getCellType(){
        return cellType; }

    public String getCellInfo(){
        if( gardenerID == 0 ){
            cellInfo = "location:(" + row + "," + col + ")";
            return cellInfo;
        } else {
            cellInfo = "location:(" + row + "," + col + ")" + " Gardener ID:" + gardenerID;
            return cellInfo;
        }
    }

    public void setRow( int r ) {
        row = r;
    }

    public void setCol( int c ){
        col = c;
    }

    public void setGardenerID( int gID ){
        gardenerID = gID;
    }


}
