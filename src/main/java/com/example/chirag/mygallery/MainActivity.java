package com.example.chirag.mygallery;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Chirag Ramchandanee");
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
        // Send intent to SingleViewActivity
        Intent i = new Intent(getApplicationContext(), SingleViewActivity.class);
        // Pass image index
        Toast.makeText(this,"Clicked image : "+position, Toast.LENGTH_SHORT).show();
        i.putExtra("id", position);
        startActivity(i);
    }
}
