
package hospital.models;

public class Ward {
    private int id;
    private String name;
    private String wardType;
    private int capacity;
    
    public Ward(){
        
    }

    public Ward(int id, String name, String wardType, int capacity) {
        this.id = id;
        this.name = name;
        this.wardType = wardType;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWardType() {
        return wardType;
    }

    public void setWardType(String wardType) {
        this.wardType = wardType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    
}
