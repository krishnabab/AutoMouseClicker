package com.krishna;
import java.awt.Robot;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyRobo {

	public static void main(String[] argv) throws Exception {
		Robot bot = new Robot();
		JTextField textField = new JTextField();

		textField.addKeyListener(new MKeyListener());

		JFrame jframe = new JFrame("Time Check Robo");
		
		jframe.add(textField);

		jframe.setSize(400, 350);

		jframe.setVisible(true);
		while(true) {
			int mask = InputEvent.BUTTON1_DOWN_MASK;
		      bot.mouseMove(200, 200);
		      bot.mousePress(mask);
		      bot.mouseRelease(mask);
		      SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
		      textField.setText("Hello !!!    Time now : "+String.valueOf(sdf.format(System.currentTimeMillis())));
		      Thread.sleep(20000);
		}

	}
}

class MKeyListener extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent event) {

		char ch = event.getKeyChar();

		if (ch == 27) {
			System.out.println(event.getKeyChar());
			System.out.println("Esc pressed and Exiting now...");
			System.exit(0);

		}
		if (event.getKeyCode() == KeyEvent.VK_HOME) {

			System.out.println("Key codes: " + event.getKeyCode());

		}
	}
}