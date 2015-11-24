package rps.view;

import rps.controller.Controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Sets up the frame for the program.
 * @author thod0127
 * @version 1.0
 */
public class Frame extends JFrame
{
	private Controller baseController;
	private Panel basePanel;
	
	public Frame(Controller baseController)
	{
		this.baseController = baseController;
		basePanel = new Panel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setSize(400, 400);
		this.setTitle("Rock Paper Scissors!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
