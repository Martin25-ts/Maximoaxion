package game;

public class Event extends GameAtribut{

	private String EventName,EventMessage,EventEffcrts;

	public Event(String timeDay, String description, String eventName, String eventMessage, String eventEffcrts) {
		super(timeDay, description);
		EventName = eventName;
		EventMessage = eventMessage;
		EventEffcrts = eventEffcrts;
	}

	public String getEventName() {
		return EventName;
	}

	public void setEventName(String eventName) {
		EventName = eventName;
	}

	public String getEventMessage() {
		return EventMessage;
	}

	public void setEventMessage(String eventMessage) {
		EventMessage = eventMessage;
	}

	public String getEventEffcrts() {
		return EventEffcrts;
	}

	public void setEventEffcrts(String eventEffcrts) {
		EventEffcrts = eventEffcrts;
	}
	
	

}
