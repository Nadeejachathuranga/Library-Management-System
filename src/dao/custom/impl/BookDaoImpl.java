package dao.custom.impl;

import dao.SqlUtil;
import dao.custom.BookDao;
import entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookDaoImpl implements BookDao {

    public static ResultSet getCombo() throws SQLException, ClassNotFoundException {
        String sql="SELECT name FROM category";
        ResultSet execute = SqlUtil.Execute(sql);
        return execute;

    }

    @Override
    public boolean add(Book entity) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO books VALUES (?, ?, ?, ?,?,?,?,?,?,?)";
        return SqlUtil.Execute(sql,entity.getName(),entity.getId(),entity.getAuthor(),entity.getQuantity(),entity.getCategory(),entity.getPages(),entity.getPrice(),entity.getSupplierName(),entity.getSupplierBatch(),entity.getIsbn());
    }

    @Override
    public boolean update(Book entity) {
       // String sql="UPDATE members SET name = ?, nic_id = ?, contact_no = ?, email = ?, address= ?, subscription_Id= ? WHERE id = ? ";
      //  return SqlUtil.Execute(sql,);
        return true;
    }

    @Override
    public ResultSet search(Book entity) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(Book entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList GetCombo() throws SQLException, ClassNotFoundException {
        String sql="SELECT name FROM category";
        ResultSet execute = SqlUtil.Execute(sql);
        ArrayList<Object> objects = new ArrayList<>();
        if(execute.next()){
            while (execute.next()){
                objects.add(execute.getString(1));
            }
        }else {
            System.out.println("BookDaoImpl-->  Cant get Result");
        }
        return objects;
    }

    @Override
    public boolean AddNewCategory(Book book) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO category VALUES(?,?)";
        String date= String.valueOf(LocalDate.now());
        return SqlUtil.Execute(sql,book.getCategory(),date);
    }

    @Override
    public boolean removeCategory(Book book) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM category where name = ?";
        return SqlUtil.Execute(sql,book.getCategory());
    }
}
