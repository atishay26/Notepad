import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

public class Notepad extends MouseAdapter implements ActionListener 
{
	JFrame jf;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem menuItem,font;
	JFileChooser jfc;
	JTextPane jt;
	JScrollPane jp,jp1;
	JPopupMenu p;
	static JTextArea ta1;
	
	Runtime r;
	
		
	String str="";
	String fname="";
	String result="";
	String result1="";
	
		
	static String absPath;
	static String fName;
	static int flag;
	public Font displayfont;
	Notepad()
	{
		r=Runtime.getRuntime();
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch(Exception e)	
		{
			System.out.println("Error setting native LAF: " + e);
		}
		jf=new JFrame("Notepad");
		jt=new JTextPane();
		jt.setPreferredSize(new Dimension(50,50));
		
		displayfont=new Font("Serif",Font.PLAIN,15);
		jt.setFont(displayfont);
		//jf.add(ta);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(jt);
		jp=new JScrollPane(jt);
		jf.add(jp);
		menubar=new JMenuBar();
		
		menu=new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menubar.add(menu);
			
			menuItem=new JMenuItem("New");
			menuItem.setMnemonic(KeyEvent.VK_N);
			KeyStroke i=KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK);
			menuItem.setAccelerator(i);
			menu.add(menuItem);
			menu.addSeparator();
			menuItem.addActionListener(this);
			
			menuItem=new JMenuItem("Open");
			menuItem.setMnemonic(KeyEvent.VK_O);
			i=KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK);
			menuItem.setAccelerator(i);
			menu.add(menuItem);
			menu.addSeparator();
			menuItem.addActionListener(this);
			
			menuItem=new JMenuItem("Save");
			menuItem.setMnemonic(KeyEvent.VK_S);
			i=KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK);
			menuItem.setAccelerator(i);
			menu.add(menuItem);
			menu.addSeparator();
			menuItem.addActionListener(this);
			
			menuItem=new JMenuItem("Save As");
			menuItem.setMnemonic(KeyEvent.VK_A);
			menu.add(menuItem);
			menu.addSeparator();
			menuItem.addActionListener(this);
			
			menuItem=new JMenuItem("Exit");
			menuItem.setMnemonic(KeyEvent.VK_X);
			menu.add(menuItem);
			menuItem.addActionListener(this);
			
		menu=new JMenu("Edit");
		menu.setMnemonic(KeyEvent.VK_E);
		menubar.add(menu);
		
			menuItem=new JMenuItem("Undo");
			menuItem.setMnemonic(KeyEvent.VK_U);
			i=KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK);
			menuItem.setAccelerator(i);
			menu.add(menuItem);
			menu.addSeparator();
			menuItem.addActionListener(this);
			
			menuItem=new JMenuItem("Cut");
			menuItem.setMnemonic(KeyEvent.VK_T);
			i=KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK);
			menuItem.setAccelerator(i);
			menu.add(menuItem);
			menu.addSeparator();
			menuItem.addActionListener(this);
		
			menuItem=new JMenuItem("Copy");
			menuItem.setMnemonic(KeyEvent.VK_C);
			i=KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK);
			menuItem.setAccelerator(i);
			menu.add(menuItem);
			menu.addSeparator();
			menuItem.addActionListener(this);
			
			menuItem=new JMenuItem("Paste");
			menuItem.setMnemonic(KeyEvent.VK_P);
			i=KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK);
			menuItem.setAccelerator(i);
			menu.add(menuItem);
			menu.addSeparator();
			menuItem.addActionListener(this);
			
			menuItem=new JMenuItem("Delete");
			menuItem.setMnemonic(KeyEvent.VK_E);
			menu.add(menuItem);
			menu.addSeparator();
			menuItem.addActionListener(this);
			
			menuItem=new JMenuItem("Find");
			menuItem.setMnemonic(KeyEvent.VK_F);
			i=KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK);
			menuItem.setAccelerator(i);
			menu.add(menuItem);
			menu.addSeparator();
			menuItem.addActionListener(this);
			
			menuItem=new JMenuItem("Replace");
			menuItem.setMnemonic(KeyEvent.VK_R);
			i=KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK);
			menuItem.setAccelerator(i);
			menu.add(menuItem);
			menu.addSeparator();
			menuItem.addActionListener(this);
			
			menuItem=new JMenuItem("Select All");
			menuItem.setMnemonic(KeyEvent.VK_A);
			i=KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK);
			menuItem.setAccelerator(i);
			menu.add(menuItem);
			menuItem.addActionListener(this);
		
		menu=new JMenu("Format");
		menu.setMnemonic(KeyEvent.VK_O);
		menubar.add(menu);
			
				font=new JMenuItem("Font...");
				menu.add(font);
				font.addActionListener(this);
				
		menu=new JMenu("Options");
		menu.setMnemonic(KeyEvent.VK_P);
			menuItem=new JMenuItem("Compile");
			menuItem.setMnemonic(KeyEvent.VK_O);
			i=KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK);
			menuItem.setAccelerator(i);
			menu.add(menuItem);
			menuItem.addActionListener(this);
			
			menuItem=new JMenuItem("Run");
			menuItem.setMnemonic(KeyEvent.VK_R);
			i=KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK);
			menuItem.setAccelerator(i);
			menu.add(menuItem);
			menuItem.addActionListener(this);
		menubar.add(menu);
			
		
		p=new JPopupMenu("pop");
			JMenuItem i1=new JMenuItem("Cut");
			JMenuItem i2=new JMenuItem("Copy");
			JMenuItem i3=new JMenuItem("Paste");
			JMenuItem i4=new JMenuItem("Delete");
			JMenuItem i5=new JMenuItem("Select All");
			
			p.add(i1);
			p.add(i2);
			p.add(i3);
			p.add(i4);
			p.add(i5);
			
			i1.addActionListener(this);
			i2.addActionListener(this);
			i3.addActionListener(this);
			i4.addActionListener(this);
			i5.addActionListener(this);
			
		
		jt.addMouseListener(this);
			
		jf.setJMenuBar(menubar);
		jf.setSize(500,500);
		jf.setVisible(true);
	}
	public void mouseClicked(MouseEvent e)
	{
		int x=e.getButton();
		if(x==MouseEvent.BUTTON3)
		p.show(e.getComponent(),e.getX(),e.getY());
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Compile"))
		{
			ta1=new JTextArea();
			ta1.setBackground(Color.red);
			JScrollPane jp=new JScrollPane(ta1);
			jf.add(ta1,BorderLayout.SOUTH);
			ta1.setEditable(false);
			
			str="";
			if(!jt.getText().equals(""))
			{
				try
				{
					fname=jf.getTitle();
					FileWriter fw=new FileWriter(fname);
					String s1=jt.getText();
					PrintWriter pw=new PrintWriter(fw);
					pw.println(s1);
					pw.flush();
					Process error=r.exec("C:\\Program Files (x86)\\Java\\jdk1.8.0_73\\bin\\javac.exe -d . "+fname);
					BufferedReader err=new BufferedReader(new InputStreamReader(error.getErrorStream()));
					while(true)
					{
						String temp=err.readLine();
						if(temp!=null)
						{
							result+=temp;
							result+="\n";
						}
						else
							break;
					}
					if(result.equals(""))
					{
						ta1.setText("Compilation Successful: "+fname);
						err.close();
					}
					else
						ta1.setText(result);
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
			else
				ta1.setText("please open a java programme");
		}
		if(e.getActionCommand().equals("Run"))
		{
			try
			{
				String title=jf.getTitle();
				int count=0;
				char ch[]=title.toCharArray();
				for (int i=0;ch[i]!='.';i++)
				count++;
				String fn=str.substring(0,count);
				Process p=r.exec("C:\\Program Files (x86)\\Java\\jdk1.8.0_73\\bin\\java.exe "+fn);
				BufferedReader output=new BufferedReader(new InputStreamReader(p.getInputStream()));
				BufferedReader error=new BufferedReader(new InputStreamReader(p.getErrorStream()));
				while(true)
				{
					String temp=output.readLine();
					if(temp!=null)
					{
						result+=temp;
						result+="\n";
					}
					else
						break;
				}
				while(true)
				{
					String temp=error.readLine();
					if(temp!=null)
					{
						result1+=temp;
						result1+="\n";
					}
					else
						break;
				}
				output.close();
				error.close();
				ta1.setText(result+"\n"+result1);
			}
			catch(Exception e2)
			{
				System.out.println(e2);
			}
			
		}
		if(e.getActionCommand().equals("New"))
		{
			jt.setText(null);
		}
		
		if(e.getActionCommand().equals("Open"))
		{
			flag=1;
			jfc=new JFileChooser();
			int x=jfc.showOpenDialog(null);
			if(x==JFileChooser.APPROVE_OPTION)
			{
				File f=jfc.getSelectedFile();
				absPath=f.getAbsolutePath();
				fName=f.getName();
				jf.setTitle(fName);
				try
				{
					FileReader fr=new FileReader(absPath);
					BufferedReader br=new BufferedReader(fr);
					String s="a";
					while(s!=null)
					{
						s=br.readLine();
						if(s!=null)
						{
							jt.setText(jt.getText()+s);
							jt.setText(jt.getText()+"\n");
						}
					}
				}catch(Exception i){System.out.println(i);}
			}
		}
		
		if(e.getActionCommand().equals("Save"))
		{
			if(flag==1)
			{
				File orgFile=new File(absPath);
				orgFile.delete();
				File tempFile=new File(absPath);
				try
				{
					boolean fileCreated=tempFile.createNewFile();
					if(fileCreated)
					{
						FileWriter fw=new FileWriter(tempFile,true);
						PrintWriter pw=new PrintWriter(fw);
						StringTokenizer st=new StringTokenizer(jt.getText(),"\n");
						while(st.hasMoreTokens())
						pw.println(st.nextToken());
						pw.close();
					}
					else
					{
						System.out.println("file not created");
					}
				}
				catch(Exception p){System.out.println(p);}
			}
			else
			{
				try
				{
					File fi=new File("New Text Document");
					FileWriter fw=new FileWriter(fi,true);
					PrintWriter pw=new PrintWriter(fw);
					StringTokenizer st=new StringTokenizer(jt.getText(),"\n");
					while(st.hasMoreTokens())
						pw.println(st.nextToken());
					pw.close();
				}
				catch(Exception g){System.out.println(g);}
			}
		}
		if(e.getActionCommand().equals("Save As"))
		{
			flag=1;
			jfc=new JFileChooser();
			int x=jfc.showSaveDialog(null);
			if(x==JFileChooser.APPROVE_OPTION)
			{
				File f=jfc.getSelectedFile();
				absPath=f.getAbsolutePath();
				fName=f.getName();
				jf.setTitle(fName);
				try
				{
					FileWriter fw=new FileWriter(new File(absPath),true);
					PrintWriter pw=new PrintWriter(fw);
					StringTokenizer st=new StringTokenizer(jt.getText(),"\n");
					while(st.hasMoreTokens())
					pw.println(st.nextToken());
					pw.close();
				}
				catch(Exception l){System.out.println(l);}
			}
		}
		if(e.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}
		
		//EDIT MENU
		
		//---------------------------------------------//	
		if(e.getActionCommand().equals("Cut"))
		{
			jt.cut();
		}
		if(e.getActionCommand().equals("Copy"))
		{
			jt.copy();
		}
		if(e.getActionCommand().equals("Paste"))
		{
			jt.paste();
		}
		if(e.getActionCommand().equals("Select All"))
		{
			jt.selectAll();
		}
		if(e.getActionCommand().equals("Delete"))
		{
			jt.setText(jt.getText().replace(jt.getSelectedText(),""));
		}
		
		//FORMAT MENU//
		//--------------------------------------//
		if(e.getActionCommand().equals("Font..."))
		{
			new GUI(this);
		}
		
		
	}
			
	
		
	public static void main(String args[])
	{
		Notepad n=new Notepad();
	}
}
