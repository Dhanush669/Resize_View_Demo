package com.devgd.swipetoopen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView=findViewById(R.id.cardView);
        cardView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int sizeX,sizeY,size;
                if(motionEvent.getPointerCount()>1) {
                    Log.i("checking for pointer", String.valueOf(motionEvent.getPointerId(1)));
                    int first=motionEvent.getPointerId(0);
                    int second=motionEvent.getPointerId(1);
                    sizeX= (int) (motionEvent.getX(first)-motionEvent.getX(second));
                    sizeY= (int) (motionEvent.getY(first)-motionEvent.getY(second));
                    if(sizeX<0){
                        sizeX*=-1;
                    }
                    if(sizeY<0){
                        sizeY*=-1;
                    }
                    if(sizeX>sizeY)
                        size=sizeX;
                    else
                        size=sizeY;
                    cardView.getLayoutParams().height=size;
                    cardView.getLayoutParams().width=size;
                    cardView.requestLayout();
                }
                return true;
            }
        });
    }
}