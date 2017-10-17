package com.example.ubuntu.basketballscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnA1, btnA2, btnA3, btnB1, btnB2, btnB3, btnUndo, btnReset;
    TextView tvScoreA, tvScoreB;
    ArrayList<Integer> arrNilai;
    ArrayList<Character> arrTim;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        arrNilai = new ArrayList<>();
        arrTim = new ArrayList<>();
        index = -1;

        btnA1 = (Button) findViewById(R.id.btnA1);
        btnA2 = (Button) findViewById(R.id.btnA2);
        btnA3 = (Button) findViewById(R.id.btnA3);
        btnB1 = (Button) findViewById(R.id.btnB1);
        btnB2 = (Button) findViewById(R.id.btnB2);
        btnB3 = (Button) findViewById(R.id.btnB3);
        btnUndo = (Button) findViewById(R.id.btnUndo);
        btnReset = (Button) findViewById(R.id.btnReset);
        tvScoreA = (TextView) findViewById(R.id.tvScoreA);
        tvScoreB = (TextView) findViewById(R.id.tvScoreB);

        tvScoreA.setText("0");
        tvScoreB.setText("0");

        btnA1.setOnClickListener(this);
        btnA2.setOnClickListener(this);
        btnA3.setOnClickListener(this);
        btnB1.setOnClickListener(this);
        btnB2.setOnClickListener(this);
        btnB3.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnUndo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int a = Integer.parseInt(tvScoreA.getText().toString());
        int b = Integer.parseInt(tvScoreB.getText().toString());

        if(v.getId()==R.id.btnA1 || v.getId()==R.id.btnA2 || v.getId()==R.id.btnA3){
            if(v.getId()==R.id.btnA1){
                a++;
                arrNilai.add(1);
            }else if(v.getId()==R.id.btnA2){
                a+=2;
                arrNilai.add(2);
            }else{
                a+=3;
                arrNilai.add(3);
            }

            tvScoreA.setText(String.valueOf(a));
            arrTim.add('A');
            index++;
        }else if(v.getId()==R.id.btnB1 || v.getId()==R.id.btnB2 || v.getId()==R.id.btnB3){
            if(v.getId()==R.id.btnB1){
                b++;
                arrNilai.add(1);
            }else if(v.getId()==R.id.btnB2){
                b+=2;
                arrNilai.add(2);
            }else{
                b+=3;
                arrNilai.add(3);
            }

            tvScoreB.setText(String.valueOf(b));
            arrTim.add('B');
            index++;
        }else if(v.getId()==R.id.btnUndo){
            if(index<0){
                Toast.makeText(this, "Sudah habis", Toast.LENGTH_SHORT).show();
            }else{
                if(arrTim.get(index)=='A'){
                    a-=arrNilai.get(index);
                    tvScoreA.setText(String.valueOf(a));
                }else if(arrTim.get(index)=='B'){
                    b-=arrNilai.get(index);
                    tvScoreB.setText(String.valueOf(b));
                }
                arrTim.remove(index);
                arrNilai.remove(index);
                index--;
            }
        }else if(v.getId()==R.id.btnReset){
            tvScoreA.setText("0");
            tvScoreB.setText("0");

            arrNilai.clear();
            arrTim.clear();
            index = -1;
        }
    }
}
