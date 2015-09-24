package example.com.recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by user on 23/9/2015.
 */
public class FoodAdapter extends ArrayAdapter {
    List list = new ArrayList();

    public FoodAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class DataHandler{
        ImageView Pics;
        TextView Names;
        TextView Makers;
    }
    @Override
    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
            row = convertView;
        DataHandler handler;
            if (convertView == null){
                LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.single_row,parent, false);
                handler = new DataHandler();
                handler.Pics = (ImageView) row.findViewById(R.id.food_pics);
                handler.Names = (TextView) row.findViewById(R.id.food_name);
                handler.Makers = (TextView) row.findViewById(R.id.food_maker);
                row.setTag(handler);
            }else{
                handler = (DataHandler) row.getTag();
            }
            FoodDataProvider dataProvider;
        dataProvider = (FoodDataProvider) this.getItem(position);
        handler.Pics.setImageResource(dataProvider.getFood_pics_resource());
        handler.Names.setText(dataProvider.getFood_names());
        handler.Makers.setText(dataProvider.getFood_makers());

        return row;
    }
}
