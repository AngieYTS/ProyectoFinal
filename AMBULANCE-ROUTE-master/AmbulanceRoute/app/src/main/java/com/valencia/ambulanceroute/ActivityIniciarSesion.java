package com.valencia.ambulanceroute;

import android.app.Activity;
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


public class




ActivityIniciarSesion extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText Email,Password;
    private Button siguiente;
    private Button Registro;
    FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        mAuth = FirebaseAuth.getInstance();
        Registro = (Button)findViewById(R.id.btnRegistrarse);
        Email=(EditText)findViewById(R.id.Email);
        Password=(EditText)findViewById(R.id.Password);
        siguiente=(Button)findViewById(R.id.btniniciarsesion);

        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                if(firebaseAuth.getCurrentUser()!=null){
                    startActivity(new Intent(ActivityIniciarSesion.this,Ambulance_Route.class));
                }else{
                    Toast.makeText(ActivityIniciarSesion.this,"Sus datos son incorrectos",Toast.LENGTH_SHORT).show();

            }


            }

        };
        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Registrador = new Intent(ActivityIniciarSesion.this,ActivityRegistro.class);
                startActivity(Registrador);


            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PruebaFirebase();


            }
        });

    }

    public void PruebaFirebase() {

        String email = Email.getText().toString();
        String password = Password.getText().toString();



        mAuth.signInWithEmailAndPassword("aytumina@misena.edu.co","123456").addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("INFO", "signInWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                        startActivity(new Intent(ActivityIniciarSesion.this,Ambulance_Route.class));

                    Toast.makeText(getApplicationContext(),"Bienvenido",Toast.LENGTH_SHORT).show();
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("INFO", "signInWithEmail:failure", task.getException());
                    Toast.makeText(getApplicationContext(),"Sus Datos son incorrectos",Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}
