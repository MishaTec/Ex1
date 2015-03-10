package com.example.natip2.ex1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class TipCalculatorActivity extends ActionBarActivity {

    private View.OnClickListener calcListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText input = (EditText) findViewById(R.id.edtBillAmount);
            double result = Double.parseDouble(input.getText().toString()) * 0.12;
            boolean isRound = ((CheckBox) findViewById(R.id.chkRound)).isChecked();
            if (isRound) {
                result = Math.round(result);
            }
            TextView tipResultText = (TextView) findViewById(R.id.txtTipResult);
            tipResultText.setText("Tip: $" + String.format("%." + (isRound ? 0 : 2) + "f", result));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        Button calc = (Button) findViewById(R.id.btnCalculate);
        calc.setOnClickListener(calcListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
