package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CrudDAO<T> {
    public boolean add(T entity) throws SQLException, ClassNotFoundException;
    public boolean update(T entity) throws SQLException, ClassNotFoundException;
    public ResultSet search(T entity) throws SQLException, ClassNotFoundException;
    public boolean delete(T entity) throws SQLException, ClassNotFoundException;
}
