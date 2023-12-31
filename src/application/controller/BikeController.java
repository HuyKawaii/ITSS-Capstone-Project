package application.controller;

import application.dao.BikeDAO;
import application.entity.Bike;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.Random;

public class BikeController {
    private final BikeDAO dao;

    public BikeController() {
        this.dao = new BikeDAO();
    }
    
    public void updateBike(Bike bike) {
        dao.updateBike(bike);
    }

    public void generateBikeCode(Bike bike) {
        String code = generateRandomCode();
        
        while (bikeCodeExists(code)) {
            code = generateRandomCode();
        }
        
        bike.setBikeCode(code);
    }
    
    private String generateRandomCode() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
    
    private boolean bikeCodeExists(String code) {
        return dao.bikeCodeExists(code);
    }

    public void rentBike(Bike bike) {
        try {
            bike.setRentedTime(LocalDateTime.now());
            generateBikeCode(bike);
            updateBike(bike);  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void returnBike(Bike bike) {
        try {
            if (bike.getRentedTime() != null) {
                Duration duration = Duration.between(bike.getRentedTime(), LocalDateTime.now());
                float rentedDuration = (float) duration.toMinutes();
                bike.setRentingTime(rentedDuration);
                bike.setRentedTime(null);
                updateBike(bike);
            }
        } catch (Exception e) {
       
            e.printStackTrace();
        }
    }
}

