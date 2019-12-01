////////////////////////////////////////////////////////////////////
// [EDUARD GEORGE] [SERBAN] [1052741]
////////////////////////////////////////////////////////////////////

package it.unipd.tos;
import it.unipd.tos.model.MenuItem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class MenuItemTest{
	
	@org.junit.Test
    public void testItemTypeEnumValues() {
		assertEquals("PANINI", MenuItem.itemType.valueOf(MenuItem.itemType.PANINI.toString()).name());
		assertEquals("FRITTI", MenuItem.itemType.valueOf(MenuItem.itemType.FRITTI.toString()).name());
        assertEquals("BEVANDE", MenuItem.itemType.valueOf(MenuItem.itemType.BEVANDE.toString()).name());
    }

    @org.junit.Test
    public void testGetType(){
        MenuItem item = new MenuItem(MenuItem.itemType.PANINI, "Primavera", 7.50);
        assertEquals(item.getType(), MenuItem.itemType.PANINI);
    }

    @org.junit.Test
    public void testGetName(){
        MenuItem item = new MenuItem(MenuItem.itemType.PANINI, "Primavera", 7.50);
        assertEquals(item.getName(),  "Primavera");
    }

    @org.junit.Test
    public void testGetPrice(){
        MenuItem item = new MenuItem(MenuItem.itemType.PANINI, "Primavera", 7.50);
        assertEquals(7.5,item.getPrice(), 0);
    }
}
