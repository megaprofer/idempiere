package org.alquimiasoft.logger.util;

public class Chronometer {
	
	private long initTime;
	private long endTime;
	
	public Chronometer() {
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		this.initTime = System.currentTimeMillis();
	}
	
	public void stop() {
		this.endTime = System.currentTimeMillis();
	}
	
	public long getTotalTime() {
		return this.endTime - this.initTime;
	}
	

}
