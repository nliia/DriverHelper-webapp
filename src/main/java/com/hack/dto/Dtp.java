package com.hack.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hack.model.Car;
import com.hack.model.User;

import java.util.Date;

/**
 * @author lnurullina
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dtp {
    private Long id;
    private String fullDtpPlace;
    private Long date;
    private int carCrashedCount;
    private int victimsNumbers;
    private boolean matherialDamageToTransportExceptAandB;
    private boolean matherialDamagToDifferentThinks;
    private String witnessesFullNameAndAdresses;
    private boolean finished = false;
    private Double latitude;
    private Double longitude;
    private User firstUser;
    private User secondUser;
    private Car firstCar;
    private Car secondCar;
    private String firstUsersName;
    private String secondUsersName;
    @JsonIgnore
    private Date dateD;

    public String getFullDtpPlace() {
        return fullDtpPlace;
    }

    public void setFullDtpPlace(String fullDtpPlace) {
        this.fullDtpPlace = fullDtpPlace;
    }


    public int getCarCrashedCount() {
        return carCrashedCount;
    }

    public void setCarCrashedCount(int carCrashedCount) {
        this.carCrashedCount = carCrashedCount;
    }

    public int getVictimsNumbers() {
        return victimsNumbers;
    }

    public void setVictimsNumbers(int victimsNumbers) {
        this.victimsNumbers = victimsNumbers;
    }

    public boolean isMatherialDamageToTransportExceptAandB() {
        return matherialDamageToTransportExceptAandB;
    }

    public void setMatherialDamageToTransportExceptAandB(boolean matherialDamageToTransportExceptAandB) {
        this.matherialDamageToTransportExceptAandB = matherialDamageToTransportExceptAandB;
    }

    public boolean isMatherialDamagToDifferentThinks() {
        return matherialDamagToDifferentThinks;
    }

    public void setMatherialDamagToDifferentThinks(boolean matherialDamagToDifferentThinks) {
        this.matherialDamagToDifferentThinks = matherialDamagToDifferentThinks;
    }

    public String getWitnessesFullNameAndAdresses() {
        return witnessesFullNameAndAdresses;
    }

    public void setWitnessesFullNameAndAdresses(String witnessesFullNameAndAdresses) {
        this.witnessesFullNameAndAdresses = witnessesFullNameAndAdresses;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    public Car getFirstCar() {
        return firstCar;
    }

    public void setFirstCar(Car firstCar) {
        this.firstCar = firstCar;
    }

    public Car getSecondCar() {
        return secondCar;
    }

    public void setSecondCar(Car secondCar) {
        this.secondCar = secondCar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstUsersName() {
        return firstUsersName;
    }

    public void setFirstUsersName(String firstUsersName) {
        this.firstUsersName = firstUsersName;
    }

    public String getSecondUsersName() {
        return secondUsersName;
    }

    public void setSecondUsersName(String secondUsersName) {
        this.secondUsersName = secondUsersName;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Date getDateD() {
        return dateD;
    }

    public void setDateD(Date dateD) {
        this.dateD = dateD;
    }
}
