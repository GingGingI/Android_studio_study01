package com.example.veiwflipper;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnClickListener {

    int A = 1;
    Button left,right;
    ViewFlipper view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left = (Button) findViewById(R.id.Btn1);
        right = (Button) findViewById(R.id.Btn2);
        left.setText("전공동아리");
        right.setText("비전공동아리");
        view = (ViewFlipper)findViewById(R.id.viewFlipper1);

        left.setOnClickListener(this);
        right.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        if (v == right ) {

            view.showNext();
            if (A >= 3) {
                A = 1;
            } else if (A < 3)
            {
                A++;
            }
        }else if (v == left) {
            view.showPrevious();
            if (A <= 1) {
                A = 3;
            } else if (A > 1)
            {
                A--;
            }
        }
        if(A == 1) {
            left.setText("전공동아리");
            right.setText("비전공동아리");
        } else if (A == 2) {
            left.setText("4차산업동아리");
            right.setText("전공동아리");
        } else if (A == 3) {
            left.setText("비전공동아리");
            right.setText("4차산업동아리");
        }
    }
}
