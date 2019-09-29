package com.example.gridviewtest;

import com.example.gridviewtest.Model.GardenerItem;
import com.example.gridviewtest.Model.GridCell;
import com.example.gridviewtest.Model.Plant;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridCellFactoryTest {

    @Test //1
    public void makeEmptyCell() {
        GridCell gridCell1 = new GridCell();
        gridCell1.setResourceID(R.drawable.blank); // 0
        gridCell1.setCellType("Empty Cell"); // 0
        gridCell1.setRow(16);
        gridCell1.setCol(16);
        final int x = 0;
        final int val = 256;
        final GridCellFactory gcf1 = new GridCellFactory();
        GridCell gridCell2 = gcf1.makeCell( val, x );

        assertEquals( gridCell1.getCellInfo(), gridCell2.getCellInfo() );
        assertEquals( gridCell1.getCellType(), gridCell2.getCellType() );
        assertEquals( gridCell1.getResourceID(), gridCell2.getResourceID() );
    }

    @Test //2
    public void makeTreeCell() {
        Plant gridCell1 = new Plant();
        gridCell1.setResourceID(R.drawable.tree); // 0
        gridCell1.setCellType("Tree"); // 0
        gridCell1.setRow(16);
        gridCell1.setCol(16);
        final int x = 1000;
        final int val = 256;
        final GridCellFactory gcf1 = new GridCellFactory();
        Plant gridCell2 = (Plant) gcf1.makeCell( val, x );

        assertEquals( gridCell1.getCellInfo(), gridCell2.getCellInfo() );
        assertEquals( gridCell1.getCellType(), gridCell2.getCellType() );
        assertEquals( gridCell1.getResourceID(), gridCell2.getResourceID() );
    }

    @Test //3
    public void makeBushCell() {
        Plant gridCell1 = new Plant();
        gridCell1.setResourceID(R.drawable.bushes); // 0
        gridCell1.setCellType("Bushes"); // 0
        gridCell1.setRow(16);
        gridCell1.setCol(16);
        final int x = 1500;
        final int val = 256;
        final GridCellFactory gcf1 = new GridCellFactory();
        Plant gridCell2 = (Plant) gcf1.makeCell( val, x );

        assertEquals( gridCell1.getCellInfo(), gridCell2.getCellInfo() );
        assertEquals( gridCell1.getCellType(), gridCell2.getCellType() );
        assertEquals( gridCell1.getResourceID(), gridCell2.getResourceID() );
    }

    @Test //4
    public void makeCloverCell() {
        Plant gridCell1 = new Plant();
        gridCell1.setResourceID(R.drawable.clover); // 0
        gridCell1.setCellType("Clover"); // 0
        gridCell1.setRow(16);
        gridCell1.setCol(16);
        final int x = 2002;
        final int val = 256;
        final GridCellFactory gcf1 = new GridCellFactory();
        Plant gridCell2 = (Plant) gcf1.makeCell( val, x );

        assertEquals( gridCell1.getCellInfo(), gridCell2.getCellInfo() );
        assertEquals( gridCell1.getCellType(), gridCell2.getCellType() );
        assertEquals( gridCell1.getResourceID(), gridCell2.getResourceID() );
    }

    @Test //5
    public void makeMushroomCell() {
        Plant gridCell1 = new Plant();
        gridCell1.setResourceID(R.drawable.mushroom); // 0
        gridCell1.setCellType("Mushroom"); // 0
        gridCell1.setRow(16);
        gridCell1.setCol(16);
        final int x = 2003;
        final int val = 256;
        final GridCellFactory gcf1 = new GridCellFactory();
        Plant gridCell2 = (Plant) gcf1.makeCell( val, x );

        assertEquals( gridCell1.getCellInfo(), gridCell2.getCellInfo() );
        assertEquals( gridCell1.getCellType(), gridCell2.getCellType() );
        assertEquals( gridCell1.getResourceID(), gridCell2.getResourceID() );
    }

    @Test //6
    public void makeSunflowerCell() {
        Plant gridCell1 = new Plant();
        gridCell1.setResourceID(R.drawable.sunflower); // 0
        gridCell1.setCellType("Sunflower"); // 0
        gridCell1.setRow(16);
        gridCell1.setCol(16);
        final int x = 3000;
        final int val = 256;
        final GridCellFactory gcf1 = new GridCellFactory();
        Plant gridCell2 = (Plant) gcf1.makeCell( val, x );

        assertEquals( gridCell1.getCellInfo(), gridCell2.getCellInfo() );
        assertEquals( gridCell1.getCellType(), gridCell2.getCellType() );
        assertEquals( gridCell1.getResourceID(), gridCell2.getResourceID() );
    }

    @Test //7
    public void makeReservedCell() {
        GridCell gridCell1 = new GridCell();
        gridCell1.setResourceID(R.drawable.blank); // 0
        gridCell1.setCellType("Reserved"); // 0
        gridCell1.setRow(16);
        gridCell1.setCol(16);
        final int x = 5000;
        final int val = 256;
        final GridCellFactory gcf1 = new GridCellFactory();
        GridCell gridCell2 = gcf1.makeCell( val, x );

        assertEquals( gridCell1.getCellInfo(), gridCell2.getCellInfo() );
        assertEquals( gridCell1.getCellType(), gridCell2.getCellType() );
        assertEquals( gridCell1.getResourceID(), gridCell2.getResourceID() );
    }

    @Test //8
    public void makeGardenerCell() {
        GardenerItem gridCell1 = new GardenerItem();
        gridCell1.setResourceID(R.drawable.gardender_icon); // 0
        gridCell1.setCellType("Gardener"); // 0
        gridCell1.setRow(16);
        gridCell1.setCol(16);
        gridCell1.setGardenerID(444);
        final int x = 1444001;
        final int val = 256;
        final GridCellFactory gcf1 = new GridCellFactory();
        GardenerItem gridCell2 = (GardenerItem) gcf1.makeCell( val, x );

        assertEquals( gridCell1.getCellInfo(), gridCell2.getCellInfo() );
        assertEquals( gridCell1.getCellType(), gridCell2.getCellType() );
        assertEquals( gridCell1.getResourceID(), gridCell2.getResourceID() );
    }

    @Test //9
    public void makeShovelCell() {
        GridCell gridCell1 = new GridCell();
        gridCell1.setResourceID(R.drawable.shovel_icon); // 0
        gridCell1.setCellType("Shovel"); // 0
        gridCell1.setRow(16);
        gridCell1.setCol(16);
        gridCell1.setGardenerID(444);
        final int x = 2444001;
        final int val = 256;
        final GridCellFactory gcf1 = new GridCellFactory();
        GardenerItem gridCell2 = (GardenerItem) gcf1.makeCell( val, x );

        assertEquals( gridCell1.getCellInfo(), gridCell2.getCellInfo() );
        assertEquals( gridCell1.getCellType(), gridCell2.getCellType() );
        assertEquals( gridCell1.getResourceID(), gridCell2.getResourceID() );
    }

    @Test //10
    public void makeCartCell() {
        GardenerItem gridCell1 = new GardenerItem();
        gridCell1.setResourceID(R.drawable.golfcart_icon); // 0
        gridCell1.setCellType("Cart"); // 0
        gridCell1.setRow(16);
        gridCell1.setCol(16);
        gridCell1.setGardenerID(444);
        final int x = 14440001;
        final int val = 256;
        final GridCellFactory gcf1 = new GridCellFactory();
        GardenerItem gridCell2 = (GardenerItem) gcf1.makeCell( val, x );

        assertEquals( gridCell1.getCellInfo(), gridCell2.getCellInfo() );
        assertEquals( gridCell1.getCellType(), gridCell2.getCellType() );
        assertEquals( gridCell1.getResourceID(), gridCell2.getResourceID() );
    }

    @Test //11
    public void getGardenerID() {
        GridCellFactory gcf1 = new GridCellFactory();
        int x = 1222000;
        int y = 222;
        int z = gcf1.getGardenerID(x);
        assertEquals( y, z );
    }

    @Test //12
    public void getGardenerID2() {
        GridCellFactory gcf1 = new GridCellFactory();
        int x = 12220000;
        int y = 222;
        int z = gcf1.getGardenerID2(x);
        assertEquals( y, z );
    }
}