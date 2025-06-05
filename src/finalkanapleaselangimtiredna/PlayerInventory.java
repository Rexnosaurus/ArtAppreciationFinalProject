/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalkanapleaselangimtiredna;

public class PlayerInventory extends AbstractInventory {
    private int money;
    Player activePlayer;
    public PlayerInventory() {
        super();
        money = 0;
    }
    
    public void useItem(Item item) {
        item.use(activePlayer);
        CONTENTS.put(item, CONTENTS.get(item)-1);
        int curItemAmt = CONTENTS.get(item);
        if(curItemAmt <= 0) {
            CONTENTS.remove(item);
        }
    }
    
    public void useItem(String itemName) {
        try {
            Object[] contentsKeySet = CONTENTS.keySet().toArray();
            for(int i = 0; i < contentsKeySet.length; i++) {
                Item currentItem = (Item) contentsKeySet[i];
                if(currentItem.getItemName().equalsIgnoreCase(itemName)) {
                    int currentItemAmount = CONTENTS.get(currentItem);
                    if(currentItemAmount-1 == 0) {
                        currentItem.use(activePlayer);
                    }
                    else {
                        CONTENTS.put(currentItem, currentItemAmount-1);
                    }
                }
            }
        }
        catch(Exception e) {
            
        }
    }
    
    public int getMoney() {
        return money;
    }
    
    public void setMoney(int amt) {
        money = amt;
    }
    
    public Player getActiveCharacter() {
        return activePlayer;
    }
    
    public void setActiveCharacter(Player newActivePlayer) {
        activePlayer = newActivePlayer;
    }
}
