package po;

import java.io.Serializable;

public class HotelPo implements Serializable{



	//hotelid 未4位整数 第一位是1
	// hotelname 为不超过10位字符串
	// 所有可用客房数量 不超过100
	//position  只有4中选择，见po.address
	// 所有房间价格不超过100

	// 星级只有12345

	// 评分为0～5之间浮点数
	// 评价不超过20为字符串
	// 描述不超过20为字符串
	
	private static final long serialVersionUID =20L;

	int hotelID;
	String position;
	String address;
	String hotelName;
	
	int avdachuangfang;
	
	int avshuangrenfang;
	int avsanrenjian;
	int dachuangfangprice;
	
	int shuangrenfangprice;
	int sanrenjianprice;
	int star;
	double score;
	String assess;
	String description;

	public HotelPo(){
		super();
	}
	public HotelPo(int hotelID,String address,String position,String hotelName,int dachuangfangprice,int shuangrenfangprice,int sanrenjianprice,int star,double score,String description){
		this.hotelID = hotelID;
		this.position = position;
		this.hotelName = hotelName;
		this.dachuangfangprice = dachuangfangprice;
		this.shuangrenfangprice = shuangrenfangprice;
		this.sanrenjianprice = sanrenjianprice;
		this.star = star;
		this.score = score;
		this.description = description;
		
	}
	
	public int getHotelID(){
		return this.hotelID;
	}
	
	public void setHotelID(int hotelID){
		this.hotelID = hotelID;
	}

	public String getPosition(){
		return this.position;
	}
	
	public void setPosition(String position){
		this.position = position;
	}
	
	public String getHotelName(){
		return this.hotelName;
	}
	
	public void setHotelName(String hotelName){
		this.hotelName = hotelName;
	}
	public int getAvdachuangfang() {
		return avdachuangfang;
	}
	public void setAvdachuangfang(int avdachuangfang) {
		this.avdachuangfang = avdachuangfang;
	}
	public int getAvshuangrenfang() {
		return avshuangrenfang;
	}
	public void setAvshuangrenfang(int avshuangrenfang) {
		this.avshuangrenfang = avshuangrenfang;
	}
	public int getAvsanrenjian() {
		return avsanrenjian;
	}
	public void setAvsanrenjian(int avsanrenjian) {
		this.avsanrenjian = avsanrenjian;
	}
	
	public int getDachaungfangprice() {
		return dachuangfangprice;
	}
	public int getShuangrenfangprice() {
		return shuangrenfangprice;
	}
	public int getSanrenjianprice() {
		return sanrenjianprice;
	}
	public int getStar(){
		return this.star;
	}
	public void setStar(int i){
		if(i>=1&&i<=5){
			star = i;
		}
	}
	public double getScore(){
		return this.score;
	}
	public void setScore(double score){
		this.score = score;
	}
	public String getAssess(){
		return this.assess;
	}
	public void setAssess(String assess){
		this.assess = assess;
	}
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}


}
