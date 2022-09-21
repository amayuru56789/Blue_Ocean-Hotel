package model;

public class Rooms {
    private String roomId;
    private String roomType;
    private String roomAvailability;
    private String price;

    public Rooms() {

    }

    public Rooms(String roomId, String roomType, String roomAvailability, String price) {
        this.setRoomId(roomId);
        this.setRoomType(roomType);
        this.setRoomAvailability(roomAvailability);
        this.setPrice(price);
    }


    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(String roomAvailability) {
        this.roomAvailability = roomAvailability;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
