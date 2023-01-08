package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import Connect.DataDB;
import Entity.Account;

public class AccountDao
{
    public static void addAccount(final Account account) throws SQLException, ClassNotFoundException {
        DataDB db = new DataDB();
        PreparedStatement sta = db.getStatement("insert into account (username, password, fullname, phone, sex, role, enabled, newsletter, date) values (?, ?, ?, ?, ?, 1, 1, ?, now())");
        sta.setString(1, account.getUsername());
        sta.setString(2, account.getPassword());
        sta.setString(3, account.getFullName());
        sta.setString(4, account.getPhoneNumber());
        sta.setInt(5, account.getSex());
        sta.setString(6, ""+account.getNewsletter());
        sta.executeUpdate();
    }
    
    public static void updateAccount(final Account account) throws SQLException, ClassNotFoundException {
        DataDB db = new DataDB();
        PreparedStatement sta = db.getStatement("update account set fullname =? , phone=? , sex=? where username = ?");
        sta.setString(1, account.getFullName());
        sta.setString(2, account.getPhoneNumber());
        sta.setInt(3, account.getSex());
        sta.setString(4, account.getUsername());
        sta.executeUpdate();
    }
    public static void updatePassword(final Account account) throws SQLException, ClassNotFoundException {
        DataDB db = new DataDB();
        PreparedStatement sta = db.getStatement("update account set password =? where username = ?");
        sta.setString(1, account.getPassword());
        sta.setString(2, account.getUsername());
        sta.executeUpdate();
    }

    public static String getFullName(String username) throws SQLException, ClassNotFoundException{
        DataDB db = new DataDB();
        PreparedStatement sta = db.getStatement("select * from account where username = ?");
        sta.setString(1, username);
        ResultSet rs = sta.executeQuery();
        String name = "";
        if(rs.next()){
            name = rs.getString("fullname");
        }
        return name;
    }
}