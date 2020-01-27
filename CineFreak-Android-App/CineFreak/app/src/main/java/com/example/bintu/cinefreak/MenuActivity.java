package com.example.bintu.cinefreak;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    public static final String ex3="userid";
    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent= getIntent();
        String message=intent.getStringExtra(LoginActivity.ex);
        userid=intent.getStringExtra(LoginActivity.ex2);
        TextView textView= (TextView)(findViewById(R.id.hello));

        textView.setText(message);
    }

    public void logout(View v)
    {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
        finish();
    }
    public void addmovies(View v)
    {
        Intent i = new Intent(this,WatchlistActivity.class);
        i.putExtra(ex3,userid);
        startActivity(i);
    }
    public void onaddwishlistClick(View v)
    {
        Intent i = new Intent(this,WishlistActivity.class);
        i.putExtra(ex3,userid);
        startActivity(i);
    }
    public void onViewMovieClick(View v)
    {
        Intent i = new Intent(this,WishlistWatchlistActivity.class);
        i.putExtra(ex3,userid);
        startActivity(i);
    }

    public void onGoToImdbClick(View v)
    {
        Uri uri = Uri.parse("http://www.imdb.com"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
