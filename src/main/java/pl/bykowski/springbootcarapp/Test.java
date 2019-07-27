package pl.bykowski.springbootcarapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bykowski.springbootcarapp.model.Car;
import pl.bykowski.springbootcarapp.model.CarType;
import pl.bykowski.springbootcarapp.repository.CarRepo;

import java.time.LocalDate;

@Component
public class Test {

    private CarRepo carRepo;

    @Autowired
    public Test(CarRepo carRepo) {
        this.carRepo = carRepo;
        Car car = new Car();
        car.setMark("Fiat");
        car.setModel("126p");
        car.setCarType(CarType.SEDAN);
        car.setProdYear(LocalDate.of(1995, 1, 1));
        carRepo.save(car);
    }







}
