package com.example.paster52.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class StandardCalc extends ActionBarActivity {
    private Button zero,one,two,three,four,five,six,seven,eight,nine;
    private Button []numbers;
    private Button plus;
    private TextView screen;
    private int firstNum;
    private String op;
    private Boolean clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_calc);
        clear=true;
        screen = (TextView)findViewById(R.id.textView);
        zero = (Button)findViewById(R.id.button0);
        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                NumberClick(zero,view);
            }
        });
        one = (Button)findViewById(R.id.button1);
        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                NumberClick(one,view);
            }
        });
        two = (Button)findViewById(R.id.button2);
        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                NumberClick(two,view);
            }
        });
        three = (Button)findViewById(R.id.button2);
        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                NumberClick(three,view);
            }
        });
        four = (Button)findViewById(R.id.button2);
        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                NumberClick(four,view);
            }
        });
        five = (Button)findViewById(R.id.button2);
        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                NumberClick(five,view);
            }
        });
        six = (Button)findViewById(R.id.button2);
        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                NumberClick(six,view);
            }
        });
        plus = (Button)findViewById(R.id.buttonPlus);
        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                OperationClick(plus, view);
            }
        });
        numbers = new Button[]{one,two};
    }

    private void OperationClick(Button operation, View view) {
        op = operation.getText().toString();

        if (firstNum != 0) {
            int answer = firstNum + Integer.parseInt(screen.getText().toString());
            screen.setText(Integer.toString(answer));
            firstNum=answer;
            clear = true;
        }
        firstNum = Integer.parseInt(screen.getText().toString());
        clear=true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_standard_calc, menu);
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
    private void NumberClick(Button num,View v)
    {
        //If number is zero need leading decimal or number
        if(num==zero){
            if(screen.getText().length()>1){
                screen.append(num.getText());
            }
            else{screen.setText(num.getText());}
        }
        else {
            if (clear) {
                screen.setText(num.getText());
                clear = false;
            } else {
                screen.append(num.getText());
            }
        }

    }
}
