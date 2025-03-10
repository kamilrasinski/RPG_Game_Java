import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends Character {
    private int experience;

    public Player(String name, int healthPoints, int attackPoints, int level, int experience) {
        super(name, healthPoints, attackPoints, level);
        this.experience = experience;
        super.setGold(0);
    }

    public void levelUp(){
        this.setLevel(this.getLevel() + 1);
        this.setHealthPoints(this.getHealthPoints() + 10);
        this.setAttackPoints(this.getAttackPoints() + 10);
        this.experience = 0;
        System.out.println("Level up! Current level: " + this.getLevel());
    }

    @Override
    public String toString() {
        return "Player: " + "\n" +
                "1. Name: " + super.getName() + "\n" +
                "2. Level: " + super.getLevel() + "\n" +
                "3. Health Points: " + TextFormatter.getAnsiRed(String.valueOf(super.getHealthPoints())) + "\n" +
                "4. Attack Points: " + TextFormatter.getAnsiGreen(String.valueOf(super.getAttackPoints())) + "\n" +
                "Current experience: " + experience + "\n" +
                "Current gold: " + TextFormatter.getAnsiYellow(String.valueOf(super.getGold())) + "\n";
    }
}
