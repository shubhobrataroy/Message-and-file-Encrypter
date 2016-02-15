import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.*;

public class file_io {
	JFileChooser f;
	JPanel panel_container;
	JTextArea t1;
	JButton b;
	JPanel p1= new JPanel(new FlowLayout());
	JPanel p2=new JPanel(new BorderLayout());
	JPanel p3=new JPanel(new BorderLayout());
	JPanel p4=new JPanel();
	JTextArea t2= new JTextArea ();
	JTextArea t3= new JTextArea ();
	JButton button1=new JButton("ENCRYPT");
	JButton button2=new JButton("DECRYPT");
	StringBuilder s= new StringBuilder();
	JTextArea t4=new JTextArea();
	
	String path;
	public file_io ()
	{
		this.panel_container=new JPanel(new BorderLayout());
		f= new JFileChooser();
		t1=new JTextArea();
		t1.setColumns(20);
		t4.setColumns(40);
        b=new JButton("Select A File");
        t1.setRows(4);
        t3.setRows(8);
        
        b.addActionListener(new ActionListener()
        		{
					public void actionPerformed(ActionEvent e) {
				         try{
						 f.showOpenDialog(null);
				         path =f.getSelectedFile().getAbsolutePath();
				         FileInputStream file=new FileInputStream(path);
				         int c=file.read();
				         while(c>=0){
				        	 s.append((char)c);
				        	 c=file.read();
				         }
				         
				         t2.setText(String.format("%s", s));
					     t1.setText(path);
					    
				         } catch(Exception e3){JOptionPane.showMessageDialog(null,"File Was not selected / File I/O Error/ Key Was Not Entered ");}
				         
					}
        		});
         
        button1.addActionListener(new ActionListener()
        		{
					public void actionPerformed(ActionEvent e) {
						try{
						String s1= new gui().process(t4.getText(), String.format("%s", s), '+');
					 
					     FileOutputStream file2;
						try {
							file2 = new FileOutputStream(path);
						 
					     
					       
					     for(int i=0;i<s1.length();i++)
					     {
					    	 file2.write((int)s1.charAt(i));
					     }
					     
					     file2.close();
						}catch(Exception e5) {JOptionPane.showMessageDialog(null,"File I/O Error");}  
					    
						
					    t3.setText(String.format("%s", s1));
						}catch(Exception e2 ) { JOptionPane.showMessageDialog(null, "Failed");}
					}
					
        		});
        
        
        button2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				try{
				String s1= new gui().process(t4.getText(), String.format("%s", s), '-');
				
			     
			     FileOutputStream file2;
				try {
					file2 = new FileOutputStream(path);
			   
			     for(int i=0;i<s1.length();i++)
			     {
			    	 file2.write((int)s1.charAt(i));
			     }
			     
			     file2.close();
				}catch(Exception e5) {JOptionPane.showMessageDialog(null,"File I/O Error");}  
		
				t3.setText(String.format("%s", s1));
				}catch(Exception e2 ) { JOptionPane.showMessageDialog(null, "Failed");}
			}
	
		});
      
       this.p4.add(button1) ;
       this.p4.add(button2) ;
        
        this.p1.add(new JLabel("Key:"));
        this.p1.add(t4);
        this.p1.add(b);
        this.p1.add(t1);
		
		this.p2.add(new JLabel("File Preview Before Action Performed:"),BorderLayout.NORTH);
		this.p2.add(t2,BorderLayout.CENTER);
		this.p2.add(p4,BorderLayout.SOUTH);
		
		this.p3.add(new JLabel("File Preview After Action Performed:"),BorderLayout.NORTH);
		this.p3.add(t3,BorderLayout.CENTER);
		
		this.panel_container.add(p1,BorderLayout.NORTH);
		this.panel_container.add(p2,BorderLayout.CENTER);
		this.panel_container.add(p3,BorderLayout.SOUTH);
	}
	
	public JPanel getPanel() {return this.panel_container;}
}
