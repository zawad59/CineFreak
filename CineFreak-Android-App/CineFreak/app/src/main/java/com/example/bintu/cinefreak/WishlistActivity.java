package com.example.bintu.cinefreak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class WishlistActivity extends AppCompatActivity {

    String s,m,m1;
    public static String ex="username";
    public static String ex2="category";
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    Databasehelper AddMovieDatabase= new Databasehelper(this);
    Infromation in;
    EditText name,r;
    String  category;
    RatingBar ratingBar;
    float a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent= getIntent();
        m=intent.getStringExtra(MenuActivity.ex3);
        setContentView(R.layout.activity_wishlist);
        name = (EditText) findViewById(R.id.moviename);
        spinner=(Spinner)(findViewById(R.id.spinner));
        adapter=ArrayAdapter.createFromResource(this,R.array.Category,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){


                category=parent.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    public void onAddToWatchlistClick(View view) {
        String Category=category+"wi";
        s=name.getText().toString()+"\n";
        Series Series = new Series(s);
        m1=AddMovieDatabase.addseries1(Series,m,Category);
        name.setText("");
        Toast t = Toast.makeText(WishlistActivity.this,"Your Wishlist Has Been Updated", Toast.LENGTH_SHORT);
        t.show();
    }
    public void onGoToWatchClick(View view) {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra(ex,m);
        intent.putExtra(ex2,"wi");
        startActivity(intent);
    }

}
