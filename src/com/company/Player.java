package com.company;

import java.awt.*;

public class Player extends Rectangle {

    private static final long serialVersionUID = 1L;

    public boolean right, left, up, down;
    private int speed = 4;

    public Player(int x, int y){
        setBounds(x, y, 32, 32);
    }

    public void tick(){
        if(right && canMove(x+speed, y)) {x += speed;}
        else if(left && canMove(x-speed, y)) {x -= speed;}
        else if(up && canMove(x, y-speed)) {y -= speed;}
        else if(down && canMove(x, y+speed)) {y += speed;}

        Level level = Game.level;

        for(int i=0; i < level.apples.size(); i++){
            if(this.intersects(level.apples.get(i))){
                level.apples.remove(i);
                break;
            }
        }
        if(level.apples.size() == 0){
            //Game end
            Game.player = new Player(0, 0);
            Game.level = new Level("res/map/map7.png");
            return;

        }
        for(int i=0; i < Game.level.enemies.size(); i++){
            Enemy en = Game.level.enemies.get(i);
//            if(en.intersects(this)){
//                System.exit(1);
//            }
        }

    }

    private boolean canMove(int nextx, int nexty){

        Rectangle bounds = new Rectangle(nextx, nexty, width, height);
        Level level = Game.level;

        for(int xx=0; xx < level.tiles.length; xx++){
            for(int yy=0; yy < level.tiles[0].length; yy++){
                if(level.tiles[xx][yy] != null){
                    if(bounds.intersects(level.tiles[xx][yy])){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public void render(Graphics g){
        g.drawImage(Texture.player, x, y, 32, 32, null);
    }


}
