package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends Activity implements OnClickListener {
    int life = 5;
    int Rand;
    int C1 = 1, C2 = 3, C3 = 5;
    int Strike = 0, Ball = 0, Out = 0, OutCnt = 0;
    TextView TxLife, TxV1, TxV2, TxV3, TxV4, TxV5;
    Button Choose;
    Button Exit, Restart;
    EditText PS1, PS2, PS3;
    int PC1, PC2, PC3;
    LinearLayout LoseView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoseView = (LinearLayout)findViewById(R.id.View_Lose);
        TxLife = (TextView)findViewById(R.id.TxLife);
        Choose = (Button)findViewById(R.id.Btn_Choose);
        Exit = (Button)findViewById(R.id.Btn_Finish);
        Restart = (Button)findViewById(R.id.Btn_Restart);
        PS1 = (EditText)findViewById(R.id.PS1);
        PS2 = (EditText)findViewById(R.id.PS2);
        PS3 = (EditText)findViewById(R.id.PS3);
        TxV1 = (TextView)findViewById(R.id.TxV1);
        TxV2 = (TextView)findViewById(R.id.TxV2);
        TxV3 = (TextView)findViewById(R.id.TxV3);
        TxV4 = (TextView)findViewById(R.id.TxV4);
        TxV5 = (TextView)findViewById(R.id.TxV5);

        Restart.setOnClickListener(this);
        Exit.setOnClickListener(this);
        Choose.setOnClickListener(this);

        for (int i = 0 ; i < 3; i++) {
            Rand = (int) (Math.random() * 10);
            switch (i) {
                case 0:
                    C1 = Rand;
                    break;
                case 1:
                    C2 = Rand;
                    break;
                case 2:
                    C3 = Rand;
                    break;
            }
        }
            }

    @Override
    public void onClick(View v) {

        PC1 = Integer.parseInt(PS1.getText().toString().trim());
        PC2 = Integer.parseInt(PS2.getText().toString().trim());
        PC3 = Integer.parseInt(PS3.getText().toString().trim());

        if (v == Exit) {
            LoseView.setVisibility(View.GONE);
            finish();
        }
        if (v == Restart) {
            LoseView.setVisibility(View.GONE);

            life = 5;
            TxLife.setText("5");

            TxV1.setText("");
            TxV2.setText("");
            TxV3.setText("");
            TxV4.setText("");
            TxV5.setText("");

            for (int i = 0 ; i < 3; i++) {

                Rand = (int) (Math.random() * 10);

                switch (i) {
                    case 0:
                        C1 = Rand;
                        break;
                    case 1:
                        C2 = Rand;
                        break;
                    case 2:
                        C3 = Rand;
                        break;
                }
            }

            Strike = 0;
            Ball = 0;
            Out = 0;
        }

        if (v == Choose) {
            if (PC1 == PC2 || PC2 == PC3 || PC3 == PC1) {
                Toast.makeText(MainActivity.this, "같은숫자가 있습니다.", Toast.LENGTH_SHORT).show();
            }else {
                        if (PC1 == C1)
                        {
                            Strike++;
                        }

                        if (PC2 == C2)
                        {
                            Strike++;
                        }

                        if (PC3 == C3)
                        {
                            Strike++;
                        }

                        if (PC1 == C2 || PC1 == C3)
                        {
                            Ball++;
                        }

                        if (PC2 == C1 || PC2 == C3)
                        {
                            Ball++;
                        }

                        if (PC3 == C2 || PC3 == C1)
                        {
                            Ball++;
                        }

                Strike = 0;
                Ball = 0;
                Out = 0;

                if (PC1 != C1 && PC1 != C2 && PC1 != C3){
                    OutCnt++;
                }
                if (PC2 != C1 && PC2 != C2 && PC2 != C3){
                    OutCnt++;
                }
                if (PC3 != C1 && PC3 != C2 && PC3 != C3){
                    OutCnt++;
                    }
                if (OutCnt == 3){
                    Out++;
                    OutCnt = 0;
                }

            switch (life){
                case 5 :
                    TxV1.setText(Strike+"스트라이크, "+Ball+"볼, "+Out+"아웃."+C1+C2+C3);
                    life--;
                    TxLife.setText("4");
                    Strike = 0;
                    Ball = 0;
                    Out = 0;
                    break;
                case 4 :
                    TxV2.setText(Strike+"스트라이크, "+Ball+"볼, "+Out+"아웃.");
                    life--;
                    TxLife.setText("3");
                    Strike = 0;
                    Ball = 0;
                    Out = 0;
                    break;
                case 3 :
                    TxV3.setText(Strike+"스트라이크, "+Ball+"볼, "+Out+"아웃.");
                    life--;
                    TxLife.setText("2");
                    Strike = 0;
                    Ball = 0;
                    Out = 0;
                    break;
                case 2 :
                    TxV4.setText(Strike+"스트라이크, "+Ball+"볼, "+Out+"아웃.");
                    life--;
                    TxLife.setText("1");
                    Strike = 0;
                    Ball = 0;
                    Out = 0;
                    break;
                case 1 :
                    TxV5.setText(Strike+"스트라이크, "+Ball+"볼, "+Out+"아웃.");
                    life--;
                    TxLife.setText("0");
                    Strike = 0;
                    Ball = 0;
                    Out = 0;
                    break;
            }
                if (life == 0){
                LoseView.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
