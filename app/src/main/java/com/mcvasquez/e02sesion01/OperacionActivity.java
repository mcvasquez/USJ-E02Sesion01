package com.mcvasquez.e02sesion01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class OperacionActivity extends AppCompatActivity {

    public static final String QUOTATION = "";
    public static final String SUMAR = "sumar";
    public static final String RESTAR = "restar";
    public static final String MULTIPLICAR = "multiplicar";
    public static final String DIVIDIR = "dividir";
    String[] opciones = {SUMAR, RESTAR, MULTIPLICAR, DIVIDIR};
    private EditText et1;
    private EditText et2;
    private TextView tv1;
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion);
        onInit();

    }

    public void onInit() {
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);
        Toolbar toolbar = findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new
                ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                opciones);
        spinner1.setAdapter(adapter);
    }

    public void operar(View view) {
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        if (valor1.equals(QUOTATION) && valor2.equals(QUOTATION)) {
            tv1.setText(R.string.mensaje1);
        } else if (valor1.equals("")) {
            tv1.setText(R.string.mensaje2);
        } else if (valor2.equals("")) {
            tv1.setText(R.string.mensaje3);
        } else {
            int nro1 = Integer.parseInt(valor1);
            int nro2 = Integer.parseInt(valor2);
            realizarOperacion(nro1, nro2);
        }
    }


    public void realizarOperacion(int nro1, int nro2) {
        String selec = spinner1.getSelectedItem().toString();
        String resu = null;
        int operacion;
        switch (selec) {
            case SUMAR: {
                operacion = nro1 + nro2;
                resu = String.valueOf(operacion);
                tv1.setText(resu);
                break;
            }
            case RESTAR: {
                operacion = nro1 - nro2;
                resu = String.valueOf(operacion);
                tv1.setText(resu);
                break;
            }
            case MULTIPLICAR: {
                operacion = nro1 * nro2;
                resu = String.valueOf(operacion);
                tv1.setText(resu);
                break;
            }
            case DIVIDIR: {
                operacion = nro1 / nro2;
                resu = String.valueOf(operacion);
                tv1.setText(resu);
                break;
            }
            default:
                resu = getString(R.string.mensaje6);
        }

        tv1.setText(resu);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
