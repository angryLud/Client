package presentation.hotelui;

import java.awt.BorderLayout;

import dataservice.*;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.text.DateFormat;
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
import rmi.RemoteHelper;
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
	
	private JButton allorders;
	private JButton inexecutedorders;
	private JButton executedorders;
	private JButton abnormalorders;
	private JButton canceledorders;
	
	private JLabel delayLabel;
	
	private JTextField delayTextField;
	
	
	private JPanel serviceTypeJpanel;
	private JPanel searchButtonJpanel;
	private JPanel delayPanel;
	
	private JTable searchOrderTable;
	
	private Vector<String> searchColumns;
	
	private Vector<OrderVo> searchData;
	
	private DefaultTableModel searchOrderModel;
	
	private JScrollPane scrollPane;

    private OrderPo orderpo;
    private UserPo userpo;
	
	private orderdataservice orderdataservice;
	private userdataservice userdataservice;
	
	public ManageOrderView(ManageOrderViewController controller){
		this.controller = controller;
		this.init();
		this.setLayout(null);
	}
	
	public void init(){
		//组件
		
		allorders = new JButton("所有类型");
		allorders.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//更新订单列表
				searchOrderModel.setRowCount(0);
				if(controller.getAllOrders(HotelID)!=null){
				for (OrderVo orderVo : controller.getAllOrders(HotelID)) {
					searchOrderModel.addRow(orderVo);
				}
				}
				//设置控件可用类型
				delayButton.setEnabled(false);
				executeButton.setEnabled(false);
			}
			
		});
		inexecutedorders = new JButton("未执行订单");
		inexecutedorders.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//更新订单列表
				searchOrderModel.setRowCount(0);
				if(controller.getUnfinishedOrders(HotelID)!=null){
				for (OrderVo orderVo : controller.getUnfinishedOrders(HotelID)) {
					searchOrderModel.addRow(orderVo);
				}
				}
				//设置控件可用类型
				delayButton.setEnabled(false);
				executeButton.setEnabled(true);
			}
			
		});
		executedorders = new JButton("已执行订单");
		executedorders.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//更新订单列表
				searchOrderModel.setRowCount(0);
				if(controller.getFinishedOrders(HotelID)!=null){
				for (OrderVo orderVo : controller.getFinishedOrders(HotelID)) {
					searchOrderModel.addRow(orderVo);
				}
				}
				//设置控件可用类型
				delayButton.setEnabled(false);
				executeButton.setEnabled(false);
				
			}
			
		});
		abnormalorders = new JButton("异常订单");
		abnormalorders.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//更新订单列表
				searchOrderModel.setRowCount(0);
				if(controller.getAbnormalOrders(HotelID)!=null){
				for (OrderVo orderVo : controller.getAbnormalOrders(HotelID)) {
					searchOrderModel.addRow(orderVo);
				}
				}
				//设置控件可用类型
				delayButton.setEnabled(true);
				executeButton.setEnabled(false);
				
			}
			
		});
		canceledorders = new JButton("已撤销订单");
		canceledorders.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//更新订单列表
				searchOrderModel.setRowCount(0);
				if(controller.getcanceledOrders(HotelID)!=null){
				for (OrderVo orderVo : controller.getcanceledOrders(HotelID)) {
					searchOrderModel.addRow(orderVo);
				}
				}
				//设置控件可用类型
				delayButton.setEnabled(false);
				executeButton.setEnabled(false);
			}
		});
		
		scrollPane = new JScrollPane();

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

		searchColumns = new Vector<String>();
		searchColumns.add("订单号");
		searchColumns.add("房间号");
		searchColumns.add("酒店id");
		searchColumns.add("创建时间");
		searchColumns.add("执行时间");
		searchColumns.add("最晚入住时间");
		searchColumns.add("退房时间");
		searchColumns.add("价格");
		searchColumns.add("执行情况");
		
		searchData = new Vector<OrderVo>();
		List<OrderVo> list1 = new ArrayList<OrderVo>();
        list1 = controller.getAllOrders(HotelID);
        for(OrderVo vo :list1){
        	searchData.add(vo);
        }
        
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
			serviceTypeJpanel.add(allorders);
			allorders.setBounds(20,40,100,25);
			serviceTypeJpanel.add(inexecutedorders);
			inexecutedorders.setBounds(130,40,100,25);
			serviceTypeJpanel.add(executedorders);
			executedorders.setBounds(240,40,100,25);
			serviceTypeJpanel.add(abnormalorders);
			abnormalorders.setBounds(350,40,100,25);
			serviceTypeJpanel.add(canceledorders);
			canceledorders.setBounds(460,40,100,25);
			
			this.add(serviceTypeJpanel);
			serviceTypeJpanel.setBounds(0, 0, 800, 600);
		   
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
				OrderPo orderPo = controller.searchOrder(orderid);
				OrderVo orderVo = new OrderVo(orderPo);
				searchOrderModel.setRowCount(0);
				searchOrderModel.addRow(orderVo);
				searchFrame.dispose();
			}
		});
		
		searchFrame.getContentPane().add(searchPanel);
		searchFrame.setBounds(400,400, 200, 200);
		searchFrame.setResizable(false);
		searchFrame.setVisible(true);
	}

	public void ExecuteButtonClicked() {
		int index = searchOrderTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(null, "请选择订单！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		int orderNo=Integer.valueOf((String)searchOrderTable.getValueAt(index, 0));			
		int userid = Integer.valueOf((String)searchOrderTable.getValueAt(index, 1));
		int credit = Integer.valueOf((String)searchOrderTable.getValueAt(index, 7));
		try {
			
			userpo = RemoteHelper.getInstance().getUserdataservice().userfind(userid);
			userpo.setCredit(userpo.getCredit()+credit);
			
			orderpo = RemoteHelper.getInstance().getOrderdataservice().orderfind(orderNo);
		    orderpo.setStatus(1);
		 
			if(RemoteHelper.getInstance().getOrderdataservice().orderupdate(orderpo)&&
					RemoteHelper.getInstance().getUserdataservice().userupdate(userpo)){
				JOptionPane.showMessageDialog(null, "执行成功！","", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null, "执行失败！","", JOptionPane.ERROR_MESSAGE);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		controller.refresh();
	}
	
public void delayOrderButtonClicked(){
		
		final int index = searchOrderTable.getSelectedRow();
		
		if(index == -1){
			JOptionPane.showMessageDialog(null, "请选择订单！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		final int orderNo =Integer.valueOf((String)searchOrderTable.getValueAt(index, 0));
		
		delayFrame = new JFrame();
		delayFrame.setSize(600, 80);
		delayFrame.setLocation(400, 400);
		
		delayPanel = new JPanel();
		delayPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		delayLabel = new JLabel("订单延期至：（yyyyMMdd）");
		delayTextField = new JTextField(10);
		JButton delayProcessButton = new JButton("延期");
		//处理订单延期
		delayProcessButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
					
					String temp = delayTextField.getText();
					long delaytime = Long.parseLong(temp);
					int userid = Integer.valueOf((String)searchOrderTable.getValueAt(index, 1));
					int credit = Integer.valueOf((String)searchOrderTable.getValueAt(index, 7));
					try {
						userpo = RemoteHelper.getInstance().getUserdataservice().userfind(userid);
						userpo.setCredit(userpo.getCredit()+credit);
						orderpo = RemoteHelper.getInstance().getOrderdataservice().orderfind(orderNo);
						orderpo.setStatus(1);
						if(RemoteHelper.getInstance().getOrderdataservice().orderupdate(orderpo)&&
								RemoteHelper.getInstance().getUserdataservice().userupdate(userpo)){
							JOptionPane.showMessageDialog(null, "执行成功！","", JOptionPane.INFORMATION_MESSAGE);
						}
						else{
							JOptionPane.showMessageDialog(null, "执行失败！","", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (RemoteException e) {
						e.printStackTrace();
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

}