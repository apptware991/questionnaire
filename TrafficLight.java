package com.example.trafficsystem;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class TrafficLight {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(TrafficLight.class);
	
    private final StateMachine<TrafficLightState, TrafficLightEvent> stateMachine;

    public TrafficLight(StateMachine<TrafficLightState, TrafficLightEvent> stateMachine) {
        this.stateMachine = stateMachine;
    }

    
    
//    public void start() {
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//            	
//				logger.info("Running states");
//				System.out.println("Running state print");
//                stateMachine.sendEvent(TrafficLightEvent.TIMER);
//            }
//        }, 0, 5000); // 5000 milliseconds = 5 seconds
//    }
    
//    @Autowired
//    private StateMachine<TrafficLightState, TrafficLightEvent> stateMachine1;

    public void startTrafficLight() {
        // Trigger the initial state transition
    	System.out.println("Starting the traffic Light");
        stateMachine.start();
    }

    public void triggerTimerExpiredEvent() {
        // Simulate the timer expired event to transition to the next state
    	System.out.println("Triggering the event");
        stateMachine.sendEvent(TrafficLightEvent.TIMER);
    }
}



