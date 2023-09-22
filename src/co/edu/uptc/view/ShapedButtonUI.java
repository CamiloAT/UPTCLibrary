package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;


public class ShapedButtonUI extends BasicButtonUI{
	private Color color;
	public ShapedButtonUI(Color color) {
		this.color= color ;
	}
	@Override
	public void paint(Graphics g, JComponent c) {
		Graphics2D g2d = (Graphics2D) g;
		// defininimos la forma del bot�n
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		Shape buttonShape = null;
		buttonShape = new RoundRectangle2D.Double(0, 0, c.getWidth(), c.getHeight(), 40, 40);
		
		// establecemos el color para el fondo del boton
		g2d.setPaint(color);
		g2d.fill(buttonShape);
		super.paint(g2d, c);
		JButton circleButton = new JButton("Circular");
		circleButton.setBorderPainted(false);
		// Establecemos un UI espec�fico
		
		// A�adimos nuestros componentes

	}
}
