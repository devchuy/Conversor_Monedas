package control;

import javax.swing.JTextField;
import control.Conversion;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Conversion {
	private static final double dolar = 17.09;
	private static final double euro = 18.67;
	private static final double libra = 21.85;
	private double valorI = 0.00;

	private JComboBox<Monedas> cmb;
	private JButton btn;
	private JLabel lbl;
	private JTextField txt;

	public Conversion(JComboBox<Monedas> cmb, JButton btn, JLabel lbl, JTextField txt) {
		this.cmb = cmb;
		this.btn = btn;
		this.lbl = lbl;
		this.txt = txt;
	}

	public void Convertir() {
		if (Validar(txt.getText())) {
			Monedas moneda = (Monedas) cmb.getSelectedItem();
			switch (moneda) {
			case PESOS_DOLAR:
				PesosAMoneda(dolar);
				break;
			case PESOS_EURO:
				PesosAMoneda(euro);
				break;
			case PESOS_LIBRA:
				PesosAMoneda(libra);
				break;
			case DOLAR_PESOS:
				MonedaAPesos(dolar);
				break;
			case EURO_PESOS:
				MonedaAPesos(euro);
				break;
			case LIBRA_PESOS:
				MonedaAPesos(libra);
				break;
			default:
				break;
			}
		}
	}

	private void MonedaAPesos(double moneda) {
		double resultado = valorI * moneda;
		lbl.setText(Redondear(resultado));
	}

	private void PesosAMoneda(double moneda) {
		double resultado = valorI / moneda;
		lbl.setText(Redondear(resultado));
	}

	private String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}

	private boolean Validar(String Texto) {
		try {
			double parsear = Double.parseDouble(Texto);
			if (parsear > 0)
			valorI = parsear;
			return true;
		} catch (NumberFormatException nfe) {
			lbl.setText("Solamente numeros" + nfe);
			return false;
		}
	}
}