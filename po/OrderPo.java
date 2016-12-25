package po;

import java.io.Serializable;

/**
 * Created by huihantao on 2016/11/30.
 */
public class OrderPo implements Serializable {

    //id四位整数

    // 时间8位

    // 价格 不超过4位整数

    // 状态 0 未执行
    //     1 已执行
    //     2 异常
    //     3 已撤销


    // 折扣0～1 浮点数 小数点后2位
    // 评价不超过20位字符

    // 房间类型
    // 0:大床房
    // 1:双人房
    // 2:三人间


    private static final long serialVersionUID=40L;
    private int orderid;
    private int userid;
    private int hotelid;
    private long createtime;
    private long executetime;
    private long delaytime;
    private long endtime;
    private int value;
    private int status;

    private double discount;
    private String assess;
    private int score;
    private int roomstyle;
    private int roomnum;

    public OrderPo(int orderid,int userid, int hotelid, long createtime, long executetime, long delaytime ,long endtime, int value, int status,int roomstyle,int roomnum,String assess,double discount,int score) {
        this.orderid=orderid;
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
        this.assess = assess;
        this.discount=discount;
        this.score = score;
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
    public int getRoomstyle(){
        return roomstyle;
    }
    public void setRoomstyle(int roomstyle){
        this.roomstyle=roomstyle;
    }
    public int getRoomnum(){
        return roomnum;
    }
    public void setRoomnum(int roomnum){
        this.roomnum=roomnum;
    }

    public String toString (){
        return "'"+userid+"','"+hotelid+"','"+createtime+"','"+executetime+"','"+delaytime+"','"+endtime+"','"+value+"','"+status+"','"+roomnum+"','"+roomstyle+"','"+(assess==null?"":assess)+"','"+discount+"','"+score+"'";
    }

}