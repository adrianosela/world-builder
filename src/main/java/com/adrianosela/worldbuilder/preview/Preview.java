package com.adrianosela.worldbuilder.preview;

import com.adrianosela.worldbuilder.level.Level;
import com.adrianosela.worldbuilder.ui.UI;
import com.adrianosela.worldbuilder.world.World;
import java.io.Serializable;
import javax.swing.SwingUtilities;

/** {@link Preview} describes a Preview of a world */
public class Preview implements Serializable {
  private static final long serialVersionUID = 1L;

  static final int X_DIM = 40;
  static final int Y_DIM = 40;

  /**
   * Entry point for the world preview.
   *
   * @param args Runtime arguments.
   */
  public static void main(String[] args) throws Exception {
    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            World w = new Level(X_DIM, Y_DIM);
            new UI(w).start();
          }
        });
  }
}
