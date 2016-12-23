package presentation.promotionui;

import presentation.controller.ChangeOrderViewControllerImpl;
import vo.OrderVo;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import businesslogic.ChangeOrderServiceImpl;
import businesslogicservice.ChangeOrderService;


public class ChangeOrderView extends JPanel{
	
//	public static void main(String args[]){
//		JFrame changeOrderFrame = new JFrame();
//		changeOrderFrame.setSize(800,600);
//		changeOrderFrame.setLocation(300, 100);
//		changeOrderFrame.setTitle("更改异常订单状态");
//		int hotelId = 1; 
//		ChangeOrderViewControllerService controller = new ChangeOrderViewControllerImpl(hotelId);
//		ChangeOrderView view = new ChangeOrderView(controller);
//		controller.setView(view);
//		changeOrderFrame.getContentPane().add(view);
//		changeOrderFrame.setVisible(true);
//	}
	
	private ChangeOrderViewControllerService controller;
	
	private JTable orderTable;
	
	private int hotelId;
	
	private DefaultTableModel orderListModel;
	
	private JButton changeButton;
	
	private JButton returnButton;
	
	public ChangeOrderView(ChangeOrderViewControllerService controller){
		this.controller = controller;
		this.hotelId = controller.getHotelId();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	
		initButtons();
		
		initChangeOrderScene();
		
		this.validate();
	}
	
	public void initButtons(){
		changeButton = new JButton("更改状态");
		changeButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				controller.changeButtonClicked();
			}
		});
		
		returnButton = new JButton("返回");
		returnButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0){
				controller.returnButtonClicked();
			}
		});
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(changeButton);
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel2.add(returnButton);
		panel3.setLayout(new GridLayout(1,2));
		panel3.add(panel1);
		panel3.add(panel2);
		changeButton.setEnabled(true);
		returnButton.setEnabled(true);
		
		this.add(panel3);
	}
	
	public void initChangeOrderScene(){
		JScrollPane scrollPane = new JScrollPane();
		
		//表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("订单id");
		vColumns.add("用户id");
		vColumns.add("酒店id");
		vColumns.add("订单创建时间");
		vColumns.add("用户入住时间");
		vColumns.add("最晚执行时间");
		vColumns.add("用户退房时间");
		vColumns.add("订单状态");
		vColumns.add("房间样式");
		vColumns.add("房间数量");
		
		//数据
		Vector<OrderVo> vData = new Vector<OrderVo>();
		vData.addAll(controller.getAbnormalOrder(hotelId));
		//模型
		orderListModel = new DefaultTableModel(vData,vColumns);
		//表格
		orderTable = new JTable(orderListModel){

			public boolean isCellEditable(int row,int column){
				return false;
			}
		};
		orderTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
		scrollPane.getViewport().add(orderTable);
		orderTable.setFillsViewportHeight(true);
		this.add(scrollPane);	
	}
	
	public void changeButtonClicked(){
		int index = orderTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(null,"请选择订单","",JOptionPane.ERROR_MESSAGE);
		}
		int orderid = (int) orderTable.getValueAt(index, 0);
		ChangeOrderService changeOrderService = new ChangeOrderServiceImpl(orderid);
		if(changeOrderService.updateOrder(orderid)){
			JOptionPane.showMessageDialog(null,"更改成功","",JOptionPane.ERROR_MESSAGE);
			orderTable.remove(index);
		}
	}
	
	

}
