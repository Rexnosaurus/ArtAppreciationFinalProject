/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package finalkanapleaselangimtiredna;

// TEMPLATE GUIDE
/*
super(
    id
    name
    description
    buy cost
    sell price
)
*/

public class Items {
    public static class PotionSmallHealth extends Item{
        public PotionSmallHealth() { 
            super(
                0,
                "Fish Fillet",
                "A.....",
                100,
                50
            );
        }
        
        @Override
        public void use(Player activeCharacter){
            activeCharacter.addHp(150);
            System.out.println("Item used by: "+activeCharacter.name);
        }
        
    }    
    
    public static class PotionLargeHealth extends Item{
        public PotionLargeHealth() {
            super(
                1, 
                "Turon ni Nanay", 
                "A........", 
                150, 
                75
            );    
        }
        
        @Override
        public void use(Player activeCharacter){
            activeCharacter.addHp(250);
            
        }
        
    }

    public static class PotionSmallMana extends Item{

        public PotionSmallMana() {
            super(
                2, 
                "Lucky Day", 
                "A..................", 
                100, 
                50
            );    
        }
        
        @Override
        public void use(Player activeCharacter){
            activeCharacter.addMp(150);
            
        }
        
    }   
    
    public static class PotionLargeMana extends Item{
        public PotionLargeMana() {
            super(
                3, 
                "Black Coffee ni Rex", 
                "A potion that will greatly restore hp of an active character.", 
                150, 
                75
            );    
        }
    
        
        @Override
        public void use(Player activeCharacter){
            activeCharacter.addMp(250);
            
        }
    }
    
    public static class PotionRevive extends Item {
        public PotionRevive() {
            super(
                4,
                "",
                "Revives an ally.",
                2000,
                350
            );
        }
        
        @Override
        public void use(Player activeCharacter) {
            
        }
    }
}
