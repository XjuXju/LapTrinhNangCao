package project.model;

public class Room {
	private String roomName;
	private String houseName;
	private String gender;
	private String quantity;
	private String status;
	private static Room room = null;
	public Room(String roomName, String houseName, String gender, String quantity, String status) {
		super();
		this.roomName = roomName;
		this.houseName = houseName;
		this.gender = gender;
		this.quantity = quantity;
		this.status = status;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static Room getInstance(){
		if(room == null){
			room = new Room("","","","","");
		}
		return room;
	}

}
