package Characters;

public class Enemy extends Character {

    public Enemy(String name, int healthPoints, int level, int attackPoints) {
        super (name, healthPoints, level, attackPoints);
        this.setGold((int) (Math.random() * 100) + 10);
    }

}
