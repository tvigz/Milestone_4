package com.example.gridviewtest;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewAdapter extends BaseAdapter {

    Context myContext;
    List<String> sources;
    private Map<Integer, Integer> mStateResources = new HashMap<Integer, Integer>();

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
        if (view == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(myContext);
            imageView.setLayoutParams(new GridView.LayoutParams(50, 50));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(2, 2, 2, 2);
            if( MainActivity.sources.size() != 0)
            {
                if( MainActivity.sources.get(i).equalsIgnoreCase("0") ) {
                    mStateResources.put(i, R.drawable.p2);
                    imageView.setImageResource(pictureArray[1]);
                }
                else {
                    mStateResources.put( i, R.drawable.p1);
                    imageView.setImageResource(pictureArray[0]);
                }
            }
            else
                imageView.setImageResource(pictureArray[1]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d( "gridView", "" + i );
                    int row = (int) Math.ceil( (i) / 16 );
                    int column = ( i % 16 );
                    if( mStateResources.get( i ) == R.drawable.p1 )
                        MainActivity.text.setText("(" + (row+1) + "," + (column+1) + ")" + " // nonzero");
                    else
                        MainActivity.text.setText("(" + (row+1) + "," + (column+1) + ")" + " // zero");
                }
            });
        } else
            imageView = (ImageView) view;
        return imageView;
    }

    private Integer[] pictureArray= {
            R.drawable.p1, R.drawable.p2
    };
}