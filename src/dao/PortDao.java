package dao;

import pojo.Port;
import utils.DButil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PortDao {
    public  int insert(Port port){
        Connection con=null;
        PreparedStatement preparedStatement=null;
        int counter=0;
        try {
            con= DButil.GetConnection();
            String sql="insert into container() values(?,?,?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,port.getIndex());
            preparedStatement.setString(2,port.getName());
            preparedStatement.setString(3,port.getContainer_id());
            preparedStatement.setString(4,port.getSize());
            preparedStatement.setString(5,port.getLading_id());
            preparedStatement.setString(6,port.getContainer_yard());
            preparedStatement.setString(7,port.getAction());
            preparedStatement.setString(8,port.getData());
            counter= preparedStatement.executeUpdate();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DButil.close(con,preparedStatement,null);
        }
        return counter;
    }

   public  int deleteById(int index){
        Connection con=null;
        PreparedStatement preparedStatement=null;
        int counter=0;
        try {
            con=DButil.GetConnection();
            String sql="delete from container where index=?";
            preparedStatement=con.prepareStatement(sql);
            preparedStatement.setInt(1,index);
            counter=preparedStatement.executeUpdate(sql);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DButil.close(con,preparedStatement,null);
        }
        return counter;
    }

   public  int update(Port port){
        Connection con=null;
        PreparedStatement preparedStatement=null;
        int counter=0;
        try {
            con=DButil.GetConnection();
            String sql="update container set id=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,port.getContainer_id());
            counter=preparedStatement.executeUpdate();

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DButil.close(con,preparedStatement,null);
        }
        return counter;
    }

   public  Port selectByNameDate(String name,String data){
        Connection con=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        Port port=null;
        int counter=0;
        try {
            con=DButil.GetConnection();
            String sql="select * from container where index=? and action_date=?";
            preparedStatement= con.prepareStatement(sql);
            preparedStatement.setString(1,name);
            //preparedStatement.setDate(1,);
            rs=preparedStatement.executeQuery();
            if(rs.next()){
                String containerId=rs.getString("id");

                
               port=new Port();



            }




        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DButil.close(con,preparedStatement,rs);
        }


        return port;
    }




}
