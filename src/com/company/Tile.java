package com.company;

import java.awt.*;

public class Tile extends Rectangle {
    public Tile(int x, int y){
        setBounds(x, y, 32, 32);
    }

    public void render(Graphics g){
        g.setColor(new Color(1,12,252));
        g.fillRect(x, y, width, height);
    }
}