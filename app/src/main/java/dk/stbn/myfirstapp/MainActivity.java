package dk.stbn.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b, hello;
    TextView hi, nameTV;
    EditText nameET;

    GætTal game = GætTal.getInstance();
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game.setMax(2000);
        b = findViewById(R.id.welcome);
        b.setOnClickListener(this);
        hello = findViewById(R.id.button2);
        hello.setOnClickListener(this);
        hi = findViewById(R.id.textView);
        nameTV = findViewById(R.id.textView2);
        nameET = findViewById(R.id.name);

    }


    @Override
    public void onClick(View v) {
        if(v == b) {
//DO NOT instantiate activities yourself !!!!             new AppCompatActivity()
            Intent myIntent = new Intent(this, Menu.class);
            startActivity(myIntent);

        }
        else{
        Log.d("Sune", " hello was clicked");
        username = nameET.getText().toString();
        nameTV.setText("Username was: " + username);
        }
    }

    @Override
    protected void onPause() {
        System.out.println("onPause: Backgrounded");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("username", username);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        username = savedInstanceState.getString("username");
        System.out.println(username);
    }

    @Override
    protected void onStop() {
        System.out.println("onStop: Invisible");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("ondestroy");
        super.onDestroy();
    }

}