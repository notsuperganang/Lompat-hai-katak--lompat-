/**
 * Class KotakPermainan1 merupakan class yang berisikan jumlah kotak yang akan digunakan dalam permainan,
 * selain itu class ini juga digunakan untuk menyimpan jumlah koin dan monster
 * serta digunakan untuk mengacak koin dan monster pada setiap kotak yang berbeda
 *
 * @author Ganang Setyo Hadi
 * @version 10-29-2023
 */

// package yang digunakan untuk membuat array list dan collections
import java.util.ArrayList;
import java.util.Collections;

public class gbHard {

  // inisialisasi atribut
  private int manyBoxes;
  private int manyCoins;
  private int manyMonsters;
  private int mixCoin[];
  private int mixMonsters[];
  private boxes[] boardGame;

  /**
   * methode constructor dengan parameter
   * @param manyBoxes
   * @param manyCoins
   * @param manyMonsters
   */
  public gbHard(int manyBoxes, int manyCoins, int manyMonsters) {
    this.manyBoxes = manyBoxes;
    this.manyCoins = manyCoins;
    this.manyMonsters = manyMonsters;

    mixGenerator();
    boxesInitialization();
  }

  /**
   * method mengacak list yang digunakan untuk mengisi koin dan monster
   * yang sesuai dengan jumlah kotak, koin dan monster
   */
  private void mixGenerator() {
    // untuk menghasilkan nilai acak yang tidak berulang
    // membuat object array list dengan tipe data integer
    ArrayList<Integer> list = new ArrayList<Integer>();
    mixCoin = new int[manyCoins];
    mixMonsters = new int[manyMonsters];

    // nilai acak sesuai manyBoxes
    for (int i = 0; i < this.manyBoxes; i++) {
      list.add(i); // memasukkan values ke dalam list
    }
    Collections.shuffle(list);

    // untuk menghasilkan nilai acak untuk koin
    for (int i = 0; i < this.manyCoins; i++) {
      mixCoin[i] = list.get(i);
    }

    // untuk menghasilkan position monster pada kotak
    // position monster tidak boleh sama dengan posisi koin
    for (int i = manyCoins; i < manyMonsters + manyCoins; i++) {
      mixMonsters[i - manyCoins] = list.get(i);
    }
  }

  /**
   * methode inisialasi kotak
   * digunakan untuk mengisi kotak yang sudah ada dengan object koin dan monster
   */
  private void boxesInitialization() {
    boardGame = new boxes[manyBoxes];
    coinSilver silver = new coinSilver(10);
    monsGodzilla godzilla = new monsGodzilla(-30, "Godzilla");

    for (int i = 0; i < manyBoxes; i++) {
      boardGame[i] = new boxes();
    }

    for (int i = 0; i < manyCoins; i++) {
      boardGame[mixCoin[i]].addCoin(silver);
    }

    for (int i = 0; i < manyMonsters; i++) {
      boardGame[mixMonsters[i]].addMonster(godzilla);
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
