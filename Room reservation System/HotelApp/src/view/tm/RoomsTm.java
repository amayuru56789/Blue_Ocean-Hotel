package view.tm;

import javafx.scene.control.Button;

public class RoomsTm {
    private String id;
    private String type;
    private String availability;
    private String price;

    private Button btn;

    public RoomsTm() {
    }

    public RoomsTm(String id, String type, String availability, String price, Button btn) {
        this.setId(id);
        this.setType(type);
        this.setAvailability(availability);
        setPrice(price);
        this.setBtn(btn);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        price = price;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
