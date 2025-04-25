package com.example.custom_recycler_list;

//https://pastebin.com/nJ2udEfm
public class Castles {
    private Castle[] castle;

    public Castles(Castle[] castle) {
        this.castle = castle;
    }

    public int getCount(){return this.castle.length;}
    public Castle getCastle(int index){return this.castle[index];}

    public String [] getNames(){
        String [] names = new String[this.getCount()];
        for(int i=0;i<getCount();i++){
            names[i]=getCastle(i).getName();
        }
        return names;

    }
}
