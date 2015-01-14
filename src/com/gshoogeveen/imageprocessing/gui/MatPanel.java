package com.gshoogeveen.imageprocessing.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.opencv.core.Mat;

import com.gshoogeveen.imageprocessing.data.MatrixContainer;
import com.gshoogeveen.imageprocessing.utils.Utils;

public class MatPanel extends JPanel implements Observer
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8485174383701803543L;

	private MatrixContainer matrixContainer;
	private String key;

	public MatPanel(MatrixContainer matrixContainer, String key)
	{
		this.matrixContainer = matrixContainer;
		this.key = key;
		matrixContainer.addObserver(this);
	}

	public void paintComponent(Graphics g)
	{
		Mat m = matrixContainer.getMatrix(key);
		if (m.width() > 0 && m.height() > 0)
			g.drawImage(Utils.toBufferedImage(matrixContainer.getMatrix(key)),
					0, 0, null);
	}

	public void setMat(MatrixContainer matrixContainer)
	{
		this.matrixContainer = matrixContainer;
		panelUpdate();
	}

	@Override
	public void update(Observable o, Object arg)
	{
		String key = arg.toString();
		if (this.key.compareTo(key) == 0)
		{
			panelUpdate();
		}
	}

	private void panelUpdate()
	{
		Mat mat = matrixContainer.getMatrix(key);
		if (mat.width() != getWidth() || mat.height() != getHeight())
		{
			this.setPreferredSize(new Dimension(mat.width(), mat.height()));
			this.revalidate();
		}
		repaint();
	}
}
