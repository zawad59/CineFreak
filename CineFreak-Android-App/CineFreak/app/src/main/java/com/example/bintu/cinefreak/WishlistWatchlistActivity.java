package com.example.bintu.cinefreak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class WishlistWatchlistActivity extends AppCompatActivity {


    String userid,ex3="username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist_watchlist);

        Intent i=getIntent();
        userid=i.getStringExtra(MenuActivity.ex3);

    }

    public void onViewWatchlistClick2(View v)
    {
        Intent i = new Intent(this,CategoryActivity.class);
        i.putExtra("username",userid);
        i.putExtra("category","wa");
        startActivity(i);
    }

    public void onViewWishlistClick2(View v)
    {
        Intent i = new Intent(this,CategoryActivity.class);
        i.putExtra("username",userid);
        i.putExtra("category","wi");
        startActivity(i);
    }
}
