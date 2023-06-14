package bo.custom.impl;

import bo.custom.MemberBo;
import dao.custom.impl.MemberDaoImpl;
import dto.MemberDTO;
import entity.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberBoImpl implements MemberBo {
    private String AutoGenerateId;

    @Override
    public String GenerateId() throws SQLException, ClassNotFoundException {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        ResultSet resultSet = memberDao.GenerateId();
        if (resultSet.next()) {
            String c = resultSet.getString(1);
            System.out.println(c);
        }
        String Auto = resultSet.getString(1);
        String[] Last = Auto.split("MBR");
        int AutoId = Integer.parseInt(Last[01]);
        AutoId += 1;
        String AutoGenerateId = "MBR0" + AutoId;
        System.out.println(AutoId);
        System.out.println(AutoGenerateId);
        return AutoGenerateId;

    }

    @Override
    public ObservableList<Object> GetSubscriptionCombo() throws SQLException, ClassNotFoundException {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        ArrayList arrayList1 = memberDao.GetSubscriptionCombo();
        ObservableList<Object> objects = FXCollections.observableArrayList();
        for (Object name : arrayList1) {
            objects.add(name);
        }
        System.out.println(objects);
        return objects;
    }

    @Override
    public boolean addNewMember(MemberDTO dto) throws SQLException, ClassNotFoundException {
        MemberDaoImpl memberDao = new MemberDaoImpl();
      return memberDao.add(new Member(dto.getName(), dto.getNid(), dto.getId(), dto.getContactNo(), dto.getEmail(), dto.getAddress(), dto.getSubs()));
    }

    @Override
    public boolean UpdateMemberInfo(MemberDTO dto) throws SQLException, ClassNotFoundException {
        MemberDaoImpl memberDao = new MemberDaoImpl();
       return memberDao.update(new Member(dto.getName(),dto.getNid(),dto.getContactNo(),dto.getEmail(),dto.getAddress(),dto.getSubs(),dto.getId()));
    }

    @Override
    public ResultSet Search(MemberDTO dto) throws SQLException, ClassNotFoundException {
        MemberDaoImpl memberDao = new MemberDaoImpl();
       return memberDao.search(new Member(dto.getId()));
    }

    @Override
    public boolean Delete(MemberDTO dto) throws SQLException, ClassNotFoundException {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        return memberDao.delete(new Member(dto.getId()));
    }
}
