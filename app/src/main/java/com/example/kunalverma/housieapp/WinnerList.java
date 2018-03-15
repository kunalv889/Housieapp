package com.example.kunalverma.housieapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinnerList extends AppCompatActivity {

    TextView showw1,showw2,showw3,showfw,home,restart,w1,w2,w3,w4,wtitle;
    String r1,r2,r3,hw;

    @Override
    public void onBackPressed() {
        finishAndRemoveTask();

        Intent i=new Intent(WinnerList.this,MainActivityHousie.class);
        startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View dv=getWindow().getDecorView();
        int ui=View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        dv.setSystemUiVisibility(ui);
        setContentView(R.layout.activity_winner_list);

        r1=getIntent().getStringExtra("displaywinnerr1");
        r2=getIntent().getStringExtra("displaywinnerr2");
        r3=getIntent().getStringExtra("displaywinnerr3");
        hw=getIntent().getStringExtra("displayhwinner");
      showw1=(TextView)findViewById(R.id.textView16);
        showw2=(TextView)findViewById(R.id.textView17);
        showw3=(TextView)findViewById(R.id.textView18);
        showfw=(TextView)findViewById(R.id.textView19);
        home=(TextView)findViewById(R.id.textView20);
        restart=(TextView)findViewById(R.id.textView21);
        w1=(TextView)findViewById(R.id.textView12);
        w2=(TextView)findViewById(R.id.textView13);
        w3=(TextView)findViewById(R.id.textView14);
        w4=(TextView)findViewById(R.id.textView15);
        wtitle=(TextView)findViewById(R.id.textView11);

        Typeface good=Typeface.createFromAsset(getAssets(),"goodtimes.ttf");
        Typeface sup=Typeface.createFromAsset(getAssets(),"Superr.ttf");
        //Typeface ourfont=Typeface.createFromAsset(getAssets(), "PrimeLight.otf");

        showw1.setTypeface(sup);
        showw2.setTypeface(sup);
        showw3.setTypeface(sup);
        showfw.setTypeface(sup);
        w1.setTypeface(sup);
        w2.setTypeface(sup);
        w3.setTypeface(sup);
        w4.setTypeface(sup);
        wtitle.setTypeface(good);
        wtitle.setTextSize(30);
        home.setTextSize(25);
        restart.setTextSize(25);
        home.setTypeface(good);
        restart.setTypeface(good);

        showw1.setText(r1);
        showw2.setText(r2);
        showw3.setText(r3);
        showfw.setText(hw);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ob = new Intent(WinnerList.this, MainActivityHousie.class);
                startActivity(ob);
                finish();

            }

        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAndRemoveTask();
                Intent ob= new Intent(WinnerList.this,SingleActivity.class);
                startActivity(ob);

            }
        });

    }
}
