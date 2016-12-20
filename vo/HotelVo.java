package vo;

import po.HotelPo;
import java.util.Vector;
public class HotelVo extends Vector<String>{
	
public HotelVo(HotelPo hotelPo) {
	this.add(String.valueOf(hotelPo.getHotelID()));
	this.add(hotelPo.getPosition());
	this.add(hotelPo.getHotelName());
	this.add(String.valueOf(hotelPo.getRoomNums()));
	this.add(String.valueOf(hotelPo.getAvailableRoomNums()));
	this.add(String.valueOf(hotelPo.getPrices()));
	this.add(String.valueOf(hotelPo.getStar()));
	this.add(String.valueOf(hotelPo.getScore()));
	this.add(hotelPo.getAssess());
	this.add(hotelPo.getDescription());
	if(hotelPo.getReserved()){
	this.add("预订过.");
	}
	else{
		this.add("未订过.");
	}
}


	public HotelVo(String hotelname,String star,String mark,boolean reserved){
		this.add(hotelname);
		this.add(star);
		this.add(mark);
		if (reserved) this.add("预订过");
		else this.add("未订过");
	}


public int getHotelID(){
	return Integer.parseInt(this.get(0));
}

public String getPosition(){
	return this.get(1);
}

public String getHotelName(){
	return this.get(2);
}
public String getRoomNums(){
	return this.get(3);
}
public String getAvailableRoomNums(){
	return this.get(4);
}
public String getPrices(){
	return this.get(5);
}
public String getStar(){
	return this.get(6);
}
public String getScore(){
	return this.get(7);
}
public String getAssess(){
	return this.get(8);
}
public String getDescription(){
	return this.get(9);
}
public String getReserved(){
	return this.get(10);
}
}
