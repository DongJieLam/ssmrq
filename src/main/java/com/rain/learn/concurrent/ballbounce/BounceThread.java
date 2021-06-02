package com.rain.learn.concurrent.ballbounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 单线程的小球弹跳例子
 * 缺点：小球运动未结束前，点击close按钮是点不了的。必须等到小球运行完成才能执行关闭操作
 *      性能就非常糟糕，不能中断操作。
 */
public class BounceThread {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setTitle("BounceThread");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

   static class BounceFrame extends JFrame{
        private BallComponent comp;
        public static final int STEPS = 1000;
        public static final int DELAY = 3;

        public BounceFrame(){
            setTitle("Bounce");
            comp = new BallComponent();
            add(comp, BorderLayout.CENTER);
            JPanel buttonPanel = new JPanel();
            addButton(buttonPanel, "Start",event -> addBall());
            addButton(buttonPanel, "Close", event -> System.exit(0));
            add(buttonPanel, BorderLayout.SOUTH);
            pack();

        }

        public void addButton(Container c, String title, ActionListener listener){
            JButton button = new JButton(title);
            c.add(button);
            button.addActionListener(listener);
        }

        public void addBall(){

                Ball ball = new Ball();
                comp.add(ball);
                //这里将移动球的逻辑放在线程里去做
                Runnable r = () -> {
                    try {
                        for (int i = 0; i < STEPS; i++) {
                            ball.move(comp.getBounds());
                            comp.repaint();
                            Thread.sleep(DELAY);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
                Thread t = new Thread(r);
                t.start();
        }
    }
}
