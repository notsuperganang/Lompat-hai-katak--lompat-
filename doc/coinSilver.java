/**
 * The coinSilver class is
 * a derived class from the coin class (abstract class)
 * where the coinSilver class
 * will override the abstract method of the coin class
 *
 * @author Ganang Setyo Hadi
 * @version 10-29-2023
 */

public class coinSilver extends coin {

  // inisialisasi atribut
  private int value;

  /**
   * methode constructor dengan parameter
   * @param value
   */
  public coinSilver(int value) {
    this.value = value;
  }

  @Override
  public int coinValue() {
    return this.value;
  }
}
