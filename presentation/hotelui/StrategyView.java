package presentation.hotelui;


import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class StrategyView extends JPanel{
	
	private StrategyViewController controller;
	
	
	private JFrame strategyAddFrame;
	private JPanel serviceTypeJpanel;
	private JPanel strategyJpanel;
	private JLabel strategyLabel1,strategyLabel2;
	private JTextField strategyField1,strategyField2,strategyAddField;
	private JComboBox strategyBox;
	private JButton strategyConfirmButton;
	private JButton strategyAddButton;
	
	private Vector<String> options;
	
	public StrategyView(StrategyViewController controller){
		this.controller = controller;
		this.init();
	}
	
	public void init(){
	   strategyJpanel = new JPanel();
	   
	   strategyLabel1 = new JLabel();
	   strategyLabel1.setText("输入订单号");
	   strategyLabel2 = new JLabel();
	   strategyLabel2.setText("选择促销策略");
	   
	   strategyConfirmButton = new JButton("确定");
	   strategyAddButton = new JButton("添加促销策略");
	   
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
	//���沼��
//	    frame.repaint();
//	    mainlabel.setVisible(false);
//		label.setVisible(false);
//		label1.setVisible(false);
//		label2.setVisible(true);
//		label3.setVisible(false);
//		label4.setVisible(false);
//		label5.setVisible(false);
//		frame.getContentPane().add(BorderLayout.NORTH,label2);
//		serviceTypeJpanel.add(strategyJpanel);
//		serviceTypeJpanel.remove(scrollPane);
//	    serviceTypeJpanel.remove(inputButtonJpanel);
//	    serviceTypeJpanel.remove(executeJpanel);
//	    serviceTypeJpanel.remove(manageButtonJpanel);
//	    serviceTypeJpanel.remove(searchButtonJpanel);
//	    serviceTypeJpanel.remove(textJpanel);
	    strategyJpanel.setVisible(false);
	    strategyJpanel.setVisible(true);
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
}
