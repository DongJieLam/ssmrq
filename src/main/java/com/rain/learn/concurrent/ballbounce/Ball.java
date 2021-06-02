package com.rain.learn.concurrent.ballbounce;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;


public class Ball {

    private static final int XSIZE = 10;
    private static final int YSIZE = 10;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    /**
     * 移动球到下一位置，如果碰到边缘就反弹
     * @param bounds
     */
    public void move(Rectangle2D bounds){
        x += dx;
        y += dy;
        if(x < bounds.getMinX()){
            x = bounds.getMinX();
            dx = -dx;
        }
        if(x+XSIZE > bounds.getMaxX()){
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if(y < bounds.getMinY()){
            y = bounds.getMinY();
            dy = -dy;
        }
        if(y > bounds.getMaxY()){
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    /**
     * 获取当前位置的球
     * x-矩形左上角的x坐标
     * y-矩形左上角的y坐标
     * XSIZE-矩形的宽
     * YSIZE-矩形的高
     * @return
     */
    public Ellipse2D getShape(){
        return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
    }

}
