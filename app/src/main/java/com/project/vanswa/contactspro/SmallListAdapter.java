package com.project.vanswa.contactspro;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by vonstuben on 11/16/2015.
 */
public class SmallListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;
    private final ArrayList<String> subValues;

    public SmallListAdapter(Context context, ArrayList<String> values,ArrayList<String> subValues){
        super(context,-1,values);
        this.context =context;
        this.values = values;
        this.subValues = subValues;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        //create new view for the added pieces of data inside my rowlayout, one header and one sub, in addition to a picture
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout,parent,false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        TextView textView1 = (TextView) rowView.findViewById(R.id.subLabel);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.iconSmall);
        textView.setText(values.get(position));
        textView1.setText(subValues.get(position));

        return rowView;
    }

}
