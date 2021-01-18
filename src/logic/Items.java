package logic;

public class Items {
    // Datafields
    private String name;
    private int costPrice;
    private int sellingPrice;
    private int amountOwn;
    // Constructor
    public Items(String name, int costPrice, int sellingPrice, int amountOwn) {
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.amountOwn = amountOwn;
    }








    //Getter and setters
    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountOwn(int amountOwn) {
        this.amountOwn = amountOwn;
    }

    public int getAmountOwn() {
        return amountOwn;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public String getName() {
        return name;
    }
}
