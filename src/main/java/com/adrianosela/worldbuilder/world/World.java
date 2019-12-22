package com.adrianosela.worldbuilder.world;

/**
 * An implementation of the basic behavior of a {@link World} for which all worlds (levels/screens)
 * conform to
 */
public interface World {
  /** Advances the world by one unit time step */
  void step();

  /**
   * Exposes dimension x
   *
   * @return width (horizontal) dimension of world
   */
  int getWidth();

  /**
   * Exposes dimension y
   *
   * @return height (vertical) dimension of the world
   */
  int getHeight();
}
