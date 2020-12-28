package com.codingbootcamp.week1.day1;

public class Point implements Comparable<Point> {

  private final int coordinateX;

  private final int coordinateY;

  public Point(final int coordinateX, final int coordinateY) {
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
  }

  /**
   * Calculates the sum of two Points by summarizing their coordinates
   *
   * @param that the second Point for calculation
   * @return the new Point object with newly created coordinates
   */
  public Point sum(final Point that) {
    return new Point(that.coordinateX + coordinateX, that.coordinateY + coordinateY);
  }

  public int getX() {
    return this.coordinateX;
  }

  public int getY() {
    return this.coordinateY;
  }

  /**
   * Updates the value of the X coordinate
   *
   * @param newX value to be set
   * @return new Point object with updated fields
   */
  public Point updateX(int newX) {
    return new Point(newX, this.coordinateY);
  }

  /**
   * Updates the value of the Y coordinate
   *
   * @param newY value to be set
   * @return new Point object with updated fields
   */
  public Point updateY(int newY) {
    return new Point(this.coordinateX, newY);
  }

  /**
   * Calculates the distance between two Points
   *
   * @param that the second Point for calculation
   * @return calculated integer value of distance
   */
  public int distanceTo(Point that) {
    int deltaX = that.coordinateX - this.coordinateX;
    int deltaY = that.coordinateY - this.coordinateY;
    return (int) Math.sqrt(Math.pow(deltaX, 2.0) + Math.pow(deltaY, 2.0));
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    Point point = (Point) obj;
    return point.coordinateX == this.coordinateX
        && point.coordinateY == this.coordinateY;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + coordinateX;
    result = 31 * result + coordinateY;
    return result;
  }

  @Override
  public String toString() {
    return "Point{"
        + "X: "
        + coordinateX
        + ", Y: "
        + coordinateY
        + '}';
  }

  @Override
  public int compareTo(Point that) {
    if (this.equals(that)) {
      return 0;
    }
    return that.coordinateY - this.coordinateY + that.coordinateX - this.coordinateX;
  }
}
