package logic;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class MainGameLogicController implements Initializable{
    @FXML
    private ImageView BackGroundImage, amountChangereArrow, muteButton;
    @FXML
    private Label desktopSellingPrice, desktopCostPrice, camSellingPrice, camCostPrice, xpodSellingPrice, xpodCostPrice,
            amountChecker, laptopSellingPrice, laptopCostPrice, xphoneSellingPrice, xphoneCostPrice, monitorSellingPrice,
            monitorCostPrice, desktopQuantity, camQuantity, xpodQuantity, laptopQuantity, xphoneQuantity, monitorQuantity,
            bankValueView, marketValueView, debtValueView;
    @FXML
    private Button desktopButton;
    @FXML
    private Slider dSlider, cSlider, xpodSlider, lSlider,xphoneSlider, mSlider;
    @FXML
    private ProgressBar dayProgressBar;

    @FXML
    private AnchorPane modal, coverBlack;

   @FXML
   private Rectangle desktopLine, camLine, xpodLine, laptopLine, xphoneLine, monitorLine;







    // Main player object and backgroundMusic.
    public Player mainPlayer = new Player();
    public MusicClass m1 = new MusicClass();



    //count to control the logic.
    public int count = 0;
    public int costPriceCount = 0;
    public int dayCounter =0;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Initalize the mainplayer and his company stats.
        mainPlayer.setBankValue(10000);
        mainPlayer.setMarketValue(0);
        mainPlayer.setDebtValue(100000);

        // Initialize the players first set of items.
        mainPlayer.addASingleItemToCompany(new Items("Desktop",299,499,0 ));
        mainPlayer.addASingleItemToCompany(new Items("Cam" , 399,799,0));
        mainPlayer.addASingleItemToCompany(new Items("Xpod" , 105,200,0));
        mainPlayer.addASingleItemToCompany(new Items("Laptop" , 999,1499,0));
        mainPlayer.addASingleItemToCompany(new Items("Xphone" , 499,799,0));
        mainPlayer.addASingleItemToCompany(new Items("Pc Monitor" , 120,500,0));

        //Start the BackgroundMusic
        m1.playMusic();


        // Start the thread and call methods needed to make the game run by itself i.e automatic selling items and automatic repaying the loan.
        Thread thread = new Thread(() -> {
            while (true) {
                costPriceCount = mainPlayer.costPriceUpdate(costPriceCount);
                mainPlayer.newSellingItems();
                count = mainPlayer.paybackDebt(this.mainPlayer,this.count );
                mainPlayer.marketValueUpdate();
                this.dayProgressBar.setProgress(count*0.1);
                this.mainPlayer.newSellingItems();
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        // Thread that handles the update  set to sleep every 17 mil sec so make the game run at 62 frames a sec.
        Thread gThread = new Thread(() -> {
            while (true) {
                sellingPriceModifier();
                try {
                    Thread.sleep(17);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(this::update);
            }
        });
        gThread.start();


    }


    //Function that changed the amount of items you buy
    public void changeAmountToBuy(){
        if(amountChecker.getText().equals("1")){
            amountChecker.setText("10");
        }else if ( amountChecker.getText().equals("10")){
            amountChecker.setText("100");
        }else { amountChecker.setText("1");}

    }


    // Funcktions that will activate the buy function in The player class
    public void buyD(){
            // Find what amount the player wan´t to buy.
            int amountToBuy = Integer.parseInt(amountChecker.getText());
            // Check if the player has enough money to buy.
            if(amountToBuy * mainPlayer.getASingelItem(0).getCostPrice() < mainPlayer.getBankValue()){
            mainPlayer.buyItem("Desktop",amountToBuy);
            m1.playBuySound();


        }

    }
    public void buyC(){
        int amountToBuy = Integer.parseInt(amountChecker.getText());

        if(amountToBuy * mainPlayer.getASingelItem(1).getCostPrice() < mainPlayer.getBankValue()) {
            mainPlayer.buyItem("Cam", amountToBuy);
            m1.playBuySound();
        }
    }
    public void buyXP(){

            int amountToBuy = Integer.parseInt(amountChecker.getText());

        if(amountToBuy * mainPlayer.getASingelItem(4).getCostPrice() < mainPlayer.getBankValue()) {
            mainPlayer.buyItem("Xphone", amountToBuy);
            m1.playBuySound();
        }
    }
    public void buyXp(){
        int amountToBuy = Integer.parseInt(amountChecker.getText());
            if(amountToBuy * mainPlayer.getASingelItem(2).getCostPrice() < mainPlayer.getBankValue()) {
                mainPlayer.buyItem("Xpod", amountToBuy);
                m1.playBuySound();
            }
    }
    public void buyM(){
        int amountToBuy = Integer.parseInt(amountChecker.getText());
                if(amountToBuy * mainPlayer.getASingelItem(5).getCostPrice() < mainPlayer.getBankValue()) {
                    mainPlayer.buyItem("Monitor", amountToBuy);
                    m1.playBuySound();
                }
    }
    public void buyL(){
        int amountToBuy = Integer.parseInt(amountChecker.getText());
                    if(amountToBuy * mainPlayer.getASingelItem(3).getCostPrice() < mainPlayer.getBankValue()) {
                        mainPlayer.buyItem("Laptop", amountToBuy);
                        m1.playBuySound();
                    }
    }



    // Function that set the selling price based on a modifier from a slider in the game. And at the same times set a demand for the item.
    public void sellingPriceModifier(){
        this.mainPlayer.getASingelItem(0).setSellingPrice((int) (this.mainPlayer.getASingelItem(0).getORGINAL_SELLINGPRICE()* dSlider.getValue()));
        this.mainPlayer.getASingelItem(1).setSellingPrice((int) (this.mainPlayer.getASingelItem(1).getORGINAL_SELLINGPRICE()* cSlider.getValue()));
        this.mainPlayer.getASingelItem(2).setSellingPrice((int) (this.mainPlayer.getASingelItem(2).getORGINAL_SELLINGPRICE()* xpodSlider.getValue()));
        this.mainPlayer.getASingelItem(3).setSellingPrice((int) (this.mainPlayer.getASingelItem(3).getORGINAL_SELLINGPRICE()* lSlider.getValue()));
        this.mainPlayer.getASingelItem(4).setSellingPrice((int) (this.mainPlayer.getASingelItem(4).getORGINAL_SELLINGPRICE()* xphoneSlider.getValue()));
        this.mainPlayer.getASingelItem(5).setSellingPrice((int) (this.mainPlayer.getASingelItem(5).getORGINAL_SELLINGPRICE()* mSlider.getValue()));

        this.mainPlayer.getASingelItem(0).setDemand((double)this.mainPlayer.getASingelItem(0).getSellingPrice()/this.mainPlayer.getASingelItem(0).getORGINAL_SELLINGPRICE());
        this.mainPlayer.getASingelItem(1).setDemand((double)this.mainPlayer.getASingelItem(1).getSellingPrice()/this.mainPlayer.getASingelItem(1).getORGINAL_SELLINGPRICE());
        this.mainPlayer.getASingelItem(2).setDemand((double)this.mainPlayer.getASingelItem(2).getSellingPrice()/this.mainPlayer.getASingelItem(2).getORGINAL_SELLINGPRICE());
        this.mainPlayer.getASingelItem(3).setDemand((double)this.mainPlayer.getASingelItem(3).getSellingPrice()/this.mainPlayer.getASingelItem(3).getORGINAL_SELLINGPRICE());
        this.mainPlayer.getASingelItem(4).setDemand((double)this.mainPlayer.getASingelItem(4).getSellingPrice()/this.mainPlayer.getASingelItem(4).getORGINAL_SELLINGPRICE());
        this.mainPlayer.getASingelItem(5).setDemand((double)this.mainPlayer.getASingelItem(5).getSellingPrice()/this.mainPlayer.getASingelItem(5).getORGINAL_SELLINGPRICE());




    }

    //Mute gameSound.
    public void muteSound(){
        m1.muteSound();
    }

    //Update function
    public void update(){
        bankValueView.setText(mainPlayer.getBankValue() + "$");
        debtValueView.setText(mainPlayer.getDebtValue() +"$");
        marketValueView.setText(mainPlayer.getMarketValue() +"$");

        desktopCostPrice.setText(mainPlayer.getASingelItem(0).getCostPrice() + "$");
        desktopSellingPrice.setText(mainPlayer.getASingelItem(0).getSellingPrice() + "$");
        desktopQuantity.setText(String.valueOf(mainPlayer.getASingelItem(0).getAmountOwn()));

        camCostPrice.setText(mainPlayer.getASingelItem(1).getCostPrice() + "$");
        camSellingPrice.setText(mainPlayer.getASingelItem(1).getSellingPrice() + "$");
        camQuantity.setText(String.valueOf(mainPlayer.getASingelItem(1).getAmountOwn()));

        xpodCostPrice.setText(mainPlayer.getASingelItem(2).getCostPrice() + "$");
        xpodSellingPrice.setText(mainPlayer.getASingelItem(2).getSellingPrice() + "$");
        xpodQuantity.setText(String.valueOf(mainPlayer.getASingelItem(2).getAmountOwn()));

        laptopCostPrice.setText(mainPlayer.getASingelItem(3).getCostPrice() + "$");
        laptopSellingPrice.setText(mainPlayer.getASingelItem(3).getSellingPrice() + "$");
        laptopQuantity.setText(String.valueOf(mainPlayer.getASingelItem(3).getAmountOwn()));

        xphoneSellingPrice.setText(mainPlayer.getASingelItem(4).getSellingPrice() + "$");
        xphoneCostPrice.setText(mainPlayer.getASingelItem(4).getCostPrice() + "$");
        xphoneQuantity.setText(String.valueOf(mainPlayer.getASingelItem(4).getAmountOwn()));

        monitorSellingPrice.setText(mainPlayer.getASingelItem(5).getSellingPrice() + "$");
        monitorCostPrice.setText(mainPlayer.getASingelItem(5).getCostPrice() +"$");
        monitorQuantity.setText(String.valueOf(mainPlayer.getASingelItem(5).getAmountOwn()));

    }





    public void openChart(){
        modal.setVisible(!modal.isVisible());
        coverBlack.setVisible(!coverBlack.isVisible());
        setLineSize();
    }

    public void setLineSize(){
        desktopLine.setHeight(360*(2-mainPlayer.getASingelItem(0).getDemand()));
        camLine.setHeight(360*(2-mainPlayer.getASingelItem(1).getDemand()));
        xpodLine.setHeight(360*(2-mainPlayer.getASingelItem(2).getDemand()));
        laptopLine.setHeight(360*(2-mainPlayer.getASingelItem(3).getDemand()));
        xphoneLine.setHeight(360*(2-mainPlayer.getASingelItem(4).getDemand()));
        monitorLine.setHeight(360*(2-mainPlayer.getASingelItem(5).getDemand()));
    }








    }
