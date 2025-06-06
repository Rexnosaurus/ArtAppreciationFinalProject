/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;


public class Rex extends Player{

    public Rex(PlayerInventory inv) {
        super(1, "Rex", 500, 500, 250, 250, 0, 100, 50, 5, 5, 10, 15, inv);
        
    }
    
    @Override
    public void basicAttack(Enemy enemy){
        int damage = calculateBasicAttackDamage();
        enemy.takeDamage(damage);
        System.out.println(name + " dealt " + damage + " damage with Basic Attack.");        
    }
    
    @Override
    public void dodge(){
        
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
        System.out.println("=====Rex's Stats=====");
        super.getStats();
    }
    
}
