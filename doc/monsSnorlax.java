/**
 * The monsSnorlax class is
 * a derived class from the monster class (abstract class)
 * where the monsSnorlax class
 * will Override the abstract method of the monster class
 *
 * @author Ganang Setyo Hadi
 * @version 10-29-2023
 */

public class monsSnorlax extends monster {

  // inisialisasi atribut
  private int value;
  private String name;

  /**
   * methode constructor dengan parameter
   * @param value
   * @param name
   */
  public monsSnorlax(int value, String name) {
    this.value = value;
    this.name = name;
  }

  @Override
  public int monsValue() {
    return this.value;
  }

  @Override
  public String monsName() {
    return this.name;
  }
}
