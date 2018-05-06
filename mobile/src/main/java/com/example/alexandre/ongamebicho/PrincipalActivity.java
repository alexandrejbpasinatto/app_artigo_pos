package com.example.alexandre.ongamebicho;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.alexandre.ongamebicho.R.id.btnOcorrencias;

public class PrincipalActivity extends AppCompatActivity {

    private Button btnOcorrencia, btnAnimais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


      btnOcorrencia = findViewById(btnOcorrencias);

      btnOcorrencia.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent itOcorrencia = new Intent();
              itOcorrencia.setClass(PrincipalActivity.this, OcorrenciaActivity.class);
              startActivity(itOcorrencia);
          }
      });

    }

}
