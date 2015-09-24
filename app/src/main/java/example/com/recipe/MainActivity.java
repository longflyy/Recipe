package example.com.recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int[] food_pics_resource = {R.drawable.food_1, R.drawable.food_2,R.drawable.food_3,
                                R.drawable.food_4,R.drawable.food_5,R.drawable.food_6};
    String[] food_names;
    String[] food_makers;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        food_makers = getResources().getStringArray(R.array.food_makers);
        food_names = getResources().getStringArray(R.array.food_names);
        int i=0;
        adapter = new FoodAdapter(getApplicationContext(), R.layout.single_row);
        listView.setAdapter(adapter);
        for (String names: food_names){
            FoodDataProvider dataProvider = new FoodDataProvider(food_pics_resource[i],
            names, food_makers[i]);
            adapter.add(dataProvider);
            i++;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_others) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
