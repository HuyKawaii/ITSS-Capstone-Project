package application.entity;

public class BikeFactory {

    public Bike createBike(String bikeType) {
        switch (bikeType) {
            case "EBike":
                return new EBike();
            case "TwinBike":
                return new TwinBike();
            case "TwinEBike": 
                return new TwinEBike();
            default:
                return new Bike(bikeType);  
        }
    }
}

