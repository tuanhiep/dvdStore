/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package management;

import entity.Dvd;

/**
 *
 * @author Strong man
 */
public class MissingDvd {
    
    private Dvd dvd;
    private int missquantity;

    public MissingDvd(Dvd dvd, int missquantity) {
        this.dvd = dvd;
        this.missquantity = missquantity;
    }
    

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    public int getMissquantity() {
        return missquantity;
    }

    public void setMissquantity(int missquantity) {
        this.missquantity = missquantity;
    }
    
    
    
}
