package com.example.imab.imab_group33;

import java.util.HashMap;

/**
 * Created by daniel on 01/04/17.
 */


public class groups_class {
    public int icon;
    public String title;
    public String noti;
    //public ArrayList<items_class> items;
    private HashMap<String, Object> Items;

    //Constructor => in case we dont receive anything
    public groups_class(){
        super();
    }

    //Constructor => in case we receive elements
    public groups_class(String noti, int icon, String title, HashMap<String, Object> Items){
        super();
        this.icon = icon;
        this.title = title;
        this.noti = noti;
        this.Items =Items;

    }



    public void setIcon( int icon){this.icon=icon;}
    public int getIcon(){return this.icon;}
    public void setTitle(String title){this.title=title;}
    public String getTitle(){return title;}
    public void setNoti(String noti){this.noti=noti;}
    public String getNoti(){return noti;}
    public void setItems_list(HashMap<String, Object> items_list){this.Items =Items;}
    public HashMap<String, Object> getItems_list(){return Items;}

}

///////////////////////////////
//Elements will be of this class. Data type: groups_class
