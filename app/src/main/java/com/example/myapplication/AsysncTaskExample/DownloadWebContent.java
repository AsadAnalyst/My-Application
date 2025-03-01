package com.example.myapplication.AsysncTaskExample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class DownloadWebContent extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_download_web_content);
        editText=findViewById(R.id.edtwebcontent);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Download_Content(View view) {
        DownloadWeb_Content obj = new DownloadWeb_Content();
        try {
            String value=obj.execute("https:/www.google.com/").get();
            Log.d("TAG","Back In Main");
            editText.setText(value);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    class DownloadWeb_Content extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            Log.d("TAG","doInBackground() is in Progress");
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader=new InputStreamReader(inputStream);
                int mydata = reader.read();
                String webcontent="";

                while (mydata!=-1){
                    char ch = (char) mydata;
                    webcontent+=ch;
                    mydata=reader.read();
                }
                return webcontent;

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}