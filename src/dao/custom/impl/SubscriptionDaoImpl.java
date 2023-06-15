package dao.custom.impl;

import dao.SqlUtil;
import dao.custom.SubscriptionDAO;
import entity.Subscription;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriptionDaoImpl implements SubscriptionDAO {
    @Override
    public boolean add(Subscription entity) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO subscriptions VALUES (?, ?, ?, ?,?,?)";
         return SqlUtil.Execute(sql,entity.getName(),entity.getId(),entity.getPrice(),entity.getTimePeriod(),entity.getDescription(),entity.getFine());
    }

    @Override
    public boolean update(Subscription entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ResultSet search(Subscription entity) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(Subscription entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ResultSet GenerateSubsId() throws SQLException, ClassNotFoundException {
        String sql="SELECT id  FROM subscriptions ORDER BY id DESC LIMIT 1;";
        ResultSet execute = SqlUtil.Execute(sql);
        return execute;
    }
}
