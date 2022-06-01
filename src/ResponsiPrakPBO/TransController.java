package ResponsiPrakPBO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransController {
    Connector connector;
    TransView outputView;

    public String pId, pNama, pKasir, pQty, pPpqty, pDisc;

    public TransController(Connector connector, TransView transView) {
        this.connector = connector;
        this.outputView = transView;

        if (connector.getBanyakData()!=0) {
            String dataItem[][] = connector.ItemList();
            outputView.table.setModel((new JTable(dataItem, outputView.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        outputView.btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = outputView.getId();
                String nama = outputView.getNama();
                String kasir = outputView.getKasir();
                String qty = outputView.getQty();
                String ppqty = outputView.getPpqty();
                String disc = outputView.getDisc();
                connector.insertItem(id, nama, kasir, qty, ppqty, disc);

                String dataItem[][] = connector.ItemList();
                outputView.table.setModel((new JTable(dataItem, outputView.namaKolom)).getModel());
            }
        });

        outputView.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = outputView.getId();
                String nama = outputView.getNama();
                String kasir = outputView.getKasir();
                String qty = outputView.getQty();
                String ppqty = outputView.getPpqty();
                String disc = outputView.getDisc();
                connector.updateItem(id, nama, kasir, qty, ppqty, disc);

                String dataItem[][] = connector.ItemList();
                outputView.table.setModel((new JTable(dataItem, outputView.namaKolom)).getModel());
            }
        });

        outputView.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = outputView.getId();
                connector.deleteItem(id);

                String dataItem[][] = connector.ItemList();
                outputView.table.setModel((new JTable(dataItem, outputView.namaKolom)).getModel());
            }
        });

        outputView.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                outputView.tfId.setText("");
                outputView.tfNama.setText("");
                outputView.tfKasir.setText("");
                outputView.tfQty.setText("");
                outputView.tfPpqty.setText("");
                outputView.tfDisc.setText("");
            }
        });

        outputView.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = outputView.table.getSelectedRow();

                pId = outputView.table.getValueAt(baris, 0).toString();
                pNama = outputView.table.getValueAt(baris, 1).toString();
                pKasir = outputView.table.getValueAt(baris, 2).toString();
                pQty = outputView.table.getValueAt(baris, 3).toString();
                pPpqty = outputView.table.getValueAt(baris, 4).toString();
                pDisc = outputView.table.getValueAt(baris, 5).toString();

                outputView.tfId.setText(pId);
                outputView.tfNama.setText(pNama);
                outputView.tfKasir.setText(pKasir);
                outputView.tfQty.setText(pQty);
                outputView.tfPpqty.setText(pPpqty);
                outputView.tfDisc.setText(pDisc);
            }
        });



    }

}