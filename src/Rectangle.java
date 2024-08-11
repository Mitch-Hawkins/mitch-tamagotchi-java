public class Rectangle implements Clickable {

  private int x;
  private int y;
  private int width;
  private int height;

  public Rectangle(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  // Getter methods
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  // Method to check if a point is inside the rectangle
  public boolean contains(int mouseX, int mouseY) {
    return (
      mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height
    );
  }

  public void onClick() {
    System.out.println("Rectangle Clicked!");
  }
}
