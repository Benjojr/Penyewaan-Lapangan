    package GUI;


    import ClassDAO.DAOLapangan;
import MainClass.Alamat;
    import MainClass.Lapangan;
import MainClass.LokasiLapangan;
    import MainClass.Pengguna;

    import java.util.List;
    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.Box;
    import javax.swing.BoxLayout;
    import javax.swing.JButton;
    import javax.swing.UIManager;
    import com.formdev.flatlaf.FlatLightLaf;
import java.util.ArrayList;
import java.util.Comparator;

    public class pilihLapangan extends javax.swing.JFrame {
        String idOlahRaga;
        private ContainerPilihOlahraga parent;
        private Pengguna pengguna;
        private Alamat alamat;
        private DAOLapangan dao = new DAOLapangan();

        public pilihLapangan(String idOlahRaga, ContainerPilihOlahraga parent, Pengguna pengguna) {
            this.pengguna = pengguna;
            this.alamat = pengguna.getAlamat();
            initComponents();
            this.idOlahRaga = idOlahRaga;
            this.parent = parent;
            setLocationRelativeTo(null);
            jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS)); // Supaya tombol tersusun vertikal
            List<Lapangan> lapanganList = dao.getLapanganByOlahraga(idOlahRaga);
            for (Lapangan lap : lapanganList) {
                String info = """
                    <html>
                        <center>
                            Lapangan: %s<br>
                            Harga: %s / Jam<br>
                            Lokasi: %s
                        </center>
                    </html>
                    """.formatted(
                        lap.getNama_lapangan(),
                        lap.getHarga(),
                        lap.getLokasi()
                    );

                JButton button = new JButton(info);
                button.setPreferredSize(new Dimension(300, 80));
                button.setMaximumSize(new Dimension(508, 80));
                button.setBackground(Color.WHITE);

                // Tambahkan aksi saat tombol diklik
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        DashboardLapangan dbl = new DashboardLapangan(lap, pilihLapangan.this, pilihLapangan.this.pengguna);
                        dbl.setVisible(true);
                        pilihLapangan.this.setVisible(false);
                    }
                });

                jPanel1.add(button);
                jPanel1.add(Box.createVerticalStrut(10)); // Spacer antar tombol
            }

            jPanel1.revalidate();
            jPanel1.repaint();
            
        }

        /**
         * Creates new form pilihLapangan
         */
        public pilihLapangan() {
            initComponents();

        }
        
        public void LoadLapangan(String Filter) {
            jPanel1.removeAll();
            List<Lapangan> lapanganList = filterLapangan(dao.getLapanganByOlahraga(idOlahRaga), Filter);
            for (Lapangan lap : lapanganList) {
                String info = """
                    <html>
                        <center>
                            Lapangan: %s<br>
                            Harga: %s / Jam<br>
                            Lokasi: %s
                        </center>
                    </html>
                    """.formatted(
                        lap.getNama_lapangan(),
                        lap.getHarga(),
                        lap.getLokasi()
                    );

                JButton button = new JButton(info);
                button.setPreferredSize(new Dimension(300, 80));
                button.setMaximumSize(new Dimension(508, 80));
                button.setBackground(Color.WHITE);

                // Tambahkan aksi saat tombol diklik
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        DashboardLapangan dbl = new DashboardLapangan(lap, pilihLapangan.this, pilihLapangan.this.pengguna);
                        dbl.setVisible(true);
                        pilihLapangan.this.setVisible(false);
                    }
                });

                jPanel1.add(button);
                jPanel1.add(Box.createVerticalStrut(10)); // Spacer antar tombol
            }

            jPanel1.revalidate();
            jPanel1.repaint();
        }
        
        public List<Lapangan> filterLapangan(List<Lapangan> laps, String Filter) {
            List<Lapangan> temp = new ArrayList<Lapangan>();
            List<Integer> scores = new ArrayList<Integer>();
            if(Filter.equals(null)) {
                Filter = "";
            }
            if(Filter.equals("Lokasi Terdekat")) {
                for(Lapangan elem : laps) {
                    int tempScore = 0;
                    LokasiLapangan lokasi = elem.getLokasi();
                    if(lokasi.getProvinsi().equals(alamat.getProvinsi())) {
                        tempScore++;
                        if(lokasi.getKota().equals(alamat.getKota())) {
                            tempScore++;
                            if(lokasi.getKecamatan().equals(alamat.getKecamatan())) {
                                tempScore++;
                                if(lokasi.getKelurahan().equals(alamat.getKelurahan())) {
                                    tempScore++;
                                    if(lokasi.getJalan().equals(alamat.getJalan())) {
                                        tempScore++;
                                        if(lokasi.getRt_rw().equals(alamat.getRt_rw())) {
                                            tempScore++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    scores.add(tempScore);
                }
                for(int i=6 ;i>=0; i--) {
                    for (int j=0 ;j<scores.size(); j++) {
                        if(scores.get(j)==i){
                            temp.add(laps.get(j));
                        }
                    }
                }
                return temp;
            } else{
                laps.sort(Comparator.comparingDouble(Lapangan::getHarga));
                return laps;
            }
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(jPanel1);

        jLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pilih Lapangan");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Urutkan Berdasarkan:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Harga", "Lokasi Terdekat" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
            parent.setVisible(true);
            this.setVisible(false);
        }//GEN-LAST:event_btnBackActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        LoadLapangan(jComboBox1.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox1ActionPerformed

        /**
         * @param args the command line arguments
         */

        public static void main(String[] args) {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
                FlatLightLaf.setup();
                UIManager.put("Button.arc", 20);
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }

            new pilihLapangan().setVisible(true);
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    }
