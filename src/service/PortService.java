package service;

import dao.PortDao;
import pojo.Port;

public class PortService {


    private PortDao portDao=new PortDao();
    public void QueryImportOutport(String name,String data){
        Port port = portDao.selectByNameDate(name, data);


    }

    public void QueryTrend(){


    }


}
