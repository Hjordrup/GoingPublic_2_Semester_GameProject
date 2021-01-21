package logic;

public class Items {
    // Datafields
    private String name;
    private int costPrice;
    private int sellingPrice;
    private int amountOwn;
    private final int ORIGINAL_VALUE;
    private int ORGINAL_SELLINGPRICE;

    // Constructor
    public Items(String name, int costPrice, int sellingPrice, int amountOwn) {
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.amountOwn = amountOwn;
        this.ORIGINAL_VALUE = this.costPrice;
        this.ORGINAL_SELLINGPRICE = this.sellingPrice;
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

    public int getORIGINAL_VALUE(){
        return this.ORIGINAL_VALUE;
    }

    public int getORGINAL_SELLINGPRICE() {
        return ORGINAL_SELLINGPRICE;
    }
}
