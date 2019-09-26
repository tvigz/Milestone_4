package com.example.gridviewtest.Model;

public class SimulationGrid {

    GridCell simArray[];

    public SimulationGrid( int size ) {
        simArray = new GridCell[size];
    }

    public void setCell( int index, GridCell cell )
    {
        simArray[index] = cell;
    }

    public GridCell getCell( int index ){
        return simArray[index];
    }

    public int getNumRows(){
        return 16; // static in our case, at least for m3
    }

    public int getNumCols(){
        return 16; // static in our case, at least for m3
    }

    public int size(){
        int length = simArray.length;
        return length;
    }

}
