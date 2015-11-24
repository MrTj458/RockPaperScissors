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
	private String selection;
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
	private JLabel dogeWowLabel;
	private JLabel suchGameLabel;
	
	public Panel(Controller baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		rockButton = new JButton("Rock");
		selection = "";
		userPoints = 0;
		botPoints = 0;
		paperButton = new JButton("Paper");
		scissorsButton = new JButton("Scissors");
		shootButton = new JButton("Shoot");
		selectionLabel = new JLabel("You selected: ");
		userPointsLabel = new JLabel("Your points: " + userPoints);
		botPointsLabel = new JLabel("Bot points: " + botPoints);
		dogeFaceLabel = new JLabel(new ImageIcon(getClass().getResource("images/doge.png")));
		dogeWowLabel = new JLabel(new ImageIcon(getClass().getResource("images/WOW16x.jpg")));
		suchGameLabel = new JLabel("Such Game");
		suchGameLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
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
		this.add(dogeWowLabel);
		this.add(suchGameLabel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, selectionLabel, 103, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, selectionLabel, 166, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, botPointsLabel, 0, SpringLayout.NORTH, userPointsLabel);
		baseLayout.putConstraint(SpringLayout.EAST, botPointsLabel, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, userPointsLabel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, userPointsLabel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, paperButton, 6, SpringLayout.SOUTH, rockButton);
		baseLayout.putConstraint(SpringLayout.WEST, paperButton, 0, SpringLayout.WEST, rockButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, rockButton, -244, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, scissorsButton, 6, SpringLayout.SOUTH, paperButton);
		baseLayout.putConstraint(SpringLayout.WEST, scissorsButton, 0, SpringLayout.WEST, rockButton);
		baseLayout.putConstraint(SpringLayout.WEST, rockButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, shootButton, 0, SpringLayout.WEST, selectionLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, shootButton, 0, SpringLayout.NORTH, paperButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, dogeFaceLabel, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, dogeFaceLabel, -110, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, dogeWowLabel, 0, SpringLayout.NORTH, rockButton);
		baseLayout.putConstraint(SpringLayout.NORTH, suchGameLabel, 2, SpringLayout.SOUTH, dogeWowLabel);
		baseLayout.putConstraint(SpringLayout.WEST, dogeWowLabel, 0, SpringLayout.WEST, suchGameLabel);
		baseLayout.putConstraint(SpringLayout.EAST, suchGameLabel, -25, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, dogeWowLabel, -23, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		rockButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				selection = "Rock";
				selectionLabel.setText("You selected: " + selection);
			}
		});
		
		paperButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				selection = "Paper";
				selectionLabel.setText("You selected: " + selection);
			}
		});
		
		scissorsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				selection = "Scissors";
				selectionLabel.setText("You selected: " + selection);
			}
		});
		
		shootButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
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
		});
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
