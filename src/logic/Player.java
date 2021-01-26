package logic;

import java.util.ArrayList;

public class Player {

    // DateFields
    private int bankValue;
    private int marketValue;
    private int debtValue;
    private ArrayList<Items> itemsInCompany = new ArrayList<>();

    //Function that adds and item to the players inventory.
    public void buyItem(String name, int amountToBuy){

        System.out.println("My bank value is " + bankValue);
        switch (name) {
            case "Desktop" -> {
                this.itemsInCompany.get(0).setAmountOwn(this.itemsInCompany.get(0).getAmountOwn() + amountToBuy);
                this.bankValue = (int) (this.bankValue - amountToBuy * itemsInCompany.get(0).getCostPrice());
            }
            case "Cam" -> {
                this.itemsInCompany.get(1).setAmountOwn(this.itemsInCompany.get(1).getAmountOwn() + amountToBuy);
                this.bankValue = (int) (this.bankValue - amountToBuy * itemsInCompany.get(1).getCostPrice());
            }
            case "Xpod" -> {
                this.itemsInCompany.get(2).setAmountOwn(this.itemsInCompany.get(2).getAmountOwn() + amountToBuy);
                this.bankValue = (int) (this.bankValue - amountToBuy * itemsInCompany.get(2).getCostPrice());
            }
            case "Laptop" -> {
                this.itemsInCompany.get(3).setAmountOwn(this.itemsInCompany.get(3).getAmountOwn() + amountToBuy);
                this.bankValue = (int) (this.bankValue - amountToBuy * itemsInCompany.get(3).getCostPrice());
            }
            case "Xphone" -> {
                this.itemsInCompany.get(4).setAmountOwn(this.itemsInCompany.get(4).getAmountOwn() + amountToBuy);
                this.bankValue = (int) (this.bankValue - amountToBuy * itemsInCompany.get(4).getCostPrice());
            }
            case "Monitor" -> {
                this.itemsInCompany.get(5).setAmountOwn(this.itemsInCompany.get(5).getAmountOwn() + amountToBuy);
                this.bankValue = (int) (this.bankValue - amountToBuy * itemsInCompany.get(5).getCostPrice());
            }
        }


        System.out.println("I bought and item ");

        System.out.println("Now my bank value is " + bankValue);

    }



    //New Selling function
    public void newSellingItems(){
        for (int i = 0; i < 6; i++) {
            int amountToSell = (int) (10/this.getASingelItem(i).getDemand() - ((int)(Math.random()*5)+1));
            System.out.println(amountToSell);
         if (this.getItemsInCompany().get(i).getAmountOwn() > amountToSell){
             this.getASingelItem(i).setAmountOwn(this.getASingelItem(i).getAmountOwn() - amountToSell);
             this.setBankValue(this.getBankValue() + this.getASingelItem(i).getSellingPrice()*amountToSell);
         }
        }
    }

    //Debt payback function.
    public int paybackDebt(Player player, int  count){
        if(count == 10 && player.getDebtValue() !=0){

            if (bankValue >= 500){
                setBankValue(getBankValue()-500);
                player.setDebtValue(player.getDebtValue() - 500);
                return 0;
            }else
                System.out.println("You do not have enough money to payback the loan. ");

            return 0;
        }
        System.out.println("This is the outer loop");
        if (player.getDebtValue() == 0 ){
            System.out.println("You have payed back the loan ");
            return -1;
        }

        return count +1;
    }

    //function that takes the players amount of items and calculate and cost price based on that.
    public int costPriceUpdate(int cPC){
     double randomInt =  (Math.random() + 1) - 0.5;
     if (cPC == 10 ){
         for (int i = 0; i < 6; i++) {
             this.getASingelItem(i).setCostPrice((int) (this.getASingelItem(i).getORIGINAL_VALUE() * randomInt));
         }
         return 0;
     }

        return cPC + 1;
    }


    // Function that calculates the correct Market value
    public void marketValueUpdate(){
        int valueOfStock =0;
        for (int i = 0; i < 6; i++) {
            valueOfStock = valueOfStock + (this.getASingelItem(i).getAmountOwn() * this.getASingelItem(i).getCostPrice());
        }
        this.marketValue = (valueOfStock + this.bankValue);
    }



    //Getters and Setters
    public int getBankValue() {
        return bankValue;
    }

    public void setBankValue(int bankValue) {
        this.bankValue = bankValue;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    public int getDebtValue() {
        return debtValue;
    }

    public void setDebtValue(int debtValue) {
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
