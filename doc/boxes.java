/**
 * Class Kotak merupakan class yang berisikan koin (dari class Koin)
 * dan berisikan monster (dari class Monster)
 *
 * @author Ganang Setyo Hadi
 * @version 10-29-2023
 */

public class boxes {

  // object member (Kotak)
  private coin coin;
  private monster monster;

  /**
   * methode constructor tanpa parameter/first constructor
   */
  public boxes() {}

  /**
   * @param c
   */
  public void addCoin(coin c) {
    this.coin = c;
  }

  /**
   * @param m
   */
  public void addMonster(monster m) {
    this.monster = m;
  }

  /**
   * methode acessor/getter
   * @return coin
   */
  public coin getCoin() {
    return this.coin;
  }

  /**
   * methode acessor/getter
   * @returnmonster
   */
  public monster getMonster() {
    return this.monster;
  }

  /**
   * Metode pengakses dengan nilai pengembalian boolean
   * @return boolean
   */
  public boolean isThereCoin() {
    return coin != null;
  }

  /**
   * Metode pengakses dengan nilai pengembalian boolean
   * @returnboolean
   */
  public boolean isThereMonster() {
    return monster != null;
  }
}
