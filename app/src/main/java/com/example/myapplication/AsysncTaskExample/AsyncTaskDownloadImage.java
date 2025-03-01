package com.example.myapplication.AsysncTaskExample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class AsyncTaskDownloadImage extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_async_task_download_image);
        imageView=findViewById(R.id.imgAsynctask);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Download_Image(View view) {
        ImageDownload obj = new ImageDownload();
        try {
            Bitmap bitmap=obj.execute("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBjQEuHP8tAQTFSAv4fxKH6Q7Xz5yvSiFZRg&s").get();
            imageView.setImageBitmap(bitmap);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    class ImageDownload extends AsyncTask<String,Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            URL url =null;
            try {
                url=new URL(strings[0]);
                try {
                    HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                    connection.connect();
                    InputStream inputStream= connection.getInputStream();
                    Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                    return bitmap;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}