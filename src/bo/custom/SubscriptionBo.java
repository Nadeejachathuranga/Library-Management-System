package bo.custom;

import dto.SubscriptionDTO;

import java.sql.SQLException;

public interface SubscriptionBo {
    public boolean AddNewSubscription(SubscriptionDTO dto) throws SQLException, ClassNotFoundException;

    public String GenerateSubsId() throws SQLException, ClassNotFoundException;
}
