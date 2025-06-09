/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;


public class Rex extends Player{

    public Rex() {
        super(1, "Rex", 500, 500, 250, 250, 0, 20, 0.10, 10, 5, 10, 15);
        dodgeCooldown = 0;
        skill1Cooldown = 0;
        skill2Cooldown = 0;        
    }
    
    @Override
    public void basicAttack(Entity targetEntity){
        
        damagedealt = calculateBasicAttackDamage();
        targetEntity.takeDamage((int) damagedealt);   
        
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
    
    @Override
    public void skill1(Entity targetEntity){
        System.out.println("Mac Attack");
        
        int macDamage = calculateBasicAttackDamage() * 2;
        damagedealt = macDamage;
        
        targetEntity.takeDamage(macDamage);
        
        skill1Cooldown = 10;
    }
    
    @Override
    public void skill2(Entity targetEntity){
        
        int bribeChance = (int)(Math.random()*100)+1;
        
        int bribeAcceptDamage = targetEntity.maxHp;
        
        damagedealt = bribeAcceptDamage;
        if (bribeChance <= 60) {
            targetEntity.takeDamage((int) damagedealt);
            System.out.println("Enemy accepts the money and leave the battle");
        } else {

            System.out.println("Enemy refuse to take the Money");
        }
        
        skill2Cooldown = 15;
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
