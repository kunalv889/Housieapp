package com.example.kunalverma.housieapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;
import android.os.Handler;
import android.widget.Toast;

public class HousieBoard extends AppCompatActivity {
    TextView Htable[][]=new TextView[10][10],tv27,tv33;
    int i,j,p,n,hot=0,q;
    ImageButton ibut,ibut2;
    Button okbut,diabutok,ok,cancel;
    Switch s1,s4;
    EditText ed;
    TextToSpeech tts;
    TextView prevcoin,tv24,tv26,tv28,tv29,tv32,  tv11,tv12,leave,tv37;
    RelativeLayout rlauto,rltable;
    int Ht[]=new int[90];
    Random Tran=new Random();
    int ischecked=0,isbuttonon=0,isautoon=0;
    Dialog dia;
    Dialog quitdial;


    Handler handler=new Handler();




    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            View decorView= getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View dv=getWindow().getDecorView();

        int ui=View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;

        dv.setSystemUiVisibility(ui);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        View dv=getWindow().getDecorView();
        int ui=View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        dv.setSystemUiVisibility(ui);


        setContentView(R.layout.activity_housie_board);
       // dialog=new Dialog(HousieBoard.this);

      /*  Window window=dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT);  */
       // dialog.setContentView(R.layout.sample_my_view);
       // dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);


        dia=new Dialog(HousieBoard.this);
        dia.setContentView(R.layout.previouscoin_layout);
        dia.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);

        quitdial=new Dialog(HousieBoard.this);
        quitdial.setContentView(R.layout.dialog_layout);
        quitdial.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);


        Typeface ourfont=Typeface.createFromAsset(getAssets(), "PrimeLight.otf");                       //SETTING FONTS START
        Typeface dig=Typeface.createFromAsset(getAssets(),"digital.ttf");
        Typeface KGT=Typeface.createFromAsset(getAssets(),"KGTraditional.ttf");
        Typeface sup=Typeface.createFromAsset(getAssets(),"Superr.ttf");
        Typeface good=Typeface.createFromAsset(getAssets(),"goodtimes.ttf");



        ibut=(ImageButton)findViewById(R.id.imageButton5);
        ibut2=(ImageButton)findViewById(R.id.imageButton4);
        tv27=(TextView)findViewById(R.id.textView27);
        tv26=(TextView)findViewById(R.id.textView26);

        leave=(TextView)findViewById(R.id.textView25);
        tv24=(TextView)findViewById(R.id.textView24);
        tv37=(TextView)findViewById(R.id.textView37);
        s1=(Switch)findViewById(R.id.switch1);
        s4=(Switch)findViewById(R.id.switch4);
        ed=(EditText)findViewById(R.id.editText2);
        okbut=(Button)findViewById(R.id.button7);
        prevcoin=(TextView)dia.findViewById(R.id.textView9);
        tv11=(TextView)dia.findViewById(R.id.textView23);
        diabutok=(Button)dia.findViewById(R.id.button5);
        ok=(Button)quitdial.findViewById(R.id.dialog_ok);
        cancel=(Button)quitdial.findViewById(R.id.dialog_cancel);
        tv28=(TextView)findViewById(R.id.textView34);
        tv29=(TextView)findViewById(R.id.textView35);
        tv32=(TextView)findViewById(R.id.textView36);
        rlauto=(RelativeLayout)findViewById(R.id.RLAUTO);
        rltable=(RelativeLayout)findViewById(R.id.relativeLayout22);
        tv12=(TextView)quitdial.findViewById(R.id.textView22);

        tv24.setTypeface(ourfont);
        tv24.setTextSize(40);
        leave.setTypeface(ourfont);
        leave.setTextSize(25);
        tv26.setTypeface(sup);
        tv26.setTextSize(25);
        s1.setTypeface(sup);
        s1.setTextSize(20);
        s4.setTypeface(sup);
        s4.setTextSize(20);

        tv27.setTypeface(dig);
        tv27.setTextSize(40);
        tv28.setTypeface(ourfont);
        tv29.setTypeface(ourfont);
        tv32.setTypeface(ourfont);
        ed.setTypeface(ourfont);
        tv12.setTypeface(good);
        tv11.setTypeface(good);
        tv37.setTypeface(good);
        tts =new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR)
                {
                    tts.setLanguage(Locale.UK);
                }
            }
        });


        /*ed.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm=(InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                }
                return false;
            }
        }); */
        ed.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                InputMethodManager keyboard=(InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if(hasFocus)
                    keyboard.showSoftInput(ed,0);
                else
                    keyboard.hideSoftInputFromWindow(ed.getWindowToken(),0);
            }
        });

        ed.requestFocus();
        for(i=0;i<9;i++)
        {
            for(j=0;j<=9;j++)
            {
                if(i==0&&j==0){continue;}
                String TextId3="textViewT"+i+""+j;
                int resID3=getResources().getIdentifier(TextId3,"id",getPackageName());
                Htable[i][j]=(TextView)findViewById(resID3);
                Htable[i][j].setTypeface(KGT);
                Htable[i][j].setTextSize(30);
                Animation animationright= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_right);
                Animation animationleft= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_left);
                if(j<6&&j>0){
                    Htable[i][j].startAnimation(animationright);
                }
                else
                    Htable[i][j].startAnimation(animationleft);
            }
        }
        try {
            String textid4="textViewT90";
            int resID4=getResources().getIdentifier(textid4,"id",getPackageName());
            Htable[9][0] = (TextView) findViewById(resID4);
            Htable[9][0].setTypeface(KGT);
            Htable[9][0].setTextSize(30);
            Animation animationright= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_left);
            Htable[9][0].startAnimation(animationright);

        }
        catch(Exception e){}






        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isbuttonon = 1;

                } else {
                    isbuttonon =0;
                }
            }
        });

        s4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ischecked=0;
                    isautoon = 1;
                    rlauto.setVisibility(View.VISIBLE);
                    Animation fadein=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                    rlauto.startAnimation(fadein);
                    Animation moveright=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_righttozero);
                    rltable.startAnimation(moveright);

                    rltable.setVisibility(View.INVISIBLE);
                    ibut.setEnabled(false);
                    ibut2.setEnabled(false);


                } else {
                    isautoon = 0;

                        if(ischecked==0) {
                            rltable.setVisibility(View.VISIBLE);
                            Animation fadeout = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                            rlauto.startAnimation(fadeout);
                            Animation moveleft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_left);
                            rltable.startAnimation(moveleft);
                            rlauto.setVisibility(View.INVISIBLE);
                            ischecked = 0;
                        }
                    else if(ischecked>1)
                        {
                            rltable.setVisibility(View.VISIBLE);
                            rlauto.setVisibility(View.INVISIBLE);
                            ischecked=0;
                        }



                    ibut.setEnabled(true);
                    ibut2.setEnabled(true);
                }


            }
        });





        HTable();
        prevCoin(0);
        quitactivity();
        ibut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // if (isautoon== 1){}


                if (hot <= 89 && isautoon== 0) {
                    randomselect(hot);
                }
                prevCoin(hot);
                hot++;
                if(hot>90){
                    restart();
                }

            }

        });




        okbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Animation fadeout=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                rlauto.startAnimation(fadeout);
                rlauto.setVisibility(View.INVISIBLE);
                rltable.setVisibility(View.VISIBLE);
                Animation moveleft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_left);
                rltable.startAnimation(moveleft);
                View dv=getWindow().getDecorView();
                int ui=View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                dv.setSystemUiVisibility(ui);


                if(isautoon==1)
                autoselect();

            }

        });





    }


    void restart()
    {
        tv37.setVisibility(View.VISIBLE);
       // s1.setVisibility(View.INVISIBLE);
       // s4.setVisibility(View.INVISIBLE);
        s1.setEnabled(false);
        s4.setEnabled(false);
        tv26.setVisibility(View.INVISIBLE);
        tv27.setVisibility(View.INVISIBLE);
      tv37.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              s1.setEnabled(true);
              s4.setEnabled(true);
              Intent i=new Intent(HousieBoard.this,HousieBoard.class);
              startActivity(i);
              finish();
          }
      });
    }

void autoselect(){


       String value = ed.getText().toString();
       int desiredValue=Integer.parseInt(value);
       int desired=desiredValue*1000;


    Handler mhandler = new Handler();
    mhandler.postDelayed(new Runnable() {
        @Override
        public void run() {

            if (isautoon == 1 && hot < 90) {
                randomselect(hot);
                System.out.println("loop no" + hot);
                hot++;
                if(hot>=90){
                    restart();
                }
            }
            if (isautoon == 1 && hot < 90)
                autoselect();
            ischecked++;
            prevCoin(hot-1);



        }
    }, desired);


}



    void HTable()
    {
        p=0;
        try {

            for (i = 0; i < 90;i++) {

                n = 1 + Tran.nextInt(90);                                                   //NUMBER GENERATION CODE AND COMPARING

                Ht[i] = n;
                for (j = 0; j <= i - 1; j++) {
                    if (Ht[i] != Ht[j]) {
                        p++;

                    } else if (Ht[i] == Ht[j])

                    {
                        p = 0;
                        break;
                    }
                }


                if (p > 0 || i == 0)                                                   //PRINTING OF ALL 100 RANDOM NUMBERS
                {
                    System.out.println("random no" + (i + 1) + "\t=>" + Ht[i]);
                } else
                    i--;
            }
        }
        catch(Exception e){}

    }

    void randomselect(int hot){

        System.out.println("Inside randomselect"+hot);

        String text= new Integer(Ht[hot]).toString();

      if(isbuttonon==1) {


            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }

        int y,u;
        y=Ht[hot]/10;
        u=Ht[hot]%10;
        Htable[y][u].setBackground(getResources().getDrawable(R.drawable.tablebackground2));

        if(y>0)
            tv27.setText(Integer.toString(Ht[hot]));
        else
            tv27.setText("0"+Integer.toString(Ht[hot]));

    }




    public Runnable ute=new Runnable() {
        @Override
        public void run() {
            int r;
            long cur=System.currentTimeMillis();
            Random raa=new Random();
            r=1+raa.nextInt(90);
            tv27.setText(Integer.toString(r));
            handler.postAtTime(this,cur);
            handler.postDelayed(ute,50);
        }
    };






    void prevCoin(final int rap ){

        ibut2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (rap == 0) {
                    prevcoin.setText("Null");
                    dia.show();
                } else if (rap >= 1) {
                    try {
                        System.out.println("inside prevcoin");
                        if (Ht[rap - 1] > 9) {
                            prevcoin.setText(Integer.toString(Ht[rap - 1]));
                            dia.show();
                        } else if (Ht[rap - 1] < 10) {
                            prevcoin.setText("0" + Integer.toString(Ht[rap - 1]));
                            dia.show();
                        }
                    } catch (Exception e) {
                        System.out.println("exception");
                        Toast.makeText(HousieBoard.this, "exception", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });
        diabutok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dia.hide();

            }
        });
    }






    void quitactivity(){

        leave.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {


                quitdial.show();

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(HousieBoard.this, MainActivityHousie.class);
                        startActivity(i);
                       isbuttonon=0;
                        finish();

                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Toast.makeText(SingleActivity.this, "cancel pressed", Toast.LENGTH_SHORT).show();
                        quitdial.hide();

                    }
                });

            }
        });

    }





    void quitactivityy() {


        quitdial.show();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Toast.makeText(SingleActivity.this, "ok pressed", Toast.LENGTH_SHORT).show();
                Intent ob=new Intent(HousieBoard.this,MainActivityHousie.class);
                startActivity(ob);
              isbuttonon=0;
                finish();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(SingleActivity.this, "cancel pressed", Toast.LENGTH_SHORT).show();
                quitdial.hide();
            }
        });
    }






    @Override
    public void onBackPressed() {

        quitactivityy();
    }




}


