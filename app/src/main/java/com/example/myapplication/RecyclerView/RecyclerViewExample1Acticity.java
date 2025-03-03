package com.example.myapplication.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewExample1Acticity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapterRecyclerView myAdapterRecyclerView;
    List <Mobile> mobileList = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view_example1_acticity);
        recyclerView=findViewById(R.id.recyclerViewExample1);
        LoadData();
        myAdapterRecyclerView=new MyAdapterRecyclerView(mobileList);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapterRecyclerView);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void LoadData(){
        Mobile mobile1=new Mobile("Note 1","Sumsung","5000");
        mobileList.add(mobile1);
        Mobile mobile2=new Mobile("Note 2","Sumsung","10000");
        mobileList.add(mobile2);
        Mobile mobile3 = new Mobile("Note 3","Sumsung","20000");
        mobileList.add(mobile3);
        myAdapterRecyclerView.notifyDataSetChanged();
    }
}