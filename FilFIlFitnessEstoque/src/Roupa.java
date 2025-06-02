public class Roupa {
    //Variables

    private int code;
    private String name;
    private String size;
    private String color;
    private float price;
    private int quantity;
    private boolean status;

//setters

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(boolean status) {
        if(quantity > 0){
            this.status = true;
        }else{
            this.status = false;
        }
    }

    //Getters

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean getStatus() {
        return status;
    }

    //Functions

    void sale (){
        if(status == true){
        quantity--;
        }else{
            return;
        }

    }
}
