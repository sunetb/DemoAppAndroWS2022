package dk.stbn.myfirstapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    //The view-element ListView
    ListView fooditemlist;

    GætTal game = GætTal.getInstance();
    MySingleton singleton = MySingleton.app;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Get String from the Intent that was used to start it
        String un = getIntent().getStringExtra("username");
        System.out.println("username form Menu: "+un);

        //Data for the list
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

        //The adapter for the ListView: "connects" the data from the list (fooditems) to a specific view (in this case TextView) in a specified layout for list-elements
                                                                //Layout for list-elements  //ID for the relevant TextView
        ArrayAdapter myAdapter = new ArrayAdapter(this, R.layout.listelementlayout, R.id.food, fooditems){
            //if you need to do more than just setting one text on one TextView, you CAN inherit from ArrayAdapter and override the getView method:
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                //Get the list element from super.getView()
                View listelement = super.getView(position, convertView, parent);
                //Search for the relevant TextView
                TextView number = listelement.findViewById(R.id.number);
                //Do something
                number.setText(""+position);
                return listelement;
            }
        };

        fooditemlist = findViewById(R.id.food); //Find the ListView
        fooditemlist.setAdapter(myAdapter); //Set the adapter on the ListView
        //Set an OnItemClickListener. NOT a standard OnClickListener!
        fooditemlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //Handle clicks on an item by position
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("You picked: "+fooditems.get(i) + " index: "+i);
            }
        });






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