package dk.stbn.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Menu extends AppCompatActivity {


    GætTal game = GætTal.getInstance();
    MySingleton singleton = MySingleton.app;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        String un = getIntent().getStringExtra("username");
        System.out.println("username form Manu: "+un);

    }

    @Override
    protected void onDestroy() {
        System.out.println("Ondestroy was called");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        System.out.println("onBackpressed");
        super.onBackPressed();
    }
}