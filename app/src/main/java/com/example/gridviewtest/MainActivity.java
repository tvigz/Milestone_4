package com.example.gridviewtest;
import android.os.Bundle;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
public class MainActivity extends AppCompatActivity {
    private RequestQueue rQueue;
    public static TextView text;
    public GridView gridView;
    public GridViewAdapter gA1;
    static String savedCoords = "";
    static List<String> sources = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text );
        //parseJson handles request and creating the gridview following the response
        parseJson();

        //BUTTON STUFF
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_SHORT )
                        .show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Woodbye Gorld", Toast.LENGTH_SHORT )
                        .show();
            }
        });
    }

    private void parseJson(){
        rQueue = Volley.newRequestQueue(this);
        String url = "http://stman1.cs.unh.edu:6191/games";
        JsonObjectRequest jOR1 = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray jsonArr = response.getJSONArray( "grid" );
                    for( int i = 0; i < 16; i++ )
                    {
                        JSONArray jsonInner = jsonArr.getJSONArray(i);
                        for( int j = 0; j < 16; j++ )
                        {
                            sources.add( "" + jsonInner.get(j) );
                        }
                    }
                    updateGrid();
                } catch( JSONException e ) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d( "ERROR:", "InternetError" );
            }
        });
        rQueue.add( jOR1 );
    }

    public void updateGrid()
    {
        gridView = findViewById(R.id.gridView);
        gA1 = new GridViewAdapter( sources, this  );
        gridView.setAdapter(gA1);
        gridView.setNumColumns(16);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putString( savedCoords, text.getText().toString() );
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        text.setText( savedInstanceState.getString( savedCoords ) );
    }
}
