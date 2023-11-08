/**
 * The coinGold class is
 * a derived class from the coin class (abstract class)
 * where the coinGold class
 * will override the abstract method of the coin class
 *
 * @author Ganang Setyo Hadi
 * @version 10-29-2023
 */

public class coinGold extends coin {

  // inisialisasi atribut
  private int value;

  /**
   * methode constructor dengan parameter
   * @param value
   */
  public coinGold(int value) {
    this.value = value;
  }

  @Override
  public int coinValue() {
    return this.value;
  }
}
