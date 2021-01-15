package logic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


public class MainGameLogicController implements Initializable {
    @FXML
    private ImageView BackGroundImage;
    @FXML
    private Label amountChecker;
    @FXML
    private Label desktopSellingPrice;
    @FXML
    private Label desktopCostPrice;
    @FXML
    private Label camSellingPrice;
    @FXML
    private Label camCostPrice;
    @FXML
    private Label xpodSellingPrice;
    @FXML
    private Label xpodCostPrice;
    @FXML
    private Label laptopSellingPrice;
    @FXML
    private Label laptopCostPrice;
    @FXML
    private Label xphoneSellingPrice;
    @FXML
    private Label xphoneCostPrice;
    @FXML
    private Label monitorSellingPrice;
    @FXML
    private Label monitorCostPrice;
    @FXML
    private Label desktopQuantity;
    @FXML
    private Label camQuantity;
    @FXML
    private Label xpodQuantity;
    @FXML
    private Label laptopQuantity;
    @FXML
    private Label xphoneQuantity;
    @FXML
    private Label monitorQuantity;
    @FXML
    private Label bankValueView;
    @FXML
    private Label marketValueView;
    @FXML
    private Label debtValueView;
    @FXML
    private Label companyLsvIEW;
    @FXML
    private ImageView amountChangereArrow;
    @FXML
    private Button desktopButton;

    Player mainPlayer = new Player();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Initalize the mainplayer and his company stats.

        mainPlayer.setBankValue(10000);
        mainPlayer.setMarketValue(0);
        mainPlayer.setDebtValue(1000000);
        bankValueView.setText(mainPlayer.getBankValue() + "$");
        debtValueView.setText(mainPlayer.getDebtValue() +"$");
        marketValueView.setText(mainPlayer.getMarketValue() +"$");


        // Initialize the players first set of items. and set the view to the correct stats.
        mainPlayer.addASingleItemToCompany(new Items("Desktop",10,100,0 ));
        desktopCostPrice.setText(mainPlayer.getASingelItem(0).getCostPrice() + "$");
        desktopSellingPrice.setText(mainPlayer.getASingelItem(0).getSellingPrice() + "$");
        desktopQuantity.setText(String.valueOf(mainPlayer.getASingelItem(0).getAmountOwn()));


        mainPlayer.addASingleItemToCompany(new Items("Cam" , 11,4,0));
        camCostPrice.setText(mainPlayer.getASingelItem(1).getCostPrice() + "$");
        camSellingPrice.setText(mainPlayer.getASingelItem(1).getSellingPrice() + "$");
        camQuantity.setText(String.valueOf(mainPlayer.getASingelItem(1).getAmountOwn()));

        mainPlayer.addASingleItemToCompany(new Items("Xpod" , 11,4,0));
        mainPlayer.addASingleItemToCompany(new Items("Laptop" , 11,4,0));
        mainPlayer.addASingleItemToCompany(new Items("Xphone" , 11,4,0));
        mainPlayer.addASingleItemToCompany(new Items("Pc Monitor" , 11,4,0));

    }

    //Function that changed the amount of items you buy
    public void changeAmountToBuy(){
        if(amountChecker.getText().equals("1")){
            amountChecker.setText("10");
        }else if ( amountChecker.getText().equals("10")){
            amountChecker.setText("100");
        }else { amountChecker.setText("1");}
    }



    // Funcktions that will get activate the buy function in The player class
    public void buyD(){
            // Find what amount the player wan´t to buy.
            int amountToBuy = Integer.parseInt(amountChecker.getText());
            // Check if the player has enough money to buy.
            if(amountToBuy * mainPlayer.getASingelItem(0).getCostPrice() < mainPlayer.getBankValue()){
            mainPlayer.buyItem("Desktop",amountToBuy);
        }

    }
    public void buyC(){
        int amountToBuy = Integer.parseInt(amountChecker.getText());

        if(amountToBuy * mainPlayer.getASingelItem(1).getCostPrice() < mainPlayer.getBankValue()) {
            mainPlayer.buyItem("Cam", amountToBuy);
        }
    }
    public void buyXP(){

            int amountToBuy = Integer.parseInt(amountChecker.getText());

        if(amountToBuy * mainPlayer.getASingelItem(4).getCostPrice() < mainPlayer.getBankValue()) {
            mainPlayer.buyItem("Xphone", amountToBuy);
        }
    }
    public void buyXp(){
        int amountToBuy = Integer.parseInt(amountChecker.getText());
            if(amountToBuy * mainPlayer.getASingelItem(2).getCostPrice() < mainPlayer.getBankValue()) {
                mainPlayer.buyItem("Xpod", amountToBuy);
            }
    }
    public void buyM(){
        int amountToBuy = Integer.parseInt(amountChecker.getText());
                if(amountToBuy * mainPlayer.getASingelItem(5).getCostPrice() < mainPlayer.getBankValue()) {
                    mainPlayer.buyItem("Monitor", amountToBuy);
                }
    }
    public void buyL(){
        int amountToBuy = Integer.parseInt(amountChecker.getText());
                    if(amountToBuy * mainPlayer.getASingelItem(3).getCostPrice() < mainPlayer.getBankValue()) {
                        mainPlayer.buyItem("Laptop", amountToBuy);
                    }
    }


public void sellRandomItems(){
        mainPlayer.sellingItem();
}












































}
