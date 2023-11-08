/**
 * This class represents a player in the game.
 *
 * @author Ganang Setyo Hadi
 * @version 10-29-2023
 */
public class player {

  private String name;
  private int value;

  /**
   * Constructor for creating a player with a specified name and initializes the value to 0.
   *
   * @param name The name of the player.
   */
  public player(String name) {
    this.name = name;
    // Initial value
    value = 0;
  }

  /**
   * Get the name of the player.
   *
   * @return The name of the player.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Set the name of the player.
   *
   * @param name The name to set for the player.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the value (score/points) of the player.
   *
   * @return The value (score/points) of the player.
   */
  public int getValue() {
    return this.value;
  }

  /**
   * Set the value (score/points) of the player.
   *
   * @param value The value to set for the player.
   */
  public void setValue(int value) {
    this.value = value;
  }
}
