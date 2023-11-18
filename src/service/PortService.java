package service;

import dao.PortDao;
import pojo.Port;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class PortService {
    private PortDao portDao=new PortDao();
    public int[] QueryImportOutport(String name,String dateON,String dateOff) throws ParseException {
        List<Port> list = portDao.selectByNameDate(name, dateON,dateOff);
        int[] number=new int[2];
        for (Port port: list)
        {
            System.out.println(port.getAction());
            if(port.getAction().equals("出库")){number[0]++;}
            if(port.getAction().equals("入库")){number[1]++;}
        }
        return number;
    }
    public void QueryTrend(String name,String dateON,String dateOff,String lading_id) throws ParseException {
        List<Port> list = portDao.selectByNameDate(name, dateON, dateOff);
        List<Port> list1=new ArrayList<>();
        for (Port port: list
             ) {
            if(port.getLading_id().equals(lading_id)){
                list1.add(port);
            }
        }
        TreeMap<String,Integer> treeMap=new TreeMap<>();







    }


}
