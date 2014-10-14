package restaurant;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class BillViewer extends JFrame{
//	private JButton buttonList[NUM_OF_BUTTONS];
	private static final int FRAME_WIDTH = 200;
	private static final int FRAM_HEIGHT = 400;
	private static final int NUM_OF_BUTTONS = 10;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button10;
	private JButton enterButton;
	private JTextField newItemName;
	private JTextField newItemPrice;
	private JTextArea billDisplayArea;
	//Add Bill object
	
	public BillViewer(){
		createComponents();
	}
	
	class AddItemListener implements ActionListner{
		public void actionPerformed(ActionEvent event){
			//Bill Add method
			event.Source().getText();
		}
	}
	private void createComponents(){
		//Create buttons
		ActionListener listener = new AddItemListener();
		button1 = new JButton("");
		button1.addActionListener(listener);
		
		//Create text field
		

		JPanel buttonPanel = new JPanel();
		//Add buttons
		
		JPanel textEnterPanel = new JPanel();
		//Add Text Fields & Enter Button
		
		JPanel textDisplayPanel = new JPanel();
		//Add text area
		
		JPanel mainPanel = new JPanel();
		
			
	}
}
