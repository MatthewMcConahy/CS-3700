/*
Matthew McConahy
First Exam

*/
package myclass;



/**
 *
 * @author matthewmcconahy
 */
public class MyClass extends Weapons{

   // enums
    LifeState healthly;
    LifeState damaged;
    LifeState critical;
    
    
    static int userHealth = 100;
    
    
    private void start(){
        
        // using interfaces 
        MyClass test = new MyClass();
        
        test.type();
        test.damage();
        test.range();
        test.lifeSpan();
        test.swing();
        test.shoot();
        test.aliveOrDead();
        
        
    }
   
    
    public static void main(String[] args) {
       new MyClass().start();
    }
    
    public void checkHealth(){
        
    }

    @Override
    public void type() {
        weaponType = "rope";
        System.out.println("You have picked a " + weaponType);
    }

    @Override
    public void damage() {
        attack = 20;
        System.out.println("You have done "+ attack + " damage" );
    }

    @Override
    public void range() {
        attackRange = 44;
        System.out.println("Your weapon range is "+ attackRange);
    }

    @Override
    public void lifeSpan() {
        weaponLifeSpan = 10;
        if(weaponLifeSpan < 20){
            System.out.println("Your weapon is becoming weak");
        }
        else{
            System.out.println("Your weapon is still strong");
        }
    }

    @Override
    public void swing() {
        int strength = 3;
        int fatigue = 1;
        
        for(strength = 3; strength >= fatigue; fatigue++){
            System.out.println("You have swung and your strength is " + strength );
            strength--;
            
        } 
        if(strength < fatigue){
            System.out.println("You are tired, must rest");
        }
    }

    @Override
    public void shoot() {
        attack = 300;
        System.out.println("You have been shot and have been hurt with "+ attack + "damage");
        userHealth = userHealth - attack;
        
    }
    
    public int aliveOrDead(){
        if(userHealth >= 100){
            System.out.println("User is okay and has " + userHealth + " left");
        }
        else if(userHealth >= 50)
        {
            System.out.println("User is hurt and has " + userHealth + " left" );
         }
        else if(userHealth <= 0){
            System.out.println("User is not alive ");
        }
        return userHealth;
        
    }
}

// Class will allow different levels of damage, but it is not used 
 enum LifeState {
    healthy, damage, critical;
   
}


 abstract class Weapons implements Gun, Sword {
    
    String weaponType = "hammer";
    int attack = 4;
    int attackRange = 150;
    int weaponLifeSpan = 20;
    
    
    public void type(){
        System.out.println("You have picked a " + weaponType);
    }
    public void damage(){
        System.out.println("you have done" + attack + "to enemy");
    }
    public void range(){
        System.out.println("Your weapon does not have enough range in the " + attackRange + " area");
    }
    public void lifeSpan(){
        System.out.println("Your weapon only has "+ weaponLifeSpan + "left");
    }
    
}

 interface Sword{
    
    public void swing();
   
}

interface Gun {
    
    public void shoot();
}
