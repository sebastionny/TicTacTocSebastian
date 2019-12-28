package com.tn.tictactocsebastian;

import android.app.Activity;

import android.content.Context;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.ImageView;

import android.widget.TextView;

public class Win extends Activity {
    TextView winn;
    Button b;
    final Context context=this;
    ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_layout);

        Intent intent = getIntent();
        String win=intent.getStringExtra("winner");
        winn=(TextView)findViewById(R.id.wintxt);
        b=(Button)findViewById(R.id.back);
        im=(ImageView)findViewById(R.id.trophy);
        im.setImageResource(R.drawable.trophy);
        winn.setText(win);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,MainActivity.class);
                startActivity(i);
            }

        });

    }

}