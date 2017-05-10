package project.model;

public class House {
	private String houseName;
	private String maleRoom;
	private String FemaleRoom;
	private String quantity;
	private static House house= null;
	public House(String houseName, String maleRoom, String femaleRoom, String quantity) {
		super();
		this.houseName = houseName;
		this.maleRoom = maleRoom;
		FemaleRoom = femaleRoom;
		this.quantity = quantity;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getMaleRoom() {
		return maleRoom;
	}
	public void setMaleRoom(String maleRoom) {
		this.maleRoom = maleRoom;
	}
	public String getFemaleRoom() {
		return FemaleRoom;
	}
	public void setFemaleRoom(String femaleRoom) {
		FemaleRoom = femaleRoom;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public static House getInstance(){
		if(house == null){
			house = new House("", "", "", "");
		}
		return house;
	}

}
