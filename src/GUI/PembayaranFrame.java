package GUI;

import MainClass.*;
import ClassDAO.*;
import java.time.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;


public class PembayaranFrame extends javax.swing.JFrame {
    private String id;
    private String idPengguna;
    private Booking pesanan;
    private String Bank;
    private double potongan; 
    private int KodePembayaran = generateKodePembayaran();
    private double hargaAwal;
    private double nominal;
    private LocalDateTime waktuPembayaran = LocalDateTime.now();
    private LocalDate tanggal = LocalDate.of(waktuPembayaran.getYear(), waktuPembayaran.getMonth(), waktuPembayaran.getDayOfMonth());
    private LocalTime jam = LocalTime.now();
    private String statusPembayaran = "idle";
    private String tipePembayaran;
    private boolean status;
    private Pembayaran hasil;
    private DAOPembayaran daopbyr = new DAOPembayaran();
    private DAOBookingDetail daobook = new DAOBookingDetail();
    private DAOJadwal daojadwal = new DAOJadwal();
    private DAOLangganan langganandao = new DAOLangganan();
    
    public PembayaranFrame(Booking pesanan, String bank, double hargaTotal, String tipePembayaran) {
        this.pesanan = pesanan;
        this.idPengguna = pesanan.getPengguna().getId();
        this.hargaAwal = hargaTotal;
        this.potongan = langganandao.LoadSomeById(this.pesanan.getPengguna().getSubscription().getIdLangganan()).getPotongan()*hargaAwal;
        this.tipePembayaran = tipePembayaran;
        if(this.tipePembayaran.equals("DP")) {
            this.nominal = (hargaAwal-potongan)/2;
        } else {
            this.nominal = hargaAwal-potongan;
        }
        
        this.Bank = bank;
        this.id = generateId(daopbyr.LoadAllId());
        initComponents();
        setLocationRelativeTo(null);
        setFrame();
        setLocationRelativeTo(null);
    }
    // pemesanan.getLapangan().getHarga()*this.pemesanan.getJadwal().size()
    
    private void setFrame() {
        JudulPemesananLabel.setText("Pemesanan "+pesanan.getId_booking()+" : Lapangan "+pesanan.getLapangan().getNama_lapangan());
        HargaAwalLabel.setText(String.format("Harga awal : Rp. %.2f",hargaAwal));
        BankLabel.setText("Via : "+Bank);
        KodePembayaranLabel.setText(String.format("Kode Pembayaran : %d",KodePembayaran));
        PotonganLabel.setText(String.format("Potongan : Rp. %.2f", potongan));
        if(this.tipePembayaran.equals("DP")) {
            NominalLabel.setText(String.format("Nominal Pembayaran : Rp. %.2f (Rp. %.2f => cash)", nominal, nominal));
        } else {
            NominalLabel.setText(String.format("Nominal Pembayaran : Rp. %.2f", nominal));
        }
        JadwalListCOBO.removeAllItems();
        for(Jadwal elem : this.pesanan.getJadwal()) {
            JadwalListCOBO.addItem(elem.getJam_Mulai().toString()+"-"+elem.getJam_Selesai().toString());
        }
        UsrnmLabel.setText("Username : "+pesanan.getPengguna().getUsername()+" ("+pesanan.getPengguna().getSubscription().getJenisLangganan()+")");
        TimeLabel.setText("Waktu : "+waktuPembayaran.getDayOfMonth()+" "+waktuPembayaran.getMonth()+" "+waktuPembayaran.getYear()+" at "+waktuPembayaran.getHour()+":"+waktuPembayaran.getMinute());
        
    }
    
    private int generateKodePembayaran() {
        int randomNum = 10000+((int)(Math.random() * 90000));
        return randomNum;
    }
    
    private String generateId(ArrayList<String> ids) {
        int terbesar =0;
        for(String elem : ids){
            String id = elem.substring(3);
            if(Integer.parseInt(id)>terbesar) {
                terbesar = Integer.parseInt(id);
            }
        }
        return String.format("PMB%03d", (terbesar+1));

        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JudulPemesananLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        UsrnmLabel = new javax.swing.JLabel();
        BankLabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        NominalLabel = new javax.swing.JLabel();
        PotonganLabel = new javax.swing.JLabel();
        HargaAwalLabel = new javax.swing.JLabel();
        JadwalLabel = new javax.swing.JLabel();
        JadwalListCOBO = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        KodePembayaranLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JudulPemesananLabel.setText("Pemesanan x : Lapangan X");
        JudulPemesananLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        UsrnmLabel.setText("Username : xxxxxxxxx ( jenisLangganan )");
        UsrnmLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        BankLabel.setText("Bank : xxxxxx");
        BankLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        TimeLabel.setText("Waktu : xx : xx : xx");
        TimeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        NominalLabel.setText("Nominal Pembayaran : Rp. xxx.xxx.xxx");
        NominalLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        PotonganLabel.setText("Potongan : Rp. xxx.xxx.xxx");
        PotonganLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        HargaAwalLabel.setText("Harga awal : Rp. xxx.xxx.xxx");
        HargaAwalLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        JadwalLabel.setText("Jadwal : ");
        JadwalLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        JadwalListCOBO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JadwalListCOBO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JadwalListCOBOActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipe Pembayaran : ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(UsrnmLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                        .addComponent(BankLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(HargaAwalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                        .addComponent(PotonganLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(JadwalLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JadwalListCOBO, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(NominalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UsrnmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BankLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TimeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JadwalLabel)
                    .addComponent(JadwalListCOBO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HargaAwalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PotonganLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NominalLabel)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Langkah-langkah :");
        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel7.setText("1. Pergi ke ATM atau buka aplikasi mobile Banking anda");
        jLabel7.setAutoscrolls(true);
        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setToolTipText("");

        jLabel8.setText("3. Pergi ke ATM atau buka aplikasi mobile Banking anda");
        jLabel8.setAutoscrolls(true);
        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setToolTipText("");

        jLabel9.setText("2. Pergi ke ATM atau buka aplikasi mobile Banking anda");
        jLabel9.setAutoscrolls(true);
        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setToolTipText("");

        jLabel10.setText("4. Pergi ke ATM atau buka aplikasi mobile Banking anda");
        jLabel10.setAutoscrolls(true);
        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setToolTipText("");

        jLabel11.setText("5. Pergi ke ATM atau buka aplikasi mobile Banking anda");
        jLabel11.setAutoscrolls(true);
        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        KodePembayaranLabel.setText("Kode Pembayaran : xxxxx");
        KodePembayaranLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jButton1.setText("Bayar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(KodePembayaranLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(290, 298, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JudulPemesananLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JudulPemesananLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KodePembayaranLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TransferPengguna tf = new TransferPengguna();
        tf.setVisible(true);
        tf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Thread thread = new Thread(() -> {
            while(true){
                if(tf.isVisible()) {
                    System.out.println("Checking");
                }
                if(!tf.isVisible()){
                    statusPembayaran = cekPembayaran(tf.getKode(),tf.getNominal());
                    System.out.println("status tf : "+statusPembayaran);
                    
                }
                
                if(statusPembayaran.equals("sukses")){
                    String tempStatus = statusPembayaran;
                    statusPembayaran = "idle";
                    System.out.println("testing");
                    JOptionPane.showMessageDialog(null,
                    "Pemesanan Berhasil",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
                    status = tempStatus.equals("sukses");
                    hasil = new Pembayaran(id, tanggal, jam, Bank, nominal, status); 
                    pesanan.setPembayaran(hasil);
                    daopbyr.Regist(hasil, this.tipePembayaran);
                    daobook.RegistBooking(pesanan);
                    for(Jadwal elem : pesanan.getJadwal()) {
                        daojadwal.RegistJadwal(elem, pesanan.getId_booking());
                    }
                    Invoice invoice = new Invoice(pesanan);
                    invoice.setVisible(true);
                    this.dispose();
                    break;
                } else if(statusPembayaran.equals("kurang")) {
                    statusPembayaran = "idle";
                    JOptionPane.showMessageDialog(null,
                    "Jumlah yang kamu transfer tidak mencukupi untuk membayar tagihan.",
                    "Inane warning",
                    JOptionPane.WARNING_MESSAGE);
                    tf.resetField();
                    tf.setVisible(true);
                    
                } else if(statusPembayaran.equals("salah")){
                    statusPembayaran = "idle";
                    JOptionPane.showMessageDialog(null,
                    "Kode Pembayaran yang kamu masukkan, tidak dapat dikenali.",
                    "Inane warning",
                    JOptionPane.WARNING_MESSAGE);
                    tf.resetField();
                    tf.setVisible(true);
                }
            }
        });
        thread.start();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JadwalListCOBOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JadwalListCOBOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JadwalListCOBOActionPerformed
    
    private String cekPembayaran(String kode, String nominal) {
        int kodepembayaran = Integer.parseInt(kode);
        double Nominal = Double.parseDouble(nominal);
        
        if(kodepembayaran==this.KodePembayaran) {
            if(Nominal >= this.nominal) {
                return "sukses";
            } else {
                return "kurang";
            }
        } else {
            return "salah";
        }
    }
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BankLabel;
    private javax.swing.JLabel HargaAwalLabel;
    private javax.swing.JLabel JadwalLabel;
    private javax.swing.JComboBox<String> JadwalListCOBO;
    private javax.swing.JLabel JudulPemesananLabel;
    private javax.swing.JLabel KodePembayaranLabel;
    private javax.swing.JLabel NominalLabel;
    private javax.swing.JLabel PotonganLabel;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel UsrnmLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}