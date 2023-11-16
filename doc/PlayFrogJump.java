/**
 * This class is the main class where the program will be executed.
 *
 * @author: Ganang Setyo Hadi
 * @version: 10-29-2023
 * link video : https://drive.google.com/file/d/1cRPdPh7S1hh1Dajt-xz9z2TjTI7L3Y9e/view?usp=sharing
 */

/*
 * Import statement yang memungkinkan
 * penggunaan kelas Scanner untuk
 * interaksi dengan input pengguna.
 */
import java.util.Scanner;

/*
 * Deklarasi kelas utama PlayFrogJump.
 */
public class PlayFrogJump {

    /*
     * Deklarasi variabel dan objek yang akan
     * digunakan dalam kelas, termasuk
     * jumlah koin, jumlah monster, tingkat kesulitan,
     * nama pemain, objek Scanner untuk input pengguna,
     * dan objek permainan untuk tingkat kesulitan yang
     * berbeda (Easy, Normal, Hard, Insane).
     */
    int manyCoins;
    int manyMonsters;
    int level;
    String name;
    public Scanner in = new Scanner(System.in);

    gbEasy easyGame;
    gbNormal normalGame;
    gbHard hardGame;
    gbInsane insaneGame;

    /*
     * Metode statis
     * printGameRules yang mencetak aturan permainan
     */
    public static void printGameRules() {
        System.out.println("\n");
        System.out.println(
                "\t\t===============================================================================");
        System.out.println(
                "\t\t<===================---<     WELCOME TRAVELERS      >---======================>");
        System.out.println(
                "\t\t<===================---<            TO              >---======================>");
        System.out.println(
                "\t\t<===================---<   THE ULTIMATE FROG JUMP   >---======================>");
        System.out.println(
                "\t\t===============================================================================");
        System.out.println("\n\t\tHere are the rules of the game:");
        System.out.println("\t\t********************************************");
        System.out.println(
                "\t\t1. You control a frog that can jump forward or backward.");
        System.out.println(
                "\t\t2. You will encounter different challenges on the way:");
        System.out.println("\t\t   - Coins: Collect coins to earn points.");
        System.out.println(
                "\t\t   - Monsters: Beware of monsters that can deduct points.");
        System.out.println(
                "\t\t3. Choose your difficulty level (Easy, Normal, Hard, or Insane).");
        System.out.println(
                "\t\t4. You can Jump one or two box forward or backward based on your choice.");
        System.out.println(
                "\t\t5. Keep an eye on your frog's position and point score.");
        System.out.println(
                "\t\t6. The game ends when your frog reaches the end or loses all points.");
        System.out.println(
                "\t\t7. Based on your score, you will be classified as:");
        System.out.println(
                "\t\t   - Terrible\n\t\t   - So-so\n\t\t   - Decent\n\t\t   - Legend!");
        System.out.println(
                "\t\t8. You can play again or exit after completing the game.");
        System.out.println("\t\t9. Enjoy the game and have fun!");
        System.out.println("\t\t********************************************");
    }

    /**
     * Retrieves a valid integer input from the user.
     *
     * @param scanner the scanner for user input
     * @param prompt  the prompt message to display
     * @return the valid integer input
     */
    private static int getValidNumberInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\n\n\t\t\t      =================================================");
                System.out.println("\t\t\t      |                                               |");
                System.out.println("\t\t\t      |  Invalid input. Please enter a valid number.  |");
                System.out.println("\t\t\t      |                                               |");
                System.out.println("\t\t\t      =================================================\n");
            }
        }
    }

    /**
     * Retrieves a valid non-empty string input from the user.
     *
     * @param scanner the scanner for user input
     * @param prompt  the prompt message to display
     * @return the valid non-empty string input
     */
    private static String getValidStringInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isBlank()) {
                return input;
            } else {
                System.out.println("\n\n\t\t\t      =================================================");
                System.out.println("\t\t\t      |                                               |");
                System.out.println("\t\t\t      |Invalid input. Please enter a non-empty string.|");
                System.out.println("\t\t\t      |                                               |");
                System.out.println("\t\t\t      =================================================\n");
            }
        }
    }

    /**
     * Metode pribadi Movement yang menampilkan pilihan
     * pergerakan yang dapat dipilih oleh pemain.
     */
    private static void Movement() {
        System.out.print("\n\t\tChoose your next move!");
        System.out.print(
                "\n\t\t1. Jump 1 box forward\n\t\t2. Jump 2 boxes forward\n\t\t3. Jump backward 1 box\n\t\t4. Jump backward 2 boxes\n");
    }

    /*
     * Metode pribadi Congrats
     * yang memberikan ucapan selamat berdasarkan skor pemain.
     */
    private static void Congrats(int playerScore) {
        if (playerScore <= 0) {
            System.out.println("\n\t\tBro, reallY? I cant even say anything -_-.\n");
        } else if (playerScore > 0 && playerScore <= 100) {
            System.out.println("\n\t\tYou are TERRIBLE my guy!\n");
        } else if (playerScore > 100 && playerScore <= 200) {
            System.out.println("\n\t\tIts just so so. No need to be happy like that!\n");
        } else if (playerScore > 200 && playerScore <= 400) {
            System.out.println("\n\t\tPretty DECENT. Not bad I guess\n");
        } else {
            System.out.println("\n\t\tYO! You are trully a LEGEND!!!!.\n");
        }
    }

    /*
     * Konstruktor kelas PlayFrogJump yang memulai
     * permainan dan mengatur tingkat kesulitan berdasarkan pilihan pengguna.
     */
    public PlayFrogJump() {
        frog frog = new frog();
        player player;
        int choice;

        name = getValidStringInput(in, "\n\t\tPlease input your name\t : ");
        player = new player(name);

        System.out.println(
                "\n\t\t\t+-----------------------------------------------------------------+");
        System.out.println(
                "\t\t\t\tHave fun there " +
                        player.getName() +
                        ", May the force be with you!");
        System.out.println(
                "\t\t\t+-----------------------------------------------------------------+\n");
        while (true) {
            System.out.print("\t\t\t\tPlease select the difficulty level!");
            System.out.print(
                    "\n\t\t\t\t1. Easy\n\t\t\t\t2. Normal\n\t\t\t\t3. Hard\n\t\t\t\t4. Insane\n");
            level = getValidNumberInput(in, "\n\t\tYour Choice : ");
            System.out.print("\n");
            if (level >= 1 && level <= 4) {
                break;
            } else {
                System.out.print(
                        "\n\t\t\t\t==================================================");
                System.out.print(
                        "\n\t\t\t\t|     The Difficulity You Choose Is Invalid!     |");
                System.out.print("\n\t\t\t\t|Please Choose According To The Available Options|");
                System.out.print(
                        "\n\t\t\t\t==================================================\n\n");
            }
        }

        switch (level) {
            case 1:
                System.out.print("\t\t\t\t\t============================\n");
                System.out.print("\t\t\t\t\t  Difficulity Level : Easy  \n");
                System.out.print("\t\t\t\t\t============================\n");
                gbEasy easyGame = new gbEasy(300, 150, 120);
                break;
            case 2:
                System.out.print("\t\t\t\t\t==============================\n");
                System.out.print("\t\t\t\t\t  Difficulity Level : Normal  \n");
                System.out.print("\t\t\t\t\t==============================\n");
                gbNormal normalGame = new gbNormal(300, 130, 150);
                break;
            case 3:
                System.out.print("\t\t\t\t\t============================\n");
                System.out.print("\t\t\t\t\t  Difficulity Level : Hard  \n");
                System.out.print("\t\t\t\t\t============================\n");
                gbHard hardGame = new gbHard(300, 110, 170);
                break;
            case 4:
                System.out.print("\t\t\t\t\t==============================\n");
                System.out.print("\t\t\t\t\t  Difficulity Level : Insane  \n");
                System.out.print("\t\t\t\t\t==============================\n");
                gbInsane insaneGame = new gbInsane(300, 95, 190);
                break;
        }

        System.out.println("\n\t\tYour starting point Is: " + frog.getPoint());
        System.out.println(
                "\t\tNow your frog is in the " + frog.getPosition() + " box position");
        while (frog.getPosition() < 299 && frog.getPoint() > 0) {
            if (frog.getPosition() == 298) {
                System.out.print("\n\t\tHey! Its ur last jump!!");
            }

            int newPosition = frog.getPosition();
            Movement();
            choice = getValidNumberInput(in, "\n\t\tYour Choice : ");
            System.out.println(
                    "\t\t-----------------------------------------------------------------\n");

            if (frog.getPosition() == 0 && (choice == 3 || choice == 4)) {
                System.out.print("\t\t\t\t==========================================================");
                System.out.print("\n\t\t\t\t|   You cannot jump back if you are on the 0th square    |");
                System.out.print("\n\t\t\t\t==========================================================\n");
                continue;
            }

            if (choice == 1) {
                frog.jump1fwd();
            } else if (choice == 2) {
                if ((newPosition += 2) >= 300) {
                    frog.setPosition(299);
                } else {
                    frog.jump2fwd();
                }
            } else if (choice == 3) {
                if ((newPosition -= 1) <= 0) {
                    frog.setPosition(0);
                } else {
                    frog.jump1bwd();
                }
            } else if (choice == 4) {
                if ((newPosition -= 2) <= 0) {
                    frog.setPosition(0);
                } else {
                    frog.jump2bwd();
                }
            } else {
                System.out.print(
                        "\n\t\t\t\t==================================================");
                System.out.print(
                        "\n\t\t\t\t|     The Option You Choose Is Invalid!          |");
                System.out.print("\n\t\t\t\t|Please Choose According To The Available Options|");
                System.out.print(
                        "\n\t\t\t\t==================================================\n\n");
                continue;
            }

            gbEasy easyGame = new gbEasy(300, 150, 120);
            gbNormal normalGame = new gbNormal(300, 130, 150);
            gbHard hardGame = new gbHard(300, 110, 170);
            gbInsane insaneGame = new gbInsane(300, 95, 190);

            switch (level) {
                case 1:
                    frog.setPoint(frog.getPoint() + easyGame.contain(frog.getPosition()));
                    if (easyGame.contain(frog.getPosition()) == 50) {
                        System.out.print(
                                "\n\t\t\t\t\t==========================================");
                        System.out.print(
                                "\n\t\t\t\t\t||        EXTRAORDINARYYYYY!!           ||");
                        System.out.print(
                                "\n\t\t\t\t\t||      YOU FOUND A DIAMOND COINN!!!    ||");
                        System.out.print(
                                "\n\t\t\t\t\t||    IT GIVES YOU 50 EXTRA POINTS!!!   ||");
                        System.out.print(
                                "\n\t\t\t\t\t==========================================\n");
                        System.out.println(
                                "\n\t\tYour Point Right Now Is: " + frog.getPoint());
                        System.out.println(
                                "\t\tNow your frog is in the " +
                                        frog.getPosition() +
                                        " box position");
                    } else if (easyGame.contain(frog.getPosition()) == -5) {
                        System.out.print(
                                "\n\t\t\t\t\t===========================================================");
                        System.out.print(
                                "\n\t\t\t\t\t||                         Mehhhhh                       ||");
                        System.out.print(
                                "\n\t\t\t\t\t||       Your againts squirtle, it's not very scary!     ||");
                        System.out.print(
                                "\n\t\t\t\t\t||   it just ask you for a candy, so u have to buy it    ||");
                        System.out.print(
                                "\n\t\t\t\t\t||          and that candy cost you 5 points :)          ||");
                        System.out.print(
                                "\n\t\t\t\t\t===========================================================\n");
                        System.out.println(
                                "\n\t\tYour Point Right Now Is: " + frog.getPoint());
                        System.out.println(
                                "\t\tNow your frog is in the " +
                                        frog.getPosition() +
                                        " box position");
                    } else {
                        System.out.print(
                                "\n\t\t\t\t\t==========================================");
                        System.out.print(
                                "\n\t\t\t\t\t||              HAHAHAHA                ||");
                        System.out.print(
                                "\n\t\t\t\t\t||              HAHAHAHA                ||");
                        System.out.print(
                                "\n\t\t\t\t\t||     You Did Not Find ANYTHING!!      ||");
                        System.out.print(
                                "\n\t\t\t\t\t==========================================\n");
                        System.out.println(
                                "\n\t\tour Point Right Now Is: " + frog.getPoint());
                        System.out.println(
                                "\t\tNow your frog is in the " +
                                        frog.getPosition() +
                                        " box position");
                    }
                    break;
                case 2:
                    frog.setPoint(
                            frog.getPoint() + normalGame.contain(frog.getPosition()));
                    if (normalGame.contain(frog.getPosition()) == 30) {
                        System.out.print(
                                "\n\t\t\t\t\t==========================================");
                        System.out.print(
                                "\n\t\t\t\t\t||            UNBELIEVABLE!             ||");
                        System.out.print(
                                "\n\t\t\t\t\t||      You found a GOLD coin!!!        ||");
                        System.out.print(
                                "\n\t\t\t\t\t||    It gives you 30 extra points      ||");
                        System.out.print(
                                "\n\t\t\t\t\t==========================================\n");
                        System.out.println(
                                "\n\t\tYour Point Right Now Is: " + frog.getPoint());
                        System.out.println(
                                "\t\tNow your frog is in the " +
                                        frog.getPosition() +
                                        " box position");
                    } else if (normalGame.contain(frog.getPosition()) == -18) {
                        System.out.print(
                                "\n\t\t\t\t\t==========================================================");
                        System.out.print(
                                "\n\t\t\t\t\t||                      Carefull!!                      ||");
                        System.out.print(
                                "\n\t\t\t\t\t||     You're againts SNORLAX, it's kinda aggresive.    ||");
                        System.out.print(
                                "\n\t\t\t\t\t||           HE ATTACKS YOU WITH HIS HEAVY SLAM         ||");
                        System.out.print(
                                "\n\t\t\t\t\t||             AND MAKES YOU LOSE 18 POINTS             ||");
                        System.out.print(
                                "\n\t\t\t\t\t==========================================================\n");
                        System.out.println(
                                "\n\t\tYour Point Right Now Is: " + frog.getPoint());
                        System.out.println(
                                "\t\tNow your frog is in the " +
                                        frog.getPosition() +
                                        " box position");
                    } else {
                        System.out.print(
                                "\n\t\t\t\t\t==========================================");
                        System.out.print(
                                "\n\t\t\t\t\t||              HAHAHAHA                ||");
                        System.out.print(
                                "\n\t\t\t\t\t||              HAHAHAHA                ||");
                        System.out.print(
                                "\n\t\t\t\t\t||     You Did Not Find ANYTHING!!      ||");
                        System.out.print(
                                "\n\t\t\t\t\t==========================================\n");
                        System.out.println(
                                "\n\t\tYour Point Right Now Is: " + frog.getPoint());
                        System.out.println(
                                "\t\tNow your frog is in the " +
                                        frog.getPosition() +
                                        " box position");
                    }
                    break;
                case 3:
                    frog.setPoint(frog.getPoint() + hardGame.contain(frog.getPosition()));
                    if (hardGame.contain(frog.getPosition()) == 10) {
                        System.out.print(
                                "\n\t\t\t\t\t=======================================");
                        System.out.print(
                                "\n\t\t\t\t\t||              Hey!                 ||");
                        System.out.print(
                                "\n\t\t\t\t\t||     You Found a SILVER Coin!!.    ||");
                        System.out.print(
                                "\n\t\t\t\t\t||    It gives you 10 extra points   ||");
                        System.out.print(
                                "\n\t\t\t\t\t=======================================\n");
                        System.out.println(
                                "\n\t\tYour Point Right Now Is: " + frog.getPoint());
                        System.out.println(
                                "\t\tNow your frog is in the " +
                                        frog.getPosition() +
                                        " box position");
                    } else if (hardGame.contain(frog.getPosition()) == -30) {
                        System.out.print(
                                "\n\t\t\t\t\t===========================================================");
                        System.out.print(
                                "\n\t\t\t\t\t||                        OH NOOO                        ||");
                        System.out.print(
                                "\n\t\t\t\t\t||      YOU'RE AGAINTS GODZILLA, THE KING OF MONSTERR    ||");
                        System.out.print(
                                "\n\t\t\t\t\t||           HE ATTACKS YOU WITH HIS FIRE BREATH         ||");
                        System.out.print(
                                "\n\t\t\t\t\t||             AND MAKES YOU LOSE 30 POINTS              ||");
                        System.out.print(
                                "\n\t\t\t\t\t===========================================================\n");
                        System.out.println(
                                "\n\t\tYour Point Right Now Is: " + frog.getPoint());
                        System.out.println(
                                "\t\tNow your frog is in the " +
                                        frog.getPosition() +
                                        " box position");
                    } else {
                        System.out.print(
                                "\n\t\t\t\t\t==========================================");
                        System.out.print(
                                "\n\t\t\t\t\t||              HAHAHAHA                ||");
                        System.out.print(
                                "\n\t\t\t\t\t||              HAHAHAHA                ||");
                        System.out.print(
                                "\n\t\t\t\t\t||     You Did Not Find ANYTHING!!      ||");
                        System.out.print(
                                "\n\t\t\t\t\t==========================================\n");
                        System.out.println(
                                "\n\t\tYour Point Right Now Is: " + frog.getPoint());
                        System.out.println(
                                "\t\tNow your frog is in the " +
                                        frog.getPosition() +
                                        " box position");
                    }
                    break;
                case 4:
                    frog.setPoint(
                            frog.getPoint() + insaneGame.contain(frog.getPosition()));
                    if (insaneGame.contain(frog.getPosition()) == 5) {
                        System.out.print(
                                "\n\t\t\t\t\t======================================");
                        System.out.print(
                                "\n\t\t\t\t\t||            Oh Look!              ||");
                        System.out.print(
                                "\n\t\t\t\t\t||     You found a BRONZE coin!.    ||");
                        System.out.print(
                                "\n\t\t\t\t\t||    It gives you 5 extra points   ||");
                        System.out.print(
                                "\n\t\t\t\t\t======================================\n");
                        System.out.println(
                                "\n\t\tYour Point Right Now Is: " + frog.getPoint());
                        System.out.println(
                                "\t\tNow your frog is in the " +
                                        frog.getPosition() +
                                        " box position");
                    } else if (insaneGame.contain(frog.getPosition()) == -90) {
                        System.out.print(
                                "\n\t\t\t\t\t===========================================================");
                        System.out.print(
                                "\n\t\t\t\t\t||        DUN DUN DUN DUNNNN MAX VERTSAPENN!!            ||");
                        System.out.print(
                                "\n\t\t\t\t\t||      YOU'RE AGAINTS MAX VERSTAPPEN, THE MAD MAX       ||");
                        System.out.print(
                                "\n\t\t\t\t\t||           HE ATTACKS YOU WITH HIS F1 CAR              ||");
                        System.out.print(
                                "\n\t\t\t\t\t||             AND MAKES YOU LOSE 90 POINTS              ||");
                        System.out.print(
                                "\n\t\t\t\t\t===========================================================\n");
                        System.out.println(
                                "\n\t\tYour Point Right Now Is: " + frog.getPoint());
                        System.out.println(
                                "\t\tNow your frog is in the " +
                                        frog.getPosition() +
                                        " box position");
                    } else {
                        System.out.print(
                                "\n\t\t\t\t\t==========================================");
                        System.out.print(
                                "\n\t\t\t\t\t||              HAHAHAHA                ||");
                        System.out.print(
                                "\n\t\t\t\t\t||              HAHAHAHA                ||");
                        System.out.print(
                                "\n\t\t\t\t\t||     You Did Not Find ANYTHING!!      ||");
                        System.out.print(
                                "\n\t\t\t\t\t==========================================\n");
                        System.out.println(
                                "\n\t\tYour Point Right Now Is: " + frog.getPoint());
                        System.out.println(
                                "\t\tNow your frog is in the " +
                                        frog.getPosition() +
                                        " box position");
                    }
                    break;
            }
        }

        if (frog.getPoint() <= 0) {
            System.out.println(
                    "\t\t-----------------------------------------------------------------\n");
            System.out.print(
                    "\n\t\t\t\t\t==========================================");
            System.out.print(
                    "\n\t\t\t\t\t||              GAME OVER!              ||");
            System.out.print(
                    "\n\t\t\t\t\t||         BRO, YOUR FROG DIED!         ||");
            System.out.print(
                    "\n\t\t\t\t\t==========================================");
        }
        System.out.print("\n\t\tThe Game is Finished!");
        player.setValue(frog.getPoint());
        int playerScore = player.getValue();
        System.out.print("\n\t\tPlayer's Name : " + player.getName() + "\n");
        Congrats(playerScore);
    }

    /**
     * Metode utama main yang memulai eksekusi program dan
     * memberikan menu kepada pengguna untuk
     * memilih opsi permainan, menampilkan aturan permainan
     * , atau keluar dari program.
     */
    public static void main(String[] args) {
        int choice;
        boolean playAgain;

        Scanner ip = new Scanner(System.in);
        Scanner ent = new Scanner(System.in);

        do {
            System.out.println("\n");
            System.out.println(
                    "\t\t===============================================================================");
            System.out.println(
                    "\t\t<===================---<     WELCOME TRAVELERS      >---======================>");
            System.out.println(
                    "\t\t<===================---<            TO              >---======================>");
            System.out.println(
                    "\t\t<===================---<   THE ULTIMATE FROG JUMP   >---======================>");
            System.out.println(
                    "\t\t===============================================================================");
            System.out.println("\n");
            System.out.println("\t\t\t\t\t+-----------------------+ ");
            System.out.println("\t\t\t\t\t|         Menu          |");
            System.out.println("\t\t\t\t\t+-----------------------+ ");
            System.out.println("\t\t\t\t\t|       1. Play         |");
            System.out.println("\t\t\t\t\t|       2. Rules        |");
            System.out.println("\t\t\t\t\t|       3. Exit         |");
            System.out.println("\t\t\t\t\t+-----------------------+ ");

            choice = getValidNumberInput(ip, "\n\t\tPlease enter your choice : ");

            if (choice == 1) {
                do {
                    PlayFrogJump playing = new PlayFrogJump();
                    System.out.print("\n\t\tDo you want to play again? (1 for Yes / 0 for No): ");
                    int playChoice = getValidNumberInput(ip,
                            "\n\t\tDo you want to play again? (1 for Yes / 0 for No): ");
                    playAgain = false;
                    if (playChoice == 1) {
                        playAgain = true;
                    } else if (playChoice == 0) {
                        playAgain = false;
                    } else {
                        System.out.print(
                                "\n\t\t\t\t==================================================");
                        System.out.print(
                                "\n\t\t\t\t|     The Option You Choose Is Invalid!          |");
                        System.out.print("\n\t\t\t\t|Please Choose According To The Available Options|");
                        System.out.print(
                                "\n\t\t\t\t==================================================\n");
                    }
                } while (playAgain);
            } else if (choice == 2) {
                printGameRules();
                System.out.println("\t\tPress enter to return to menu!");
                ent.nextLine();
                continue;
            } else if (choice == 3) {
                break;
            } else {
                System.out.print(
                        "\n\n\t\t\t\t==================================================");
                System.out.print(
                        "\n\t\t\t\t|     The Option You Choose Is Invalid!          |");
                System.out.print("\n\t\t\t\t|Please Choose According To The Available Options|");
                System.out.print(
                        "\n\t\t\t\t==================================================\n");
                continue;
            }
        } while (true);

        ip.close();

        ent.close();
    }
}
