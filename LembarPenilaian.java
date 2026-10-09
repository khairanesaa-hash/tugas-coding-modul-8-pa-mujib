import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LembarPenilaian extends JFrame {

    private JTextField txtNIM, txtNama;
    private JRadioButton rbA, rbB, rbC;
    private JTextArea taInfo;
    private JComboBox<String> cbMatakuliah;
    private JButton btnCari, btnEdit, btnSimpan, btnHapus, btnKeluar;

    public LembarPenilaian() {
        setTitle("Lembar Penilaian");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // null layout, tidak menggunakan GUI builder

        getContentPane().setBackground(new Color(210, 230, 245));

    
        JLabel lblNIM = new JLabel("NIM");
        lblNIM.setBounds(30, 30, 100, 25);
        add(lblNIM);

        txtNIM = new JTextField();
        txtNIM.setBounds(150, 30, 200, 25);
        add(txtNIM);

        btnCari = new JButton("Cari");
        btnCari.setBounds(400, 30, 150, 25);
        btnCari.setBackground(new Color(220, 220, 220));
        add(btnCari);

        
        JLabel lblNama = new JLabel("Nama");
        lblNama.setBounds(30, 70, 100, 25);
        add(lblNama);

        txtNama = new JTextField();
        txtNama.setBounds(150, 70, 400, 25);
        add(txtNama);

        
        JLabel lblKelas = new JLabel("Kelas");
        lblKelas.setBounds(30, 110, 100, 25);
        add(lblKelas);

        rbA = new JRadioButton("A");
        rbA.setBounds(150, 110, 50, 25);
        rbA.setOpaque(false);
        add(rbA);

        rbB = new JRadioButton("B");
        rbB.setBounds(200, 110, 50, 25);
        rbB.setOpaque(false);
        add(rbB);

        rbC = new JRadioButton("C");
        rbC.setBounds(250, 110, 50, 25);
        rbC.setOpaque(false);
        add(rbC);

        ButtonGroup bgKelas = new ButtonGroup();
        bgKelas.add(rbA);
        bgKelas.add(rbB);
        bgKelas.add(rbC);

        
        taInfo = new JTextArea();
        taInfo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        taInfo.setBounds(320, 105, 230, 70);
        add(taInfo);

        
        JLabel lblMatakuliah = new JLabel("Matakuliah");
        lblMatakuliah.setBounds(30, 190, 100, 25);
        add(lblMatakuliah);

        cbMatakuliah = new JComboBox<>(new String[]{"kalkulus", "algoritma", "basis data", "jaringan komputer"});
        cbMatakuliah.setBounds(150, 190, 150, 25);
        add(cbMatakuliah);

        
        btnEdit = new JButton("Edit");
        btnEdit.setBounds(30, 280, 100, 30);
        add(btnEdit);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(150, 280, 100, 30);
        add(btnSimpan);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(270, 280, 100, 30);
        add(btnHapus);

        btnKeluar = new JButton("Keluar");
        btnKeluar.setBounds(450, 280, 100, 30);
        add(btnKeluar);

        
        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        
        btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = txtNIM.getText();
                taInfo.setText("Mencari data untuk NIM: " + nim);
            }
        });

        
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNIM.setText("");
                txtNama.setText("");
                taInfo.setText("");
                bgKelas.clearSelection();
            }
        });

        
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LembarPenilaian.this, "Data berhasil disimpan!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LembarPenilaian().setVisible(true);
            }
        });
    }
}