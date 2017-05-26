/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sebix.flightdirector;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dasch
 */
@RestController
public class HelloWorldController {
    
    @RequestMapping("/helloworld")
    public String helloWorld() {
        return "hello world";
    }
}
