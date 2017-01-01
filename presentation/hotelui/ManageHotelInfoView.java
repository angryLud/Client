package presentation.hotelui;

import java.awt.FlowLayout;
import dataservice.hoteldataservice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import po.HotelPo;
import rmi.RemoteHelper;

public class ManageHotelInfoView extends JPanel{
	private int hotelID;
	private ManageHotelInfoViewController controller;
	private hoteldataservice hoteldataservice;
	
	private JTextField dizhi;
	private JTextField shangquan;
	private JTextField jianjie;
	private JTextField dachuangfangjiage;
	private JTextField shuangrenfangjiage;
	private JTextField sanrenjianjiage;
	private JTextField xingji;
	
	private JLabel dizhil;
	private JLabel shangquanl;
	private JLabel jianjiel;
	private JLabel dachuangfangjiagel;
	private JLabel shuangrenfangjiagel;
	private JLabel sanrenjianjiagel;
	private JLabel xingjil;


	
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
		dizhi = new JTextField(10);
		shangquan = new JTextField(10);
		jianjie = new JTextField(50);
		dachuangfangjiage = new JTextField(10);
		shuangrenfangjiage = new JTextField(10);
		sanrenjianjiage = new JTextField(10);
		xingji = new JTextField(10);
		
		dizhi.setEditable(false);
		shangquan.setEditable(false);
		jianjie.setEditable(false);
		dachuangfangjiage.setEditable(false);
		shuangrenfangjiage.setEditable(false);
		sanrenjianjiage.setEditable(false);
		xingji.setEditable(false);
		
		dizhil = new JLabel("地址");
		shangquanl = new JLabel("商圈");
		jianjiel = new JLabel("简介");
		dachuangfangjiagel = new JLabel("大床房价格");
		shuangrenfangjiagel = new JLabel("双人房价格");
		sanrenjianjiagel = new JLabel("三人间价格");
		xingjil = new JLabel("星级");
		
		serviceTypeJpanel = new JPanel();
		
		modifyButton = new JButton("修改");
		confirmButton = new JButton("确定");
		exitButton = new JButton("返回");

		try {
			po = RemoteHelper.getInstance().getHoteldataservice().findhotelbyid(hotelID);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		//界面内容
		dizhi.setText(controller.getAddress());
		shangquan.setText(controller.getPosition());
		jianjie.setText(controller.getDescription());
		dachuangfangjiage.setText(String.valueOf(controller.getDachuangfangjiage()));
		shuangrenfangjiage.setText(String.valueOf(controller.getShuangrenfangprice()));
		sanrenjianjiage.setText(String.valueOf(controller.getSanrenjianprice()));
		xingji.setText(String.valueOf(controller.getStar()));
		
		
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
		
		serviceTypeJpanel.setLayout(null);
		serviceTypeJpanel.add(exitButton);
		exitButton.setBounds(600, 40, 70, 25);
		
		serviceTypeJpanel.add(dizhil);
		dizhil.setBounds(20,60,80,20);
		serviceTypeJpanel.add(shangquanl);
		shangquanl.setBounds(20,90,80,20);
		serviceTypeJpanel.add(jianjiel);
		jianjiel.setBounds(20,120,80,20);
		serviceTypeJpanel.add(dachuangfangjiagel);
		dachuangfangjiagel.setBounds(20,150,80,20);
		serviceTypeJpanel.add(shuangrenfangjiagel);
		shuangrenfangjiagel.setBounds(20,180,80,20);
		serviceTypeJpanel.add(sanrenjianjiagel);
		sanrenjianjiagel.setBounds(20,210,80,20);
		serviceTypeJpanel.add(xingjil);
		xingjil.setBounds(20,240,80,20);
		
		serviceTypeJpanel.add(dizhi);
		dizhi.setBounds(120,60,180,20);
		serviceTypeJpanel.add(shangquan);
		shangquan.setBounds(120,90,180,20);
		serviceTypeJpanel.add(jianjie);
		jianjie.setBounds(120,120,180,20);
		serviceTypeJpanel.add(dachuangfangjiage);
		dachuangfangjiage.setBounds(120,150,180,20);
		serviceTypeJpanel.add(shuangrenfangjiage);
		shuangrenfangjiage.setBounds(120,180,180,20);
		serviceTypeJpanel.add(sanrenjianjiage);
		sanrenjianjiage.setBounds(120,210,180,20);
		serviceTypeJpanel.add(xingji);
		xingji.setBounds(120,240,180,20);
		
		serviceTypeJpanel.add(modifyButton);
		modifyButton.setBounds(400,210,70,25);
		serviceTypeJpanel.add(confirmButton);
		confirmButton.setBounds(480,210,70,25);
		
		this.add(serviceTypeJpanel);
		serviceTypeJpanel.setBounds(0, 0, 800, 600);
	}
		
		public void ModifyButtonClicked(){
			dizhi.setEditable(true);
			shangquan.setEditable(true);
			jianjie.setEditable(true);
			dachuangfangjiage.setEditable(true);
			shuangrenfangjiage.setEditable(true);
			sanrenjianjiage.setEditable(true);
			xingji.setEditable(true);
			
		}

		public void ConfirmButtonClicked(){
			dizhi.setEditable(false);
			shangquan.setEditable(false);
			jianjie.setEditable(false);
			dachuangfangjiage.setEditable(false);
			shuangrenfangjiage.setEditable(false);
			sanrenjianjiage.setEditable(false);
			xingji.setEditable(false);
//			if(dizhi.getText()==null||shangquan.getText()==null||jianjie.getText()==null||dachuangfangjiage.getText()==null
//					||shuangrenfangjiage.getText()==null||sanrenjianjiage.getText()==null||xingji.getText()==null
//					||Integer.parseInt(dachuangfangjiage.getText())>Integer.parseInt(shuangrenfangjiage.getText())
//					||Integer.parseInt(dachuangfangjiage.getText())>Integer.parseInt(sanrenjianjiage.getText())
//					||Integer.parseInt(shuangrenfangjiage.getText())>Integer.parseInt(sanrenjianjiage.getText())){
//				JOptionPane.showMessageDialog(null, "输入不符合规定！","", JOptionPane.INFORMATION_MESSAGE);
//			}

			po.setAddress(dizhi.getText());
			po.setPosition(shangquan.getText());
			po.setDescription(jianjie.getText());
			po.setDachuangfangprice(Integer.parseInt(dachuangfangjiage.getText()));
			po.setShuangrenfangprice(Integer.parseInt(shuangrenfangjiage.getText()));
			po.setSanrenjianprice(Integer.parseInt(sanrenjianjiage.getText()));
			po.setStar(Integer.parseInt(xingji.getText()));
			
			if(controller.updateHotel(po)){
				JOptionPane.showMessageDialog(null, "修改成功！","", JOptionPane.INFORMATION_MESSAGE);
				controller.refresh();
			}

			
		}
}
