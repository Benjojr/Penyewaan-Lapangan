package GUI;

import ClassDAO.DAOBookingDetail;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author User
 */
import ClassDAO.DAOJadwal;
import MainClass.Booking;
import MainClass.Jadwal;
import MainClass.Lapangan;
import MainClass.Pengguna;
import MainClass.Ulasan;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;


public class DashboardLapangan extends javax.swing.JFrame {

    private DAOBookingDetail daoBook = new DAOBookingDetail();
    private DAOJadwal daojadwal = new DAOJadwal();
    private ArrayList<Jadwal> jadwals = new ArrayList<>();
    private Booking pemesanan;
    private Pengguna pengguna;
    private Lapangan lapangan;
    private Ulasan ulasan; // Removed because Ulasan cannot be resolved to a type
    private pilihLapangan parent;
    private ArrayList<javax.swing.JToggleButton> jadwalButtons;
    private ArrayList<String> jadwalLabels;
    private final LocalDate toDate = LocalDate.now();

    public DashboardLapangan() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public DashboardLapangan(Lapangan lapangan, pilihLapangan parent, Pengguna pengguna) {
        initComponents();
        setLocationRelativeTo(null);
        tanggalPesan.setDate(LocalDate.now());
        this.lapangan = lapangan;
        this.parent = parent;
        this.pengguna = pengguna;

        // Set tanggal hanya hari ini dan ke depan
        DatePickerSettings settings = tanggalPesan.getSettings();
        settings.setVetoPolicy(date -> !date.isBefore(LocalDate.now()));

        setGambar();

        jadwalButtons = new ArrayList<>(Arrays.asList(
                btnJadwalTujuh, btnJadwalDelapan, btnJadwalSembilan, btnJadwalSepuluh,
                btnJadwalSebelas, btnJadwalDuabelas, btnJadwalTigabelas, btnJadwalEmpatbelas,
                btnJadwalLimabelas, btnJadwalEnambelas, btnJadwalTujuhbelas, btnJadwalDelapanbelas,
                btnJadwalSembilanbelas, btnJadwalDuapuluh, btnJadwalDuapuluhSatu, btnJadwalDuapuluhDua,
                btnJadwalDuapuluhTiga
        ));
        jadwalLabels = new ArrayList<>(Arrays.asList(
                "07:00-08:00", "08:00-09:00", "09:00-10:00", "10:00-11:00",
                "11:00-12:00", "12:00-13:00", "13:00-14:00", "14:00-15:00",
                "15:00-16:00", "16:00-17:00", "17:00-18:00", "18:00-19:00",
                "19:00-20:00", "20:00-21:00", "21:00-22:00", "22:00-23:00", "23:00-00:00"
        ));

        // Disable tombol sesuai jadwal yang sudah terisi
        disableBookedSlots(lapangan.getId_lapangan(), tanggalPesan.getDate());

        jLabel1.setText("Lapangan " + lapangan.getNama_lapangan());
        labelInformasiLapangan.setText(String.format(
                "<html><left>Lapangan: %s<br>Harga: %s/Jam<br>Lokasi: %s</left></html>",
                lapangan.getNama_lapangan(),
                lapangan.getHarga(),
                lapangan.getLokasi()
        ));

        // Tambahkan listener ke semua tombol jadwal (cukup satu loop)
        for (javax.swing.JToggleButton btn : jadwalButtons) {
            btn.addActionListener(e -> {
                updateLabelJadwal(jadwalButtons, jadwalLabels);
                prosesJadwalDipilih();
            });
        }

        tanggalPesan.addDateChangeListener(e -> {
            // Aktifkan semua tombol dulu sebelum disable ulang
            for (javax.swing.JToggleButton btn : jadwalButtons) {
                btn.setEnabled(true);
                btn.setSelected(false); // opsional: reset pilihan
            }
            if (tanggalPesan.getDate() != null) {
                disableBookedSlots(lapangan.getId_lapangan(), tanggalPesan.getDate());
            }
        });
    }

// Tambahkan method baru untuk disable slot yang sudah dibooking
    private void disableBookedSlots(String idLapangan, LocalDate tanggal) {
        ArrayList<Jadwal> jadwalList = daojadwal.getJadwalByLapangan(idLapangan, tanggal);
        for (Jadwal jadwal : jadwalList) {
            int start = jadwal.getJam_Mulai().getHour();
            int end = jadwal.getJam_Selesai().getHour();
            for (int jam = start; jam < end; jam++) {
                int idx = jam - 7;
                if (idx >= 0 && idx < jadwalButtons.size()) {
                    jadwalButtons.get(idx).setEnabled(false);
                }
            }
        }
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelGambar = new javax.swing.JLabel();
        labelInformasiLapangan = new javax.swing.JLabel();
        btnJadwalTujuh = new javax.swing.JToggleButton();
        btnJadwalDelapan = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        UlasBtn = new javax.swing.JButton();
        btnJadwalSembilan = new javax.swing.JToggleButton();
        btnJadwalSepuluh = new javax.swing.JToggleButton();
        btnJadwalSebelas = new javax.swing.JToggleButton();
        btnJadwalDuabelas = new javax.swing.JToggleButton();
        btnJadwalTigabelas = new javax.swing.JToggleButton();
        btnJadwalEmpatbelas = new javax.swing.JToggleButton();
        btnJadwalLimabelas = new javax.swing.JToggleButton();
        btnJadwalEnambelas = new javax.swing.JToggleButton();
        btnJadwalTujuhbelas = new javax.swing.JToggleButton();
        btnJadwalDelapanbelas = new javax.swing.JToggleButton();
        btnJadwalSembilanbelas = new javax.swing.JToggleButton();
        btnJadwalDuapuluh = new javax.swing.JToggleButton();
        btnJadwalDuapuluhSatu = new javax.swing.JToggleButton();
        btnJadwalDuapuluhDua = new javax.swing.JToggleButton();
        btnJadwalDuapuluhTiga = new javax.swing.JToggleButton();
        labelJadwalYangDipilih = new javax.swing.JLabel();
        tanggalPesan = new com.github.lgooddatepicker.components.DatePicker();
        jLabel2 = new javax.swing.JLabel();
        showUlasanBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lapangan xxxxxxxxxxxxxxxx");
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        labelInformasiLapangan.setText("Informasi Lapangan");
        labelInformasiLapangan.setBackground(new java.awt.Color(153, 153, 153));

        btnJadwalTujuh.setText("07:00-08:00");
        btnJadwalTujuh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalTujuhActionPerformed(evt);
            }
        });

        btnJadwalDelapan.setText("08:00-09:00");
        btnJadwalDelapan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalDelapanActionPerformed(evt);
            }
        });

        jLabel4.setText("Jadwal");
        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        UlasBtn.setText("Ulas");
        UlasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UlasBtnActionPerformed(evt);
            }
        });

        btnJadwalSembilan.setText("09:00-10:00");
        btnJadwalSembilan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalSembilanActionPerformed(evt);
            }
        });

        btnJadwalSepuluh.setText("10:00-11:00");
        btnJadwalSepuluh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalSepuluhActionPerformed(evt);
            }
        });

        btnJadwalSebelas.setText("11:00-12:00");
        btnJadwalSebelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalSebelasActionPerformed(evt);
            }
        });

        btnJadwalDuabelas.setText("12:00-13:00");
        btnJadwalDuabelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalDuabelasActionPerformed(evt);
            }
        });

        btnJadwalTigabelas.setText("13:00-14:00");
        btnJadwalTigabelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalTigabelasActionPerformed(evt);
            }
        });

        btnJadwalEmpatbelas.setText("14:00-15:00");
        btnJadwalEmpatbelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalEmpatbelasActionPerformed(evt);
            }
        });

        btnJadwalLimabelas.setText("15:00-16:00");
        btnJadwalLimabelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalLimabelasActionPerformed(evt);
            }
        });

        btnJadwalEnambelas.setText("16:00-17:00");
        btnJadwalEnambelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalEnambelasActionPerformed(evt);
            }
        });

        btnJadwalTujuhbelas.setText("17:00-18:00");
        btnJadwalTujuhbelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalTujuhbelasActionPerformed(evt);
            }
        });

        btnJadwalDelapanbelas.setText("18:00-19:00");
        btnJadwalDelapanbelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalDelapanbelasActionPerformed(evt);
            }
        });

        btnJadwalSembilanbelas.setText("19:00-20:00");
        btnJadwalSembilanbelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalSembilanbelasActionPerformed(evt);
            }
        });

        btnJadwalDuapuluh.setText("20:00-21:00");
        btnJadwalDuapuluh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalDuapuluhActionPerformed(evt);
            }
        });

        btnJadwalDuapuluhSatu.setText("21:00-22:00");
        btnJadwalDuapuluhSatu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalDuapuluhSatuActionPerformed(evt);
            }
        });

        btnJadwalDuapuluhDua.setText("22:00-23:00");
        btnJadwalDuapuluhDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalDuapuluhDuaActionPerformed(evt);
            }
        });

        btnJadwalDuapuluhTiga.setText("23:00-00:00");
        btnJadwalDuapuluhTiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalDuapuluhTigaActionPerformed(evt);
            }
        });

        labelJadwalYangDipilih.setText("Jadwal dipilih: ");

        tanggalPesan.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tanggalPesanAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel2.setText("Pilih Tanggal");

        showUlasanBtn.setText("Lihat Ulasan");
        showUlasanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUlasanBtnActionPerformed(evt);
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(labelGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelInformasiLapangan, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tanggalPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(showUlasanBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(UlasBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelJadwalYangDipilih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnJadwalTujuh)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnJadwalDelapan)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnJadwalSembilan)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnJadwalSepuluh)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnJadwalSebelas)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnJadwalDuabelas))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnJadwalSembilanbelas)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnJadwalDuapuluh)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnJadwalDuapuluhSatu)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnJadwalDuapuluhDua))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnJadwalTigabelas)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnJadwalEmpatbelas)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnJadwalLimabelas)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnJadwalEnambelas)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnJadwalTujuhbelas)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnJadwalDelapanbelas))
                                        .addComponent(btnJadwalDuapuluhTiga)))))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelInformasiLapangan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tanggalPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(UlasBtn))
                    .addComponent(labelGambar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showUlasanBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJadwalTujuh)
                    .addComponent(btnJadwalDelapan)
                    .addComponent(btnJadwalSembilan)
                    .addComponent(btnJadwalSepuluh)
                    .addComponent(btnJadwalSebelas)
                    .addComponent(btnJadwalDuabelas))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJadwalTigabelas)
                    .addComponent(btnJadwalEmpatbelas)
                    .addComponent(btnJadwalLimabelas)
                    .addComponent(btnJadwalEnambelas)
                    .addComponent(btnJadwalTujuhbelas)
                    .addComponent(btnJadwalDelapanbelas))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJadwalSembilanbelas)
                    .addComponent(btnJadwalDuapuluh)
                    .addComponent(btnJadwalDuapuluhSatu)
                    .addComponent(btnJadwalDuapuluhDua)
                    .addComponent(btnJadwalDuapuluhTiga))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnBack)
                    .addComponent(labelJadwalYangDipilih))
                .addContainerGap())
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

    private void tanggalPesanAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tanggalPesanAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalPesanAncestorAdded

    private void showUlasanBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_showUlasanBtnActionPerformed
        UlasanFrame ulsFrame = new UlasanFrame(lapangan.getId_lapangan(), lapangan.getNama_lapangan());
        ulsFrame.setVisible(true);
    }// GEN-LAST:event_showUlasanBtnActionPerformed

    private void setGambar() {
        labelGambar.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/assets/" + lapangan.getId_lapangan() + ".png"))); // NOI18N
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        parent.setVisible(true);
        this.setVisible(false);
    }// GEN-LAST:event_jButton2ActionPerformed

    private void updateLabelJadwal(ArrayList<javax.swing.JToggleButton> buttons, ArrayList<String> labels) {
        ArrayList<Integer> selected = new ArrayList<>();
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).isSelected()) {
                selected.add(i);
            }
        }
        java.util.Collections.sort(selected);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < selected.size()) {
            int start = selected.get(i);
            int end = start;
            // Gabungkan yang berurutan
            while (i + 1 < selected.size() && selected.get(i + 1) == end + 1) {
                end = selected.get(i + 1);
                i++;
            }
            if (sb.length() > 0) {
                sb.append(", ");
            }
            String startLabel = labels.get(start).substring(0, 5);
            String endLabel = labels.get(end).substring(6, 11);
            sb.append(startLabel).append("-").append(endLabel);
            i++;
        }
        if (sb.length() == 0) {
            labelJadwalYangDipilih.setText("Jadwal dipilih: ");
        } else {
            labelJadwalYangDipilih.setText("Jadwal dipilih: " + sb.toString());
        }
    }

    private boolean prosesJadwalDipilih() {
        ArrayList<Integer> selectedIndices = new ArrayList<>();
        for (int i = 0; i < jadwalButtons.size(); i++) {
            if (jadwalButtons.get(i).isSelected()) {
                selectedIndices.add(i);
            }
        }
        if (selectedIndices.isEmpty()) {
            labelJadwalYangDipilih.setText("Jadwal dipilih: ");
            return false;
        }
        Collections.sort(selectedIndices);

        LocalDate tanggal = tanggalPesan.getDate();
        if (tanggal == null) {
            tanggal = LocalDate.now();
        }

        // Opsional: pemesanan belum dibuat di sini, cukup jadwals saja
        jadwals.clear();

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < selectedIndices.size()) {
            int start = selectedIndices.get(i);
            int end = start;
            while (i + 1 < selectedIndices.size() && selectedIndices.get(i + 1) == end + 1) {
                end = selectedIndices.get(i + 1);
                i++;
            }
            String jamMulaiStr = jadwalLabels.get(start).substring(0, 5);
            String jamSelesaiStr = jadwalLabels.get(end).substring(6, 11);
            LocalTime jamMulai = LocalTime.parse(jamMulaiStr);
            LocalTime jamSelesai = LocalTime.parse(jamSelesaiStr);
            String idJadwal = generateID(this.daojadwal.getIdAllJadwal(), "J");
            // Pemesanan belum di-set di sini, cukup null/dummy
            Jadwal jadwal = new Jadwal(idJadwal, tanggal, jamMulai, jamSelesai, lapangan);
            jadwals.add(jadwal);
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(jamMulaiStr).append("-").append(jamSelesaiStr);

            i++;
        }
        labelJadwalYangDipilih.setText("Jadwal dipilih: " + sb.toString());
        return true;
    }


    private void btnJadwalTujuhActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalTujuhActionPerformed

    private void btnJadwalDelapanActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalDelapanActionPerformed

    private void btnJadwalSembilanActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalSembilanActionPerformed

    private void btnJadwalSepuluhActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalSepuluhActionPerformed

    private void btnJadwalSebelasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalSebelasActionPerformed

    private void btnJadwalDuabelasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalDuabelasActionPerformed

    private void btnJadwalTigabelasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalTigabelasActionPerformed

    private void btnJadwalEmpatbelasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalEmpatbelasActionPerformed

    private void btnJadwalLimabelasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalLimabelasActionPerformed

    private void btnJadwalEnambelasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalEnambelasActionPerformed

    private void btnJadwalTujuhbelasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalTujuhbelasActionPerformed

    private void btnJadwalDelapanbelasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalDelapanbelasActionPerformed

    private void btnJadwalSembilanbelasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalSembilanbelasActionPerformed

    private void btnJadwalDuapuluhActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalDuapuluhActionPerformed

    private void btnJadwalDuapuluhSatuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalDuapuluhSatuActionPerformed

    private void btnJadwalDuapuluhDuaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalDuapuluhDuaActionPerformed

    private void btnJadwalDuapuluhTigaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }// GEN-LAST:event_btnJadwalDuapuluhTigaActionPerformed

    private int getnumID(String elem) {
        String temp = elem.substring(1);
        return Integer.parseInt(temp);
    }

    private String generateID(ArrayList<String> AllId, String init) {
        int maxId = 0;
        for (String elem : AllId) {
            if (getnumID(elem) > maxId) {
                maxId = getnumID(elem);
            }
        }
        return String.format("%s%04d", init, (maxId + 1));
    }

    private String generateIDfromLast(String id, String init) {
        int maxId = 0;
        maxId = getnumID(id);
        return String.format("%s%04d", init, (maxId + 1));
    }

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        if (!prosesJadwalDipilih() || jadwals.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pilih jadwal dulu.");
            return;
        }
        // Generate Booking baru
        LocalDate tanggal = tanggalPesan.getDate();
        if (tanggal == null) tanggal = LocalDate.now();
        // Assuming you can pass null for Jadwal and Pembayaran at this stage
        this.pemesanan = new Booking(
            generateID(this.daoBook.getIdAllBooking(), "B"),
            null, // Jadwal will be set later
            this.pengguna,
            null // Pembayaran will be set later
        );

        // Buat ulang jadwals agar id_jadwal dan booking bisa diisi benar
        ArrayList<Jadwal> jadwalsWithBooking = new ArrayList<>();
        for (Jadwal j : jadwals) {
            String idJadwal = generateID(this.daojadwal.getIdAllJadwal(), "J");
            Jadwal newJadwal = new Jadwal(idJadwal, tanggal, j.getJam_Mulai(), j.getJam_Selesai(), lapangan);
            jadwalsWithBooking.add(newJadwal);
            // Jika Booking support multi-jadwal, tambahkan ke Booking
            this.pemesanan.setJadwal(newJadwal);
        }
        jadwals = jadwalsWithBooking; // replace jika perlu menyimpan yang baru

        // Lanjut ke proses booking/checkout
        Checkout co = new Checkout(pemesanan, this);
        co.setVisible(true);
        this.dispose(); // Pastikan variable sudah ke-set
    }// GEN-LAST:event_jButton1ActionPerformed

    private void tampilkanPesan(String judul, String pesan) {
        JOptionPane.showOptionDialog(
                null,
                pesan,
                judul,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Oke bang"},
                "Oke bang");
    }

    private void UlasBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_UlasBtnActionPerformed
        Ulas ulas = new Ulas(lapangan, pengguna);
        ulas.setVisible(true);
        this.dispose();
    }// GEN-LAST:event_UlasBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardLapangan.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardLapangan.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardLapangan.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardLapangan.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardLapangan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JToggleButton btnJadwalDelapan;
    private javax.swing.JToggleButton btnJadwalDelapanbelas;
    private javax.swing.JToggleButton btnJadwalDuabelas;
    private javax.swing.JToggleButton btnJadwalDuapuluh;
    private javax.swing.JToggleButton btnJadwalDuapuluhDua;
    private javax.swing.JToggleButton btnJadwalDuapuluhSatu;
    private javax.swing.JToggleButton btnJadwalDuapuluhTiga;
    private javax.swing.JToggleButton btnJadwalEmpatbelas;
    private javax.swing.JToggleButton btnJadwalEnambelas;
    private javax.swing.JToggleButton btnJadwalLimabelas;
    private javax.swing.JToggleButton btnJadwalSebelas;
    private javax.swing.JToggleButton btnJadwalSembilan;
    private javax.swing.JToggleButton btnJadwalSembilanbelas;
    private javax.swing.JToggleButton btnJadwalSepuluh;
    private javax.swing.JToggleButton btnJadwalTigabelas;
    private javax.swing.JToggleButton btnJadwalTujuh;
    private javax.swing.JToggleButton btnJadwalTujuhbelas;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton UlasBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelGambar;
    private javax.swing.JLabel labelInformasiLapangan;
    private javax.swing.JLabel labelJadwalYangDipilih;
    private javax.swing.JButton showUlasanBtn;
    private com.github.lgooddatepicker.components.DatePicker tanggalPesan;
    // End of variables declaration//GEN-END:variables
}
