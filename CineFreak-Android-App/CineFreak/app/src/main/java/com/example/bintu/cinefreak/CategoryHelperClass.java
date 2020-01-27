package com.example.bintu.cinefreak;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.resource;

/**
 * Created by bintu on 2/10/2017.
 */

public class CategoryHelperClass extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] resource;
    public final int images[];

    public CategoryHelperClass(Activity context, String[] resource, int[]images) {
        super(context, R.layout.categoryhelper,resource);
        this.images = images;
        this.context = context;
        this.resource = resource;
    }
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.categoryhelper,null,false);
        //String s = getItem(position);
        TextView t = (TextView)v.findViewById(R.id.text1);
        ImageView i1 = (ImageView)v.findViewById(R.id.icon);

        t.setText(resource[position]);
        i1.setImageResource(images[position]);

        return v;
    }


}
