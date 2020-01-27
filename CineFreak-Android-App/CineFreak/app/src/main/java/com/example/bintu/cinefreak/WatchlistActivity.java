package com.example.bintu.cinefreak;

import android.content.Intent;
import android.graphics.Color;
import android.icu.util.ULocale;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class WatchlistActivity extends AppCompatActivity {

    String s,userid,m1;
    public static String ex="username";
    public static String ex2="category";
    Spinner spinner;
    ArrayAdapter<CharSequence>adapter;
    Databasehelper AddMovieDatabase= new Databasehelper(this);
    Infromation in;
    EditText name,r,actor,actress,link;
    String  category;
    RatingBar ratingBar;
    float rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchlist);
        Intent intent= getIntent();
        userid=intent.getStringExtra(MenuActivity.ex3);
        name = (EditText) findViewById(R.id.moviename);
        actor=(EditText)findViewById(R.id.actorname);
        actress=(EditText)findViewById(R.id.actressname);
        link=(EditText)findViewById(R.id.linkname);
        addListenerOnRatingBar();
        spinner=(Spinner)(findViewById(R.id.spinner));
        adapter=ArrayAdapter.createFromResource(this,R.array.Category,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent,View view,int position,long id){


                category=parent.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.rating);
        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                rate=rating;

            }
        });
    }

    public void onAddToWatchlistClick(View view) {
        String Category=category+"wa";
        s=name.getText().toString()+"\n";
        Series Series = new Series(s);
        MovieInformation movieInformation=new MovieInformation(name.getText().toString()+userid,actor.getText().toString(),actress.getText().toString(),link.getText().toString(),String.valueOf(rate));
        m1=AddMovieDatabase.addseries1(Series,userid,Category);
        AddMovieDatabase.mo(movieInformation);
        name.setText("");
        actor.setText("");
        actress.setText("");
        link.setText("");
        //category.set("");
        ratingBar.setRating(0F);
       // String string="4.5";
      //  float rating = Float.parseFloat(string);
      //  ratingBar.setRating(rating);
        Toast t = Toast.makeText(WatchlistActivity.this,"Your Watchlist Has Been Updated", Toast.LENGTH_SHORT);
        t.show();
    }
    public void onGoToWatchClick(View view) {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("username",userid);
        intent.putExtra("category","wa");
        startActivity(intent);
    }
}
