import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter

public class Character implements Serializable { //serialization allows to save object in bytes sequence

    private static final long serialVersionUID = 1L;

    private String name;
    private int healthPoints;
    private int attackPoints;
    private int level;
    private int gold;

    public Character(String name, int healthPoints, int attackPoints, int level) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.level = level;
    }

    public void attack (Character opponent) {
        opponent.setHealthPoints(opponent.getHealthPoints() - this.getAttackPoints());
        System.out.println(this.getName() + " attacked! " + opponent.getName() + " current HP: " + opponent.getHealthPoints() + ".");
    }

    public void defend() {
        this.setHealthPoints(this.getHealthPoints() + 10);
        System.out.println(this.getName() + " defended! " + this.getName() + " current HP: " + this.getHealthPoints() + ".");
    }
}


