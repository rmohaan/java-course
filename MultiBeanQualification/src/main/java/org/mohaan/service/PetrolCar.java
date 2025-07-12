package org.mohaan.service;

import org.mohaan.model.Car;
import org.springframework.stereotype.Component;

@Component
public class PetrolCar implements Car {
    public Car getCarInfo() {
        return new PetrolCar();
    }
}
