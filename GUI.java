import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.text.*;
class GUI implements ListSelectionListener,ActionListener
{
	static String f="Serif";
	static int fs=Font.PLAIN,sz=15;
	JFrame jf1;
	JLabel jl1,jl2,jl3;
	JList list1,list2,list3;
	JTextField jtf1,jtf2,jtf3;
	JButton jb1,jb2;
	Font font1; 
	String fonts[] =GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	String entry[]={"PLAIN","BOLD","ITALIC","BOLD ITALIC"};
	String size[]=new String[100];
	Notepad notepad;
	
	GUI(Notepad np)
	{
		notepad=np;
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch(Exception e)	
		{
			System.out.println("Error setting native LAF: " + e);
		}
		
		for(int i=1;i<=100;i++)
		{
			size[i-1]=Integer.toString(i);
		}
		Font defFont=new Font("Serif",Font.PLAIN,15);

		jf1=new JFrame("Font");
		jtf1=new JTextField("Choose Font");
		jl1=new JLabel("Font:");
		list1=new JList(fonts);
		list1.setVisibleRowCount(5);
		JScrollPane list1pane=new JScrollPane(list1);
		jl1.setBounds(10,10,30,20);
		jtf1.setBounds(10,30,100,20);
		list1pane.setBounds(10,55,100,100);
		jf1.add(list1pane);
		jf1.add(jl1);
		jf1.add(jtf1);
		list1.addListSelectionListener(this);
		list1.setFont(defFont);
		
		jtf2=new JTextField("Choose Font Style");
		jl2=new JLabel("Font Style:");
		list2=new JList(entry);
		list2.setVisibleRowCount(5);
		JScrollPane list2pane=new JScrollPane(list2);
		jl2.setBounds(130,10,80,20);
		jtf2.setBounds(130,30,100,20);
		list2pane.setBounds(130,55,100,70);
		jf1.add(list2pane);
		jf1.add(jl2);
		jf1.add(jtf2);
		list2.addListSelectionListener(this);
		list2.setFont(defFont);
		
		jtf3=new JTextField("Choose Font Size");
		jl3=new JLabel("Font Size:");
		list3=new JList(size);
		JScrollPane list3pane=new JScrollPane(list3);
		jl3.setBounds(250,10,80,20);
		jtf3.setBounds(250,30,100,20);
		list3pane.setBounds(250,55,100,70);
		jf1.add(list3pane);
		jf1.add(jl3);
		jf1.add(jtf3);
		list3.addListSelectionListener(this);
		list3.setFont(defFont);
		
		jb1=new JButton("Ok");
		jb1.setBounds(150,130,50,30);
		jf1.add(jb1);
		jb1.addActionListener(this);
		
		jb2=new JButton("Cancel");
		jb2.setBounds(255,130,65,30);
		jf1.add(jb2);
		jb2.addActionListener(this);
		
		jf1.setLayout(null);
		jf1.setSize(550,550);
		jf1.setVisible(true);
	}
	public void valueChanged(ListSelectionEvent e)
	{
		if (e.getSource()==list1)
		{
			int idx=list1.getSelectedIndex();
			Font temp=new Font(fonts[idx],Font.PLAIN,15);
			jtf1.setFont(temp);
			f=fonts[idx];
		}
		if(e.getSource()==list2)
		{
			Font temp1;
			int idx=list2.getSelectedIndex();
			if(idx==0)
			{
				fs=Font.PLAIN;
				temp1=new Font("Serif",Font.PLAIN,15);
			}
			else if(idx==1)
			{
				fs=Font.BOLD;
				temp1=new Font("Serif",Font.BOLD,15);
			}
			else if(idx==2)
			{
				fs=Font.ITALIC;
				temp1=new Font("Serif",Font.ITALIC,15);
			}
			else
			{
				fs=Font.BOLD|Font.ITALIC;														//if not 0,1,2 then definitely 3 therefore bold+italic
				temp1=new Font("Serif",Font.BOLD|Font.ITALIC,15);
			}
			jtf2.setFont(temp1);
			
		}
		if(e.getSource()==list3)
		{
			sz=list3.getSelectedIndex() + 1;
		}
	}
		
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jb1)
		{
			font1=new Font(f,fs,sz);
			/*if(!notepad.jt.getSelectedText().equals(""))
			{
				Document doc=notepad.jt.getDocument();
				StyleContext sc=new StyleContext();
				Style style=sc.addStyle("myStyle",null);
				StyleConstants.setFontFamily(style,font1.getFamily());
				if(fs==Font.BOLD)
					StyleConstants.setBold(style,true);
				if(fs==FONT.ITALIC)
					StyleConstants.setItalic(style,true);
				if(fs==Font.BOLD|Font.ITALIC)
				{
					StyleConstants.setBold(style,true);
					StyleConstants.setItalic(style,true);
				}
			}
			else
			{*/
				notepad.jt.setFont(font1);
				jf1.setVisible(false);
			//}
		}
		if(ae.getSource()==jb2)
		{
			jf1.setVisible(false);
		}
	}
	/*public static void main(String args[])
	{
		new GUI();
	}*/
}
				