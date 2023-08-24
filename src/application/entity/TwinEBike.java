package application.entity;

public class TwinEBike extends Bike {

    public TwinEBike() {
        super("TwinEBike");
    }

    @Override
    protected void setPrice() {
        this.price = 2 * 400000.0f; // Twice the price of a standard bike
    }

    @Override
    public String getBikeType() {
        return "TwinEBike";
    }

    @Override
    public String getAdditionalInfo() {
        return "This is a TwinEBike with integrated electric motors for assisting propulsion.";
    }
}
