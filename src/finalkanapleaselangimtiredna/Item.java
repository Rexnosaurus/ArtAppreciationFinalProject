/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class Item {
    int itemId;
    String itemName;
    String itemDescription;
    int itemPrice;
    int itemSellCost;
    Icon sprite;

    public Item(int itemId, String itemName, String itemDescription, int itemPrice, int itemSellCost) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemSellCost = itemSellCost;
    }
    
    //public abstract void use();
    public abstract void use(Player activeCharacter);
    
    public void setSprite(String fileLocation) {
        sprite = new ImageIcon(getClass().getResource(fileLocation));
    }
    
    public Icon getSprite() {
        return sprite;
    }
    
    public String getDescription(){
        return itemDescription;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public int getItemPrice(){
        return itemPrice;
    }
    
    @Override
    public int hashCode() {
        return itemId;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this.hashCode() == obj.hashCode()) {
            return true;
        }
        return false;
    }
}
