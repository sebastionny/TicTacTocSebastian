package com.tn.tictactocsebastian;

import android.app.Activity;

import android.content.Context;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;



public class DrawGame extends Activity {
    Button back;
    final Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw_layout);

        back=(Button)findViewById(R.id.drawBack);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,MainActivity.class);
                startActivity(i);
            }

        });

    }

}