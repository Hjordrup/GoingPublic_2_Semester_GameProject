package Logic;

public class Items {
    // Datafields
    private String name;
    private double costPrice;
    private double sellingPrice;
    private double amountOwn;
    // Constructor
    public Items(String name, double costPrice, double sellingPrice, double amountOwn) {
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.amountOwn = amountOwn;
    }








    //Getter and setters
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountOwn(double amountOwn) {
        this.amountOwn = amountOwn;
    }

    public double getAmountOwn() {
        return amountOwn;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public String getName() {
        return name;
    }
}
