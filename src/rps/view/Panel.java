package rps.view;

import rps.controller.Controller;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel extends JPanel
{
	private Controller baseController;
	private SpringLayout baseLayout;
	private boolean isMultiplayer;
	private String selection;
	private String user2Selection;
	private int userPoints;
	private int botPoints;
	private JButton rockButton;
	private JButton paperButton;
	private JButton scissorsButton;
	private JButton shootButton;
	private JLabel selectionLabel;
	private JLabel userPointsLabel;
	private JLabel botPointsLabel;
	private JLabel dogeFaceLabel;
	private JCheckBox multiplayerToggle;
	private JButton rockButton2;
	private JButton paperButton2;
	private JButton scissorsButton2;
	private JButton hideSelectionButton;
	private JLabel titleLabel;
	
	public Panel(Controller baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		rockButton = new JButton("Rock");
		selection = "";
		user2Selection ="";
		userPoints = 0;
		botPoints = 0;
		paperButton = new JButton("Paper");
		scissorsButton = new JButton("Scissors");
		shootButton = new JButton("Shoot");
		selectionLabel = new JLabel("You selected: ");
		userPointsLabel = new JLabel("Your points: " + userPoints);
		botPointsLabel = new JLabel("Bot points: " + botPoints);
		dogeFaceLabel = new JLabel(new ImageIcon(getClass().getResource("images/doge.png")));
		multiplayerToggle = new JCheckBox("Multiplayer");
		rockButton2 = new JButton("Rock");
		paperButton2 = new JButton("Paper");
		scissorsButton2 = new JButton("Scissors");
		hideSelectionButton = new JButton("Hide selection");
		titleLabel = new JLabel("Rock Paper Scissors!");
		baseLayout.putConstraint(SpringLayout.WEST, titleLabel, 135, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, titleLabel, -37, SpringLayout.NORTH, selectionLabel);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.lightGray);
		this.add(rockButton);
		this.add(paperButton);
		this.add(scissorsButton);
		this.add(selectionLabel);
		this.add(userPointsLabel);
		this.add(botPointsLabel);
		this.add(shootButton);
		this.add(dogeFaceLabel);
		this.add(multiplayerToggle);
		this.add(rockButton2);
		this.add(paperButton2);
		this.add(scissorsButton2);
		this.add(hideSelectionButton);
		hideSelectionButton.setToolTipText("Click this button to get rid of the highlighted buttons");
		this.add(titleLabel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, selectionLabel, 103, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, selectionLabel, 166, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, botPointsLabel, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, paperButton, 6, SpringLayout.SOUTH, rockButton);
		baseLayout.putConstraint(SpringLayout.WEST, paperButton, 0, SpringLayout.WEST, rockButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, rockButton, -244, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, scissorsButton, 6, SpringLayout.SOUTH, paperButton);
		baseLayout.putConstraint(SpringLayout.WEST, scissorsButton, 0, SpringLayout.WEST, rockButton);
		baseLayout.putConstraint(SpringLayout.WEST, rockButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, shootButton, 0, SpringLayout.WEST, selectionLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, shootButton, 0, SpringLayout.NORTH, paperButton);
		baseLayout.putConstraint(SpringLayout.WEST, multiplayerToggle, 0, SpringLayout.WEST, rockButton);
		baseLayout.putConstraint(SpringLayout.NORTH, userPointsLabel, 0, SpringLayout.NORTH, botPointsLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, botPointsLabel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, userPointsLabel, 0, SpringLayout.WEST, rockButton);
		baseLayout.putConstraint(SpringLayout.NORTH, scissorsButton2, 0, SpringLayout.NORTH, scissorsButton);
		baseLayout.putConstraint(SpringLayout.EAST, scissorsButton2, 0, SpringLayout.EAST, botPointsLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, paperButton2, 0, SpringLayout.NORTH, paperButton);
		baseLayout.putConstraint(SpringLayout.EAST, paperButton2, 0, SpringLayout.EAST, botPointsLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, rockButton2, 0, SpringLayout.NORTH, rockButton);
		baseLayout.putConstraint(SpringLayout.EAST, rockButton2, 0, SpringLayout.EAST, botPointsLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, multiplayerToggle, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, hideSelectionButton, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, hideSelectionButton, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, dogeFaceLabel, -6, SpringLayout.WEST, scissorsButton2);
		baseLayout.putConstraint(SpringLayout.NORTH, dogeFaceLabel, 0, SpringLayout.NORTH, scissorsButton);
	}
	
	private void setupListeners()
	{
		rockButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				selection = "Rock";
				if(!isMultiplayer)
				{
					selectionLabel.setText("You selected: " + selection);
				}
			}
		});
		
		paperButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				selection = "Paper";
				if(!isMultiplayer)
				{
					selectionLabel.setText("You selected: " + selection);
				}
			}
		});
		
		scissorsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				selection = "Scissors";
				if(!isMultiplayer)
				{
					selectionLabel.setText("You selected: " + selection);
				}
			}
		});
		
		rockButton2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				user2Selection = "Rock";
			}
		});
		
		paperButton2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				user2Selection = "Paper";
			}
		});
		
		scissorsButton2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				user2Selection = "Scissors";
			}
		});
		
		shootButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(isMultiplayer)
				{
					if(!selection.equals("") && !user2Selection.equals(""))
					{
						multiplayerCalculate();
					}
					else
					{
						JOptionPane.showMessageDialog(shootButton, "One of the users did not make a selection!");
						selection = "";
						user2Selection = "";
					}
				}
				else
				{
					if(!selection.equals(""))
					{
						botSelect();
					}
					else
					{
						JOptionPane.showMessageDialog(shootButton, "Make a selection first!");
					}
				}
			}
		});
		
		multiplayerToggle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(!isMultiplayer)
				{
					isMultiplayer = true;
					selectionLabel.setText("Multiplayer Selected!");
					selection = "";
					user2Selection = "";
					botPoints = 0;
					userPoints = 0;
					userPointsLabel.setText("User 1 points: " + userPoints);
					botPointsLabel.setText("User 2 points: " + botPoints);
				}
				else
				{
					isMultiplayer = false;
					selectionLabel.setText("You selected: " + selection);
					selection = "";
					user2Selection = "";
					userPoints = 0;
					botPoints = 0;
					userPointsLabel.setText("Your points: " + userPoints);
					botPointsLabel.setText("Bot points: " + botPoints);
				}
			}
		});
	}
	
	private void multiplayerCalculate()
	{
		if(selection.equals("Rock"))
		{
			if(user2Selection.equals("Rock"))
			{
				JOptionPane.showMessageDialog(shootButton, "Rock Vs. Rock!");
				JOptionPane.showMessageDialog(shootButton, "You tied!");
			}
			else if(user2Selection.equals("Paper"))
			{
				JOptionPane.showMessageDialog(shootButton, "Rock Vs. Paper!");
				JOptionPane.showMessageDialog(shootButton, "User 2 wins!");
				botPoints++;
			}
			else if(user2Selection.equals("Scissors"))
			{
				JOptionPane.showMessageDialog(shootButton, "Rock Vs. Scissors!");
				JOptionPane.showMessageDialog(shootButton, "User 1 wins!");
				userPoints++;
			}
		}
		else if(selection.equals("Paper"))
		{
			if(user2Selection.equals("Rock"))
			{
				JOptionPane.showMessageDialog(shootButton, "Paper Vs. Rock!");
				JOptionPane.showMessageDialog(shootButton, "user 1 wins!");
				userPoints++;
			}
			else if(user2Selection.equals("Paper"))
			{
				JOptionPane.showMessageDialog(shootButton, "Paper Vs. Paper!");
				JOptionPane.showMessageDialog(shootButton, "You tied!");
			}
			else if(user2Selection.equals("Scissors"))
			{
				JOptionPane.showMessageDialog(shootButton, "Paper Vs. Scissors!");
				JOptionPane.showMessageDialog(shootButton, "User 2 wins!");
				botPoints++;
			}
		}
		else if(selection.equals("Scissors"))
		{
			if(user2Selection.equals("Rock"))
			{
				JOptionPane.showMessageDialog(shootButton, "Scissors Vs. Rock!");
				JOptionPane.showMessageDialog(shootButton, "user 2 wins!");
				botPoints++;
			}
			else if(user2Selection.equals("Paper"))
			{
				JOptionPane.showMessageDialog(shootButton, "Scissors Vs. Paper!");
				JOptionPane.showMessageDialog(shootButton, "User 1 wins!");
				userPoints++;
			}
			else if(user2Selection.equals("Scissors"))
			{
				JOptionPane.showMessageDialog(shootButton, "Scissors Vs. Scissors!");
				JOptionPane.showMessageDialog(shootButton, "You tied!");
			}
		}
		userPointsLabel.setText("User 1 points: " + userPoints);
		botPointsLabel.setText("User 2 points: " + botPoints);
		selection = "";
		user2Selection = "";
	}
	
	private void botSelect()
	{
		int botChoice;
		botChoice = (int) (Math.random() * 3);
		
		if(botChoice == 0) //rock
		{
			JOptionPane.showMessageDialog(shootButton, "The bot selected: Rock!");
			if(selection.equals("Rock"))
			{
				JOptionPane.showMessageDialog(shootButton, "You tied!");
			}
			else if(selection.equals("Paper"))
			{
				JOptionPane.showMessageDialog(shootButton, "You won!");
				userPoints++;
			}
			else if(selection.equals("Scissors"))
			{
				JOptionPane.showMessageDialog(shootButton, "You lost!");
				botPoints++;
			}
		}
		else if(botChoice == 1) //paper
		{
			JOptionPane.showMessageDialog(shootButton, "The bot selected: Paper!");
			if(selection.equals("Rock"))
			{
				JOptionPane.showMessageDialog(shootButton, "You Lost!");
				botPoints++;
			}
			else if(selection.equals("Paper"))
			{
				JOptionPane.showMessageDialog(shootButton, "You Tied!");
			}
			else if(selection.equals("Scissors"))
			{
				JOptionPane.showMessageDialog(shootButton, "You Won!");
				userPoints++;
			}
		}
		else if(botChoice == 2) //scissors
		{
			JOptionPane.showMessageDialog(shootButton, "The bot selected: Scissors!");
			if(selection.equals("Rock"))
			{
				JOptionPane.showMessageDialog(shootButton, "You won!");
				userPoints++;
			}
			else if(selection.equals("Paper"))
			{
				JOptionPane.showMessageDialog(shootButton, "You Lost!");
				botPoints++;
			}
			else if(selection.equals("Scissors"))
			{
				JOptionPane.showMessageDialog(shootButton, "You tied!");
			}
		}
		
		userPointsLabel.setText("Your points: " + Integer.toString(userPoints));
		botPointsLabel.setText("Bot points: " + Integer.toString(botPoints));
		selection = "";
		selectionLabel.setText("You selected: ");
	}
}
