package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ScreenMenu extends JPanel{
	
	private Color yellow = Color.getHSBColor((float)0.14, 1, 1);	
	private MenuButton startNewGame = new MenuButton("New Game", yellow);
	private MenuButton loadLevel = new MenuButton("Load a level", yellow);
	private MenuButton editLevel = new MenuButton("Create new level",yellow);
	private MenuButton options = new MenuButton ("Options", yellow);
	private MenuButton quit = new MenuButton("Quit", yellow);
	private MenuBackground screenLevels;
	
	private static MenuBackground screen;
	static Window w;
	
	private ScreenMenu(){
		startNewGame.addActionListener(new StartNewGame());
		loadLevel.addActionListener(new LevelSelect());
		editLevel.addActionListener(new EditLevel());
		options.addActionListener(new Options());
		quit.addActionListener(new Quit());
		
		JPanel content = new JPanel(); 
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content,BoxLayout.PAGE_AXIS));
		content.add(startNewGame);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(loadLevel);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(editLevel);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(options);
		content.add(Box.createRigidArea(new Dimension(0,30)));
		content.add(quit);
		
		JPanel centerMenu = new JPanel();
		centerMenu.setLayout(new BoxLayout(centerMenu,BoxLayout.LINE_AXIS));
		centerMenu.add(Box.createVerticalGlue());
		centerMenu.add(content);
		centerMenu.add(Box.createVerticalGlue());
		centerMenu.setOpaque(false);
		
		screen = new MenuBackground("img/forest.jpg");
		screen.setOpaque(false);
		screen.setLayout(new BoxLayout(screen,BoxLayout.PAGE_AXIS));
		screen.add(Box.createHorizontalGlue());
		screen.add(centerMenu);
		screen.add(Box.createHorizontalGlue());
		
	}
	
	private static ScreenMenu screenMenu = new ScreenMenu();
	
	public static MenuBackground getScreenMenu(Window window){
		w = window;
		return screen;
	}
	
	class StartNewGame implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			w.setContentPane(NewGame.getNewGame());
			w.setVisible(true);
		}
	}	
	
	class LevelSelect implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			w.setContentPane(LoadLevel.getLoadLevel());
			w.setVisible(true);
		}
	}
	
	class EditLevel implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			w.setContentPane(EditMenu.getEditMenu());
			w.setVisible(true);
		}
	}
	
	class Options implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			ComingSoon tmp_screen = new ComingSoon();
		}
	}
	class Quit implements ActionListener {
		public void actionPerformed(ActionEvent arg0){
			System.exit(0);
		}
	}

}
