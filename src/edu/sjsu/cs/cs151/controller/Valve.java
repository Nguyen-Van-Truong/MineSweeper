package edu.sjsu.cs.cs151.controller;

import edu.sjsu.cs.cs151.Message;

public interface Valve {

	/**
	 * Performs certain action in response to message
	 * 
	 * @param message
	 * @return
	 */
	public ValveResponse execute(Message message);
}
