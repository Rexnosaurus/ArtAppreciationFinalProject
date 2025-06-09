/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;

import java.util.ArrayList;
import java.util.List;


public class Aaron extends Player{

    int instantSleepTurnCount;
    boolean instantSleep = false;
    
    int spreadCurseTurnCount;
    boolean spreadCurse = false;
    
    private static final List<Player> players = new ArrayList<>();
    
    public Aaron() {
        super(1, "Aaron", 600, 600, 200, 200, 0, 15, 0.10, 10, 5, 10, 15);
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
            System.out.println("Dodge succeeded!");
        } else {
            isDodging = false;
            System.out.println("Dodge failed!");
        }        
    }
    
    /**
     *
     * @param targetEntity
     * Ignore this method.
     * This method does nothing,
     */
    @Override
    public void skill1(Entity targetEntity){};
    
    public void skill1(){
        int healAmount = (int)(this.maxHp * 0.25);
        System.out.println("\nHealed all characters for " + healAmount + "HP.");
        
        for (Player p : Player.getPlayers()) {
            p.hp = Math.min(p.hp + healAmount, p.maxHp);
            System.out.println(p.name + " healed for " + healAmount + " HP.");
        }
    
        this.skill1Cooldown = 10;
        
    }
    
    @Override
    public void skill2(Entity targetEntity){

        int damagePerTurn;
        int healAmount = (int)(this.maxHp * 0.05);
        
        if (spreadCurse) {
            
            damagePerTurn = (int) (calculateBasicAttackDamage() * 0.55);
            damagedealt += damagePerTurn;

            System.out.println("Curse deals additional " + damagePerTurn + " this turn");
            
            for (Player p : Player.getPlayers()) {
                p.hp -= healAmount;
                System.out.println(p.name + " cursed and get damage by " + healAmount + ".");
            }            
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
        System.out.println("=====Aaron's Stats=====");
        super.getStats();
    }
    
    public void resetDodge(){
        isDodging = false;
    }
}
