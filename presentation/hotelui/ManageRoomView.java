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
	private JLabel tempLabel;
	
	private JButton manageModifyButton;
	private JButton manageConfirmButton;
	private JButton inputButton;
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
	
	private Vector<HotelVo> vData;
	private Vector<HotelVo> manageData;
	
	private JTable roomTable;
	private JTable manageRoomTable;
	
	private JScrollPane scrollPane;
	
	public ManageRoomView(ManageRoomViewController controller){
		this.controller = controller;
		this.init();
		this.setLayout(null);
	}
	
	
	public void init(){
		scrollPane = new JScrollPane();
		
		manageModifyButton = new JButton("管理");
		manageConfirmButton = new JButton("确定");
		inputButton = new JButton("可用客房");
		inputRoomButton = new JButton("录入");
		deleteRoomButton = new JButton("删除");
		exitButton = new JButton("返回");
		
		serviceTypeJpanel = new JPanel();
		inputButtonJpanel = new JPanel();
		manageButtonJpanel = new JPanel();
		
		
		manageColumns = new Vector<String>();
		manageColumns.add("酒店id");
		manageColumns.add("商圈");
		manageColumns.add("酒店名称");
		manageColumns.add("价格");
		manageColumns.add("使用情况");
		manageColumns.add("入住时间");
		manageColumns.add("预计离开时间");
		manageColumns.add("实际离开时间");
		
		manageData = new Vector<HotelVo>();
//		HotelPo hotelPo1 = new HotelPo(1,"仙林","英尊",false);
//		hotelPo1.setRoomNum(0, 29);
//		hotelPo1.setRoomNum(1, 25);
//		hotelPo1.setRoomNum(2, 18);
//		hotelPo1.setAvailableRoomNum(0, 19);
//		hotelPo1.setAvailableRoomNum(0, 15);
//		hotelPo1.setAvailableRoomNum(0, 6);
//		hotelPo1.setPrice(0, 198);
//		hotelPo1.setPrice(1, 288);
//		hotelPo1.setPrice(2, 328);
//		HotelVo hotelVo1 = new HotelVo(hotelPo1);
//		manageData.add(hotelVo1);
		
		vColumns = new Vector<String>();
		vColumns.add("酒店id");
		vColumns.add("房间号");
		vColumns.add("房间类型");
		vColumns.add("价格");
		vColumns.add("使用情况");
		vColumns.add("入住时间");
		vColumns.add("预计离开时间");
		vColumns.add("实际离开时间");
		
//		vData = new Vector<HotelVo>();
//		RoomPo roomPo = new RoomPo(1,316,"大床房","198","使用中","20161213","20161221","201211111");
//		RoomVo roomVo = new RoomVo(roomPo);
//		vData.add(roomVo);
		
		manageRoomModel = new DefaultTableModel(manageData, manageColumns);
		manageRoomTable = new JTable(manageRoomModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return true;
			}
		};
		manageRoomTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.getViewport().add(manageRoomTable);
		manageRoomTable.setFillsViewportHeight(true);
        manageRoomTable.setEnabled(false);
        
        manageButtonJpanel.add(manageModifyButton);
        manageModifyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				manageRoomTable.setEnabled(true);
			}
        });
        manageButtonJpanel.add(manageConfirmButton);
        manageConfirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				manageRoomTable.setEnabled(false);
			}
        });
        manageButtonJpanel.add(inputButton);
        inputButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.InputButtonClicked();
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
	
	public void InputButtonClicked(){
		
		serviceTypeJpanel.repaint();
		roomModel = new DefaultTableModel(vData, vColumns);
		roomTable = new JTable(roomModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		roomTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.getViewport().add(roomTable);
		roomTable.setFillsViewportHeight(true);
		
        inputButtonJpanel.add(inputRoomButton);
        inputButtonJpanel.add(deleteRoomButton);


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
			public void actionPerformed(ActionEvent e) {
				controller.ExitButtonClicked();
			}
	    });
	    serviceTypeJpanel.add(scrollPane);
	    scrollPane.setBounds(20,80,470,300);
	    serviceTypeJpanel.remove(manageButtonJpanel);
	    serviceTypeJpanel.add(inputButtonJpanel);
	    inputButtonJpanel.setBounds(480,300,250,100);
	    serviceTypeJpanel.validate();
	    this.remove(serviceTypeJpanel);
	    this.add(serviceTypeJpanel);
		serviceTypeJpanel.setBounds(0, 0, 800, 600);
}
	public void InputRoomButtonClicked(){
		final JFrame inputFrame = new JFrame("录入可用客房");
		JPanel inputPanel = new JPanel();
		JLabel label1 = new JLabel("房间号");
		final JTextField field1 = new JTextField(10);
		JLabel label2 = new JLabel("房间类型");
		final JTextField field2 = new JTextField(10);
		JLabel label3 = new JLabel("价格");
		final JTextField field3 = new JTextField(10);
		JButton confirmButton = new JButton("确定");
		inputPanel.add(label1);
		inputPanel.add(field1);
		inputPanel.add(label2);
		inputPanel.add(field2);
		inputPanel.add(label3);
		inputPanel.add(field3);
		inputPanel.add(confirmButton);
		confirmButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				RoomPo inputRoomPo = new RoomPo(1,1,"1","1","1","1","1","1");
				inputRoomPo.setRoomNum(Integer.parseInt(field1.getText()));
				inputRoomPo.setRoomCategory(field2.getText());
				inputRoomPo.setPrice(field3.getText());
				RoomVo inputRoomVo = new RoomVo(inputRoomPo);
				roomModel.addRow(inputRoomVo);
				inputFrame.dispose();
			}
			
		});
		
		inputFrame.getContentPane().add(inputPanel);
		inputFrame.setBounds(400,400, 200, 200);
		inputFrame.setResizable(false);
		inputFrame.setVisible(true);
		
	}


	public void DeleteRoomButtonClicked(){
//		final JFrame deleteFrame = new JFrame("删除可用客房");
//		JPanel deletePanel = new JPanel();
//		JLabel label1 = new JLabel("房间号");
//		final JTextField field1 = new JTextField(10);
//		JButton confirmButton = new JButton("确定");
//		deletePanel.add(label1);
//		deletePanel.add(field1);
//		deletePanel.add(confirmButton);
//		confirmButton.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
				int index = roomTable.getSelectedRow();
				roomModel.removeRow(index);
				
//			}
			
//		});
	}
	public void ExitButtonClicked(){
		
	}
	
}
	
