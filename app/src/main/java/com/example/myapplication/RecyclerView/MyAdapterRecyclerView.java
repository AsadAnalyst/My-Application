package com.example.myapplication.RecyclerView;

import android.icu.text.Transliterator;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterRecyclerView extends RecyclerView.Adapter<MyAdapterRecyclerView.ViewHolder> {
    private List<Mobile> mobileList;

    public MyAdapterRecyclerView(List<Mobile> mobileList) {
        this.mobileList = mobileList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_mobile_layout,parent,false);
        ViewHolder obj = new ViewHolder(view);
        return obj;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mobile mobile= mobileList.get(position);
        holder.mobilePrice.setText(mobile.getMobilePrice());
        holder.mobileCompany.setText(mobile.getMobileCompany());
        holder.mobileName.setText(mobile.getMobileName());
    }

    @Override
    public int getItemCount() {
        return mobileList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mobileName;
        TextView mobileCompany;
        TextView mobilePrice;
        public ViewHolder(@NonNull View view) {
            super(view);
            mobileName=view.findViewById(R.id.txtMobileName);
            mobileCompany=view.findViewById(R.id.txtMobileCompany);
            mobileName=view.findViewById(R.id.txtMobilePrice);
        }

    }
}
