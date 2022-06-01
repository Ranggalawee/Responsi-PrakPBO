package ResponsiPrakPBO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TransView extends JFrame {
    Connector connector = new Connector();

    JLabel lId = new JLabel("Id Transaksi");
    JLabel lNama = new JLabel("Nama Barang");
    JLabel lKasir = new JLabel("Nama Kasir");
    JLabel lQty = new JLabel("Jumlah Barang");
    JLabel lPpqty = new JLabel("Harga per Barang");
    JLabel lDisc = new JLabel("Diskon");

    public JTextField tfId = new JTextField();
    public JTextField tfNama = new JTextField();
    public JTextField tfKasir = new JTextField();
    public JTextField tfQty = new JTextField();
    public JTextField tfPpqty = new JTextField();
    public JTextField tfDisc = new JTextField();

    public JButton btnCreate = new JButton("Create");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnClear = new JButton("Clear");

    public JTable table;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Id", "Nama Barang", "Kasir", "Jumlah", "Harga per", "Diskon", "Total"};

    public TransView() {
        dtm = new DefaultTableModel(namaKolom, 0);
        table = new JTable(dtm);
        scrollPane = new JScrollPane(table);

        setTitle("Data Transaksi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700, 500);

        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);

        add(lId);
        lId.setBounds(510, 20, 90, 20);
        add(tfId);
        tfId.setBounds(510, 40, 120, 20);

        add(lNama);
        lNama.setBounds(510, 60, 90, 20);
        add(tfNama);
        tfNama.setBounds(510, 80, 120, 20);

        add(lKasir);
        lKasir.setBounds(510, 100, 90, 20);
        add(tfKasir);
        tfKasir.setBounds(510, 120, 120, 20);

        add(lQty);
        lQty.setBounds(510, 140, 90, 20);
        add(tfQty);
        tfQty.setBounds(510, 160, 120, 20);

        add(lPpqty);
        lPpqty.setBounds(510, 180, 90, 20);
        add(tfPpqty);
        tfPpqty.setBounds(510, 200, 120, 20);

        add(lDisc);
        lDisc.setBounds(510, 220, 90, 20);
        add(tfDisc);
        tfDisc.setBounds(510, 240, 120, 20);

        add(btnCreate);
        btnCreate.setBounds(510, 300, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(510, 330, 90, 20);

        add(btnDelete);
        btnDelete.setBounds(510, 360, 90, 20);

        add(btnClear);
        btnClear.setBounds(510, 390, 90, 20);
    }

    public String getId() {
        return tfId.getText();
    }

    public String getNama() {
        return tfNama.getText();
    }

    public String getKasir() {
        return tfKasir.getText();
    }

    public String getQty() {
        return tfQty.getText();
    }

    public String getPpqty() {
        return tfPpqty.getText();
    }

    public String getDisc() {
        return tfDisc.getText();
    }
}