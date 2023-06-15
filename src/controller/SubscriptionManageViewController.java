package controller;

import bo.custom.SubscriptionBo;
import bo.custom.impl.SubscriptionBoImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.SubscriptionDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class SubscriptionManageViewController {

    public AnchorPane BottomAnchorPane;

    //Subscription adding Field
    public JFXTextField txtSubsName;
    public JFXTextField txtSubsPrice;
    public JFXTextField txtSubsTimePeriod;
    public JFXTextField txtSubsDescription;
    public JFXTextField txtSubsFine;
    public Label lblSubsId;
    public JFXButton btnSaveNewSubscriptionPack;

    public  void Navigate(String xml,AnchorPane pane) throws IOException {
        URL resource = getClass().getResource("/view/"+xml+".fxml");
        Parent load = FXMLLoader.load(resource);
        pane.getChildren().clear();
        pane.getChildren().add(load);
    }

    public void AddNewSubscriptionOnAction(ActionEvent actionEvent) throws IOException {
        Navigate("AddSubscriptionView",BottomAnchorPane);
    }

    public void ChangeSubcriptionInfoOnAction(ActionEvent actionEvent) throws IOException {
      //  Navigate("AddSubscriptionView",BottomAnchorPane);
    }

    public void RemoveSubscriptionOnAction(ActionEvent actionEvent) {
        //  Navigate("AddSubscriptionView",BottomAnchorPane);
    }

    public void SaveNewSubscriptionPackOnAction(ActionEvent actionEvent) throws IOException {
        String name=txtSubsName.getText();
        String id="s003";
        String price=txtSubsPrice.getText();
        String timePeriod=txtSubsTimePeriod.getText();
        String description=txtSubsDescription.getText();
        String fine=txtSubsFine.getText();
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO(name, id, price, timePeriod, description, fine);
        SubscriptionBoImpl subscriptionBo = new SubscriptionBoImpl();
        try {
            boolean isAdd = subscriptionBo.AddNewSubscription(subscriptionDTO);
            if (isAdd){
                new Alert(Alert.AlertType.CONFIRMATION,name+" is added").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,name+" is adding failed").show();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void SubsNameKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode()== KeyCode.ENTER){
            GenerateSubscriptionId();
        }
    }
    public void GenerateSubscriptionId(){
        SubscriptionBoImpl subscriptionBo = new SubscriptionBoImpl();
        try {
            String id = subscriptionBo.GenerateSubsId();
            lblSubsId.setText(id);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
