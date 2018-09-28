/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button1;
    @FXML
    private Label judul;
    @FXML
    private Label nama;
    @FXML
    private TextField inputnama;
    @FXML
    private Label nomor;
    @FXML
    private TextField inputnomor;
    @FXML
    private Label jumlah;
    @FXML
    private TextField inputjumlah;
    @FXML
    private Label pilih;
    @FXML
    private RadioButton rdR;
    @FXML
    private RadioButton rdB;
    @FXML
    private RadioButton rdP;
    @FXML
    private RadioButton rdA;
    @FXML
    private Label bayar;
    @FXML
    private TextField inputbayar;
    @FXML
    private Label rp;
    @FXML
    private Button button2;
    @FXML
    private TextArea hasil;

    @FXML
    private void selesai(ActionEvent event) {
        String paket;
        int harga = 0;
        int kembali = 0;
        
        if(inputnama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan Nama");
        }else if(inputnomor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan Nomor Telepon");
        }else if(inputjumlah.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan Jumlah Barang");
        }else if (inputbayar.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan Pembayaran");
        }
        
        if(rdR.isSelected())
        paket = "Roti";
        else if (rdB.isSelected())
        paket = "Buku";
        else if (rdP.isSelected())
        paket = "Penggaris";
        else if (rdA.isSelected())
        paket = "Air Mineral";
        else
        paket = "";
        
        if(!(rdR.isSelected() || rdB.isSelected() || rdP.isSelected() || rdA.isSelected() )){
            JOptionPane.showMessageDialog(null, "Harap pilih paket layanan");
        }else{
        String nama = inputnama.getText();
        String nomor = inputnomor.getText();
        String jumlah = inputjumlah.getText() + " kg";
        String bayar = inputbayar.getText();
        
        int hitung = Integer.parseInt(inputjumlah.getText());
        
        if (rdR.isSelected())
        harga = hitung*3000;
        if (rdB.isSelected())
        harga = hitung*2500;
        if (rdP.isSelected())
        harga = hitung*2000;
        if (rdA.isSelected())
        harga = hitung*3000;
        
        int hitung1 = Integer.parseInt(inputbayar.getText());
        
        if (rdR.isSelected())
        kembali = hitung1-harga;
        if (rdB.isSelected())
        kembali = hitung1-harga;
        if (rdP.isSelected())
        kembali = hitung1-harga;
        if (rdA.isSelected())
        kembali = hitung1-harga;
        
        hasil.setText("Nama : " +nama+"\n"+"Nomor Telepon : "+nomor+"\n"+"Pilihan Paket : " +paket+"\n"+"Pembayaran yang harus dibayar : Rp. " +harga+"\n"+"Kembali : Rp."+kembali);
        }
    }
    
    @FXML
    private void hapus(ActionEvent event) {
        inputnama.setText("");
        inputnomor.setText("");
        inputjumlah.setText("");
        rdR.setSelected(false);
        rdB.setSelected(false);
        rdP.setSelected(false);
        rdA.setSelected(false);
        inputbayar.setText("");
        hasil.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
