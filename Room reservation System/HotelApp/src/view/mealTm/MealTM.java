package view.mealTm;

import javafx.scene.control.Button;

public class MealTM {
    private String id;
    private String plan;
    private String meals;
    private String price;
    private Button btn;

    public MealTM() {
    }

    public MealTM(String id, String plan, String meals, String price, Button btn) {
        this.setId(id);
        this.setPlan(plan);
        this.setMeals(meals);
        this.setPrice(price);
        this.setBtn(btn);
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
