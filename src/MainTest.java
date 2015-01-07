import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

import com.gshoogeveen.imageprocessing.data.MatrixContainer;
import com.gshoogeveen.imageprocessing.gui.Frame;
import com.gshoogeveen.imageprocessing.gui.MatPanel;

public class MainTest
{
	public static void main(String[] args)
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		VideoCapture cam = new VideoCapture(0);

		Mat mat = new Mat();
		cam.read(mat);
		
		MatrixContainer matrixContainer = new MatrixContainer();

		Frame f = new Frame();
		MatPanel p = new MatPanel(matrixContainer, "key");

		f.add(p);

		long start, elapsed;
		
		while (true)
		{

			start = System.nanoTime();
			cam.read(mat);
			p.repaint();

	        elapsed = System.nanoTime() - start;

	        System.out.println("fps: "+elapsed / 1000000);
			
		}
	}

}
