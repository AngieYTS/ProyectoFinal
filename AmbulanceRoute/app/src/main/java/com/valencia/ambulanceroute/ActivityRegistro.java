package com.valencia.ambulanceroute;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityRegistro extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText Correo,Contraseña;
    Button RegistroBien;
    private ProgressDialog progressDialog;
    FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();

        Correo=(EditText)findViewById(R.id.CorreoUsuario);
        Contraseña=(EditText)findViewById(R.id.ContraseñaUsuario);
        RegistroBien=(Button)findViewById(R.id.btnRegistrado);
        progressDialog = new ProgressDialog(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null){
                    startActivity(new Intent(ActivityRegistro.this,Ambulance_Route.class));
                }else{
                    Toast.makeText(ActivityRegistro.this,"Sus datos son incorrectos",Toast.LENGTH_SHORT).show();

                }


            }
        };
        RegistroBien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistroFirebase();

            }
        });

    }
    public void RegistroFirebase() {

        progressDialog.setMessage("Registrando Usuario...");
        progressDialog.show();
        String email = Correo.getText().toString();
        String password = Contraseña.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("INFO", "createUserWithEmail:success");
                            startActivity(new Intent(ActivityRegistro.this,ActivityIniciarSesion.class));
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.w("INFO", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Correo no Valido o Contraseña muy Corta", Toast.LENGTH_SHORT).show();

                        }
                        progressDialog.dismiss();
                    }
                });

    }
    }