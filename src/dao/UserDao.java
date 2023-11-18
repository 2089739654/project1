package dao;

import pojo.User;
import utils.DButil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public int insert(User user){
        Connection con=null;
        PreparedStatement preparedStatement=null;
        int counter=0;
        try {
            con= DButil.GetConnection();
            String sql="insert into userdata() values(?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,user.getIndex());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getId());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setInt(6,user.getPassword());
            counter= preparedStatement.executeUpdate();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DButil.close(con,preparedStatement,null);
        }
        return counter;
    }

    public int deleteByIndex(User user){
        Connection con=null;
        PreparedStatement preparedStatement=null;
        int counter=0;
        try {
            con= DButil.GetConnection();
            String sql="delete from userdata() where index=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,user.getIndex());
            counter= preparedStatement.executeUpdate();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DButil.close(con,preparedStatement,null);
        }
        return counter;
    }

    public int selectByIdPassword(String id,Integer password){
        Connection con=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        int counter=0;
        try {
            con= DButil.GetConnection();
            String sql="select * from userdata() where id=? and password=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setInt(2,password);
            rs= preparedStatement.executeQuery();
            if(rs.next()){
                counter++;
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DButil.close(con,preparedStatement,rs);
        }
        return counter;
    }



}
