package org.mohaan;

import org.mohaan.model.Car;
import org.mohaan.service.DieselCar;
import org.mohaan.service.ElectricCar;
import org.mohaan.service.PetrolCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfiguration {

    @Bean
    @Primary
    public Car getElectricCar(
            @Autowired ElectricCar electricCar
    ) {
        return electricCar.getCarInfo();
    }

    @Bean
    public Car getPetrolCar(
            @Autowired PetrolCar petrolCar
    ) {
        return petrolCar.getCarInfo();
    }

    @Bean
    public Car getDieselCar(
            @Autowired DieselCar dieselCar
    ) {
        return dieselCar.getCarInfo();
    }
}
