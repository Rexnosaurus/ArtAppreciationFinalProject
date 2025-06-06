/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;


public class Arth extends Player{

    public Arth(PlayerInventory inv) {
        super(1, "Arth", 500, 500, 350, 350, 0, 90, 40, 5, 5, 10, 15, inv);
        //super("Arth", 500, 350, 0, 90, inv);
    }
    
    @Override
    public void basicAttack(){

    }
    
    @Override
    public void dodge(){
        System.out.println("Scolio Dodge");
    }
    
    @Override
    public void skill1(){
        
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
        System.out.println("=====Arth's Stats=====");
        super.getStats();
    }
    
}
