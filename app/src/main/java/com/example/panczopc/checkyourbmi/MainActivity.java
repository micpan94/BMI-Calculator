package com.example.panczopc.checkyourbmi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;
    private TextView result;
    private Button btn,infobtn,webbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editHeight);
        et2 = (EditText) findViewById(R.id.editWeight);
        btn = (Button) findViewById(R.id.button);
        infobtn = (Button) findViewById(R.id.infobtn);
        webbtn = (Button) findViewById(R.id.webbtn);
        result = (TextView) findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });

        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,InfoActivity.class);
                startActivity(intent);
            }

        });

        webbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://wp.pl"));
                startActivity(intent);
            }
        });

    }

    protected void calculate()
    {

        double a,b,c;

        a = Double.parseDouble(et1.getText().toString())/100;
        b = Double.parseDouble(et2.getText().toString());

      if(a == 0 | b == 0)
      {
          Toast.makeText(getApplicationContext(),"Podaj poprawną wartość",Toast.LENGTH_SHORT).show();
      }
      else{

        c = b / (a * a);

        c = c * 10;
        c = Math.round(c);
        c = c / 10;

        result.setText( "Twoje bmi wynosi : " + c);

        if((c > 0) && (c <16))
        {
            Toast.makeText(getApplicationContext(),"Wygłodzenie",Toast.LENGTH_SHORT).show();
        }
        else if ((c >= 16) && (c <18.5))
        {
            Toast.makeText(getApplicationContext(),"Niedowaga",Toast.LENGTH_SHORT).show();
        }
        else if ((c >= 18.5) && (c <= 25 ))
        {
            Toast.makeText(getApplicationContext(),"Waga prawidłowa",Toast.LENGTH_SHORT).show();
        }
        else if ((c > 25 ) && (c <= 30))
        {
            Toast.makeText(getApplicationContext(),"Nadwaga",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Ciężka nadwaga",Toast.LENGTH_SHORT).show();
        }


    }}
}
