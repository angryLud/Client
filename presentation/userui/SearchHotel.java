package presentation.userui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import presentation.controller.SearchHotelControllerimpl;
import presentation.controller.UserSearchOrderCotrollerimpl;
import vo.HotelVo;
import vo.OrderVo;



public class SearchHotel extends JPanel{
	private JFrame ReserveHotel;
	private JFrame Hotelinformation;
	private JTextField textField;
	private JLabel label1;
	private int orderId;
	private int userId;
	private int hotelId;
	private SearchHotelController searchHotelCon;
	private Vector<HotelVo> vData;
	private Vector<String> vColumns;
	private JTable hotelTable;
	private DefaultTableModel hotelListModel;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_3;
	private JButton button_1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton exitbutton;
	private Vector<HotelVo> hotellist;
	


	public SearchHotel(SearchHotelController searchHotelCon) {
		// TODO Auto-generated constructor stub
		this.searchHotelCon = searchHotelCon;
		this.userId = searchHotelCon.getUserID();
		this.setLayout(null);
		this.go();
	}


//	public static void main(String[] args){
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(800,600);
//		SearchHotel gui = new SearchHotel(new SearchHotelControllerimpl());
//		frame.getContentPane().add(gui);
//		frame.setVisible(true);
//	}
	private void go() {
		// TODO Auto-generated method stub
		label1 = new JLabel("个人信息管理     当前身份：客户");
		this.add(label1);
		label1.setBounds(0,0,200,27);
		exitbutton = new JButton("返回");
		exitbutton.setBounds(680, 0, 100, 30);
		exitbutton.addActionListener(new exitbuttonListener());
		this.add(exitbutton);
		//商圈
		comboBox = new JComboBox();
		comboBox.setBounds(56, 40, 70, 21);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"商圈"}));
		comboBox.addItem("新街口");
		this.add(comboBox);
		//地址ַ
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"地址"}));
		comboBox_1.setBounds(136, 40, 70, 21);
		comboBox_1.addItem("南京");
		this.add(comboBox_1);
		//排序
		button4 = new JButton("排序");
		button4.setBounds(296, 40, 70, 21);
		button4.addActionListener(new ActionListener(){
			@Override//按照评分和星级排序
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RowSorter sorter = new TableRowSorter(hotelListModel);
				hotelTable.setRowSorter(sorter);
				}		
		});
		this.add(button4);
		//限定
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"限定"}));
		comboBox_3.setBounds(216, 40, 70, 21);
		comboBox_3.addItem("预订过");
		comboBox_3.addItem("未订过");
		this.add(comboBox_3);
		
		textField = new JTextField("名称/星级");
		textField.setBounds(410, 40, 102, 21);
		this.add(textField);
		textField.setColumns(10);

		
		scrollPane = new JScrollPane();
		
		 //表头
		vColumns = new Vector<String>();
		vColumns.add("酒店ID");
		vColumns.add("酒店名称");
		vColumns.add("商圈");
		vColumns.add("地址");
		vColumns.add("星级");
		vColumns.add("评分");
		vColumns.add("是否预定过");
		//数据
		hotellist=new Vector<>();

		hotellist.addAll(searchHotelCon.getAllHotels(userId));
		//模型
        hotelListModel = new DefaultTableModel(hotellist, vColumns);
		//表格
		hotelTable = new JTable(hotelListModel){
		   public boolean isCellEditable(int row, int column){
						return false;
					}
				};
				hotelTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//				scrollPane.getViewport().add(hotelTable);
				scrollPane.setViewportView(hotelTable);
				scrollPane.setBounds(56,74,400,200);
				this.add(scrollPane);
				hotelTable.setFillsViewportHeight(true);
				hotelTable.setBounds(56, 74, 400, 200);
				hotelTable.setSize( 400, 200);
				hotelTable.setBackground(Color.LIGHT_GRAY);
//		hotelTable.add(scrollPane);
				
				//搜索按钮的实现（不包括排序）
				button_1 = new JButton("搜索");
				button_1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String s1 = (String)comboBox.getSelectedItem();//商圈
						String s2 = (String)comboBox_1.getSelectedItem();//地址
						String s3 = (String)comboBox_3.getSelectedItem();//限定是否预定过
						if(s1=="商圈"||s2=="地址"){
							JFrame frame = new JFrame();
							frame.setLayout(null);
							JLabel label = new JLabel("请选择地址或商圈!");
							frame.add(label);
							label.setBounds(20, 10, 150, 30);
							frame.setSize(160, 100);
							frame.setVisible(true);
						}else if(s3=="限定"){//没有限定直接搜索特定地址和商圈
							Vector<Vector<String>> volist=new Vector<Vector<String>>();
							for(int i=0;i<hotellist.size();i++){
								if(hotellist.get(i).get(2).equals(s1)&&hotellist.get(i).get(3).equals(s2)){
									volist.add(hotellist.get(i));
								}
							}
							 hotelTable.setModel(new DefaultTableModel(volist,vColumns));
						}else{//有地址和商圈限定，还有是否预定过的限定
							Vector<Vector<String>> volist=new Vector<Vector<String>>();
							String text = textField.getText();
							boolean isNum = Pattern.matches("^\\d+$", text);//"^\\d+$"
							for(int i=0;i<hotellist.size();i++){
								if(isNum==true){
								if(hotellist.get(i).get(2).equals(s1)&&hotellist.get(i).get(3).equals(s2)&&hotellist.get(i).get(6).equals(s3)&&hotellist.get(i).get(4).equals(text)){
									volist.add(hotellist.get(i));
								}
								}else if(text.matches("[\\u4e00-\\u9fa5]+")){
									if(hotellist.get(i).get(2).equals(s1)&&hotellist.get(i).get(3).equals(s2)&&hotellist.get(i).get(6).equals(s3)&&hotellist.get(i).get(1).equals(text)){
										volist.add(hotellist.get(i));
									}
								}
							}
							 hotelTable.setModel(new DefaultTableModel(volist,vColumns));
						}
					}
				});
				button_1.setBounds(520, 40, 93, 23);
				this.add(button_1);				
			
//生成订单按钮的实现			
		button2 = new JButton("生成订单");
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						searchHotelCon.reservehotel();
					}
				});
	    this.add(button2);
		button2.setBounds(56, 284, 100, 30);
//查看酒店详细信息按钮的实现
		button3 = new JButton("查看酒店详细信息");
		button3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = hotelTable.getSelectedRow();
				if(index==-1){
					JFrame frame = new JFrame();
					frame.setLayout(null);
					JLabel label = new JLabel("请选择酒店!");
					frame.add(label);
					label.setBounds(20, 10, 100, 30);
					frame.setSize(100, 100);
					frame.setVisible(true);
				}else
				searchHotelCon.hotelinformation(index+1);
			}
			
		});
		this.add(button3);
		button3.setBounds(170, 284, 150, 30);
	}
	

		public void createtable(Vector<HotelVo> vData){
			this.remove(scrollPane);
			scrollPane = new JScrollPane();

			//数据
			//模型
			hotelListModel = new DefaultTableModel(vData, vColumns);
			//表格
			hotelTable = new JTable(hotelListModel){

				public boolean isCellEditable(int row, int column){
					return false;
				}
			};
			hotelTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//				scrollPane.getViewport().add(hotelTable);
			scrollPane.setViewportView(hotelTable);
			scrollPane.setBounds(56,74,400,200);

			hotelTable.setFillsViewportHeight(true);
			hotelTable.setBounds(56, 74, 400, 200);
			hotelTable.setSize( 400, 200);
			hotelTable.setEnabled(true);
			hotelTable.setBackground(Color.LIGHT_GRAY);
			this.add(scrollPane);
		}

	public String toString( )
	{
		return "ri";
	}
	//返回按钮实现
	class exitbuttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			searchHotelCon.ExitButtonClicked();
		}
		
	}
	//生成订单的界面填写订单信息
	public void reservehotel() {
		// TODO Auto-generated method stub
		ReserveHotel = new JFrame();
		ReserveHotel.setLayout(null);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
		
		label1 = new JLabel("个人信息管理     当前身份：客户 ");
		ReserveHotel.add(label1);
		label1.setBounds(0,0,200,27);
		
		
        String[] s1 = {"大床房","双人房","三人间"};
        final JComboBox combo1 = new JComboBox(s1);
        combo1.setBorder(BorderFactory.createTitledBorder("房间类型"));
        String[] s2 = {"1","2","3","4","5"};
        final JComboBox combo2 = new JComboBox(s2);
        combo2.setBorder(BorderFactory.createTitledBorder("房间数量"));
        String[] s3 = {"1","2","3","4","5"};
        final JComboBox combo3 = new JComboBox(s3);
        combo3.setBorder(BorderFactory.createTitledBorder("预定人数"));
        String[] s4 = {"是","否"};
        final JComboBox combo4 = new JComboBox(s4);
        combo4.setBorder(BorderFactory.createTitledBorder("是否有小孩"));
        JLabel label2 = new JLabel("预定日期：(xx/xx)");
        final JTextField textfield1 = new JTextField();
        textfield1.setColumns(10);
        JLabel label3 = new JLabel("退房日期：(xx/xx)");
        final JTextField textfield2 = new JTextField();
        textfield2.setColumns(10);
        JLabel label4 = new JLabel("最晚订单执行时间：(xx/xx hh/hh)");
        final JTextField textfield3 = new JTextField();
        textfield3.setColumns(10);
        JLabel label5 = new JLabel("预定信息:");
        JButton button1 = new JButton("预定");
        button1.addActionListener(new ActionListener(){
        		public void actionPerformed(ActionEvent e) {
        			// TODO Auto-generated method stub
        			if(searchHotelCon.getcredit()>=0){
        				JFrame frame1 = new JFrame();
        				frame1.setSize(200,200);
        				frame1.setVisible(true);
        				
        				String s1 = (String )combo1.getSelectedItem();
        				int s2 = combo2.getSelectedIndex();
        				int s3 = combo3.getSelectedIndex();
        				String s4 = (String )combo4.getSelectedItem();
        				String s5 = textfield1.getText();
        				long executetime = Integer.parseInt(s5);
        				String s6 = textfield2.getText();
        				long endtime = Integer.parseInt(s6);
        				String s7 = textfield3.getText();
        				long delaytime = Integer.parseInt(s7);
        				SimpleDateFormat df = new SimpleDateFormat("MMddHHmm");
        				String nowtime = df.format(new Date());
        				int intnowtime = Integer.parseInt(nowtime);
        				int status = 1;//1表示未执行订单
        				int i1 = 0;
        				if(s1=="大床房"){
        					i1 = 0;
        				}if(s1=="双人房"){
        					i1 = 1;
        				}if(s1=="三人间"){
        					i1 = 2;
        				}
        				
        				int value=searchHotelCon.createorder(orderId,userId,hotelId,intnowtime,executetime,delaytime,endtime,status,i1+"",s2);
        				JLabel label1 = new JLabel("预定成功,价格为 "+value);
        				frame1.add(label1);
        			}else if(searchHotelCon.getcredit()<0){
        				JFrame frame1 = new JFrame();
        				frame1.setSize(100,100);
        				frame1.setVisible(true);
        				JLabel label1 = new JLabel("预定失败，信用值不够");
        				frame1.add(label1);
        			}		
        		}
        });
        panel2.add(label5);
        panel2.add(combo1);
        panel2.add(combo2);
        panel2.add(combo3);
        panel2.add(combo4);
        panel2.add(label2);
        panel2.add(textfield1);
        panel2.add(label3);
        panel2.add(textfield2);
        panel2.add(label4);
        panel2.add(textfield3);
        panel2.add(button1);
        ReserveHotel.add(panel2);
        panel2.setBounds(20, 40, 225, 400);
        
        JLabel label6 = new JLabel("客户信息");
        label6.setFont(new Font("宋体", Font.PLAIN, 15));
        JLabel label7 = new JLabel("姓名："+searchHotelCon.getname());
        label7.setFont(new Font("宋体", Font.PLAIN, 15));
        JLabel label8 = new JLabel("联系方式：110");
        label8.setFont(new Font("宋体", Font.PLAIN, 15));
        JLabel label9 = new JLabel("ID："+userId);
        label9.setFont(new Font("宋体", Font.PLAIN, 15));
        JLabel label10 = new JLabel("信用值："+searchHotelCon.getcredit()+""); 
        label10.setFont(new Font("宋体", Font.PLAIN, 15));
        panel1.add(label6);
        panel1.add(label7);
        panel1.add(label8);
        panel1.add(label9);
        panel1.add(label10);
        ReserveHotel.add(panel1);
        panel1.setBounds(300, 100, 530, 277);
        ReserveHotel.setSize(500, 500);
        ReserveHotel.setVisible(true);
    	
	}


	public void hotelinformation(int hotelid) {
		// TODO Auto-generated method stub
		Hotelinformation = new JFrame();
		Hotelinformation.setLayout(null);
		JPanel panelinfor = new JPanel();
		Hotelinformation.add(panelinfor);
		panelinfor.setBounds(30, 30, 300, 400);
		
		JButton button = new JButton("生成订单");
		Hotelinformation.add(button);
		button.setBounds(30, 450, 100, 30);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				searchHotelCon.reservehotel();
			}
			
		});
		
		Hotelinformation.setSize(800, 600);
		Hotelinformation.setVisible(true);
		
	}
}

	

