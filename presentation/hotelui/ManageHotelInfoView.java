package presentation.hotelui;

import java.awt.FlowLayout;
import dataservice.hoteldataservice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import po.HotelPo;

public class ManageHotelInfoView extends JPanel{
	private int hotelID;
	private ManageHotelInfoViewController controller;
	private hoteldataservice hoteldataservice;
	private JTextArea area;
	private JPanel textJpanel;
	private JPanel serviceTypeJpanel;
	private JButton modifyButton;
	private JButton confirmButton;
	private JButton exitButton;
	private HotelPo po;

	public ManageHotelInfoView(ManageHotelInfoViewController controller){
		this.controller = controller;
		this.init();
		this.setLayout(null);
	}
	
		private void init() {
		//初始化组件
		area = new JTextArea(8,30);
		area.setEditable(false);
		
		textJpanel = new JPanel();
		
		serviceTypeJpanel = new JPanel();
		
		modifyButton = new JButton("修改");
		confirmButton = new JButton("确定");
		exitButton = new JButton("返回");
		
		po = new HotelPo(1,"仙林","英尊",188,288,328,4,4.6,"商圈：XXXX\n地址：XXXXX\n服务设施：停车场丶wifi等\n房间价格：XXXXX\n");
//		try{
//			po = hoteldataservice.findhotelbyid(hotelID);
//		}
//		catch(RemoteException e){
//			e.printStackTrace();
//		}
		//界面内容
		area.setFont(new Font("serif",Font.BOLD,20));
		area.setText(po.getDescription());
		area.setEditable(false);
		textJpanel.add(area);
		
	    modifyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.ModifyButtonClicked();
			}
	    });
		
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.ConfirmButtonClicked();
			}
		});
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.ExitButtonClicked();
			}
		});
		textJpanel.add(modifyButton);
		textJpanel.add(confirmButton);
        
		serviceTypeJpanel.setLayout(null);
		serviceTypeJpanel.add(exitButton);
		exitButton.setBounds(600, 40, 70, 25);
		serviceTypeJpanel.add(textJpanel);
		textJpanel.setBounds(0,80,650,600);
		textJpanel.setVisible(true);
		
		this.add(serviceTypeJpanel);
		serviceTypeJpanel.setBounds(0, 0, 800, 600);

	}
		
		public void ModifyButtonClicked(){
			area.setEditable(true);
			po.setDescription(area.getText());
		}

		public void ConfirmButtonClicked(){
			area.setEditable(false);
		}
}
