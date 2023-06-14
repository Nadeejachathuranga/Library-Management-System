package controller;

import bo.custom.impl.BookBoImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.BookDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookManageViewController implements Initializable{
    public Label txtHeadingText;
    public JFXButton btnAddNewBook;
    public AnchorPane BottomAnchorPane;
    public JFXButton btnSelectNewCategory;
    public JFXButton btnSelectUpdateBookInfo;
    public JFXButton btnSelectRemoveBook;
    public JFXButton btnSelectBookSearch;


    // Book Adding Fields
    public JFXTextField txtBookName;
    public JFXTextField txtAuthorName;
    public JFXComboBox cmbCategory;
    public JFXComboBox cmbSupplierName;
    public JFXComboBox cmbSupplierBatch;
    public JFXTextField txtQuantity;
    public JFXTextField txtPages;
    public JFXTextField txtPrice;
    public JFXTextField txtIsbn;

    // Category Adding Fields
    public JFXButton btnSaveNewCategory;
    public JFXComboBox cmbRemoveBookCategory;
    public JFXButton btnRemoveCategory;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            LoadCategoryCombo();
            LoadCategoryNameCombo();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void AddNewBookHover(MouseEvent mouseEvent) {
    }

    public void AddNewBookCategoryHover(MouseEvent mouseEvent) {
    }

    public void AddNewBookOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        URL resource = getClass().getResource("/view/AddBookView.fxml");
        Parent load = FXMLLoader.load(resource);
        BottomAnchorPane.getChildren().clear();
        BottomAnchorPane.getChildren().add(load);
        LoadCategoryCombo();

    }

    public void SaveNewBookOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
           String bookName=txtBookName.getText();
           String bookId="bid001";
           String authorName = txtAuthorName.getText();
           String category="novel";
           String supplierName="neone publisher";
           String supplierBatch="spb001";
           int quantity=10;
           int pages=200;
           int price=780;
           String isbn="00001";
           BookDTO bookDTO = new BookDTO(bookName, bookId, authorName, quantity, category, pages, price, supplierName, supplierBatch, isbn);
           BookBoImpl bookBo = new BookBoImpl();
        boolean add = bookBo.add(bookDTO);
        if (add){
            new Alert(Alert.AlertType.CONFIRMATION,"Book Adding Success").show();
        }
    }

    public void SelectNewCategoryOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        URL resource = getClass().getResource("/view/AddNewCategoryView.fxml");
        Parent load = FXMLLoader.load(resource);
        BottomAnchorPane.getChildren().clear();
        BottomAnchorPane.getChildren().add(load);
    }

    public void SelectUpdateBookInfoOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/UpdateBookInfoView.fxml");
        Parent load = FXMLLoader.load(resource);
        BottomAnchorPane.getChildren().clear();
        BottomAnchorPane.getChildren().add(load);
    }

    public void SelectRemoveBookOnAction(ActionEvent actionEvent) {
      //  Navigate();
    }

    public void SelectBookSearchOnAction(ActionEvent actionEvent) {
      //  Navigate();
    }
    public void LoadCategoryCombo() throws SQLException, ClassNotFoundException {
        ArrayList<String> category = new ArrayList<>();
        ObservableList<Object> objects = FXCollections.observableArrayList();
        ResultSet categoryToComboBox = BookBoImpl.getCategoryToComboBox();
        if (categoryToComboBox.next()){
            while (categoryToComboBox.next()){
                category.add(categoryToComboBox.getString("name"));
            }
            for (String name : category){
                objects.add(name);
            }
        }
        System.out.println("fx"+objects);
        System.out.println("Arr"+category);
    }
    public void LoadCategoryNameCombo(){
    try {
        BookBoImpl bookBo = new BookBoImpl();
        ObservableList category = bookBo.getcombo();
        cmbCategory.setItems(category);
    }catch (Exception e){
        System.out.println(e);
    }
    }

    public void AddNewBookNamekeyPress(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        if (keyEvent.getCode()== KeyCode.ENTER){
           LoadCategoryNameCombo();
        }
    }

    public void SaveNewCategoryOnAction(ActionEvent actionEvent) {
        String NewCategoryName=txtBookName.getText();
        BookDTO bookDTO = new BookDTO(NewCategoryName);
        BookBoImpl bookBo = new BookBoImpl();
        try {
            boolean isCategoryAdd = bookBo.addNewCategory(bookDTO);
            if (isCategoryAdd) {
                new Alert(Alert.AlertType.CONFIRMATION, "New Category adding Successfully").show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "New Category adding Failed").show();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void newBookCategoryKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode()==KeyCode.ENTER){
            LoadCategoryNameCombo();
            btnSaveNewCategory.requestFocus();
        }
    }

    public void removeCategoryOnAction(ActionEvent actionEvent) {
        String categoryName= (String) cmbRemoveBookCategory.getValue();
        BookDTO bookDTO = new BookDTO(categoryName);
        BookBoImpl bookBo = new BookBoImpl();
        try {
            boolean isDelete = bookBo.RemoveCategory(bookDTO);
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION,categoryName+ " is Deleted").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,categoryName+ " is Deleting failed").show();
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }


}
