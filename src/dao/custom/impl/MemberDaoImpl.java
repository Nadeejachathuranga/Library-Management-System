package dao.custom.impl;

import dao.SqlUtil;
import dao.custom.MemberDAO;
import entity.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDaoImpl implements MemberDAO {
    @Override
    public ResultSet GenerateId() throws SQLException, ClassNotFoundException {
        String sql="SELECT id  FROM members ORDER BY id DESC LIMIT 1;";
        ResultSet execute = SqlUtil.Execute(sql);
        return execute;
    }

    @Override
    public ArrayList GetSubscriptionCombo() throws SQLException, ClassNotFoundException {
        ArrayList<String> objects = new ArrayList<>();
        String sql="SELECT id FROM subscriptions";
        ResultSet execute = SqlUtil.Execute(sql);
        if (execute.next()){
         //   while (execute.next()){
                objects.add(execute.getString(1));
                System.out.println(execute.getString(1));
         //   }
        }else {
            System.out.println("cant get Result");
        }

        return objects;
    }

    @Override
    public boolean add(Member entity) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO members VALUES (?, ?, ?, ?,?,?,?)";
        return SqlUtil.Execute(sql,entity.getName(),entity.getNid(),entity.getId(),entity.getContactNo(),entity.getEmail(),entity.getAddress(),entity.getSubs());
    }

    @Override
    public boolean update(Member entity) throws SQLException, ClassNotFoundException {
        String sql="UPDATE members SET name = ?, nic_id = ?, contact_no = ?, email = ?, address= ?, subscription_Id= ? WHERE id = ? ";
        return SqlUtil.Execute(sql,entity.getName(),entity.getNid(),entity.getContactNo(),entity.getEmail(),entity.getAddress(),entity.getSubs(),entity.getId());
    }

    @Override
    public ResultSet search(Member entity) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM members where id=?";
        return SqlUtil.Execute(sql,entity.getId());
    }

    @Override
    public boolean delete(Member entity) throws SQLException, ClassNotFoundException {
        String sql="DELETE from members where id = ?";
        return SqlUtil.Execute(sql,entity.getId());
    }
}
