package com.mcvasquez.e02sesion01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Creando editTexts
    private EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Identificando Ids
        etUsername = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etContrasena);
    }

    public void onLoginClick(View view) {
        // Obteniendo texto de los editTexts
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        // Creación de objeto booleando con la finalidad de
        // validar si los datos suministrados contienen errores
        boolean hasError = Boolean.FALSE;

        // TextUtils.isEmpty() valida si el String
        // suministrado está vacio o nulo.
        if (TextUtils.isEmpty(username)) {
            // setError() agrega un mensaje de error en el editText
            etUsername.setError(getString(R.string.error_username));
            hasError = true;
        }

        // TextUtils.isEmpty() valida si el String
        // suministrado está vacio o nulo.
        if (TextUtils.isEmpty(password)) {
            // setError() agrega un mensaje de error en el editText
            etPassword.setError(getString(R.string.error_password));
            hasError = true;
        }

        // Validación de errores y de datos suministrados
        if (!hasError && username.equalsIgnoreCase("android") && password.equalsIgnoreCase("android")) {
            // Iniciando una nuevo activity y finalizando la actual
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
        // Mostrando Toast si existe errores
        else Toast.makeText(this, getString(R.string.error_login), Toast.LENGTH_SHORT).show();
    }
}
