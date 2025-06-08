/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;


public class Rex extends Player{

    public Rex(PlayerInventory inv) {
        super(1, "Rex", 500, 500, 250, 250, 0, 20, 0.10, 10, 5, 10, 15, inv);
        dodgeCooldown = 0;
        skill1Cooldown = 0;
        skill2Cooldown = 0;        
    }
    
    @Override
    public void basicAttack(Enemy enemy){
        
        damagedealt = calculateBasicAttackDamage();
        enemy.takeDamage((int) damagedealt);   
        
    }
    
    @Override
    public void dodge(){
        int chance = (int)(Math.random() * 100) + 1;
        if (chance <= 90) { 
            isDodging = true;
            System.out.println("Rex Dodge succeeded!");
        } else {
            isDodging = false;
            System.out.println("Dodge failed!");
        }
        
        dodgeCooldown = 5;
    }
    
    public void skill1(Enemy enemy){
        System.out.println("Mac Attack");
        
        int macDamage = calculateBasicAttackDamage() * 2;
        damagedealt = macDamage;
        
        enemy.takeDamage(macDamage);
        
        skill1Cooldown = 10;
    }
    

    public void skill2(Enemy enemy){
        
        int bribeChance = (int)(Math.random()*100)+1;
        
        int bribeAcceptDamage = enemy.maxHp - 1;
        
        damagedealt = bribeAcceptDamage;
        if (bribeChance <= 60) {
            enemy.takeDamage((int) damagedealt);
            System.out.println("Enemy accepts the money and leave the battle");
        } else {

            System.out.println("Enemy refuse to take the Money");
        }
        
        skill2Cooldown = 15;
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

    public void resetDodge(){
        isDodging = false;
    }    
}
