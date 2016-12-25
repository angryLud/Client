package vo;

import po.PromotionerPo;

public class PromotionerVo {
	
	private String name;
	
	private int id;
	
	public PromotionerVo(){
		super();
	}
	
	public PromotionerVo(PromotionerPo ppo){
		super();
		this.name = ppo.getName();
		this.id = ppo.getId();
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

}
