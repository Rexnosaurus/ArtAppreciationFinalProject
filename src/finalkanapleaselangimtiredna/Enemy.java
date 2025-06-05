/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;


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
        int enemyMaxHp = 300 + level * 50;
        int enemyHp = enemyMaxHp;
        int enemyMaxMana = 150 + level * 50;
        int enemyMana = enemyMaxMana;
        int enemyDefense = 2 + level * 20;
        int enemyBaseAttack = 50 + level * 50;
        int enemyCritDamage = 50 + level * 2;
        int enemtCritRate = 5 + (level / 2);
        
        if (level < 10) {
            if (level % 2 == 0) {
                enemyName = "Alden Minion";
            } else {
                enemyName = "Alden Elite Minion";
            }
        } else if (level == 10) {
            enemyName = "Alden Richarge";
            enemyHp *= 2;
            enemyMaxHp *= 2;
            enemyMaxMana *= 2;
            enemyMaxMana *= 2;
        } else if (level < 20) {
            
            if (level % 2 == 0) {
                enemyName = "Sophie Minion";
            } else {
                enemyName = "Sophie Elite Minion";
            }
        } else if (level == 20) {
            enemyName = "Sophie and DJMOD";
            enemyMaxHp *= 2;
            enemyMaxMana *= 2;
        } else if (level < 30) {
            if (level % 2 == 0) {
                enemyName = "HereComeTheSun's Minion";
            } else {
                enemyName = "HereComeTheSun's Minion";
            }
        } else if (level == 30) {
            enemyName = "HereComeTheSun";
            enemyMaxHp *= 2;
            enemyMaxMana *= 2;
        } else {
            enemyName = "Unknown Enemy";
        }       
        return new Enemy(level, enemyName, enemyHp, enemyMaxHp, enemyMana, enemyMaxMana, enemyDefense, enemyBaseAttack, enemyCritDamage, enemtCritRate, 0, 0, 0, 1);
        
        
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
    
    
    
}

