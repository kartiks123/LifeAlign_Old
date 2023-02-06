package classes;

import java.awt.BorderLayout; // AWT - Abstract Window Toolkit

import java.awt.event.MouseAdapter; // Mouse Adapter helps to track mouse pointers when the mouse is pointing to a 
									// specific place, pressed, deleted, a task is created from it

import java.awt.event.MouseEvent;   // The action that occured when clicking a mouse button and what action is done

// javax swing is used for providing the smallest of tasks at the minimal effort

import javax.swing.JButton; // An implementation of the push/labeled button

import javax.swing.JFrame;  // The main window where diff components like buttons, labeles, etc. are added in a GUI


public class AppFrame extends JFrame{
	
	private TitleBar title;
	private Footer footer;
	private List list;
	
	private JButton newTask;
	private JButton clear;
	private JButton time;
	
	AppFrame()
	{
		this.setSize(400,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		title = new TitleBar();
		footer = new Footer();
		list = new List();
		
		this.add(title,BorderLayout.NORTH);
		this.add(footer,BorderLayout.SOUTH);
		this.add(list,BorderLayout.CENTER);
		
		newTask = footer.getNewTask();
		clear = footer.getClear();
		time=footer.getTime();
		
		addListeners();
	}
	
	public void addListeners()
	{
		newTask.addMouseListener(new MouseAdapter()
		{
			@override
			public void mousePressed(MouseEvent e)
			{
				Task task = new Task();
				list.add(task);
				list.updateNumbers();
				
				task.getDone().addMouseListener(new MouseAdapter()
				{
					@override
					public void mousePressed(MouseEvent e)
					{
						task.changeState();
						list.updateNumbers();
						revalidate();
					}
				});
			}
			
		});
		
		clear.addMouseListener(new MouseAdapter()
		{
			@override
			public void mousePressed(MouseEvent e)
			{
				list.removeCompletedTasks();
				repaint();
			}
		});

		time.addMouseListener(new MouseAdapter()
		{
			@override
			public void mousePressed(MouseEvent e)
			{
				
			}
		});
	}	
}