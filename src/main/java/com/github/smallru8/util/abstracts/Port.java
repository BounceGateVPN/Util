package com.github.smallru8.util.abstracts;

public abstract class Port {

	public enum DeviceType{
		WS,TunTap,virtualRouter,virtualSwitch
	}
	
	public DeviceType type;//為WebSocket / TunTap / virtualSwitch / virtualRouter
	
	/**
	 * Device to switch/router
	 * @param data
	 */
	public abstract void sendToVirtualDevice(byte[] data);
	
	/**
	 * Switch/Router to device
	 * @param data
	 */
	public abstract void sendToDevice(byte[] data);
	
}