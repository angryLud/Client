package presentation.signup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by huihantao on 2016/11/18.
 */

//地址获取需要vo


public class signup extends JPanel{
    private JLabel label;
    private JButton backbutton;
    private JButton confirmbutton;
    private signupcontroller signcon;
    private JComboBox<String> type;


    private JLabel name;
    private JLabel password;
    private JLabel passwordconfirm;
    private JLabel number;
    private JTextField namefield;
    private JPasswordField passwordfield;
    private JPasswordField passwordfieldconfirm;
    private JButton confirm;

    //user
    private JTextField numberfield;

    //hotel
    private JLabel add;
    private JLabel dis;
    private JLabel sta;
    private JLabel descri;
    private JComboBox<String> address;
    private JComboBox<String> district;
    private JComboBox<String> star;
    private JTextArea description;
    private JLabel serv;
    private JTextArea service;






    public signup(signupcontroller signcon){
        this.setLayout(null);
        this.signcon=signcon;
        this.init();
    }
    private void init(){

        type=new JComboBox<>();
        type.addItem("客户");
        type.addItem("酒店");
        type.setBounds(400,20,100,40);
        type.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        this.add(type);


        label=new JLabel("请选择类别",JLabel.RIGHT);
        label.setBounds(270,20,100,40);
        label.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        this.add(label);



        backbutton=new JButton("返回");
        backbutton.setBounds(10,20,100,40);
        backbutton.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signcon.back();
            }
        });
        this.add(backbutton);

        confirmbutton=new JButton("确认");
        confirmbutton.setBounds(600,20,100,40);
        confirmbutton.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        confirmbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signcon.signup((String) type.getSelectedItem());
            }
        });
        this.add(confirmbutton);
    }

    public void usersignup(){
        this.removeAll();
        this.repaint();
        this.revalidate();
        this.init();
        type.setSelectedItem("客户");
        name=new JLabel("姓名",JLabel.RIGHT);
        password=new JLabel("密码",JLabel.RIGHT);
        number=new JLabel("手机号码",JLabel.RIGHT);
        passwordconfirm=new JLabel("请确认您的密码",JLabel.RIGHT);
        passwordconfirm.setBounds(170,260,200,40);
        name.setBounds(270,100,100,40);
        password.setBounds(270,180,100,40);
        number.setBounds(270,340,100,40);
        number.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        password.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        name.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        passwordconfirm.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));


        namefield=new JTextField();
        passwordfield=new JPasswordField();
        passwordfieldconfirm=new JPasswordField();
        numberfield=new JTextField();

        namefield.setBounds(400,100,200,40);
        passwordfield.setBounds(400,180,200,40);
        passwordfieldconfirm.setBounds(400,260,200,40);
        numberfield.setBounds(400,340,200,40);

        confirm=new JButton("确定");
        confirm.setBounds(350,450,100,40);
        confirm.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (signcon.uservalidate(namefield.getText(),passwordfield.getPassword(),passwordfieldconfirm.getPassword(),numberfield.getText()))
                {

                }
                else{
                    signcon.signupfail();
                }
            }
        });
        this.add(confirm);

        this.add(name);
        this.add(password);
        this.add(number);
        this.add(passwordconfirm);
        this.add(namefield);
        this.add(passwordfield);
        this.add(passwordfieldconfirm);
        this.add(numberfield);

        namefield.setFont(new Font("STSongti-SC-Regular",Font.PLAIN,20));
        passwordfieldconfirm.setFont(new Font("STSongti-SC-Regular",Font.PLAIN,20));
        passwordfield.setFont(new Font("STSongti-SC-Regular",Font.PLAIN,20));
        numberfield.setFont(new Font("STSongti-SC-Regular",Font.PLAIN,20));



    }
    public void hotelsignup(){
        this.removeAll();
        this.repaint();
        this.revalidate();
        this.init();
        type.setSelectedItem("酒店");
        name=new JLabel("酒店名称",JLabel.RIGHT);
        password=new JLabel("密码",JLabel.RIGHT);
        passwordconfirm=new JLabel("请确认您的密码",JLabel.RIGHT);
        passwordconfirm.setBounds(0,220,200,40);
        name.setBounds(100,100,100,40);
        password.setBounds(100,160,100,40);
        password.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        name.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        passwordconfirm.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));


        namefield=new JTextField();
        passwordfield=new JPasswordField();
        passwordfieldconfirm=new JPasswordField();

        namefield.setBounds(230,100,200,40);
        passwordfield.setBounds(230,160,200,40);
        passwordfieldconfirm.setBounds(230,220,200,40);


        add=new JLabel("地址",JLabel.RIGHT);
        add.setBounds(100,280,100,40);
        add.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        this.add(add);

        address=new JComboBox<>();
        address.addItem("南京");
        address.setBounds(230,280,200,40);
        address.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        this.add(address);

        dis=new JLabel("商圈",JLabel.RIGHT);
        dis.setBounds(100,340,100,40);
        dis.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        this.add(dis);

        district=new JComboBox<>();
        district.addItem("仙林");
        district.setBounds(230,340,200,40);
        district.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        this.add(district);

        sta=new JLabel("星级",JLabel.RIGHT);
        sta.setBounds(100,400,100,40);
        sta.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        this.add(sta);

        star=new JComboBox<>();
        star.addItem("5");
        star.addItem("4");
        star.addItem("3");
        star.addItem("2");
        star.addItem("1");
        star.setBounds(230,400,200,40);
        star.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        this.add(star);

        descri=new JLabel("描述",JLabel.RIGHT);
        descri.setBounds(420,100,100,40);
        descri.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        this.add(descri);

        description=new JTextArea();
        description.setBounds(550,100,150,150);
        this.add(description);

        serv=new JLabel("设施服务",JLabel.RIGHT);
        serv.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        serv.setBounds(420,300,100,40);
        this.add(serv);

        service=new JTextArea();
        service.setBounds(550,300,150,150);
        this.add(service);

        confirm=new JButton("确定");
        confirm.setBounds(350,460,100,40);
        confirm.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,18));
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(confirm);

        this.add(name);
        this.add(password);
        this.add(passwordconfirm);
        this.add(namefield);
        this.add(passwordfield);
        this.add(passwordfieldconfirm);

        namefield.setFont(new Font("STSongti-SC-Regular",Font.PLAIN,20));
        passwordfield.setFont(new Font("STSongti-SC-Regular",Font.PLAIN,20));
        passwordfieldconfirm.setFont(new Font("STSongti-SC-Regular",Font.PLAIN,20));
        service.setFont(new Font("STSongti-SC-Regular",Font.PLAIN,20));
        description.setFont(new Font("STSongti-SC-Regular",Font.PLAIN,20));



    }
    public void signupfail(){
        JOptionPane.showMessageDialog(null, "您输入信息有误，注册失败","", JOptionPane.ERROR_MESSAGE);
        namefield.setText("");
        passwordfield.setText("");
        passwordfieldconfirm.setText("");
//        service.setText("");
//        description.setText("");
        numberfield.setText("");

    }



}
