/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;


public class Arth extends Player{
    
    int turnCount;
    boolean hackerMan = false;
    
    public Arth() {
        super(1, "Arth", 500, 500, 350, 350, 0, 10, 0.5, 10, 5, 10, 15);
        //super("Arth", 500, 350, 0, 90, inv);
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
        log(name+" tried to dodge...");
        if (chance <= 80) {
            isDodging = true;
            System.out.println("Arth Dodge succeeded!");
        } else {
            isDodging = false;
            System.out.println("Dodge failed!");
            log(name+" failed to dodge.");
        }
        
    }
    
    @Override
    public void skill1(Entity targetEntity){
        System.out.println("Scolio Dodge");

        int chance = (int)(Math.random()*100)+1;        
    
        double baseDamage = calculateBasicAttackDamage();
        damagedealt = baseDamage * 1.5;
        
        if (chance <= 80) {
            isDodging = true;
            System.out.println("Arth Dodge succeeded and Deal " + damagedealt + "Damage");
        } else {
            isDodging = false;
            System.out.println("Arth dailed to dodge but he Deal " + damagedealt + "Damage");
        }
        
        targetEntity.takeDamage((int) damagedealt);
        skill1Cooldown = 10;
        
    }
    
    @Override
    public void skill2(Entity targetEntity){
        int damagePerTurn;
        if (hackerMan) {
            damagePerTurn = (int) (calculateBasicAttackDamage() * 0.5);
            damagedealt += damagePerTurn;
            System.out.println("HackerMan deals additional " + damagePerTurn + " this turn");
        }
        skill2Cooldown = 15;
    }
    
    @Override
    public void getStats(){
        System.out.println("=====Arth's Stats=====");
        super.getStats();
    }
    
    public void resetDodge(){
        isDodging = false;
    }    
    
}
