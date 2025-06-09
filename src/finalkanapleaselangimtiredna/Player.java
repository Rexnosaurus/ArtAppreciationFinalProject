/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;

import java.util.ArrayList;
import java.util.List;



public abstract class Player extends Entity{
    
    private int level = 1;
    private static int experiencePointsCurrent = 49;
    private static int experiencePointsThreshold = 50;
    
    private int currentExp = 0;
    private int expThreshold = 50;
    
    boolean isDead;
    boolean isUnlocked = true;
    
    private static final List<Player> players = new ArrayList<>();
    
    public Player(int playerLevel, String playerName, int playerHp, int playerMaxHp, int playerMana, int playerMaxMana, int playerDefense, int playerBaseAttack,
            double playerCritDamage, double playerCritRate, int playerDodgeCooldown, int playerSkill1Cooldown, int playerSkill2Cooldown) {
        super(1, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
        this.level = playerLevel;
        this.name = playerName;
        this.hp = playerHp;
        this.maxHp = playerMaxHp;
        this.mana = playerMana;
        this.maxMana = playerMaxMana;
        this.defense = playerDefense;
        this.baseAttack = playerBaseAttack;
        this.critDamage = playerCritDamage;
        this.critRate = playerCritRate;
        this.dodgeCooldown = playerDodgeCooldown;
        this.skill1Cooldown = playerSkill1Cooldown;
        this.skill2Cooldown = playerSkill2Cooldown;
        this.isDead = false;
        
        players.add(this);
    }
    
    @Override
    public void takeDamage(int damage) {
        if (isDodging) {
            System.out.println(name + " dodged the attack!");
            isDodging = false; // dodge only applies to one attack
            damage = 0;
        }
        
        hp -= damage;
        if (hp < 0) {
            hp = 0;
            isDead = true;
            isUnlocked = false;
        }
        
        System.out.println(name + " has " + hp + " HP left.");
    }
    
    /*
    public static void addExperience(int exp) {
        experiencePointsCurrent += exp;
        System.out.println("Gained " + exp + " EXP. Current EXP: " + experiencePointsCurrent + "/" + experiencePointsThreshold);

        while (experiencePointsCurrent >= experiencePointsThreshold) {
        
            experiencePointsCurrent -= experiencePointsThreshold;
            level++;
            experiencePointsThreshold = (int)(experiencePointsThreshold * 1.5);
            System.out.println("Level up! New Level: " + level);
            levelUpAllCharcters();
        
        }

    }
*/
    
    private static void levelUpAllCharcters() {   
        for (Player p : players) {
            p.levelUpStats();
        }
    }

    public void levelUpStats() {
        
        this.maxHp += 50;
        this.hp = this.maxHp;
        
        this.maxMana += 25;
        this.mana = this.maxMana;
        
        this.defense += 5;
        this.baseAttack += 10;
        this.critDamage += 0.5;
        this.critRate += 1;
        
        
        
        System.out.println(name + " leveled up to level " + this.level + "!");
        
    }

    public int getLevel() {
        return level;
    }    
    
    
    
    
    @Override
    public abstract void basicAttack(Entity targetEntity);
    @Override
    public abstract void dodge();
    @Override
    public abstract void skill1(Entity targetEntity);
    @Override
    public abstract void skill2(Entity targetEntity);
    
    public int calculateBasicAttackDamage() {
        int critChance = (int)(Math.random() * 100 + 1);
        int damage;

        if (critChance <= critRate) {
            damage = (int)(baseAttack * (1 + critDamage));
            System.out.println("Critical hit! Damage: " + damage);
        } else {
            damage = baseAttack;
            System.out.println("Normal hit. Damage: " + damage);
        }
        return damage;

                
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
        
        System.out.println("Hp: " + hp);
        System.out.println("Max Hp: " + maxHp);
        System.out.println("Mana: " + mana);
        System.out.println("Max Mana: " + maxMana);
        System.out.println("Defense: " + defense);
        System.out.println("Base Attack: " + baseAttack);
        System.out.println("Crit Damage: " + critDamage);
        System.out.println("Crit Rate: " + critRate);
        
    }
    
    public int getExpThreshold(){
        return expThreshold;
    }
    
    public int getExpCurrent(){
        return currentExp;
    }
    
    public void checkForLevelUp() {
        if(this.currentExp >= expThreshold) {
            this.level++;
            currentExp -= expThreshold;
            expThreshold = (int) Math.round(expThreshold * 1.272);
            System.out.println(this.name+" Leveled Up!");
        }
        
    }
    
    public void gainExp(int amt) {
        this.currentExp += amt;
        System.out.println("EXP Gained: "+amt);
        checkForLevelUp();
        System.out.println("Current EXP: "+this.currentExp);
    }
    
    public static List<Player> getPlayers() {
        return players;
    }
    
    public void setUnlocked(boolean b) {
        isUnlocked = b;
    }
}
