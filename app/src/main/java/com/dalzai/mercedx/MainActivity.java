package com.dalzai.mercedx;

import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId())
        {
            case R.id.locate_us:
                String loc = "https://www.google.com/maps/search/?api=1&query=mercedes+benz+beverly+hills";
                Uri locationUri = Uri.parse(loc);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,locationUri);
                startActivity(mapIntent);
                return true;
            case R.id.call_us:
                Uri callUri = Uri.parse("tel:+1555999444");
                Intent callIntent = new Intent(Intent.ACTION_DIAL,callUri);
                startActivity(callIntent);
                return true;
            case R.id.about_us:
                String web = "https://www.mercedes-benz.com/en/company/";
                Uri webUri = Uri.parse(web);
                Intent webIntent = new Intent(Intent.ACTION_VIEW,webUri);
                startActivity(webIntent);
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void merc(View view)
    {
        String web = "https://www.mbusa.com/en/home";
        Uri webUri = Uri.parse(web);
        Intent webIntent = new Intent(Intent.ACTION_VIEW,webUri);
        startActivity(webIntent);
    }

    public void amg(View view)
    {
        String web = "https://www.mercedes-amg.com/en.html";
        Uri webUri = Uri.parse(web);
        Intent webIntent = new Intent(Intent.ACTION_VIEW,webUri);
        startActivity(webIntent);
    }

    public void smart(View view)
    {
        String web = "https://www.smart.com/int/en/home";
        Uri webUri = Uri.parse(web);
        Intent webIntent = new Intent(Intent.ACTION_VIEW,webUri);
        startActivity(webIntent);
    }
}
