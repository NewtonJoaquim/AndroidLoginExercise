package com.example.aluno.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    User user1;
    Button loginButton, savePasswordButton;
    EditText loginText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user1 = new User("Newton", "12345");

        loginButton = (Button)findViewById(R.id.loginButton);
        savePasswordButton = (Button)findViewById(R.id.savePasswordButton);

        loginText = (EditText)findViewById(R.id.loginText);
        passwordText = (EditText)findViewById(R.id.passwordText);

        loginButton.setOnClickListener(this);
        savePasswordButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.loginButton:
                boolean loginEqual = String.valueOf(loginText.getText()).equals(user1.login);
                Log.v("LOG", String.valueOf(loginEqual));
                boolean passwordEqual = String.valueOf(passwordText.getText()).equals(user1.password);
                Log.v("LOG", String.valueOf(passwordEqual));

                if(loginEqual && !passwordEqual){
                    Toast toast = Toast.makeText(getApplicationContext(), "Apenas o login eh verdadeiro", Toast.LENGTH_LONG);
                    toast.show();
                    Log.v("LOG", "Entrou aqui");
                }
                if(!loginEqual && passwordEqual){
                    Toast toast = Toast.makeText(getApplicationContext(), "Apenas a senha eh verdadeira", Toast.LENGTH_LONG);
                    toast.show();
                    Log.v("LOG", "Entrou aqui2");
                }
                if(loginEqual && passwordEqual){
                    Toast toast = Toast.makeText(getApplicationContext(), "Login e senha sao iguais", Toast.LENGTH_LONG);
                    toast.show();
                    Log.v("LOG", "Entrou aqui3");
                }
                break;

            case R.id.savePasswordButton:
                break;
        }
    }
}
