package bo.custom;

import dto.BookDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface BookBo {
    public boolean add(BookDTO dto) throws SQLException, ClassNotFoundException;
    public ObservableList getcombo() throws SQLException, ClassNotFoundException;
    public boolean addNewCategory(BookDTO bookDTO) throws SQLException, ClassNotFoundException;
    public boolean RemoveCategory(BookDTO bookDTO) throws SQLException, ClassNotFoundException;
}
