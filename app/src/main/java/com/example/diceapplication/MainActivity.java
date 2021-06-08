package com.example.diceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int dice1Value;
    int dice2Value;
    int computerResult;
    int userResult;


    int getResource(int number)
    {
        switch (number)
        {
            case 0:
                return R.drawable.dice1;
            case 1:
                return R.drawable.dice2;
            case 3:
                return R.drawable.dice4;
            case 4:
                return R.drawable.dice5;
            case 5:
                return R.drawable.dice6;
            case 2:
                return R.drawable.dice3;
            default:
                return R.drawable.dice1;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice1Value = 1;
        dice2Value = 1;
        computerResult = -1;
        userResult = -1;

        ImageView iv = (ImageView) findViewById(R.id.imageLogo);
        ImageView fd = (ImageView) findViewById(R.id.firstDiceImage);
        ImageView sd = (ImageView) findViewById(R.id.secondDiceImage);
        TextView cs = findViewById(R.id.computerString);
        TextView us = findViewById(R.id.userString);
        TextView res = findViewById(R.id.resultPrinter);
        fd.setImageDrawable(getDrawable(R.drawable.dice1));
        sd.setImageDrawable(getDrawable(R.drawable.dice2));
        iv.setImageDrawable(getDrawable(R.drawable.dicee_logo));

        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int c1 = getRandom();
                int c2 = getRandom();
                int u1 = getRandom();
                int u2 = getRandom();
                Log.d("VALUE 1",""+u1);
                Log.d("VALUE 2",""+u2);
                computerResult = c1+c2;
                userResult = u1+u2;
                fd.setImageDrawable(getDrawable(getResource(u1-1)));
                sd.setImageDrawable(getDrawable(getResource(u2-1)));

                cs.setText("Computer Score: "+computerResult);
                us.setText("User Score: "+userResult);

                res.setText(getResult(computerResult, userResult));




            }
        });


    }

    String getResult(int cs, int us)
    {
        if(cs==us)
        {
            return "It's a Tie";
        }
        else if(cs>us)
        {
            return "Computer Wins!";
        }
        else if(us>cs)
        {
            return "User Wins!";
        }
        return  "";
    }

    int getRandom()
    {
        return new Random().nextInt(6)+1;
    }
}