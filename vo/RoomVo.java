package vo;
import po.RoomPo;
import java.util.*;
public class RoomVo extends Vector<String>{
public RoomVo(RoomPo roomPo){
	this.addElement(String.valueOf(roomPo.getHotelID()));
	this.addElement(String.valueOf(roomPo.getRoomNum()));
	this.addElement(roomPo.getRoomCategory());
	this.addElement(roomPo.getPrice()+"元/晚");
	this.addElement(roomPo.getUsingCondition());
	this.addElement(roomPo.getCheckinTime());
	this.addElement(roomPo.getSupposedLeaveTime());
	this.addElement(roomPo.getActualLeaveTime());
}
public RoomVo(int hotelID,int roomNum,String roomCategory,String price,String usingCondition,String checkinTime,String supposedLeaveTime,String actualLeaveTime){
	this.addElement(String.valueOf(hotelID));
	this.addElement(String.valueOf(roomNum));
	this.addElement(roomCategory);
	this.addElement(price+"元/晚");
	this.addElement(usingCondition);
	this.addElement(checkinTime);
	this.addElement(supposedLeaveTime);
	this.addElement(actualLeaveTime);
}

public String getHotelID(){
	return this.get(0);
}
public String getRoomNum(){
	return this.get(1);
}


public String getRoomCategory(){
	return this.get(2);
}

public String getPrice(){
	return this.get(3);
}

public String getUsingCondition(){
	return this.get(4);
}

public String getCheckinTime(){
	return this.get(5);
}

public String getSupposedLeaveTime(){
	return this.get(6);
}

public String getActualLeaveTime(){
	return this.get(7);
}

}