package com.gshoogeveen.imageprocessing.input;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

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
			return Utils.toMat(robot.createScreenCapture(screenRect));
		else
			return new Mat();
	}
}
