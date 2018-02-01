package com.example.rrifafauzikomara.projectiak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Hasil extends Activity implements View.OnClickListener {

    TextView hasil;
    int benar, salah, point;
    Button exit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        benar = getIntent().getIntExtra("Benar", 0);
        salah = getIntent().getIntExtra("Salah", 0);
        point = getIntent().getIntExtra("Point", 0);

        hasil= (TextView)findViewById(R.id.Hasil1);
        hasil.setText("Jawaban Benar : "+benar+ "\n" +"\nJawaban Salah : "+salah+ "\n" +"\nNilai Kamu : " +point);

        exit = (Button) findViewById(R.id.btnexit);
        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i =new Intent(Hasil.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
    }
}