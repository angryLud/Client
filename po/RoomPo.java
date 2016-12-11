package po;

public class RoomPo {
	int hotelID;
	
	int roomNum;
	String roomCategory;
	String price;
	String usingCondition;
	String checkinTime;
	String supposedLeaveTime;
	String actualLeaveTime;
public RoomPo(){
	super();
}
public RoomPo(int hotelID,int roomNum,String roomCategory,String price,String usingCondition,String checkinTime,String supposedLeaveTime,String actualLeaveTime){
	this.hotelID = hotelID;
	this.roomNum = roomNum;
	this.roomCategory = roomCategory;
	this.price = price;
	this.usingCondition = usingCondition;
	this.checkinTime = checkinTime;
	this.supposedLeaveTime = supposedLeaveTime;
	this.actualLeaveTime = actualLeaveTime;
}
public int getHotelID(){
	return this.hotelID;
}

public int getRoomNum(){
	return this.roomNum;
}
public void setRoomNum(int roomNum){
	this.roomNum = roomNum;
}

public String getRoomCategory(){
	return this.roomCategory;
}
public void setRoomCategory(String roomCategory){
	this.roomCategory = roomCategory;
}
public String getPrice(){
	return this.price;
}
public void setPrice(String price){
	this.price = price;
}
public String getUsingCondition(){
	return this.usingCondition;
}
public void setUsingCondition(String usingCondition){
	this.usingCondition = usingCondition;
}
public String getCheckinTime(){
	return this.checkinTime;
}
public void setCheckinTime(String checkinTime){
	this.checkinTime = checkinTime;
}
public String getSupposedLeaveTime(){
	return this.supposedLeaveTime;
}
public void setSupposedLeaveTime(String supposedLeaveTime){
	this.supposedLeaveTime = supposedLeaveTime;
}
public String getActualLeaveTime(){
	return this.actualLeaveTime;
}
public void setActualLeaveTime(String actualLeaveTime){
	this.actualLeaveTime = actualLeaveTime;
}
}