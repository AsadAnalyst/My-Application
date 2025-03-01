package com.example.myapplication.intentExample;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class intentSecondActivity extends AppCompatActivity {
TextView txtvalue1;
TextView txtvalue2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_second);
        txtvalue1 = findViewById(R.id.txtintentvalue1);
        txtvalue2 = findViewById(R.id.txtintentvalue2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        int value1 = intent.getIntExtra("Key1",0);
        int value2 = intent.getIntExtra("Key2",0);
        txtvalue1.setText(String.valueOf(value1));
        txtvalue2.setText(String.valueOf(value2));


    }
}