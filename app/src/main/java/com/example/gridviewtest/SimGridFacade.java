package com.example.gridviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gridviewtest.Model.SimulationGrid;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class SimGridFacade {

    static SimulationGrid simGrid01 = new SimulationGrid( 256 );
    Activity activity;
    static List<String> sources = new ArrayList<>();
    public GridViewAdapter gA1;
    public GridView gridView;
    int count = 0;
    public GridCellFactory gcf1 = new GridCellFactory();
    //public static TextView text;

    public SimGridFacade(Activity act1){
        activity = act1;
    }

    public void setUsingJSON( JSONArray jsonArr ) {
        try{
            for( int i = 0; i < 16; i++ )
            {
                JSONArray jsonInner = jsonArr.getJSONArray(i);
                for( int j = 0; j < 16; j++ )
                {
                    String addThis = "" + jsonInner.get(j);
                    int x = Integer.parseInt( addThis );
                    simGrid01.setCell( count, gcf1.makeCell( count, x ));
                    count++;
                    sources.add( addThis );
                }
            }
            updateGrid();
        } catch( JSONException e ) {
            e.printStackTrace();
        }
    }

    public void updateGrid()
    {
        gridView = activity.findViewById(R.id.gridView);
        gA1 = new GridViewAdapter( sources, activity  );
        gridView.setAdapter(gA1);
        gridView.setNumColumns(16);
    }


    private Integer[] pictureArray = {
            R.drawable.blank, R.drawable.tree, R.drawable.bushes, R.drawable.mushroom,
            R.drawable.clover, R.drawable.sunflower, R.drawable.gardender_icon,
            R.drawable.shovel_icon, R.drawable.golfcart_icon,
    };



}
