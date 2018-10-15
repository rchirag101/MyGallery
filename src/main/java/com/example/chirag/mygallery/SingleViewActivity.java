package com.example.chirag.mygallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SingleViewActivity extends Activity{

    private ScaleGestureDetector msgd;
    private float mScaleFactor=1.0f;

    ImageView imageView=null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_view);

        // Get intent data
        Intent i = getIntent();
        // Selected image id
        int position = i.getExtras().getInt("id");
        setTitle(position+".jpg");
        ImageAdapter imageAdapter = new ImageAdapter(this);
        imageView = (ImageView) findViewById(R.id.SingleView);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);
        Toast.makeText(this,"id : "+imageAdapter.mThumbIds[position].toString(), Toast.LENGTH_SHORT).show();

        msgd = new ScaleGestureDetector(this,new ScaleListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        msgd.onTouchEvent(motionEvent);
        return true;
    }

    //inner class to handle Pinch Gesture
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor  = Math.max(0.1f,Math.min(mScaleFactor,50.0f));
            
            imageView.setScaleX(mScaleFactor);
            imageView.setScaleY(mScaleFactor);

            return true;
        }
    }
}
