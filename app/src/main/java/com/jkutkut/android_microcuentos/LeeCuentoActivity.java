package com.jkutkut.android_microcuentos;

import static com.jkutkut.android_microcuentos.MainActivity.KEY_NOMBRE;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.jkutkut.android_microcuentos.model.Cuento;
import com.jkutkut.custom.CustomActivity;

public class LeeCuentoActivity extends CustomActivity {

    public static final String KEY_CUENTO = "cuento";

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_lee_cuento);

        // UI
        TextView txtvTitle = findViewById(R.id.txtvTitle);
        TextView txtvCuento = findViewById(R.id.txtvCuento);

        String user = getIntent().getStringExtra(KEY_NOMBRE);
        Cuento cuento = (Cuento) getIntent().getSerializableExtra(KEY_CUENTO);

        txtvTitle.setText(cuento.getTitulo());
        txtvCuento.setText(String.format(cuento.getTexto(), user));
    }
}