package presentation.hotelui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

import po.OrderPo;
import vo.OrderVo;

public class ManageOrderView extends JPanel{
	
	private int HotelID;
	private ManageOrderViewController controller;
	
	private JButton orderBrowseButton;
	private JButton orderSearchButton;
	private JButton executingButton;
	private JButton executeButton;
	private JButton exitButton;
	
	private JLabel tempLabel;
	
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
		this.setLayout(null);
	}
	
	public void init(){
		//组件
		scrollPane = new JScrollPane();
		tempLabel = new JLabel("                                                        ");
		executeLabel1 = new JLabel("输入订单号");
		executeField1 = new JTextField(10);
		executingButton = new JButton("执行");
		orderBrowseButton = new JButton("浏览");
		orderSearchButton = new JButton("搜索");
		executeButton = new JButton("执行订单");
		executingButton = new JButton("执行");
		exitButton = new JButton("返回");
		
		serviceTypeJpanel = new JPanel();
		searchButtonJpanel = new JPanel();
		executeJpanel = new JPanel();
		
		searchColumns = new Vector<String>();
		searchColumns.add("订单号");
		searchColumns.add("房间号");
		searchColumns.add("酒店id");
		searchColumns.add("创建时间");
		searchColumns.add("执行时间");
		searchColumns.add("延迟时间");
		searchColumns.add("入住时间");
		searchColumns.add("价格");
		searchColumns.add("执行情况");
		
		searchData = new Vector<OrderVo>();
		OrderPo orderPo = new OrderPo(1,2,20161203,20161205,20161205,20161208,198,1,"大床房",316);
		OrderVo orderVo = new OrderVo(orderPo);
		searchData.add(orderVo);
		
		executeColumns = new Vector<String>();
		executeColumns.add("订单号");
		executeColumns.add("房间号");
		executeColumns.add("酒店id");
		executeColumns.add("创建时间");
		executeColumns.add("执行时间");
		executeColumns.add("延迟时间");
		executeColumns.add("入住时间");
		executeColumns.add("价格");
		executeColumns.add("执行情况");
		
		executeData = new Vector<OrderVo>();
		OrderPo orderPo2 = new OrderPo(1,2,20161203,20161205,20161205,20161208,198,1,"大床房",316);
		OrderVo orderVo2 = new OrderVo(orderPo2);
		executeData.add(orderVo2);
		
		
	    //界面内容
		searchOrderModel = new DefaultTableModel(searchData, searchColumns);
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
			public void actionPerformed(ActionEvent e) {
				controller.OrderBrowseButtonClicked();
			}
		});
		searchButtonJpanel.add(orderSearchButton);
		orderSearchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.OrderSearchButtonClicked();
			}
		});
		searchButtonJpanel.add(executeButton);
		executeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				  controller.ExecuteButtonClicked();
			}
		});
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				controller.ExitButtonClicked();
			}
		});
		    serviceTypeJpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		    serviceTypeJpanel.add(tempLabel);
		    serviceTypeJpanel.add(exitButton);
			serviceTypeJpanel.add(scrollPane);
			serviceTypeJpanel.add(searchButtonJpanel);
			
			this.add(serviceTypeJpanel);
			serviceTypeJpanel.setBounds(0, 0, 800, 600);
		   
	}
	public void OrderBrowseButtonClicked(){
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
		serviceTypeJpanel.repaint();
		executeOrderModel = new DefaultTableModel(executeData, executeColumns);
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
	    serviceTypeJpanel.remove(searchButtonJpanel);
		serviceTypeJpanel.add(executeJpanel);
		serviceTypeJpanel.add(scrollPane);
		serviceTypeJpanel.validate();
}
	
	public void ExecutingButtonClicked(){
		
		int orderID = Integer.parseInt(executeField1.getText());
		if(controller.executeOrder(orderID)){
			JOptionPane.showMessageDialog(null, "执行成功！");
		}
		else{
			JOptionPane.showMessageDialog(null, "订单不存在或被撤销！");
		}
	}
}
