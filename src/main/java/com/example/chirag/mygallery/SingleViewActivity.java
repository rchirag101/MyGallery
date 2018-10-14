package com.example.chirag.mygallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by chirag on 13-10-2018.
 */

public class SingleViewActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_view);

        // Get intent data
        Intent i = getIntent();
        // Selected image id
        int position = i.getExtras().getInt("id");
        setTitle(position+".jpg");
        ImageAdapter imageAdapter = new ImageAdapter(this);
        ImageView imageView = (ImageView) findViewById(R.id.SingleView);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);
        Toast.makeText(this,"id : "+imageAdapter.mThumbIds[position].toString(), Toast.LENGTH_SHORT).show();
    }
}
