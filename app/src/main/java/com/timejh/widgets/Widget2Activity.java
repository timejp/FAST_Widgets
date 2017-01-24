package com.timejh.widgets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Widget2Activity extends AppCompatActivity {

    private String formula = "0";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget2);
        textView = (TextView) findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    public void onClickBtns(View v) {
        switch (v.getId()) {
            case R.id.bt_plus:
                if (formula.charAt(formula.length() - 1) != '+' && formula.charAt(formula.length() - 1) != '-' && formula.charAt(formula.length() - 1) != '*' && formula.charAt(formula.length() - 1) != '/') {
                    formula += "+";
                } else {
                    formula = formula.substring(0, formula.length() - 1) + "+";
                }
                break;
            case R.id.bt_min:
                if (formula != "" && formula.charAt(formula.length() - 1) != '+' && formula.charAt(formula.length() - 1) != '-' && formula.charAt(formula.length() - 1) != '*' && formula.charAt(formula.length() - 1) != '/') {
                    formula += "-";
                } else {
                    formula = formula.substring(0, formula.length() - 1) + "-";
                }
                break;
            case R.id.bt_dvide:
                if (formula != "" && formula.charAt(formula.length() - 1) != '+' && formula.charAt(formula.length() - 1) != '-' && formula.charAt(formula.length() - 1) != '*' && formula.charAt(formula.length() - 1) != '/') {
                    formula += "/";
                } else {
                    formula = formula.substring(0, formula.length() - 1) + "/";
                }
                break;
            case R.id.bt_mul:
                if (formula != "" && formula.charAt(formula.length() - 1) != '+' && formula.charAt(formula.length() - 1) != '-' && formula.charAt(formula.length() - 1) != '*' && formula.charAt(formula.length() - 1) != '/') {
                    formula += "*";
                } else {
                    formula = formula.substring(0, formula.length() - 1) + "*";
                }
                break;
            case R.id.bt_run:
                calcurate();
                break;
            case R.id.bt_back:
                if (formula.length() > 0) {
                    formula = formula.substring(0, formula.length() - 1);
                    if (formula.length() == 0)
                        formula = "0";
                } else formula = "0";
                break;
            case R.id.bt_cancel:
                formula = "0";
                break;
            case R.id.bt_dot:
                if (formula.charAt(formula.length() - 1) == '+' || formula.charAt(formula.length() - 1) == '-' || formula.charAt(formula.length() - 1) == '*' || formula.charAt(formula.length() - 1) == '/' || formula.charAt(formula.length() - 1) == '.') {
                    break;
                }
                formula += ".";
                break;
            default:
                if (formula.length() <= 0)
                    break;
                String num = ((TextView) v).getText().toString();
                if (formula.charAt(formula.length() - 1) == '0') {
                    if (formula.length() > 1) {
                        if (formula.charAt(formula.length() - 2) == '+' || formula.charAt(formula.length() - 2) == '-' || formula.charAt(formula.length() - 2) == '*' || formula.charAt(formula.length() - 2) == '/') {
                            formula = formula.substring(0, formula.length() - 1);
                        }
                    } else {
                        formula = num;
                        break;
                    }
                }
                formula += num;
        }
        setText(formula);
    }

    private void calcurate() {
        try {
            calcurate('*');
            calcurate('/');
            calcurate('+');
            calcurate('-');
        } catch (Exception e) {
            Toast.makeText(this, "식이 불완전 합니다. 확인해 주세요.", Toast.LENGTH_SHORT).show();
        }
    }

    private void calcurate(char form) {
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == form) {
                int s = 0, e = formula.length();
                String num1 = "";
                for (int j = i - 1; j >= 0; j--) {
                    char buf = formula.charAt(j);
                    if (buf == '+' || buf == '-' || buf == '*' || buf == '/') {
                        s = j + 1;
                        break;
                    }
                    num1 = buf + num1;
                }
                String num2 = "";
                for (int j = i + 1; j < formula.length(); j++) {
                    char buf = formula.charAt(j);
                    if (buf == '+' || buf == '-' || buf == '*' || buf == '/') {
                        e = j;
                        break;
                    }
                    num2 = num2 + buf;
                }
                float fnum1 = Float.parseFloat(num1);
                float fnum2 = Float.parseFloat(num2);
                float fresult = 0;
                switch (form) {
                    case '*':
                        fresult = fnum1 * fnum2;
                        break;
                    case '/':
                        fresult = fnum1 / fnum2;
                        break;
                    case '+':
                        fresult = fnum1 + fnum2;
                        break;
                    case '-':
                        fresult = fnum1 - fnum2;
                        break;
                }
                formula = formula.substring(0, s) + fresult + formula.substring(e, formula.length());
            }
        }
    }

    private void setText(String text) {
        textView.setText(text);
    }
}
