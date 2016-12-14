package presentation.hotelui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ManageHotelInfoView {
	private ManageHotelInfoViewController controller;
	private JTextArea area;
	private JPanel textJpanel;
	private JPanel serviceTypeJpanel;
	private JButton modifyButton;
	private JButton confirmButton;
	private JButton exitButton;
	private JLabel templabel;
	
	public ManageHotelInfoView(ManageHotelInfoViewController controller){
		this.controller = controller;
		this.init();
	}
	
		public void init(){
		//初始化组件
		area = new JTextArea(8,30);
		area.setEditable(false);
		
		textJpanel = new JPanel();
		
		serviceTypeJpanel = new JPanel();
		
		modifyButton = new JButton("修改");
		confirmButton = new JButton("确定");
		exitButton = new JButton("返回");
		
		templabel = new JLabel("                                                  ");
		
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
				controller.ModifyButtonClicked();
				
			}
	    	
	    });
		
		confirmButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.ConfirmButtonClicked();
				
			}
			
		});
		exitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.ExitButtonClicked();
				
			}
			
		});
		textJpanel.add(modifyButton);
		textJpanel.add(confirmButton);
        
		serviceTypeJpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		serviceTypeJpanel.add(templabel);
		serviceTypeJpanel.add(exitButton);
		serviceTypeJpanel.add(textJpanel);
		textJpanel.setVisible(true);
		
		
	
		
	}
		public void ExitButtonClicked(){
			
		}
		public void ModifyButtonClicked(){
			area.setEditable(true);
		}

		public void ConfirmButtonClicked(){
			area.setEditable(false);
		}
}
