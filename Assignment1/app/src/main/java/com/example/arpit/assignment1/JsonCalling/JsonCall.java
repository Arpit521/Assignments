package com.example.arpit.assignment1.JsonCalling;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.arpit.assignment1.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonCall extends AppCompatActivity implements View.OnClickListener {

    public static final String JSON_URL = "http://stg.msupply.com/product/api/v1.0/productList";

    private Button buttonGet;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_call);

        buttonGet = (Button) findViewById(R.id.buttonGet);
        buttonGet.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.listView);
    }

    private void sendRequest(){

        Map<String,String> map = new HashMap<>();
        map.put("category1","Plumbing");
        //map.put("keyValueFilters",List<"PipesAndFittings">);
        map.put("itemsPerPage","10");
        map.put("page","1");
        map.put("skuNameSort","1");


        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST,JSON_URL,new JSONObject(map),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("the response is  ", String.valueOf(response));
                        showJSON(response);

                    }
                }, new Response.ErrorListener()

                    {

                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Log.e("error in the response ",error.toString());


                        }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(objectRequest);
    }

    private void showJSON(JSONObject json){

        String  jsonString=json.toString();
        Gson gson=new Gson();
      // Log.d("sangeet","arpit"+jsonString);
        messageUser ob=gson.fromJson(jsonString,messageUser.class);

        //Log.e("arpit",ob.getMessage().getImagePrefixURL());





    }

    @Override
    public void onClick(View v) {

        sendRequest();
    }

}
