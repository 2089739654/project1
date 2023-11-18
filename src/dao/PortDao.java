package dao;

import pojo.Port;
import utils.DButil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

   public  int deleteByIndex(int index){
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
            String sql="update container set port_name=?,container_id=?,container_size=?, lading_id=?,container_yard=?,action=?,action_date=? where index=?";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(8,port.getIndex());
            preparedStatement.setString(1,port.getName());
            preparedStatement.setString(2,port.getContainer_id());
            preparedStatement.setString(3,port.getSize());
            preparedStatement.setString(4,port.getLading_id());
            preparedStatement.setString(5,port.getContainer_yard());
            preparedStatement.setString(6,port.getAction());
            preparedStatement.setString(7,port.getData());
            counter=preparedStatement.executeUpdate();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DButil.close(con,preparedStatement,null);
        }
        return counter;
    }

   public List<Port> selectByNameDate(String name, String dateON, String dateOff) throws ParseException {
        Connection con=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        List<Port> list=new ArrayList<>();
       int counter=0;
        try {
            con=DButil.GetConnection();
            String sql="select * from container where port_name=? and action_date between ? and ?";
            preparedStatement= con.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2, dateON);
            preparedStatement.setString(3, dateOff);
            rs=preparedStatement.executeQuery();
            while (rs.next()){
                String Name= rs.getString("port_name");
                String Date= String.valueOf(rs.getDate("action_date"));
                String lading_id=rs.getString("lading_id");
                String action= rs.getString("action");
               Port port=new Port();
               port.setName(Name);
               port.setAction(action);
               port.setData(Date);
               port.setLading_id(lading_id);
               list.add(port);
            }

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DButil.close(con,preparedStatement,rs);
        }
        return list;
    }






}
