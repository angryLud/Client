package presentation.hotelui;


import javax.swing.*;
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
	
	public HotelStrategyView(HotelStrategyViewController controller){
		this.controller = controller;
		this.init();
		this.setLayout(null);
	}
	
	public void init(){
	   strategyJpanel = new JPanel();
	   serviceTypeJpanel = new JPanel();
	   
	   strategyLabel1 = new JLabel();
	   strategyLabel1.setText("输入订单号");
	   strategyLabel2 = new JLabel();
	   strategyLabel2.setText("选择促销策略");
	   
	   strategyConfirmButton = new JButton("确定");
	   strategyAddButton = new JButton("添加促销策略");
	   exitButton = new JButton("返回");
	   
	   options = new Vector<String>();
	   options.add("0.95");
	   options.add("0.85");
	   options.add("0.75");
	  
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
	   strategyJpanel.add(strategyAddButton);
	   strategyAddButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.StrategyAddButtonClicked();
			
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
		strategyJpanel.setBounds(0,40,650,600);
		
		this.add(serviceTypeJpanel);
		serviceTypeJpanel.setBounds(0, 0, 800, 600);
	}
	
	public void StrategyConfirmButtonClicked(){
		orderdataservice = RemoteHelper.getInstance().getOrderdataservice();
		double discount = Double.parseDouble((String)strategyBox.getSelectedItem());
		int orderid = Integer.parseInt(strategyField1.getText());
		OrderPo po = new OrderPo(0,0,0,0,0,0,0,0,"0",0);
		try {
			po = orderdataservice.find(orderid);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	    po.setDiscount(discount);
		
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
		strategyAddFrame.setBounds(600,400,300,150);
		strategyAddFrame.setVisible(true);
		strategyAddFrame.getContentPane().add(strategyAddPanel);
		serviceTypeJpanel.validate();
	}
	
}
