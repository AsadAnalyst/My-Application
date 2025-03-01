package com.example.myapplication.intentExample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class AlertDialogeExample extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alert_dialoge_example);
        textView = findViewById(R.id.txtshow);
        textView.setText("0");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void Open_Alert_Dialoge(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogeExample.this);
        builder.setMessage("Are you Sure").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogeExample.this, "Okay Click", Toast.LENGTH_SHORT).show();

                int currentValue = Integer.parseInt(String.valueOf(textView.getText()));
                int newValue = currentValue + 1;
                textView.setText(String.valueOf(newValue));
            }
        }).setNegativeButton("Cancel",null);
        AlertDialog alert = builder.create();
        alert.show();
    }
}