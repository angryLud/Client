package po;

import java.io.Serializable;

/**
 * Created by huihantao on 2016/11/30.
 */
public class OrderPo implements Serializable {
    private static final long serialVersionUID=3L;
    private int orderid;
    private int userid;
    private int hotelid;
    private long createtime;
    private long executetime;
    private long delaytime;
    private long endtime;
    private int value;
    private int status;
    
    private int roomNum;
    private double discount;
    private String assess;
	private String roomstyle;
	private int roomnum;

    public OrderPo(int userid, int hotelid, long createtime, long executetime, long delaytime ,long endtime, int value, int status,String roomstyle,int roomnum) {
        this.createtime = createtime;
        this.executetime = executetime;
        this.delaytime = delaytime;
        this.endtime = endtime;
        this.userid = userid;
        this.hotelid = hotelid;
        this.value = value;
        this.status = status;
        this.roomstyle = roomstyle;
        this.roomnum = roomnum;
    }


    public long getCreatetime() {
        return createtime;
    }
    public void setCreatetime(long createtime){
    	this.createtime = createtime;
    }
    public long getExecutetime() {
        return executetime;
    }
    public void setExecutetime(long executetime){
    	this.executetime = executetime;
    }
    public long getDelaytime() {
        return delaytime;
    }
    public void setDelaytime(long delaytime){
    	this.delaytime = delaytime;
    }
    public int getUserid() {
        return userid;
    }

    public int getHotelid() {
        return hotelid;
    }

    public int getOrderid() {
        return orderid;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value){
    	this.value = value;
    }
    public long getEndtime() {
        return endtime;
    }
    public void setEndtime(long endtime){
    	this.endtime = endtime;
    }
//    public int getStrategyNum(){
//    	return strategyNum;
//    }
//    public void setStrategyNum(int strategyNum){
//    	this.strategyNum = strategyNum;
//    }
    public int getStatus(){
    	return status;
    }
    public void setStatus(int status){
    	this.status = status;
    }
    public double getDiscount(){
    	return discount;
    }
    public void setDiscount(double discount){
    	this.discount = discount;
    }
    public String getAssess(){
    	return assess;
    }
    public void setAssess(String assess){
    	this.assess=assess;
    	}
    public String getRoomstyle(){
    	return roomstyle;
    }
    public void setRoomstyle(String roomstyle){
    	this.roomstyle=roomstyle;
    	}
    public int getRoomnum(){
    	return roomnum;
    }
    public void setRoomnum(int roomnum){
    	this.roomnum=roomnum;
    	}

}