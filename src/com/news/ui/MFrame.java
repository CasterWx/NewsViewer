package com.news.ui;

import com.news.bean.NewsBean;
import com.news.util.ChooseNet;
import com.news.util.NewsUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-24-10:48
 */
public class MFrame extends JFrame {
    public Label label_come = new Label();
    public Label label_out = new Label();
    public Label label_title = new Label();
    public Label label_desc = new Label();
    public Label label_time = new Label();
    public Label label_gs = new Label();
    public Label label_get = new Label();
    public NewsBean newsBean = new NewsBean();
    public MFrame(String title){
        this.setTitle(title);
        this.setLayout(null);
        this.setResizable(false);
        initButton();
        this.setBounds(400,200,500,700);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void initButton(){
        // out lable
        label_out.setText("URL:");
        label_out.setBounds(20,20,30,50);
        label_out.setFont(new Font("宋体", Font.PLAIN, 13));
        this.add(label_out);
        label_come.setText("来源");
        label_come.setBounds(20,70,30,50);
        label_come.setFont(new Font("宋体", Font.PLAIN, 13));
        this.add(label_come);
        label_title.setText("标题");
        label_title.setBounds(20,120,30,50);
        label_title.setFont(new Font("宋体", Font.PLAIN, 13));
        this.add(label_title);
        label_desc.setText("摘要");
        label_desc.setBounds(20,170,30,50);
        label_desc.setFont(new Font("宋体", Font.PLAIN, 13));
        this.add(label_desc);
        label_time.setText("时间");
        label_time.setBounds(20,290,30,50);
        label_time.setFont(new Font("宋体", Font.PLAIN, 13));
        this.add(label_time);
        label_gs.setText("格式选择");
        label_gs.setBounds(20,340,30,50);
        label_gs.setFont(new Font("宋体", Font.PLAIN, 13));
        this.add(label_gs);
        label_get.setText("文本导出");
        label_get.setBounds(20,390,30,50);
        label_get.setFont(new Font("宋体", Font.PLAIN, 13));
        this.add(label_get);

        // out file name
        final JTextField jTextField = new JTextField();
        jTextField.setFont(new Font("宋体", Font.PLAIN, 13));
        jTextField.setBounds(70,30,300,30);
        this.add(jTextField);

        final JTextField jTextCome = new JTextField();
        jTextCome.setFont(new Font("宋体", Font.PLAIN, 13));
        jTextCome.setBounds(70,80,300,30);
        this.add(jTextCome);

        final JTextField jTextTitle = new JTextField();
        jTextTitle.setFont(new Font("宋体", Font.PLAIN, 13));
        jTextTitle.setBounds(70,130,300,30);
        this.add(jTextTitle);

        final JTextArea jTextDesc = new JTextArea();
        jTextDesc.setLineWrap(true);
        jTextDesc.setWrapStyleWord(true);
        JScrollPane jScrollPane1 = new JScrollPane(jTextDesc) ;
        jScrollPane1.setFont(new Font("宋体", Font.PLAIN, 13));
        jScrollPane1.setBounds(70,180,300,100);
        this.add(jScrollPane1);

        final JTextField jTextTime = new JTextField();
        jTextTime.setFont(new Font("宋体", Font.PLAIN, 13));
        jTextTime.setBounds(70,300,300,30);
        this.add(jTextTime);

        final JTextArea jTextGet = new JTextArea();
        jTextGet.setLineWrap(true);
        jTextGet.setWrapStyleWord(true);
        JScrollPane jScrollPane = new JScrollPane(jTextGet) ;
        jScrollPane.setBounds(70,410,300,240);
        jScrollPane.setFont(new Font("宋体", Font.PLAIN, 13));
        this.add(jScrollPane);

        Button choose1 = new Button("格式一");
        choose1.setBounds(70,350,90,30);
        choose1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newsBean.url = jTextField.getText();
                newsBean.title = jTextTitle.getText();
                newsBean.come = jTextCome.getText();
                newsBean.comment = jTextDesc.getText();
                newsBean.time = jTextTime.getText();
                String outText = NewsUtil.getStatusOne(newsBean);
                jTextGet.setText(outText);
                Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable tText = new StringSelection(outText);
                clip.setContents(tText, null);
            }
        });
        this.add(choose1);
        Button choose2 = new Button("格式二");
        choose2.setBounds(170,350,90,30);
        choose2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newsBean.url = jTextField.getText();
                newsBean.title = jTextTitle.getText();
                newsBean.come = jTextCome.getText();
                newsBean.comment = jTextDesc.getText();
                newsBean.time = jTextTime.getText();
                String outText = NewsUtil.getStatusTwo(newsBean);
                jTextGet.setText(outText);
                Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable tText = new StringSelection(outText);
                clip.setContents(tText, null);
            }
        });
        this.add(choose2);
        Button choose3 = new Button("格式三");
        choose3.setBounds(270,350,90,30);
        choose3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newsBean.url = jTextField.getText();
                newsBean.title = jTextTitle.getText();
                newsBean.come = jTextCome.getText();
                newsBean.comment = jTextDesc.getText();
                newsBean.time = jTextTime.getText();
                String outText = NewsUtil.getStatusThree(newsBean);
                jTextGet.setText(outText);
                Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable tText = new StringSelection(outText);
                clip.setContents(tText, null);
            }
        });
        this.add(choose3);
        Button copy = new Button("复制");
        copy.setBounds(380,410,90,30);
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable tText = new StringSelection(jTextGet.getText());
                clip.setContents(tText, null);
            }
        });
        this.add(copy);
        // get word
        Button getword = new Button("查看");
        getword.setBounds(380,30,90,30);
        getword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextTitle.setText("");
                jTextCome.setText("");
                jTextDesc.setText("");
                jTextGet.setText("");
                jTextTime.setText("");
                String outFileName = jTextField.getText() ;
                outFileName = outFileName.replace("\n","");
                if (outFileName==null){
                    JFrame frame = new JFrame();
                    frame.setTitle("提示");
                    Label error = new Label("请输入URL");
                    frame.add(error);
                    frame.setBounds(300,300,250,100);
                    frame.setVisible(true);
                }else {
                    try {
                        newsBean = ChooseNet.chooseNet(outFileName) ;
                        jTextCome.setText(newsBean.come);
                        jTextDesc.setText(newsBean.comment.replace(" ","").replace(" ","").replace("　　",""));
                        jTextTitle.setText(newsBean.title);
                        jTextTime.setText(newsBean.time);
                    } catch (Exception e1) {
                        System.out.println(e1);
                        JFrame frame2 = new JFrame();
                        frame2.setTitle("提示");
                        Label error2 = new Label(e1.toString());
                        frame2.add(error2);
                        frame2.setBounds(300,300,250,100);
                        frame2.setVisible(true);
                    }
                }
            }
        });
        this.add(getword);
        Button cls = new Button("清除");
        cls.setBounds(380,450,90,30);
        cls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.setText("");
                jTextTitle.setText("");
                jTextCome.setText("");
                jTextDesc.setText("");
                jTextGet.setText("");
                jTextTime.setText("");
            }
        });
        this.add(cls);
        Button urlopen = new Button("打开");
        urlopen.setBounds(380,70,90,30);
        urlopen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    java.net.URI uri = java.net.URI.create(jTextField.getText());
                    // 获取当前系统桌面扩展
                    java.awt.Desktop dp = java.awt.Desktop.getDesktop();
                    // 判断系统桌面是否支持要执行的功能
                    if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                        // 获取系统默认浏览器打开链接
                        dp.browse(uri);
                    }
                }catch (Exception e1){
                }
            }
        });
        this.add(urlopen);
    }

    @Override
    public void dispose() {
        System.exit(0);
    }
}

