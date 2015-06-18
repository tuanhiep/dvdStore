
package cart;

import entity.Dvd;
import javax.ejb.EJB;
import session.DvdFacade;

/**
 * Class represent the Items which is picked to shopping cart, here this is just DVD
 * @author Strong man
 */
public class ShoppingCartItem {
      
    Dvd dvd;
    short quantity;

    public ShoppingCartItem(Dvd dvd) {
        this.dvd = dvd;
        quantity = 1;
    }

    public Dvd getDvd() {
        return dvd;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public double getTotal() {
        double amount = 0;
        amount = (this.getQuantity() * dvd.getPrice().doubleValue());
        return amount;
    }
    /**
     * Check if DVD in cart is sufficient in stock
     * @return true if the quantity of DVD in stock is sufficient and false if not
     */
    public boolean isDisponible(){
        
        return(dvd.getQuantitystock()>quantity);
           
    }
    /**
     * 
     * @return the missed quantity of dvds in the case the quantity of dvds in stock is not sufficient 
     */
    public int getMissedQuantity(){
    
    if(!this.isDisponible()){
    return (quantity-dvd.getQuantitystock());
    }
    else return 0;
    }

}