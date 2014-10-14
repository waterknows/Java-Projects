package restaurant;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
//	private static final int NUM_OF_BUTTONS = 10;
	private static final int AREA_ROWS = 15;
	private static final int AREA_COLUMNS = 20;
	private static final int TEXT_WIDTH = 5;
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
	private final Bill ItemBill;
	
	public BillViewer(){
		createComponents();
		ItemBill = new Bill();
	}
	
	class AddItemListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String itemInfo = event.getActionCommand();
			int index = getIndexOf(itemInfo,'\n');
			ItemFood Temp = new ItemFood(itemInfo.substring(0,index - 1),Double.parseDouble(itemInfo.substring(index + 1)));
			ItemBill.add_item(Temp);
			billDisplayArea.setText(ItemBill.getItemAndPrice() + "\nTotal: " + ItemBill.getTotalPrice());
		}
	}
	class SubmitListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
		}
	}
	private void createComponents(){
		createTextFields();
		createButtons();
		createPanels();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);	
	}
	private void createPanels(){
		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.add(button1);
		buttonPanel1.add(button2);
		buttonPanel1.add(button3);
		buttonPanel1.add(button4);
		buttonPanel1.add(button5);
		
		
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.add(button6);
		buttonPanel2.add(button7);
		buttonPanel2.add(button8);
		buttonPanel2.add(button9);
		buttonPanel2.add(button10);

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
		mainPanel.add(buttonPanel1);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.add(buttonPanel2);
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
		button1 = new JButton("Burrito\n5.99");
		button1.addActionListener(listener);
		button1.setActionCommand(button1.getText());
		button2 = new JButton("Tacos\n2.99");
		button2.addActionListener(listener);
		button2.setActionCommand(button2.getText());
		button3 = new JButton("Sushi\n10.98");
		button3.addActionListener(listener);
		button3.setActionCommand(button3.getText());
		button4 = new JButton("Fish\n14.59");
		button4.addActionListener(listener);
		button4.setActionCommand(button4.getText());
		button5 = new JButton("Soda\n1.28");
		button5.addActionListener(listener);
		button5.setActionCommand(button5.getText());
		button6 = new JButton("Le Cavier\n29.99");
		button6.addActionListener(listener);
		button6.setActionCommand(button6.getText());
		button7 = new JButton("Water\n0.01");
		button7.addActionListener(listener);
		button7.setActionCommand(button7.getText());
		button8 = new JButton("Banana\n0.98");
		button8.addActionListener(listener);
		button8.setActionCommand(button8.getText());
		button9 = new JButton("Shwarma\n4.99");
		button9.addActionListener(listener);
		button9.setActionCommand(button9.getText());
		button10 = new JButton("Chocolate\n102.09");
		button10.addActionListener(listener);
		button10.setActionCommand(button10.getText());
		enterButton = new JButton("Submit");
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
