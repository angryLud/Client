package presentation.userui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by huihantao on 2016/11/18.
 */
public class user extends JPanel{
    private usercontroller usercon;

    private JLabel label;
    private JButton back;
    private JTextArea profile;
    private JLabel guanli;
    private JButton gerenxinxi;
    private JButton chaxunjiudian;
    private JButton chaxundingdan;
    private ImageIcon img;
    private JLabel imgLabel;

    public user(usercontroller usercon){
        this.usercon=usercon;

        this.init();

    }

    private void init(){

        this.setLayout(null);
        label=new JLabel("客户",JLabel.LEFT);
        label.setBounds(90,10,800,50);
        label.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,30));
        this.add(label);

        back=new JButton("注销");
        back.setBounds(690,10,100,50);
        back.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,30));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usercon.back( );
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
        profile.setText("姓名："+"\r\n"+usercon.getname());
        this.add(profile);

        guanli=new JLabel("管理页面",JLabel.CENTER);
        guanli.setBounds(190,100,550,70);
        guanli.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,40));
        this.add(guanli);


        gerenxinxi=new JButton("个人信息");
        gerenxinxi.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,20));
        gerenxinxi.setBounds(280,270,180,70);
        gerenxinxi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                usercon.gerenxinxi();
            }
        });
        this.add(gerenxinxi);

        chaxunjiudian=new JButton("查询酒店");
        chaxunjiudian.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,20));
        chaxunjiudian.setBounds(440,370,180,70);
        chaxunjiudian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usercon.chexunjiudian();
            }
        });
        this.add(chaxunjiudian);



        chaxundingdan=new JButton("查询订单");
        chaxundingdan.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,20));
        chaxundingdan.setBounds(600,270,180,70);
        chaxundingdan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usercon.chaxundingdan();
            }
        });
        this.add(chaxundingdan);


    }
}
