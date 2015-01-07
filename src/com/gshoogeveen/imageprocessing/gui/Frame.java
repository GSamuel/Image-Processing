package com.gshoogeveen.imageprocessing.gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Frame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6704342152369396604L;

	public Frame()
	{
		init();
	}

	private void init()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1720,900);
		this.getContentPane().setBackground(Color.WHITE);
		
		this.setLayout(new FlowLayout());
		
		this.setVisible(true);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
}

