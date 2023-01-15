package com.jkutkut.android_microcuentos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jkutkut.custom.CustomActivity;

public class MainActivity extends CustomActivity implements View.OnClickListener {

    public static final String KEY_NOMBRE = "nombre";

    private EditText etNombre;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String user = etNombre.getText().toString().trim();
        if (user.isEmpty()) {
            etNombre.setError("Introduce tu nombre");
            return;
        }
        if (user.length() < 3) {
            etNombre.setError("El nombre debe tener al menos 3 caracteres");
            return;
        }
        Intent i = new Intent(this, EligeCuentoActivity.class);
        i.putExtra(KEY_NOMBRE, user);
        startActivity(i);
        finish();
    }
}