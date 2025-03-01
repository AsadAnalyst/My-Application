package com.example.myapplication.ListViewExample.MultiColumnListViewExample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MyMultiColumnListAdoptor extends BaseAdapter {

    Activity activity;

    public ArrayList<HashMap<String,String>> list;

    public MyMultiColumnListAdoptor(Activity activity, ArrayList<HashMap<String, String>> list) {
        this.activity = activity;
        this.list = list;
    }

    public static final String First_Column="First";
    public static final String Second_Column="Second";
    public static final String Third_Column="Third";
    public static final String Fourth_Column="Fourth";

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater inflater =  activity.getLayoutInflater();
        if(view == null){
            view = inflater.inflate(R.layout.multi_column_list_view, null);
            viewHolder.textViewFirst = view.findViewById(R.id.txtlistfirst);
            viewHolder.textViewSecond = view.findViewById(R.id.txtlistSecond);
            viewHolder.textViewThird = view.findViewById(R.id.txtlistThird);
            viewHolder.textViewFourth = view.findViewById(R.id.txtlistfourth);
            view.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) view.getTag();
        }
        HashMap<String,String> hashMap = list.get(position);
        viewHolder.textViewFirst.setText(hashMap.get(First_Column));
        viewHolder.textViewSecond.setText(hashMap.get(Second_Column));
        viewHolder.textViewThird.setText(hashMap.get(Third_Column));
        viewHolder.textViewFourth.setText(hashMap.get(Fourth_Column));
        return view;
    }

    public class ViewHolder{
        TextView textViewFirst, textViewSecond, textViewThird, textViewFourth;

    }
}
