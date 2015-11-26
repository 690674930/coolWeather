package test.com.coolweather.model;

/**
 * Created by Yang on 2015/11/26.
 */
public class Province {

    private  int id;
    private  String provinceName;
    private  String provincePyName;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }



    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }


    public String getProvincePyName() {
        return provincePyName;
    }

    public void setProvincePyName(String provincePyName) {
        this.provincePyName = provincePyName;
    }

}
