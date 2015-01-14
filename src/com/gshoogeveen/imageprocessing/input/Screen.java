package com.gshoogeveen.imageprocessing.input;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import org.opencv.core.Mat;

import com.gshoogeveen.imageprocessing.utils.Utils;

public class Screen implements PhotoInput
{
	private Rectangle screenRect;
	Robot robot;

	public Screen()
	{
		this.screenRect = new Rectangle(Toolkit.getDefaultToolkit()
				.getScreenSize());
		createRobot();

	}

	private void createRobot()
	{
		try
		{
			this.robot = new Robot();
		} catch (AWTException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Mat readMat()
	{
		if (robot != null)
		{
			BufferedImage img1 = robot.createScreenCapture(screenRect);
			BufferedImage img = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
			img.getGraphics().drawImage(img1, 0, 0, null);
			
			return Utils.toMat(img);
		}
		else
			return new Mat();
	}
}
