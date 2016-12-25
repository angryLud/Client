package main;



import presentation.controller.controller;
import rmi.RemoteHelper;


import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


/**
 * Created by huihantao on 2016/11/16.
 */
public class Main {
    private RemoteHelper remoteHelper;
    public Main(){
        linkToServer();
        initGUI();
    }
    public static void main(String[] args) {
        Main main=new Main();

    }
    private void linkToServer() {
        try {
            remoteHelper = RemoteHelper.getInstance();
            remoteHelper.setRemote(Naming.lookup("rmi://localhost:8888/DataRemoteObject"));
            System.out.println("linked");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
    private void initGUI() {
        JFrame frame = new JFrame("互联网酒店预订系统");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new controller(frame);
    }
}