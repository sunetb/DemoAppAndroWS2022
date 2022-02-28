package dk.stbn.myfirstapp;

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

    GætTal game = new GætTal();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            Intent myIntent = new Intent(this, Menu.class);
            startActivity(myIntent);
        }
        else{
        Log.d("Sune", " hello was clicked");
        String username = nameET.getText().toString();
        nameTV.setText("Username was: " + username);
        }
    }
}