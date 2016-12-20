package po;

public class HotelPo {
	int hotelID;
	String position;
	String hotelName;
	int[] roomNums;
	int[] availableRoomNums;
	int[] prices;
	int star;
	double score;
	String assess;
	String description;
	
	public HotelPo(){
		super();
	}
	public HotelPo(int hotelID,String position,String hotelName){
		this.hotelID = hotelID;
		this.position = position;
		this.hotelName = hotelName;
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
	public int[] getRoomNums(){
		return this.roomNums;
	}
	public int[] getAvailableRoomNums(){
		return this.availableRoomNums;
	}
	public int getRoomNum(int i){
		if(i>=0&&i<=2){
		return this.roomNums[i];
		}
		return 0;
	}
	public void setRoomNum(int i,int num){
		if(i>=0&&i<=2){
			roomNums[i]=num;
		}
	}
	public int getAvailableRoomNum(int i){
		if(i>=0&&i<=2){
			return availableRoomNums[i];
		}
		return 0;
	}
	public void setAvailableRoomNum(int i,int num){
		if(i>=0&&i<=2){
			availableRoomNums[i] = num;
		}
	}
	public int getPrice(int i){
		if(i>=0&&i<=2){
			return prices[i];
		}
		return 0;
	}
	public void setPrice(int i,int price){
		if(i>=0&&i<=2){
			prices[i] = price;
		}
	}
	public int[] getPrices(){
		return this.prices;
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
