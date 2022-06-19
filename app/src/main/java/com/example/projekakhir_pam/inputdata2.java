package com.example.projekakhir_pam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class inputdata2 extends AppCompatActivity {


    private EditText ednama, ednotelp, ednoktp;
    private Button fab;
    String nama, tlp, ktp, namaa ,nm;
    int success;

    private static String url_insert = "http://10.0.2.2:80/biodatanew/";
    private static final String TAG = inputdata2.class.getSimpleName();
    private static final String TAG_SUCCES = "success";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputdata2);

        ednama=findViewById(R.id.inputnama);
        ednotelp=findViewById(R.id.inputtelp);
        ednoktp=findViewById(R.id.inputktp);

        Bundle bundle = getIntent().getExtras();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), riwayat.class);
                startActivity(intent);
                SimpanData();
            }
        });

    }

    public void SimpanData() {
        if (ednama.getText().toString().equals("") || ednotelp.getText().toString().equals("") || ednoktp.getText().toString().equals("")) {
            Toast.makeText(inputdata2.this, "Semua Harus diisi Data!", Toast.LENGTH_SHORT).show();
        } else {
            nm = ednama.getText().toString();
            tlp = ednotelp.getText().toString();
            ktp = ednoktp.getText().toString();

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

            StringRequest strReq = new StringRequest(Request.Method.POST, url_insert, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d(TAG, "Response : " + response.toString());

                    try {
                        JSONObject jobj = new JSONObject(response);

                        success = jobj.getInt(TAG_SUCCES);
                        if (success == 1) {
                            Toast.makeText(inputdata2.this, "Sukses Simpan Data", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(inputdata2.this, "Gagal", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG, "Error : " + error.getMessage());

                    Toast.makeText(inputdata2.this, "Gagal Simpan Data!", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();

                    params.put("nama", nm);
                    params.put("No Telepon", tlp);
                    params.put("No KTP", ktp);



                    return params;
                }
            };
            requestQueue.add(strReq);
        }
    }


}