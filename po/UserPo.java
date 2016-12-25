package po;

import java.io.Serializable;


public class UserPo implements Serializable{

    //id为4位整数，第一位是0
//	username为不超过10位字符
//	credit 为不超过4位的整数
//	birthday为8位纯数字字符串 如1996xxxx
//	phone位11位纯数字字符串
//	company位不超过6位字符串


    private int id;

    private String userName;

    private String birthday;

    private String phone;

    private int credit;

    private String company;

    private static final long serialVersionUID = 10L;

    public UserPo(){
        super();
    }

    public UserPo(int id,String userName,String birthday,String phone,
                  int credit,String company){
        super();
        this.id = id;
        this.userName = userName;
        this.birthday = birthday;
        this.phone = phone;
        this.credit = credit;
        this.company = company;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public int getCredit(){
        return credit;
    }

    public void setCredit(int credit){
        this.credit = credit;
    }

    public String getCompany(){
        return company;
    }

    public void setCompany(String company){
        this.company = company;
    }

}
