package com.example.myapplication.ListViewExample.MultiColumnListViewExample;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiColumnListViewMainActivity extends AppCompatActivity {

    ListView listView;
    public ArrayList<HashMap<String,String>> list;
    public static final String First_Column="First";
    public static final String Second_Column="Second";
    public static final String Third_Column="Third";
    public static final String Fourth_Column="Fourth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multi_column_list_view_main);
        listView=findViewById(R.id.lstmulticolumn);
        LoadData();
        MyMultiColumnListAdoptor adoptor = new MyMultiColumnListAdoptor(this,list);
        listView.setAdapter(adoptor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void LoadData(){

        list = new ArrayList<HashMap<String,String>>();
        HashMap<String, String> hashMap1 = new HashMap<String ,String >();
        hashMap1.put(First_Column,"Asad");
        hashMap1.put(Second_Column,"Usama");
        hashMap1.put(Third_Column,"Hamza");
        hashMap1.put(Fourth_Column,"Shakeel");
        list.add(hashMap1);

        HashMap<String, String> hashMap2 = new HashMap<String ,String >();
        hashMap2.put(First_Column,"Maria");
        hashMap2.put(Second_Column,"Madhia");
        hashMap2.put(Third_Column,"Shargena");
        hashMap2.put(Fourth_Column,"Haseena");
        list.add(hashMap2);

        HashMap<String, String> hashMap3 = new HashMap<String ,String >();
        hashMap3.put(First_Column,"BMW");
        hashMap3.put(Second_Column,"Porsha");
        hashMap3.put(Third_Column,"Marcedees");
        hashMap3.put(Fourth_Column,"Toyata");
        list.add(hashMap3);

        HashMap<String, String> hashMap4 = new HashMap<String ,String >();
        hashMap4.put(First_Column,"Alpha");
        hashMap4.put(Second_Column,"Beta");
        hashMap4.put(Third_Column,"Gamma");
        hashMap4.put(Fourth_Column,"Samma");
        list.add(hashMap4);

    }
}