import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

import com.gshoogeveen.imageprocessing.data.FPS;
import com.gshoogeveen.imageprocessing.data.MatrixContainer;
import com.gshoogeveen.imageprocessing.gui.Frame;
import com.gshoogeveen.imageprocessing.gui.MatPanel;
import com.gshoogeveen.imageprocessing.input.Screen;

public class MainTest
{
	public static void main(String[] args)
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		VideoCapture cam = new VideoCapture(0);
		
		MatrixContainer matrixContainer = new MatrixContainer();

		Frame f = new Frame();
		MatPanel p = new MatPanel(matrixContainer, "key");

		f.add(p);
		
		Mat newMat;
		FPS fps = new FPS();
		Screen screen = new Screen();
		
		while (true)
		{
			fps.start();
			newMat = new Mat();
			cam.retrieve(newMat);
			matrixContainer.addMatrix("key", screen.readMat());
			fps.show();

		}
	}

}
