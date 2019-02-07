/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;

/**
 *
 * @author Lenovo
 */
public class SelectProducts {

    int qty,pid;

    public SelectProducts(int pid, int qty) {
        this.qty = qty;
        this.pid = pid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
    
    
}
