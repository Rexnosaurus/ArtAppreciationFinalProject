/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalkanapleaselangimtiredna;
import java.util.Vector;

public class Party {
    private Vector<Player> members;
    private PlayerInventory partyInventory;
    private int partyLevel;
    
    public Party() {
        this.members = new Vector<>();
        this.partyInventory = new PlayerInventory();
    }
    
    // PARTY RELATED METHODS
    public void addMember(Player p) {
        members.add(p);
    }
    
    public Player[] getMembers(Player p) {
        return (Player[]) members.toArray();
    }
    
    public boolean isPartyAlive() {
        boolean isAlive = false;
        for(Player p:members) {
            if(!p.isDead && p.isUnlocked) {
                isAlive = true;
                return isAlive;
            }
        }
        return isAlive;
    }
    
    public void addExperienceToAll(int amt) {
        for(Player p:members) {
            p.gainExp(amt);
        }
        this.partyLevel = members.get(0).getLevel();
    } 
    
    public int getPartyLevel() {
        return this.partyLevel;
    }
    
    // INVENTORY RELATED METHODS
    public PlayerInventory getInventory() {
        return partyInventory;
    }
    
    public void useItem(Item item) {
        partyInventory.useItem(item);
    }
    
    public void useItem(String itemName) {
        partyInventory.useItem(itemName);
    }
}
