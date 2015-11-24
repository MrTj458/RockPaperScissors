package rps.controller;

import rps.view.Frame;
 /**
  * Main controller class for the program. Does not do much at the moment.
  * @author thod0127
  *
  */
public class Controller
{
	private Frame baseFrame;
	
	public Controller()
	{
		baseFrame = new Frame(this);
	}
	
	public void start()
	{}
}
