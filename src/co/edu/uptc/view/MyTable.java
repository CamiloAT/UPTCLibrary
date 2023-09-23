package co.edu.uptc.view;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class MyTable extends JTable{

	private int tableColumns;
	private MyTableModel model;

	public MyTable(String[][] data, String[] tittles, int tableColumns) {
		this.tableColumns=tableColumns;
		this.initTable(tittles, data);
	}

	private void initTable(String[] titulos, Object[][] data) {
		model=new MyTableModel(data, titulos);
		this.setModel(model);
		for (int i = 0; i < this.tableColumns; i++) {
			this.getColumnModel().getColumn(i).setCellRenderer(new MyTableCell("normal"));
		}
		this.getTableHeader().setReorderingAllowed(false);
		this.setRowHeight(25);
		JTableHeader jtableHeader = this.getTableHeader();
		jtableHeader.setDefaultRenderer(new MyTableCell("header"));
		this.setTableHeader(jtableHeader);
	}
}
