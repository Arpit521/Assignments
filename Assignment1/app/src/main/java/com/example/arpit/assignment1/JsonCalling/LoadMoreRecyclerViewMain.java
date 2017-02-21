package com.example.arpit.assignment1.JsonCalling;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.arpit.assignment1.R;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


public class LoadMoreRecyclerViewMain extends AppCompatActivity {


    Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    // private List < message > mUsers = new ArrayList < > ();
    private UserAdapter mUserAdapter;
    private List<products> mUsers;

    public static final String JSON_URL = "http://stg.msupply.com/product/api/v1.0/productList";

    private Button buttonGet;
    static int  mPagenumber = 0;

    private ListView listView;
    static int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_more_recycler_view_main);

       /* buttonGet = (Button) findViewById(R.id.buttonGet);

        listView = (ListView) findViewById(R.id.listView);
*/
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(llm);
       /* buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //progressBar.setVisibility(View.VISIBLE);
                sendRequest();
            }
        });*/



       /* mUserAdapter = new UserAdapter(this, mUsers, mRecyclerView);
        mRecyclerView.setAdapter(mUserAdapter);*/

        sendRequest();
    }

    private void sendRequest() {


        Map<String, String> map = new HashMap<>();
        map.put("category1", "Plumbing");
        //map.put("keyValueFilters",List<"PipesAndFittings">);
        map.put("itemsPerPage", "10");
        map.put("page", String.valueOf(mPagenumber));
        map.put("skuNameSort", "1");


        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, JSON_URL, new JSONObject(map),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                       // Log.e("the response is  ", String.valueOf(response));
                        showJSON(response);

                    }
                }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("error in the response ", error.toString());


            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(objectRequest);


    }

    private void showJSON(JSONObject json) {

        String jsonString = json.toString();
        Gson gson = new Gson();
    //    Log.d("sangeet","arpit"+jsonString);
        messageUser ob = gson.fromJson(jsonString, messageUser.class);
        mUsers = ob.getMessage().getProducts();
       // mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


       // llm.setOrientation(LinearLayoutManager.VERTICAL);

        if (mUserAdapter == null) {
            mUserAdapter = new UserAdapter(this, mUsers, mRecyclerView);
            mRecyclerView.setAdapter(mUserAdapter);
        } else {

            //Log.d("arpit",""+count);
            mUserAdapter.appendList(mUsers);
           mUserAdapter.notifyDataSetChanged();

        }

        mUserAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
              //  Log.e("haint", "Load More");
                mUsers.add(null);
            mUserAdapter.notifyItemInserted(mUsers.size() - 1);
                //Load more data for reyclerview
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Log.e("haint", "Load More 2");
                         //mPagenumber++;
                       // sendRequest();

                        //Remove loading item
                   mUserAdapter.notifyItemRemoved(mUsers.size());
                        mUserAdapter.notifyDataSetChanged();
                        mPagenumber++;
                      //  Log.d("arpit",""+mPagenumber);
                        sendRequest();
                        mUserAdapter.setLoaded();
                        //Load data
                            /*int index = mUsers.size();
                            int end = index + 20;
                            for (int i = index; i < end; i++) {
                                User user = new User();
                                user.setName("Arpit " + i);
                                user.setEmail("Arpit Gupta" + i + "@gmail.com");
                                // mUsers.add(user);
                            }*/
                    //   mUserAdapter.notifyDataSetChanged();
                       // mUserAdapter.setLoaded();
                    }
                }, 2000);
                // sendRequest();
            }

        });
    }


    /* @Override protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_load_more_recycler_view_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        mToolbar.setTitle("LoadMoreRecycleView");
         for (int i = 0; i < 30; i++) {
             User user = new User();
             user.setName("Arpit " + i);
             user.setEmail("Arpit Gupta" + i + "@gmail.com");
             mUsers.add(user);
         }
         mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
         mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
         mUserAdapter = new UserAdapter(this,mUsers,mRecyclerView);
         mRecyclerView.setAdapter(mUserAdapter);
         mUserAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
             @Override public void onLoadMore() {
                 Log.e("haint", "Load More");
                 mUsers.add(null);
                 mUserAdapter.notifyItemInserted(mUsers.size() - 1);
                 //Load more data for reyclerview
                 new Handler().postDelayed(new Runnable() {
                     @Override public void run() {
                         Log.e("haint", "Load More 2");
                         //Remove loading item
                         mUsers.remove(mUsers.size() - 1);
                         mUserAdapter.notifyItemRemoved(mUsers.size());
                         //Load data
                         int index = mUsers.size();
                         int end = index + 20;
                         for (int i = index; i < end; i++) {
                             User user = new User();
                             user.setName("Arpit " + i);
                             user.setEmail("Arpit Gupta" + i + "@gmail.com");
                             mUsers.add(user);
                         }
                         mUserAdapter.notifyDataSetChanged();
                         mUserAdapter.setLoaded();
                     }
                 }, 2000);
             }
         });
     }*/
   /* static class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvEmailId;
        public ImageView tvImage;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvEmailId = (TextView) itemView.findViewById(R.id.tvEmailID);
            tvImage=(ImageView) itemView.findViewById(R.id.imagejson);
        }
    }

    static class LoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar1);
        }


    }*/

}