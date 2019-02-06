package by.myfirstweb.test.domain.to;

import java.io.Serializable;

public class Auto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long autoId;
    private String carBrend;
    private String carModel;
    private String engine;
    private String year;
    private String color;
    private String carStatus;
    private Long priceDay;

    public Long getAutoId() {
        return autoId;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarBrend() {
        return carBrend;
    }

    public void setCarBrend(String carBrend) {
        this.carBrend = carBrend;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(Long priceDay) {
        this.priceDay = priceDay;
    }
}
