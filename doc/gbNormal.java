/**
 * Kelas gbNormal merupakan kelas yang digunakan untuk mengatur jumlah kotak yang akan digunakan dalam permainan.
 * Selain itu, kelas ini juga digunakan untuk menyimpan jumlah koin dan monster,
 * serta mengacak koin dan monster pada setiap kotak yang berbeda.
 *
 * @author Ganang Setyo Hadi
 * @version 10-29-2023
 */

// Package yang digunakan untuk membuat ArrayList dan Collections
import java.util.ArrayList;
import java.util.Collections;

public class gbNormal {

  // Inisialisasi atribut
  private int manyBoxes;
  private int manyCoins;
  private int manyMonsters;
  private int mixCoin[];
  private int mixMonsters[];
  private boxes[] boardGame;

  /**
   * Konstruktor dengan parameter untuk menginisialisasi kelas gbNormal.
   *
   * @param manyBoxes Jumlah kotak dalam permainan.
   * @param manyCoins Jumlah koin yang akan ditempatkan di kotak.
   * @param manyMonsters Jumlah monster yang akan ditempatkan di kotak.
   */
  public gbNormal(int manyBoxes, int manyCoins, int manyMonsters) {
    this.manyBoxes = manyBoxes;
    this.manyCoins = manyCoins;
    this.manyMonsters = manyMonsters;

    mixGenerator();
    boxesInitialization();
  }

  /**
   * Metode untuk mengacak indeks yang digunakan untuk mengisi koin dan monster sesuai dengan jumlah kotak, koin, dan monster.
   */
  private void mixGenerator() {
    // Untuk menghasilkan nilai acak yang tidak berulang,
    // membuat objek ArrayList dengan tipe data integer.
    ArrayList<Integer> list = new ArrayList<Integer>();
    mixCoin = new int[manyCoins];
    mixMonsters = new int[manyMonsters];

    // Menghasilkan nilai acak sesuai dengan manyBoxes.
    for (int i = 0; i < this.manyBoxes; i++) {
      list.add(i); // Memasukkan nilai ke dalam list.
    }
    Collections.shuffle(list);

    // Menghasilkan nilai acak untuk koin.
    for (int i = 0; i < this.manyCoins; i++) {
      mixCoin[i] = list.get(i);
    }

    // Menghasilkan posisi monster pada kotak.
    // Posisi monster tidak boleh sama dengan posisi koin.
    for (int i = manyCoins; i < manyMonsters + manyCoins; i++) {
      mixMonsters[i - manyCoins] = list.get(i);
    }
  }

  /**
   * Metode inisialisasi kotak.
   * Digunakan untuk mengisi kotak yang sudah ada dengan objek koin dan monster.
   */
  private void boxesInitialization() {
    boardGame = new boxes[manyBoxes];
    coinGold gold = new coinGold(30);
    monsSnorlax snorlax = new monsSnorlax(-18, "Snorlax");

    for (int i = 0; i < manyBoxes; i++) {
      boardGame[i] = new boxes();
    }

    for (int i = 0; i < manyCoins; i++) {
      boardGame[mixCoin[i]].addCoin(gold);
    }

    for (int i = 0; i < manyMonsters; i++) {
      boardGame[mixMonsters[i]].addMonster(snorlax);
    }
  }

  /**
   * Metode untuk mengembalikan nilai di kotak tertentu.
   *
   * @param position Posisi kotak yang ingin dicek.
   * @return Nilai di kotak tersebut (nilai koin atau monster) atau 0 jika kotak kosong.
   */
  public int contain(int position) {
    if (boardGame[position].isThereCoin()) {
      return boardGame[position].getCoin().coinValue();
    } else if (boardGame[position].isThereMonster()) {
      return boardGame[position].getMonster().monsValue();
    } else {
      return 0;
    }
  }
}
