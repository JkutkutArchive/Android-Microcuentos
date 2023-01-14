package com.jkutkut.android_microcuentos.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jkutkut.android_microcuentos.R;
import com.jkutkut.android_microcuentos.model.Cuento;
import com.jkutkut.android_microcuentos.model.Cuentos;

import java.util.ArrayList;

public class CuentoAdapter extends RecyclerView.Adapter<CuentoAdapter.CuentoVH> {
    private final ArrayList<Cuento> data;
    private final OnCuentoClickListener listener;

    public CuentoAdapter(OnCuentoClickListener listener) {
        this.data = Cuentos.getCuentos();
        this.listener = listener;
    }

    @NonNull
    @Override
    public CuentoAdapter.CuentoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cuento_item, parent, false);
        return new CuentoVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CuentoAdapter.CuentoVH holder, int position) {
        holder.bindData(data.get(position));
        holder.itemView.setOnClickListener(v -> listener.onCuentoClick(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // GETTERS
    public Cuento getCuento(int position) {
        if (position >= 0 && position < data.size())
            return data.get(position);
        return null;
    }

    // Classes and inferfaces

    public static class CuentoVH extends RecyclerView.ViewHolder {
        private final TextView txtvTitulo;
        private final TextView txtvAvance;

        public CuentoVH(@NonNull View itemView) {
            super(itemView);

            txtvTitulo = itemView.findViewById(R.id.txtvTitulo);
            txtvAvance = itemView.findViewById(R.id.txtvAvance);
        }

        public void bindData(Cuento c) {
            txtvTitulo.setText(c.getTitulo());
            txtvAvance.setText(c.getAvance());
        }
    }

    public interface OnCuentoClickListener {
        void onCuentoClick(int position);
    }
}
