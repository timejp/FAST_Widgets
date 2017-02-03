package com.timejh.widgets;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ConstraintActivity extends AppCompatActivity {

    private ToggleButton toggleButton;

    private CheckBox checkApple;
    private CheckBox checkBanana;
    private CheckBox checkCherry;

    private RadioGroup radioGroup;
    private Spinner spinner;
    private SeekBar seekBar;

    private TextView tv_seek;

    String[] MONTHS = {"JAN", "FEB", "MAR"};
    private List<Integer> adapterlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton6);
        checkApple = (CheckBox) findViewById(R.id.ch_apple);
        checkBanana = (CheckBox) findViewById(R.id.ch_banana);
        checkCherry = (CheckBox) findViewById(R.id.ch_charry);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup1);
        spinner = (Spinner) findViewById(R.id.spinner);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        tv_seek = (TextView) findViewById(R.id.tv_seek);

        toggleButton.setOnCheckedChangeListener(compoundButton_OnClickListener);

        checkApple.setOnCheckedChangeListener(compoundButton_OnClickListener);
        checkBanana.setOnCheckedChangeListener(compoundButton_OnClickListener);
        checkCherry.setOnCheckedChangeListener(compoundButton_OnClickListener);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String text = "";
                switch (i) {
                    case R.id.radiobt_anaconda:
                        text = "Anaconda";
                        break;
                    case R.id.radiobt_bear:
                        text = "Bear";
                        break;
                    case R.id.radiobt_cat:
                        text = "Cat";
                        break;
                }
                Toast.makeText(ConstraintActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });

        //스피너에 들어가는 데이터를 동적으로 입력
        //올해~100년전
        adapterlist = new ArrayList<>();
        for(int i=0; i<100; i++) {
            adapterlist.add(Calendar.getInstance().get(Calendar.YEAR) - i);
        }


        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, adapterlist);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ConstraintActivity.this, adapterlist.get(i) + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Seek가 움직일때 마다 불러오는 함수
                tv_seek.setText(i + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //터치 시작
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //터치 때는 순간
            }
        });
    }


    CompoundButton.OnCheckedChangeListener compoundButton_OnClickListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            Toast.makeText(ConstraintActivity.this, compoundButton.getText().toString() + " " + b, Toast.LENGTH_SHORT).show();
        }
    };
}
