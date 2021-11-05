package com.example.clientapilatifahafra.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clientapilatifahafra.R;
import com.example.clientapilatifahafra.model.BarangModel;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangViewHolder> {
    private Context context;
    private List<BarangModel> listBarang;

    public BarangAdapter(Context context, List<BarangModel> listBarang) {
        this.context = context;
        this.listBarang = listBarang;
    }

    @NonNull
    @Override
    public BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutInflater = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_data_barang,parent,false);
        BarangViewHolder BVH = new BarangViewHolder(layoutInflater);
        return BVH;
    }

    @Override
    public void onBindViewHolder(@NonNull BarangViewHolder holder, int position) {
        BarangModel barangModel = listBarang.get(position);
        holder.id.setText(String.valueOf(barangModel.getId()) );
        holder.nama.setText("Nama Barnag : "+barangModel.getNama());
        holder.keterangan.setText("Keterangan : "+barangModel.getKeterangan());
        holder.harga.setText("Harga  : Rp. "+String.valueOf(barangModel.getHarga()));
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    class BarangViewHolder extends RecyclerView.ViewHolder{

        TextView id, nama, harga, keterangan;

        public BarangViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.txtID);
            nama = itemView.findViewById(R.id.txtNama);
            keterangan = itemView.findViewById(R.id.txtKeterangan);
            harga = itemView.findViewById(R.id.txtHarga);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Perhatikan");
                    builder.setMessage("Hati - Hati");
                    builder.show();
                }
            });

        }
    }
}



