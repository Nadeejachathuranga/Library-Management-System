package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class DashBoardViewController {
    public AnchorPane MainAnchorPane;
    public JFXButton btnBorrowBook;
    public AnchorPane NavigateAnchorPane;
    public JFXButton btnBookManage;
    public JFXButton btnMemberManage;


    public void Navigate(String fxml) throws IOException {
        URL resource = getClass().getResource("/view/"+fxml);
        Parent load = FXMLLoader.load(resource);
        NavigateAnchorPane.getChildren().clear();
        NavigateAnchorPane.getChildren().add(load);
    }

    public void BorrowingBookOnAction(ActionEvent actionEvent) throws IOException {
        Navigate("BorrowView.fxml");
    }

    public void BookManageOnAction(ActionEvent actionEvent) throws IOException {
        Navigate("BookManageView.fxml");
    }

    public void MemberManageOnAction(ActionEvent actionEvent) throws IOException {
        Navigate("MemberManageView.fxml");
    }
}
