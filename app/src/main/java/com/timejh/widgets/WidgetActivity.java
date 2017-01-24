package com.timejh.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class WidgetActivity extends AppCompatActivity {

    private String formula = "";
    private boolean done = true;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        textView = (TextView)findViewById(R.id.textView);
    }

    public void onClickBtns(View v) {
        switch (v.getId()) {
            case R.id.bt_plus:
                if ((formula.contains("+") || formula.contains("-") || formula.contains("*") || formula.contains("/")) && formula.charAt(formula.length() - 1) != '+' && formula.charAt(formula.length() - 1) != '-' && formula.charAt(formula.length() - 1) != '*' && formula.charAt(formula.length() - 1) != '/') {
                    calcurate();
                }
                if (formula.charAt(formula.length() - 1) != '+' && formula.charAt(formula.length() - 1) != '-' && formula.charAt(formula.length() - 1) != '*' && formula.charAt(formula.length() - 1) != '/') {
                    formula += "+";
                } else {
                    formula = formula.substring(0, formula.length() - 1) + "+";
                }
                done = false;
                break;
            case R.id.bt_min:
                if ((formula.contains("+") || formula.contains("-") || formula.contains("*") || formula.contains("/")) && formula.charAt(formula.length() - 1) != '+' && formula.charAt(formula.length() - 1) != '-' && formula.charAt(formula.length() - 1) != '*' && formula.charAt(formula.length() - 1) != '/') {
                    calcurate();
                }
                if (formula != "" && formula.charAt(formula.length() - 1) != '+' && formula.charAt(formula.length() - 1) != '-' && formula.charAt(formula.length() - 1) != '*' && formula.charAt(formula.length() - 1) != '/') {
                    formula += "-";
                } else {
                    formula = formula.substring(0, formula.length() - 1) + "-";
                }
                done = false;
                break;
            case R.id.bt_dvide:
                if ((formula.contains("+") || formula.contains("-") || formula.contains("*") || formula.contains("/")) && formula.charAt(formula.length() - 1) != '+' && formula.charAt(formula.length() - 1) != '-' && formula.charAt(formula.length() - 1) != '*' && formula.charAt(formula.length() - 1) != '/') {
                    calcurate();
                }
                if (formula != "" && formula.charAt(formula.length() - 1) != '+' && formula.charAt(formula.length() - 1) != '-' && formula.charAt(formula.length() - 1) != '*' && formula.charAt(formula.length() - 1) != '/') {
                    formula += "/";
                } else {
                    formula = formula.substring(0, formula.length() - 1) + "/";
                }
                done = false;
                break;
            case R.id.bt_mul:
                if ((formula.contains("+") || formula.contains("-") || formula.contains("*") || formula.contains("/")) && formula.charAt(formula.length() - 1) != '+' && formula.charAt(formula.length() - 1) != '-' && formula.charAt(formula.length() - 1) != '*' && formula.charAt(formula.length() - 1) != '/') {
                    calcurate();
                }
                if (formula != "" && formula.charAt(formula.length() - 1) != '+' && formula.charAt(formula.length() - 1) != '-' && formula.charAt(formula.length() - 1) != '*' && formula.charAt(formula.length() - 1) != '/') {
                    formula += "*";
                } else {
                    formula = formula.substring(0, formula.length() - 1) + "*";
                }
                done = false;
                break;
            case R.id.bt_run:
                if (formula.equals(""))
                    break;
                if(formula.charAt(formula.length() - 1) == '+' || formula.charAt(formula.length() - 1) == '-' || formula.charAt(formula.length() - 1) == '*' || formula.charAt(formula.length() - 1) == '/') {
                    formula = formula.substring(0, formula.length() - 1);
                }
                if (formula.contains("+") || formula.contains("-") || formula.contains("*") || formula.contains("/"))
                    calcurate();
                done = true;
                break;
            case R.id.bt_cancel:
                formula = "";
                setText("0");
                break;
            default:
                if(done) {
                    formula = "";
                    done = false;
                }
                String num = ((TextView) v).getText().toString();
                if (!num.equals(0)) formula += num;
        }
        setText(formula);
    }

    private void calcurate() {
        String buf1 = "";
        char form = 0;
        String buf2 = "";
        for(int i=0;i<formula.length();i++) {
            if(formula.charAt(i) != '+' && formula.charAt(i) != '-' && formula.charAt(i) != '*' && formula.charAt(i) != '/') {
                if (form == 0) buf1 += formula.charAt(i);
                else buf2 += formula.charAt(i);
            }
            else form = formula.charAt(i);
        }

        int num = 0;
        switch (form) {
            case '+':
                num = Integer.parseInt(buf1) + Integer.parseInt(buf2);
                break;
            case '-':
                num = Integer.parseInt(buf1) - Integer.parseInt(buf2);
                break;
            case '*':
                num = Integer.parseInt(buf1) * Integer.parseInt(buf2);
                break;
            case '/':
                num = Integer.parseInt(buf1) / Integer.parseInt(buf2);
                break;
        }
        setText(num + "");
        formula = num + "";
    }

    private void setText(String text) {
        textView.setText(text);
    }
}
