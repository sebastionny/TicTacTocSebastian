package com.tn.tictactocsebastian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button b, click, btnFermer;
    RadioGroup g1, g2;
    RadioButton rd;
    EditText pe1, pe2;
    //String p1, p2;
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFermer = (Button)findViewById(R.id.btnFermer);
        btnFermer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });


        click=(Button)findViewById(R.id.clickHere);
        click.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setContentView(R.layout.menu_layout);
                b=(Button)findViewById(R.id.play);
                pe1 = (EditText)findViewById(R.id.txtp1);
                pe2 = (EditText)findViewById(R.id.txtp2);


                b.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent i=new Intent(context,Game.class);
                        i.putExtra("Player1",pe1.getText().toString());
                        i.putExtra("Player2",pe2.getText().toString());
                        startActivity(i);
                    }
                });
            }
        });

    }
}