package com.example.projekakhir_pam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projekakhir_pam.adapter.DataAdapter;
import com.example.projekakhir_pam.database.bookingdata;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class riwayat extends AppCompatActivity {

    TextView homee;
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private ArrayList<bookingdata> bookingdataArrayList = new ArrayList<>();

    private static final String TAG       = Home.class.getSimpleName();
    private static String  url_select     = "https://20200140120.praktikumtiumy.com/bacateman.php";
    public  static final String TAG_ID    = "id";
    public  static final String TAG_NAMA  = "nama";
    public  static final String TAG_NoTelepon  = "no telepon";
    public  static final String TAG_NoKTP  = "no ktp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);

        homee=findViewById(R.id.home);

        homee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent it = new Intent(getApplicationContext(), Home.class);
                startActivity(it);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.btnadd);
        BacaData();
        adapter = new DataAdapter(bookingdataArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(riwayat.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter((RecyclerView.Adapter) adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(riwayat.this, inputdata2.class);
                startActivity(intent);
            }
        });
    }

    public void  BacaData(){

        bookingdataArrayList.clear();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        JsonArrayRequest jArr = new JsonArrayRequest(url_select, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());

                // parsing json
                for (int i = 0; i < response.length(); i++) {

                    try {
                        JSONObject obj = response.getJSONObject(i);

                        bookingdata item = new bookingdata();

                        item.setId(obj.getString(TAG_ID));
                        item.setNama(obj.getString(TAG_NAMA));
                        item.setTanggallahir(obj.getString(TAG_NoTelepon));
                        item.setJeniskelamin(obj.getString(TAG_NoKTP));


                        // menambah item ke array
                        bookingdataArrayList.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                error.printStackTrace();
                Toast.makeText(riwayat.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jArr);
    }

}