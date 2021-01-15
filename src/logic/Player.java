package logic;

import java.util.ArrayList;

public class Player {

    // DateFields
    private double bankValue;
    private double marketValue;
    private double debtValue;
    private ArrayList<Items> itemsInCompany = new ArrayList<>();

    //Function that adds and item to the players inventory.
    public void buyItem(String name, int amountToBuy){

        System.out.println("My bank value is " + bankValue);
        if(name.equals("Desktop")){

            this.itemsInCompany.get(0).setAmountOwn(this.itemsInCompany.get(0).getAmountOwn() + amountToBuy);
            this.bankValue = this.bankValue - amountToBuy*itemsInCompany.get(0).getCostPrice();
        }else if(name.equals("Cam")){

            this.itemsInCompany.get(1).setAmountOwn(this.itemsInCompany.get(1).getAmountOwn() + amountToBuy);
            this.bankValue = this.bankValue - amountToBuy*itemsInCompany.get(1).getCostPrice();

        }else if(name.equals("Xpod")){

            this.itemsInCompany.get(2).setAmountOwn(this.itemsInCompany.get(2).getAmountOwn() + amountToBuy);
            this.bankValue = this.bankValue - amountToBuy*itemsInCompany.get(2).getCostPrice();

        }else if(name.equals("Laptop")){

            this.itemsInCompany.get(3).setAmountOwn(this.itemsInCompany.get(3).getAmountOwn() + amountToBuy);
            this.bankValue = this.bankValue - amountToBuy*itemsInCompany.get(3).getCostPrice();

        }else if(name.equals("Xphone")){

            this.itemsInCompany.get(4).setAmountOwn(this.itemsInCompany.get(4).getAmountOwn() + amountToBuy);
            this.bankValue = this.bankValue - amountToBuy*itemsInCompany.get(4).getCostPrice();

        }else if(name.equals("Monitor")){

            this.itemsInCompany.get(5).setAmountOwn(this.itemsInCompany.get(5).getAmountOwn() + amountToBuy);
            this.bankValue = this.bankValue - amountToBuy*itemsInCompany.get(5).getCostPrice();

        }


        System.out.println("I bought and item ");

        System.out.println("Now my bank value is " + bankValue);

    }


    //Function that pickes and random type of item and sells and random amount of that items.
    public void sellingItem(){
        int amountToSell = (int)(Math.random()*10)+1;
        int itemToSell = (int)(Math.random()*6);

        if(itemsInCompany.get(itemToSell).getAmountOwn() > amountToSell){
            itemsInCompany.get(itemToSell).setAmountOwn(itemsInCompany.get(itemToSell).getAmountOwn() - amountToSell);
            setBankValue(getBankValue() + (itemsInCompany.get(itemToSell).getSellingPrice()*amountToSell) );
        }
    }


    //TODO Update function;

    //Getters and Setters
    public double getBankValue() {
        return bankValue;
    }

    public void setBankValue(double bankValue) {
        this.bankValue = bankValue;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public double getDebtValue() {
        return debtValue;
    }

    public void setDebtValue(double debtValue) {
        this.debtValue = debtValue;
    }


    public ArrayList<Items> getItemsInCompany() {
        return itemsInCompany;
    }

    public Items getASingelItem(int p){
        return itemsInCompany.get(p);
    }
    
    public void setItemsInCompany(ArrayList<Items> itemsInCompany) {
        this.itemsInCompany = itemsInCompany;
    }

    public void addASingleItemToCompany(Items item ){
        this.itemsInCompany.add(item);
    }
}
