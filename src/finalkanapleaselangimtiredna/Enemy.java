/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;

import java.util.Random;


public class Enemy extends Entity{
    
    public boolean isDodging = false;

    public Enemy(int lvl, String enemyName, int enemyHp, int enemyMaxHp, int enemyMana, int enemyMaxMana, int enemyDefense, int enemyBaseAttack, int enemyCritDamage, int enemyCritRate, int enemyDodgeCooldown, int enemySkill1Cooldown, int enemySkill2Cooldown, int multiplier) {
        super(1, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 2, 5, 10);
        
        this.level = lvl;
        this.name = enemyName;
        this.hp = enemyHp;
        this.maxHp = enemyMaxHp;
        this.mana = enemyMana;
        this.maxMana = enemyMaxMana;
        this.defense = enemyDefense;
        this.baseAttack = enemyBaseAttack;
        this.critDamage = enemyCritDamage;
        this.critRate = enemyCritRate;
        this.dodgeCooldown = enemyDodgeCooldown;
        this.skill1Cooldown = enemySkill1Cooldown;
        this.skill2Cooldown = enemySkill2Cooldown;
        this.multiplier = multiplier;
        
        
    }
    
    public void basicAttack(Entity activeCharacter){
        int damage = this.baseAttack;
        
        if (activeCharacter.isDodging == false) {
            activeCharacter.takeDamage(damage);
            System.out.println("Enemy do a Basic Attack and deal " + damage + " Damage");
            
        } else if (activeCharacter.isDodging) {
            System.out.println(activeCharacter.name + " Dodge The Attack");
        }
 
    }
    
    public void dodge(){
        
        isDodging = true;
        System.out.println(name + " is dodging the next attack.");
        
    }
    
    @Override
    public void skill1(Entity targetEntity){
        
        System.out.println("Enemy use Skill 1");
    }
    
    @Override
    public void skill2(Entity targetEntity){
        
        System.out.println("Enemy use Skill2");
    }
    
    public static Enemy generateEnemy(int lvl, int partyLevel, int wl){
        
        int level = wl;
        String enemyName;

        int baseHp = 400;         
        int baseMana = 75;        
        int baseDefense = 1;      
        int baseAttack = 50;      
        int baseCritDamage = 10;  
        int baseCritRate = 1;     

        
        int multiplier = 1 + (level / 10);  // every 10th levels, multiplier increases by 1

        int enemyMaxHp = baseHp + level * 40 * multiplier;
        int enemyHp = enemyMaxHp;
        int enemyMaxMana = baseMana + level * 20 * multiplier;
        int enemyMana = enemyMaxMana;
        int enemyDefense = baseDefense + level * 5 * multiplier;
        int enemyBaseAttack = baseAttack + level * 3 * multiplier;
        int enemyCritDamage = baseCritDamage + (level / 2) * multiplier;
        int enemyCritRate = baseCritRate + (level / 3) * multiplier;
        
        if (level < 10) {
            if (level % 2 == 0) {
                enemyName = "Sol Minion";
            } else {
                enemyName = "Sol Elite Minion";
            }
        } else if (level == 10) {
            level = partyLevel+2;
            enemyName = "Sol (The Overheating Android)";
            enemyHp *= 2;
            enemyMaxHp *= 2;
            enemyMaxMana *= 2;
        } else if (level < 20) {
            
            if (level % 2 == 0) {
                enemyName = "PIT1 Minion";
            } else {
                enemyName = "PIT1 Elite Minion";
            }
        } else if (level == 20) {
            enemyName = "PIT1 (The GymRat Android)";
            enemyMaxHp *= 2;
            enemyMaxMana *= 2;
        } else if (level < 30) {
            if (level % 2 == 0) {
                enemyName = "FIL's Minion";
            } else {
                enemyName = "FIL's Minion";
            }
        } else if (level == 30) {
            enemyName = "FIL (The Ruler)";
            enemyMaxHp *= 2;
            enemyMaxMana *= 2;
        } else if (level < 40) {
            if (level % 2 == 0) {
                enemyName = "SPC's Minion";
            } else {
                enemyName = "SPC's Minion";
            }
        } else if (level == 40) {
            enemyName = "Shape Property Calculator (The Almighty SPC)";
            enemyMaxHp *= 2;
            enemyMaxMana *= 2;
        } else {
            enemyName = "Unknown Enemy";
        }       
        return new Enemy(level, enemyName, enemyHp, enemyMaxHp, enemyMana, enemyMaxMana, enemyDefense, enemyBaseAttack, enemyCritDamage, enemyCritRate, 0, 0, 0, 1);
    }
    
    public int getLevel(){
        return level;
    }
    
    @Override
    public void getStats(){
        System.out.println("=====" + name + "=====");
        System.out.println("Hp: " + hp);
        System.out.println("Mana: " + mana);
        System.out.println("Level: " + level);
    }

    
    public int calculateExpReward() {
        Random rand = new Random();
        int baseExpMin = 10;  // minimum EXP per level
        int baseExpMax = 20;  // maximum EXP per level

        int minExp = this.level * baseExpMin;
        int maxExp = this.level * baseExpMax;

        // Return random EXP between minExp and maxExp (inclusive)
        return rand.nextInt(maxExp - minExp + 1) + minExp;
}
    
    
    
}

