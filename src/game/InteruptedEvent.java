package game;

public class InteruptedEvent extends GameAtribut{
	private String NameEvent;
	private Integer Chance;
	public InteruptedEvent(String timeDay, String description, String nameEvent, Integer chance) {
		super(timeDay, description);
		NameEvent = nameEvent;
		Chance = chance;
	}
	public String getNameEvent() {
		return NameEvent;
	}
	public void setNameEvent(String nameEvent) {
		NameEvent = nameEvent;
	}
	public Integer getChance() {
		return Chance;
	}
	public void setChance(Integer chance) {
		Chance = chance;
	}
	

}
