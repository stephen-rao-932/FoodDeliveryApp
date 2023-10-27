package com.raogroup.fooddeliveryapp.Models;

public class Cg_Item_Model {

    int pic;
    String item_name;

    public Cg_Item_Model(int pic, String item_name) {
        this.pic = pic;
        this.item_name = item_name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
}
