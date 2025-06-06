/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;


public class Aaron extends Player{

    public Aaron(PlayerInventory inv) {
        super(1, "Aaron", 600, 600, 200, 200, 0, 100, 50, 5, 5, 10, 15, inv);
        
    }
    
    @Override
    public void basicAttack(){

    }
    
    @Override
    public void dodge(){
        
    }
    
    @Override
    public void skill1(){
        int instantSleepTurnCount = 5;
        hp += 50;
    }
    
    @Override
    public void skill2(){
        
    }
    
    
    @Override
    public void reduceCooldown(){
        
        if (dodgeCooldown > 0) {
            dodgeCooldown --;
        }
        
        if (skill1Cooldown > 0) {
            skill1Cooldown --;
        }
        
        if (skill2Cooldown > 0) {
            skill2Cooldown --;
        }
        
    }
    
    @Override
    public void getStats(){
        System.out.println("=====Aaron's Stats=====");
        super.getStats();
    }
}
