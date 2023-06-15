package bo.custom.impl;

import bo.custom.SubscriptionBo;
import dao.custom.impl.SubscriptionDaoImpl;
import dto.SubscriptionDTO;
import entity.Subscription;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriptionBoImpl implements SubscriptionBo {
    @Override
    public boolean AddNewSubscription(SubscriptionDTO dto) throws SQLException, ClassNotFoundException {
        SubscriptionDaoImpl subscriptionDao = new SubscriptionDaoImpl();
      return   subscriptionDao.add(new Subscription(dto.getName(),dto.getId(),dto.getPrice(),dto.getTimePeriod(),dto.getDescription(),dto.getFine()));
    }

    @Override
    public String GenerateSubsId() throws SQLException, ClassNotFoundException {
        SubscriptionDaoImpl subscriptionDao = new SubscriptionDaoImpl();
        ResultSet resultSet = subscriptionDao.GenerateSubsId();
        String id="Cant get id";
        if (resultSet.next()){
            if (resultSet.next()) {
                String c = resultSet.getString(1);
                System.out.println(c);
            }
            String Auto = resultSet.getString(1);
            String[] Last = Auto.split("s00");
            int AutoId = Integer.parseInt(Last[01]);
            AutoId += 1;
            String AutoGenerateId = "s000" + AutoId;
            System.out.println(AutoId);
            System.out.println(AutoGenerateId);
            return AutoGenerateId;
        }
        return id;
    }
}
