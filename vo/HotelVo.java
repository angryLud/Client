package vo;

import po.HotelPo;
import java.util.Vector;
public class HotelVo extends Vector<String>{
public HotelVo(HotelPo hotelPo) {
	this.add(String.valueOf(hotelPo.getHotelID()));
	this.add(hotelPo.getPosition());
	this.add(hotelPo.getHotelName());
}

public HotelVo(int hotelID,String position,String hotelName){
	this.add(String.valueOf(hotelID));
	this.add(position);
	this.add(hotelName);
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
}
