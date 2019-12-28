package com.tn.tictactocsebastian;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.*;

import androidx.annotation.RequiresApi;

import java.util.Arrays;
import java.util.Timer;

public class Game extends Activity {

    int player1 = 1;
    String p1 , p2;
    static int i=0;
    int pontageP1 = 0;
    int pontageP2 = 0;
    TextView pla1, pla2, pp1, pp2, status;
    Button btnMenu, btnReset;

    String[] symbols=new String[]{"","","","","","","","",""};
    int visitedp1[]={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int visitedp2[]={-1,-1,-1,-1,-1,-1,-1,-1,-1};

   final Context context=this;

    public void check(int visitedp1[], int visitedp2[])

    {
        int flag=0;


        //player1
        if((visitedp1[0]==1)&& (visitedp1[4]==1) &&(visitedp1[8]==1))
        {
            flag=1;
            pontageP1++;
        }
        else if((visitedp1[2]==1)&& (visitedp1[4]==1) &&(visitedp1[6]==1))
        {
            flag=1;
            pontageP1++;
        }
        else if((visitedp1[0]==1)&& (visitedp1[3]==1) &&(visitedp1[6]==1))
        {
            flag=1;
            pontageP1++;
        }

        else if((visitedp1[1]==1)&& (visitedp1[4]==1) &&(visitedp1[7]==1))
        {
            flag=1;
            pontageP1++;
        }
        else if((visitedp1[2]==1)&& (visitedp1[5]==1) &&(visitedp1[8]==1))
        {
            flag=1;
            pontageP1++;
        }
        else if((visitedp1[0]==1)&& (visitedp1[1]==1) &&(visitedp1[2]==1))
        {
            flag=1;
            pontageP1++;
        }
        else if((visitedp1[3]==1)&& (visitedp1[4]==1) &&(visitedp1[5]==1))
        {
            flag=1;
            pontageP1++;
        }
        else if((visitedp1[6]==1)&& (visitedp1[7]==1) &&(visitedp1[8]==1))
        {
            flag=1;
            pontageP1++;
        }


        //player2
        if((visitedp2[0]==1)&& (visitedp2[4]==1) &&(visitedp2[8]==1))
        {
            flag=1;
            pontageP2++;
        }
        else if((visitedp2[2]==1)&& (visitedp2[4]==1) &&(visitedp2[6]==1))
        {
            flag=1;
            pontageP2++;
        }
        else if((visitedp2[0]==1)&& (visitedp2[3]==1) &&(visitedp2[6]==1))
        {
            flag=1;
            pontageP2++;
        }
        else if((visitedp2[1]==1)&& (visitedp2[4]==1) &&(visitedp2[7]==1))
        {
            flag=1;
            pontageP2++;
        }
        else if((visitedp2[2]==1)&& (visitedp2[5]==1) &&(visitedp2[8]==1))
        {
            flag=1;
            pontageP2++;
        }
        else if((visitedp2[0]==1)&& (visitedp2[1]==1) &&(visitedp2[2]==1))
        {
            flag=1;
            pontageP2++;
        }
        else if((visitedp2[3]==1)&& (visitedp2[4]==1) &&(visitedp2[5]==1))
        {
            flag=1;
            pontageP2++;
        }
        else if((visitedp2[6]==1)&& (visitedp2[7]==1) &&(visitedp2[8]==1))
        {
            flag=1;
            pontageP2++;
        }

        if(flag==1)
        {
            Intent i=new Intent(context,Game.class);
            i.putExtra("pontageP1",pontageP1);
            i.putExtra("pontageP2",pontageP2);
            i.putExtra("Player1", pla1.getText().toString());
            i.putExtra("Player2", pla2.getText().toString());
            startActivity(i);
        }

        if(i==8)
        {

            status = (TextView)findViewById(R.id.status);
            status.setText("MATCH NUL");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    symbols=new String[]{"","","","","","","","",""};
                    i = 0;
                    Intent i=new Intent(context,Game.class);
                    i.putExtra("pontageP1",pontageP1);
                    i.putExtra("pontageP2",pontageP2);
                    i.putExtra("Player1", pla1.getText().toString());
                    i.putExtra("Player2", pla2.getText().toString());
                    startActivity(i);
                }
            }, 1200);
        }

    }

    TextView t;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for(int k=0;k<9;++k)
        {
            visitedp1[k]=-1;
            visitedp2[k]=-1;
        }
        i=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        // Recuperer les pontage des joueurs

        pp1 = (TextView)findViewById(R.id.PontPlayer1);
        pp2 = (TextView)findViewById(R.id.PontPlayer2);



        pla1 = (TextView)findViewById(R.id.player1);
        pla2 = (TextView)findViewById(R.id.player2);
        Intent intent = getIntent();
        p1=intent.getStringExtra("Player1");
        p2=intent.getStringExtra("Player2");
        pontageP1 =intent.getIntExtra("pontageP1",0);
        pontageP2 =intent.getIntExtra("pontageP2", 0);

        pla1.setText(p1);
        pla2.setText(p2);
        pp1.setText(Integer.toString(pontageP1));
        pp2.setText(Integer.toString(pontageP2));


        // Buttom MENU et Resset

        btnMenu = (Button)findViewById(R.id.btnmenu);
        btnReset = (Button)findViewById(R.id.btnresert);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,MainActivity.class);
                startActivity(i);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 0;
                Intent i=new Intent(context,Game.class);
                i.putExtra("pontageP1",0);
                i.putExtra("pontageP2",0);
                i.putExtra("Player1", pla1.getText().toString());
                i.putExtra("Player2", pla2.getText().toString());
                symbols=new String[]{"","","","","","","","",""};

                startActivity(i);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void tapped (View v){

        ImageView img  =  (ImageView) v;
        String tagValue = img.getTag().toString();

        if(!Arrays.asList(symbols).contains(tagValue)){

            img.setTranslationY(-1500);
            img.setTranslationZ(500);

            if(player1 == 1){
                img.setImageResource(R.drawable.x);
                img.animate().translationYBy(1500).setDuration(400);
                visitedp1[Integer.parseInt(tagValue)] = 1;
                symbols[Integer.parseInt(tagValue)] = tagValue;
                check(visitedp1,visitedp2);
                i=i+1;
                player1 = 2;
            } else {
                img.setImageResource(R.drawable.o);
                img.animate().translationYBy(1500).setDuration(400);
                visitedp2[Integer.parseInt(tagValue)] = 1;
                symbols[Integer.parseInt(tagValue)] = tagValue;
                check(visitedp1,visitedp2);
                i=i+1;
                player1 = 1;
            }

        }
    }

}
