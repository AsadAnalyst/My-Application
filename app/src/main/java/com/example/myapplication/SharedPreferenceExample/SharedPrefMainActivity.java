package com.example.myapplication.SharedPreferenceExample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class SharedPrefMainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_pref_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferences=getSharedPreferences("MyFile",0);
    }

    public void Save_pref(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("K1",100);
        editor.putString("K2","Ali");
        editor.commit();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }

    public void Show_Pref(View view) {
        int value1= sharedPreferences.getInt("K1",0);
        String value2= sharedPreferences.getString("K2","");
        Toast.makeText(this, "value 1 "+value1+" value12"+value2, Toast.LENGTH_SHORT).show();
    }
}