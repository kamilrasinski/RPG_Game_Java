import java.util.Arrays;
import java.util.List;

public class Enemy extends Character {

    public Enemy(String name, int healthPoints, int level, int attackPoints) {
        super (name, healthPoints, level, attackPoints);
        this.setGold((int) (Math.random() * 100) + 10);
    }

   // private static List<String> enemyTypes = Arrays.asList("Skeleton", "Dragon", "Wolf");

}
