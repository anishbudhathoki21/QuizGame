package com.anish.playquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.content.SharedPreferences;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean saveLogin;
    CheckBox rememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.etUsername);
        password=(EditText)findViewById(R.id.etPassword);
        login=(Button)findViewById(R.id.btnLogin);
        sharedPreferences=getSharedPreferences("loginref",MODE_PRIVATE);
        rememberMe=(CheckBox)findViewById(R.id.chkRem);
        editor=sharedPreferences.edit();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();
            }
        });
        saveLogin=sharedPreferences.getBoolean("savelogin",true);
        if(saveLogin==true)
        {
            username.setText(sharedPreferences.getString("username",null));
            password.setText(sharedPreferences.getString("password",null));
        }

    }

    public void login()
    {
        String uname=username.getText().toString();
        String pswd=password.getText().toString();

        if (uname.equals("admin") && pswd.equals("admin")
        ) {
//            MainActivity.this.startActivity(new Intent(MainActivity.this, Dashboard.class));
//
//            MainActivity.this.finish();
//            Toast.makeText(this,"username and password match",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getApplicationContext(),Dashboard.class);
            intent.putExtra("USERNAME",uname);
            startActivity(intent);
            if(rememberMe.isChecked())
            {
                editor.putBoolean("Savelogin",true);
                editor.putString("username",uname);
                editor.putString("password",pswd);
                editor.commit();

            }
        }
        else
        {
            Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
        }
        }

}
