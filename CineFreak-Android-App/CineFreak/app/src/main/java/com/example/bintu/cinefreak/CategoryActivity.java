package com.example.bintu.cinefreak;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.app.ListActivity;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CategoryActivity extends Activity {

    ListView listview;
    public final int images[]= {
            R.drawable.nw,
            R.drawable.smr,
            R.drawable.new1,
            R.drawable.new2,
            R.drawable.new3,
            R.drawable.new4,
            R.drawable.new5,
            R.drawable.new6
    };
    public static String ex="information",u="userid";
    Databasehelper AddMovieDatabase= new Databasehelper(this);

    String x[] ={"Horror","Romantic","Scientific","Thriller","Action","Animation","Comedy","Other"};
    String username,category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        CategoryHelperClass adapter = new CategoryHelperClass(this, x, images);
        listview = (ListView) (findViewById(R.id.list));
        listview.setAdapter(adapter);

        Intent i=getIntent();
        Bundle bundle=i.getExtras();
        username=bundle.getString("username");
        category=bundle.getString("category");
        listview.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s=(x[position])+category;
                String dbString = AddMovieDatabase.displayMovie(username,s);
                Intent intent = new Intent(getApplicationContext(), DisplayWatchlistActivity.class);
                intent.putExtra(u,username);
                intent.putExtra(ex,dbString);
                intent.putExtra("category",s);
                startActivity(intent);
            }

            //public void onItemClick
        });

    }

}
