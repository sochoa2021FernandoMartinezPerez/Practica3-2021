package net.iesseveroochoa.fernandomartinezperez.practica3_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int EXTRA_NUEVO_CONTACTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**Este Evento lanza la acividad NuevoContacto */
        Button nuevo = (Button) findViewById(R.id.btNuebo);
        nuevo.setOnClickListener(
                view -> {
                    Intent intent = new Intent(MainActivity.this, NuevoContacto.class);
                    startActivityForResult(intent, EXTRA_NUEVO_CONTACTO);
                }
        );
        /**Este evento cierra la app */
        Button salir = (Button) findViewById(R.id.btSalir);
        salir.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
    }
    /**Este evento recupera los datos del nuevo contacto*/
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        TextView tvAgenda = findViewById(R.id.tvAgenda);

        String agendaTemp = tvAgenda.getText().toString();

        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == Activity.RESULT_OK) {
            agendaTemp += ("\n" + data.getStringExtra(NuevoContacto.EXTRA_NOMBRE) + " " +
                    data.getStringExtra(NuevoContacto.EXTRA_APELLIDOS) + "-" + data.getStringExtra(NuevoContacto.EXTRA_TELEFONO));
            tvAgenda.setText(agendaTemp);
        }
    }
}