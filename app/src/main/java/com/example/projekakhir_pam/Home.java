package com.example.projekakhir_pam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    ImageView imghotel1, imghotel2;
    TextView riwayat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imghotel1=findViewById(R.id.pichotelsatu);
        imghotel2=findViewById(R.id.pichoteldua);
        riwayat=findViewById(R.id.rwyt);


        imghotel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent it = new Intent(getApplicationContext(), DetailHotelsatu.class);
                startActivity(it);
            }
        });

        riwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent it = new Intent(getApplicationContext(), riwayat.class);
                startActivity(it);
            }
        });
    }
}