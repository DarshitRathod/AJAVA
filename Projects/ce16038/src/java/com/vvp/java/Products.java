/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;
import java.util.*;
/**
 *
 * @author Lenovo
 */
public class Products {

    int pid,qty;
    double price;
    String description,productName,image;

    public Products(int pid, int qty, double price, String description, String productName, String image) {
        this.pid = pid;
        this.qty = qty;
        this.price = price;
        this.description = description;
        this.productName = productName;
        this.image = image;
    }
    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public int getPid() {
        return pid;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQty() {
        return qty;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }    
    
    static HashMap <Integer,Products> products = new HashMap <Integer,Products>();
    public static void initData()
    {
        Products p1 = new Products(1,5,200.0,"bag","bag","bag");
        Products p2 = new Products(2,3,20.0,"pencil","pencil","pencil");
        //Products p1 = new Products(1, 3, 200, "bag", "bag", "bag");
        //Products p2 = new Products(2, 3, 20, "pencil", "pencil", "pencil");
        products.put(new Integer(1),p1);
        products.put(new Integer(2),p2);
    }

}
