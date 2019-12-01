////////////////////////////////////////////////////////////////////
// [EDUARD GEORGE] [SERBAN] [1052741]
////////////////////////////////////////////////////////////////////

package it.unipd.tos;

import it.unipd.tos.business.BillMaker;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;



public class BillMakerTest {

    @org.junit.Test(expected = TakeAwayBillException.class)
    public void testPriceException() throws TakeAwayBillException{
        List<MenuItem> item = new ArrayList<>();
        for(int i = 0; i < 31; i++) {
            item.add(new MenuItem(MenuItem.itemType.PANINI, "Fantasia", 4.50));
        }
        BillMaker maker = new BillMaker();
        maker.getOrderPrice(item);
    }

   @org.junit.Test
    public void testcinquepanini(){
        List<MenuItem> item = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            item.add(new MenuItem(MenuItem.itemType.PANINI, "Primavera", 5));
        }
        item.add(new MenuItem(MenuItem.itemType.PANINI, "Vegetariano", 4));
        BillMaker maker = new BillMaker();
        double totalPrice = 0;
        try {
            totalPrice = maker.getOrderPrice(item);
        }catch(TakeAwayBillException e){
            System.out.println("Errore");
        }
        assertEquals(27,totalPrice,0);
    }

   @org.junit.Test
    public void testSconto(){
        List<MenuItem> item = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            item.add(new MenuItem(MenuItem.itemType.FRITTI, "Patatine", 6));
        }
        BillMaker maker = new BillMaker();
        double totalPrice = 0;
        try {
            totalPrice = maker.getOrderPrice(item);
        }catch(TakeAwayBillException e){
            System.out.println("Errore");
        }
        assertEquals(54,totalPrice, 0);
    }
   
   @org.junit.Test
   public void testAumentoPrezzo(){
       List<MenuItem> item = new ArrayList<>();
       for(int i = 0; i < 3; i++){
           item.add(new MenuItem(MenuItem.itemType.FRITTI, "Patatine", 3));
       }
       BillMaker maker = new BillMaker();
       double totalPrice = 0;
       try {
           totalPrice = maker.getOrderPrice(item);
       }catch(TakeAwayBillException e){
           System.out.println("Errore");
       }
       assertEquals(9.5,totalPrice, 0);
   }

    @org.junit.Test
    public void testCompleto(){
        List<MenuItem> item = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            item.add(new MenuItem(MenuItem.itemType.PANINI, "Primavera", 5));
        }
        item.add(new MenuItem(MenuItem.itemType.PANINI, "Vegetariano", 4));
        item.add(new MenuItem(MenuItem.itemType.BEVANDE, "Coca-Cola", 8));
        BillMaker maker = new BillMaker();
        double totalPrice = 0;
        try {
            totalPrice = maker.getOrderPrice(item);
        }catch(TakeAwayBillException e){
            System.out.println("Errore");
        }
        assertEquals(54,totalPrice,0);
    }
}
