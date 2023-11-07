package pojo;

public class Port {

    private Integer index;
    private String name;
    private String container_id;
    private String size;
    private String container_yard;
    private String lading_id;
    private String action;

    private String data;


    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Port() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
