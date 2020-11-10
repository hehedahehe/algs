package com.ruibo.demo.statemachine.demo;

import com.ruibo.demo.statemachine.common.Events;
import com.ruibo.demo.statemachine.common.States;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;

import java.util.EnumSet;

public class SpringStateMachineDemo {


	public static void main(String[] args) throws Exception {
		StateMachine<States, Events> stateMachine = new SpringStateMachineDemo().buildMachine();
		stateMachine.start();
		stateMachine.sendEvent(Events.EVENT1);
		stateMachine.sendEvent(Events.EVENT2);
	}

	public StateMachine<States, Events> buildMachine() throws Exception {
		StateMachineBuilder.Builder<States, Events> builder = StateMachineBuilder.builder();

		builder.configureStates()
				.withStates()
				.initial(States.STATE1)
				.states(EnumSet.allOf(States.class));

		builder.configureTransitions()
				.withExternal()
				.source(States.STATE1).target(States.STATE2)
				.event(Events.EVENT1)
				.and()
				.withExternal()
				.source(States.STATE2).target(States.STATE1)
				.event(Events.EVENT2);

		return builder.build();
	}
}
