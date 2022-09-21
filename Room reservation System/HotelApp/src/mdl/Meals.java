package mdl;

public class Meals {
    private String id;
    private String plan;
    private String meals;
    private String price;

    public Meals() {

    }

    public Meals(String id, String plan, String meals, String price) {
        this.setId(id);
        this.setPlan(plan);
        this.setMeals(meals);
        this.setPrice(price);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
