package presentation.hotelui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import po.RoomPo;
import vo.RoomVo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ManageRoomView extends JPanel{
	
	private ManageRoomViewController controller;
	
	private JButton manageModifyButton;
	private JButton inputButton;
	private JButton inputRoomButton;
	private JButton deleteRoomButton;
	
	private JPanel manageButtonJpanel;
	private JPanel serviceTypeJpanel;
	private JPanel inputButtonJpanel;
	
	private DefaultTableModel roomModel;
	private DefaultTableModel manageRoomModel;
	
	private Vector<String> vColumns;
	private Vector<String> manageColumns;
	
	private Vector<RoomVo> vData;
	private Vector<RoomVo> manageData;
	
	private JTable roomTable;
	private JTable manageRoomTable;
	
	private JScrollPane scrollPane;
	
	public ManageRoomView(ManageRoomViewController controller){
		this.controller = controller;
		this.init();
	}
	
	
	public void init(){
		manageRoomModel = new DefaultTableModel(manageData, manageColumns);
		//���
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

			@Override
			public void actionPerformed(ActionEvent e) {
				manageRoomTable.setEnabled(true);
				
			}
        	
        });
        manageButtonJpanel.add(inputButton);
        
	serviceTypeJpanel.add(scrollPane);
	serviceTypeJpanel.add(manageButtonJpanel);
	}
	
	public void InputButtonClicked(){
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

	@Override
	public void actionPerformed(ActionEvent e) {
		InputRoomButtonClicked();
		
	}
	
});
deleteRoomButton.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent e) {
		DeleteRoomButtonClicked();
		
	}

});
serviceTypeJpanel.add(scrollPane);
serviceTypeJpanel.add(inputButtonJpanel);

scrollPane.setVisible(true);
inputButtonJpanel.setVisible(true);

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
	
}
	
