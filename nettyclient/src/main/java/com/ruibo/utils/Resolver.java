package com.ruibo.utils;

public interface Resolver {
	public Message resolve(Message message);
	public boolean support(Message message);
}
