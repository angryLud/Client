package presentation.hotelui;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import po.*;
import vo.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import presentation.controller.controller;
public class ManageRoomView extends JPanel{
	
	private ManageRoomViewController controller;
	
	private JButton inputRoomButton;
	private JButton deleteRoomButton;
	private JButton exitButton;
	
	private JPanel manageButtonJpanel;
	private JPanel serviceTypeJpanel;
	private JPanel inputButtonJpanel;
	
	private DefaultTableModel roomModel;
	private DefaultTableModel manageRoomModel;
	
	private Vector<String> vColumns;
	private Vector<String> manageColumns;
	
	private Vector<Vector<String>> vData;
	private Vector<Vector<String>> manageData;
	
	private JTable roomTable;
	private JTable manageRoomTable;
	
	private HotelPo po1;
	
	private JScrollPane scrollPane;
	
	public ManageRoomView(ManageRoomViewController controller){
		this.controller = controller;
		this.init();
		this.setLayout(null);
	}
	
	
	public void init(){
		scrollPane = new JScrollPane();

		inputRoomButton = new JButton("录入");
		deleteRoomButton = new JButton("删除");
		exitButton = new JButton("返回");
		
		serviceTypeJpanel = new JPanel();
		inputButtonJpanel = new JPanel();
		manageButtonJpanel = new JPanel();
		
		
		manageColumns = new Vector<String>();
		manageColumns.add("酒店id");
		manageColumns.add("酒店名称");
		manageColumns.add("房间类型");
		manageColumns.add("可用数量");
		manageColumns.add("价格");
		
		manageData = new Vector<Vector<String>>();
		Vector<String> vo1 = new Vector<String>();
		Vector<String> vo2 = new Vector<String>();
		Vector<String> vo3 = new Vector<String>();
		po1 = new HotelPo(1,"仙林","英尊",188,288,328,4,4.6,"不错");
		po1.setAvdachuangfang(28);
		po1.setAvshuangrenfang(19);
		po1.setAvsanrenjian(20);
		
		vo1.add(String.valueOf(po1.getHotelID()));
		vo1.add(po1.getHotelName());
		vo1.add("大床房");
		vo1.add(String.valueOf(po1.getAvdachuangfang()));
		vo1.add(String.valueOf(po1.getDachaungfangprice()));
		
		vo2.add(String.valueOf(po1.getHotelID()));
		vo2.add(po1.getHotelName());
		vo2.add("双人房");
		vo2.add(String.valueOf(po1.getAvshuangrenfang()));
		vo2.add(String.valueOf(po1.getShuangrenfangprice()));
		
		vo3.add(String.valueOf(po1.getHotelID()));
		vo3.add(po1.getHotelName());
		vo3.add("三人间");
		vo3.add(String.valueOf(po1.getAvsanrenjian()));
		vo3.add(String.valueOf(po1.getSanrenjianprice()));
		manageData.add(vo1);
		manageData.add(vo2);
		manageData.add(vo3);
		
//		vColumns = new Vector<String>();
//		vColumns.add("酒店id");
//		vColumns.add("酒店名称");
//		vColumns.add("房间类型");
//		vColumns.add("可用数量");
//		vColumns.add("价格");
//		
//        vData = new Vector<Vector<String>>();
//        Vector<String> vo4 = new Vector<String>();
//		Vector<String> vo5 = new Vector<String>();
//		Vector<String> vo6 = new Vector<String>();
//		po1.setAvdachuangfang(28);
//		po1.setAvshuangrenfang(19);
//		po1.setAvsanrenjian(20);
//		
//		vo4.add(String.valueOf(po1.getHotelID()));
//		vo4.add(po1.getHotelName());
//		vo4.add("大床房");
//		vo4.add(String.valueOf(po1.getAvdachuangfang()));
//		vo4.add(String.valueOf(po1.getDachaungfangprice()));
//		
//		vo5.add(String.valueOf(po1.getHotelID()));
//		vo5.add(po1.getHotelName());
//		vo5.add("双人房");
//		vo5.add(String.valueOf(po1.getAvshuangrenfang()));
//		vo5.add(String.valueOf(po1.getShuangrenfangprice()));
//		
//		vo6.add(String.valueOf(po1.getHotelID()));
//		vo6.add(po1.getHotelName());
//		vo6.add("三人间");
//		vo6.add(String.valueOf(po1.getAvsanrenjian()));
//		vo6.add(String.valueOf(po1.getSanrenjianprice()));
//		vData.add(vo4);
//		vData.add(vo5);
//		vData.add(vo6);
//        
		
		manageRoomModel = new DefaultTableModel(manageData, manageColumns);
		manageRoomTable = new JTable(manageRoomModel){

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		manageRoomTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.getViewport().add(manageRoomTable);
		manageRoomTable.setFillsViewportHeight(true);
       
        
        manageButtonJpanel.add(inputRoomButton);
        manageButtonJpanel.add(deleteRoomButton);
        
        inputRoomButton.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent e) {
		         InputRoomButtonClicked();
	         }
        });
        deleteRoomButton.addActionListener(new ActionListener(){
	         public void actionPerformed(ActionEvent e) {
		          DeleteRoomButtonClicked();
	         }
       });
         
        serviceTypeJpanel.setLayout(null);
	    serviceTypeJpanel.add(exitButton);
	    exitButton.setBounds(600, 40, 70, 25);
	    exitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.ExitButtonClicked();
				
			}
	    	
	    });
	    serviceTypeJpanel.add(scrollPane);
	    scrollPane.setBounds(20,80,470,300);
	    serviceTypeJpanel.add(manageButtonJpanel);
	    manageButtonJpanel.setBounds(480,300,250,100);
	    
	    this.add(serviceTypeJpanel);
		serviceTypeJpanel.setBounds(0, 0, 800, 600);
	}
	
//	public void InputButtonClicked(){
//		serviceTypeJpanel.repaint();
//		roomModel = new DefaultTableModel(vData, vColumns);
//		roomTable = new JTable(roomModel){
//			private static final long serialVersionUID = 1L;
//
//			public boolean isCellEditable(int row, int column){
//				return false;
//			}
//		};
//		roomTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		scrollPane.getViewport().add(roomTable);
//		roomTable.setFillsViewportHeight(true);
//		
//        inputButtonJpanel.add(inputRoomButton);
//        inputButtonJpanel.add(deleteRoomButton);
//
//
//        inputRoomButton.addActionListener(new ActionListener(){
//	         public void actionPerformed(ActionEvent e) {
//		         InputRoomButtonClicked();
//	         }
//         });
//        deleteRoomButton.addActionListener(new ActionListener(){
//	         public void actionPerformed(ActionEvent e) {
//		          DeleteRoomButtonClicked();
//	         }
//        });
//        
//        serviceTypeJpanel.setLayout(null);
//	    
//	    serviceTypeJpanel.add(exitButton);
//	    exitButton.setBounds(600, 40, 70, 25);
//	    exitButton.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				controller.ExitButtonClicked();
//			}
//	    });
//	    serviceTypeJpanel.add(scrollPane);
//	    scrollPane.setBounds(20,80,470,300);
//	    serviceTypeJpanel.remove(manageButtonJpanel);
//	    serviceTypeJpanel.add(inputButtonJpanel);
//	    inputButtonJpanel.setBounds(480,300,250,100);
//	    serviceTypeJpanel.validate();
//	    this.remove(serviceTypeJpanel);
//	    this.add(serviceTypeJpanel);
//		serviceTypeJpanel.setBounds(0, 0, 800, 600);
//}
	public void InputRoomButtonClicked(){
		final JFrame inputFrame = new JFrame("录入可用客房");
		JPanel inputPanel = new JPanel();
		
		JLabel label2 = new JLabel("房间类型");
		Vector<String> categories = new Vector<String>();
		categories.add("大床房");
		categories.add("双人房");
		categories.add("三人间");
		final JComboBox box1 = new JComboBox(categories);
		
		
		
		JButton confirmButton = new JButton("确定");
		
		inputPanel.add(label2);
		inputPanel.add(box1);
		
		inputPanel.add(confirmButton);
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(box1.getSelectedIndex()==0){
					po1.setAvdachuangfang(po1.getAvdachuangfang()+1);
				}
				if(box1.getSelectedIndex()==1){
					po1.setAvshuangrenfang(po1.getAvshuangrenfang()+1);
				}
				if(box1.getSelectedIndex()==2){
					po1.setAvsanrenjian(po1.getAvsanrenjian()+1);
				}
				manageRoomModel = new DefaultTableModel(manageData, manageColumns);
				manageRoomTable = new JTable(manageRoomModel){

					public boolean isCellEditable(int row, int column){
						return false;
					}
				};
				serviceTypeJpanel.validate();
				inputFrame.dispose();
				
			}
			
		});
		
		inputFrame.getContentPane().add(inputPanel);
		inputFrame.setBounds(400,400, 200, 200);
		inputFrame.setResizable(false);
		inputFrame.setVisible(true);
		
	}


	public void DeleteRoomButtonClicked(){
		final JFrame deleteFrame = new JFrame("删除可用客房");
		JPanel deletePanel = new JPanel();
		
		JLabel label2 = new JLabel("房间类型");
		Vector<String> categories = new Vector<String>();
		categories.add("大床房");
		categories.add("双人房");
		categories.add("三人间");
		final JComboBox box1 = new JComboBox(categories);
		
		JButton confirmButton = new JButton("确定");
		
		deletePanel.add(label2);
		deletePanel.add(box1);
		
		deletePanel.add(confirmButton);
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(box1.getSelectedIndex()==0){
					po1.setAvdachuangfang(po1.getAvdachuangfang()-1);
				}
				if(box1.getSelectedIndex()==1){
					po1.setAvshuangrenfang(po1.getAvshuangrenfang()-1);
				}
				if(box1.getSelectedIndex()==2){
					po1.setAvsanrenjian(po1.getAvsanrenjian()-1);
				}
				deleteFrame.dispose();
				
			}
			
		});
		
		deleteFrame.getContentPane().add(deletePanel);
		deleteFrame.setBounds(400,400, 200, 200);
		deleteFrame.setResizable(false);
		deleteFrame.setVisible(true);
	}
	
}
	
