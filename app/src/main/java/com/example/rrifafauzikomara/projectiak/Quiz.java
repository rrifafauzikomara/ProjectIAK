package com.example.rrifafauzikomara.projectiak;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Quiz extends AppCompatActivity implements View.OnClickListener {

    // pembuatan suatu variabel dari classnya masing
    ImageView soal_image;
    ImageButton pilih_a, pilih_b, pilih_c, pilih_d;
    TextView soal, salahbenar;
    Button button_jawab;
    EditText text_jawab;

    // pembuatan variabel string menggunakan array untuk menentukan suatu pertanyaan yang
    // ditampilkan pada textview
    String [] soalgambar = {"1. Sistem operasi apakah ini ?"};
    String [] pertanyaan ={"2. Yang manakah sistem operasi pertama android ?",
                           "3. Sistem operasi yang di rilis pada tahun 2012 adalah ?",
                           "4. Handphone pertama yang di ciptakan di dunia adalah ?",
                           "5. Siapakah penemu telephone genggam ?"};
    int[] soalGAMBAR = {R.drawable.jb};

    // pembuatan variabel int menggunakan array untuk pembuatan pilihan ganda menggunakan gambar
    int [] pilihan_a ={R.drawable.cu, R.drawable.jlb, R.drawable.hp1, R.drawable.andro};
    int [] pilihan_b ={R.drawable.fro, R.drawable.alp, R.drawable.hp2, R.drawable.tv};
    int [] pilihan_c ={R.drawable.alp, R.drawable.ma, R.drawable.hp3, R.drawable.google};
    int [] pilihan_d ={R.drawable.ma,  R.drawable.cu, R.drawable.hp4, R.drawable.hp};

    // pembuatan variabel string menggunakan array untuk menentukan jawaban dari setiap pertanyaan
    String [] jawaban = {"C","A","A","D"};
    String[] jawabgambar = {"Jelly Bean"};

    // pembuatan variabel int untuk menentukan nilai awal dan akan di jumlahkan pada akhir kuis
    int salah = 0, benar = 0 , index = 0, point = 0, indeks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // pendeklarasian suatu variabel yang telah dibuat
        soal=(TextView)findViewById(R.id.soal);
        soal.setText(pertanyaan[0]);
        soal_image = (ImageView) findViewById(R.id.soalGambar);
        soal_image.setImageResource(soalGAMBAR[0]);
        text_jawab = (EditText) findViewById(R.id.txtjawab);
        text_jawab.setText(soalgambar[0]);
        button_jawab = (Button) findViewById(R.id.btnJawab);
        button_jawab.setOnClickListener(this);
        salahbenar=(TextView)findViewById(R.id.hasil);
        pilih_a=(ImageButton)findViewById(R.id.img1);
        pilih_a.setImageResource(pilihan_a[0]);
        pilih_a.setOnClickListener(this);
        pilih_b=(ImageButton)findViewById(R.id.img2);
        pilih_b.setImageResource(pilihan_b[0]);
        pilih_b.setOnClickListener(this);
        pilih_c=(ImageButton)findViewById(R.id.img3);
        pilih_c.setImageResource(pilihan_c[0]);
        pilih_c.setOnClickListener(this);
        pilih_d=(ImageButton)findViewById(R.id.img4);
        pilih_d.setImageResource(pilihan_d[0]);
        pilih_d.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        // untuk menjawab soal gambar dengan jawaban inputan EditText
        if (v == button_jawab) {
            String jawab_user = text_jawab.getText().toString();

            if (jawab_user.equalsIgnoreCase(jawabgambar[index])) {
                salahbenar.setText("BENAR");
                benar++;
                point = point +20;
                text_jawab.setText("");
                salahbenar.setText("");

                button_jawab.setEnabled(true);
                button_jawab.setTextColor(Color.RED);

                if (index < jawabgambar.length - 1) {

                    index++;
                    soal_image.setImageResource(soalGAMBAR[index]);
                    text_jawab.setHint(soalgambar[index]);

                } else {

                    soal_image.setVisibility(View.INVISIBLE);
                    text_jawab.setVisibility(View.INVISIBLE);
                    button_jawab.setVisibility(View.INVISIBLE);

                    soal.setVisibility(View.VISIBLE);
                    pilih_a.setVisibility(View.VISIBLE);
                    pilih_b.setVisibility(View.VISIBLE);
                    pilih_c.setVisibility(View.VISIBLE);
                    pilih_d.setVisibility(View.VISIBLE);

                }
            } else {
                salahbenar.setText("SALAH");
                salah++;
                text_jawab.setText("");
                salahbenar.setText("");

                button_jawab.setEnabled(true);
                button_jawab.setTextColor(Color.RED);

                if (index < jawabgambar.length - 1) {

                    index++;
                    soal_image.setImageResource(soalGAMBAR[index]);
                    text_jawab.setHint(soalgambar[index]);

                } else {

                    soal_image.setVisibility(View.INVISIBLE);
                    text_jawab.setVisibility(View.INVISIBLE);
                    button_jawab.setVisibility(View.INVISIBLE);

                    soal.setVisibility(View.VISIBLE);
                    pilih_a.setVisibility(View.VISIBLE);
                    pilih_b.setVisibility(View.VISIBLE);
                    pilih_c.setVisibility(View.VISIBLE);
                    pilih_d.setVisibility(View.VISIBLE);

                }
            }

            salahbenar.setVisibility(View.VISIBLE);
            button_jawab.setEnabled(false);
            button_jawab.setTextColor(Color.WHITE);

        }

        // untuk menjawab soal text dengan jawaban menentukan gambar yang tepat
        if (v == pilih_a)
        {
            if (jawaban[indeks].equals("A"))
            {
                salahbenar.setText("Anda Memilih Jawaban A");benar++;
                point = point + 20;
                if (indeks<jawaban.length-1)
                {
                    indeks++;
                    soal.setText(pertanyaan[indeks]);
                    pilih_a.setImageResource(pilihan_a[indeks]);
                    pilih_b.setImageResource(pilihan_b[indeks]);
                    pilih_c.setImageResource(pilihan_c[indeks]);
                    pilih_d.setImageResource(pilihan_d[indeks]);
                    salahbenar.setText("");
                }
                else
                {
                    Intent i = new Intent (Quiz.this, Hasil.class);
                    i.putExtra("Benar", benar);
                    i.putExtra("Salah", salah);
                    i.putExtra("Point", point);
                    startActivity(i);
                }
            }
            else
            {
                salahbenar.setText("Anda Memilih Jawaban A");salah++;
                if (indeks<jawaban.length-1)
                {
                    indeks++;
                    soal.setText(pertanyaan[indeks]);
                    pilih_a.setImageResource(pilihan_a[indeks]);
                    pilih_b.setImageResource(pilihan_b[indeks]);
                    pilih_c.setImageResource(pilihan_c[indeks]);
                    pilih_d.setImageResource(pilihan_d[indeks]);
                    salahbenar.setText("");
                }
                else
                {
                    Intent i = new Intent (Quiz.this, Hasil.class);
                    i.putExtra("Benar", benar);
                    i.putExtra("Salah", salah);
                    i.putExtra("Point", point);
                    startActivity(i);
                }
            }
        }
        else if (v==pilih_b)
        {
            if (jawaban[indeks].equals("B"))
            {
                salahbenar.setText("Anda Memilih Jawaban B");benar++;
                point = point + 20;
                if (indeks<jawaban.length-1)
                {
                    indeks++;
                    soal.setText(pertanyaan[indeks]);
                    pilih_a.setImageResource(pilihan_a[indeks]);
                    pilih_b.setImageResource(pilihan_b[indeks]);
                    pilih_c.setImageResource(pilihan_c[indeks]);
                    pilih_d.setImageResource(pilihan_d[indeks]);
                    salahbenar.setText("");
                }
                else
                {
                    Intent i = new Intent (Quiz.this, Hasil.class);
                    i.putExtra("Benar", benar);
                    i.putExtra("Salah", salah);
                    i.putExtra("Point", point);
                    startActivity(i);
                }
            }
            else
            {
                salahbenar.setText("Anda Memilih Jawaban B");salah++;
                if (indeks<jawaban.length-1)
                {
                    indeks++;
                    soal.setText(pertanyaan[indeks]);
                    pilih_a.setImageResource(pilihan_a[indeks]);
                    pilih_b.setImageResource(pilihan_b[indeks]);
                    pilih_c.setImageResource(pilihan_c[indeks]);
                    pilih_d.setImageResource(pilihan_d[indeks]);
                    salahbenar.setText("");
                }
                else
                {
                    Intent i = new Intent (Quiz.this, Hasil.class);
                    i.putExtra("Benar", benar);
                    i.putExtra("Salah", salah);
                    i.putExtra("Point", point);
                    startActivity(i);
                }
            }
        }
        else if (v==pilih_c)
        {
            if (jawaban[indeks].equals("C"))
            {
                salahbenar.setText("Anda Memilih Jawaban C");benar++;
                point = point + 20;
                if (indeks<jawaban.length-1)
                {
                    indeks++;
                    soal.setText(pertanyaan[indeks]);
                    pilih_a.setImageResource(pilihan_a[indeks]);
                    pilih_b.setImageResource(pilihan_b[indeks]);
                    pilih_c.setImageResource(pilihan_c[indeks]);
                    pilih_d.setImageResource(pilihan_d[indeks]);
                    salahbenar.setText("");
                }
                else
                {
                    Intent i = new Intent (Quiz.this, Hasil.class);
                    i.putExtra("Benar", benar);
                    i.putExtra("Salah", salah);
                    i.putExtra("Point", point);
                    startActivity(i);
                }
            }
            else
            {
                salahbenar.setText("Anda Memilih Jawaban C");salah++;
                if (indeks<jawaban.length-1)
                {
                    indeks++;
                    soal.setText(pertanyaan[indeks]);
                    pilih_a.setImageResource(pilihan_a[indeks]);
                    pilih_b.setImageResource(pilihan_b[indeks]);
                    pilih_c.setImageResource(pilihan_c[indeks]);
                    pilih_d.setImageResource(pilihan_d[indeks]);
                    salahbenar.setText("");
                }
                else
                {
                    Intent i = new Intent (Quiz.this, Hasil.class);
                    i.putExtra("Benar", benar);
                    i.putExtra("Salah", salah);
                    i.putExtra("Point", point);
                    startActivity(i);
                }
            }
        }
        else if (v==pilih_d)
        {
            if (jawaban[indeks].equals("D"))
            {
                salahbenar.setText("Anda Memilih Jawaban D");benar++;
                point = point + 20;
                if (indeks<jawaban.length-1)
                {
                    indeks++;
                    soal.setText(pertanyaan[indeks]);
                    pilih_a.setImageResource(pilihan_a[indeks]);
                    pilih_b.setImageResource(pilihan_b[indeks]);
                    pilih_c.setImageResource(pilihan_c[indeks]);
                    pilih_d.setImageResource(pilihan_d[indeks]);
                    salahbenar.setText("");
                }
                else
                {
                    Intent i = new Intent (Quiz.this, Hasil.class);
                    i.putExtra("Benar", benar);
                    i.putExtra("Salah", salah);
                    i.putExtra("Point", point);
                    startActivity(i);
                }
            }
            else
            {
                salahbenar.setText("Anda Memilih Jawaban D");salah++;
                if (indeks<jawaban.length-1)
                {
                    indeks++;
                    soal.setText(pertanyaan[indeks]);
                    pilih_a.setImageResource(pilihan_a[indeks]);
                    pilih_b.setImageResource(pilihan_b[indeks]);
                    pilih_c.setImageResource(pilihan_c[indeks]);
                    pilih_d.setImageResource(pilihan_d[indeks]);
                    salahbenar.setText("");
                }
                else
                {
                    Intent i = new Intent (Quiz.this, Hasil.class);
                    i.putExtra("Benar", benar);
                    i.putExtra("Salah", salah);
                    i.putExtra("Point", point);
                    startActivity(i);
                }
            }
        }
    }
}