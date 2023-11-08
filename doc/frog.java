/**
 * Kelas ini digunakan sebagai representasi seekor katak dalam permainan. Kelas ini berisi informasi tentang posisi dan skor dari katak.
 *
 * @author Ganang Setyo Hadi
 * @version 10-29-2023
 */
public class frog {

  // Variabel instance
  private int point; // Skor katak
  private int position; // Posisi katak

  /**
   * Konstruktor tanpa parameter yang menginisialisasi skor dan posisi katak.
   */
  public frog() {
    this.point = 100;
    this.position = 0;
  }

  /**
   * Metode akses yang mengembalikan posisi katak.
   *
   * @return Posisi katak
   */
  public int getPosition() {
    return this.position;
  }

  /**
   * Metode mutator yang mengatur posisi katak ke nilai yang baru.
   *
   * @param position Posisi baru untuk katak
   */
  public void setPosition(int position) {
    this.position = position;
  }

  /**
   * Metode akses yang mengembalikan skor katak.
   *
   * @return Skor katak
   */
  public int getPoint() {
    return this.point;
  }

  /**
   * Metode mutator yang mengatur skor katak ke nilai yang baru.
   *
   * @param point Skor baru untuk katak
   */
  public void setPoint(int point) {
    this.point = point;
  }

  /**
   * Metode yang membuat katak melompat satu kali ke depan.
   *
   * @return Posisi ditambah 1
   */
  public int jump1fwd() {
    System.out.print("\t\tKatak melompat satu kali ke depan!\n");
    return this.position += 1;
  }

  /**
   * Metode yang membuat katak melompat dua kali ke depan.
   *
   * @return Posisi ditambah 2
   */
  public int jump2fwd() {
    System.out.print("\t\tKatak melompat dua kali ke depan!\n");
    return this.position += 2;
  }

  /**
   * Metode yang membuat katak melompat satu kali ke belakang.
   *
   * @return Posisi dikurangi 1
   */
  public int jump1bwd() {
    System.out.print("\t\tKatak melompat satu kali ke belakang!\n");
    return this.position -= 1;
  }

  /**
   * Metode yang membuat katak melompat dua kali ke belakang.
   *
   * @return Posisi dikurangi 2
   */
  public int jump2bwd() {
    System.out.print("\t\tKatak melompat dua kali ke belakang!\n");
    return this.position -= 2;
  }
}
