package com.example.gridviewtest;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.gridviewtest.Model.GardenerItem;
import com.example.gridviewtest.Model.GridCell;
import com.example.gridviewtest.Model.Plant;
import com.example.gridviewtest.Model.SimulationGrid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewAdapter extends BaseAdapter {

    Context myContext;
    List<String> sources;



    public GridViewAdapter(List<String> sources, Context myContext)
    {
        this.sources = sources;
        this.myContext = myContext;
    }
    @Override
    public int getCount() {
        return 256;
    }

    @Override
    public Object getItem(int i) {
        return pictureArray[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ImageView imageView;
        int x = 0;
        int gardenerID;
        String parseThis = "";
        if (view == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(myContext);
            imageView.setLayoutParams(new GridView.LayoutParams(50, 50));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(2, 2, 2, 2);
            if( SimGridFacade.sources.size() != 0)
            {
                parseThis = SimGridFacade.sources.get(i);
                x = Integer.parseInt( parseThis );
                if( x == 0 ) {
                    imageView.setImageResource(pictureArray[0]);
                } else if( x == 1000 ) {
                    imageView.setImageResource(pictureArray[1]);
                } else if ( x > 1000 && x < 2000 ) {
                    imageView.setImageResource(pictureArray[2]);
                } else if ( x == 2002 ) {
                    imageView.setImageResource(pictureArray[4]);
                } else if ( x == 2003 ) {
                    imageView.setImageResource(pictureArray[3]);
                } else if( x == 3000 ) {
                    imageView.setImageResource(pictureArray[5]);
                } else if ( x > 4000 && x < 1000000 ) {
                    imageView.setImageResource(pictureArray[0]);
                } else if ( x >= 1000000 && x < 2000000 ) {
                    imageView.setImageResource(pictureArray[6]);
                } else if ( x >= 2000000 && x < 3000000 ) {
                    imageView.setImageResource(pictureArray[7]);
                } else if ( x >= 10000000 && x < 20000000 ) {
                    imageView.setImageResource(pictureArray[8]);
                } else {
                    imageView.setImageResource(pictureArray[0]);
                }
                //simGrid01.setCell( i, gridCell01 );

            }
            else
                imageView.setImageResource(R.drawable.blank);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d( "gridView", "" + i );
                    MainActivity.text.setText( SimGridFacade.simGrid01.getCell(i).getCellInfo() + "//" +
                            SimGridFacade.simGrid01.getCell(i).getCellType() );
                }
            });
        } else
            imageView = (ImageView) view;
        return imageView;
    }

    private Integer[] pictureArray = {
            R.drawable.blank, R.drawable.tree, R.drawable.bushes, R.drawable.mushroom,
            R.drawable.clover, R.drawable.sunflower, R.drawable.gardender_icon,
            R.drawable.shovel_icon, R.drawable.golfcart_icon,
    };



}