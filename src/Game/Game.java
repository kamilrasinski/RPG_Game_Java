package Game;

import Characters.Enemy;
import Characters.Player;
import UI.TextFormatter;

import java.io.*;
import java.util.Scanner;

public class Game {

    private boolean gameMenu;
    private boolean sessionMenu;
    private Player player;
    Scanner input = new Scanner(System.in);

    public Game() { // Game.Game initialization
        this.player = new Player("placeholder", 100, 10, 1, 0);
        this.gameMenu = true;
        this.sessionMenu = false;
    }

    public void start() {
        System.out.println(TextFormatter.getAnsiBlue("Hello! Welcome to the game!"));
        System.out.println();
        showGameMenu();
    }

    public void showGameMenu() { // Main menu for starting new game/loading/termination
        while (gameMenu) {
            System.out.println(TextFormatter.getAnsiCyan("Please choose your action!"));
            System.out.println("1 - Start new game | 2 - Load previous save | 3 - Quit");
            int gameMenuAction = input.nextInt();
            input.nextLine(); // Clear buffer

            switch (gameMenuAction) {
                case 1 -> startNewGame();
                case 2 -> loadGame();
                case 3 -> exitGame();
            }
        }
    }

    public void showSessionMenu() { // Game.Game session menu for choosing your actions
        sessionMenu = true;
        while (sessionMenu) {
            System.out.println(TextFormatter.getAnsiCyan("Please choose your action!"));
            System.out.println("1 - training | 2 - fight | 3 - statistics | 4 - save game | 5 - exit");
            int sessionMenuAction = input.nextInt();
            input.nextLine(); // Clear buffer

            switch (sessionMenuAction) {
                case 1 -> player.train();
                case 2 -> {
                    Battle battle = new Battle(input, player, new Enemy("Skeleton",100, 5, 20));
                    battle.start();
                }
                case 3 -> player.getStatistics();
                case 4 -> saveGame(player);
                case 5 -> quitSession();
            }
        }
    }

    public void startNewGame() {
        player.setHealthPoints(100);
        player.setAttackPoints(10);
        player.setLevel(1);
        player.setGold(0);
        System.out.println("Enter your name: ");
        player.setName(input.nextLine());
        System.out.println("Your name is " + player.getName() + "! Welcome!");

        gameMenu = false;
        sessionMenu = true;
        showSessionMenu();
    }

    public void exitGame() {
        System.out.println(TextFormatter.getAnsiBlue("Goodbye!"));
        gameMenu = false;
    }

    public void quitSession() {
        System.out.println(TextFormatter.getAnsiBlue("End of session!"));
        sessionMenu = false;
        gameMenu = true;
    }

    public void saveGame(Player player) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("player.dat"));
            output.writeObject(player);
            output.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadGame() {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("player.dat"));
            player = (Player) input.readObject();
            input.close();
            gameMenu = false;
            showSessionMenu();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
