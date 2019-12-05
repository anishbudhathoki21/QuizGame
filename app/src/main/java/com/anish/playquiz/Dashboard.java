package com.anish.playquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Dashboard extends AppCompatActivity {

    TextView tvUn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tvUn=(TextView)findViewById(R.id.tvUn);
        Intent intent=getIntent();
        String userName=intent.getStringExtra("USERNAME");
        tvUn.setText(userName);

    }
}