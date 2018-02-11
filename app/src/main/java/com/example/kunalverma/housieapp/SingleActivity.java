package com.example.kunalverma.housieapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;
import android.os.Handler;

public class SingleActivity extends AppCompatActivity {


    TextView Ticket1[][]=new TextView[3][9];
    TextView Ticket2[][]=new TextView[3][9];
    TextView Htable[][]=new TextView[10][10];
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10;
    TextView winner1,winner2,winner3,prevcoin;
    String winr1,winr2,winr3,hwin;
    ImageButton quitbutton;
    ImageButton b5,b6;
    Button ok,cancel;
    TextToSpeech tts;
    boolean isb6clickable=true;

    int i,j,k=0,t,p=0,temp=0,temp01,temp02,temp03,temp1,r,n,fin=0;
    int row1A = 0, row2A = 0, row3A = 0, row1B = 0, row2B = 0, row3B = 0,hot=0;
    int [][][]b=new int[2][3][10];
    int [][]a=new int[2][15];
    int []Ht=new int [90];
    Random ran=new Random();
    Random Tran=new Random();

  Dialog dialog;
    Dialog dia;
    

    Handler handler=new Handler();


    @Override
    public void onBackPressed() {

        quitactivityy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       View dv=getWindow().getDecorView();
        int ui=View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
       dv.setSystemUiVisibility(ui);




        setContentView(R.layout.activity_single);
        dialog = new Dialog(SingleActivity.this);
        dialog.setContentView(R.layout.dialog_layout);
       dia=new Dialog(SingleActivity.this);
        dia.setContentView(R.layout.previouscoin_layout);

        Typeface ourfont=Typeface.createFromAsset(getAssets(), "PrimeLight.otf");                       //SETTING FONTS START
        Typeface dig=Typeface.createFromAsset(getAssets(),"digital.ttf");
        Typeface KGT=Typeface.createFromAsset(getAssets(),"KGTraditional.ttf");
        Typeface sup=Typeface.createFromAsset(getAssets(),"Superr.ttf");
        Typeface good=Typeface.createFromAsset(getAssets(),"goodtimes.ttf");




        for(i=0;i<3;i++)
        {
            for(j=0;j<9;j++)
            {
                String TextID="textView1"+i+""+j;
                int resID=getResources().getIdentifier(TextID,"id",getPackageName());
                Ticket1[i][j]=(TextView)findViewById(resID);
                Ticket1[i][j].setTypeface(KGT);
                Ticket1[i][j].setTextSize(21);


                String TextID2="textView2"+i+""+j;
                int resID2=getResources().getIdentifier(TextID2,"id",getPackageName());
                Ticket2[i][j]=(TextView)findViewById(resID2);
                Ticket2[i][j].setTypeface(KGT);
                Ticket2[i][j].setTextSize(21);
            }
        }
        for(i=0;i<9;i++)
        {
            for(j=0;j<=9;j++)
            {
                if(i==0&&j==0){continue;}
                String TextId3="textViewT"+i+""+j;
                int resID3=getResources().getIdentifier(TextId3,"id",getPackageName());
                Htable[i][j]=(TextView)findViewById(resID3);
                Htable[i][j].setTypeface(KGT);
                Htable[i][j].setTextSize(17);
            }
        }
        try {
            String textid4="textViewT90";
            int resID4=getResources().getIdentifier(textid4,"id",getPackageName());
            Htable[9][0] = (TextView) findViewById(resID4);
            Htable[9][0].setTypeface(KGT);
            Htable[9][0].setTextSize(17);
        }
        catch(Exception e){}

        tts =new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR)
                {
                    tts.setLanguage(Locale.UK);
                }
            }
        });
         b5 = (ImageButton)findViewById(R.id.imageButton2);
        b6=(ImageButton)findViewById(R.id.imageButton3);
         tv1=(TextView)findViewById(R.id.TVWinnerRow1);
         tv2=(TextView)findViewById(R.id.TVWinnerRow2);
         tv3=(TextView)findViewById(R.id.TVWinnerRow3);
        tv8=(TextView)findViewById(R.id.textView8);
        tv4=(TextView)findViewById(R.id.textView2);
        tv5=(TextView)findViewById(R.id.textView3);
        tv6=(TextView)findViewById(R.id.textView4);
        tv7=(TextView)findViewById(R.id.textView6);
        tv10=(TextView)findViewById(R.id.textView10);
        winner1=(TextView)findViewById(R.id.WinnerRow1);
        winner2=(TextView)findViewById(R.id.WinnerRow2);
        winner3=(TextView)findViewById(R.id.WinnerRow3);
        tv9=(TextView)findViewById(R.id.textView5);
        quitbutton=(ImageButton)findViewById(R.id.imageButton);
        ok=(Button)dialog.findViewById(R.id.dialog_ok);
        cancel=(Button)dialog.findViewById(R.id.dialog_cancel);
        prevcoin=(TextView)dia.findViewById(R.id.textView9);

        tv4.setTypeface(ourfont);
        tv5.setTypeface(sup);
        tv6.setTypeface(sup);
        tv7.setTypeface(sup);
        tv8.setTypeface(dig);
        tv10.setTypeface(sup);
        tv3.setTypeface(good);
        tv2.setTypeface(good);
        tv1.setTypeface(good);
        winner1.setTypeface(good);
        winner2.setTypeface(good);
        winner3.setTypeface(good);
        tv9.setTypeface(sup);
        prevcoin.setTypeface(good);




                                                                                                       //FONT SETTING ENDS

        iniTicket(0);                                                                                //FUNCTIONS CALLED
        genTicket(0);
        printTicket(0);
        iniTicket(1);
        genTicket(1);
        printTicket(1);
        HTable();
        prevCoin(0);
        quitactivity();


            if (isb6clickable==true) {
                b6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        starttextview();
                        Handler haan = new Handler();
                        haan.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                stoptextview();
                                tv8.setText(Integer.toString(Ht[hot]));
                                System.out.println(hot);
                                WinnerGenerator(hot);
                                prevCoin(hot);
                                hot = hot + 1;
                            }
                        }, 1000);


                    }
                });

            }
    }                                                                                                   //ONCREATE ENDS


    void iniTicket(int n)
    {
        for(i=0;i<3;i++)                    //INTIALIZING EACH VALUE TO BE 0
        {
            for(j=0;j<9;j++)
            {
                b[n][i][j]=0;
            }
        }
    }


    void prevCoin(final int rap ){

        b5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(rap==0)
                {
                    prevcoin.setText("NO PREVOIUS COIN");
                    dia.show();
                }
                else if (rap >= 1) {
                    try {

                        prevcoin.setText(Integer.toString(Ht[rap-1]));
                        dia.show();
                    } catch (Exception e) {
                        Toast.makeText(SingleActivity.this, "exception", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });
    }



    void quitactivity(){
      //  window.setGravity(Gravity.TOP);
        quitbutton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                dialog.show();
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //   Toast.makeText(SingleActivity.this, "ok pressed", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Toast.makeText(SingleActivity.this, "cancel pressed", Toast.LENGTH_SHORT).show();
                        dialog.hide();
                    }
                });

            }
        });

    }
    void quitactivityy() {


        dialog.show();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Toast.makeText(SingleActivity.this, "ok pressed", Toast.LENGTH_SHORT).show();
                Intent ob=new Intent(SingleActivity.this,MainActivityHousie.class);
                finish();
                startActivity(ob);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(SingleActivity.this, "cancel pressed", Toast.LENGTH_SHORT).show();
                dialog.hide();
            }
        });
    }

    void genTicket(int n)
    {
        r=0;
        for(i=0;i<15;i++)                                 //NUMBER GENERATION CODE AND COMPARING
        {

            t = 1 + ran.nextInt(90);

            a[n][i] = t;
            for (j = 0; j <= i - 1; j++) {
                if (a[n][i] != a[n][j]) {
                    p++;
                } else if (a[n][i] == a[n][j]) {
                    p = 0;
                    break;
                }
            }


            if (p > 0 || i == 0)                        //SETTING IN ORDER
            {

                temp = a[n][i];
                System.out.println(temp);
                temp1 = temp / 10;
                try {
                    if (b[n][r][temp1] == 0 && temp != 90) {
                        b[n][r][temp1] = a[n][i];
                    } else if (b[n][r][8] == 0 && temp == 90) {
                        b[n][r][8] = 90;
                    } else {
                        i--;
                        continue;
                    }

                } catch (Exception ArrayIndexOutOFBondException)           //EXCEPTION HANDLING
                {
                }


                if ((i + 1) % 5 == 0 && i < 14)            //NEW LINE GENERATION
                {
                    //  System.out.println("");
                    r = r + 1;
                }
            } else
                i--;

        }



        for(i=0;i<9;i++)                                        //CODE FOR SETTING IN INCREASING ORDER
        {
            temp01=b[n][0][i];
            temp02=b[n][1][i];
            temp03=b[n][2][i];
            if(temp01==temp02||temp01==temp03||temp02==temp03)
                continue;


            else if(temp01!=0&&temp02!=0&&temp03!=0)
            {
                if(temp01<temp02&&temp01<temp03)
                {
                    b[n][0][i]=temp01;
                    if(temp02<temp03)
                    {
                        b[n][1][i]=temp02;
                        b[n][2][i]=temp03;
                    }
                    else
                    {
                        b[n][1][i]=temp03;
                        b[n][2][i]=temp02;

                    }
                }
                else if(temp02<temp01&&temp02<temp03)
                {
                    b[n][0][i]=temp02;
                    if(temp01<temp03)
                    {
                        b[n][1][i]=temp01;
                        b[n][2][i]=temp03;
                    }
                    else
                    {
                        b[n][1][i]=temp03;
                        b[n][2][i]=temp01;
                    }
                }
                else
                {
                    b[n][0][i]=temp03;
                    if(temp01<temp02)
                    {
                        b[n][1][i]=temp01;
                        b[n][2][i]=temp02;
                    }
                    else
                    {
                        b[n][1][i]=temp02;
                        b[n][2][i]=temp01;
                    }
                }
            }
            else
            {
                if(temp01==0)
                {
                    if(temp02<temp03)
                    {
                        b[n][1][i]=temp02;
                        b[n][2][i]=temp03;
                    }
                    else
                    {
                        b[n][1][i]=temp03;
                        b[n][2][i]=temp02;
                    }
                }
                else if(temp02==0)
                {
                    if(temp01<temp03)
                    {
                        b[n][0][i]=temp01;
                        b[n][2][i]=temp03;
                    }
                    else
                    {
                        b[n][0][i]=temp03;
                        b[n][2][i]=temp01;
                    }
                }
                else
                {
                    if(temp01<temp02)
                    {
                        b[n][0][i]=temp01;
                        b[n][1][i]=temp02;
                    }
                    else
                    {
                        b[n][0][i]=temp02;
                        b[n][1][i]=temp01;
                    }
                }

            }
        }                                       //CODE FOR INCREASING ORDER ENDS HERE

    }




    void printTicket(int n)
    {
        if (n==0) {
            for (i = 0; i < 3; i++)                       //  PRINTING OF TICKET 1
            {
                for (j = 0; j < 9; j++) {
                    temp = b[n][i][j];
                    if (temp == 0) {
                        System.out.print("0" + b[n][i][j] + " ");
                        Ticket1[i][j].setText(" ");
                    } else {
                        System.out.print(b[n][i][j] + " ");
                        try {
                            if (b[n][i][j] / 10 > 0)
                                Ticket1[i][j].setText("" + b[n][i][j]);
                            else
                                Ticket1[i][j].setText("0" + b[n][i][j]);
                        } catch (Exception ArrayIndexOutOfBondException) {
                        }
                    }
                }
                System.out.println("");
            }
        }
        else if (n==1)
        {
            for(i=0;i<3;i++)                       //  PRINTING OF TICKET 1
            {
                for (j = 0; j < 9; j++) {
                    temp = b[n][i][j];
                    if (temp == 0) {
                        System.out.print("0" + b[n][i][j] + " ");
                        Ticket2[i][j].setText(" ");
                    } else {
                        System.out.print(b[n][i][j] + " ");
                        try {
                            if(b[n][i][j]/10>0)
                                Ticket2[i][j].setText(""+b[n][i][j]);
                            else
                                Ticket2[i][j].setText("0"+b[n][i][j]);
                        } catch (Exception ArrayIndexOutOfBondException) {
                        }
                    }
                }
                System.out.println("");
            }
        }
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






    void WinnerGenerator(int i) {




        System.out.println("outer loop");
        String text= new Integer(Ht[i]).toString();
       // tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);

              try {

                    int y,u;

                    y=Ht[i]/10;
                    u=Ht[i]%10;
                    Htable[y][u].setBackground(getResources().getDrawable(R.drawable.tablebackground2));
                  int x=Ht[i];
                  System.out.println(x);
                   tv8.setText(Integer.toString(x));

                      for (j = 0; j < 3; j++) {
                                  for (k = 0; k < 9; k++) {
                                      if (Ht[i] == b[0][j][k]) {

                                          Ticket1[j][k].setBackground(getResources().getDrawable(R.drawable.capture3));
                                          if (j == 0)
                                              row1A = row1A + 1;
                                          else if (j == 1)
                                              row2A = row2A + 1;
                                          else if (j == 2)
                                              row3A = row3A + 1;
                                      }
                                  }
                              }

                              for (j = 0; j < 3; j++) {
                                  for (k = 0; k < 9; k++) {
                                      if (Ht[i] == b[1][j][k]) {
                                          Ticket2[j][k].setBackground(getResources().getDrawable(R.drawable.capture3));
                                          if (j == 0)
                                              row1B = row1B + 1;
                                          else if (j == 1)
                                              row2B = row2B + 1;
                                          else if (j == 2)
                                              row3B = row3B + 1;
                                      }
                                  }                                                                           //COMPARRING ROWS AND GENERATED NUNBERS END HERE
                              }
                              // System.out.println("random no" + (i + 1) + "\t=>" + Ht[i]);


                              if (row1A == 5 || row1B == 5)                                   //FOR DISPLAYING THE WINNER
                              {                                                         //FOR ROW NO 1
                                  if (row1A == 5) {
                                      System.out.println("Row 1 winner is player 1 ");
                                      tv1.setText("YOU");
                                      winr1="YOU";
                                      row1B = row1B + 6;
                                      row1A = row1A + 6;
                                      fin++;
                                  } else if (row1B == 5) {
                                      System.out.println("Row 1 winner is android");
                                      tv1.setText("ANDROID");
                                      winr1="ANDROID";
                                      row1A = row1A + 6;
                                      row1B = row1B + 6;
                                      fin++;
                                  }
                              }


                              if (row2A == 5 || row2B == 5)                                //FOR ROW NO 2
                              {
                                  if (row2A == 5) {
                                      System.out.println("Row 2 winner is PLayer 1 ");
                                      tv2.setText("YOU");
                                      winr2="YOU";
                                      row2B = row2B + 6;
                                      row2A = row2A + 6;
                                      fin++;
                                  } else if (row2B == 5) {
                                      System.out.println("Row 2 winner is android");
                                      tv2.setText("ANDROID");
                                      winr2="ANDROID";
                                      row2A = row2A + 6;
                                      row2B = row2B + 6;
                                      fin++;
                                  }
                              }


                              if (row3A == 5 || row3B == 5)                                      //FOR ROW NO 3
                              {
                                  if (row3A == 5) {
                                      System.out.println("Row 3 winner is player 1");
                                      tv3.setText("YOU");
                                      winr3="YOU";
                                      row3B = row3B + 6;
                                      row3A = row3A + 6;
                                      fin++;
                                  } else if (row3B == 5) {
                                      System.out.println("ANDROID");
                                      tv3.setText("ANDROID");
                                      winr3="ANDROID";
                                      row3A = row3A + 6;
                                      row3B = row3B + 6;
                                      fin++;
                                  }
                              }


                              System.out.println("value of Ht[" + i + "] is" + Ht[i]);
                            if(fin==3){

                                isb6clickable=false;
                                if(winr1==winr2&&winr1==winr3){
                                    hwin=winr1;
                                }
                                else if(winr1==winr2){
                                    hwin=winr1;
                                }
                                else if(winr2==winr3){
                                    hwin=winr2;
                                }
                                else if(winr3==winr1){
                                    hwin=winr3;
                                }
                                Intent ob=new Intent(SingleActivity.this,WinnerList.class);
                                finish();
                                ob.putExtra("displaywinnerr1", winr1);
                                ob.putExtra("displaywinnerr2", winr2);
                                ob.putExtra("displaywinnerr3", winr3);
                                ob.putExtra("displayhwinner",hwin);
                                startActivity(ob);
                            }




             }
            catch(Exception e){
                System.out.println("error");
            }

    }




    public Runnable ute=new Runnable() {
        @Override
        public void run() {
            int r;
            long cur=System.currentTimeMillis();
            Random raa=new Random();
            r=1+raa.nextInt(90);
            tv8.setText(Integer.toString(r));
            handler.postAtTime(this,cur);
            handler.postDelayed(ute,50);
        }
    };
         boolean istextviewstarted=false;

    public  void starttextview()
    {
        if(istextviewstarted==false){
            handler.removeCallbacks(ute);
            handler.postDelayed(ute,50);
            istextviewstarted=true;
        }
    }

    public void stoptextview(){
        handler.removeCallbacks(ute);
        istextviewstarted=false;
    }



}