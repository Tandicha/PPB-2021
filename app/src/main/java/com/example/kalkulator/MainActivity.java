package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel
    private EditText mEditTextBilanganPertama;
    private EditText mEditTextBilanganKedua;
    private Spinner mSpinnerOperator;
    private Button mButtonHitung;
    private TextView mTextViewHasil;

    private Double mBilanganPertama;
    private Double mBilanganKedua;
    private String mOperator;
    private Double mHasilPerhitungan = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisialisasi variabel widget
        mEditTextBilanganPertama = findViewById(R.id.angka1);
        mEditTextBilanganKedua = findViewById(R.id.angka2);
        mSpinnerOperator = findViewById(R.id.spinner);
        mButtonHitung = findViewById(R.id.hitung);
        mTextViewHasil = findViewById(R.id.hasil);

        //onclick listener pada widget button
        mButtonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mengambil nilai dari widget EditText dan mengubah menjadi tipe data double
                mBilanganPertama = Double.valueOf(mEditTextBilanganPertama.getText().toString());
                mBilanganKedua = Double.valueOf(mEditTextBilanganKedua.getText().toString());
                //mengambil nilai 'operator' yang dipilih dalam widget spinner
                mOperator = mSpinnerOperator.getSelectedItem().toString();

                //menggunakan switch case untuk mengecek setiap case berdasarkan operator(mOperator) yang dipilih
                switch (mOperator) {
                    case "Penjumlahan":
                        mHasilPerhitungan = mBilanganPertama + mBilanganKedua;
                        break;
                    case "Pengurangan":
                        mHasilPerhitungan = mBilanganPertama - mBilanganKedua;
                        break;
                    case "Perkalian":
                        mHasilPerhitungan = mBilanganPertama * mBilanganKedua;
                        break;
                    case "Pembagian":
                        mHasilPerhitungan = mBilanganPertama / mBilanganKedua;
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Belum memilih operator", Toast.LENGTH_SHORT).show();
                        break;
                }

                //Mengubah nilai dari double menjadi string (String.valueOf()) dan menampilkannya ke widget TextView
                mTextViewHasil.setText(String.valueOf(mHasilPerhitungan));
            }
        });
    }
}