package com.example.hemalpractical;

public class Model {

    private int id;
    private String itemname;
    private int itemprice;
    private int itemcount;
    private int itempricetotal;


    public Model(String itemname, int itemprice, int itemcount, int itempricetotal) {
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.itemcount = itemcount;
        this.itempricetotal = itempricetotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getItemprice() {
        return itemprice;
    }

    public void setItemprice(int itemprice) {
        this.itemprice = itemprice;
    }

    public int getItemcount() {
        return itemcount;
    }

    public void setItemcount(int itemcount) {
        this.itemcount = itemcount;
    }

    public int getItempricetotal() {
        return itempricetotal;
    }

    public void setItempricetotal(int itempricetotal) {
        this.itempricetotal = itempricetotal;
    }
}
