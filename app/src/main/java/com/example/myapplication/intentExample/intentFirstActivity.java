package com.example.myapplication.intentExample;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

public class intentFirstActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_first);
        textView = findViewById(R.id.btn);

        textView.setText("0");
        //textView=setText(a);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }

    public void Add_One(View view) {
        int currentValue = Integer.parseInt(String.valueOf(textView.getText()));
        int newValue = currentValue + 1;
        textView.setText(String.valueOf(newValue));
    }

    public void send_data_To_second_activity(){
        Intent intent = new Intent(this, intentSecondActivity.class);
        intent.putExtra("Key1","50");
        intent.putExtra("Key2","20");
        startActivity(intent);
    }

    public void Show_Tost(View view) {
        //Toast.makeText(this, "My Toast", Toast.LENGTH_SHORT).show();

        Snackbar.make(view,"My Toast", Snackbar.LENGTH_SHORT).show();
    }
}