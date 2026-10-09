import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class kalkulator extends JFrame implements ActionListener {

    private JTextField display;
    private double hasil = 0;
    private String operatorTerpilih = "";
    private boolean mulaiBaru = true;

    public kalkulator() {
        setTitle("KALKULATOR SEDERHANA");
        setSize(360, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); 

        getContentPane().setBackground(Color.PINK);

        
        display = new JTextField();
        display.setBounds(20, 20, 300, 40);
        display.setEditable(false);
        display.setBackground(new Color(255, 255, 255));
        add(display);

        
        String[][] tombolLayout = {
                {"1", "2", "3", "+"},
                {"4", "5", "6", "-"},
                {"7", "8", "9", "*"},
                {"0", "C", "=", "/"}
        };

        int startX = 20;
        int startY = 80;
        int lebar = 65;
        int tinggi = 50;
        int gapX = 10;
        int gapY = 10;

        for (int baris = 0; baris < tombolLayout.length; baris++) {
            for (int kolom = 0; kolom < tombolLayout[baris].length; kolom++) {
                String teks = tombolLayout[baris][kolom];
                JButton tombol = new JButton(teks);
                int x = startX + kolom * (lebar + gapX);
                int y = startY + baris * (tinggi + gapY);
                tombol.setBounds(x, y, lebar, tinggi);
                tombol.setBackground(new Color(173, 216, 230));
                tombol.addActionListener(this);
                add(tombol);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String perintah = e.getActionCommand();

        if (perintah.matches("[0-9]")) {
            if (mulaiBaru) {
                display.setText(perintah);
                mulaiBaru = false;
            } else {
                display.setText(display.getText() + perintah);
            }
        } else if (perintah.equals("C")) {
            display.setText("");
            hasil = 0;
            operatorTerpilih = "";
            mulaiBaru = true;
        } else if (perintah.equals("+") || perintah.equals("-") ||
                   perintah.equals("*") || perintah.equals("/")) {
            hasil = Double.parseDouble(display.getText());
            operatorTerpilih = perintah;
            mulaiBaru = true;
        } else if (perintah.equals("=")) {
            double nilaiKedua = Double.parseDouble(display.getText());
            double hasilAkhir = 0;

            switch (operatorTerpilih) {
                case "+":
                    hasilAkhir = hasil + nilaiKedua;
                    break;
                case "-":
                    hasilAkhir = hasil - nilaiKedua;
                    break;
                case "*":
                    hasilAkhir = hasil * nilaiKedua;
                    break;
                case "/":
                    if (nilaiKedua != 0) {
                        hasilAkhir = hasil / nilaiKedua;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }

            display.setText(String.valueOf(hasilAkhir));
            mulaiBaru = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new kalkulator().setVisible(true);
            }
        });
    }
}