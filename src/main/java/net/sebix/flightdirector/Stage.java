package net.sebix.flightdirector;

import com.fasterxml.jackson.annotation.JsonIgnore;
import static net.sebix.flightdirector.OptimalStageController.GRAV_ACC;

public class Stage {
    private double payload;
    private double fuelMass;
    @JsonIgnore
    private Engine engine;
    private static final double FUEL_OVERHEAD_FACTOR = 1/9;

    public Stage(double payload, double fuelMass, Engine engine) {
        this.payload = payload;
        this.fuelMass = fuelMass;
        this.engine = engine;
    }
    
    public double getTankMass(){
        return getFuelMass()*(1+ FUEL_OVERHEAD_FACTOR);
    }
    
    public double getDryMass() {
        return payload + engine.getMass() + getTankMass();
    }
    
    public double getDeltaV() {
        return GRAV_ACC*engine.getIsp()*Math.log1p((getDryMass()+fuelMass)/getDryMass());
    }

    /**
     * @return the payload
     */
    public double getPayload() {
        return payload;
    }

    /**
     * @param payload the payload to set
     */
    public void setPayload(double payload) {
        this.payload = payload;
    }

    /**
     * @return the fuelMass
     */
    public double getFuelMass() {
        return fuelMass;
    }

    /**
     * @param fuelMass the fuelMass to set
     */
    public void setFuelMass(double fuelMass) {
        this.fuelMass = fuelMass;
    }

    /**
     * @return the engine
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * @param engine the engine to set
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
