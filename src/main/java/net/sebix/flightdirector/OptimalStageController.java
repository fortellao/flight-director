package net.sebix.flightdirector;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OptimalStageController {
    public final static double GRAV_ACC = 9.81;
    public final static double STEP = 0.5;
    public final static int ITERATIONS = 50;
    
    @RequestMapping(value="staging", method=RequestMethod.GET)
    public List<Stage> optimizeStage(@RequestParam("isp") double engineISP,
            @RequestParam("enginemass") double engineMass,
            @RequestParam("payload") double payload) {
        
        Engine engine = new Engine(engineMass, engineISP);
        List<Stage> stageSetups = new ArrayList<>();
        for(int i=0; i < ITERATIONS; i++) {
            stageSetups.add(new Stage(payload, (i+1)*STEP, engine));
        }
        return stageSetups;
    }
    
    @RequestMapping(value="deltav", method=RequestMethod.GET)
    public double deltaV(@RequestParam("drymass") double dryMass,
            @RequestParam("isp") double engineISP,
            @RequestParam("fuel") double fuelMass) {
        
        return GRAV_ACC*engineISP*Math.log1p((dryMass+fuelMass)/dryMass);
    }
    
}
