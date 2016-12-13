package presentation.hotelui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import vo.OrderVo;

public class ManageOrderView {
	
	private int HotelID;
	private ManageOrderViewController controller;
	
	private JButton orderBrowseButton;
	private JButton orderSearchButton;
	private JButton executingButton;
	private JButton executeCreditButton;
	private JButton executeButton;
	
	private JTextField executeField1;
	
	private JLabel executeLabel1;
	
	private JPanel serviceTypeJpanel;
	private JPanel searchButtonJpanel;
	private JPanel executeJpanel;
	
	private JTable searchOrderTable;
	private JTable executeOrderTable;
	
	private Vector<String> searchColumns;
	private Vector<String> executeColumns;
	
	private Vector<OrderVo> searchData;
	private Vector<OrderVo> executeData;
	
	private DefaultTableModel searchOrderModel;
	private DefaultTableModel executeOrderModel;
	
	private JScrollPane scrollPane;
	
	public ManageOrderView(ManageOrderViewController controller){
		this.controller = controller;
		this.init();
	}
	
	public void init(){

		searchOrderModel = new DefaultTableModel(searchData, searchColumns);
		//���
		searchOrderTable = new JTable(searchOrderModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		searchOrderTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.getViewport().add(searchOrderTable);
		searchOrderTable.setFillsViewportHeight(true);
		
		searchButtonJpanel.add(orderBrowseButton);
		orderBrowseButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				OrderBrowseButtonClicked();
				
			}
			
		});
		searchButtonJpanel.add(orderSearchButton);
		orderSearchButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				OrderSearchButtonClicked();
				
			}
			
		});
		searchButtonJpanel.add(executeButton);
		
			serviceTypeJpanel.add(scrollPane);
			serviceTypeJpanel.add(searchButtonJpanel);
		   
	}
	public void OrderBrowseButtonClicked(){
//		controller.OrderBrowseButtonClicked();
		List<OrderVo> list = controller.getAllOrders(HotelID);
		for(OrderVo orderVo:list){
			searchOrderModel.addRow(orderVo);
		}
	}

	public void OrderSearchButtonClicked(){
		final JFrame searchFrame = new JFrame("搜索订单");
		JPanel searchPanel = new JPanel();
		JLabel searchLabel = new JLabel("输入订单号");
		final JTextField searchfield = new JTextField(10);
		JButton confirmButton = new JButton("确定");
		searchPanel.add(searchLabel);
		searchPanel.add(searchfield);
		searchPanel.add(confirmButton);
		confirmButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int orderid = Integer.parseInt(searchfield.getText());
				OrderVo orderVo = controller.searchOrder(orderid);
				searchOrderModel.setRowCount(0);
				searchOrderModel.addRow(orderVo);	
			}
		});
		
		searchFrame.getContentPane().add(searchPanel);
		searchFrame.setBounds(400,400, 200, 200);
		searchFrame.setResizable(false);
		searchFrame.setVisible(true);
	}
	public void ExecuteButtonClicked(){
		executeOrderModel = new DefaultTableModel(executeData, executeColumns);
		//���
		executeOrderTable = new JTable(executeOrderModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		executeOrderTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.getViewport().add(executeOrderTable);
		executeOrderTable.setFillsViewportHeight(true);
	
	
	    executeJpanel.add(executeLabel1);
	    executeJpanel.add(executeField1);

	    executeJpanel.add(executingButton);
	    executingButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ExecutingButtonClicked();
				
			}
	    	
	    });
		serviceTypeJpanel.add(executeJpanel);
		serviceTypeJpanel.add(scrollPane);
}
	public void ExecutingButtonClicked(){
		
		int orderID = Integer.parseInt(executeField1.getText());
		if(controller.executeOrder(orderID)){
			JOptionPane.showMessageDialog(null, "执行成功！");
		}
		else{
			JOptionPane.showMessageDialog(null, "订单已执行或被撤销！");
		}
	}
}
