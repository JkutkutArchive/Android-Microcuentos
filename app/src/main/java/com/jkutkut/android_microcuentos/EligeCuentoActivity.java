package com.jkutkut.android_microcuentos;

import static com.jkutkut.android_microcuentos.MainActivity.KEY_NOMBRE;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.jkutkut.android_microcuentos.util.CuentoAdapter;
import com.jkutkut.custom.CustomActivity;

public class EligeCuentoActivity extends CustomActivity implements CuentoAdapter.OnCuentoClickListener {

    private RecyclerView rvCuentos;
    private CuentoAdapter adapter;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_elige_cuento);

        rvCuentos = findViewById(R.id.rvCuentos);
        adapter = new CuentoAdapter(this);

        LinearLayoutManager lym = new LinearLayoutManager(this);

        rvCuentos.setLayoutManager(lym);
        rvCuentos.setHasFixedSize(true);
        rvCuentos.setAdapter(adapter);
    }

    @Override
    public void onCuentoClick(int position) {
        Intent intent = new Intent(EligeCuentoActivity.this, LeeCuentoActivity.class);
        intent.putExtra(LeeCuentoActivity.KEY_CUENTO, adapter.getCuento(position));
        intent.putExtra(KEY_NOMBRE, getIntent().getStringExtra(KEY_NOMBRE));
        startActivity(intent);
    }
}