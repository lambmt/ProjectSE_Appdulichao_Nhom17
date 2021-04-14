package com.example.appdulichao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdulichao.R;
import com.example.appdulichao.model.Typeaccess;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TypeaccessAdapter extends BaseAdapter {
    ArrayList<Typeaccess> arrayListtypeaccess;
    Context context;

    public TypeaccessAdapter(ArrayList<Typeaccess> arrayListtypeaccess, Context context) {
        this.arrayListtypeaccess = arrayListtypeaccess;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListtypeaccess.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListtypeaccess.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        TextView txtTypeaccess;
        ImageView imgTypeaccess;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_listview_typaccess, null);
            viewHolder.txtTypeaccess = (TextView) convertView.findViewById(R.id.textviewTypeaccess);
            viewHolder.imgTypeaccess = (ImageView) convertView.findViewById(R.id.imageviewTypeaccess);
            convertView.setTag(viewHolder);
        }else   {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Typeaccess typeaccess = (Typeaccess) getItem(position);
        viewHolder.txtTypeaccess.setText(typeaccess.getTypeaccess_name());
        Picasso.with(context).load(typeaccess.getTypeaccess_img())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imgTypeaccess);
        return convertView;
    }
}
