package dk.stbn.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {


    GætTal game = GætTal.getInstance();
    MySingleton singleton = MySingleton.app;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Get String from the Intent that was used to start it
        String un = getIntent().getStringExtra("username");
        System.out.println("username form Menu: "+un);


        //List
        ArrayList<String> fooditems = new ArrayList<>();

        fooditems.add("bread");
        fooditems.add("banana");
        fooditems.add("butter");
        fooditems.add("potato");
        fooditems.add("apple");
        fooditems.add("rice");
        fooditems.add("milk");
        fooditems.add("sauce");
        fooditems.add("peanutbutter");
        fooditems.add("carrot");
        fooditems.add("juice");
        fooditems.add("egg");
        fooditems.add("flour");
        fooditems.add("chili");
        fooditems.add("pepper");
        fooditems.add("salt");
        fooditems.add("cheese");
        fooditems.add("salad");

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