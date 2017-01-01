package presentation.manageui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.ManageServiceImpl;
import businesslogicservice.ManageService;
import po.HotelPo;
import po.PromotionerPo;
import po.UserPo;

import presentation.controller.ManageViewControllerImpl;
import vo.HotelVo;
import vo.PromotionerVo;
import vo.UserVo;

public class ManageView extends JPanel{
	
//	public static void main(String args[]){
//		JFrame manageFrame = new JFrame();
//		manageFrame.setSize(800,600);
//		manageFrame.setLocation(300,100);
//		ManageViewControllerService controller = new ManageViewControllerImpl();
//		ManageView view = new ManageView(controller);
//		controller.setView(view);
//		manageFrame.setTitle("人员管理");
//		manageFrame.getContentPane().add(view);
//		manageFrame.setVisible(true);
//	}
	
	private int userID;
	
	private ManageViewControllerService controller;
	
	private JComboBox<String> userTypeCombobox;
	
	private JButton searchButton;
	
	private JButton returnButton;
	
	private JButton newMemberButton,newHotelButton;
	
	private JPanel userPanel;
	
	private JLabel userLabel;
	
	private JTextField userTextField;
	
	private JFrame searchFrame;
	
	private JPanel searchPanel;
	
	private JLabel searchLabel1,searchLabel2,searchLabel3,searchLabel4,searchLabel5,searchLabel6,searchLabel7,searchLabel8,searchLabel9,searchLabel_;
	
	private JTextField searchTextField1,searchTextField2,searchTextField3,searchTextField4,searchTextField5,searchTextField6,searchTextField7,searchTextField8,searchTextField9,searchTextField_;
	
	private JButton saveButton,cancleButton;
	
	private JFrame newMemberFrame;
	
	private JPanel newMemberPanel,newMemberPanel2;
	
	private JLabel newMemberLabel1,newMemberLabel2,newMemberLabel3,newMemberLabel4,newMemberLabel5,newMemberLabel6;
	
	private JTextField newMemberTextField1,newMemberTextField2,newMemberTextField3,newMemberTextField4,newMemberTextField5,newMemberTextField6;
	
	private JComboBox<String> newMemberCombobox;
	
	private JFrame newHotelFrame;
	
	private JLabel newHotelLabel1,newHotelLabel2,newHotelLabel_,newHotelLabel3,newHotelLabel4,newHotelLabel5,newHotelLabel6,newHotelLabel7,newHotelLabel8,newHotelLabel9;
	
	private JTextField newHotelTextField1,newHotelTextField2,newHotelTextField3,newHotelTextField_,newHotelTextField4,newHotelTextField5,newHotelTextField6,newHotelTextField7,newHotelTextField8,newHotelTextField9;
	
	private ManageService manageService;
	
	private HotelPo hotelPo;
	
	public ManageView(ManageViewControllerService controller){
		this.controller = controller;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//初始化页面
		initManageScene();
		
		this.validate();				
	}
	
	public void initManageScene(){
		
		userTypeCombobox = new JComboBox<String>();
		
		//用户类型列表
		List<String> list=new ArrayList<String>();
		list.add("类型");
		list.add("用户");
		list.add("酒店");
		
		//初始化combobox
		for(String str : list){
			userTypeCombobox.addItem(str);
		}
		
		//设置选择事件
		userTypeCombobox.addItemListener(new ItemListener(){
			
			public void itemStateChanged(ItemEvent evt){
				
				if(evt.getStateChange() == ItemEvent.SELECTED){
					
					String selected=(String)userTypeCombobox.getSelectedItem();
					
					controller.updateScene(selected);
				}
			}
		});
		
		JPanel userTypeJpanel = new JPanel();
		userTypeJpanel.setLayout(null);
		JLabel userTypeLabel = new JLabel("类型");
		userTypeLabel.setFont(new Font("宋体",Font.BOLD,20));
		userTypeCombobox.setFont(new Font("宋体",Font.BOLD,20));
		userTypeLabel.setBounds(50, 60, 100, 30);
		userTypeCombobox.setBounds(150, 60,100,30);
		userTypeJpanel.add(userTypeLabel);
		userTypeJpanel.add(userTypeCombobox);
		
		userLabel = new JLabel("请输入ID");
		userTextField = new JTextField(20);
		
		userLabel.setFont(new Font("宋体",Font.BOLD,20));
		userTextField.setFont(new Font("宋体",Font.BOLD,20));
		userLabel.setBounds(100, 200, 100, 30);
		userTextField.setBounds(300,200, 200, 30);
		userTypeJpanel.add(userLabel);
		userTypeJpanel.add(userTextField);
		
		searchButton = new JButton("查询（修改）信息");
		//添加按钮监听事件
		searchButton.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent arg0) {
						
				//界面跳转
				controller.searchButtonClicked();
			}
		});
		
		newMemberButton = new JButton("添加网络营销人员");
		//添加按钮监听事件
		newMemberButton.addActionListener(new ActionListener() {
									
			public void actionPerformed(ActionEvent arg0) {
										
				//界面跳转
				controller.newMemberButtonClicked();
			}
		});
		
		newHotelButton = new JButton("添加酒店及工作人员");
		//添加按钮监听事件
		newHotelButton.addActionListener(new ActionListener() {
											
			public void actionPerformed(ActionEvent arg0) {
												
				//界面跳转
				controller.newHotelButtonClicked();
			}
		});
		
		returnButton = new JButton("注销");
		returnButton.setBounds(680,10,100,50);
        returnButton.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,30));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.back( );
            }
        });
		
		searchButton.setFont(new Font("宋体",Font.BOLD,20));
		newMemberButton.setFont(new Font("宋体",Font.BOLD,20));
		newHotelButton.setFont(new Font("宋体",Font.BOLD,20));
		searchButton.setBounds(20, 400, 220,50);
		newMemberButton.setBounds(260, 400, 220,50);
		newHotelButton.setBounds(500, 400, 260,50);
		userTypeJpanel.add(searchButton);
		userTypeJpanel.add(newMemberButton);
		userTypeJpanel.add(newHotelButton);
		userTypeJpanel.add(returnButton);
				
		searchButton.setEnabled(false);
		newMemberButton.setEnabled(false);
		newHotelButton.setEnabled(false);
		
		this.add(userTypeJpanel);
		
	}
	
	/**
	 * 类型改变后更改数据源
	 */
	public void updateScene(String selected){
		if(selected == "用户"){
			searchButton.setEnabled(true);
			newMemberButton.setEnabled(true);
			newHotelButton.setEnabled(false);
		}else if(selected == "酒店"){
			searchButton.setEnabled(true);
			newMemberButton.setEnabled(false);
			newHotelButton.setEnabled(true);
		}
	}
	
	/**
	 * 打开查询修改信息界面
	 */
	public void searchButtonClicked(){
		searchFrame = new JFrame();
		searchFrame.setSize(600, 300);
		searchFrame.setLocation(400, 150);
		searchFrame.setTitle("查询（修改）信息");
		
		int id = Integer.valueOf(userTextField.getText());
		manageService = new ManageServiceImpl();
		
		searchPanel = new JPanel();
		searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT));		
		
		saveButton = new JButton("保存");
		//保存信息修改
		saveButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				//事件处理
				if(saveUser()){
					searchFrame.dispose();
				}
			}
		});
		cancleButton = new JButton("取消");
		//取消查询修改处理
		cancleButton.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e) {
						//关闭窗口
				searchFrame.dispose();
						
			}
		});
		
		if(id>2999&&id<4000){
			searchLabel1 = new JLabel("姓名");
			searchLabel2 = new JLabel("ID");
			PromotionerVo pvo = manageService.uploadPromotioner(id);
			searchTextField1 = new JTextField(20);
			searchTextField1.setText(pvo.getName());
			searchTextField2 = new JTextField(20);
			searchTextField2.setText(String.valueOf(pvo.getId()));
			searchTextField2.setEditable(false);
			
			JPanel searchPanel1 = new JPanel();
			searchPanel1.setLayout(new GridLayout(3,2));
			searchPanel = new JPanel();
			searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			searchPanel1.add(searchLabel1);
			searchPanel1.add(searchTextField1);
			searchPanel1.add(searchLabel2);
			searchPanel1.add(searchTextField2);
			searchPanel1.add(saveButton);
			searchPanel1.add(cancleButton);
			searchPanel.add(searchPanel1);
		}else if(id>1999&&id<3000){
			hotelPo = manageService.uploadHotel(id);
			HotelVo hotelVo = new HotelVo(hotelPo);
			searchLabel2 = new JLabel("ID");
			searchLabel1 = new JLabel("酒店名称");
			searchLabel3 = new JLabel("酒店地址");
			searchLabel_ = new JLabel("酒店商圈");
			searchLabel4 = new JLabel("酒店星级");
			searchLabel5 = new JLabel("酒店描述");
			searchLabel6 = new JLabel("评分");
//			searchLabel7 = new JLabel("大床房价格");
//			searchLabel8 = new JLabel("双人间价格");
//			searchLabel9 = new JLabel("三人间价格");
			searchTextField2 = new JTextField(20);
			searchTextField2.setText(String.valueOf(hotelVo.getHotelID()));
			searchTextField1 = new JTextField(20);
			searchTextField1.setText(hotelVo.getHotelName());
			searchTextField3 = new JTextField(20);
			searchTextField3.setText(hotelVo.getAddress());
			searchTextField_ = new JTextField(20);
			searchTextField_.setText(hotelVo.getPosition());
			searchTextField4 = new JTextField(20);
			searchTextField4.setText(hotelVo.getStar());
			searchTextField5 = new JTextField(20);
			searchTextField5.setText(hotelVo.getDescription());
			searchTextField6 = new JTextField(20);
			searchTextField6.setText(hotelVo.getScore());
//			searchTextField7 = new JTextField(20);
//			searchTextField7.setText();
//			searchTextField8 = new JTextField(20);
//			searchTextField8.setText();
//			searchTextField9 = new JTextField(20);
//			searchTextField9.setText();
			searchTextField2.setEditable(false);
			searchTextField6.setEditable(false);
			
			JPanel searchPanel1 = new JPanel();
			searchPanel1.setLayout(new GridLayout(8,2));
			searchPanel = new JPanel();
			searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			searchPanel1.add(searchLabel1);
			searchPanel1.add(searchTextField1);
			searchPanel1.add(searchLabel2);
			searchPanel1.add(searchTextField2);
			searchPanel1.add(searchLabel3);
			searchPanel1.add(searchTextField3);
			searchPanel1.add(searchLabel_);
			searchPanel1.add(searchTextField_);
			searchPanel1.add(searchLabel4);
			searchPanel1.add(searchTextField4);
			searchPanel1.add(searchLabel5);
			searchPanel1.add(searchTextField5);
			searchPanel1.add(searchLabel6);
			searchPanel1.add(searchTextField6);
			searchPanel1.add(saveButton);
			searchPanel1.add(cancleButton);
			searchPanel.add(searchPanel1);
		}else if(id>999&&id<2000){
			UserVo userVo = manageService.uploadUser(id);
			searchLabel1 = new JLabel("姓名");
			searchLabel2 = new JLabel("ID");
			searchLabel3 = new JLabel("生日");
			searchLabel4 = new JLabel("手机号码");
			searchLabel5 = new JLabel("信用");
			searchLabel6 = new JLabel("公司");
			
			searchTextField1 = new JTextField(20);
			searchTextField1.setText(userVo.getUserName());
			searchTextField2 = new JTextField(20);
			searchTextField2.setText(String.valueOf(userVo.getId()));
			searchTextField3 = new JTextField(20);
			searchTextField3.setText(userVo.getBirthday());
			searchTextField4 = new JTextField(20);
			searchTextField4.setText(userVo.getPhone());
			searchTextField5 = new JTextField(20);
			searchTextField5.setText(String.valueOf(userVo.getCredit()));
			searchTextField6 = new JTextField(20);
			searchTextField6.setText(userVo.getCompany());
			searchTextField2.setEditable(false);
			searchTextField5.setEditable(false);
			
			JPanel searchPanel1 = new JPanel();
			searchPanel1.setLayout(new GridLayout(7,2));
			searchPanel = new JPanel();
			searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			searchPanel1.add(searchLabel1);
			searchPanel1.add(searchTextField1);
			searchPanel1.add(searchLabel2);
			searchPanel1.add(searchTextField2);
			searchPanel1.add(searchLabel3);
			searchPanel1.add(searchTextField3);
			searchPanel1.add(searchLabel4);
			searchPanel1.add(searchTextField4);
			searchPanel1.add(searchLabel5);
			searchPanel1.add(searchTextField5);
			searchPanel1.add(searchLabel6);
			searchPanel1.add(searchTextField6);
			searchPanel1.add(saveButton);
			searchPanel1.add(cancleButton);
			searchPanel.add(searchPanel1);
		}

		searchFrame.getContentPane().add(searchPanel);
		searchFrame.setVisible(true);
	}
	
	/**
	 * 打开添加新人员界面
	 */
	public void newMemberButtonClicked(){
		newMemberFrame = new JFrame();
		newMemberFrame.setSize(500, 150);
		newMemberFrame.setLocation(400, 200);
		newMemberFrame.setTitle("添加网络营销人员");
		
		newMemberPanel = new JPanel();
		newMemberPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		newMemberLabel1 = new JLabel("姓名");
		newMemberLabel2 = new JLabel("密码");
//		newMemberLabel3 = new JLabel("生日");
//		newMemberLabel4 = new JLabel("手机号码");
//		newMemberLabel5 = new JLabel("信用");
//		newMemberLabel6 = new JLabel("公司");
//		newMemberCombobox = new JComboBox<String>();
//		
//		List<String> list=new ArrayList<String>();
//		list.add("客户");
//		list.add("酒店工作人员");
//		list.add("网站营销人员");
		
//		for(String str : list){
//			newMemberCombobox.addItem(str);
//		}
//				
//		newMemberCombobox.addItemListener(new ItemListener(){
//					
//			public void itemStateChanged(ItemEvent evt){
//						
//				if(evt.getStateChange() == ItemEvent.SELECTED){
//							
//					String selected=(String)newMemberCombobox.getSelectedItem();
//				}
//			}
//		});
		
		newMemberTextField1 = new JTextField(20);
		newMemberTextField2 = new JTextField(20);
//		newMemberTextField3 = new JTextField(20);
//		newMemberTextField4 = new JTextField(20);
//		newMemberTextField5 = new JTextField(20);
//		newMemberTextField6 = new JTextField(20);
		saveButton = new JButton("保存");
		//保存信息
        saveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				 if(newUser()){
					 newMemberFrame.dispose();
				 }
			}
		});
		cancleButton = new JButton("取消");
		//取消添加新人员处理
		cancleButton.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e) {
				//关闭窗口
				newMemberFrame.dispose();
						
			}
		});
		
		newMemberPanel = new JPanel();
		newMemberPanel2 = new JPanel();
		newMemberPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		newMemberPanel2.setLayout(new GridLayout(3,2));
		newMemberPanel2.add(newMemberLabel1);
		newMemberPanel2.add(newMemberTextField1);
		newMemberPanel2.add(newMemberLabel2);
		newMemberPanel2.add(newMemberTextField2);
//		newMemberPanel2.add(newMemberLabel3);
//		newMemberPanel2.add(newMemberTextField3);
//		newMemberPanel2.add(newMemberLabel4);
//		newMemberPanel2.add(newMemberTextField4);
//		newMemberPanel2.add(newMemberLabel5);
//		newMemberPanel2.add(newMemberTextField5);
//		newMemberPanel2.add(newMemberLabel6);
//		newMemberPanel2.add(newMemberTextField6);
		newMemberPanel2.add(saveButton);
		newMemberPanel2.add(cancleButton);
		newMemberPanel.add(newMemberPanel2);
		
		newMemberFrame.getContentPane().add(newMemberPanel);
		newMemberFrame.setVisible(true);
	}
	
	/**
	 * 打开新增酒店界面
	 */
	public void newHotelButtonClicked(){
		newHotelFrame = new JFrame();
		newHotelFrame.setSize(600, 350);
		newHotelFrame.setLocation(400, 200);
		newHotelFrame.setTitle("添加酒店及工作人员");
		
		newHotelLabel1 = new JLabel("密码");
		newHotelLabel2 = new JLabel("酒店名称");
		newHotelLabel3 = new JLabel("酒店地址");
		newHotelLabel_ = new JLabel("酒店商圈");
		newHotelLabel4 = new JLabel("酒店星级");
		newHotelLabel5 = new JLabel("酒店描述");
		newHotelLabel6 = new JLabel("评分");
		newHotelLabel7 = new JLabel("大床房价格");
		newHotelLabel8 = new JLabel("双人间价格");
		newHotelLabel9 = new JLabel("三人间价格");
		newHotelTextField1 = new JTextField(20);
		newHotelTextField2 = new JTextField(20);
		newHotelTextField3 = new JTextField(20);
		newHotelTextField_ = new JTextField(20);
		newHotelTextField4 = new JTextField(20);
		newHotelTextField5 = new JTextField(20);
		newHotelTextField6 = new JTextField(20);
		newHotelTextField7 = new JTextField(20);
		newHotelTextField8 = new JTextField(20);
		newHotelTextField9 = new JTextField(20);
		saveButton = new JButton("保存");
		saveButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				
				if(saveHotel()){
					newHotelFrame.dispose();
				}
			}
		});
		cancleButton = new JButton("取消");
		cancleButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				newHotelFrame.dispose();
			}
		});
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(11,2));
		panel2.add(newHotelLabel2);
		panel2.add(newHotelTextField2);
		panel2.add(newHotelLabel1);
		panel2.add(newHotelTextField1);
		panel2.add(newHotelLabel3);
		panel2.add(newHotelTextField3);
		panel2.add(newHotelLabel_);
		panel2.add(newHotelTextField_);
		panel2.add(newHotelLabel4);
		panel2.add(newHotelTextField4);
		panel2.add(newHotelLabel5);
		panel2.add(newHotelTextField5);
		panel2.add(newHotelLabel6);
		panel2.add(newHotelTextField6);
		panel2.add(newHotelLabel7);
		panel2.add(newHotelTextField7);
		panel2.add(newHotelLabel8);
		panel2.add(newHotelTextField8);
		panel2.add(newHotelLabel9);
		panel2.add(newHotelTextField9);
		panel2.add(saveButton);
		panel2.add(cancleButton);
		panel1.add(panel2);
		
		newHotelFrame.getContentPane().add(panel1);
		newHotelFrame.setVisible(true);
	}
	
	/**
	 * 保存按钮点击事件
	 */
	private boolean saveUser(){
		int id = Integer.valueOf(searchTextField2.getText());
		String userName = searchTextField1.getText();
		manageService = new ManageServiceImpl();
		if(id>2999&&id<4000){
			PromotionerPo ppo = new PromotionerPo(id,userName);
			if(manageService.changePromotionerInfo(ppo)){
				return true;
			}
		}else if(id>1999&&id<3000){
			String position = searchTextField_.getText();
			String address = searchTextField3.getText();
			int star = Integer.valueOf(searchTextField4.getText());
			String description = searchTextField5.getText();
			HotelPo hpo = new HotelPo(hotelPo.getHotelID(),address,position,userName,hotelPo.getDachaungfangprice(),hotelPo.getShuangrenfangprice(),hotelPo.getSanrenjianprice(),star,hotelPo.getScore(),description);
			if(manageService.changeHotelInfo(hpo)){
				return true;
			}
		}
		else{
			String birthday = searchTextField3.getText();
			String phone = searchTextField4.getText();
			int credit = Integer.valueOf(searchTextField5.getText());
			String company = searchTextField6.getText();
			UserPo userPo = new UserPo(id,userName,birthday,phone,credit,company);
			if(manageService.changeUserInfo(userPo)){
				return true;
			}
		}
		return false;
	}
	
	private boolean saveHotel(){
		int id = 0;
		String password = newHotelTextField1.getText();
		String hotelName = newHotelTextField2.getText();
		String hotelAddress = newHotelTextField3.getText();
		String position = newHotelTextField_.getText();
		int dachuangfangprice = Integer.valueOf(newHotelTextField7.getText());
		int shuangrenfangprice =Integer.valueOf(newHotelTextField8.getText());
		int sanrenjianprice =Integer.valueOf(newHotelTextField9.getText());
		int star =Integer.valueOf(newHotelTextField4.getText());
		double score =Double.valueOf(newHotelTextField6.getText());
		String description = newHotelTextField5.getText();
		HotelPo hotelPo = new HotelPo(id,hotelAddress,position,hotelName,dachuangfangprice,shuangrenfangprice,
				sanrenjianprice,star,score,description);

		manageService = new ManageServiceImpl();
		id = manageService.addHotel(hotelPo,password);
		if(id!=0){
			JOptionPane.showMessageDialog(null,"酒店id为"+id);
			return true;
		}

		return false;

	}
	
	public boolean newUser(){
		int id = 0;
		String userName = newMemberTextField1.getText();
		String password = newMemberTextField2.getText();
//		String birthday = newMemberTextField3.getText();
//		String phone = newMemberTextField4.getText();
//		int credit = Integer.valueOf(newMemberTextField5.getText());
//		String company = newMemberTextField6.getText();
		PromotionerPo pPo = new PromotionerPo(id,userName);
		manageService = new ManageServiceImpl();
		id = manageService.addUser(pPo,password);
		if(id>2999){
			JOptionPane.showMessageDialog(null,"网络营销人员id为"+id);
			return true;
		}
		return false;	
	}

}
