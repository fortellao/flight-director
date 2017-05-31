package net.sebix.flightdirector;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OptimalStageController {
    public final static double GRAV_ACC = 9.81;
    
    public void optimizeStage(BigDecimal engineISP, BigDecimal engineMass, BigDecimal payload) {
        
        
    }
    
    @RequestMapping(value="deltav", method=RequestMethod.GET)
    public double deltaV(@RequestParam("drymass") double dryMass,
            @RequestParam("isp") double engineISP,
            @RequestParam("fuel") double fuelMass) {
        
        return GRAV_ACC*engineISP*Math.log1p((dryMass+fuelMass)/dryMass);
    }
    
}
