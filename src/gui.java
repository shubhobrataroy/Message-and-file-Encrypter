import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class gui extends JFrame {
	
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JButton button1;
	JButton button2;
	//I used JTextArea instead of JTextField because it has dynamic size and it Supports newlines
	JTextArea t1; //Contains the main text that needs to be encrypted of decrypted 
	JTextArea f1; //Contains the key for encryption or decryption
	JTextArea f2; //Contains the processed test
	JTabbedPane tp;// Creates tab
	JPanel Panel_Container1;
	
	gui()
	{
		super("OOP1 Project");
		this.setLayout(new BorderLayout()); //Setting BorderLayout For main frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Setting Default Close Operation of our frame
		this.setResizable(false); // The main window can't be resized
		
		//Initializing the components
		panel1=new JPanel(new BorderLayout());
		Panel_Container1=new JPanel(new BorderLayout());
		panel2=new JPanel(new FlowLayout());
		panel3=new JPanel(new BorderLayout());
		button1=new JButton("ENCRYPT");
		button2=new JButton("DECRYPT");
		f1=new JTextArea();
		f2=new JTextArea();
		tp=new JTabbedPane();
		t1=new JTextArea();
		
		
		this.setSize(500, 400); //Setting size of our window
		this.setLocationRelativeTo(null); //Setting Location of our window to the centre of our screen
		
		panel1.setSize(300, 200); 
		//panel1.setVisible(true);
		
		//resizing the textAreas
		t1.setColumns(40);
		t1.setRows(6);
		f1.setColumns(10);
		f2.setColumns(40);
		f2.setRows(11);
		f2.setEditable(false);
		
		
		button1.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				try{
				
				String s1=f1.getText(); //Contains the key it will be converted to integer
				
				f2.setText(new gui().process(s1, t1.getText(),'+')); 
				}catch(Exception e){ JOptionPane.showMessageDialog(null,"FAILED !!!!!");}
			}
			
		});
		
		
		button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
				
				String s1=f1.getText();
				
				f2.setText(new gui().process(s1, t1.getText(),'-'));
				}catch(Exception e){ JOptionPane.showMessageDialog(null,"FAILED !!!!!");}
			}
			
		});
		
		
		panel1.add(new JLabel("Enter Your Message Here:"),BorderLayout.NORTH);
		panel1.add(t1,BorderLayout.CENTER);
		
		panel2.add(new JLabel("Enter Your KEY HERE :"));panel2.add(f1);panel2.add(button1);panel2.add(button2);
		
		panel3.add(new JLabel("Converted Message: "),BorderLayout.NORTH);
		panel3.add(f2,BorderLayout.CENTER);
		
		
		
		this.Panel_Container1.add(panel1,BorderLayout.NORTH);
		this.Panel_Container1.add(panel2,BorderLayout.CENTER);
		this.Panel_Container1.add(panel3,BorderLayout.SOUTH);
		
		tp.addTab("Message Encrypter" ,this.Panel_Container1);
		
		file_io f=new file_io();
		
		tp.addTab("File Encrypter",f.getPanel());
		
		add(tp);
	}
	
	String process(String k,String message,char operation){
		
		
		int key= Integer.valueOf(k);
		JOptionPane.showMessageDialog(null,"Success !!!!!");
		
		StringBuilder s3=new StringBuilder(message);
		StringBuilder s2=new StringBuilder("");
		
		char c;
		
		for(int i=0;i<s3.length();i++)
		{
			c=s3.charAt(i);
			if(operation=='-')
	        {c=(char)(c-key);}
			
			else {c=(char)(c+key);}
			s2.append(c);
		}
	return String.format("%s", s2);
		
	}
	
}
