package dao.custom;

import dao.CrudDAO;
import entity.Subscription;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SubscriptionDAO extends CrudDAO<Subscription> {
    public ResultSet GenerateSubsId() throws SQLException, ClassNotFoundException;
}
