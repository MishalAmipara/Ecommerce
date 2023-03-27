package com.example.ecommerceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends BaseAdapter
{
    Context context;
    ArrayList<DataModel> dataModels = new ArrayList<>();

    public DataAdapter(Context context, ArrayList<DataModel> dataModels) {
        this.context = context;
        this.dataModels=dataModels;
    }

    @Override
    public int getCount() {
        System.out.println("Size="+dataModels.size());
        return dataModels.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.view_data_item,viewGroup,false);
        TextView tvId=view.findViewById(R.id.txtId);
        TextView tvName=view.findViewById(R.id.txtName);
        TextView tvUname=view.findViewById(R.id.txtUname);
        TextView tvEmail=view.findViewById(R.id.txtemail);
        System.out.println("Position="+i);
        tvId.setText(""+dataModels.get(i));
        DataModel model=dataModels.get(i);
        tvId.setText(model.getId());
        tvName.setText(model.getName());
        tvUname.setText(model.getUname());
        tvEmail.setText(model.email);
        System.out.println("Name="+model.getName());

        return view;
    }
}
