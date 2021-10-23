package com.example.makanan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class adapter_menu extends RecyclerView.Adapter<adapter_menu.ViewHolder> {

    private ViewHolder holder;

    public adapter_menu(ArrayList<Menu> listMenu) {
        this.listMenu = listMenu;
    }
    private ArrayList<Menu> listMenu;
    private Context context;

    @NonNull
    @Override
    public adapter_menu.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.menu_makanan, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        Menu menu = listMenu.get(position);
        holder.txtNama.setText(menu.getNama());
        holder.txtHarga.setText(menu.getHarga());
        holder.imgFoto.setImageResource(menu.getId_gambar());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), menu.getDeskripsi(), Toast.LENGTH_LONG).show();
            }
        });

}

    @Override
    public int getItemCount() {
        return listMenu.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtNama, txtHarga;
        public ImageView imgFoto;
        public ConstraintLayout itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtHarga = (TextView) itemView.findViewById(R.id.txtHarga);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            this.itemView = (ConstraintLayout) itemView.findViewById(R.id.mainLayout);
        }
    }
}
