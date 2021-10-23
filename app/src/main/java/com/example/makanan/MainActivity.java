package com.example.makanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recMenu;
    private ArrayList<Menu> listMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recMenu = findViewById(R.id.rec_menu);
        initData();

        recMenu.setAdapter(new adapter_menu(listMenu));
        recMenu.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        this.listMenu = new ArrayList<>();
        listMenu.add(new Menu("Bakso",
                "20.000",
                "Bakso daging sapi yang menggunakan kuah kaldu asli.",
                R.drawable.bakso));

        listMenu.add(new Menu("Mie Ayam",
                "15.000",
                "Mie ayam yang menggunakan ayam pilihan.",
                R.drawable.mie));

        listMenu.add(new Menu("Geprek keju",
                "23.000",
                "ayam geprek yang diberi keju.",
                R.drawable.geprek));

        listMenu.add(new Menu("Nasi goreng",
                "13.000",
                "Nasi goreng dengan tambahan daging ayam",
                R.drawable.nasi));
    }
}