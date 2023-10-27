package com.raogroup.fooddeliveryapp.Models;

public class Rc_Item_Model {

    int pic;
    String item_name, price;

    public Rc_Item_Model(int pic, String item_name, String price) {
        this.pic = pic;
        this.item_name = item_name;
        this.price = price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
