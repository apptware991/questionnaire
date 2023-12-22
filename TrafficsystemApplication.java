package com.example.trafficsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class TrafficsystemApplication implements ApplicationRunner {
	
	@Autowired
    private TrafficLight trafficLightService;


	public static void main(String[] args) {
		 System.out.println("Akarsh");
		SpringApplication.run(TrafficsystemApplication.class, args);
	}

	   @Autowired
	    private StateMachine<TrafficLightState, TrafficLightEvent> stateMachine;

	    public void run(ApplicationArguments args) throws Exception {
//	    	System.out.println("Inside run ");
//	        TrafficLight trafficLight = new TrafficLight(stateMachine);
//	        trafficLight.start();
	        System.out.println("In run method");
	    	trafficLightService.startTrafficLight();

	        // Simulate timer events triggering state transitions
	        trafficLightService.triggerTimerExpiredEvent();
	        trafficLightService.triggerTimerExpiredEvent();
	        trafficLightService.triggerTimerExpiredEvent();
	    }
}
