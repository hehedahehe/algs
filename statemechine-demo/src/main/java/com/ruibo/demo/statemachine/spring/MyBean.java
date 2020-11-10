package com.ruibo.demo.statemachine.spring;


import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class MyBean {

	@OnTransition(target = "STATE1")
	void toState1() {
	}

	@OnTransition(target = "STATE2")
	void toState2() {
	}
}
