package com.timejh.widgets;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class UnitActivity extends AppCompatActivity {

    private final int LENGTH = 1;
    private final int AREA = 2;
    private final int WEIGHT = 3;

    private int MODE = LENGTH;

    private int BEFOREINT = 0;
    private int AFTERINT = 0;

//    private final String[] LENGTH_LIST = {"밀리미터 (mm)", "센티미터(cm)", "미터(m)", "킬로미터(km)", "인치(in)", "피트(ft)", "야드(yd)", "마일(mile)", "자(尺)", "간(間)", "정(町)", "리(里)", "해리(海里)"};
//    private final String[] LENGTH_UNITLIST = {"mm", "cm", "m", "km", "in", "ft", "yd", "mile", "尺", "間", "町", "里", "海里"};
//    private final double[] LENGTH_RAITO = {1, 0.1, 0.001, 1e-6, 0.03937, 0.003281, 0.001094, 6.2137e-7, 0.0033, 0.00055, 9.1667e-6, 2.5463e-6, 5.3996e-7};
//
//    private final String[] AREA_LIST = {"제곱미터(m2)", "아르(a)", "헥타르(ha)", "제곱킬로미터(km2)", "제곱피트(ft2)", "제곱야드(yd2)", "에이커(ac)", "평방자", "평", "단보", "정보"};
//    private final String[] AREA_UNITLIST = {"m2", "a", "ha", "km2", "ft2", "yd2", "ac", "평방자", "평", "단보", "정보"};
//    private final double[] AREA_RAITO = {1, 0.001, 0.0001, 1e-6, 10.76391, 1.19599, 0.000247, 10.89, 0.3025, 0.001008, 0.000101};
//
//    private final String[] WEIGHT_LIST = {"밀리그램(mg)", "그램(g)", "킬로그램(kg)", "톤(t)", "킬로톤(kt)", "그레인(gr)", "온스(oz)", "파운드(lb)", "돈", "냥", "근", "관"};
//    private final String[] WEIGHT_UNITLIST = {"mg", "g", "kg", "t", "kt", "gr", "oz", "lb", "돈", "냥", "근", "관"};
//    private final double[] WEIGHT_RAITO = {1, 0.001, 1e-6, 10e-10, 1e-12, 0.015432, 0.000035, 2.2046e-6, 0.000267, 0.000027, 1.6667e-6, 2.6667e-7};


    private final String[] LENGTH_LIST = {"밀리미터 (mm)", "센티미터(cm)", "미터(m)", "킬로미터(km)", "인치(in)", "피트(ft)", "야드(yd)", "마일(mile)", "자(尺)", "간(間)", "정(町)", "리(里)", "해리(海里)"};
    private final String[] LENGTH_UNITLIST = {"mm", "cm", "m", "km", "in", "ft", "yd", "mile", "尺", "間", "町", "里", "海里"};
    private final double[] LENGTH_RAITO = {1, 0.1, 0.001, 0.000001, 0.03937, 0.003281, 0.001094, 0.00000062137, 0.0033, 0.00055, 0.0000091667, 0.0000025463, 0.00000053996};

    private final String[] AREA_LIST = {"제곱미터(m2)", "아르(a)", "헥타르(ha)", "제곱킬로미터(km2)", "제곱피트(ft2)", "제곱야드(yd2)", "에이커(ac)", "평방자", "평", "단보", "정보"};
    private final String[] AREA_UNITLIST = {"m2", "a", "ha", "km2", "ft2", "yd2", "ac", "평방자", "평", "단보", "정보"};
    private final double[] AREA_RAITO = {1, 0.001, 0.0001, 0.000001, 10.76391, 1.19599, 0.000247, 10.89, 0.3025, 0.001008, 0.000101};

    private final String[] WEIGHT_LIST = {"밀리그램(mg)", "그램(g)", "킬로그램(kg)", "톤(t)", "킬로톤(kt)", "그레인(gr)", "온스(oz)", "파운드(lb)", "돈", "냥", "근", "관"};
    private final String[] WEIGHT_UNITLIST = {"mg", "g", "kg", "t", "kt", "gr", "oz", "lb", "돈", "냥", "근", "관"};
    private final double[] WEIGHT_RAITO = {1, 0.001, 0.000001, 0.000000001, 0.000000000001, 0.015432, 0.000035, 0.0000022046, 0.000267, 0.000027, 0.0000016667, 0.00000026667};


    private Button bt_Length;
    private Button bt_Area;
    private Button bt_Weight;

    private TextView tv_title;

    private Spinner spinner_before;
    private Spinner spinner_after;
    private Button bt_swipe;

    private EditText ed_input;
    private TextView tv_before_unit;

    private TextView tv_result;
    private TextView tv_after_unit;

    private GridLayout gridlayout;

    private ArrayAdapter<String> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        init();
        modeChanged();
    }

    AdapterView.OnItemSelectedListener adapterItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            selectedSpinnerItem(adapterView, i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private void init() {
        bt_Length = (Button) findViewById(R.id.bt_Length);
        bt_Area = (Button) findViewById(R.id.bt_Area);
        bt_Weight = (Button) findViewById(R.id.bt_Weight);

        tv_title = (TextView) findViewById(R.id.tv_title);
        spinner_before = (Spinner) findViewById(R.id.spinner_before);
        spinner_after = (Spinner) findViewById(R.id.spinner_after);
        bt_swipe = (Button) findViewById(R.id.bt_swipe);
        ed_input = (EditText) findViewById(R.id.ed_input);
        tv_before_unit = (TextView) findViewById(R.id.tv_before_unit);
        tv_result = (TextView) findViewById(R.id.tv_result);
        tv_after_unit = (TextView) findViewById(R.id.tv_after_unit);
        gridlayout = (GridLayout) findViewById(R.id.gridlayout);

        bt_Length.setOnClickListener(settingBtns_OnClick);
        bt_Area.setOnClickListener(settingBtns_OnClick);
        bt_Weight.setOnClickListener(settingBtns_OnClick);
        bt_swipe.setOnClickListener(swipeButton_OnCLick);

        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);

        spinner_before.setAdapter(spinnerAdapter);
        spinner_after.setAdapter(spinnerAdapter);

        spinner_after.setOnItemSelectedListener(adapterItemSelected);
        spinner_before.setOnItemSelectedListener(adapterItemSelected);

        ed_input.addTextChangedListener(input_OnChange);
    }

    private View.OnClickListener swipeButton_OnCLick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int temp = AFTERINT;
            AFTERINT = BEFOREINT;
            BEFOREINT = temp;

            spinner_after.setSelection(AFTERINT);
            spinner_before.setSelection(BEFOREINT);

            selectedSpinnerItem(spinner_before, BEFOREINT);
            selectedSpinnerItem(spinner_after, AFTERINT);
        }
    };

    private TextWatcher input_OnChange = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(ed_input.getText().toString().length() == 0) {
                ed_input.setText("0");
            }
            String[] unit = null;
            String[] list = null;
            double[] raito = null;
            switch (MODE) {
                case LENGTH :
                    unit = LENGTH_UNITLIST;
                    list = LENGTH_LIST;
                    raito = LENGTH_RAITO;
                    break;
                case AREA :
                    unit = AREA_UNITLIST;
                    list = AREA_LIST;
                    raito = AREA_RAITO;
                    break;
                case WEIGHT :
                    unit = WEIGHT_UNITLIST;
                    list = WEIGHT_LIST;
                    raito = WEIGHT_RAITO;
                    break;
            }
            calculate(list, unit, raito);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private View.OnClickListener settingBtns_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt_Length:
                    MODE = LENGTH;
                    break;
                case R.id.bt_Area:
                    MODE = AREA;
                    break;
                case R.id.bt_Weight:
                    MODE = WEIGHT;
                    break;
            }
            modeChanged();
        }
    };

    private void selectedSpinnerItem(AdapterView adapterView, int i) {
        String[] unit = null;
        String[] list = null;
        double[] raito = null;
        switch (MODE) {
            case LENGTH :
                unit = LENGTH_UNITLIST;
                list = LENGTH_LIST;
                raito = LENGTH_RAITO;
                break;
            case AREA :
                unit = AREA_UNITLIST;
                list = AREA_LIST;
                raito = AREA_RAITO;
                break;
            case WEIGHT :
                unit = WEIGHT_UNITLIST;
                list = WEIGHT_LIST;
                raito = WEIGHT_RAITO;
                break;
        }

        switch (adapterView.getId()) {
            case R.id.spinner_before:
                BEFOREINT = i;
                tv_before_unit.setText(unit[i]);
                break;
            case R.id.spinner_after:
                AFTERINT = i;
                tv_after_unit.setText(unit[i]);
                break;
        }
        calculate(list, unit, raito);
    }

    private void calculate(String[] list, String[] unit, double[] raito) {
        double[] result = new double[list.length];

        double input = Double.parseDouble(ed_input.getText().toString());
        double inputmm = input / raito[BEFOREINT];
        for(int i=0;i<list.length;i++) {
            result[i] = (Math.round(inputmm * raito[i] * 100000))/100000.0;
        }
        tv_result.setText(result[AFTERINT] + "");
        setGridLists(result, list);
    }

    private void setGridLists(double[] result, String[] list) {
        gridlayout.removeAllViews();
        for(int i=0;i<list.length;i++) {
            gridlayout.addView(getGridItem(i, result[i] + "", list[i]));
        }
    }

    private void modeChanged() {
        spinnerAdapter.clear();
        BEFOREINT = 0;
        AFTERINT = 0;
        switch (MODE) {
            case LENGTH:
                setModeLENGTH();
                break;
            case AREA:
                setModeAREA();
                break;
            case WEIGHT:
                setModeWeight();
                break;
        }
        spinnerAdapter.notifyDataSetChanged();
        spinner_before.setSelection(BEFOREINT);
        spinner_after.setSelection(AFTERINT);

        selectedSpinnerItem(spinner_before, BEFOREINT);
        selectedSpinnerItem(spinner_after, AFTERINT);
    }

    private void setModeLENGTH() {
        tv_title.setText("Length");
        spinnerAdapter.addAll(LENGTH_LIST);
    }

    private void setModeAREA() {
        tv_title.setText("Area");
        spinnerAdapter.addAll(AREA_LIST);
    }

    private void setModeWeight() {
        tv_title.setText("Weight");
        spinnerAdapter.addAll(WEIGHT_LIST);
    }

    /*
            <LinearLayout
                android:orientation="horizontal"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_rowSpan="1"
                android:layout_columnSpan="1"
                android:layout_columnWeight="0.5"
                android:padding="5dp">

                <TextView
                    android:text="0"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:textColor="#FFFF0000"
                    android:textSize="30dp"
                    android:gravity="right" />

                <TextView
                    android:text="mm"
                    android:layout_marginLeft="5dp"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:textSize="25dp" />

            </LinearLayout>
     */
    private LinearLayout getGridItem(int count, String result, String unit) {
        TextView tv_result = new TextView(this);
        tv_result.setGravity(Gravity.RIGHT);
        tv_result.setTextColor(Color.argb(0xff,0xff,0x00,0x00));
        tv_result.setTextSize(15);
        tv_result.setText(result);

        TextView tv_unit = new TextView(this);
        LinearLayout.LayoutParams unit_params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        unit_params.setMargins(5,0,0,0);
        tv_unit.setLayoutParams(unit_params);
        tv_unit.setTextSize(15);
        tv_unit.setText(unit);

        LinearLayout linearLayout = new LinearLayout(this);

        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        GridLayout.LayoutParams param =new GridLayout.LayoutParams();
        param.height = GridLayout.LayoutParams.WRAP_CONTENT;
        param.width = GridLayout.LayoutParams.WRAP_CONTENT;
        param.columnSpec = GridLayout.spec(count % 2, 1, 0.5f);
        linearLayout.setLayoutParams(param);
        linearLayout.setPadding(5,5,5,5);

        linearLayout.addView(tv_result);
        linearLayout.addView(tv_unit);
        return linearLayout;
    }
}
