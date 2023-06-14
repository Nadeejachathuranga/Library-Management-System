package bo.custom.impl;

import bo.custom.BookBo;
import dao.custom.impl.BookDaoImpl;
import dto.BookDTO;
import entity.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookBoImpl implements BookBo {

    public static ResultSet getCategoryToComboBox() throws SQLException, ClassNotFoundException {
       return BookDaoImpl.getCombo();

    }

    @Override
    public boolean add(BookDTO dto) throws SQLException, ClassNotFoundException {
        BookDaoImpl bookDao = new BookDaoImpl();
       return bookDao.add(new Book(dto.getName(),dto.getId(),dto.getAuthor(),dto.getQuantity(),dto.getCategory(),dto.getPages(),dto.getPrice(),dto.getSupplierName(),dto.getSupplierBatch(),dto.getIsbn()));
    }

    @Override
    public ObservableList getcombo() throws SQLException, ClassNotFoundException {
        BookDaoImpl bookDao = new BookDaoImpl();
        ArrayList arrayList = bookDao.GetCombo();
        ObservableList<Object> objects = FXCollections.observableArrayList();
        for (Object name:arrayList) {
            objects.add(name);
        }
        return objects;
    }

    @Override
    public boolean addNewCategory(BookDTO bookDTO) throws SQLException, ClassNotFoundException {
        BookDaoImpl bookDao = new BookDaoImpl();
        return bookDao.AddNewCategory(new Book(bookDTO.getCategory()));
    }

    @Override
    public boolean RemoveCategory(BookDTO bookDTO) throws SQLException, ClassNotFoundException {
        BookDaoImpl bookDao = new BookDaoImpl();
       return bookDao.removeCategory(new Book(bookDTO.getCategory()));
    }
}
