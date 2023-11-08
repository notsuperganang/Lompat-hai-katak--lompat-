/**
 * Kelas monsGodzilla adalah
 * kelas turunan dari kelas monster (kelas abstrak)
 * di mana kelas monsGodzilla
 * akan Menggantikan metode abstrak dari kelas monster
 *
 * @author Ganang Setyo Hadi
 * @version 10-29-2023
 */

public class monsGodzilla extends monster {

  // Inisialisasi atribut
  private int value;
  private String name;

  /**
   * Konstruktor dengan parameter
   *
   * @param value Nilai monster Godzilla.
   * @param name Nama monster Godzilla.
   */
  public monsGodzilla(int value, String name) {
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
