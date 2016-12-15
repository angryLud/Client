package presentation.hotelui;


import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class HotelStrategyView extends JPanel{
	
	private HotelStrategyViewController controller;
	
	private JLabel tempLabel;
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
	}
	
	public void init(){
	   tempLabel = new JLabel("                                                                       ");
	   strategyJpanel = new JPanel();
	   serviceTypeJpanel = new JPanel();
	   
	   strategyLabel1 = new JLabel();
	   strategyLabel1.setText("输入订单号");
	   strategyLabel2 = new JLabel();
	   strategyLabel2.setText("选择促销策略");
	   
	   strategyConfirmButton = new JButton("确定");
	   strategyAddButton = new JButton("添加促销策略");
	   exitButton = new JButton("返回");
	   
	   strategyField1 = new JTextField(20);
		
		
	   strategyJpanel.add(strategyLabel1);
	   strategyJpanel.add(strategyField1);
	   strategyJpanel.add(strategyLabel2);
	   strategyJpanel.add(strategyBox);
	   strategyJpanel.add(strategyConfirmButton);
	   strategyConfirmButton.addActionListener(new ActionListener(){

		@Override
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
	    serviceTypeJpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		serviceTypeJpanel.add(tempLabel);
		serviceTypeJpanel.add(exitButton);
		serviceTypeJpanel.add(strategyJpanel);
	}
	
	public void StrategyConfirmButtonClicked(){
//		int selected = strategyBox.getSelectedIndex();
		double discount = Double.parseDouble((String)strategyBox.getSelectedItem());
		int orderid = Integer.parseInt(strategyField1.getText());
//		controller.selectStrategy(discount,orderid);
//		OrderPo orderPo = orderservice.orderfindbyid(Integer.parseInt(strategyField1.getText()));
//		orderPo.setStrategyNum(strategyNum+1);
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
		strategyAddFrame.setBounds(600,400,300,150);
		strategyAddFrame.setVisible(true);
		strategyAddFrame.getContentPane().add(strategyAddPanel);
	}
	
	public void ExitButtonClicked(){
		
	}
}