package com.afpa.checker;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
public static final String EXTRA_MESSAGE = "com.afpa.adrien.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        Intent intent =new Intent(this,plusActivity.class);
        EditText prenomEntre1 =  (EditText) findViewById(R.id.entreText);
        Prenom prenom1 = new Prenom(prenomEntre1.getText().toString()) ;
        EditText prenomEntre2 = (EditText) findViewById(R.id.entreText2);
        Prenom prenom2 = new Prenom(prenomEntre2.getText().toString()) ;
        Double resultat= prenom1.checkMatch(prenom2);


        intent.putExtra(EXTRA_MESSAGE,resultat);
        startActivity(intent);
    }
}
