package test.com.coolweather.model;

/**
 * Created by Yang on 2015/11/26.
 */
public class County {
    private  int id;
    private  String countyName;
    private  String countPyName;
    private  int cityId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountPyName() {
        return countPyName;
    }

    public void setCountPyName(String countPyName) {
        this.countPyName = countPyName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }


}
