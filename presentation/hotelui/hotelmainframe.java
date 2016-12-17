package presentation.hotelui;


import javax.swing.*;

import presentation.controller.HotelStrategyViewControllerImpl;
import presentation.controller.ManageHotelInfoViewControllerImpl;
import presentation.controller.ManageOrderViewControllerImpl;
import presentation.controller.ManageRoomViewControllerImpl;
import presentation.controller.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by huihantao on 2016/12/13.
 */
public class hotelmainframe extends JPanel{
	private int HotelID;

    private JLabel label;
    private JButton back;
    private JTextArea profile;
    private JLabel guanli;
    private JButton HotelInfo;
    private JButton ManageOrder;
    private JButton ManageRoom;
    private JButton HotelStrategy;
    private ImageIcon img;
    private JLabel imgLabel;
    private mainframecontroller hotelcon;

    public hotelmainframe(mainframecontroller hotelcon){
        this.hotelcon=hotelcon;
        this.init();

    }

    private void init(){
    	HotelID = 1;

        this.setLayout(null);
        label=new JLabel("酒店管理人员",JLabel.LEFT);
        label.setBounds(20,10,800,50);
        label.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,30));
        this.add(label);

        back=new JButton("注销");
        back.setBounds(690,10,100,50);
        back.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,30));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hotelcon.signout();
            }
        });
        this.add(back);
        
        img = new ImageIcon("src/presentation/userui/c.jpg");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(40,120,150,150);
        this.add(imgLabel);

        profile=new JTextArea();
        profile.setEditable(false);
        profile.setBounds(40,350,150,150);
        profile.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,20));
        profile.setText("姓名："+"\r\n"+"天气好");
        this.add(profile);

        guanli=new JLabel("管理页面",JLabel.CENTER);
        guanli.setBounds(190,100,550,70);
        guanli.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,40));
        this.add(guanli);


        HotelInfo=new JButton("酒店信息");
        HotelInfo.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,20));
        HotelInfo.setBounds(340,250,100,100);
        HotelInfo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				hotelcon.HotelInfoButtonClicked();
			}
        });
        this.add(HotelInfo);

        ManageOrder=new JButton("订单管理");
        ManageOrder.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,20));
        ManageOrder.setBounds(340,370,100,100);
        ManageOrder.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				hotelcon.ManageOrderButtonClicked();
				
			}
        	
        });
        this.add(ManageOrder);

        ManageRoom=new JButton("客房管理");
        ManageRoom.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,20));
        ManageRoom.setBounds(460,250,100,100);
        ManageRoom.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hotelcon.ManageRoomButtonClicked();
			}
        	
        });
        this.add(ManageRoom);

        HotelStrategy=new JButton("促销策略");
        HotelStrategy.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,20));
        HotelStrategy.setBounds(460,370,100,100);
        HotelStrategy.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hotelcon.HotelStrategyButtonClicked();
				
			}
        	
        });
        this.add(HotelStrategy);
        
    }
//    public void HotelInfoButtonClicked(){
//    	ManageHotelInfoViewController controller = new ManageHotelInfoViewControllerImpl(HotelID);
//    	ManageHotelInfoView view = new ManageHotelInfoView(controller);
//    	controller.setView(view);
//    }
//    public void ManageOrderButtonClicked(){
//    	ManageOrderViewController controller = new ManageOrderViewControllerImpl(HotelID);
//    	ManageOrderView view = new ManageOrderView(controller);
//    	controller.setView(view);
//    }
//    public void ManageRoomButtonClicked(){
//    	ManageRoomViewController controller = new ManageRoomViewControllerImpl(HotelID);
//    	ManageRoomView view = new ManageRoomView(controller);
//    	controller.setView(view);
//    }
//    public void HotelStrategyButtonClicked(){
//    	HotelStrategyViewController controller = new HotelStrategyViewControllerImpl(HotelID);
//    	HotelStrategyView view = new HotelStrategyView(controller);
//    	controller.setView(view);
//    }
}

