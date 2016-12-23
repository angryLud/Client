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
    private signupcontroller signcon;


    private JLabel name;
    private JLabel password;
    private JLabel passwordconfirm;
    private JLabel number;
    private JTextField namefield;
    private JPasswordField passwordfield;
    private JPasswordField passwordfieldconfirm;
    private JButton confirm;

    private JTextField numberfield;

    public signup(signupcontroller signcon){
        this.setLayout(null);
        this.signcon=signcon;
        this.usersignup();
    }


    private void usersignup(){


        label=new JLabel("注册");
        label.setBounds(380,20,100,50);
        label.setFont(new Font("STXingkaiSC-Light",Font.BOLD,25));
        this.add(label);


        backbutton=new JButton("返回");
        backbutton.setBounds(680,20,100,40);
        this.add(backbutton);
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signcon.back();
            }
        });


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
                    String name=namefield.getText();
                    char[] password=passwordfield.getPassword();
                    String number=numberfield.getText();
                    int id=signcon.signup(name,password,number);
                    if (id==0)  JOptionPane.showMessageDialog(null, "注册失败","", JOptionPane.ERROR_MESSAGE);
                    else
                    JOptionPane.showMessageDialog(null, "您的id是"+id+"  请务必记住！！！");
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

    public void signupfail(){
        JOptionPane.showMessageDialog(null, "您输入信息有误，注册失败","", JOptionPane.ERROR_MESSAGE);
        namefield.setText("");
        passwordfield.setText("");
        passwordfieldconfirm.setText("");
        numberfield.setText("");

    }



}
