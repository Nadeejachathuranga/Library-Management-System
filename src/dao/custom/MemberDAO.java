package dao.custom;

import dao.CrudDAO;
import entity.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberDAO extends CrudDAO<Member> {
    public ResultSet GenerateId() throws SQLException, ClassNotFoundException;
    public ArrayList GetSubscriptionCombo() throws SQLException, ClassNotFoundException;
}
