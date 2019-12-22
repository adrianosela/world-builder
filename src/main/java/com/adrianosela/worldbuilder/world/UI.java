package com.adrianosela.worldbuilder.world;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/** The setup of the Word's {@link UI} */
public class UI extends JPanel implements Serializable {
  private static final long serialVersionUID = 1L;

  private final JFrame frame;
  private final JButton stepButton;
  private final JButton runButton;
  private static final String TITLE_TEXT = "World Preview";
  private static final String START_BUTTON_TEXT = "Start";
  private static final String STOP_BUTTON_TEXT = "Stop";
  private static final String STEP_BUTTON_TEXT = "Step";

  private static final int IMAGE_DEFAULT_SIZE = 16; // pixels
  private static final int RUN_SPEED = 100; // milliseconds

  private final World world;
  private final Timer timer;

  public UI(World w) {
    world = w;

    Dimension preferredSize =
        new Dimension(w.getWidth() * IMAGE_DEFAULT_SIZE, w.getHeight() * IMAGE_DEFAULT_SIZE);
    setPreferredSize(preferredSize);
    setBackground(Color.WHITE);

    timer =
        new Timer(
            RUN_SPEED,
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                step();
              }
            });

    runButton = new JButton(START_BUTTON_TEXT);
    stepButton = new JButton(STEP_BUTTON_TEXT);

    JPanel ctrlPanel = new JPanel(new BorderLayout());
    ctrlPanel.add(runButton, BorderLayout.WEST);
    ctrlPanel.add(stepButton, BorderLayout.EAST);

    stepButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            step();
          }
        });

    runButton.addActionListener(
        new ActionListener() {
          boolean toggle = true;

          @Override
          public void actionPerformed(ActionEvent e) {
            if (toggle) {
              start();
              stepButton.setEnabled(false);
              runButton.setText(STOP_BUTTON_TEXT);
            } else {
              stop();
              stepButton.setEnabled(true);
              runButton.setText(START_BUTTON_TEXT);
            }
            toggle = !toggle;
          }
        });

    // Add the elements.
    frame = new JFrame(TITLE_TEXT);
    Container pane = frame.getContentPane();
    pane.add(this, BorderLayout.CENTER);
    pane.add(ctrlPanel, BorderLayout.SOUTH);

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
  }

  @Override
  public void paintComponent(Graphics graphics) {
    // TODO
  }

  public void start() {
    timer.start();
  }

  public void stop() {
    timer.stop();
  }

  public void step() {
    world.step();
    repaint();
  }
}
