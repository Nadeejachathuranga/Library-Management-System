package bo.custom;

import dto.MemberDTO;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberBo {
    public String GenerateId() throws SQLException, ClassNotFoundException;
    public ObservableList GetSubscriptionCombo() throws SQLException, ClassNotFoundException;
    public boolean addNewMember(MemberDTO dto) throws SQLException, ClassNotFoundException;
    public boolean UpdateMemberInfo(MemberDTO dto) throws SQLException, ClassNotFoundException;
    public ResultSet Search(MemberDTO dto) throws SQLException, ClassNotFoundException;
    public boolean Delete(MemberDTO dto) throws SQLException, ClassNotFoundException;
}
