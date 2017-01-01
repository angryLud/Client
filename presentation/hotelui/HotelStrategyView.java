package presentation.hotelui;


import javax.swing.*;

import businesslogicservice.OrderService;
import dataservice.*;
import po.OrderPo;
import rmi.RemoteHelper;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;

public class HotelStrategyView extends JPanel{
	
	private HotelStrategyViewController controller;
	
	private orderdataservice orderdataservice;
	
	
	private JFrame strategyAddFrame;
	private JPanel serviceTypeJpanel;
	private JPanel strategyJpanel;
	private JLabel strategyLabel1,strategyLabel2;
	private JTextField strategyField1,strategyAddField;
	private JComboBox strategyBox;
	private JButton strategyConfirmButton;
	private JButton strategyAddButton;
	private JButton exitButton;
	
	private Vector<String> options;
	
	private OrderPo po;
	
	public HotelStrategyView(HotelStrategyViewController controller){
		this.controller = controller;
		this.init();
		this.setLayout(null);
	}
	
	public void init(){
//	初始化组件
	   strategyJpanel = new JPanel();
	   serviceTypeJpanel = new JPanel();
	   
	   strategyLabel1 = new JLabel();
	   strategyLabel1.setText("输入订单号");
	   strategyLabel2 = new JLabel();
	   strategyLabel2.setText("选择促销策略");
	   
	   strategyConfirmButton = new JButton("确定");
	   strategyAddButton = new JButton("管理");
	   exitButton = new JButton("返回");
	   
	   options = new Vector<String>();
	   options.add("生日特惠");
	   options.add("三间以上特惠");
	   options.add("合作企业折扣");
	   options.add("双十一特惠");
	  
	   strategyField1 = new JTextField(20);
	   
	   strategyBox = new JComboBox(options);
		
		
	   strategyJpanel.add(strategyLabel1);
	   strategyJpanel.add(strategyField1);
	   strategyJpanel.add(strategyLabel2);
	   strategyJpanel.add(strategyBox);
	   strategyJpanel.add(strategyConfirmButton);
	   strategyConfirmButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			controller.StrategyConfirmButtonClicked();
		}
	   });

	   exitButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			controller.ExitButtonClicked();
		}
	   });
	    serviceTypeJpanel.setLayout(null);
		serviceTypeJpanel.add(exitButton);
		exitButton.setBounds(650, 20, 70, 25);
		serviceTypeJpanel.add(strategyJpanel);
		strategyJpanel.setBounds(0,80,650,600);
		
		this.add(serviceTypeJpanel);
		serviceTypeJpanel.setBounds(0, 0, 800, 600);
	}
	
	public void StrategyConfirmButtonClicked(){
//		选择促销策略
		orderdataservice = RemoteHelper.getInstance().getOrderdataservice();
		String selected = (String)strategyBox.getSelectedItem();
		double discount = 0.0;
		if(selected == "生日特惠"){
			discount = 0.85;
		}
		if(selected == "三间以上特惠"){
			discount = 0.75;
		}
		if(selected == "合作企业折扣"){
			discount = 0.88;
		}
		if(selected == "双十一特惠"){
			discount = 0.8;
		}
		
		int orderid = Integer.parseInt(strategyField1.getText());
		try {
			po = RemoteHelper.getInstance().getOrderdataservice().orderfind(orderid);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	    po.setDiscount(discount);
	    try {
			if(RemoteHelper.getInstance().getOrderdataservice().orderupdate(po)){
				JOptionPane.showMessageDialog(null, "已生效！","", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
		    	JOptionPane.showMessageDialog(null, "未能应用该优惠！","", JOptionPane.ERROR_MESSAGE);
		    }
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

//	public void StrategyAddButtonClicked(){
//		
//		JButton strategySaveButton = new JButton("生效");
//		strategySaveButton.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//			String appendence = strategyAddField.getText();
//			if(appendence == "生日特惠"){
//				
//			}
//			if(appendence == "三间以上特惠"){
//				
//			}
//			if(appendence == "合作企业折扣"){
//				
//			}
//			if(appendence == "双十一特惠"){
//				
//			}
//			strategyAddFrame.dispose();
//			}
//			
//		});
//		JButton strategyCancelButton = new JButton("失效");
//		strategyCancelButton.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				strategyAddFrame.dispose();
//			}
//		});
//		JLabel strategyAddLabel = new JLabel("输入促销策略");
//		strategyAddField = new JTextField(30);
//		JPanel strategyAddPanel = new JPanel();
//		strategyAddPanel.add(strategyAddLabel);
//		strategyAddPanel.add(strategyAddField);
//		strategyAddPanel.add(strategySaveButton);
//		strategyAddPanel.add(strategyCancelButton);
//		strategyAddPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//		
//		strategyAddFrame = new JFrame("添加促销策略");
//		strategyAddFrame.setBounds(600,400,300,150);
//		strategyAddFrame.setVisible(true);
//		strategyAddFrame.getContentPane().add(strategyAddPanel);
//		serviceTypeJpanel.validate();
//	}
	
}
