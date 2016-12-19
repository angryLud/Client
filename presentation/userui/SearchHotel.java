package presentation.userui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import presentation.controller.SearchHotelControllerimpl;
import presentation.controller.UserSearchOrderCotrollerimpl;
import vo.HotelVo;
import vo.OrderVo;



public class SearchHotel extends JPanel{
	private JTextField textField;
	private JLabel label1;
	private int userId;
	private SearchHotelController searchHotelCon;
	private Vector<HotelVo> vData;
	private Vector<String> vColumns;
	private JTable hotelTable;
	private DefaultTableModel hotelListModel;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JButton button_1;
	private JButton button2;
	private JButton exitbutton;
	


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
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"排序"}));
		comboBox_2.setBounds(216, 40, 70, 21);
		comboBox_2.addItem("评分");
		comboBox_2.addItem("星级");
		this.add(comboBox_2);
		//限定
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"限定"}));
		comboBox_3.setBounds(296, 40, 70, 21);
		comboBox_3.addItem("住过");
		comboBox_3.addItem("未住过");
		this.add(comboBox_3);
		
		JLabel label_7 = new JLabel("搜索:");
		label_7.setBounds(380, 43, 36, 15);
		this.add(label_7);
		
		textField = new JTextField();
		textField.setBounds(410, 40, 102, 21);
		this.add(textField);
		textField.setColumns(10);

		button_1 = new JButton("搜索");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s1 = (String)comboBox.getSelectedItem();
				String s2 = (String)comboBox_1.getSelectedItem();
				String s3 = (String)comboBox_2.getSelectedItem();
				String s4 = (String)comboBox_3.getSelectedItem();
				searchHotelCon.usersearchhotel(s1,s2,s3,s4);
			}
		});
		button_1.setBounds(520, 40, 93, 23);
		this.add(button_1);
		
		scrollPane = new JScrollPane();
		
		        //表头
				vColumns = new Vector<String>();
				vColumns.add("酒店名称");
				vColumns.add("星级");
				vColumns.add("评分");
				vColumns.add("是否预定过");
				//数据
				vData=new Vector<>();
		Vector<HotelVo> x=new Vector<>();
		x.add(new HotelVo(2,"saf","卧槽 "));
				//模型
                hotelListModel = new DefaultTableModel(x, vColumns);
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
				
				
			
				
				button2 = new JButton("生成订单");
				button2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

					}
				});
				this.add(button2);
				button2.setBounds(56, 284, 100, 30);
	}
	
//生成订单按钮实现
//	class button2Listener implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//
//		}
//
//		}


		public void createtable(Vector<HotelVo> vData){
			this.remove(scrollPane);
			scrollPane = new JScrollPane();

			//表头
//			vColumns = new Vector<String>();
//			vColumns.add("酒店名称");
//			vColumns.add("星级");
//			vColumns.add("评分");
//			vColumns.add("是否预定过");
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

	}

