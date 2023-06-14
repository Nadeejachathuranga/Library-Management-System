package dao.custom;

import dao.CrudDAO;
import entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookDao extends CrudDAO<Book> {
    public ArrayList GetCombo() throws SQLException, ClassNotFoundException;
    public boolean AddNewCategory(Book book) throws SQLException, ClassNotFoundException;
    public boolean removeCategory(Book book) throws SQLException, ClassNotFoundException;
}
