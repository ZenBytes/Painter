package Paint;

import java.awt.*;
import java.awt.event.MouseEvent;

import hsa_ufa.*;

public class Paint {

	public static Console g = new Console(600, 480, "ConsolePaint");
	public final static int BLACK = 0, RED = 1, GREEN = 2, BLUE = 3, CYAN = 4,
			MAGENTA = 5, YELLOW = 6;
	public static int currColor = BLACK;
	public static int radius = 2;

	public static void main(String[] args) {

		g.enableMouse();
		g.enableMouseMotion();

		colorButtons(); // draws the buttons

		while (1 == 1) {

			if (g.isKeyDown(32) && g.getMouseX() > (g.getWidth() - 80)) {
				changeColor(g.getMouseY());
			}

			if (g.isKeyDown(32)) {
				drawLine();
			}

			if (g.isKeyDown(32) && g.getMouseX() > (520)
					&& g.getMouseY() > (420)) {
				clear();
			}

			for (int i = 1; i <= 9; i++)
				if (g.isKeyDown(i + 48))
					radius = i * 2;
		}

	}

	public static void colorButtons() {

		int width = g.getWidth();
		int height = g.getHeight() - 32;

		int colorSpacing = height / 8;

		g.setColor(Color.GRAY);
		g.fillRect(0, height, width, 4);
		g.fillRect(0, 0, width, 4);
		g.fillRect(0, 0, 4, width);
		g.fillRect(width - 84, 0, 84, height);

		g.setColor(Color.BLACK);
		g.fillRect(width - 80, 3 + 0 * colorSpacing, 80, colorSpacing - 3);
		g.setColor(Color.RED);
		g.fillRect(width - 80, 3 + 1 * colorSpacing, 80, colorSpacing - 3);
		g.setColor(Color.GREEN);
		g.fillRect(width - 80, 3 + 2 * colorSpacing, 80, colorSpacing - 3);
		g.setColor(Color.BLUE);
		g.fillRect(width - 80, 3 + 3 * colorSpacing, 80, colorSpacing - 3);
		g.setColor(Color.CYAN);
		g.fillRect(width - 80, 3 + 4 * colorSpacing, 80, colorSpacing - 3);
		g.setColor(Color.MAGENTA);
		g.fillRect(width - 80, 3 + 5 * colorSpacing, 80, colorSpacing - 3);
		g.setColor(Color.YELLOW);
		g.fillRect(width - 80, 3 + 6 * colorSpacing, 80, colorSpacing - 3);
		g.setColor(Color.WHITE);
		g.drawRect(width - 80, 1 + currColor * colorSpacing, 80, colorSpacing);
		g.drawRect(width - 79, 2 + currColor * colorSpacing, 78, colorSpacing);
		g.fillRect(width - 80, 3 + 7 * colorSpacing, 80, colorSpacing + 1);
		g.setColor(Color.BLACK);
		g.drawRect(width - 80, 3 + 7 * colorSpacing, 73, colorSpacing + 1);
		g.drawString("CLEAR", width - 65, height - 25);

	}

	public static void changeColor(int y) {

		int width = g.getWidth();
		int height = g.getHeight() - 32;
		int colorSpacing = height / 8;
		int newColor = y / colorSpacing;

		if (newColor < 0 || newColor > 6 || newColor == currColor)
			return;

		g.setColor(Color.GRAY);
		g.drawRect(width - 80, 1 + currColor * colorSpacing, 80, colorSpacing);
		g.drawRect(width - 79, 2 + currColor * colorSpacing, 78, colorSpacing);
		currColor = newColor;
		g.setColor(Color.WHITE);
		g.drawRect(width - 80, 1 + currColor * colorSpacing, 80, colorSpacing);
		g.drawRect(width - 79, 2 + currColor * colorSpacing, 78, colorSpacing);

	}

	public static void drawLine() {

		switch (currColor) {

		case 0:
			g.setColor(Color.BLACK);
			break;
		case 1:
			g.setColor(Color.RED);
			break;
		case 2:
			g.setColor(Color.GREEN);
			break;
		case 3:
			g.setColor(Color.BLUE);
			break;
		case 4:
			g.setColor(Color.CYAN);
			break;
		case 5:
			g.setColor(Color.MAGENTA);
			break;
		case 6:
			g.setColor(Color.YELLOW);
			break;

		}

		while (g.isKeyDown(32) && g.getMouseX() < (g.getWidth() - 91)
				&& g.getMouseX() > 4 && g.getMouseY() < g.getHeight() - 38
				&& g.getMouseY() > 3) {

			g.fillOval(g.getMouseX(), g.getMouseY(), radius, radius);

		}

	}

	public static void clear() {

		g.setColor(Color.WHITE);
		g.fillRect(4, 4, g.getWidth() - 88, g.getHeight() - 36);

	}

}