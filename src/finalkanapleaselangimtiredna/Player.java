/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;


public class Player extends Entity{
    private PlayerInventory inventory;
    boolean  isDodging = false;
    int expThreshold = 100;
    int currentExp = 0;
    boolean isDead;
    public Player(int playerLevel, int experiencePoints, String playerName, int playerHp, int playerMaxHp, int playerMana, int playerMaxMana, int playerDefense, int playerBaseAttack,
            int playerCritDamage, double playerCritRate, int playerDodgeCooldown, int playerSkill1Cooldown, int playerSkill2Cooldown, PlayerInventory inv) {
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
        this.inventory = inv;
        this.isDead = false;
    }
    
    public Player(String name, int baseHP, int baseMP, int def, int atk, PlayerInventory inv) {
        super(
        1,
        0,
        name,
        baseHP,
        baseHP,
        baseMP,
        baseMP,
        def,
        atk,
        50,
        5,
        5,
        10,
        15
        );
        
        this.inventory = inv;
    }
    
    public void useItem(Item item) {
        inventory.useItem(item);
    }
    
    public void useItem(String itemName) {
        inventory.useItem(itemName);
    }
    
    
    
    @Override
    public void basicAttack(Enemy enemy){
        int damage = calculateBasicAttackDamage();
        enemy.takeDamage(damage);
        System.out.println(name + " dealt " + damage + " damage with Basic Attack.");        
    }
    
    @Override
    public void dodge(){
        isDodging = true;
        System.out.println(name + " is dodging the next attack.");        
    }
    
    @Override
    public void skill1(){
        
    }
    
    @Override
    public void skill2(){
        
    }
    
    public int calculateBasicAttackDamage() {
        int critChance = (int)(Math.random()*100 + 1);
        if (critChance <= critRate) {
            return (int)(baseAttack * (1 + critDamage));
        }
        return baseAttack;
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
    
    
}
