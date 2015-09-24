package example.com.recipe;

/**
 * Created by user on 23/9/2015.
 */
public class FoodDataProvider {
    private int food_pics_resource;
    private String food_names;
    private String food_makers;

    public FoodDataProvider(int food_pics_resource, String food_names,String food_makers){
        this.setFood_pics_resource(food_pics_resource);
        this.setFood_names(food_names);
        this.setFood_makers(food_makers);
    }

    public int getFood_pics_resource() {
        return food_pics_resource;
    }

    public void setFood_pics_resource(int food_pics_resource) {
        this.food_pics_resource = food_pics_resource;
    }

    public String getFood_names() {
        return food_names;
    }

    public void setFood_names(String food_names) {
        this.food_names = food_names;
    }

    public String getFood_makers() {
        return food_makers;
    }

    public void setFood_makers(String food_makers) {
        this.food_makers = food_makers;
    }
}
