package com.example.projekakhir_pam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class rincianbooking extends AppCompatActivity {

    TextView txTask, txjenis, txLama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rincianbooking);
        txTask = findViewById(R.id.inputnama);
        txjenis = findViewById(R.id.inputtelp);
        txLama = findViewById(R.id.inputktp);
        Bundle bundle = getIntent().getExtras();
        String task = bundle.getString("x");
        String jenis = bundle.getString("y");
        String lama = bundle.getString("z");
        txTask.setText(task);
        txjenis.setText(jenis);
        txLama.setText(lama);
    }
}