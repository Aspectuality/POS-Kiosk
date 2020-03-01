import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.DefaultListModel;



import javax.swing.JTextField;
import javax.swing.JList;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;
import java.sql.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.text.Document;
import javax.swing.JPasswordField;
import java.util.Date;

public class POSprototype {
	


	private JFrame frame;
	private JTextField textFieldqty;
	int qty = 1;
	private static DecimalFormat df = new DecimalFormat("0.00");
	DefaultListModel listModel;
	ArrayList <Float> ArrListSubtotal = new ArrayList<Float>();
	int allAmerican = 0;
	int littleOhio = 0;
	int dadsWeekend = 0;
	int havanaDog =0;
	int classicChicago =0;
	int olCornDog =0;
	int fountainDrink=0;
	int icedTea =0;
	int coffee =0;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException, Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POSprototype window = new POSprototype();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public POSprototype() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 1920, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel BeginningPanel = new JPanel();
		
		frame.getContentPane().add(BeginningPanel, "name_176805875066296");
		BeginningPanel.setLayout(null);
		
		JLabel lblBeginning = new JLabel("Click anywhere to start");
		lblBeginning.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBeginning.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeginning.setBounds(768, 495, 381, 66);
		BeginningPanel.add(lblBeginning);
		
		JLabel lblWelcomeToBulldys = new JLabel("Welcome to Bulldy's");
		lblWelcomeToBulldys.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblWelcomeToBulldys.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToBulldys.setBounds(749, 392, 421, 75);
		BeginningPanel.add(lblWelcomeToBulldys);
		
		JPanel MainPanel = new JPanel();
		frame.getContentPane().add(MainPanel, "name_38845825914841");
		MainPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		
		
		JPanel panel = new JPanel();
		MainPanel.add(panel);
		panel.setLayout(null);
		
		//create food type buttons which go into panel of Main panel
		JButton btnburgers = new JButton(new ImageIcon(POSprototype.class.getResource("/resources/StockBurger.JPG")));
		btnburgers.setBounds(63, 32, 300, 300);
		btnburgers.setText("Burgers");
		btnburgers.setHorizontalTextPosition(JButton.CENTER);
		btnburgers.setVerticalTextPosition(JButton.BOTTOM);		
		btnburgers.setPreferredSize(new Dimension(300,300));
		btnburgers.setBackground(Color.white);
		btnburgers.setOpaque(true);		
		panel.add(btnburgers);
		
		
		JButton btnHotdogs = new JButton("Hot Dogs");		
		btnHotdogs.setBounds(63, 361, 300, 300);
		btnHotdogs.setIcon(new ImageIcon(POSprototype.class.getResource("/resources/StockHotDog.png")));
		btnHotdogs.setPreferredSize(new Dimension(300,300));
		btnHotdogs.setBackground(Color.white);
		btnHotdogs.setHorizontalTextPosition(JButton.CENTER);
		btnHotdogs.setVerticalTextPosition(JButton.BOTTOM);
		btnHotdogs.setOpaque(true);
		panel.add(btnHotdogs);
		
		
		JButton btnDrinks = new JButton("Drinks");		
		btnDrinks.setBounds(63, 706, 300, 300);
		btnDrinks.setIcon(new ImageIcon(POSprototype.class.getResource("/resources/StockDrink.JPG")));
		btnDrinks.setPreferredSize(new Dimension(300,300));
		btnDrinks.setHorizontalTextPosition(JButton.CENTER);
		btnDrinks.setVerticalTextPosition(JButton.BOTTOM);
		btnDrinks.setBackground(Color.white);
		btnDrinks.setOpaque(true);
		panel.add(btnDrinks);
		
		JPanel panel2 = new JPanel();
		MainPanel.add(panel2);
		
		//create food item buttons which go into panel 2 of Main Panel
		JButton btnAllAmerican = new JButton("All American");
		
		btnAllAmerican.setIcon(new ImageIcon(POSprototype.class.getResource("/resources/AllAmerican.JPG")));
		btnAllAmerican.setBounds(144, 32, 240, 300);
		btnAllAmerican.setVisible(false);
		btnAllAmerican.setSize(new Dimension(250, 250));
		btnAllAmerican.setBackground(Color.white);
		JButton btnLittleOhio = new JButton("Little Ohio");
		
		btnLittleOhio.setIcon(new ImageIcon(POSprototype.class.getResource("/resources/Little Ohio.JPG")));
		btnLittleOhio.setBounds(144, 366, 300, 300);
		btnLittleOhio.setVisible(false);
		btnLittleOhio.setSize(new Dimension(250,250));
		btnLittleOhio.setBackground(Color.white);
		JButton btnDadsWeekend = new JButton("Dad's Weekend");
		
		btnDadsWeekend.setBackground(Color.WHITE);
		btnDadsWeekend.setIcon(new ImageIcon(POSprototype.class.getResource("/resources/DadsWeekend.JPG")));
		btnDadsWeekend.setBounds(144, 709, 300, 300);
		btnDadsWeekend.setVisible(false);
		btnDadsWeekend.setSize(new Dimension(250,250));
		JButton btnHavanaDog = new JButton("Havana Dog");
		
		btnHavanaDog.setIcon(new ImageIcon(POSprototype.class.getResource("/resources/HavanaDog.JPG")));
		btnHavanaDog.setBounds(144, 32, 300, 300);
		btnHavanaDog.setVisible(false);
		btnHavanaDog.setSize(new Dimension(250,250));
		btnHavanaDog.setBackground(Color.WHITE);
		JButton btnClassicChicago = new JButton("Classic Chicago");
		
		btnClassicChicago.setIcon(new ImageIcon(POSprototype.class.getResource("/resources/ClassicChicago.JPG")));
		btnClassicChicago.setBounds(144, 366, 300, 300);
		btnClassicChicago.setVisible(false);
		btnClassicChicago.setSize(new Dimension(250,250));
		btnClassicChicago.setBackground(Color.WHITE);
		JButton btnOlCornDog = new JButton("Ol' Corn Dog");
		btnOlCornDog.setIcon(new ImageIcon(POSprototype.class.getResource("/resources/OlCornDog.JPG")));
		btnOlCornDog.setBounds(144, 709, 300, 300);
		btnOlCornDog.setVisible(false);
		btnOlCornDog.setSize(new Dimension(250,250));
		btnOlCornDog.setBackground(Color.WHITE);
		JButton btnFountainDrinks = new JButton("Fountain Drinks");
		
		btnFountainDrinks.setIcon(new ImageIcon(POSprototype.class.getResource("/resources/fountaindrinks.jpg")));
		btnFountainDrinks.setBounds(144, 32, 300, 300);
		btnFountainDrinks.setVisible(false);
		btnFountainDrinks.setSize(new Dimension(250,250));
		btnFountainDrinks.setBackground(Color.WHITE);
		JButton btnIcedTea = new JButton("Iced tea");
		btnIcedTea.setIcon(new ImageIcon(POSprototype.class.getResource("/resources/IcedTea.jpg")));
		btnIcedTea.setBounds(144, 366, 300, 300);
		btnIcedTea.setVisible(false);
		btnIcedTea.setSize(new Dimension(250,250));
		btnIcedTea.setBackground(Color.WHITE);
		JButton btnCoffee = new JButton("Coffee");
		btnCoffee.setIcon(new ImageIcon(POSprototype.class.getResource("/resources/coffee.jpg")));
		btnCoffee.setBounds(144, 709, 300, 300);
		btnCoffee.setVisible(false);
		btnCoffee.setSize(new Dimension(250,250));
		btnCoffee.setBackground(Color.WHITE);
		panel2.setLayout(null);
		//labels to display price of respective item it is next to
		JLabel lblItemPrice = new JLabel("");
		lblItemPrice.setBounds(443, 159, 46, 14);
		panel2.add(lblItemPrice);
		
		JLabel lblItemPrice2 = new JLabel("");
		lblItemPrice2.setBounds(443, 493, 46, 14);
		panel2.add(lblItemPrice2);
		
		JLabel lblItemPrice3 = new JLabel("");
		lblItemPrice3.setLabelFor(btnDadsWeekend);
		lblItemPrice3.setBounds(443, 829, 46, 14);
		panel2.add(lblItemPrice3);
		panel2.add(btnAllAmerican);
		panel2.add(btnLittleOhio);
		panel2.add(btnDadsWeekend);
		panel2.add(btnHavanaDog);
		panel2.add(btnClassicChicago);
		panel2.add(btnOlCornDog);
		panel2.add(btnFountainDrinks);
		panel2.add(btnIcedTea);
		panel2.add(btnCoffee);
		/*Panel 3 of main panel is where Order is displayed in a text area and where users can remove items from order or 
		click on review order button to review order. */
		JPanel panel3 = new JPanel();
		MainPanel.add(panel3);
		panel3.setLayout(null);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setBounds(20, 11, 421, 100);
		lblOrder.setVerticalAlignment(SwingConstants.TOP);
		lblOrder.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel3.add(lblOrder);
		
		JButton btnReviewOrder = new JButton("Review Order");
		btnReviewOrder.setEnabled(false);
		btnReviewOrder.setBounds(382, 997, 148, 53);
		panel3.add(btnReviewOrder);
		
		JButton btnRemoveItem = new JButton("Remove Item");
		btnRemoveItem.setBounds(20, 997, 133, 53);
		btnRemoveItem.setEnabled(false);
		panel3.add(btnRemoveItem);
		//list model, anything added to list model is displayed in jlist
		listModel = new DefaultListModel();
		JList list = new JList(listModel);
		
		list.setBounds(20, 83, 510, 447);
		panel3.add(list);
		
		JLabel lblSubtotalText = new JLabel("Subtotal");
		lblSubtotalText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubtotalText.setHorizontalAlignment(SwingConstants.LEFT);
		lblSubtotalText.setBounds(20, 577, 71, 32);
		panel3.add(lblSubtotalText);
		
		JLabel lblSubtotal = new JLabel("0.00");
		lblSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSubtotal.setBounds(415, 577, 115, 43);
		panel3.add(lblSubtotal);
		
		JLabel lblTaxText = new JLabel("Tax");
		lblTaxText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTaxText.setBounds(20, 639, 46, 14);
		panel3.add(lblTaxText);
		
		JLabel lblTax = new JLabel("0.00");
		lblTax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTax.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTax.setBounds(415, 631, 115, 43);
		panel3.add(lblTax);
		
		JLabel lblTotalText = new JLabel("Total");
		lblTotalText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalText.setBounds(20, 709, 46, 14);
		panel3.add(lblTotalText);
		
		JLabel lblTotal = new JLabel("0.00");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotal.setBounds(415, 709, 115, 43);
		panel3.add(lblTotal);
		JPanel ModifierPanel = new JPanel();
		frame.getContentPane().add(ModifierPanel, "name_343247077855839");
		ModifierPanel.setLayout(null);
		
		textFieldqty = new JTextField();
		textFieldqty.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		textFieldqty.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldqty.setText("1");
		textFieldqty.setEditable(false);
		textFieldqty.setBounds(789, 930, 130, 54);
		ModifierPanel.add(textFieldqty);
		textFieldqty.setColumns(10);
		
		JButton btnMinusOne = new JButton("-");
		btnMinusOne.setFont(new Font("Tahoma", Font.PLAIN, 72));
		
		btnMinusOne.setEnabled(false);
		btnMinusOne.setBounds(576, 910, 116, 97);
		ModifierPanel.add(btnMinusOne);
		
		JButton btnPlusOne = new JButton("+");
		btnPlusOne.setFont(new Font("Tahoma", Font.PLAIN, 72));
		
		btnPlusOne.setBounds(990, 910, 116, 97);
		ModifierPanel.add(btnPlusOne);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(789, 833, 128, 54);
		ModifierPanel.add(lblQuantity);
		
		JButton btnAddToOrder = new JButton("Add To Order");
		
		btnAddToOrder.setBounds(1518, 910, 158, 97);
		ModifierPanel.add(btnAddToOrder);
		
		JButton btnModGoBack = new JButton("Go Back");
		
		btnModGoBack.setBounds(76, 899, 137, 87);
		ModifierPanel.add(btnModGoBack);
		
		JLabel lblModFoodItem = new JLabel("");
		lblModFoodItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModFoodItem.setBounds(283, 11, 1592, 39);
		ModifierPanel.add(lblModFoodItem);
		
		JLabel lblModfooditemprice = new JLabel("");
		lblModfooditemprice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModfooditemprice.setBounds(76, 10, 197, 40);
		ModifierPanel.add(lblModfooditemprice);
		
		JButton btnModIngredientMinus1 = new JButton("-");
		
		btnModIngredientMinus1.setFont(new Font("Tahoma", Font.PLAIN, 72));
		btnModIngredientMinus1.setEnabled(false);
		btnModIngredientMinus1.setBounds(76, 165, 116, 97);
		ModifierPanel.add(btnModIngredientMinus1);
		
		JButton btnModIngredientMinus2 = new JButton("-");
		
		btnModIngredientMinus2.setFont(new Font("Tahoma", Font.PLAIN, 72));
		btnModIngredientMinus2.setEnabled(false);
		btnModIngredientMinus2.setBounds(76, 310, 116, 97);
		ModifierPanel.add(btnModIngredientMinus2);
		
		JButton btnModIngredientMinus3 = new JButton("-");
		
		btnModIngredientMinus3.setFont(new Font("Tahoma", Font.PLAIN, 72));
		btnModIngredientMinus3.setEnabled(false);
		btnModIngredientMinus3.setBounds(76, 458, 116, 97);
		ModifierPanel.add(btnModIngredientMinus3);
		
		JButton btnModIngredientMinus4 = new JButton("-");
		
		btnModIngredientMinus4.setFont(new Font("Tahoma", Font.PLAIN, 72));
		btnModIngredientMinus4.setEnabled(false);
		btnModIngredientMinus4.setBounds(76, 619, 116, 97);
		ModifierPanel.add(btnModIngredientMinus4);
		
		JButton btnModIngredientPlus1 = new JButton("+");
		
		btnModIngredientPlus1.setFont(new Font("Tahoma", Font.PLAIN, 72));
		btnModIngredientPlus1.setBounds(274, 165, 116, 97);
		ModifierPanel.add(btnModIngredientPlus1);
		
		JButton btnModIngredientPlus2 = new JButton("+");
		
		btnModIngredientPlus2.setFont(new Font("Tahoma", Font.PLAIN, 72));
		btnModIngredientPlus2.setBounds(274, 310, 116, 97);
		ModifierPanel.add(btnModIngredientPlus2);
		
		JButton btnModIngredientPlus3 = new JButton("+");
		
		btnModIngredientPlus3.setFont(new Font("Tahoma", Font.PLAIN, 72));
		btnModIngredientPlus3.setBounds(274, 458, 116, 97);
		ModifierPanel.add(btnModIngredientPlus3);
		
		JButton btnModIngredientPlus4 = new JButton("+");
		btnModIngredientPlus4.setFont(new Font("Tahoma", Font.PLAIN, 72));
		btnModIngredientPlus4.setBounds(274, 619, 116, 97);
		ModifierPanel.add(btnModIngredientPlus4);
		
		JLabel lblModIngredient1 = new JLabel("Ketchup");
		lblModIngredient1.setBounds(628, 165, 121, 97);
		ModifierPanel.add(lblModIngredient1);
		
		JLabel lblModIngredient2 = new JLabel("Lettuce");
		lblModIngredient2.setBounds(628, 310, 121, 97);
		ModifierPanel.add(lblModIngredient2);
		
		JLabel lblModIngredient3 = new JLabel("Pickle");
		lblModIngredient3.setBounds(628, 458, 121, 97);
		ModifierPanel.add(lblModIngredient3);
		
		JLabel lblModIngredient4 = new JLabel("Onion");
		lblModIngredient4.setBounds(628, 619, 121, 97);
		ModifierPanel.add(lblModIngredient4);
		
		JLabel lblModIngredientQty1 = new JLabel("None");
		lblModIngredientQty1.setBounds(460, 165, 121, 97);
		ModifierPanel.add(lblModIngredientQty1);
		
		JLabel lblModIngredientQty2 = new JLabel("Regular");
		lblModIngredientQty2.setBounds(460, 310, 121, 97);
		ModifierPanel.add(lblModIngredientQty2);
		
		JLabel lblModIngredientQty3 = new JLabel("None");
		lblModIngredientQty3.setBounds(460, 458, 121, 97);
		ModifierPanel.add(lblModIngredientQty3);
		
		JLabel lblModIngredientQty4 = new JLabel("None");
		lblModIngredientQty4.setBounds(460, 619, 121, 97);
		ModifierPanel.add(lblModIngredientQty4);
		
		JButton btnModIngredientMinus5 = new JButton("-");
		btnModIngredientMinus5.setFont(new Font("Tahoma", Font.PLAIN, 72));
		btnModIngredientMinus5.setEnabled(false);
		btnModIngredientMinus5.setBounds(923, 165, 116, 97);
		ModifierPanel.add(btnModIngredientMinus5);
		
		JButton btnModIngredientMinus6 = new JButton("-");
		btnModIngredientMinus6.setFont(new Font("Tahoma", Font.PLAIN, 72));
		btnModIngredientMinus6.setEnabled(false);
		btnModIngredientMinus6.setBounds(923, 310, 116, 97);
		ModifierPanel.add(btnModIngredientMinus6);
		
		JButton btnModIngredientPlus5 = new JButton("+");
		btnModIngredientPlus5.setFont(new Font("Tahoma", Font.PLAIN, 72));
		btnModIngredientPlus5.setBounds(1130, 165, 116, 97);
		ModifierPanel.add(btnModIngredientPlus5);
		
		JButton btnModIngredientPlus6 = new JButton("+");
		btnModIngredientPlus6.setFont(new Font("Tahoma", Font.PLAIN, 72));
		btnModIngredientPlus6.setBounds(1130, 310, 116, 97);
		ModifierPanel.add(btnModIngredientPlus6);
		
		JLabel lblModIngredientQty5 = new JLabel("Regular");
		lblModIngredientQty5.setBounds(1333, 165, 121, 97);
		ModifierPanel.add(lblModIngredientQty5);
		
		JLabel lblModIngredientQty6 = new JLabel("None");
		lblModIngredientQty6.setBounds(1333, 310, 121, 97);
		ModifierPanel.add(lblModIngredientQty6);
		
		JLabel lblModIngredient5 = new JLabel("Cheese");
		lblModIngredient5.setBounds(1518, 165, 121, 97);
		ModifierPanel.add(lblModIngredient5);
		
		JLabel lblModIngredient6 = new JLabel("Tomato");
		lblModIngredient6.setBounds(1518, 310, 121, 97);
		ModifierPanel.add(lblModIngredient6);
		btnModGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPanel.setVisible(true);
				ModifierPanel.setVisible(false);
			}
		});
		
		btnPlusOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qty += 1;
				textFieldqty.setText(String.valueOf(qty));
				btnMinusOne.setEnabled(true);
			}
		});
		btnMinusOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qty -=1;
				textFieldqty.setText(String.valueOf(qty));
				if (qty == 1) {
					btnMinusOne.setEnabled(false);
				}
			}
		});
		btnModIngredientPlus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblModIngredientQty1.getText() == "None") {
					lblModIngredientQty1.setText("Regular");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" no " + lblModIngredient1.getText(), ""));
					lblModFoodItem.setText(lblModFoodItem.getText() + " with " + lblModIngredient1.getText());
					btnModIngredientMinus1.setEnabled(true);
				}
				
				else if (lblModIngredientQty1.getText() == "Regular") {
					lblModIngredientQty1.setText("Extra");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" with " + lblModIngredient1.getText(), ""));
					lblModFoodItem.setText(lblModFoodItem.getText() +" "+  lblModIngredientQty1.getText() +" "+ lblModIngredient1.getText());
					btnModIngredientPlus1.setEnabled(false);
					btnModIngredientMinus1.setEnabled(true);
				}
			}
		});
		btnModIngredientMinus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblModIngredientQty1.getText() == "Regular" && (!lblModFoodItem.getText().contains(" with "))) {
					lblModIngredientQty1.setText("None");
					lblModFoodItem.setText(lblModFoodItem.getText() + " no " + lblModIngredient1.getText());
					btnModIngredientMinus1.setEnabled(false);
				}
				else if (lblModIngredientQty1.getText() == "Regular") {
					lblModIngredientQty1.setText("None");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" with " + lblModIngredient1.getText(), " no " + lblModIngredient1.getText()));
					btnModIngredientMinus1.setEnabled(false);
				}
				else if (lblModIngredientQty1.getText() == "Extra") {
					lblModIngredientQty1.setText("Regular");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" Extra " + lblModIngredient1.getText() ,""));
					lblModFoodItem.setText(lblModFoodItem.getText() + " with " + lblModIngredient1.getText());
					btnModIngredientPlus1.setEnabled(true);
					btnModIngredientMinus1.setEnabled(true);
				}
			}
		});
		btnModIngredientPlus2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblModIngredientQty2.getText() == "None") {
					lblModIngredientQty2.setText("Regular");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" no " + lblModIngredient2.getText(), ""));
					lblModFoodItem.setText(lblModFoodItem.getText() + " with " + lblModIngredient2.getText());
					btnModIngredientMinus2.setEnabled(true);
				}
				else if (lblModIngredientQty2.getText() == "Regular") {
					lblModIngredientQty2.setText("Extra");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" with " + lblModIngredient2.getText(), ""));
					lblModFoodItem.setText(lblModFoodItem.getText() +" "+  lblModIngredientQty2.getText() +" "+ lblModIngredient2.getText());
					btnModIngredientPlus2.setEnabled(false);
					btnModIngredientMinus2.setEnabled(true);
				}
			}
		});
		btnModIngredientMinus2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblModIngredientQty2.getText() == "Regular" && (!lblModFoodItem.getText().contains(" with "))) {
					lblModIngredientQty2.setText("None");
					lblModFoodItem.setText(lblModFoodItem.getText() + " no " + lblModIngredient2.getText());
					btnModIngredientMinus2.setEnabled(false);
				}
				else if (lblModIngredientQty2.getText() == "Regular") {
					lblModIngredientQty2.setText("None");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" with " + lblModIngredient2.getText(), " no " + lblModIngredient2.getText()));
					btnModIngredientMinus2.setEnabled(false);
				}
				else if (lblModIngredientQty2.getText() == "Extra") {
					lblModIngredientQty2.setText("Regular");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" Extra " + lblModIngredient2.getText() ,""));
					lblModFoodItem.setText(lblModFoodItem.getText() + " with " + lblModIngredient2.getText());
					btnModIngredientPlus2.setEnabled(true);
					btnModIngredientMinus2.setEnabled(true);
				}
			}
		});
		btnModIngredientPlus3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblModIngredientQty3.getText() == "None") {
					lblModIngredientQty3.setText("Regular");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" no " + lblModIngredient3.getText(), ""));
					lblModFoodItem.setText(lblModFoodItem.getText() + " with " + lblModIngredient3.getText());
					btnModIngredientMinus3.setEnabled(true);
				}
				else if (lblModIngredientQty3.getText() == "Regular") {
					lblModIngredientQty3.setText("Extra");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" with " + lblModIngredient3.getText(), ""));
					lblModFoodItem.setText(lblModFoodItem.getText() +" "+  lblModIngredientQty3.getText() +" "+ lblModIngredient3.getText());
					btnModIngredientPlus3.setEnabled(false);
					btnModIngredientMinus3.setEnabled(true);
				}

			}
		});
		btnModIngredientMinus3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblModIngredientQty3.getText() == "Regular" && (!lblModFoodItem.getText().contains(" with "))) {
					lblModIngredientQty3.setText("None");
					lblModFoodItem.setText(lblModFoodItem.getText() + " no " + lblModIngredient3.getText());
					btnModIngredientMinus3.setEnabled(false);
				}
				else if (lblModIngredientQty3.getText() == "Regular") {
					lblModIngredientQty3.setText("None");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" with " + lblModIngredient3.getText(), " no " + lblModIngredient3.getText()));
					btnModIngredientMinus3.setEnabled(false);
				}
				else if (lblModIngredientQty3.getText() == "Extra") {
					lblModIngredientQty3.setText("Regular");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" Extra " + lblModIngredient3.getText() ,""));
					lblModFoodItem.setText(lblModFoodItem.getText() + " with " + lblModIngredient3.getText());
					btnModIngredientPlus3.setEnabled(true);
					btnModIngredientMinus3.setEnabled(true);
				}
			}
		});
		btnModIngredientPlus4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblModIngredientQty4.getText() == "None") {
					lblModIngredientQty4.setText("Regular");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" no " + lblModIngredient4.getText(), ""));
					lblModFoodItem.setText(lblModFoodItem.getText() + " with " + lblModIngredient4.getText());
					btnModIngredientMinus4.setEnabled(true);
				}
				else if (lblModIngredientQty4.getText() == "Regular") {
					lblModIngredientQty4.setText("Extra");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" with " + lblModIngredient4.getText(), ""));
					lblModFoodItem.setText(lblModFoodItem.getText() +" "+  lblModIngredientQty4.getText() +" "+ lblModIngredient4.getText());
					btnModIngredientPlus4.setEnabled(false);
					btnModIngredientMinus4.setEnabled(true);
				}

			}
		});
		btnModIngredientMinus4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblModIngredientQty4.getText() == "Regular" && (!lblModFoodItem.getText().contains(" with "))) {
					lblModIngredientQty4.setText("None");
					lblModFoodItem.setText(lblModFoodItem.getText() + " no " + lblModIngredient4.getText());
					btnModIngredientMinus4.setEnabled(false);
				}
				else if (lblModIngredientQty4.getText() == "Regular") {
					lblModIngredientQty4.setText("None");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" with " + lblModIngredient4.getText(), " no " + lblModIngredient4.getText()));
					btnModIngredientMinus4.setEnabled(false);
				}
				else if (lblModIngredientQty4.getText() == "Extra") {
					lblModIngredientQty4.setText("Regular");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" Extra " + lblModIngredient4.getText() ,""));
					lblModFoodItem.setText(lblModFoodItem.getText() + " with " + lblModIngredient4.getText());
					btnModIngredientPlus4.setEnabled(true);
					btnModIngredientMinus4.setEnabled(true);
				}
			}
		});
		btnModIngredientPlus5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblModIngredientQty5.getText() == "None") {
					lblModIngredientQty5.setText("Regular");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" no " + lblModIngredient5.getText(), ""));
					lblModFoodItem.setText(lblModFoodItem.getText() + " with " + lblModIngredient5.getText());
					btnModIngredientMinus5.setEnabled(true);
				}
				else if (lblModIngredientQty5.getText() == "Regular") {
					lblModIngredientQty5.setText("Extra");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" with " + lblModIngredient5.getText(), ""));
					lblModFoodItem.setText(lblModFoodItem.getText() +" "+  lblModIngredientQty5.getText() +" "+ lblModIngredient5.getText());
					btnModIngredientPlus5.setEnabled(false);
					btnModIngredientMinus5.setEnabled(true);
				}

			}
		});
		btnModIngredientMinus5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblModIngredientQty5.getText() == "Regular" && (!lblModFoodItem.getText().contains(" with "))) {
					lblModIngredientQty5.setText("None");
					lblModFoodItem.setText(lblModFoodItem.getText() + " no " + lblModIngredient5.getText());
					btnModIngredientMinus5.setEnabled(false);
				}
				else if (lblModIngredientQty5.getText() == "Regular") {
					lblModIngredientQty5.setText("None");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" with " + lblModIngredient5.getText(), " no " + lblModIngredient5.getText()));
					btnModIngredientMinus5.setEnabled(false);
				}
				else if (lblModIngredientQty5.getText() == "Extra") {
					lblModIngredientQty5.setText("Regular");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" Extra " + lblModIngredient5.getText() ,""));
					lblModFoodItem.setText(lblModFoodItem.getText() + " with " + lblModIngredient5.getText());
					btnModIngredientPlus5.setEnabled(true);
					btnModIngredientMinus5.setEnabled(true);
				}

			}
		});
		btnModIngredientPlus6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblModIngredientQty6.getText() == "None") {
					lblModIngredientQty6.setText("Regular");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" no " + lblModIngredient6.getText(), ""));
					lblModFoodItem.setText(lblModFoodItem.getText() + " with " + lblModIngredient6.getText());
					btnModIngredientMinus6.setEnabled(true);
				}
				else if (lblModIngredientQty6.getText() == "Regular") {
					lblModIngredientQty6.setText("Extra");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" with " + lblModIngredient6.getText(), ""));
					lblModFoodItem.setText(lblModFoodItem.getText() +" "+  lblModIngredientQty6.getText() +" "+ lblModIngredient6.getText());
					btnModIngredientPlus6.setEnabled(false);
					btnModIngredientMinus6.setEnabled(true);
				}

			}
		});
		btnModIngredientMinus6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblModIngredientQty6.getText() == "Regular" && (!lblModFoodItem.getText().contains(" with "))) {
					lblModIngredientQty6.setText("None");
					lblModFoodItem.setText(lblModFoodItem.getText() + " no " + lblModIngredient6.getText());
					btnModIngredientMinus6.setEnabled(false);
				}
				else if (lblModIngredientQty6.getText() == "Regular") {
					lblModIngredientQty6.setText("None");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" with " + lblModIngredient6.getText(), " no " + lblModIngredient6.getText()));
					btnModIngredientMinus6.setEnabled(false);
				}
				else if (lblModIngredientQty6.getText() == "Extra") {
					lblModIngredientQty6.setText("Regular");
					lblModFoodItem.setText(lblModFoodItem.getText().replace(" Extra " + lblModIngredient6.getText() ,""));
					lblModFoodItem.setText(lblModFoodItem.getText() + " with " + lblModIngredient6.getText());
					btnModIngredientPlus6.setEnabled(true);
					btnModIngredientMinus6.setEnabled(true);
				}
			}
		});
		btnAddToOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPanel.setVisible(true);
				ModifierPanel.setVisible(false);	
				listModel.addElement(qty +" "+ lblModFoodItem.getText() +" - " + df.format(qty*Float.parseFloat(lblModfooditemprice.getText())));
				ArrListSubtotal.add(qty*Float.parseFloat(lblModfooditemprice.getText()));
				float subtotal = 0;
				float tax = 0;
				float total = 0;
				for(int i = 0; i < ArrListSubtotal.size(); i++)
					subtotal += ArrListSubtotal.get(i);
				lblSubtotal.setText(df.format(subtotal));
				tax = (float)(subtotal * 0.07);
				total = subtotal + tax;
				lblTax.setText(df.format(tax));
				lblTotal.setText(df.format(total));
				if (lblModFoodItem.getText().contains("All American")) {
					allAmerican += qty;
				}
				else if (lblModFoodItem.getText().contains("Little Ohio")) {
					littleOhio += qty;
				}
				else if (lblModFoodItem.getText().contains("Dad's Weekend")) {
					dadsWeekend += qty;
				}
				else if (lblModFoodItem.getText().contains("Havana Dog")) {
					havanaDog += qty;
				}
				else if (lblModFoodItem.getText().contains("Classic Chicago")) {
					classicChicago += qty;
				}
				else if (lblModFoodItem.getText().contains("Ol' Corn Dog")) {
					littleOhio += qty;
				}
				else if (lblModFoodItem.getText().contains("Fountain Drink")) {
					fountainDrink += qty;
				}
				else if (lblModFoodItem.getText().contains("Iced Tea")) {
					icedTea += qty;
				}
				else if (lblModFoodItem.getText().contains("Coffee")) {
					coffee += qty;
				}
				qty = 1;
				btnReviewOrder.setEnabled(true);
				btnRemoveItem.setEnabled(true);
				
			}
		});
		
		JPanel ReviewPanel = new JPanel();
		frame.getContentPane().add(ReviewPanel, "name_40465119948053");
		ReviewPanel.setLayout(null);
		ReviewPanel.setVisible(false);
		
      
      
      //PayPanel
      
		
      JPanel PayPanel = new JPanel();
      	frame.getContentPane().add(PayPanel, "name_808765621674807");
      	PayPanel.setVisible(false);
      PayPanel.setLayout(null);
 
      JLabel lblPay = new JLabel("Please enter your VISA or MASTERCARD payment information");
		lblPay.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPay.setHorizontalAlignment(SwingConstants.LEFT);
		lblPay.setBounds(31, 18, 936, 37);
      PayPanel.add(lblPay);
      
      JLabel lblNameFieldError = new JLabel();
      lblNameFieldError.setBounds(420, 143, 463, 50);
      lblNameFieldError.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNameFieldError.setForeground(Color.red);
		PayPanel.add(lblNameFieldError);		
      
      JLabel lblNameField = new JLabel("Name on Card: ");
      lblNameField.setBounds(31, 100, 243, 43);
      lblNameField.setFont(new Font("Tahoma", Font.PLAIN, 35));
		PayPanel.add(lblNameField);
      
      JLimitedTextField nameField = new JLimitedTextField(30);
      nameField.setFont(new Font("Arial", Font.PLAIN, 35));
		nameField.setMaximumSize(new Dimension(1000, 50));
		nameField.setBounds(31,150,325,50);
      PayPanel.add(nameField);
      
      JLabel lblCardNumberFieldError = new JLabel();
      lblCardNumberFieldError.setBounds(454, 240, 429, 50);
		lblCardNumberFieldError.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCardNumberFieldError.setForeground(Color.red);
		PayPanel.add(lblCardNumberFieldError);		
      
      JLabel lblCardNumberField = new JLabel("Credit Card Number: ");
      lblCardNumberField.setBounds(31, 205, 329, 43);
      lblCardNumberField.setFont(new Font("Tahoma", Font.PLAIN, 35));
      PayPanel.add(lblCardNumberField);
      
      JLimitedIntegerField cardNumberField = new JLimitedIntegerField(19);
      cardNumberField.setFont(new Font("Arial", Font.PLAIN, 35));
		cardNumberField.setMaximumSize(new Dimension(800, 50));
		cardNumberField.setBounds(31,250,325,50);
      PayPanel.add(cardNumberField);
      
      JLabel lblExpirationDateFieldError = new JLabel();
      lblExpirationDateFieldError.setBounds(321, 351, 596, 50);
		lblExpirationDateFieldError.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExpirationDateFieldError.setForeground(Color.red);
      PayPanel.add(lblExpirationDateFieldError);		
      
      JLabel lblExpirationDateField = new JLabel("Credit Card Expiration Date (MMYY): ");
      lblExpirationDateField.setBounds(31, 301, 575, 43);
      lblExpirationDateField.setFont(new Font("Tahoma", Font.PLAIN, 35));
      PayPanel.add(lblExpirationDateField);
      
      JLimitedIntegerField expirationDateField = new JLimitedIntegerField(4);
      expirationDateField.setFont(new Font("Arial", Font.PLAIN, 35));
		expirationDateField.setMaximumSize(new Dimension(160, 50));
		expirationDateField.setBounds(31,350,100,50);
      PayPanel.add(expirationDateField);
      
      JLabel lblSecurityCodeFieldError = new JLabel();
      lblSecurityCodeFieldError.setBounds(298, 450, 585, 50);
		lblSecurityCodeFieldError.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSecurityCodeFieldError.setForeground(Color.red);
		PayPanel.add(lblSecurityCodeFieldError);		
      
      JLabel lblSecurityCodeField = new JLabel("Credit Card Security Code: ");
      lblSecurityCodeField.setBounds(31, 397, 419, 43);
      lblSecurityCodeField.setFont(new Font("Tahoma", Font.PLAIN, 35));
      PayPanel.add(lblSecurityCodeField);
      
      JSecureCodeField securityCodeField = new JSecureCodeField(3);
      securityCodeField.setFont(new Font("Arial", Font.PLAIN, 35));
		securityCodeField.setMaximumSize(new Dimension(160, 50));
		securityCodeField.setBounds(31,450,100,50);
      PayPanel.add(securityCodeField);
      
      JLabel lblZipCodeFieldError = new JLabel();
      lblZipCodeFieldError.setBounds(270, 550, 438, 50);
		lblZipCodeFieldError.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblZipCodeFieldError.setForeground(Color.red);
		PayPanel.add(lblZipCodeFieldError);		
      
      JLabel lblZipCodeField = new JLabel("Credit Card ZIP Code: ");
      lblZipCodeField.setBounds(31, 501, 348, 41);
      lblZipCodeField.setFont(new Font("Arial", Font.PLAIN, 35));
      PayPanel.add(lblZipCodeField);
      
      JLimitedIntegerField zipCodeField = new JLimitedIntegerField(5);
      zipCodeField.setFont(new Font("Arial", Font.PLAIN, 35));
		zipCodeField.setMaximumSize(new Dimension(230, 50));
		zipCodeField.setBounds(31,550,100,50);
      PayPanel.add(zipCodeField);
      
      JButton btnConfirmPayment = new JButton("Confirm Payment");
      btnConfirmPayment.setBounds(1626, 1002, 269, 39);
		btnConfirmPayment.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PayPanel.add(btnConfirmPayment);
      
      JButton btnBackToReviewOrder = new JButton("Back");
      btnBackToReviewOrder.setBounds(50, 1002, 279, 39);
		btnBackToReviewOrder.setFont(new Font("Tahoma", Font.PLAIN, 25));
		PayPanel.add(btnBackToReviewOrder);
    
      //ReceiptPanel
      JPanel ReceiptPanel = new JPanel();
      frame.getContentPane().add(ReceiptPanel);
      ReceiptPanel.setVisible(false);
      ReceiptPanel.setLayout(null);
      
      JLabel lblPaymentSuccessful = new JLabel("Payment Successful");
		lblPaymentSuccessful.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPaymentSuccessful.setHorizontalAlignment(SwingConstants.LEFT);
		lblPaymentSuccessful.setBounds(571, 359, 299, 37);
      ReceiptPanel.add(lblPaymentSuccessful);
      
      JLabel lblReceipt = new JLabel("$" + lblTotal.getText() + " has been charged to VISA/MC ending in " /*+ cardNumberField.getText().substring(cardNumberField.getText().length()-4)*/);
		lblReceipt.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblReceipt.setHorizontalAlignment(SwingConstants.LEFT);
		lblReceipt.setBounds(364, 461, 882, 31);
      ReceiptPanel.add(lblReceipt);
      
      JButton btnCreateNewOrder = new JButton("Create New Order");
      btnCreateNewOrder.setBounds(545, 570, 380, 39);
		btnCreateNewOrder.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ReceiptPanel.add(btnCreateNewOrder);
      
      
      
		JButton btnPay = new JButton("Pay");
		btnPay.setBounds(1700, 1004, 161, 43);
		ReviewPanel.add(btnPay);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(60, 1004, 137, 43);
		ReviewPanel.add(btnGoBack);

		
		JTextArea textAreaOrder = new JTextArea();
		textAreaOrder.setEditable(false);
		textAreaOrder.setBounds(47, 60, 885, 851);
		ReviewPanel.add(textAreaOrder);

		JLabel lblSubtotalTextRP = new JLabel("Subtotal");
		lblSubtotalTextRP.setHorizontalAlignment(SwingConstants.LEFT);
		lblSubtotalTextRP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubtotalTextRP.setBounds(1205, 188, 71, 32);
		ReviewPanel.add(lblSubtotalTextRP);
		
		JLabel lblSubtotalRP = new JLabel("0.00");
		lblSubtotalRP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotalRP.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSubtotalRP.setBounds(1548, 181, 115, 43);
		ReviewPanel.add(lblSubtotalRP);
		
		JLabel lblTaxTextRP = new JLabel("Tax");
		lblTaxTextRP.setHorizontalAlignment(SwingConstants.LEFT);
		lblTaxTextRP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTaxTextRP.setBounds(1205, 382, 71, 32);
		ReviewPanel.add(lblTaxTextRP);
		
		JLabel lblTotalTextRP = new JLabel("Total");
		lblTotalTextRP.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalTextRP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalTextRP.setBounds(1205, 583, 71, 32);
		ReviewPanel.add(lblTotalTextRP);
		
		JLabel lblTaxRP = new JLabel("0.00");
		lblTaxRP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTaxRP.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTaxRP.setBounds(1548, 375, 115, 43);
		ReviewPanel.add(lblTaxRP);
		
		JLabel lblTotalRP = new JLabel("0.00");
		lblTotalRP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalRP.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotalRP.setBounds(1548, 576, 115, 43);
		ReviewPanel.add(lblTotalRP);
		
		
		/*
		 * Modifier panel, allows for user to customize their food item selection
		 * the following codes creates the Modifier panel
		 * and adds all the buttons and labels to the
		 * Modifier panel
		 */
		
		/*
		 * Action event handler if you click anywhere on the beginning panel 
		 * it will bring you to the Main Panel.
		 */
		
		BeginningPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainPanel.setVisible(true);
				BeginningPanel.setVisible(false);
			}
		});
		
		/*
		 * All the button actions
		 * for the Main Panel
		 * btnburgers,btnHotdogs,btnDrinks sets Visible their respective food items
		 * and changes the lblItemPrice next to each food item to be their respective 
		 * price
		 */
		
		/*
		 * event handlers for food type buttons
		 * 
		 */
		btnburgers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				btnAllAmerican.setVisible(true);
				btnLittleOhio.setVisible(true);
				btnDadsWeekend.setVisible(true);
				btnHavanaDog.setVisible(false);
				btnClassicChicago.setVisible(false);
				btnOlCornDog.setVisible(false);
				btnFountainDrinks.setVisible(false);
				btnIcedTea.setVisible(false);
				btnCoffee.setVisible(false);
				lblItemPrice.setText("$6.00");
				lblItemPrice2.setText("$5.00");
				lblItemPrice3.setText("$7.00");

				
			}
		});
		
		btnHotdogs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnAllAmerican.setVisible(false);
				btnLittleOhio.setVisible(false);
				btnDadsWeekend.setVisible(false);
				btnHavanaDog.setVisible(true);
				btnClassicChicago.setVisible(true);
				btnOlCornDog.setVisible(true);
				btnFountainDrinks.setVisible(false);
				btnIcedTea.setVisible(false);
				btnCoffee.setVisible(false);
				lblItemPrice.setText("$4.00");
				lblItemPrice2.setText("$3.00");
				lblItemPrice3.setText("$2.00");
			}
		});
		
		btnDrinks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAllAmerican.setVisible(false);
				btnLittleOhio.setVisible(false);
				btnDadsWeekend.setVisible(false);
				btnHavanaDog.setVisible(false);
				btnClassicChicago.setVisible(false);
				btnOlCornDog.setVisible(false);
				btnFountainDrinks.setVisible(true);
				btnIcedTea.setVisible(true);
				btnCoffee.setVisible(true);
				lblItemPrice.setText("$0.99");
				lblItemPrice2.setText("$0.99");
				lblItemPrice3.setText("$0.99");
			}
		});
		/*
		 * Event handlers for remove item and review order
		 * remove item button, removes selected item from jlist
		 * Review order button brings you to Review Order Panel
		 */
		btnRemoveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
				System.out.println(listModel.get(selectedIndex));
				String s =  (String) listModel.get(selectedIndex);
				
				Matcher matcher = Pattern.compile("\\d+").matcher(s);
				matcher.find();
				int removedQty = Integer.valueOf(matcher.group());
				System.out.println(removedQty);
				if (s.contains("All American")) {
					allAmerican -= removedQty;
				}
				else if (s.contains("Little Ohio")) {
					littleOhio -= removedQty;
				}
				else if (s.contains("Dad's Weekend")) {
					dadsWeekend -= removedQty;
				}
				else if (s.contains("Havana Dog")) {
					havanaDog -= removedQty;
				}
				else if (s.contains("Classic Chicago")) {
					classicChicago -= removedQty;
				}
				else if (s.contains("Ol' Corn Dog")) {
					littleOhio -= removedQty;
				}
				else if (s.contains("Fountain Drink")) {
					fountainDrink -= removedQty;
				}
				else if (s.contains("Iced Tea")) {
					icedTea -= removedQty;
				}
				else if (s.contains("Coffee")) {
					coffee -= removedQty;
				}
				System.out.println(allAmerican +" "+ littleOhio+ " "+dadsWeekend);
				
				listModel.remove(selectedIndex);
				ArrListSubtotal.remove(selectedIndex);
				/*float subtotal = 0;
				float tax = 0;
				float total = 0;
				for(int i = 0; i < ArrListSubtotal.size(); i++)
					subtotal += ArrListSubtotal.get(i);
				lblSubtotal.setText(df.format(subtotal));
				tax = (float)(subtotal * 0.07);
				total = subtotal + tax;
				lblTax.setText(df.format(tax));
				lblTotal.setText(df.format(total));
				 * 
				 * 
				 * 
				*/
				float subtotal = 0;
				float tax =0;
				float total =0;
				for(int i = 0; i < ArrListSubtotal.size(); i++)
					subtotal += ArrListSubtotal.get(i);
				lblSubtotal.setText(df.format(subtotal));
				tax = (float)(subtotal * 0.07);
				total = subtotal + tax;
				lblTax.setText(df.format(tax));
				lblTotal.setText(df.format(total));
				if (ArrListSubtotal.size() == 0) {
					btnReviewOrder.setEnabled(false);
					btnRemoveItem.setEnabled(false);
				}
			}
		});
		
		btnReviewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReviewPanel.setVisible(true);
				MainPanel.setVisible(false);
				textAreaOrder.setText(null);
				String s = "";
				for (int index = 0; index < listModel.getSize(); index++) {
					s += "\n" + listModel.getElementAt(index);
				    //textAreaOrder.append(listModel.getElementAt(index).toString());
				}
				textAreaOrder.setText(s);
				lblSubtotalRP.setText(lblSubtotal.getText());
				lblTaxRP.setText(lblTax.getText());
				lblTotalRP.setText(lblTotal.getText());
				
				
			}
		});
		/*
		 * event handlers for all food items
		 * each button will bring you to modifier panel
		 * and change the labels and buttons on the modifier 
		 * panel accordingly
		 */
		
		
		btnAllAmerican.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierPanel.setVisible(true);
				MainPanel.setVisible(false);
				btnMinusOne.setEnabled(false);
				qty = 1;
				textFieldqty.setText(String.valueOf(qty));
				lblModFoodItem.setText("All American");
				lblModfooditemprice.setText("6.00");
				lblModIngredient1.setText("Lettuce");
				lblModIngredient2.setText("Ketchup");
				lblModIngredient3.setText("Pickle");
				lblModIngredient4.setText("Onion");
				lblModIngredient5.setText("Cheese");
				lblModIngredient6.setText("Tomato");
				lblModIngredientQty1.setText("Regular");
				lblModIngredientQty2.setText("None");
				lblModIngredientQty3.setText("None");
				lblModIngredientQty4.setText("None");
				lblModIngredientQty5.setText("Regular");
				lblModIngredientQty6.setText("Regular");
				btnModIngredientMinus1.setEnabled(true);
				btnModIngredientMinus2.setEnabled(false);
				btnModIngredientMinus3.setEnabled(false);
				btnModIngredientMinus4.setEnabled(false);
				btnModIngredientMinus5.setEnabled(true);
				btnModIngredientMinus6.setEnabled(true);
				btnModIngredientMinus1.setVisible(true);
				btnModIngredientMinus2.setVisible(true);
				btnModIngredientMinus3.setVisible(true);
				btnModIngredientMinus4.setVisible(true);
				btnModIngredientMinus5.setVisible(true);
				btnModIngredientMinus6.setVisible(true);
				btnModIngredientPlus1.setEnabled(true);
				btnModIngredientPlus2.setEnabled(true);
				btnModIngredientPlus3.setEnabled(true);
				btnModIngredientPlus4.setEnabled(true);
				btnModIngredientPlus5.setEnabled(true);
				btnModIngredientPlus6.setEnabled(true);
				btnModIngredientPlus1.setVisible(true);
				btnModIngredientPlus2.setVisible(true);
				btnModIngredientPlus3.setVisible(true);
				btnModIngredientPlus4.setVisible(true);
				btnModIngredientPlus5.setVisible(true);
				btnModIngredientPlus6.setVisible(true);
			}
		});
		btnLittleOhio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierPanel.setVisible(true);
				MainPanel.setVisible(false);
				btnMinusOne.setEnabled(false);
				qty = 1;
				textFieldqty.setText(String.valueOf(qty));
				lblModFoodItem.setText("Little Ohio");
				lblModfooditemprice.setText("5.00");
				lblModIngredient1.setText("Lettuce");
				lblModIngredient2.setText("Ketchup");
				lblModIngredient3.setText("Pickle");
				lblModIngredient4.setText("Onion");
				lblModIngredient5.setText("Cheese");
				lblModIngredient6.setText("Tomato");
				lblModIngredientQty1.setText("None");
				lblModIngredientQty2.setText("Regular");
				lblModIngredientQty3.setText("Regular");
				lblModIngredientQty4.setText("None");
				lblModIngredientQty5.setText("Regular");
				lblModIngredientQty6.setText("None");
				btnModIngredientMinus1.setEnabled(false);
				btnModIngredientMinus2.setEnabled(true);
				btnModIngredientMinus3.setEnabled(true);
				btnModIngredientMinus4.setEnabled(false);
				btnModIngredientMinus5.setEnabled(true);
				btnModIngredientMinus6.setEnabled(false);
				btnModIngredientMinus1.setVisible(true);
				btnModIngredientMinus2.setVisible(true);
				btnModIngredientMinus3.setVisible(true);
				btnModIngredientMinus4.setVisible(true);
				btnModIngredientMinus5.setVisible(true);
				btnModIngredientMinus6.setVisible(true);
				btnModIngredientPlus1.setEnabled(true);
				btnModIngredientPlus2.setEnabled(true);
				btnModIngredientPlus3.setEnabled(true);
				btnModIngredientPlus4.setEnabled(true);
				btnModIngredientPlus5.setEnabled(true);
				btnModIngredientPlus6.setEnabled(true);
				btnModIngredientPlus1.setVisible(true);
				btnModIngredientPlus2.setVisible(true);
				btnModIngredientPlus3.setVisible(true);
				btnModIngredientPlus4.setVisible(true);
				btnModIngredientPlus5.setVisible(true);
				btnModIngredientPlus6.setVisible(true);
			}
		});
		
		btnDadsWeekend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierPanel.setVisible(true);
				MainPanel.setVisible(false);
				btnMinusOne.setEnabled(false);
				qty = 1;
				textFieldqty.setText(String.valueOf(qty));
				lblModFoodItem.setText("Dad's Weekend");
				lblModfooditemprice.setText("7.00");
				lblModIngredient1.setText("Lettuce");
				lblModIngredient2.setText("Ketchup");
				lblModIngredient3.setText("Pickle");
				lblModIngredient4.setText("Onion");
				lblModIngredient5.setText("Cheese");
				lblModIngredient6.setText("Tomato");
				lblModIngredientQty1.setText("None");
				lblModIngredientQty2.setText("Regular");
				lblModIngredientQty3.setText("None");
				lblModIngredientQty4.setText("None");
				lblModIngredientQty5.setText("Regular");
				lblModIngredientQty6.setText("None");
				btnModIngredientMinus1.setEnabled(false);
				btnModIngredientMinus2.setEnabled(true);
				btnModIngredientMinus3.setEnabled(false);
				btnModIngredientMinus4.setEnabled(false);
				btnModIngredientMinus5.setEnabled(true);
				btnModIngredientMinus6.setEnabled(false);
				btnModIngredientMinus1.setVisible(true);
				btnModIngredientMinus2.setVisible(true);
				btnModIngredientMinus3.setVisible(true);
				btnModIngredientMinus4.setVisible(true);
				btnModIngredientMinus5.setVisible(true);
				btnModIngredientMinus6.setVisible(true);
				btnModIngredientPlus1.setEnabled(true);
				btnModIngredientPlus2.setEnabled(true);
				btnModIngredientPlus3.setEnabled(true);
				btnModIngredientPlus4.setEnabled(true);
				btnModIngredientPlus5.setEnabled(true);
				btnModIngredientPlus6.setEnabled(true);
				btnModIngredientPlus1.setVisible(true);
				btnModIngredientPlus2.setVisible(true);
				btnModIngredientPlus3.setVisible(true);
				btnModIngredientPlus4.setVisible(true);
				btnModIngredientPlus5.setVisible(true);
				btnModIngredientPlus6.setVisible(true);
			}
		});
		
		btnHavanaDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierPanel.setVisible(true);
				MainPanel.setVisible(false);
				btnMinusOne.setEnabled(false);
				qty = 1;
				textFieldqty.setText(String.valueOf(qty));
				lblModFoodItem.setText("Havana Dog");
				lblModfooditemprice.setText("4.00");
				lblModIngredientQty1.setText("Regular");
				lblModIngredientQty2.setText("None");
				lblModIngredientQty3.setText("None");
				lblModIngredientQty4.setText("");
				lblModIngredientQty5.setText("");
				lblModIngredientQty6.setText("");
				lblModIngredient1.setText("Ketchup");
				lblModIngredient2.setText("Mustard");
				lblModIngredient3.setText("Relish");
				lblModIngredient4.setText("");
				lblModIngredient5.setText("");
				lblModIngredient6.setText("");
				btnModIngredientMinus1.setEnabled(true);
				btnModIngredientMinus2.setEnabled(false);
				btnModIngredientMinus3.setEnabled(false);
				btnModIngredientMinus1.setVisible(true);
				btnModIngredientMinus2.setVisible(true);
				btnModIngredientMinus3.setVisible(true);
				btnModIngredientMinus4.setVisible(false);
				btnModIngredientMinus5.setVisible(false);
				btnModIngredientMinus6.setVisible(false);
				btnModIngredientPlus1.setEnabled(true);
				btnModIngredientPlus2.setEnabled(true);
				btnModIngredientPlus3.setEnabled(true);
				btnModIngredientPlus1.setVisible(true);
				btnModIngredientPlus2.setVisible(true);
				btnModIngredientPlus3.setVisible(true);
				btnModIngredientPlus4.setVisible(false);
				btnModIngredientPlus5.setVisible(false);
				btnModIngredientPlus6.setVisible(false);
				

			}
		});
		btnClassicChicago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierPanel.setVisible(true);
				MainPanel.setVisible(false);
				btnMinusOne.setEnabled(false);
				qty = 1;
				textFieldqty.setText(String.valueOf(qty));
				lblModFoodItem.setText("Classic Chicago");
				lblModfooditemprice.setText("3.00");
				lblModfooditemprice.setText("4.00");
				lblModIngredientQty1.setText("None");
				lblModIngredientQty2.setText("Regular");
				lblModIngredientQty3.setText("Regular");
				lblModIngredientQty4.setText("");
				lblModIngredientQty5.setText("");
				lblModIngredientQty6.setText("");
				lblModIngredient1.setText("Ketchup");
				lblModIngredient2.setText("Mustard");
				lblModIngredient3.setText("Relish");
				lblModIngredient4.setText("");
				lblModIngredient5.setText("");
				lblModIngredient6.setText("");
				btnModIngredientMinus1.setEnabled(false);
				btnModIngredientMinus2.setEnabled(true);
				btnModIngredientMinus3.setEnabled(true);
				btnModIngredientMinus1.setVisible(true);
				btnModIngredientMinus2.setVisible(true);
				btnModIngredientMinus3.setVisible(true);
				btnModIngredientMinus4.setVisible(false);
				btnModIngredientMinus5.setVisible(false);
				btnModIngredientMinus6.setVisible(false);
				btnModIngredientPlus1.setEnabled(true);
				btnModIngredientPlus2.setEnabled(true);
				btnModIngredientPlus3.setEnabled(true);
				btnModIngredientPlus1.setVisible(true);
				btnModIngredientPlus2.setVisible(true);
				btnModIngredientPlus3.setVisible(true);
				btnModIngredientPlus4.setVisible(false);
				btnModIngredientPlus5.setVisible(false);
				btnModIngredientPlus6.setVisible(false);
			}
		});
		btnOlCornDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierPanel.setVisible(true);
				MainPanel.setVisible(false);
				btnMinusOne.setEnabled(false);
				qty = 1;
				textFieldqty.setText(String.valueOf(qty));
				lblModFoodItem.setText("Ol' Corn Dog");
				lblModfooditemprice.setText("2.00");
				lblModfooditemprice.setText("4.00");
				lblModIngredientQty1.setText("None");
				lblModIngredientQty2.setText("None");
				lblModIngredientQty3.setText("");
				lblModIngredientQty4.setText("");
				lblModIngredientQty5.setText("");
				lblModIngredientQty6.setText("");
				lblModIngredient1.setText("Ketchup");
				lblModIngredient2.setText("Mustard");
				lblModIngredient3.setText("");
				lblModIngredient4.setText("");
				lblModIngredient5.setText("");
				lblModIngredient6.setText("");
				btnModIngredientMinus1.setEnabled(false);
				btnModIngredientMinus2.setEnabled(false);
				btnModIngredientMinus3.setEnabled(false);
				btnModIngredientMinus1.setVisible(true);
				btnModIngredientMinus2.setVisible(true);
				btnModIngredientMinus3.setVisible(false);
				btnModIngredientMinus4.setVisible(false);
				btnModIngredientMinus5.setVisible(false);
				btnModIngredientMinus6.setVisible(false);
				btnModIngredientPlus1.setEnabled(true);
				btnModIngredientPlus2.setEnabled(true);
				btnModIngredientPlus3.setEnabled(true);
				btnModIngredientPlus1.setVisible(true);
				btnModIngredientPlus2.setVisible(true);
				btnModIngredientPlus3.setVisible(false);
				btnModIngredientPlus4.setVisible(false);
				btnModIngredientPlus5.setVisible(false);
				btnModIngredientPlus6.setVisible(false);
			}
		});
		
		btnFountainDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierPanel.setVisible(true);
				MainPanel.setVisible(false);
				btnMinusOne.setEnabled(false);
				qty = 1;
				textFieldqty.setText(String.valueOf(qty));
				lblModFoodItem.setText("Fountain Drink");
				lblModfooditemprice.setText("0.99");
				lblModIngredientQty1.setText("");
				lblModIngredientQty2.setText("");
				lblModIngredientQty3.setText("");
				lblModIngredientQty4.setText("");
				lblModIngredientQty5.setText("");
				lblModIngredientQty6.setText("");
				lblModIngredient1.setText("");
				lblModIngredient2.setText("");
				lblModIngredient3.setText("");
				lblModIngredient4.setText("");
				lblModIngredient5.setText("");
				lblModIngredient6.setText("");
				btnModIngredientMinus1.setVisible(false);
				btnModIngredientMinus2.setVisible(false);
				btnModIngredientMinus3.setVisible(false);
				btnModIngredientMinus4.setVisible(false);
				btnModIngredientMinus5.setVisible(false);
				btnModIngredientMinus6.setVisible(false);
				btnModIngredientPlus1.setVisible(false);
				btnModIngredientPlus2.setVisible(false);
				btnModIngredientPlus3.setVisible(false);
				btnModIngredientPlus4.setVisible(false);
				btnModIngredientPlus5.setVisible(false);
				btnModIngredientPlus6.setVisible(false);
			}
		});
		btnIcedTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierPanel.setVisible(true);
				MainPanel.setVisible(false);
				btnMinusOne.setEnabled(false);
				qty = 1;
				textFieldqty.setText(String.valueOf(qty));
				lblModFoodItem.setText("Iced Tea");
				lblModfooditemprice.setText("0.99");
				lblModIngredientQty1.setText("");
				lblModIngredientQty2.setText("");
				lblModIngredientQty3.setText("");
				lblModIngredientQty4.setText("");
				lblModIngredientQty5.setText("");
				lblModIngredientQty6.setText("");
				lblModIngredient1.setText("");
				lblModIngredient2.setText("");
				lblModIngredient3.setText("");
				lblModIngredient4.setText("");
				lblModIngredient5.setText("");
				lblModIngredient6.setText("");
				btnModIngredientMinus1.setVisible(false);
				btnModIngredientMinus2.setVisible(false);
				btnModIngredientMinus3.setVisible(false);
				btnModIngredientMinus4.setVisible(false);
				btnModIngredientMinus5.setVisible(false);
				btnModIngredientMinus6.setVisible(false);
				btnModIngredientPlus1.setVisible(false);
				btnModIngredientPlus2.setVisible(false);
				btnModIngredientPlus3.setVisible(false);
				btnModIngredientPlus4.setVisible(false);
				btnModIngredientPlus5.setVisible(false);
				btnModIngredientPlus6.setVisible(false);
			}
		});
		btnCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifierPanel.setVisible(true);
				MainPanel.setVisible(false);
				btnMinusOne.setEnabled(false);
				qty = 1;
				textFieldqty.setText(String.valueOf(qty));
				lblModFoodItem.setText("Coffee");
				lblModfooditemprice.setText("0.99");
				lblModIngredientQty1.setText("");
				lblModIngredientQty2.setText("");
				lblModIngredientQty3.setText("");
				lblModIngredientQty4.setText("");
				lblModIngredientQty5.setText("");
				lblModIngredientQty6.setText("");
				lblModIngredient1.setText("");
				lblModIngredient2.setText("");
				lblModIngredient3.setText("");
				lblModIngredient4.setText("");
				lblModIngredient5.setText("");
				lblModIngredient6.setText("");
				btnModIngredientMinus1.setVisible(false);
				btnModIngredientMinus2.setVisible(false);
				btnModIngredientMinus3.setVisible(false);
				btnModIngredientMinus4.setVisible(false);
				btnModIngredientMinus5.setVisible(false);
				btnModIngredientMinus6.setVisible(false);
				btnModIngredientPlus1.setVisible(false);
				btnModIngredientPlus2.setVisible(false);
				btnModIngredientPlus3.setVisible(false);
				btnModIngredientPlus4.setVisible(false);
				btnModIngredientPlus5.setVisible(false);
				btnModIngredientPlus6.setVisible(false);
			}
		});
		
		
		/*
		 * Below are all the actions for the
		 * buttons on the Modifier Panel
		 */
		/*
		 * this one's a bit of a mess. So this will add the food item and it's quantity
		 * and to the jlist. it adds the price of the food items to an array and adds them
		 * and then displays it in a label
		 */
		/*
		 * Button actions for Review Order Panel
		 * GoBack brings you back to main panel
		 * pay button brings you to pay panel
		 */
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReviewPanel.setVisible(false);
				MainPanel.setVisible(true);
			}				
		
		});

		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				ArrListSubtotal.clear();
//				lblSubtotal.setText("0.00");
//				listModel.removeAllElements();
				PayPanel.setVisible(true);
				ReviewPanel.setVisible(false);
				lblNameFieldError.setText("");
	            lblCardNumberFieldError.setText("");
	            lblExpirationDateFieldError.setText("");
	            lblSecurityCodeFieldError.setText("");
	            lblZipCodeFieldError.setText("");
            
			}		
		});
		
      
      
      
      //PayPanel button listeners 
      btnConfirmPayment.addActionListener(new ActionListener(){
      	public void actionPerformed(ActionEvent arg0){
            lblNameFieldError.setText("");
            lblCardNumberFieldError.setText("");
            lblExpirationDateFieldError.setText("");
            lblSecurityCodeFieldError.setText("");
            lblZipCodeFieldError.setText("");
            
            boolean infoValid = false;
            
            if(checkName(nameField.getText())){ 
               if(checkCardNumber(cardNumberField.getText())){ 
                  if(checkExpiration(expirationDateField.getText())){ 
                     if(checkSecurityCode(securityCodeField.getText())){ 
                        if(checkZipCode(zipCodeField.getText())){
                           infoValid = true;
                        }
                        else
                           lblZipCodeFieldError.setText("Invalid ZIP code. Please try again.");
                     }
                     else
                        lblSecurityCodeFieldError.setText("Invalid security code. Please try again.");
                  }
                  else
                     lblExpirationDateFieldError.setText("Invalid expiration date. Please try again.");
               }
               else
                  lblCardNumberFieldError.setText("Invalid card number. Please try again.");
            }
            else
               lblNameFieldError.setText("Invalid name. Please try again.");
            
               
            
            if(infoValid){
               PayPanel.setVisible(false);
               ReceiptPanel.setVisible(true);
               lblReceipt.setText("$" + lblTotal.getText() + " has been charged to VISA/MC ending in " + cardNumberField.getText().substring(cardNumberField.getText().length()-4));
               String s = "";
               Date date = new Date();
               s = date + "\n"+ nameField.getText() +"\nCredit card ending in " + cardNumberField.getText().substring(cardNumberField.getText().length()-4)+"\n"+textAreaOrder.getText()+"\n----------------------------------"+ "\nSubtotal        " +lblSubtotal.getText()+ "\nTax             " +lblTax.getText()+ "\nTotal           " +lblTotal.getText();
               PrintWriter writer;
               try {
					writer = new PrintWriter("Receipt.txt", "UTF-8");
					writer.println(s);
					writer.close();
               } catch (FileNotFoundException | UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
               }
               float tempTotal = Float.parseFloat(lblTotal.getText());
               float tempSubtotal = Float.parseFloat(lblSubtotal.getText());
               writeToDatabase(tempSubtotal,allAmerican,littleOhio,dadsWeekend,havanaDog,classicChicago,olCornDog,fountainDrink,icedTea,coffee);
            }
            else
               securityCodeField.setText("");     
         }		
		});

      btnBackToReviewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PayPanel.setVisible(false);
				ReviewPanel.setVisible(true);
				nameField.setText("");
				cardNumberField.setText("");
				expirationDateField.setText("");
				securityCodeField.setText("");     
	            zipCodeField.setText("");
				
			}		
		});
		
      //ReceiptPanel button listeners 
      btnCreateNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReceiptPanel.setVisible(false);
				BeginningPanel.setVisible(true);
				ArrListSubtotal.clear();
				lblSubtotal.setText("0.00");
				lblTotal.setText("0.00");
				lblTax.setText("0.00");
				listModel.removeAllElements();
				nameField.setText("");
				cardNumberField.setText("");
				expirationDateField.setText("");
				securityCodeField.setText("");     
	            zipCodeField.setText("");
	            btnReviewOrder.setEnabled(false);
	            allAmerican = 0;
	        	littleOhio = 0;
	        	dadsWeekend = 0;
	        	havanaDog =0;
	        	classicChicago =0;
	        	olCornDog =0;
	        	fountainDrink=0;
	        	icedTea =0;
	        	coffee =0;
			}		
		});
   
   }
   
	static void writeToDatabase(float orderTotal, int all_american_burger, int little_ohio_burger, int dads_weekend_burger, int havana_dog, int classic_chicago, int ol_corndog,int fountain_drink, int iced_tea, int coffee) {
		String PUBLIC_DNS ="bulldys-1.co4elbd1d0lu.us-east-1.rds.amazonaws.com"; 	
    	String PORT = "3306";
    	String REMOTE_DATABASE_USERNAME = "remoteu";
    	String DATABASE_USER_PASSWORD = "remoteupassword";
    	String DATABASE = "Allorders";
    	Connection connection = null;
    	Statement stmt = null;
    	
    	//so this next commented out bit isn't generally necessary but there may come a time where you have to manually load
    	//the driver, so here it is in commented form
    	/*
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }
    	*/

        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://" + PUBLIC_DNS + ":" + PORT + "/" + DATABASE, REMOTE_DATABASE_USERNAME, DATABASE_USER_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection Failed!:\n" + e.getMessage());
        }
        if (connection != null) {
            
        } else {
            System.out.println("FAILURE! Failed to make connection!");
        }
        try {
            stmt = connection.createStatement();
            String sql = "INSERT INTO orders(orderTotal, status,all_american_burger, little_ohio_burger, dads_weekend_burger,havana_dog,classic_chicago, ol_corndog,fountain_drink, iced_tea,coffee)" + "VALUES ("+ df.format(orderTotal)+", 0,"+all_american_burger+","+little_ohio_burger+","+dads_weekend_burger+","+havana_dog+","+classic_chicago+","+ol_corndog+","+fountain_drink+","+iced_tea+","+coffee+");";
            stmt.executeUpdate(sql);
            
            //STEP 6: Clean-up environment
            stmt.close();
            connection.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        
	}

   
   //PayPanel helper methods
   
   private boolean checkName(String name){
         boolean validName = false;
         if(!(name.isEmpty())){
            
            //create char array
            char testChars[] = name.toCharArray();
            
            //test if first character is letter 
            if(Character.isLetter(testChars[0])){
            
               //test if space in array
               boolean hasWhitespace = false;
               int counter = 1;
               while(!hasWhitespace && counter < testChars.length){
                  if(Character.isWhitespace(testChars[counter]))
                     hasWhitespace = true;
                  counter++;
               }   
                  
               //test if space in between other characters
               if(hasWhitespace && counter != testChars.length)   
                  validName = true;
            }
         }
         return validName;
   }
      
   private boolean checkCardNumber(String strCardNumber){
      boolean validNumber = false;
      
      if(!(strCardNumber.isEmpty())){  
         
         validNumber = (luhnAlgorithmHelper(strCardNumber) && isValidVendor(strCardNumber));
      } 
      
      return validNumber;
   }
   
   private boolean checkExpiration(String expDate){
      boolean validExp = false;   
      if(!(expDate.isEmpty()) && expDate.length() == 4){
         int month = Integer.parseInt(expDate.substring(0,2));
         int year = Integer.parseInt(expDate.substring(2,4));
         if(month >= 1 && month <= 12){   
            Calendar calendar = Calendar.getInstance(); 
            int currentMonth = calendar.get(Calendar.MONTH)+1;
            int currentYear = calendar.get(Calendar.YEAR)-2000;
            if(currentYear < year || (currentYear == year && currentMonth <= month))
               validExp=true;
         }
      }      
      return validExp;
   }
   
   private boolean checkSecurityCode(String secCode){
      boolean validSecCode = false;
      if(secCode.length() == 3)
         validSecCode = true;
      return validSecCode;
   }
   
   private boolean checkZipCode(String zipCode){
      boolean validZipCode = false;
      if(zipCode.length() == 5)
         validZipCode = true;
      return validZipCode;
   }

   private boolean luhnAlgorithmHelper(String strCardNumber){
      
      boolean luhnVerified = false;
      
      //convert string Card Number to int array   
      int cardNumber[] = new int[strCardNumber.length()];
      for(int x=0; x < strCardNumber.length(); x++){
         cardNumber[x] = Integer.parseInt(strCardNumber.substring(x, x+1));
      }
      
      //set checkDigit
      int checkDigit = cardNumber[cardNumber.length-1];
         
      //reverse all digits in new array
      int testValues[] = new int[cardNumber.length];
      for(int z=cardNumber.length-1; z >= 0; z--){
         testValues[testValues.length-1-z] = cardNumber[z];
       }
        
      //double even digits
      for(int b=1; b<testValues.length; b+=2)
         testValues[b] *= 2; 
         
      //subtract 9 from double numbers
      for(int d=1; d < testValues.length; d+=2){
         if(testValues[d] > 9)
            testValues[d] = testValues[d] - 9;
      }
               
      //add all numbers
      int sum = 0;
      for(int f=0; f < testValues.length; f++)
         sum += testValues[f];
         
      //compare using check digit and mod10
      if(sum % 10 == 0)
         luhnVerified = true;
      
      return luhnVerified;
   }
   
   private boolean isValidVendor(String strCardNumber){
      if(isVisa (strCardNumber) || isMastercard(strCardNumber))
         return true;
      return false;
   }

   private boolean isVisa(String strCardNumber){
      if(strCardNumber.length() == 16 || strCardNumber.length() == 16 || strCardNumber.length() == 19){
         if(Integer.parseInt(strCardNumber.substring(0,1)) == 4)
            return true;
      }
      return false;   
   }
   
   private boolean isMastercard(String strCardNumber){
      if(strCardNumber.length() == 16){
         int firstTwo = Integer.parseInt(strCardNumber.substring(0,2));
         int firstSix = Integer.parseInt(strCardNumber.substring(0,6));
         if((firstTwo >= 51 && firstTwo <= 55) || (firstSix >= 222100 && firstSix <= 272099))
            return true;
      }
      return false;
   }

   //JLimitedIntegerField class for PayPanel
   private class JLimitedTextField extends JTextField{
      
      int maxLen = 10;

      public JLimitedTextField(int maxLen){
         this.maxLen = maxLen;
      }

      protected Document createDefaultModel(){
         return new LimitDocument();
      }

      private class LimitDocument extends PlainDocument{
         @Override
         public void insertString(int offset, String  str, AttributeSet attr) throws BadLocationException{
            if (str == null) return;
            if ((getLength() + str.length()) <= maxLen){
               for (char c : str.toCharArray()){
                  if(!(Character.isLetter(c) || Character.isWhitespace(c))){
                     return;
                  }
               }
               super.insertString(offset, str, attr);
            }
         }
      }
        
   }
   
   private class JLimitedIntegerField extends JTextField{
      
      int maxLen = 10;

      public JLimitedIntegerField(int maxLen){
         this.maxLen = maxLen;
      }

      protected Document createDefaultModel(){
         return new LimitDocument();
      }

      private class LimitDocument extends PlainDocument{
         @Override
         public void insertString(int offset, String  str, AttributeSet attr) throws BadLocationException{
            if (str == null) return;
            if ((getLength() + str.length()) <= maxLen){
               for (char c : str.toCharArray()){
                  if(!Character.isDigit(c)){
                     return;
                  }
               }
               super.insertString(offset, str, attr);
            }
         }
      }
        
   } 

   //JSecureCodeField for PayPanel
   private class JSecureCodeField extends JPasswordField{
      
      int maxLen = 10;

      public JSecureCodeField(int maxLen){
         this.maxLen = maxLen;
      }

      protected Document createDefaultModel(){
         return new LimitDocument();
      }

      private class LimitDocument extends PlainDocument{
         @Override
         public void insertString(int offset, String  str, AttributeSet attr) throws BadLocationException{
            if (str == null) return;
            if ((getLength() + str.length()) <= maxLen){
               for (char c : str.toCharArray()){
                  if(!Character.isDigit(c)){
                     return;
                  }
               }
               super.insertString(offset, str, attr);
            }
         }
      }
   }
}
