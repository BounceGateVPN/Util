package com.github.smallru8.util.log;

public class Event {

	public static class LogEvent{
		public enum Type{
			INFO,ERROR,WARN
		}
		public String text;
		public LogEvent(Type t,String text) {
			if(t.equals(Type.INFO))
				this.text = "[INFO] ";
			else if(t.equals(Type.ERROR))
				this.text = "[ERROR] ";
			else
				this.text = "[WARN] ";
			this.text+=text;
		}
	}
	
}
