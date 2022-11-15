package com.asherbakov.hwRacing.transport;

import com.asherbakov.hwRacing.drivers.Driver;
import com.asherbakov.hwRacing.mechanics.Mechanic;
import com.asherbakov.hwRacing.sponsors.Sponsor;

import java.util.*;

public abstract class Transport {

    private String brand;
    private String model;
    private double engineVolume;
    private final Set<Sponsor<?>> sponsors = new HashSet<>();
    private final Set<Driver<?>> drivers = new HashSet<>();
    private final Set<Mechanic<?>> mechanics = new HashSet<>();

    protected final String EMPTY_STRING_VALUE = "параметр не задан";

    public Transport(String brand, String model, double engineVolume) {
        this.brand = brand.isBlank() ? EMPTY_STRING_VALUE : brand;
        this.model = model.isBlank() ? EMPTY_STRING_VALUE : model;
        setEngineVolume(engineVolume);
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            this.engineVolume = 1.2;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public void addSponsor(Sponsor<?>... sponsors) {
        if (sponsors.length > 0) {
            this.sponsors.addAll(Arrays.asList(sponsors));
        } else {
            throw new IllegalArgumentException("Попытка добавить не существующего спонсора");
        }
    }

    public void addDriver(Driver<?> driver) {
        if (driver!= null) {
            drivers.add(driver);
        } else {
            throw new NullPointerException("Попытка добавить не существующего водителя");
        }
    }

    public void addMechanic(Mechanic<?>... mechanics) {
        if (mechanics.length > 0) {
            this.mechanics.addAll(Arrays.asList(mechanics));
        } else {
            throw new IllegalArgumentException("Попытка добавить не существующего механика");
        }
    }


    public Set<Sponsor<?>> getSponsors() {
        return sponsors;
    }

    public Set<Driver<?>> getDrivers() {
        return drivers;
    }

    public Set<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

//    protected void passDiagnostics(Transport transport) {
//        System.out.printf("%s %s проходит диагностику.", transport.getBrand(), transport.getModel());
//    }

    public abstract boolean passDiagnostics();

    public abstract void repair();

    public abstract void startMoving();

    public abstract void stopMoving();

}
