package net.iesseveroochoa.fernandomartinezperez.practica3_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntroducirDatos extends AppCompatActivity {
    public final static String EXTRA_DATOS="IntoducirDatos";
    public final static String EXTRA_DATOS_RESULTADO="IntoducirDatos";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducir_datos);

        EditText etIntValor = findViewById(R.id.etInValor);
        String texto = getIntent().getStringExtra(EXTRA_DATOS);


        etIntValor.setText(texto);

        Button ok = findViewById(R.id.btidOK);
        ok.setOnClickListener(
                v -> {


                    String resultado = etIntValor.getText().toString();

                    Intent intent = new Intent();
                    intent.putExtra(EXTRA_DATOS_RESULTADO, resultado);
                    setResult(Activity.RESULT_OK, intent);
                    finish();


                }
        );

        Button cancel = findViewById(R.id.btidCancel);
        cancel.setOnClickListener(
                v -> finish()
        );
    }
}