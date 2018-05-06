package com.example.alexandre.ongamebicho;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexandre.ongamebicho.ws.WebClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OcorrenciaActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ImageView imagem;
    private Bitmap scaledBitmap;
    private EditText edtRaca, edtEspecie, edtObservacao;
    private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocorrencia);

        btnEnviar = findViewById(R.id.btnEnviar);
        imagem = findViewById(R.id.imgFoto);
        edtRaca = findViewById(R.id.edtRaca);
        edtEspecie = findViewById(R.id.edtEspecie);
        edtObservacao = findViewById(R.id.edtObseravacao);

        tiraFoto();
        enviarDados();
    }

    private void enviarDados() {
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String raca = edtRaca.getText().toString();
                String especie = edtEspecie.getText().toString();
                String observacao = edtObservacao.toString();

                List<String> dados = new ArrayList<>();
                dados.add(raca);
                dados.add(especie);
                dados.add(observacao);


                enviaParaOServidor(dados);

            }
        });

    }

    private void enviaParaOServidor(List  dados) {
        WebClient ws = new WebClient();
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); StrictMode.setThreadPolicy(policy);
            ws.enviaParaServidor(dados);
            Toast.makeText(OcorrenciaActivity.this, "Dados Enviados Com Sucesso", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(OcorrenciaActivity.this, "Ocorreu um Erro ao enviar os dados: " + e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void tiraFoto() {
        imagem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent itCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (itCamera.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(itCamera, 100);
                }
                return true;
            }
        });
    }

    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Bitmap foto = (Bitmap)
                    data.getExtras().get("data");
            Bitmap fotoResized = Bitmap.createScaledBitmap(
                    foto,
                    imagem.getWidth(),
                    imagem.getHeight(),
                    true
            );
            imagem.setImageBitmap(fotoResized);
        }
    }
}