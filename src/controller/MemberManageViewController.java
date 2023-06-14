package controller;

import bo.custom.impl.MemberBoImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.custom.impl.MemberDaoImpl;
import dto.MemberDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberManageViewController {
    public JFXButton btnSelectNewMember;
    public JFXButton btnSelectSearchMember;
    public JFXButton btnSelectUpdateMember;
    public JFXButton btnSelectRemoveMember;
    public AnchorPane BottomAnchorPane;
    public Label txtHeadingText;
    // Member Adding Fields
    public Label lblMemberId;
    public JFXTextField btnAddMemberName;
    public JFXTextField btnAddNicId;
    public JFXTextField btnAddContact;
    public JFXTextField btnAddEmail;
    public JFXTextField btnAddAddress;
    public JFXComboBox cmbAddSubscription;
    public JFXButton btnSaveNewMember;

    // Member Update Fields
    public JFXTextField btnUpdateMemberId;
    public JFXTextField btnUpdateMemberName;
    public JFXTextField btnUpdateMemberNic;
    public JFXTextField btnUpdateMemberContactNumber;
    public JFXTextField btnUpdateMemberEmailAddress;
    public JFXTextField btnUpdateMemberAddress;
    public JFXComboBox cmdUpdateMemberSubscription;
    public JFXButton btnUpdateMemberInfo;

    // Member Delete Fields
    public JFXTextField txtDeleteMemberId;


    public  void Navigate(String xml,AnchorPane pane) throws IOException {
        URL resource = getClass().getResource("/view/"+xml+".fxml");
        Parent load = FXMLLoader.load(resource);
        pane.getChildren().clear();
        pane.getChildren().add(load);
    }
    public void SelectNewMemberOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        Navigate("AddMemberView",BottomAnchorPane);
    }

    public void SelectSearchMemberOnAction(ActionEvent actionEvent) {
    }

    public void SelectUpdateMemberOnAction(ActionEvent actionEvent) throws IOException {
        Navigate("UpdateMemberInfoView",BottomAnchorPane);
    }

    public void SelectRemoveMemberOnAction(ActionEvent actionEvent) throws IOException {
        Navigate("RemoveMemberView",BottomAnchorPane);
    }

    public void SaveNewMemberOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String name = btnAddMemberName.getText();
        String nid = btnAddNicId.getText();
        String id = lblMemberId.getText();
        String contact = btnAddContact.getText();
        String email = btnAddEmail.getText();
        String address = btnAddAddress.getText();
        String Subs = (String) cmbAddSubscription.getValue();
        MemberDTO memberDTO = new MemberDTO(name, nid, id, contact, email, address, Subs);
        MemberBoImpl memberBo = new MemberBoImpl();
        boolean isSave = memberBo.addNewMember(memberDTO);
        if (isSave){
            new Alert(Alert.AlertType.CONFIRMATION,"Member Adding Success").show();
            ClearAddNewMemberFields();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Member Adding Failed").show();
        }
    }
    public void ClearAddNewMemberFields(){
        btnAddMemberName.clear();
        btnAddNicId.clear();
        btnAddContact.clear();
        btnAddEmail.clear();
        btnAddAddress.clear();

    }

    // Add new member key press on action
    public void GenerateId(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode()== KeyCode.ENTER){
             MemberBoImpl memberBo = new MemberBoImpl();
             String id = memberBo.GenerateId();
            lblMemberId.setText(id);
            btnAddNicId.requestFocus();
            ObservableList arrayList = memberBo.GetSubscriptionCombo();
            cmbAddSubscription.setItems(arrayList);
        }
    }

    public void NicIdKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode()==KeyCode.ENTER){
            btnAddContact.requestFocus();
        }
    }

    public void ContatcKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode()==KeyCode.ENTER){
            btnAddEmail.requestFocus();
        }
    }

    public void EmailKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode()==KeyCode.ENTER){
            btnAddAddress.requestFocus();
        }
    }

    public void AddressKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode()==KeyCode.ENTER){
            cmbAddSubscription.requestFocus();
        }
    }

    public void SubscriptionKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode()==KeyCode.ENTER){
            btnSaveNewMember.requestFocus();
        }
    }

    // Update member info key press on action
    public void UpdateNameKeyPress(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {

        MemberBoImpl memberBo1 = new MemberBoImpl();
        ObservableList arrayList = memberBo1.GetSubscriptionCombo();
        cmdUpdateMemberSubscription.setItems(arrayList);



        String UpdateMemberId=btnUpdateMemberId.getText();
        MemberDTO memberDTO = new MemberDTO(UpdateMemberId);
        MemberBoImpl memberBo = new MemberBoImpl();
        ResultSet search = memberBo.Search(memberDTO);
        if (search.next()){
            btnUpdateMemberName.setText(search.getString(1));
            btnUpdateMemberNic.setText(search.getString(2));
            btnUpdateMemberContactNumber.setText(search.getString(4));
            btnUpdateMemberEmailAddress.setText(search.getString(5));
            btnUpdateMemberAddress.setText(search.getString(6));
        }else {

        }
    }

    public void UpdateMemberInfoOnAction(ActionEvent actionEvent) {
        String id=btnUpdateMemberId.getText();
        String name=btnUpdateMemberName.getText();
        String nId=btnUpdateMemberNic.getText();
        String contactNo=btnUpdateMemberContactNumber.getText();
        String emailAddress=btnUpdateMemberEmailAddress.getText();
        String address=btnUpdateMemberAddress.getText();
        String subscriptionId= (String) cmdUpdateMemberSubscription.getValue();
        MemberDTO memberDTO = new MemberDTO(name, nId, contactNo, emailAddress, address, subscriptionId, id);
        MemberBoImpl memberBo = new MemberBoImpl();
        try {
            boolean isUpdate = memberBo.UpdateMemberInfo(memberDTO);
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"Member information updated").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Member information updating failed!!").show();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void DeleteMemberOnAction(ActionEvent actionEvent) {
        String MemberId=txtDeleteMemberId.getText();
        MemberDTO memberDTO = new MemberDTO(MemberId);
        MemberBoImpl memberBo = new MemberBoImpl();
        try {
            boolean delete = memberBo.Delete(memberDTO);
            if (delete){
                new Alert(Alert.AlertType.CONFIRMATION,"Member Deleted").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Member Delete failed!!").show();
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
