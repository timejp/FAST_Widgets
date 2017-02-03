package com.timejh.widgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_grid;
    private Button bt_calculator;
    private Button bt_calculator2;
    private Button bt_constraint;
    private Button bt_unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_grid = (Button) findViewById(R.id.bt_grid);
        bt_grid.setOnClickListener(this);

        bt_calculator = (Button) findViewById(R.id.bt_calculator);
        bt_calculator.setOnClickListener(this);

        bt_calculator2 = (Button) findViewById(R.id.bt_calculator2);
        bt_calculator2.setOnClickListener(this);

        bt_constraint = (Button) findViewById(R.id.bt_constraint);
        bt_constraint.setOnClickListener(this);

        bt_unit = (Button) findViewById(R.id.bt_unit);
        bt_unit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_grid:
                //안드로이드 메이저 컴포넌트를 로드하기 위해서는 Intent 를 통해서 로드할 컴포넌트를 지정해야 한다.
                Intent intent = new Intent(MainActivity.this, GridActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_calculator:
                startActivity(new Intent(MainActivity.this, WidgetActivity.class));
                break;
            case R.id.bt_calculator2:
                startActivity(new Intent(MainActivity.this, Widget2Activity.class));
                break;
            case R.id.bt_constraint:
                startActivity(new Intent(MainActivity.this, ConstraintActivity.class));
                break;
            case R.id.bt_unit:
                startActivity(new Intent(MainActivity.this, UnitActivity.class));
                break;
        }
    }
}
