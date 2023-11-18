package service;

import pojo.Port;
import utils.DButil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) throws ParseException, SQLException, IOException {
        PortService portService=new PortService();
        int[] i=portService.QueryImportOutport("苏州港","2022-08-01","2022-08-21");
        System.out.println(Arrays.toString(i));


    }
}
