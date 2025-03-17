package Game;

import Characters.Enemy;
import Characters.Player;
import UI.TextFormatter;

import java.util.Scanner;

public class Battle {
    int action;
    Player player;
    Enemy enemy;
    Scanner input;
    boolean isCurrently = true;

    public Battle(Scanner input, Player player, Enemy enemy) {
        this.input = input;
        this.player = player;
        this.enemy = enemy;
    }

    public void start() {

        while (isCurrently) {
            System.out.println("Choose your action: 1 - attack | 2 - defense | 3 - run ");
            action = input.nextInt();
            input.nextLine(); // clear buffer
            switch (action) {
                case 1 -> {
                    player.attack(enemy);
                    enemy.attack(player);
                    if (enemy.getHealthPoints() <= 0) {
                        int experience = ((int) (Math.random() * 10) + 1);
                        System.out.println("You win! \nLoot: " + TextFormatter.getAnsiYellow(String.valueOf(enemy.getGold()))+ " gold.");
                        player.setGold(player.getGold() + enemy.getGold());
                        System.out.println("You gain " + experience + " experience.");
                        player.setExperience(player.getExperience() + experience);
                        if (player.getExperience() >= 50) {
                            player.levelUp();
                        }
                        isCurrently = false;
                    }
                    else if (player.getHealthPoints() <= 0) {
                        System.out.println("You've lost!");
                        isCurrently = false;
                    }
                }
                case 2 -> player.defend();
                case 3 -> {
                    System.out.println("You choose to run!");
                    isCurrently = false;
                }

            }
        }
    }
}
