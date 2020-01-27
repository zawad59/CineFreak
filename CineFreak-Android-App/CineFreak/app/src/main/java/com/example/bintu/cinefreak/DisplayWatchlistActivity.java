package com.example.bintu.cinefreak;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class DisplayWatchlistActivity extends ListActivity{

    String y[];
    String uid,s1="",category;
    Context context;
    TextView name,actor,actress,link,title;
    Databasehelper db=new Databasehelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_watchlist);


        final ListView listView=getListView();
        Intent i=getIntent();
        String m=i.getStringExtra("information");
        uid=i.getStringExtra("userid");
        category=i.getStringExtra("category");
        int length=0;

            final String x[] = m.split("\n");
        Arrays.sort(x);
            y = x;
            length=x.length;
        if(m.equals(" ") || m.equals("\n")) {
            length=0;
        }
        title=(TextView)(findViewById(R.id.mol));
        title.setText("         You have added\n"+length+ " movies to this category");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, x);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new ListView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View view, int position, long row_id) {
                // Process the long-click
                Toast t = Toast.makeText(DisplayWatchlistActivity.this, "Movie Infromation has been deleted", Toast.LENGTH_SHORT);
                t.show();
                String s=x[position];
                for(int i=0;i<x.length;i++)
                {
                    if(!x[i].equals(s))
                        s1+=x[i]+"\n";
                }
                 db.update(s1,category,uid);
                 db.delete(s+uid+"\n");
                 return true;
            }
        });
    }

    public void onListItemClick(ListView parent, View v, int position, long id)
    {

        String s=y[position];
        MovieInformation info = db.searchMovieInfo(s+uid);
        LayoutInflater inflater = getLayoutInflater();

        View vi = inflater.inflate(R.layout.activity_display_movie_info, null); //log.xml is your file.
        name=(TextView)vi.findViewById(R.id.movienametext1);
        name.setText(s);
        actor=(TextView)vi.findViewById(R.id.movieactortext);
        actor.setText("Director: "+info.getActor());
        actress=(TextView)vi.findViewById(R.id.movieactress);
        actress.setText("Stars: "+info.getActress());
        RatingBar rating=(RatingBar) vi.findViewById(R.id.movierating);
        float r = Float.parseFloat(info.getRating());
        rating.setRating(r);
        // rating.setStepSize(Float.parseFloat(info.getRating()));
        link=(TextView)vi.findViewById(R.id.movielink);
        link.setText(info.getLink());
        Toast t = Toast.makeText(DisplayWatchlistActivity.this,s, Toast.LENGTH_SHORT);
        t.show();
        AlertDialog.Builder  mbBuilder=new AlertDialog.Builder(DisplayWatchlistActivity.this);

        mbBuilder.setView(vi);
        AlertDialog d=mbBuilder.create();
        d.show();
        /*Intent intent = new Intent(this, DisplayMovieInfoActivity.class);
        intent.putExtra(ex,s);
        startActivity(intent);*/
    }
}
