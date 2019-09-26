package com.example.gridviewtest;

import android.content.Context;
import android.widget.ImageView;

import com.example.gridviewtest.Model.GardenerItem;
import com.example.gridviewtest.Model.GridCell;
import com.example.gridviewtest.Model.Plant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridCellFactory{

    static Map<Integer, Integer> mStateResources;

    public GridCellFactory( ){
        mStateResources = new HashMap<>();
    }

    public GridCell makeCell( int val, int x )
    {
        int row = (int) Math.ceil( (val) / 16 ) + 1;
        int column = ( val % 16 ) + 1;
        if( x == 0 ) {
            mStateResources.put( val, R.drawable.blank);
            GridCell gridCell01 = new GridCell();
            gridCell01.setResourceID(pictureArray[0]);
            gridCell01.setCellType("Empty Cell");
            gridCell01.setCol( column );
            gridCell01.setRow( row );
            return gridCell01;
        } else if( x == 1000 ) {
            mStateResources.put( val, R.drawable.tree);
            Plant gridCell01 = new Plant();
            gridCell01.setResourceID(pictureArray[1]);
            gridCell01.setCellType("Tree");
            gridCell01.setCol( column );
            gridCell01.setRow( row );
            return gridCell01;
        } else if ( x > 1000 && x < 2000 ) {
            mStateResources.put( val, R.drawable.bushes);
            Plant gridCell01 = new Plant();
            gridCell01.setResourceID(pictureArray[2]);
            gridCell01.setCellType("Bushes");
            gridCell01.setCol( column );
            gridCell01.setRow( row );
            return gridCell01;
            //bush
        } else if ( x == 2002 ) {
            mStateResources.put( val, R.drawable.clover);
            Plant gridCell01 = new Plant();
            gridCell01.setResourceID(pictureArray[4]);
            gridCell01.setCellType("Clover");
            gridCell01.setCol( column );
            gridCell01.setRow( row );
            return gridCell01;
            //clover
        } else if ( x == 2003 ) {
            mStateResources.put( val, R.drawable.mushroom);
            Plant gridCell01 = new Plant();
            gridCell01.setResourceID(pictureArray[3]);
            gridCell01.setCellType("Mushroom");
            gridCell01.setCol( column );
            gridCell01.setRow( row );
            return gridCell01;
            //mushroom
        } else if( x == 3000 ) {
            mStateResources.put( val, R.drawable.sunflower);
            Plant gridCell01 = new Plant();
            gridCell01.setResourceID(pictureArray[5]);
            gridCell01.setCellType("Sunflower");
            gridCell01.setCol( column );
            gridCell01.setRow( row );
            return gridCell01;
            //sunflower
        } else if ( x > 4000 && x < 1000000 ) {
            mStateResources.put( val, R.drawable.blank );
            GridCell gridCell01 = new GridCell();
            gridCell01.setResourceID(pictureArray[0]);
            gridCell01.setCellType("Reserved");
            gridCell01.setCol( column );
            gridCell01.setRow( row );
            return gridCell01;
            //reserved position
        } else if ( x >= 1000000 && x < 2000000 ) {
            mStateResources.put( val, R.drawable.gardender_icon);
            GardenerItem gridCell01 = new GardenerItem();
            gridCell01.setResourceID(pictureArray[6]);
            gridCell01.setCellType("Gardener");
            gridCell01.setCol( column );
            gridCell01.setRow( row );
            gridCell01.setGardenerID( getGardenerID(x) );
            return gridCell01;
            //Gardener, get ID from 1GIDXXX
        } else if ( x >= 2000000 && x < 3000000 ) {
            mStateResources.put( val, R.drawable.shovel_icon);
            GardenerItem gridCell01 = new GardenerItem();
            gridCell01.setResourceID(pictureArray[7]);
            gridCell01.setCellType("Shovel");
            gridCell01.setCol( column );
            gridCell01.setRow( row );
            gridCell01.setGardenerID( getGardenerID(x) );
            return gridCell01;
            //Shovel, get ID from 2GIDXXX
        } else if ( x >= 10000000 && x < 20000000 ) {
            mStateResources.put( val, R.drawable.golfcart_icon);
            GardenerItem gridCell01 = new GardenerItem();
            gridCell01.setResourceID(pictureArray[8]);
            gridCell01.setCellType("Cart");
            gridCell01.setCol( column );
            gridCell01.setRow( row );
            gridCell01.setGardenerID( getGardenerID2(x) );
            return gridCell01;
            //Cart, 1GIDXXXX, ID is gardener owning cart
        } else {
            mStateResources.put( val, R.drawable.blank );
            GridCell gridCell01 = new GridCell();
            gridCell01.setResourceID(pictureArray[0]);
            gridCell01.setCellType("Empty Cell");
            gridCell01.setCol( column );
            gridCell01.setRow( row );
            return gridCell01;
        }
    }

    private Integer[] pictureArray = {
            R.drawable.blank, R.drawable.tree, R.drawable.bushes, R.drawable.mushroom,
            R.drawable.clover, R.drawable.sunflower, R.drawable.gardender_icon,
            R.drawable.shovel_icon, R.drawable.golfcart_icon,
    };

    public int getGardenerID( int needID ){
        int x = needID % 1000000;
        x = x/1000;
        return x;
    }

    public int getGardenerID2( int needID ){
        int x = needID % 10000000;
        x = x/10000;
        return x;
    }
}
