package com.example.yusuf.googlemapsexample2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Yusuf on 28.04.2018.
 */

public class MainMenuActivity extends AppCompatActivity {
    Button quickSearchBtn,HistoryBtn,GmapsBtn,SettingsBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenulayout);

        quickSearchBtn= (Button) findViewById(R.id.quickfindbtn);
        HistoryBtn= (Button) findViewById(R.id.historybtn);
        GmapsBtn= (Button) findViewById(R.id.GmapsBtn);
        SettingsBtn= (Button) findViewById(R.id.SettingsBtn);
        
        quickSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 28.04.2018  en yakın boş otopark konumunu mapste gösteren activity'e yönlendir
            }
        });
        HistoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 28.04.2018 Geçmiş otoparklar ve reserve edilen spotları gösteren activity'e yölendir
            }
        });
        GmapsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 28.04.2018 Google maps i aç ve otoparkları harita üzerinde göster 
            }
        });
        SettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 28.04.2018 Kullanici ayarlarının yapıldığı activity e yönlendir 
            }
        });
        
    }
}
