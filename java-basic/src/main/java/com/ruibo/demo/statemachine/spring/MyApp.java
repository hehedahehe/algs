package com.ruibo.demo.statemachine.spring;

import com.ruibo.demo.statemachine.common.Events;
import com.ruibo.demo.statemachine.common.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;

public class MyApp {

	@Autowired
	StateMachine<States, Events> stateMachine;

	void doSignals() {
		stateMachine.start();
		stateMachine.sendEvent(Events.EVENT1);
		stateMachine.sendEvent(Events.EVENT2);
	}
}
