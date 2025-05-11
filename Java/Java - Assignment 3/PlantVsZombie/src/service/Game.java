package service;

import entities.PeaShooter;
import entities.Zombie;

public class Game {
    public static void main(String[] args) {
        PeaShooter peaShooter = new PeaShooter(5, 1);
        Zombie zombie = new Zombie(10, 1);

        int round = 1;

        while (zombie.isAlive() && zombie.getX() >= peaShooter.getX()) {
            System.out.println("------ Round " + round + " ------");

            peaShooter.update();
            zombie.update();

            int distance = zombie.getX() - peaShooter.getX();
            if (distance <= 5 && distance >= 0) {
                peaShooter.shoot(zombie);
            }

            if (!zombie.isAlive()) {
                System.out.println("Zombie is defeated!");
                break;
            }

            if (zombie.getX() < peaShooter.getX()) {
                System.out.println("Zombie passed the PeaShooter! Game Over.");
                break;
            }

            round++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
