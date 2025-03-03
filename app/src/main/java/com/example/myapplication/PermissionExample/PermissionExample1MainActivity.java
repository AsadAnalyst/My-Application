package com.example.myapplication.PermissionExample;

import static android.Manifest.permission.CAMERA;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class PermissionExample1MainActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_permission_example1_main);
        textView=findViewById(R.id.txtPermission1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Request_For_permission(View view) {
        if (!cheack_Permission()){
            Request_Permission();
        }
        else {
            textView.setText("Permission Already Granted");
        }

    }

    public void Cheack_For_Permission(View view) {
        if (!cheack_Permission()){
            textView.setText("Permission Deniad");
        }
        else {
            textView.setText("Permission Granted");
        }
    }

    public boolean cheack_Permission(){
        int R1= ContextCompat.checkSelfPermission(this,CAMERA);
        return R1 == PackageManager.PERMISSION_GRANTED;
    }
    public void Request_Permission(){
        ActivityCompat.requestPermissions(this, new String[]{CAMERA},101);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults, int deviceId) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults, deviceId);
        if (requestCode==101 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            textView.setText("Permission Granted");
        }
    }
}