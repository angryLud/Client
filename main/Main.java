package main;



import presentation.controller.controller;


import javax.swing.*;


/**
 * Created by huihantao on 2016/11/16.
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("互联网酒店预订系统");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new controller(frame);
        System.out.println((int ) 'a');

    }
}