package com.adrianosela.worldbuilder.level;

import com.adrianosela.worldbuilder.world.World;
import java.io.Serializable;

public class Level implements World, Serializable {
  private static final long serialVersionUID = 1L;

  private static final int DEFAULT_WIDTH = 40;
  private static final int DEFAULT_HEIGHT = 40;

  private final int width;
  private final int height;

  /** Default constructor for a {@link Level} which sets default dimensions */
  public Level() {
    this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
  }

  /**
   * Constructor which creates this {@link Level} with the specified width and height. The width and
   * height must both be greater than zero.
   *
   * @param width the number of columns in this {@link Level}
   * @param height the number of rows in this {@link Level}
   */
  public Level(int width, int height) {
    if (width < 1 || height < 1) {
      throw new IllegalArgumentException("width and height must be positive integers");
    }
    this.width = width;
    this.height = height;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public void step() {
    // TODO
  }
}
