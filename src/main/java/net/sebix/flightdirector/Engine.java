package net.sebix.flightdirector;

public class Engine {
    private double mass;
    private double isp;

    public Engine(double mass, double isp) {
        this.mass = mass;
        this.isp = isp;
    }

    /**
     * @return the mass
     */
    public double getMass() {
        return mass;
    }

    /**
     * @param mass the mass to set
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * @return the isp
     */
    public double getIsp() {
        return isp;
    }

    /**
     * @param isp the isp to set
     */
    public void setIsp(double isp) {
        this.isp = isp;
    }
        
}
