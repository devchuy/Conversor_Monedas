package test;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import control.Conversion;
import control.Monedas;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class currency {
	private JFrame frame;
	private JComboBox<Monedas> cmb;
	private JButton btn;
	private JLabel lbl;
	private JTextField txt;
	private Conversion conversion;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					currency window = new currency();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public currency() {
		initialize();
		conversion = new Conversion(cmb, btn, lbl, txt);
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txt = new JTextField();
		txt.setBounds(159, 38, 86, 20);
		frame.getContentPane().add(txt);
		txt.setColumns(10);

		cmb = new JComboBox<Monedas>();
		cmb.setModel(new DefaultComboBoxModel<>(Monedas.values()));
		cmb.setBounds(159, 70, 118, 22);
		frame.getContentPane().add(cmb);

		btn = new JButton("CURRENCY");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				conversion.Convertir();
			}
		});
		btn.setBounds(159, 180, 106, 23);
		frame.getContentPane().add(btn);

		lbl = new JLabel("00.00");
		lbl.setBounds(159, 214, 100, 14);
		frame.getContentPane().add(lbl);
	}
}
