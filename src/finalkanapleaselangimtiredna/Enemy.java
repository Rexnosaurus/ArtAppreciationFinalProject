/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;

import java.util.Random;


public class Enemy extends Entity{
    
    public boolean isDodging = false;

    public Enemy(int level, String enemyName, int enemyHp, int enemyMaxHp, int enemyMana, int enemyMaxMana, int enemyDefense, int enemyBaseAttack, int enemyCritDamage, int enemyCritRate, int enemyDodgeCooldown, int enemySkill1Cooldown, int enemySkill2Cooldown, int multiplier) {
        super(1, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 2, 5, 10);
        
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
        activeCharacter.removeHp(damage);
        System.out.println("Enemy do a Basic Attack");
        
    }
    
    @Override
    public void dodge(){
        
        isDodging = true;
        System.out.println(name + " is dodging the next attack.");
        
    }
    
    @Override
    public void skill1(){
        
        System.out.println("Enemy use Skill 1");
    }
    
    @Override
    public void skill2(){
        
        System.out.println("Enemy use Skill2");
    }
    

    public void takeDamage(int damage) {
        if (isDodging) {
            System.out.println(name + " dodged the attack!");
            isDodging = false; // dodge only applies to one attack
            damage = 0;
        }
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
        System.out.println(name + " has " + hp + " HP left.");
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
    
    public static Enemy generateEnemy(int level){
        
        String enemyName;

        int baseHp = 100;         
        int baseMana = 75;        
        int baseDefense = 1;      
        int baseAttack = 10;      
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
            enemyName = "Sol (The Overheating Android)";
            enemyHp *= 2;
            enemyMaxHp *= 2;
            enemyMaxMana *= 2;
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
        } else if (level < 30) {
            if (level % 2 == 0) {
                enemyName = "SPC's Minion";
            } else {
                enemyName = "SPC's Minion";
            }
        } else if (level == 30) {
            enemyName = "Shape Property Calculator (The Almighty SPC)";
            enemyMaxHp *= 2;
            enemyMaxMana *= 2;
        } else {
            enemyName = "Unknown Enemy";
        }       
        return new Enemy(level, enemyName, enemyHp, enemyMaxHp, enemyMana, enemyMaxMana, enemyDefense, enemyBaseAttack, enemyCritDamage, enemyCritRate, 0, 0, 0, 1);
        
        
    }
    
    @Override
    public void getStats(){
        System.out.println("=====" + name + "=====");
        System.out.println("Hp: " + hp);
        System.out.println("Mana: " + mana);
    }

    void dodge(Entity activeCharacter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

