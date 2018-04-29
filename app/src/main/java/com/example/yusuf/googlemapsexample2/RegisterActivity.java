package com.example.yusuf.googlemapsexample2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Yusuf on 28.04.2018.
 */

public class RegisterActivity extends AppCompatActivity {

      private Button registerBtn;
      private EditText nametxt,emailtxt1,emailtxt2,passtxt1,passtxt2;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerlayout);

        Identify();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }


        });

    }
    protected void Identify(){
        // tüm arayüz elemanlarını bu metotla tanımla
        registerBtn= (Button) findViewById(R.id.registerbtn);
        nametxt= (EditText) findViewById(R.id.nameEditText);
        emailtxt1= (EditText) findViewById(R.id.emailEditText);
        emailtxt2= (EditText) findViewById(R.id.emailEditText2);
        passtxt1= (EditText) findViewById(R.id.passwordEditText);
        passtxt2= (EditText) findViewById(R.id.passwordEditText2);
    }
    protected void registerUser(){

    }
}
