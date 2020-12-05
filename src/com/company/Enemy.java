package com.company;

import java.awt.*;

public class Enemy extends Rectangle {

    private static final long serialVersionUID = 1L;

    public Enemy(int x, int y){
        setBounds(x, y, 32, 32);
    }

    public void tick(){

    }

    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, 32, 32);
    }
}
