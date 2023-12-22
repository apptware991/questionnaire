package com.example.trafficsystem;

import java.util.EnumSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigBuilder;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;


@Configuration
@EnableStateMachine
public class TrafficLightStateMachineConfig extends EnumStateMachineConfigurerAdapter<TrafficLightState, TrafficLightEvent> {

  

    @Override
    public void configure(StateMachineConfigurationConfigurer<TrafficLightState, TrafficLightEvent> config) throws Exception {
        config
            .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }
	
//    @Override
//    public void configure(StateMachineConfigBuilder<TrafficLightState, TrafficLightEvent> config) throws Exception {
//        config.configureConfiguration()
//                .withConfiguration()
//                .autoStartup(true)
//                .listener(listener());
//    }
	
    @Override
    public void configure(StateMachineStateConfigurer<TrafficLightState, TrafficLightEvent> states)
            throws Exception {
        states
            .withStates()
                .initial(TrafficLightState.RED) // Set the initial state here
                .states(EnumSet.allOf(TrafficLightState.class));
        System.out.println("Initial State Red");
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<TrafficLightState, TrafficLightEvent> transitions)
            throws Exception {
        transitions
            .withExternal()
                .source(TrafficLightState.RED).target(TrafficLightState.GREEN)
                .event(TrafficLightEvent.TIMER)
                .and()
            .withExternal()
                .source(TrafficLightState.GREEN).target(TrafficLightState.YELLOW)
                .event(TrafficLightEvent.TIMER)
                .and()
            .withExternal()
                .source(TrafficLightState.YELLOW).target(TrafficLightState.RED)
                .event(TrafficLightEvent.TIMER);
        System.out.println("Initialization of the state machine: State changed from one colour to another ");
    }



    @Bean
   public StateMachineListener<TrafficLightState, TrafficLightEvent> listener() {
        return new StateMachineListenerAdapter<>() {
            @Override
            public void stateChanged(State<TrafficLightState, TrafficLightEvent> from, State<TrafficLightState, TrafficLightEvent> to) {
                System.out.println("Transitioning from " + from.getId() + " to " + to.getId());
            }
        };
    }
}