package com.hchen.pesticidecu;

/**
 * Created by user on 2017/7/27.
 */

public class Animal {
    private String aName;
    private String aSpeak;
    private int aIcon;
    public Animal(String name,String speak,int icon)
    {
        this.aName=name;
        this.aSpeak=speak;
        this.aIcon=icon;
    }
    public String getName()
    {
        return this.aName;
    }
    public String getSpeak()
    {
        return this.aSpeak;
    }
    public int getIcon()
    {
        return this.aIcon;
    }
    public void setName(String name)
    {
        this.aName=name;
    }
    public void setSpeak(String speak)
    {
        this.aSpeak=speak;
    }
    private void setIcon(int icon)
    {
        this.aIcon=icon;
    }
}
