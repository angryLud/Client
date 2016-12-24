package presentation.controller;

import presentation.hotelui.HotelStrategyView;
import presentation.hotelui.HotelStrategyViewController;
import presentation.hotelui.ManageHotelInfoView;
import presentation.hotelui.ManageHotelInfoViewController;
import presentation.hotelui.ManageOrderView;
import presentation.hotelui.ManageOrderViewController;
import presentation.hotelui.ManageRoomView;
import presentation.hotelui.ManageRoomViewController;
import presentation.hotelui.hotelmainframe;
import presentation.hotelui.mainframecontroller;
import presentation.login.login;
import presentation.login.logincontroller;
import presentation.manageui.ManageView;
import presentation.manageui.ManageViewControllerService;
import presentation.promotionui.*;
import presentation.signup.signup;
import presentation.signup.signupcontroller;
import presentation.userui.*;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * Created by huihantao on 2016/11/17.
 */
public class controller {
    private JPanel view;
    private logincontroller logcon;
    private signupcontroller signupcon;
    private usercontroller usercon;
    private JFrame frame;
    private ManageViewControllerService managecon;
    private mainframecontroller hotelcon;
    private ManageViewControllerService manageViewController;



    public controller(JFrame frame){
        this.frame=frame;
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);


            }
        });
        this.login();


    }
    public void login(){
        frame.getContentPane().removeAll();
        frame.repaint();


        logcon=new logincontrollerimpl();
        this.view=new login(logcon);
        frame.getContentPane().add(this.view);
        frame.setVisible(true);
        logcon.setcon(this);
        logcon.setview((login) this.view);

    }


// decision
    public void loggedin(String id){
        if (id.substring(0,1).equals("0")){

            usercon=new usercontrollerimpl(Integer.parseInt(id));
            frame.getContentPane().removeAll();
            frame.repaint();
            this.view=new user(usercon);
            usercon.setcon(this);
            frame.getContentPane().add(this.view);
            frame.setVisible(true);
            usercon.setView((user) this.view);
            return;
        }

        if (id.substring(0,1).equals("1")){

            hotelcon =new hotelcontroller("1");
            frame.getContentPane().removeAll();
            frame.repaint();
            this.view=new hotelmainframe(hotelcon);
            hotelcon.setcon(this);
            frame.getContentPane().add(this.view);
            frame.setVisible(true);
            return;
        }

        if (id.substring(0,1).equals("2")){

            manageViewController =new ManageViewControllerImpl(Integer.parseInt(id));
            frame.getContentPane().removeAll();
            frame.repaint();
            this.view=new ManageView(manageViewController);
            manageViewController.setcon(this);
            manageViewController.setView((ManageView)this.view);
            frame.getContentPane().add(this.view);
            frame.setVisible(true);
            return;
        }
        if (id.substring(0,1).equals("3")){
//            Date date=new Date();

            PromotionController promotionCon=new PromotionControllerimpl(Integer.parseInt(id));
            frame.getContentPane().removeAll();
            frame.repaint();
            this.view=new Promotion(promotionCon);
            promotionCon.setcon(this);
            promotionCon.setView((Promotion)this.view);
            frame.getContentPane().add(this.view);
            frame.setVisible(true);
            return;
        }








    }

    public void signup(){

        frame.getContentPane().removeAll();
        frame.repaint();


        signupcon=new signupcontrollerimpl();

        this.view=new signup(signupcon);
        frame.getContentPane().add(this.view);
        frame.setVisible(true);
        signupcon.setview((signup) this.view);
        signupcon.setcon(this);

    }
    
    public void ManageHotelInfo(){
    	frame.getContentPane().removeAll();
        frame.repaint();


        ManageHotelInfoViewController hotelController=new ManageHotelInfoViewControllerImpl(1);

        this.view=new ManageHotelInfoView(hotelController);
        frame.getContentPane().add(this.view);
        frame.setVisible(true);
        hotelController.setView((ManageHotelInfoView) this.view);

        hotelController.setcon(this);
    }
    public void ManageOrder(){
      	frame.getContentPane().removeAll();
        frame.repaint();


        ManageOrderViewController hotelController=new ManageOrderViewControllerImpl(1);

        this.view=new ManageOrderView(hotelController);
        frame.getContentPane().add(this.view);
        frame.setVisible(true);
        hotelController.setView((ManageOrderView) this.view);

        hotelController.setcon(this);
    }
    public void ManageRoom(){
    	frame.getContentPane().removeAll();
        frame.repaint();


        ManageRoomViewController hotelController=new ManageRoomViewControllerImpl(1);

        this.view=new ManageRoomView(hotelController);
        frame.getContentPane().add(this.view);
        frame.setVisible(true);
        hotelController.setView((ManageRoomView) this.view);

        hotelController.setcon(this);
    }
    public void HotelStrategy(){
    	frame.getContentPane().removeAll();
        frame.repaint();


        HotelStrategyViewController hotelController=new HotelStrategyViewControllerImpl(1);

        this.view=new HotelStrategyView(hotelController);
        frame.getContentPane().add(this.view);
        frame.setVisible(true);
        hotelController.setView((HotelStrategyView) this.view);

        hotelController.setcon(this);
    }

    public void gerenxinxi(int userid){
        frame.getContentPane().removeAll();
        frame.repaint();


        UserInformationCotroller userinfocon=new UserInformationCotrollerimpl(userid);

        this.view=new UserInformation(userinfocon);
        frame.getContentPane().add(this.view);
        frame.setVisible(true);
        userinfocon.setview((UserInformation) this.view);

        userinfocon.setcon(this);
    }


    public void chexunjiudian(int userid) {
        frame.getContentPane().removeAll();
        frame.repaint();


        SearchHotelController searchhotelcon=new SearchHotelControllerimpl(userid);

        this.view=new SearchHotel(searchhotelcon);
        frame.getContentPane().add(this.view);
        frame.setVisible(true);
        searchhotelcon.setview((SearchHotel) this.view);
        searchhotelcon.setcon(this);
    }

    public void chaxundingdan(int userid) {
        frame.getContentPane().removeAll();
        frame.repaint();


        UserSearchOrderCotroller searchordercon=new UserSearchOrderCotrollerimpl(userid);

        this.view=new UserSearchOrder(searchordercon);
        frame.getContentPane().add(this.view);
        frame.setVisible(true);
        searchordercon.setview((UserSearchOrder) this.view);
        searchordercon.setcon(this);
    }

    public void cuxiaocelue(){
        frame.getContentPane().removeAll();
        frame.repaint();


        PromotionViewControllerService promocon=new PromotionViewControllerImpl();

        this.view=new PromotionView(promocon);
        frame.getContentPane().add(this.view);
        frame.setVisible(true);
        promocon.setView((PromotionView) this.view);
        promocon.setcon(this);
    }
    public void xinyongchongzhi(){
        frame.getContentPane().removeAll();
        frame.repaint();


        CreditChangeViewControllerService crecon=new CreditChangeViewControllerImpl();

        this.view=new CreditChangeView(crecon);
        frame.getContentPane().add(this.view);
        frame.setVisible(true);
        crecon.setView((CreditChangeView) this.view);
        crecon.setcon(this);
    }

    public void liulandingdan(){
        frame.getContentPane().removeAll();
        frame.repaint();


        ChangeOrderViewControllerService chancon=new ChangeOrderViewControllerImpl(1);

        this.view=new ChangeOrderView(chancon);
        frame.getContentPane().add(this.view);
        frame.setVisible(true);
        chancon.setView((ChangeOrderView) this.view);
        chancon.setcon(this);
    }
}