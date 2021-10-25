package net.iesseveroochoa.fernandomartinezperez.practica3_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class NuevoContacto extends AppCompatActivity {
    public final static String EXTRA_NOMBRE = "NuevoContacto";
    public final static String EXTRA_APELLIDOS = "NuevoContacto";
    public final static String EXTRA_TELEFONO = "NuevoContacto";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        TextView tvNombre = findViewById(R.id.tvNombre);
        tvNombre.setOnClickListener(
                v -> {
                    Intent intent = new Intent(NuevoContacto.this, IntroducirDatos.class);
                    intent.putExtra(IntroducirDatos.EXTRA_DATOS,tvNombre.getText());
                    startActivityForResult(intent, 1);
                }
        );

        TextView tvApellidos = findViewById(R.id.tvApellidos);
        tvApellidos.setOnClickListener(
                v -> {
                    Intent intent = new Intent(NuevoContacto.this, IntroducirDatos.class);
                    intent.putExtra(IntroducirDatos.EXTRA_DATOS,tvApellidos.getText());
                    startActivityForResult(intent, 2);
                }
        );

        TextView tvEmpresa = findViewById(R.id.tvEmpresa);
        tvEmpresa.setOnClickListener(
                v -> {
                    Intent intent = new Intent(NuevoContacto.this, IntroducirDatos.class);
                    intent.putExtra(IntroducirDatos.EXTRA_DATOS,tvEmpresa.getText());
                    startActivityForResult(intent, 3);
                }
        );
        EditText etTelefono = findViewById(R.id.etTelefono);

        Button ok = findViewById(R.id.btNCOk);
        ok.setOnClickListener(
                v -> {
                    Intent intent = new Intent();

                    intent.putExtra(EXTRA_NOMBRE, tvNombre.getText());
                    intent.putExtra(EXTRA_APELLIDOS, tvApellidos.getText());
                    intent.putExtra(EXTRA_TELEFONO, etTelefono.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
        );

        Button cancel = findViewById(R.id.btNCCancel);
        cancel.setOnClickListener(
                v -> finish()
        );



        ImageView ivParticularEmpresa = findViewById(R.id.ivParticularEmpresa);
        RadioGroup rgEmpresa = findViewById(R.id.rgEmpresa);
        rgEmpresa.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rbtEmpresa:
                    ivParticularEmpresa.setVisibility(View.VISIBLE);
                    ivParticularEmpresa.setImageResource(R.mipmap.ic_empresa);
                    break;
                case R.id.rbtParticular:
                    ivParticularEmpresa.setVisibility(View.VISIBLE);
                    ivParticularEmpresa.setImageResource(R.mipmap.ic_particular);
            }
        });



        ImageView ivGenero = findViewById(R.id.ivGenero);
        RadioGroup rgGenero = findViewById(R.id.rgGenero);
        rgGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbtMujer:
                        ivGenero.setVisibility(View.VISIBLE);
                        ivGenero.setImageResource(R.mipmap.ic_mujer);
                        break;
                    case R.id.rbtHombre:
                        ivGenero.setVisibility(View.VISIBLE);
                        ivGenero.setImageResource(R.mipmap.ic_hombre);
                }
            }
        });


        ImageView ivFavorito = findViewById(R.id.ivFavorito);
        Switch swfavorito = findViewById(R.id.swFavoritos);
        swfavorito.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                ivFavorito.setVisibility(View.VISIBLE);
            } else {
                ivFavorito.setVisibility(View.INVISIBLE);
            }
        });


        ImageView ivLlamar = findViewById(R.id.ivLlamar);
        CheckBox cbxLlamar = findViewById(R.id.cbxLlamar);
        cbxLlamar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                ivLlamar.setVisibility(View.VISIBLE);
            } else {
                ivLlamar.setVisibility(View.INVISIBLE);
            }
        });

        TextView tvEdad = findViewById(R.id.tvEdad);
        int maxEdad = getResources().getInteger(R.integer.maxedad);
        SeekBar sbedad = findViewById(R.id.sbEdad);
        sbedad.setMax(maxEdad);
        sbedad.setProgress(maxEdad / 2);
        tvEdad.setText(String.valueOf(maxEdad / 2));

        sbedad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvEdad.setText(String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvApellidos = findViewById(R.id.tvApellidos);
        TextView tvEmpresa = findViewById(R.id.tvEmpresa);

        super.onActivityResult(requestCode, resultCode, data);

        String resultado;

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1) {
                resultado = data.getStringExtra(IntroducirDatos.EXTRA_DATOS_RESULTADO);
                tvNombre.setText(resultado);

            } else if (requestCode == 2) {
                resultado = data.getStringExtra(IntroducirDatos.EXTRA_DATOS_RESULTADO);
                tvApellidos.setText(resultado);

            } else if (requestCode == 3) {
                resultado = data.getStringExtra(IntroducirDatos.EXTRA_DATOS_RESULTADO);
                tvEmpresa.setText(resultado);
            }
        }
    }
}