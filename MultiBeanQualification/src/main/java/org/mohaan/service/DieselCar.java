package org.mohaan.service;

import org.mohaan.model.Car;
import org.springframework.stereotype.Component;

@Component
public class DieselCar implements Car {

    public Car getCarInfo() {
        return new DieselCar();
    }
}
