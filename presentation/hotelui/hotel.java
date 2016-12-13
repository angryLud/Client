package presentation.hotelui;


import java.awt.*;

import java.awt.event.*;

import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dataservice.*;

import businesslogic.*;
import businesslogicservice.*;
import presentation.hotelui.hotelController;

import po.OrderPo;
import po.RoomPo;
import vo.OrderVo;
import vo.RoomVo;
public class hotel extends JPanel{
	
	private hotelController controller;
	
	private int hotelID;
	
	private orderdataservice orderservice;
	
//	private OrderService blorderservice;

private JFrame frame;
private JFrame strategyAddFrame;
private JFrame creditChangeFrame;


private JButton modifyButton;
private JButton confirmButton;
private JButton manageButton;
private JButton inputButton;
private JButton strategyButton;
private JButton manageRoomButton;
private JButton searchButton;
private JButton executeButton;
private JButton exitButton;
private JButton inputRoomButton;
private JButton deleteRoomButton;
private JButton strategyConfirmButton;
private JButton strategyAddButton;
private JButton manageModifyButton;
private JButton manageConfirmButton;
private JButton orderBrowseButton;
private JButton orderSearchButton;
private JButton executeConfirmButton;
private JButton executingButton;
private JButton executeCreditButton;

private JTextArea area;


private JTextField strategyField1;
private JComboBox strategyBox;
private JTextField strategyAddField;
private JTextField executeField1;
private JTextField executeField2;
private JTextField executeField3;

private JLabel mainlabel;
private JLabel label;
private JLabel label1;
private JLabel label2;
private JLabel label3;
private JLabel label4;
private JLabel label5;

private JLabel strategyLabel1;
private JLabel strategyLabel2;
private JLabel strategyLabel3;

private JLabel executeLabel1;
private JLabel executeLabel2;
private JLabel executeLabel3;

private JPanel serviceTypeJpanel;
private JPanel textJpanel;
private JPanel inputButtonJpanel;
private JPanel strategyJpanel;
private JPanel manageButtonJpanel;
private JPanel searchButtonJpanel;
private JPanel executeJpanel;

private JTable roomTable;
private JTable manageRoomTable;
private JTable searchOrderTable;
private JTable executeOrderTable;

private Vector<String> vColumns;
private Vector<String> manageColumns;
private Vector<String> searchColumns;
private Vector<String> executeColumns;
private Vector<RoomVo> vData;
private Vector<RoomVo> manageData;
private Vector<OrderVo> searchData;
private Vector<OrderVo> executeData;
private Vector<String> options;

private DefaultTableModel roomModel;
private DefaultTableModel manageRoomModel;
private DefaultTableModel searchOrderModel;
private DefaultTableModel executeOrderModel;

private JScrollPane scrollPane;



//public HotelFrame(HotelFrameControllerService controller){
//	this.controller = controller;
//	this.hotelID = controller.getHotelID();
//	//初始化组件
//	initComponents();
//	//初始化主界面
//	initMainFrame();
//}


//初始化组件
public void initComponents(){
    
	
	frame=new JFrame();
	
	mainlabel = new JLabel();
	mainlabel.setFont(new Font("serif",Font.BOLD,20));
	mainlabel.setText("当前身份：酒店工作人员");
	
	label = new JLabel();
	label.setFont(new Font("serif",Font.BOLD,20));
	label.setText("  管理酒店信息                                                  当前身份：酒店工作人员");
	
	label1 = new JLabel();
	label1.setFont(new Font("serif",Font.BOLD,20));
	label1.setText("  录入可用客房                                                    当前身份：酒店工作人员");
	
	label2 = new JLabel();
	label2.setFont(new Font("serif",Font.BOLD,20));
	label2.setText("  制定促销策略                                                    当前身份：酒店工作人员");
	
	label3 = new JLabel();
	label3.setFont(new Font("serif",Font.BOLD,20));
	label3.setText("  管理客房状况                                                    当前身份：酒店工作人员");
	
	label4 = new JLabel();
	label4.setFont(new Font("serif",Font.BOLD,20));
	label4.setText("  查询订单                                                            当前身份：酒店工作人员");
	
	label5 = new JLabel();
	label5.setFont(new Font("serif",Font.BOLD,20));
	label5.setText("  执行订单                                                            当前身份：酒店工作人员");
	
	strategyLabel1 = new JLabel();
	strategyLabel1.setText("输入订单号");
	
	strategyLabel2 = new JLabel();
	strategyLabel2.setText("选择促销策略");
	
	strategyLabel3 = new JLabel();
	strategyLabel3.setText("输入促销策略");
	
	executeLabel1 = new JLabel("输入订单号");
	executeLabel2 = new JLabel("输入用户ID");
	executeLabel3 = new JLabel("输入信用值");
	
	confirmButton = new JButton("确定");
	modifyButton = new JButton("修改");
	
	manageButton = new JButton("管理酒店信息");
	inputButton = new JButton("可用客房");
	strategyButton = new JButton("制定促销策略");
	manageRoomButton = new JButton("管理客房状况");
	searchButton = new JButton("查询订单");
	executeButton = new JButton("执行订单");
	exitButton = new JButton("返回");
	
	inputRoomButton = new JButton("录入");
	deleteRoomButton = new JButton("删除");
	strategyConfirmButton = new JButton("确定");
	strategyAddButton = new JButton("添加促销策略");
	manageModifyButton = new JButton("管理");
	manageConfirmButton = new JButton("确定");
	orderBrowseButton = new JButton("浏览");
	orderSearchButton = new JButton("查询");
	executeConfirmButton = new JButton("确定");
	executingButton = new JButton("执行");
	executeCreditButton = new JButton("信用更改");
	
	area = new JTextArea(8,30);
	strategyField1 = new JTextField(20);
	executeField1 = new JTextField(20);
	executeField2 = new JTextField(20);
	executeField3 = new JTextField(20);
	options = new Vector<String>();
	options.add("0.95");
	options.add("0.9");
	options.add("0.8");
	strategyBox = new JComboBox(options);
	
	
	
	textJpanel = new JPanel();
	serviceTypeJpanel = new JPanel();
	inputButtonJpanel = new JPanel();
	strategyJpanel = new JPanel();
	manageButtonJpanel = new JPanel();
	searchButtonJpanel = new JPanel();
	executeJpanel = new JPanel();
	
	vColumns = new Vector<String>();
	vColumns.add("酒店id");
	vColumns.add("房间号");
	vColumns.add("房间类型");
	vColumns.add("价格");
	vColumns.add("使用情况");
	vColumns.add("入住时间");
	vColumns.add("预计离开时间");
	vColumns.add("实际离开时间");
	
	vData = new Vector<RoomVo>();
	RoomPo roomPo = new RoomPo(1,316,"大床房","198","使用中","20161213","20161221","201211111");
	RoomVo roomVo = new RoomVo(roomPo);
	vData.add(roomVo);
	
	manageColumns = new Vector<String>();
	manageColumns.add("酒店id");
	manageColumns.add("房间号");
	manageColumns.add("房间类型");
	manageColumns.add("价格");
	manageColumns.add("使用情况");
	manageColumns.add("入住时间");
	manageColumns.add("预计离开时间");
	manageColumns.add("实际离开时间");
	
	manageData = new Vector<RoomVo>();
	RoomPo roomPo2 = new RoomPo(1,316,"大床房","198","使用中","20161213","20161221","201211111");
	RoomVo roomVo2 = new RoomVo(roomPo2);
	manageData.add(roomVo2);
	
	searchColumns = new Vector<String>();
	searchColumns.add("订单号");
	searchColumns.add("房间号");
	searchColumns.add("酒店id");
	searchColumns.add("创建时间");
	searchColumns.add("执行时间");
	searchColumns.add("延迟时间");
	searchColumns.add("入住时间");
	searchColumns.add("价格");
	searchColumns.add("执行情况");
	
	searchData = new Vector<OrderVo>();
	OrderPo orderPo = new OrderPo(1,2,3,20161203,20161205,20161205,2,198,1);
	OrderVo orderVo = new OrderVo(orderPo);
	searchData.add(orderVo);
	
	executeColumns = new Vector<String>();
	executeColumns.add("订单号");
	executeColumns.add("房间号");
	executeColumns.add("酒店id");
	executeColumns.add("创建时间");
	executeColumns.add("执行时间");
	executeColumns.add("延迟时间");
	executeColumns.add("入住时间");
	executeColumns.add("价格");
	executeColumns.add("执行情况");
	
	executeData = new Vector<OrderVo>();
	OrderPo orderPo2 = new OrderPo(1,2,3,20161203,20161205,20161205,2,198,1);
	OrderVo orderVo2 = new OrderVo(orderPo2);
	executeData.add(orderVo2);
	
	scrollPane = new JScrollPane();
}



//初始化主界面
private void initMainFrame(){
	
	        //���ܼ�
			
			serviceTypeJpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			
			manageButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					ManageButtonClicked();
				}
			});
			
			inputButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					InputButtonClicked();
				}
			});
			
		    strategyButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					StrategyButtonClicked();
				}
			});
			
			manageRoomButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					ManageRoomButtonClicked();
				}
			});
			
			searchButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					SearchButtonClicked();
				}
			});
			
			executeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					ExecuteButtonClicked();
				}
			});
			exitButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					ExitButtonClicked();
				}
			});
			serviceTypeJpanel.add(manageButton);
//			serviceTypeJpanel.add(inputButton);
			serviceTypeJpanel.add(strategyButton);
			serviceTypeJpanel.add(manageRoomButton);
			serviceTypeJpanel.add(searchButton);
			
			JLabel templabel1 = new JLabel("                                                       ");
			serviceTypeJpanel.add(templabel1);
			
			serviceTypeJpanel.add(exitButton);
			
			
//			serviceTypeJpanel.add(executeButton);
			
			
			
			
			
			//���岼��
			
			
			frame.setBounds(600,300,750,600);
			frame.setResizable(true);
			frame.getContentPane().add(BorderLayout.NORTH,mainlabel);
			mainlabel.setVisible(true);
			frame.getContentPane().add(serviceTypeJpanel);
			frame.setVisible(true);
			
			
			

}

public void ManageButtonClicked(){
	
	
	//界面内容
	
	area.setFont(new Font("serif",Font.BOLD,20));
	area.setText("商圈：XXXX\n");
	area.append("地址：XXXXX\n");
	area.append("服务设施：停车场丶wifi等\n");
	area.append("房间价格：XXXXX\n");
	area.setEditable(false);
	textJpanel.add(area);
	
	modifyButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			ModifyButtonClicked();
			
		}
	
	});
	
	confirmButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			ConfirmButtonClicked();
			
		}
		
	});
	textJpanel.add(modifyButton);
	textJpanel.add(confirmButton);
	
	//���沼��
	frame.repaint();
	mainlabel.setVisible(false);
	label.setVisible(true);
	label1.setVisible(false);
	label2.setVisible(false);
	label3.setVisible(false);
	label4.setVisible(false);
	label5.setVisible(false);
		
	frame.getContentPane().add(BorderLayout.NORTH,label);
	serviceTypeJpanel.remove(scrollPane);
	serviceTypeJpanel.remove(executeJpanel);
    serviceTypeJpanel.remove(manageButtonJpanel);
    serviceTypeJpanel.remove(searchButtonJpanel);
    serviceTypeJpanel.remove(strategyJpanel);
    serviceTypeJpanel.remove(inputButtonJpanel);
	serviceTypeJpanel.add(textJpanel);
	textJpanel.setVisible(true);
	
}

public void InputButtonClicked(){
	        //��ͷ
	
			
			
	        //���
			
			//ģ��
			roomModel = new DefaultTableModel(vData, vColumns);
			//���
			roomTable = new JTable(roomModel){
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column){
					return false;
				}
			};
			roomTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.getViewport().add(roomTable);
			roomTable.setFillsViewportHeight(true);
			
	        inputButtonJpanel.add(inputRoomButton);
	        inputButtonJpanel.add(deleteRoomButton);
	
	//���沼��
	frame.repaint();
	mainlabel.setVisible(false);
	label.setVisible(false);
	label1.setVisible(true);
	label2.setVisible(false);
	label3.setVisible(false);
	label4.setVisible(false);
	label5.setVisible(false);
	
	frame.getContentPane().add(BorderLayout.NORTH,label1);
	
    
    inputRoomButton.addActionListener(new ActionListener(){
    
		@Override
		public void actionPerformed(ActionEvent e) {
			InputRoomButtonClicked();
			
		}
    	
    });
    deleteRoomButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			DeleteRoomButtonClicked();
			
		}
    
    });
    serviceTypeJpanel.add(scrollPane);
    serviceTypeJpanel.add(inputButtonJpanel);
    serviceTypeJpanel.remove(executeJpanel);
    serviceTypeJpanel.remove(manageButtonJpanel);
    serviceTypeJpanel.remove(searchButtonJpanel);
    serviceTypeJpanel.remove(strategyJpanel);
    serviceTypeJpanel.remove(textJpanel);
    scrollPane.setVisible(true);
	inputButtonJpanel.setVisible(true);
	
}




public void StrategyButtonClicked(){
	   strategyJpanel.add(strategyLabel1);
	   strategyJpanel.add(strategyField1);
	   strategyJpanel.add(strategyLabel2);
	   strategyJpanel.add(strategyBox);
	   strategyJpanel.add(strategyConfirmButton);
	   strategyConfirmButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			StrategyConfirmButtonClicked();
			
		}
		   
	   });
	   strategyJpanel.add(strategyAddButton);
	   strategyAddButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			StrategyAddButtonClicked();
			
		}
		   
	   });
	//���沼��
	    frame.repaint();
	    mainlabel.setVisible(false);
		label.setVisible(false);
		label1.setVisible(false);
		label2.setVisible(true);
		label3.setVisible(false);
		label4.setVisible(false);
		label5.setVisible(false);
		frame.getContentPane().add(BorderLayout.NORTH,label2);
		serviceTypeJpanel.add(strategyJpanel);
		serviceTypeJpanel.remove(scrollPane);
	    serviceTypeJpanel.remove(inputButtonJpanel);
	    serviceTypeJpanel.remove(executeJpanel);
	    serviceTypeJpanel.remove(manageButtonJpanel);
	    serviceTypeJpanel.remove(searchButtonJpanel);
	    serviceTypeJpanel.remove(textJpanel);
	    strategyJpanel.setVisible(false);
	    strategyJpanel.setVisible(true);
}

public void ManageRoomButtonClicked(){
    //��ͷ
	
			
			
	        //���
			
			//ģ��
			manageRoomModel = new DefaultTableModel(manageData, manageColumns);
			//���
			manageRoomTable = new JTable(manageRoomModel){
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column){
					return true;
				}
			};
			manageRoomTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.getViewport().add(manageRoomTable);
			manageRoomTable.setFillsViewportHeight(true);
	        manageRoomTable.setEnabled(false);
	        
	        manageButtonJpanel.add(manageModifyButton);
	        manageModifyButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					manageRoomTable.setEnabled(true);
					
				}
	        	
	        });
	        manageButtonJpanel.add(inputButton);
//	        manageConfirmButton.addActionListener(new ActionListener(){
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					manageRoomTable.setEnabled(false);
//					
//				}
//	        	
//	        });
	//���沼��
	    frame.repaint();
	    mainlabel.setVisible(false);
		label.setVisible(false);
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(true);
		label4.setVisible(false);
		label5.setVisible(false);
		frame.getContentPane().add(BorderLayout.NORTH,label3);
		serviceTypeJpanel.add(scrollPane);
		serviceTypeJpanel.add(manageButtonJpanel);
	    serviceTypeJpanel.remove(inputButtonJpanel);
	    serviceTypeJpanel.remove(executeJpanel);
	    serviceTypeJpanel.remove(searchButtonJpanel);
	    serviceTypeJpanel.remove(strategyJpanel);
	    serviceTypeJpanel.remove(textJpanel);
}

public void SearchButtonClicked(){
	//��ͷ
	
	
	
    //���
	
	//ģ��
	searchOrderModel = new DefaultTableModel(searchData, searchColumns);
	//���
	searchOrderTable = new JTable(searchOrderModel){
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column){
			return false;
		}
	};
	searchOrderTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	scrollPane.getViewport().add(searchOrderTable);
	searchOrderTable.setFillsViewportHeight(true);
	
	searchButtonJpanel.add(orderBrowseButton);
	orderBrowseButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			OrderBrowseButtonClicked();
			
		}
		
	});
	searchButtonJpanel.add(orderSearchButton);
	orderSearchButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			OrderSearchButtonClicked();
			
		}
		
	});
	searchButtonJpanel.add(executeButton);
	//���沼��
	    frame.repaint();
	    mainlabel.setVisible(false);
		label.setVisible(false);
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(true);
		label5.setVisible(false);
		frame.getContentPane().add(BorderLayout.NORTH,label4);
		serviceTypeJpanel.add(scrollPane);
		serviceTypeJpanel.add(searchButtonJpanel);
	    serviceTypeJpanel.remove(inputButtonJpanel);
	    serviceTypeJpanel.remove(executeJpanel);
	    serviceTypeJpanel.remove(manageButtonJpanel);
	    serviceTypeJpanel.remove(strategyJpanel);
	    serviceTypeJpanel.remove(textJpanel);
}

public void ExecuteButtonClicked(){
	    
	    
	//ģ��
		executeOrderModel = new DefaultTableModel(executeData, executeColumns);
		//���
		executeOrderTable = new JTable(executeOrderModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		executeOrderTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.getViewport().add(executeOrderTable);
		executeOrderTable.setFillsViewportHeight(true);
	
	
	    executeJpanel.add(executeLabel1);
	    executeJpanel.add(executeField1);
//	    executeJpanel.add(executeConfirmButton);
//	    executeConfirmButton.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				controller.ExecuteConfirmButtonClicked();
//				
//			}
//	    	
//	    });
	    executeJpanel.add(executingButton);
	    executingButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ExecutingButtonClicked();
				
			}
	    	
	    });
	    
	    
	
	//���沼��
	    frame.repaint();
	    mainlabel.setVisible(false);
		label.setVisible(false);
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		label5.setVisible(true);
		frame.getContentPane().add(BorderLayout.NORTH,label5);
		serviceTypeJpanel.add(executeJpanel);
		serviceTypeJpanel.add(scrollPane);
	    serviceTypeJpanel.remove(inputButtonJpanel);
	    serviceTypeJpanel.remove(manageButtonJpanel);
	    serviceTypeJpanel.remove(searchButtonJpanel);
	    serviceTypeJpanel.remove(strategyJpanel);
	    serviceTypeJpanel.remove(textJpanel);
}

public void ModifyButtonClicked(){
	area.setEditable(true);
}

public void ConfirmButtonClicked(){
	area.setEditable(false);
}

public void InputRoomButtonClicked(){
	final JFrame inputFrame = new JFrame("录入可用客房");
	JPanel inputPanel = new JPanel();
	JLabel label1 = new JLabel("房间号");
	final JTextField field1 = new JTextField(10);
	JLabel label2 = new JLabel("房间类型");
	final JTextField field2 = new JTextField(10);
	JLabel label3 = new JLabel("价格");
	final JTextField field3 = new JTextField(10);
	JButton confirmButton = new JButton("确定");
	inputPanel.add(label1);
	inputPanel.add(field1);
	inputPanel.add(label2);
	inputPanel.add(field2);
	inputPanel.add(label3);
	inputPanel.add(field3);
	inputPanel.add(confirmButton);
	confirmButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			RoomPo inputRoomPo = new RoomPo(1,1,"1","1","1","1","1","1");
			inputRoomPo.setRoomNum(Integer.parseInt(field1.getText()));
			inputRoomPo.setRoomCategory(field2.getText());
			inputRoomPo.setPrice(field3.getText());
			RoomVo inputRoomVo = new RoomVo(inputRoomPo);
			roomModel.addRow(inputRoomVo);
			inputFrame.dispose();
		}
		
	});
	
	inputFrame.getContentPane().add(inputPanel);
	inputFrame.setBounds(400,400, 200, 200);
	inputFrame.setResizable(false);
	inputFrame.setVisible(true);
	
}


public void DeleteRoomButtonClicked(){
//	final JFrame deleteFrame = new JFrame("删除可用客房");
//	JPanel deletePanel = new JPanel();
//	JLabel label1 = new JLabel("房间号");
//	final JTextField field1 = new JTextField(10);
//	JButton confirmButton = new JButton("确定");
//	deletePanel.add(label1);
//	deletePanel.add(field1);
//	deletePanel.add(confirmButton);
//	confirmButton.addActionListener(new ActionListener(){
//		public void actionPerformed(ActionEvent e) {
			int index = roomTable.getSelectedRow();
			roomModel.removeRow(index);
			
//		}
		
//	});
}

public void StrategyConfirmButtonClicked(){
//	int selected = strategyBox.getSelectedIndex();
	double discount = Double.parseDouble((String)strategyBox.getSelectedItem());
	int orderid = Integer.parseInt(strategyField1.getText());
	controller.selectStrategy(discount,orderid);
//	OrderPo orderPo = orderservice.orderfindbyid(Integer.parseInt(strategyField1.getText()));
//	orderPo.setStrategyNum(strategyNum+1);
}

public void StrategyAddButtonClicked(){
	
	JButton strategySaveButton = new JButton("保存");
	strategySaveButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
		String appendence = strategyAddField.getText();
		options.add(appendence);
		strategyAddFrame.dispose();
		}
		
	});
	JButton strategyCancelButton = new JButton("取消");
	strategyCancelButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			strategyAddFrame.dispose();
			
		}
		
	});
	
	JLabel strategyAddLabel = new JLabel("输入促销策略");
	strategyAddField = new JTextField(30);
	JPanel strategyAddPanel = new JPanel();
	strategyAddPanel.add(strategyAddLabel);
	strategyAddPanel.add(strategyAddField);
	strategyAddPanel.add(strategySaveButton);
	strategyAddPanel.add(strategyCancelButton);
	strategyAddPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	
	strategyAddFrame = new JFrame("添加促销策略");
	strategyAddFrame.setBounds(400,600,300,150);
	strategyAddFrame.setVisible(true);
	strategyAddFrame.getContentPane().add(strategyAddPanel);
}


public void OrderBrowseButtonClicked(){
//	controller.OrderBrowseButtonClicked();
	List<OrderVo> list = controller.getAllOrders(hotelID);
	for(OrderVo orderVo:list){
		searchOrderModel.addRow(orderVo);
	}
}

public void OrderSearchButtonClicked(){
	final JFrame searchFrame = new JFrame("搜索订单");
	JPanel searchPanel = new JPanel();
	JLabel searchLabel = new JLabel("输入订单号");
	final JTextField searchfield = new JTextField(10);
	JButton confirmButton = new JButton("确定");
	searchPanel.add(searchLabel);
	searchPanel.add(searchfield);
	searchPanel.add(confirmButton);
	confirmButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			int orderid = Integer.parseInt(searchfield.getText());
			OrderVo orderVo = controller.searchOrder(orderid);
			searchOrderModel.setRowCount(0);
			searchOrderModel.addRow(orderVo);
//			Vector<OrderVo> tempData = new Vector<OrderVo>();
//			tempData.add(orderVo);
//			DefaultTableModel tempModel = new DefaultTableModel(tempData,searchColumns);
//			searchOrderTable = new JTable(tempModel){
//				private static final long serialVersionUID = 1L;
//
//				public boolean isCellEditable(int row, int column){
//					return false;
//				}
//			};
		}
		
	});
	
	searchFrame.getContentPane().add(searchPanel);
	searchFrame.setBounds(400,400, 200, 200);
	searchFrame.setResizable(false);
	searchFrame.setVisible(true);
}

//public void ExecuteConfirmButtonClicked(){
//	final JFrame executeFrame = new JFrame("执行订单");
//	JPanel executePanel = new JPanel();
//	
//}

public void ExecutingButtonClicked(){
	
	int orderID = Integer.parseInt(executeField1.getText());
	if(controller.executeOrder(orderID)){
		JOptionPane.showMessageDialog(null, "执行成功！");
	}
	else{
		JOptionPane.showMessageDialog(null, "订单已执行或被撤销！");
	}
}

//public void CreditChangeButtonClicked(){
//	creditChangeFrame = new JFrame("信用更改");
//    JButton creditChangeAddButton = new JButton("添加");
//    creditChangeAddButton.addActionListener(new ActionListener(){
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			creditChangeFrame.dispose();
//			
//		}
//    	
//    });
//    JButton creditChangeDeclineButton = new JButton("扣除");
//    creditChangeDeclineButton.addActionListener(new ActionListener(){
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			creditChangeFrame.dispose();
//			
//		}
//    	
//    });
//    JPanel creditChangePanel = new JPanel();
//    creditChangePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//    creditChangePanel.add(executeLabel2);
//    creditChangePanel.add(executeField2);
//    creditChangePanel.add(executeLabel3);
//    creditChangePanel.add(executeField3);
//    creditChangePanel.add(creditChangeAddButton);
//    creditChangePanel.add(creditChangeDeclineButton);
//    
//    creditChangeFrame.setSize(300,300);
//    creditChangeFrame.setVisible(true);
//    creditChangeFrame.getContentPane().add(creditChangePanel);
//    
//}

public void ExitButtonClicked(){
	
}

public static void main(String[] args){
//	HotelFrameControllerService controller = new HotelFrameControllerServiceImpl(1);
//	HotelFrame gui=new HotelFrame(controller);
//	controller.setView(gui);
	hotel gui = new hotel();
	gui.initComponents();
	gui.initMainFrame();
}
}

