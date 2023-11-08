/**
 * Kelas monsSquirtel adalah
 * kelas turunan dari kelas monster (kelas abstrak)
 * di mana kelas monsSquirtel
 * akan meng-override metode abstrak dari kelas monster
 *
 * @author Ganang Setyo Hadi
 * @version 10-29-2023
 */

public class monsSquirtel extends monster {

  // Inisialisasi atribut
  private int value;
  private String name;

  /**
   * Konstruktor dengan parameter
   *
   * @param value Nilai monster Squirtel.
   * @param name Nama monster Squirtel.
   */
  public monsSquirtel(int value, String name) {
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
