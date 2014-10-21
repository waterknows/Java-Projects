import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
This frame contains a moving rectangle.
 */
@SuppressWarnings("serial")
public class RectangleFrame extends JFrame
{
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;
	private RectangleComponent scene;
	private int xMod;
	private int yMod;
	class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//Function to check 
				
			scene.moveRectangleBy();
		}
	}
	public RectangleFrame()
	{
		scene = new RectangleComponent();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		ActionListener listener = new TimerListener();
		final int DELAY = 3; // Milliseconds between timer ticks
		Timer t = new Timer(DELAY, listener);
		t.start();
	}
	
	public void createPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(scene, BorderLayout.CENTER);
		add(panel);
	}
}