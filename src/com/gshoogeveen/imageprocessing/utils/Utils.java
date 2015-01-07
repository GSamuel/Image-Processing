package com.gshoogeveen.imageprocessing.utils;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class Utils
{
	public static BufferedImage toBufferedImage(Mat m)
	{
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if (m.channels() > 1)
		{
			type = BufferedImage.TYPE_3BYTE_BGR;
		}
		int bufferSize = m.channels() * m.cols() * m.rows();
		byte[] b = new byte[bufferSize];
		m.get(0, 0, b); // get all the pixels
		BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
		final byte[] targetPixels = ((DataBufferByte) image.getRaster()
				.getDataBuffer()).getData();
		System.arraycopy(b, 0, targetPixels, 0, b.length);

		return image;
	}
	
	public static Mat toMat(BufferedImage image)
	{
		byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
		mat.put(0, 0, data);
		return mat;
	}

	public static Image screenShot()
	{
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
				.getScreenSize());

		BufferedImage capture = null;

		try
		{
			capture = new Robot().createScreenCapture(screenRect);
		} catch (AWTException e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		return capture;
	}
}
