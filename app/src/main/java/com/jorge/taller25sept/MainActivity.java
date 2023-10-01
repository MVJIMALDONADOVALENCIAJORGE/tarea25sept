package com.jorge.taller25sept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button gle,alar,llam,con,cam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       gle = findViewById(R.id.google);
       alar = findViewById(R.id.alarma);
       llam = findViewById(R.id.llamar);
       con = findViewById(R.id.temporizador);
       cam = findViewById(R.id.camara);

       gle.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            Intent irGoogle = new Intent(Intent.ACTION_VIEW);
            irGoogle.setData(Uri.parse("https://www.google.com"));
            startActivity(irGoogle);

           }
       });

       alar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                    Intent irAlarma = new Intent(AlarmClock.ACTION_SET_ALARM)
                            .putExtra(AlarmClock.EXTRA_MESSAGE,"trabajar")
                            .putExtra(AlarmClock.EXTRA_HOUR,2)
                            .putExtra(AlarmClock.EXTRA_MINUTES, 30);
                    if(irAlarma.resolveActivity(getPackageManager()) !=null){
                        startActivity(irAlarma);
                    }
           }
       });

       con.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent incTemprozador = new Intent(AlarmClock.ACTION_SET_TIMER)
                       .putExtra(AlarmClock.EXTRA_MESSAGE, "comenzando temporizador")
                       .putExtra(AlarmClock.EXTRA_LENGTH,160)
                       .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
               if (incTemprozador.resolveActivity(getPackageManager()) != null) {
                   startActivity(incTemprozador);
               }
           }
       });

       cam.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent camara = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
               startActivityForResult(camara);
           }
       });
    }



    private void startActivityForResult(Intent camara) {
        startActivity(camara);
    }
}