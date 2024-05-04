package ThuatToanBaoMatRSA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;

public class GD_LamViec extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textThongDiepCanMa;
	private JTextField textNhapKhoaMa;
	private JTextField textVanBanDaMa;

	private JTextField textKhoaCongKhai;
	private JTextField textKhoaBiMat;
	RSA_Dao p1=new RSA_Dao();
	RSA_Dao p2=new RSA_Dao();
	Font font = new Font("Arial", Font.BOLD, 16); // khung tittle
	Font font2 = new Font("Arial", Font.BOLD, 18); // thuộc tính
	Font font3 = new Font("Arial", Font.PLAIN, 18); // jtexfield
	private JTextField textVanBanCanGiai;
	private JTextField textKhoaGiaiMa;
	private JTextField textField;
	private JTextField textVanBanDaGiai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GD_LamViec frame = new GD_LamViec();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public GD_LamViec() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		p1.khoiTao();
		p2.khoiTao();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(new Color(255, 255, 255));
		pnSouth.setBounds(28, 29, 735, 108);
		pnSouth.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Tạo khóa", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16),
				Color.blue));
		TitledBorder titlethongtin = (TitledBorder) pnSouth.getBorder();
		titlethongtin.setTitleColor(Color.blue);
		titlethongtin.setTitleFont(font);
		pnSouth.setLayout(null);
		getContentPane().add(pnSouth);
		
		textKhoaCongKhai = new JTextField();
		textKhoaCongKhai.setBounds(107, 24, 595, 19);
		pnSouth.add(textKhoaCongKhai);
		textKhoaCongKhai.setColumns(10);
		
		JLabel lblKhaCngKhai = new JLabel("Khóa công khai:");
		lblKhaCngKhai.setFont(new Font("Arial", Font.PLAIN, 12));
		lblKhaCngKhai.setBounds(10, 26, 130, 19);
		pnSouth.add(lblKhaCngKhai);
		
		textKhoaBiMat = new JTextField();
		textKhoaBiMat.setBounds(107, 53, 595, 19);
		pnSouth.add(textKhoaBiMat);
		textKhoaBiMat.setColumns(10);
		
		JLabel lblKhaBMt = new JLabel("Khóa bí mật:");
		lblKhaBMt.setFont(new Font("Arial", Font.PLAIN, 12));
		lblKhaBMt.setBounds(20, 53, 130, 19);
		pnSouth.add(lblKhaBMt);
		
		JButton btnTaoKhoa = new JButton("Tạo khóa");
		btnTaoKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigInteger khoaCongKhai=p2.getSoN();
				BigInteger khoaBiMat=p2.getSoD();
				textKhoaCongKhai.setText(khoaCongKhai.toString());
				textKhoaBiMat.setText(khoaBiMat.toString());
			}
		});
		btnTaoKhoa.setBounds(340, 75, 103, 21);
		pnSouth.add(btnTaoKhoa);
		
		JLabel lblMHaRsa = new JLabel("MÃ HÓA RSA");
		lblMHaRsa.setFont(new Font("Arial", Font.BOLD, 15));
		lblMHaRsa.setBounds(346, 0, 129, 19);
		contentPane.add(lblMHaRsa);
		
	
		
		JPanel pnSouth_1 = new JPanel();
		pnSouth_1.setLayout(null);
		pnSouth_1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),

						"Mã hóa", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16),

						Color.blue));
		pnSouth_1.setBackground(Color.WHITE);
		pnSouth_1.setBounds(28, 147, 735, 143);
		contentPane.add(pnSouth_1);
		
		textThongDiepCanMa = new JTextField();
		textThongDiepCanMa.setBounds(146, 24, 556, 19);
		pnSouth_1.add(textThongDiepCanMa);
		textThongDiepCanMa.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("Nhập văn bản cần mã:");
		lblNewLabel.setBounds(10, 24, 129, 19);
		pnSouth_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		
		textNhapKhoaMa = new JTextField();
		textNhapKhoaMa.setBounds(146, 53, 556, 19);
		pnSouth_1.add(textNhapKhoaMa);
		textNhapKhoaMa.setColumns(10);
		
		JLabel lblNhpKha = new JLabel("Nhập khóa:");
		lblNhpKha.setBounds(69, 53, 129, 19);
		pnSouth_1.add(lblNhpKha);
		lblNhpKha.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JButton btnMaHoa = new JButton("Mã hóa");
		btnMaHoa.setBounds(342, 82, 90, 25);
		pnSouth_1.add(btnMaHoa);
		
		btnMaHoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String mess=textThongDiepCanMa.getText().toString();
				BigInteger key=new BigInteger(textNhapKhoaMa.getText());
				String ma=p1.maHoa(mess, key);
				textVanBanDaMa.setText(ma);
				
			}
		});
		
		JLabel lblVnBn = new JLabel("Văn bản đã mã hóa:");
		lblVnBn.setBounds(22, 114, 130, 19);
		pnSouth_1.add(lblVnBn);
		lblVnBn.setFont(new Font("Arial", Font.PLAIN, 12));
		
		textVanBanDaMa = new JTextField();
		textVanBanDaMa.setBounds(146, 113, 556, 19);
		pnSouth_1.add(textVanBanDaMa);
		
		textVanBanDaMa.setColumns(10);
		
		JPanel pnSouth_2 = new JPanel();
		pnSouth_2.setLayout(null);
		pnSouth_2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),

						"Giải mã", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 16),

						Color.blue));
		pnSouth_2.setBackground(Color.WHITE);
		pnSouth_2.setBounds(28, 300, 735, 133);
		contentPane.add(pnSouth_2);
		
		JLabel lblNhpVnBn = new JLabel("Nhập văn bản cần giải mã:");
		lblNhpVnBn.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNhpVnBn.setBounds(10, 23, 157, 19);
		pnSouth_2.add(lblNhpVnBn);
		
		textVanBanCanGiai = new JTextField();
		textVanBanCanGiai.setColumns(10);
		textVanBanCanGiai.setBounds(158, 23, 545, 19);
		pnSouth_2.add(textVanBanCanGiai);
		
		JLabel lblNhpKha_1 = new JLabel("Nhập khóa:");
		lblNhpKha_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNhpKha_1.setBounds(92, 52, 69, 19);
		pnSouth_2.add(lblNhpKha_1);
		
		textKhoaGiaiMa = new JTextField();
		textKhoaGiaiMa.setColumns(10);
		textKhoaGiaiMa.setBounds(158, 52, 545, 19);
		pnSouth_2.add(textKhoaGiaiMa);
		
		JButton btnGiaiMa = new JButton("Giải mã");
		btnGiaiMa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mess=textVanBanCanGiai.getText().toString();
				BigInteger key= new BigInteger(textKhoaGiaiMa.getText());
				String ma=p2.giaiMa(new BigInteger(mess), key);
				textVanBanDaGiai.setText(ma);
			}
		});
		btnGiaiMa.setBounds(342, 75, 90, 25);
		pnSouth_2.add(btnGiaiMa);
		
		JLabel lblVnBn_2 = new JLabel("Văn bản đã giải mã:");
		lblVnBn_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblVnBn_2.setBounds(43, 104, 130, 19);
		pnSouth_2.add(lblVnBn_2);
		
		textVanBanDaGiai = new JTextField();
		textVanBanDaGiai.setColumns(10);
		textVanBanDaGiai.setBounds(158, 104, 545, 19);
		pnSouth_2.add(textVanBanDaGiai);
		
		
	}
}
