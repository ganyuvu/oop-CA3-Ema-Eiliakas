public class Block {
    private int quantity;
    private double price;

    public Block(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    //getters
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }

    //setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}

