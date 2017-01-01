package presentation.hotelui;

import java.awt.BorderLayout;

import dataservice.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import po.OrderPo;
import po.UserPo;
import vo.OrderVo;

public class ManageOrderView extends JPanel{
	
	private int HotelID;
	private ManageOrderViewController controller;
	
	private JFrame delayFrame;
	private JButton orderBrowseButton;
	private JButton orderSearchButton;
	private JButton executingButton;
	private JButton executeButton;
	private JButton exitButton;
	private JButton delayButton;
	
	
	private JLabel tempLabel;
	private JLabel delayLabel;
	
	private JTextField executeField1;
	private JTextField delayTextField;
	
	private JLabel executeLabel1;
	
	private JPanel serviceTypeJpanel;
	private JPanel searchButtonJpanel;
	private JPanel executeJpanel;
	private JPanel delayPanel;
	
	private JTable searchOrderTable;
	private JTable executeOrderTable;
	
	private Vector<String> searchColumns;
	private Vector<String> executeColumns;
	
	private Vector<OrderVo> searchData;
	private Vector<OrderVo> executeData;
	
	private DefaultTableModel searchOrderModel;
	private DefaultTableModel executeOrderModel;
	
	private JScrollPane scrollPane;
	
	private JComboBox orderTypeBox;
	
	private orderdataservice orderdataservice;
	private userdataservice userdataservice;
	
	public ManageOrderView(ManageOrderViewController controller){
		this.controller = controller;
		this.init();
		this.setLayout(null);
	}
	
	public void init(){
		//组件
		
		Vector<String> list = new Vector<String>();
		list.add("所有类型");
		list.add("已执行订单");
		list.add("未执行订单");
		list.add("异常订单");
		orderTypeBox = new JComboBox(list);
		final String selected = (String) orderTypeBox.getSelectedItem();
		orderTypeBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				controller.updateListModel(selected);
			}
			
		});
		
		scrollPane = new JScrollPane();
		executeLabel1 = new JLabel("输入订单号");
		executeField1 = new JTextField(10);
		
		orderSearchButton = new JButton("搜索");
		executeButton = new JButton("执行订单");
		executingButton = new JButton("执行");
		exitButton = new JButton("返回");
		delayButton = new JButton("延迟入住");
		delayButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				delayOrderButtonClicked();
				
			}
			
		});
		
		serviceTypeJpanel = new JPanel();
		searchButtonJpanel = new JPanel();
		executeJpanel = new JPanel();
		
		searchColumns = new Vector<String>();
		searchColumns.add("订单号");
		searchColumns.add("用户id");
		searchColumns.add("酒店id");
		searchColumns.add("创建时间");
		searchColumns.add("执行时间");
		searchColumns.add("延迟时间");
		searchColumns.add("入住时间");
		searchColumns.add("价格");
		searchColumns.add("执行情况");
		
		searchData = new Vector<OrderVo>();
		OrderPo orderPo = new OrderPo(1,2,3,20161203,20161205,20161205,20161208,198,1,0,316);
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
		OrderPo orderPo2 = new OrderPo(1,2,3,20161203,20161205,20161205,20161208,198,1,0,316);
		OrderVo orderVo2 = new OrderVo(orderPo2);
		executeData.add(orderVo2);
		
		
	    //界面内容
		searchOrderModel = new DefaultTableModel(searchData, searchColumns);
		searchOrderTable = new JTable(searchOrderModel){

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		searchOrderTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.getViewport().add(searchOrderTable);
		searchOrderTable.setFillsViewportHeight(true);

		searchButtonJpanel.add(orderSearchButton);
		orderSearchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.OrderSearchButtonClicked();
			}
		});
		searchButtonJpanel.add(executeButton);
		executeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				  controller.ExecuteButtonClicked();
			}
		});
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.ExitButtonClicked();
			}
		});
		searchButtonJpanel.add(delayButton);
		    serviceTypeJpanel.setLayout(null);
		    serviceTypeJpanel.add(exitButton);
		    exitButton.setBounds(600, 40, 70, 25);
			serviceTypeJpanel.add(scrollPane);
			scrollPane.setBounds(20,80,470,300);
			serviceTypeJpanel.add(searchButtonJpanel);
			searchButtonJpanel.setBounds(500,300,250,100);
			serviceTypeJpanel.add(orderTypeBox);
			orderTypeBox.setBounds(20,40,100,25);
			
			this.add(serviceTypeJpanel);
			serviceTypeJpanel.setBounds(0, 0, 800, 600);
		   
	}
	public void updateListModel(String selected) {
		if(selected == "所有类型"){
			//更新订单列表
			searchOrderModel.setRowCount(0);
			for (OrderVo orderVo : controller.getAllOrders(HotelID)) {
				searchOrderModel.addRow(orderVo);
			}
			//设置控件可用类型
			delayButton.setEnabled(false);
			executeButton.setEnabled(false);
			
		}else if(selected == "未执行订单"){
			//更新订单列表
			searchOrderModel.setRowCount(0);
			for (OrderVo orderVo : controller.getUnfinishedOrders(HotelID)) {
				searchOrderModel.addRow(orderVo);
			}
			
			//设置控件可用类型
			delayButton.setEnabled(false);
			executeButton.setEnabled(true);
			
			
		}else if(selected == "已执行订单"){
			//更新订单列表
			searchOrderModel.setRowCount(0);
			for (OrderVo orderVo : controller.getFinishedOrders(HotelID)) {
				searchOrderModel.addRow(orderVo);
			}
			
			//设置控件可用类型
			delayButton.setEnabled(false);
			executeButton.setEnabled(false);
			
		}else if(selected == "异常订单"){
			//更新订单列表
			searchOrderModel.setRowCount(0);
			for (OrderVo orderVo : controller.getAbnormalOrders(HotelID)) {
				searchOrderModel.addRow(orderVo);
			}
			
			//设置控件可用类型
			delayButton.setEnabled(true);
			executeButton.setEnabled(false);
			
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
			public void actionPerformed(ActionEvent e) {
				int orderid = Integer.parseInt(searchfield.getText());
				OrderVo orderVo = controller.searchOrder(orderid);
				searchOrderModel.setRowCount(0);
				searchOrderModel.addRow(orderVo);	
			}
		});
		
		searchFrame.getContentPane().add(searchPanel);
		searchFrame.setBounds(400,400, 200, 200);
		searchFrame.setResizable(false);
		searchFrame.setVisible(true);
	}
//	public void ExecuteButtonClicked(){
//		serviceTypeJpanel.repaint();
//		executeOrderModel = new DefaultTableModel(executeData, executeColumns);
//		executeOrderTable = new JTable(executeOrderModel){
//			private static final long serialVersionUID = 1L;
//
//			public boolean isCellEditable(int row, int column){
//				return false;
//			}
//		};
//		executeOrderTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		scrollPane.getViewport().add(executeOrderTable);
//		executeOrderTable.setFillsViewportHeight(true);
//	
//	
//	    executeJpanel.add(executeLabel1);
//	    executeJpanel.add(executeField1);
//
//	    executeJpanel.add(executingButton);
//	    executingButton.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				ExecutingButtonClicked();
//				
//			}
//	    	
//	    });
//	    serviceTypeJpanel.setLayout(null);
//	    serviceTypeJpanel.add(exitButton);
//	    exitButton.setBounds(600, 40, 70, 25);
//	    serviceTypeJpanel.remove(searchButtonJpanel);
//		serviceTypeJpanel.add(executeJpanel);
//		executeJpanel.setBounds(0,80,400,50);
//		serviceTypeJpanel.add(scrollPane);
//		scrollPane.setBounds(20,150,470,300);
//		serviceTypeJpanel.validate();
//}
	public void ExecuteButtonClicked() {
		int index = searchOrderTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(null, "请选择订单！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		int orderNo=Integer.valueOf((String)searchOrderTable.getValueAt(index, 0));
		if(controller.executeOrder(orderNo)){
			searchOrderModel.removeRow(index);
			//逻辑层方法：改状态、getuserpo、加信用、更新
			
			int userid = Integer.valueOf((String)searchOrderTable.getValueAt(index, 1));
			int credit = Integer.valueOf((String)searchOrderTable.getValueAt(index, 7));
			try {
				controller.CreditChange(orderNo, userid, credit);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		}else{
			JOptionPane.showMessageDialog(null, "执行失败！","", JOptionPane.ERROR_MESSAGE);
		}
		controller.refresh();
	}
	
public void delayOrderButtonClicked(){
		
		final int index = searchOrderTable.getSelectedRow();
		
		if(index == -1){
			JOptionPane.showMessageDialog(null, "请选择订单！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		final int rowIndex = index;
		final int orderNo =Integer.valueOf((String)searchOrderTable.getValueAt(index, 0));
		
		delayFrame = new JFrame();
		delayFrame.setSize(600, 80);
		delayFrame.setLocation(400, 400);
		
		delayPanel = new JPanel();
		delayPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		delayLabel = new JLabel("订单延期至：（yyyy/MM/dd）");
		delayTextField = new JTextField(10);
		JButton delayProcessButton = new JButton("延期");
		//处理订单延期
		delayProcessButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(delayOrder(orderNo)){
					searchOrderModel.removeRow(rowIndex);
					String temp = delayTextField.getText();
					long delaytime = Long.parseLong(temp);
					int userid = Integer.valueOf((String)searchOrderTable.getValueAt(index, 1));
					int credit = Integer.valueOf((String)searchOrderTable.getValueAt(index, 7));
					try {
						controller.CreditRestore(orderNo, userid, credit, delaytime);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "执行失败！","", JOptionPane.ERROR_MESSAGE);
				}
				controller.refresh();
			}
		});
		JButton cancelButton = new JButton("取消");
		//取消订单延期处理
		cancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//关闭窗口
				delayFrame.dispose();
				
			}
		});
		delayPanel = new JPanel();
		delayPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		delayPanel.add(delayLabel);
		delayPanel.add(delayTextField);
		delayPanel.add(delayProcessButton);
		delayPanel.add(cancelButton);
		
		delayFrame.getContentPane().add(delayPanel);
		delayFrame.setVisible(true);
		
	}

   private boolean delayOrder(int orderNo) {
 	
	String time = delayTextField.getText().replaceAll("/", "");
	double delayTime = Double.parseDouble(time);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	try {
		Date date = sdf.parse(time);
	} catch (ParseException e) {
		JOptionPane.showMessageDialog(null, "请按格式（yyyy/MM/dd）填写时间！","", JOptionPane.ERROR_MESSAGE);
		delayTextField.setText("");
		return false;
	}
	if(controller.processAbnormalOrder(orderNo,time)){	
		delayFrame.dispose();
		return true;
	}else{
		JOptionPane.showMessageDialog(null, "延期异常订单失败！","", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
}
//	public void ExecutingButtonClicked(){
//		
//		int orderID = Integer.parseInt(executeField1.getText());
//		if(controller.executeOrder(orderID)){
//			JOptionPane.showMessageDialog(null, "执行成功！");
//		}
//		else{
//			JOptionPane.showMessageDialog(null, "订单不存在或被撤销！");
//		}
//	}
}
