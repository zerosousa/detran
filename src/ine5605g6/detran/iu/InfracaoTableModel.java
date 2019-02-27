package ine5605g6.detran.iu;

import ine5605g6.detran.logica.Infracao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class InfracaoTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	List<Infracao> infracoes;
	String[] nomeDasColunas;
	SimpleDateFormat sdf;
	
	public InfracaoTableModel() {
		this.infracoes = new ArrayList<Infracao>(0);
		nomeDasColunas = new String[] {"Código", "Data da infração", "Placa do veículo" };
		sdf = new SimpleDateFormat("dd/mm/yyyy");
	}
	
	public void setInfracoes(List<Infracao> infracoes) {
		this.infracoes = infracoes;
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return infracoes.size();
	}

	@Override
	public int getColumnCount() {
		return nomeDasColunas.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return nomeDasColunas[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Infracao i = infracoes.get(rowIndex);
		Object valor = "???";
		
		switch (columnIndex) {
		case 0:
			valor = i.getCodigo();
			break;
		case 1:
			valor = sdf.format(i.getDataInfracao());
			break;
		case 2:
			valor = i.getPlaca();
		}
		
		return valor;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}
