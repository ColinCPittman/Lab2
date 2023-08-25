public class StockItem {
    private String description;
    private int ID;
    private int quantity;
    private static int nextID = 1;
    private float price;
    public String getDescription() {
        return description;
    }

    public int getID() {
        return ID;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(float price) {
        if (price >= 0.0f) {
            this.price = price;
        } else System.out.println("Error: Price cannot be less than zero");
    }

    public void lowerQty(int reduction) {
        if (quantity - reduction < 0) {
            System.out.println("Error: Item quantity cannot be below zero.");
        } else {
            quantity -= reduction;
        }
    }
    public void raiseQty(int addition) {
            quantity += addition;
    }

    public StockItem() {
        this.ID = nextID++;
        description = "";
        price = 0;
        quantity = 0;
    }
    public StockItem(String description, float price, int quantity){
        this.ID = nextID++;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }
    public String toString() {
        return "Product ID: " + ID + ". " + description + ". Stock quantity is " + quantity + " with a unit price of " + price + ".";
    }


}
