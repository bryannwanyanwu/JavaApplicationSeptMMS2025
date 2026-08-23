
package hospital.models;

public class Room {
    private int id;
    private String roomNumber;
    private Ward ward;
    private String roomType;
    private int capacity;
    
    public Room(){
        
    }

    public Room(int id, String roomNumber, Ward ward, String roomType, int capacity) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.ward = ward;
        this.roomType = roomType;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    
}
