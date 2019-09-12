package com.example.imageswitcherapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
ImageSwitcher imageSwitcher;
Button buttonNext;

//Array of image IDs to show  in ImageSwitcher
     int imageIds[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
     int count=imageIds.length;

     int currentIndex=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonNext=findViewById(R.id.buttonNext);
        imageSwitcher=findViewById(R.id.simpleImageSwitcher);
        //set the view factor of the ImageSwitcher that will creat ImageView object when asked
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));

              return imageView;
            }
        });
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               currentIndex++;
               if (currentIndex==count)
                   currentIndex=0;
               imageSwitcher.setImageResource(imageIds[currentIndex]);
            }
        });


        //************************************************///
//Declare in And out animaitions and load them using AnimationUtils class
        Animation in= AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out=AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        //set the animation type to ImageSwither
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setInAnimation(out);
        //clickListener for NEXT button
        //when clicked on button ImageSwitcher will switch betbeen Images
        //the current Image will go OUT and next Image will come in with specified animation

    }
}
