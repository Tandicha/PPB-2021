package com.example.kalkulatorbidangdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText pad, lt;
    TextView luas, keliling;
    Button persegi, segitiga, lingkaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    private void initComponent() {
        pad = findViewById(R.id.pad);
        lt = findViewById(R.id.lt);

        luas = findViewById(R.id.luas);
        keliling = findViewById(R.id.keliling);

        persegi = findViewById(R.id.persegi);
        segitiga = findViewById(R.id.segitiga);
        lingkaran = findViewById(R.id.lingkaran);

        persegi.setOnClickListener(this);
        segitiga.setOnClickListener(this);
        lingkaran.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.persegi:
                luasp();
                kelilingp();
                break;
            case R.id.segitiga:
                luass();
                kelilings();
                break;
            case R.id.lingkaran:
                luasl();
                kelilingl();
                break;
        }
    }
    private void luasp() {
        int Pad=Integer.parseInt(String.valueOf(pad.getText()));

        int hasil=(Pad*2);
        luas.setText(""+hasil);
    }

    private void kelilingp() {
        int Pad=Integer.parseInt(String.valueOf(pad.getText()));

        int hasil=(Pad*4);
        keliling.setText(""+hasil);
    }

    private void luass() {
        int Pad=Integer.parseInt(String.valueOf(pad.getText()));
        int Lt=Integer.parseInt(String.valueOf(lt.getText()));

        float hasil= (float)(0.5*Pad*Lt);
        luas.setText(""+hasil);
    }

    private void kelilings() {
        int Pad=Integer.parseInt(String.valueOf(pad.getText()));
        int Lt=Integer.parseInt(String.valueOf(lt.getText()));
        float akar= (float) Math.sqrt(Math.pow(Pad,2)+Math.pow(Lt,2));

        float hasil=(Pad+Lt+akar);
        keliling.setText(""+hasil);
    }

    private void luasl() {
        int Pad=Integer.parseInt(String.valueOf(pad.getText()));
        float a= (float) Pad/2;
        float b= (float) Math.pow(a,2);
        float hasil= (float)(3.14*b);
        luas.setText(""+hasil);
    }

    private void kelilingl() {
        int Pad=Integer.parseInt(String.valueOf(pad.getText()));

        float hasil= (float)(3.14*Pad);
        keliling.setText(""+hasil);
    }
}