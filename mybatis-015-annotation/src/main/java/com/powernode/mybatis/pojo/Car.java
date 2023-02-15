package com.powernode.mybatis.pojo;

import java.io.Serializable;

/**
 * @Author iyeee
 * @Date 2023/2/8 0:47
 * @Version 1.0.1
 */
public class Car implements Serializable {
    // 数据库表中的字段应该和pojo一一对应
    // 可能为空，建议用包装类，防止null问题
    private Long id;
    private String carNo;
    private String brand;
    private Double guidePrice;
    private String produceTime;
    private String carType;

    public Car() {
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carNo='" + carNo + '\'' +
                ", brand='" + brand + '\'' +
                ", guidePrice=" + guidePrice +
                ", produceTime='" + produceTime + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(Double guidePrice) {
        this.guidePrice = guidePrice;
    }

    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Car(Long id, String carNo, String brand, Double guidePrice, String produceTime, String carType) {
        this.id = id;
        this.carNo = carNo;
        this.brand = brand;
        this.guidePrice = guidePrice;
        this.produceTime = produceTime;
        this.carType = carType;
    }
}
