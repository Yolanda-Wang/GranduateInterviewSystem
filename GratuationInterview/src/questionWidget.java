import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

import javax.swing.*;

public class questionWidget {
    public static MulticastSocket msr = null;
    public static InetAddress group;
    public static void main(String[] args) {
        questionWidget w1=new questionWidget();
    }
    public questionWidget() {
        //初始化一个jframe
        JFrame frame = new JFrame("学生端");

        //初始化一个panel
        JPanel panel = new JPanel();

        //初始化一个容器
        Container container = frame.getContentPane();


        JLabel label5=new JLabel("题目信息：");
        label5.setBounds(50,30,100,25);
        label5.setFont(new Font("",Font.PLAIN,16));
        JTextArea label6=new JTextArea();
        //label9.setSize(5000,5000);
        label6.setLineWrap(true);
        label6.setBounds(80,60,450,300);
        label6.setFont(new Font("",Font.PLAIN,16));

        panel.add(label5);
        panel.add(label6);
        label6.setText("综合面试其实主要考察考生的综合素质。包括考生本科期间的科研能力、知识结构、计算机操作能力、外语能力和应变能力等，在回答的时候并不要求十分精准的答案，但是要求考生流畅清楚以及有逻辑性的陈述。所以在综合面试之前相关信息的搜集、知识点的储备、以及勤加练习都是必不可少的。");
        panel.setLayout(null);

        //把panel添加到容器
        container.add(panel);


        //设置关闭方式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //设置大小
        frame.setSize(600,500);

        //设置位置
        frame.setLocation(100, 100);

        //设置可见性
        frame.setVisible(true);
        try {
            group = InetAddress.getByName("224.0.0.1");//组播地址
            int port = 8888;
            msr = new MulticastSocket(port);
            msr.joinGroup(group);//加入连接
            byte[] buffer = new byte[8192];
            System.out.println("接收数据包启动！(启动时间: "+new Date()+")");
            //建立一个指定缓冲区大小的数据包
            while (true) {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                msr.receive(dp);
                String s = new String(dp.getData(),0,dp.getLength());
                //解码组播数据包
                System.out.println(s);
                label6.setText(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(msr!=null){
                try {
                    msr.leaveGroup(group);
                    msr.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                }
            }
        }
    }
}
