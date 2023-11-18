package pojo;

public class Port {
    private Integer index;
    private String port_name;
    private String container_id;
    private String size;
    private String container_yard;
    private String lading_id;
    private String action;
    private String date;


    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getData() {
        return date;
    }

    public void setData(String data) {
        this.date = data;
    }

    public Port() {
    }

    public Port(Integer index, String port_name, String container_id, String size, String container_yard, String lading_id, String action, String date) {
        this.index = index;
        this.port_name = port_name;
        this.container_id = container_id;
        this.size = size;
        this.container_yard = container_yard;
        this.lading_id = lading_id;
        this.action = action;
        this.date = date;
    }

    public String getName() {
        return port_name;
    }

    public void setName(String name) {
        this.port_name = name;
    }

    public String getContainer_id() {
        return container_id;
    }

    public String getContainer_yard() {
        return container_yard;
    }

    public void setContainer_yard(String container_yard) {
        this.container_yard = container_yard;
    }

    public void setContainer_id(String container_id) {
        this.container_id = container_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLading_id() {
        return lading_id;
    }

    public void setLading_id(String lading_id) {
        this.lading_id = lading_id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
