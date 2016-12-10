package presentation.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by huihantao on 2016/11/16.
 */

// 登录验证需要vo
public class login extends JPanel {
    private JTextField name;
    private JPasswordField password;
    private JLabel label1;
    private JLabel label2;
    private JLabel label;
    private logincontroller logcon;
    private JButton button1;
    private JButton button2;


    public login(logincontroller logcon) {
        this.logcon=logcon;
        this.setLayout(null);
        this.initlabel();
    }

    private void initlabel() {
        //label
        label=new JLabel("登录",JLabel.CENTER);
        label.setBounds(290,65,220,80);
        label.setBorder(BorderFactory.createLineBorder(Color.black,3));
        label.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,60));
        label.setOpaque(true);
        label.setBackground(new Color(200,200,200));
        this.add(label);




        //label1 用户名
        label1 = new JLabel("用户名");
        label1.setBounds(150, 200, 120, 45);
        label1.setBorder(BorderFactory.createLineBorder(Color.black,3));
        label1.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,35));
        label1.setOpaque(true);
        label1.setBackground(new Color(200,200,200));
        this.add(label1);

        //label2 密码
        label2 = new JLabel(" 密码");
        label2.setBounds(150, 300, 120, 45);
        label2.setBorder(BorderFactory.createLineBorder(Color.black,3));
        label2.setOpaque(true);
        label2.setBackground(new Color(200,200,200));
        label2.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,35));
        this.add(label2);


        name = new JTextField();
        name.setBounds(380, 200, 250, 45);
        name.setBorder(BorderFactory.createLineBorder(Color.black,3));
        name.setFont(new Font("STSongti-SC-Regular",Font.PLAIN,35));
        this.add(name);


        password = new JPasswordField();
        password.setBounds(380, 300, 250, 45);
        password.setBorder(BorderFactory.createLineBorder(Color.black,3));
        password.setFont(new Font("STSongti-SC-Regular",Font.PLAIN,35));
        this.add(password);


        button1 = new JButton("登录");
        button1.setBounds(200, 400, 170, 50);
//        button.setBorder(BorderFactory.createLineBorder(Color.black,3));
        button1.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,35));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             if(  logcon.login(name.getText(),password.getPassword())){
                 logcon.loginsuccess(name.getText());
             }else{
                logcon.loginfail();
             }
            }
        });
        this.add(button1);


        button2 = new JButton("注册");
        button2.setBounds(430, 400, 170, 50);
//        button.setBorder(BorderFactory.createLineBorder(Color.black,3));
        button2.setFont(new Font("STXingkaiSC-Light",Font.PLAIN,35));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               logcon.signup();
            }
        });
        this.add(button2);

    }


    public void loginfail(){
        name.setText("");
        password.setText("");
        JOptionPane.showMessageDialog(null, "登录失败","", JOptionPane.ERROR_MESSAGE);
    }
}
