package restaurant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BillViewer extends JFrame{
//	private JButton buttonList[NUM_OF_BUTTONS];
	private static final int FRAME_WIDTH = 200;
	private static final int FRAME_HEIGHT = 400;
	private static final int NUM_OF_BUTTONS = 10;
	private static final int AREA_ROWS = 10;
	private static final int AREA_COLUMNS = 2;
	private static final int TEXT_WIDTH = 10;
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
	private JLabel fieldNameLabel;
	private JLabel fieldPriceLabel;
	//Add Bill object
	
	public BillViewer(){
		createComponents();
	}
	
	class AddItemListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String itemInfo = event.getActionCommand();
			int index = getIndexOf(itemInfo,'\n');
			billDisplayArea.setText(billDisplayArea.getText() + itemInfo.substring(0,index - 1) + itemInfo.substring(index + 1) + "\n");
		}
	}
	class SubmitListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
		}
	}
	private void createComponents(){
		createButtons();
		createTextFields();
		createPanels();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);	
	}
	private void createPanels(){
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);
		buttonPanel.add(button5);
		buttonPanel.add(button6);
		buttonPanel.add(button7);
		buttonPanel.add(button8);
		buttonPanel.add(button9);
		buttonPanel.add(button10);

		JPanel textEnterPanel = new JPanel();
		textEnterPanel.add(fieldNameLabel);
		textEnterPanel.add(newItemName);
		textEnterPanel.add(fieldPriceLabel);
		textEnterPanel.add(newItemPrice);
		textEnterPanel.add(enterButton);
		
		JScrollPane displayScroll = new JScrollPane(billDisplayArea);
		JPanel textDisplayPanel = new JPanel();
		textDisplayPanel.add(displayScroll);
		
		JPanel mainPanel = new JPanel();
		mainPanel.add(buttonPanel);
		mainPanel.add(textEnterPanel);
		mainPanel.add(textDisplayPanel);
		
		add(mainPanel);
	}
	private void createTextFields(){
		//Create labels
		fieldNameLabel = new JLabel("Item Name: ");
		fieldPriceLabel = new JLabel("Item Price: ");
		//Create text field
		newItemName = new JTextField(TEXT_WIDTH);
		newItemPrice = new JTextField(TEXT_WIDTH);
		
		//Create text area
		billDisplayArea = new JTextArea(AREA_ROWS,AREA_COLUMNS);
		billDisplayArea.setEditable(false);
	}
	
	private void createButtons(){
		//Create buttons
		ActionListener listener = new AddItemListener();
		button1 = new JButton("");
		button1.addActionListener(listener);
		button1.setActionCommand(button1.getText());
		button2 = new JButton("");
		button2.addActionListener(listener);
		button2.setActionCommand(button2.getText());
		button3 = new JButton("");
		button3.addActionListener(listener);
		button3.setActionCommand(button3.getText());
		button4 = new JButton("");
		button4.addActionListener(listener);
		button4.setActionCommand(button4.getText());
		button5 = new JButton("");
		button5.addActionListener(listener);
		button5.setActionCommand(button5.getText());
		button6 = new JButton("");
		button6.addActionListener(listener);
		button6.setActionCommand(button6.getText());
		button7 = new JButton("");
		button7.addActionListener(listener);
		button7.setActionCommand(button7.getText());
		button8 = new JButton("");
		button8.addActionListener(listener);
		button8.setActionCommand(button8.getText());
		button9 = new JButton("");
		button9.addActionListener(listener);
		button9.setActionCommand(button9.getText());
		button10 = new JButton("");
		button10.addActionListener(listener);
		button10.setActionCommand(button10.getText());
		enterButton = new JButton("");
		enterButton.addActionListener(listener);
		enterButton.setActionCommand(newItemName.getText() + "\n" + newItemPrice.getText());
		
	}
	private int getIndexOf(String string, char ch){
		for(int index = 0; index < string.length(); index++){
			if(string.charAt(index) == '\n')
				return index;
		}
		return -1;
	}
}
