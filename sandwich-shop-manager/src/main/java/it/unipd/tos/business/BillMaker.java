////////////////////////////////////////////////////////////////////
// [EDUARD GEORGE] [SERBAN] [1052741]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;


import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import java.util.List;

public class BillMaker implements TakeAwayBill {

       
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException{
        if(itemsOrdered.size() > 30) {
            throw new TakeAwayBillException("Numero di ordinazioni" +
                    " maggiori di 30");
        }
        
    
        double totalPrice = 0;
        totalPrice = itemsOrdered.stream().mapToDouble(x -> x.getPrice()).sum();
        
    
        if(itemsOrdered.stream().filter(x -> x.getType() == MenuItem.itemType.PANINI)
                .count() > 5 ) {
            totalPrice -= (0.5*itemsOrdered.stream()
                .filter(x -> x.getType() == MenuItem.itemType.PANINI)  
                .mapToDouble(x -> x.getPrice()).min().getAsDouble());
        }
        
      
        if(totalPrice > 50 ){
            totalPrice -= 0.10 * totalPrice ;
            }
            
    
            
        if(totalPrice < 10 ){
                totalPrice += 0.50 ;
        }
        return totalPrice;
}
}
