package com.valencia.ambulanceroute;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityNumeros extends AppCompatActivity {
    Button bomberos;
    Button cruz;
    Button defensa;
    Button ambulancias;
    Button policia;
    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);

        volver = (Button)findViewById(R.id.btnvolver);
        bomberos =(Button)findViewById(R.id.btnbomberos);
        cruz =(Button)findViewById(R.id.btncruzroja);
        defensa =(Button)findViewById(R.id.btndefensa);
        ambulancias =(Button)findViewById(R.id.btnambulancia);
        policia =(Button)findViewById(R.id.btnpolicia);

        bomberos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:119"));
                if (ActivityCompat.checkSelfPermission(ActivityNumeros.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(ActivityNumeros.this,"por favor active los permisos de llamada",Toast.LENGTH_SHORT).show();
                    requestPermissions();
                }
                else {
                    startActivity(intent);
                }

            }
        });
        cruz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:132"));
                if (ActivityCompat.checkSelfPermission(ActivityNumeros.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(ActivityNumeros.this,"Por favor active los permisos de llamada",Toast.LENGTH_SHORT).show();
                    requestPermissions();
                }
                else{
                    startActivity(i);
                }
            }
        });
        defensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(Intent.ACTION_CALL,Uri.parse("tel:144"));
                if (ActivityCompat.checkSelfPermission(ActivityNumeros.this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(ActivityNumeros.this,"Por favor active los permisos de llamada",Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(d);
                }
            }
        });
        ambulancias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Intent.ACTION_CALL,Uri.parse("tel:3155265864"));
                if (ActivityCompat.checkSelfPermission(ActivityNumeros.this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(ActivityNumeros.this,"por favor active los permisos de llamada",Toast.LENGTH_SHORT).show();
                }
                else {
                    startActivity(a);
                }
            }
        });
        policia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(Intent.ACTION_CALL,Uri.parse("tel:8331900"));
                if (ActivityCompat.checkSelfPermission(ActivityNumeros.this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(ActivityNumeros.this,"por favor active los permisos de llamada",Toast.LENGTH_SHORT).show();
                }
                else {
                    startActivity(p);
                }
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Registrador = new Intent(ActivityNumeros.this,Ambulance_Route.class);
                startActivity(Registrador);
            }
        });
    }
    private void requestPermissions() {
        ActivityCompat.requestPermissions(ActivityNumeros.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
    }
}
