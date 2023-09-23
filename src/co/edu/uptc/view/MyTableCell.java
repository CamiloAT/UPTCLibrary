package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class MyTableCell extends DefaultTableCellRenderer{

	private String type;
	
	public MyTableCell(String type) {
		this.type = type;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		if(type.equals("normal")) {
			this.setBorder(new MatteBorder(2, 2, 2, 2, new Color(1, 152, 205, 255)));
			this.setHorizontalAlignment( JLabel.CENTER );
			this.setText((String) value );
			this.setBackground(Color.WHITE); 
			this.setFont(new Font("Times New Roman", Font.PLAIN, 20));   
			this.setForeground(Color.BLACK);
		}
		if(type.equals("header")) {
			this.setHorizontalAlignment( JLabel.CENTER );
			this.setText((String) value );
			this.setBackground(new Color(205, 228, 238));
			this.setBorder(new MatteBorder(2, 2, 2, 2, new Color(1, 152, 205, 255)));
			this.setFont(new Font("Forte", Font.ITALIC, 23));   
			this.setForeground(new Color(1, 152, 205, 255));
		}
		return this;
	}

}
