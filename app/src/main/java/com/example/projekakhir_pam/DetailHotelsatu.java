package com.example.projekakhir_pam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailHotelsatu extends AppCompatActivity {

    TextView back;
    Button booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotelsatu);

        back=findViewById(R.id.btnback1);
        booking=findViewById(R.id.btnbooking);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent it = new Intent(getApplicationContext(), Home.class);
                startActivity(it);
            }
        });

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent it = new Intent(getApplicationContext(), inputdata2.class);
                startActivity(it);
            }
        });
    }
}