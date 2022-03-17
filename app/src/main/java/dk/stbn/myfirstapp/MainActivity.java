package dk.stbn.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
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
    SharedPreferences mySp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the SharedPreferences object that you can tead and write data to. Is stored on disk
        mySp = PreferenceManager.getDefaultSharedPreferences(this);

        //Reading from SharedPreferences
        boolean hasTheUserLoggedIn = mySp.getBoolean("loggedIn", false);

        System.out.println("logged in?: "+hasTheUserLoggedIn);
  /*
        String name = "Sune";

        SharedPreferences.Editor editor =  mySp.edit();

        editor.putString("username", name);

        editor.apply();

*/
        mySp.getString("username", "blank");

        game.setMax(2000);
        b = findViewById(R.id.welcome);
        b.setOnClickListener(this);
        hello = findViewById(R.id.button2);
        hello.setOnClickListener(this);
        hi = findViewById(R.id.textView);
        nameTV = findViewById(R.id.textView2);
        nameET = findViewById(R.id.name);
        hi.setText("login "+hasTheUserLoggedIn);

    }


    @Override
    public void onClick(View v) {
        if (v == b) {
//DO NOT instantiate activities yourself !!!!             new AppCompatActivity()
            username = nameET.getText().toString();
            int number = Integer.parseInt(username);
            game.gæt(number);
            //Intent myIntent = new Intent(this, Menu.class);
            //myIntent.putExtra("username", username);
            //startActivity(myIntent);

            //Writing to SharedPreferences
            mySp.edit().putBoolean("loggedIn", true).apply();

            //get the username
            username = "www.ruc.dk";


            // Share string with intent
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, username);
            sendIntent.setType("text/plain");

            // Try to invoke the intent.
            try {
                startActivity(sendIntent);
            } catch (ActivityNotFoundException e) {
                // Define what your app should do if no activity can handle the intent.
            }

        }
        else{
            mySp.edit().putBoolean("loggedIn", false).apply();

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