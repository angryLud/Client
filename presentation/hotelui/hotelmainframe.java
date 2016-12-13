package presentation.hotelui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by huihantao on 2016/12/13.
 */
public class hotelmainframe extends JPanel{

    private JLabel label;
    private JButton back;
    private JTextArea profile;
    private JLabel guanli;
    private JButton gerenxinxi;
    private JButton chaxunjiudian;
    private JButton chaxundingdan;
    private JButton dingdanguanli;
    private ImageIcon img;
    private JLabel imgLabel;
    private mainframecontroller hotelcon;

    public hotelmainframe(mainframecontroller hotelcon){
        this.hotelcon=hotelcon;
        this.init();

    }

    private void init(){

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


        gerenxinxi=new JButton("酒店信息");
        gerenxinxi.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,20));
        gerenxinxi.setBounds(340,250,100,100);
        this.add(gerenxinxi);

        chaxundingdan=new JButton("订单管理");
        chaxundingdan.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,20));
        chaxundingdan.setBounds(340,370,100,100);
        this.add(chaxundingdan);

        chaxundingdan=new JButton("客房管理");
        chaxundingdan.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,20));
        chaxundingdan.setBounds(460,250,100,100);
        this.add(chaxundingdan);

        dingdanguanli=new JButton("促销策略");
        dingdanguanli.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,20));
        dingdanguanli.setBounds(460,370,100,100);
        this.add(dingdanguanli);


    }
}

