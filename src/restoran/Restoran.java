package restoran;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import restoran.exceptions.IllegalOrphanException;
import restoran.exceptions.NonexistentEntityException;

public class Restoran extends javax.swing.JFrame {

    public Restoran() {
        initComponents();
        dialog_pop.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        frame_rezervation.setSize(370, 420);
        frame_rezervation.setLocationRelativeTo(null);
        jDialog1Find.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialog_pop = new javax.swing.JDialog();
        panel_popDialog = new javax.swing.JPanel();
        lbl_check = new javax.swing.JLabel();
        lbl_uncheck = new javax.swing.JLabel();
        lbl_rezervation = new javax.swing.JLabel();
        btn_check = new javax.swing.JButton();
        btn_uncheck = new javax.swing.JButton();
        btn_rezervation = new javax.swing.JButton();
        lbl_dialogNaslov = new javax.swing.JLabel();
        frame_rezervation = new javax.swing.JFrame();
        panel_rezervationForm = new javax.swing.JPanel();
        lbl_rezervationNaslov = new javax.swing.JLabel();
        lbl_rezervationName = new javax.swing.JLabel();
        txt_rezervationName = new javax.swing.JTextField();
        lbl_rezervationTelefon = new javax.swing.JLabel();
        txt_rezervationTelefon = new javax.swing.JTextField();
        lbl_rezervationBrOsoba = new javax.swing.JLabel();
        txt_rezervationBrOsoba = new javax.swing.JTextField();
        lbl_rezervationDatum = new javax.swing.JLabel();
        lbl_rezervationSto = new javax.swing.JLabel();
        txt_rezervationSto = new javax.swing.JTextField();
        btn_rezervationInsert = new javax.swing.JButton();
        btn_rezervationEdit = new javax.swing.JButton();
        btn_rezervationDelete = new javax.swing.JButton();
        btn_rezervationFind = new javax.swing.JButton();
        jDate_txt_rezervation = new com.toedter.calendar.JDateChooser();
        jDialog1Find = new javax.swing.JDialog();
        jPanelDilaogFind = new javax.swing.JPanel();
        lbl_FindName = new javax.swing.JLabel();
        lbl_FindPhone = new javax.swing.JLabel();
        lbl_FindNumberPersons = new javax.swing.JLabel();
        lbl_FindDate = new javax.swing.JLabel();
        lbl_FindTable = new javax.swing.JLabel();
        txt_findDialogName = new javax.swing.JTextField();
        txt_findDialogPhone = new javax.swing.JTextField();
        txt_findDialogPersons = new javax.swing.JTextField();
        txt_findDialogDate = new javax.swing.JTextField();
        txt_findDialogTable = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        panel_pozadina = new javax.swing.JPanel();
        lbl_naslov = new javax.swing.JLabel();
        btn_2 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        btn_1 = new javax.swing.JButton();
        btn_10 = new javax.swing.JButton();
        btn_9 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();

        dialog_pop.setBackground(new java.awt.Color(255, 255, 153));

        panel_popDialog.setBackground(new java.awt.Color(255, 255, 153));
        panel_popDialog.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_check.setText("Check Table ");
        panel_popDialog.add(lbl_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, -1));

        lbl_uncheck.setText("UnCheck Table");
        panel_popDialog.add(lbl_uncheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 80, -1));

        lbl_rezervation.setText("Rezervation");
        panel_popDialog.add(lbl_rezervation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, -1));

        btn_check.setText("Check");
        btn_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkActionPerformed(evt);
            }
        });
        panel_popDialog.add(btn_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 90, -1));

        btn_uncheck.setText("UnCheck");
        btn_uncheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uncheckActionPerformed(evt);
            }
        });
        panel_popDialog.add(btn_uncheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 90, -1));

        btn_rezervation.setText("Rezervation");
        btn_rezervation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rezervationActionPerformed(evt);
            }
        });
        panel_popDialog.add(btn_rezervation, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        lbl_dialogNaslov.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_dialogNaslov.setText("Table");
        panel_popDialog.add(lbl_dialogNaslov, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 40, -1));

        javax.swing.GroupLayout dialog_popLayout = new javax.swing.GroupLayout(dialog_pop.getContentPane());
        dialog_pop.getContentPane().setLayout(dialog_popLayout);
        dialog_popLayout.setHorizontalGroup(
            dialog_popLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_popDialog, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
        );
        dialog_popLayout.setVerticalGroup(
            dialog_popLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_popDialog, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );

        panel_rezervationForm.setBackground(new java.awt.Color(255, 255, 153));
        panel_rezervationForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_rezervationNaslov.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_rezervationNaslov.setText("Rezervation");
        panel_rezervationForm.add(lbl_rezervationNaslov, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        lbl_rezervationName.setText("Name");
        panel_rezervationForm.add(lbl_rezervationName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        txt_rezervationName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rezervationNameActionPerformed(evt);
            }
        });
        panel_rezervationForm.add(txt_rezervationName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 150, -1));

        lbl_rezervationTelefon.setText("Telefon");
        panel_rezervationForm.add(lbl_rezervationTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));
        panel_rezervationForm.add(txt_rezervationTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 150, -1));

        lbl_rezervationBrOsoba.setText("Broj osoba");
        panel_rezervationForm.add(lbl_rezervationBrOsoba, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));
        panel_rezervationForm.add(txt_rezervationBrOsoba, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 150, -1));

        lbl_rezervationDatum.setText("Datum");
        panel_rezervationForm.add(lbl_rezervationDatum, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        lbl_rezervationSto.setText("Sto");
        panel_rezervationForm.add(lbl_rezervationSto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));
        panel_rezervationForm.add(txt_rezervationSto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 150, -1));

        btn_rezervationInsert.setText("Insert");
        btn_rezervationInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rezervationInsertActionPerformed(evt);
            }
        });
        panel_rezervationForm.add(btn_rezervationInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        btn_rezervationEdit.setText("Edit");
        panel_rezervationForm.add(btn_rezervationEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, -1));

        btn_rezervationDelete.setText("Delete");
        btn_rezervationDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rezervationDeleteActionPerformed(evt);
            }
        });
        panel_rezervationForm.add(btn_rezervationDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        btn_rezervationFind.setText("Find");
        btn_rezervationFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rezervationFindActionPerformed(evt);
            }
        });
        panel_rezervationForm.add(btn_rezervationFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));
        panel_rezervationForm.add(jDate_txt_rezervation, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 150, -1));

        javax.swing.GroupLayout frame_rezervationLayout = new javax.swing.GroupLayout(frame_rezervation.getContentPane());
        frame_rezervation.getContentPane().setLayout(frame_rezervationLayout);
        frame_rezervationLayout.setHorizontalGroup(
            frame_rezervationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_rezervationLayout.createSequentialGroup()
                .addComponent(panel_rezervationForm, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        frame_rezervationLayout.setVerticalGroup(
            frame_rezervationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_rezervationLayout.createSequentialGroup()
                .addComponent(panel_rezervationForm, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelDilaogFind.setBackground(new java.awt.Color(255, 255, 153));

        lbl_FindName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_FindName.setText("Name : ");

        lbl_FindPhone.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_FindPhone.setText("Phone : ");

        lbl_FindNumberPersons.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_FindNumberPersons.setText("Persons : ");

        lbl_FindDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_FindDate.setText("Date : ");

        lbl_FindTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_FindTable.setText("Table : ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Info ");

        javax.swing.GroupLayout jPanelDilaogFindLayout = new javax.swing.GroupLayout(jPanelDilaogFind);
        jPanelDilaogFind.setLayout(jPanelDilaogFindLayout);
        jPanelDilaogFindLayout.setHorizontalGroup(
            jPanelDilaogFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDilaogFindLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelDilaogFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_FindDate)
                    .addComponent(lbl_FindNumberPersons)
                    .addComponent(lbl_FindPhone)
                    .addComponent(lbl_FindName)
                    .addComponent(lbl_FindTable))
                .addGap(74, 74, 74)
                .addGroup(jPanelDilaogFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_findDialogName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(txt_findDialogPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_findDialogPersons, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_findDialogDate)
                    .addComponent(txt_findDialogTable, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(83, 83, 83))
            .addGroup(jPanelDilaogFindLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDilaogFindLayout.setVerticalGroup(
            jPanelDilaogFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDilaogFindLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addGap(60, 60, 60)
                .addGroup(jPanelDilaogFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_FindName)
                    .addComponent(txt_findDialogName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelDilaogFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_findDialogPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_FindPhone))
                .addGap(26, 26, 26)
                .addGroup(jPanelDilaogFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_findDialogPersons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_FindNumberPersons))
                .addGap(28, 28, 28)
                .addGroup(jPanelDilaogFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_FindDate)
                    .addComponent(txt_findDialogDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanelDilaogFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_findDialogTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_FindTable))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1FindLayout = new javax.swing.GroupLayout(jDialog1Find.getContentPane());
        jDialog1Find.getContentPane().setLayout(jDialog1FindLayout);
        jDialog1FindLayout.setHorizontalGroup(
            jDialog1FindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDilaogFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1FindLayout.setVerticalGroup(
            jDialog1FindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDilaogFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_pozadina.setBackground(new java.awt.Color(255, 255, 153));

        lbl_naslov.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_naslov.setText("Raspored Stolova");

        btn_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/meeting (3).png"))); // NOI18N
        btn_2.setText("2");
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });

        btn_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/meeting (3).png"))); // NOI18N
        btn_3.setText("3");
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });

        btn_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/meeting (3).png"))); // NOI18N
        btn_4.setText("4");
        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });

        btn_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/meeting (3).png"))); // NOI18N
        btn_5.setText("5");
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });

        btn_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/meeting (3).png"))); // NOI18N
        btn_6.setText("6");
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });

        btn_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/meeting (3).png"))); // NOI18N
        btn_7.setText("7");
        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });

        btn_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/meeting (3).png"))); // NOI18N
        btn_1.setText("1");
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });

        btn_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/meeting (3).png"))); // NOI18N
        btn_10.setText("10");
        btn_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_10ActionPerformed(evt);
            }
        });

        btn_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/meeting (3).png"))); // NOI18N
        btn_9.setText("9");
        btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_9ActionPerformed(evt);
            }
        });

        btn_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/meeting (3).png"))); // NOI18N
        btn_8.setText("8");
        btn_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_pozadinaLayout = new javax.swing.GroupLayout(panel_pozadina);
        panel_pozadina.setLayout(panel_pozadinaLayout);
        panel_pozadinaLayout.setHorizontalGroup(
            panel_pozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pozadinaLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(panel_pozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_pozadinaLayout.createSequentialGroup()
                        .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panel_pozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_pozadinaLayout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addGroup(panel_pozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_2)
                                    .addComponent(btn_7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel_pozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pozadinaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                                .addGroup(panel_pozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pozadinaLayout.createSequentialGroup()
                                        .addComponent(lbl_naslov)
                                        .addGap(220, 220, 220))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pozadinaLayout.createSequentialGroup()
                                        .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(262, 262, 262)))))
                        .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_pozadinaLayout.createSequentialGroup()
                        .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pozadinaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_10)
                .addGap(382, 382, 382))
        );

        panel_pozadinaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_1, btn_10, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9});

        panel_pozadinaLayout.setVerticalGroup(
            panel_pozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_pozadinaLayout.createSequentialGroup()
                .addGroup(panel_pozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_pozadinaLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(panel_pozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_pozadinaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panel_pozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_pozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pozadinaLayout.createSequentialGroup()
                        .addGroup(panel_pozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_pozadinaLayout.createSequentialGroup()
                        .addGroup(panel_pozadinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(116, 116, 116))))
            .addGroup(panel_pozadinaLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(lbl_naslov)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btn_10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );

        panel_pozadinaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_1, btn_10, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_pozadina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_pozadina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_9ActionPerformed
        dialog_pop.setSize(250, 250);
        dialog_pop.setVisible(true);
        buttont = btn_9.getText();
    }//GEN-LAST:event_btn_9ActionPerformed

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
        dialog_pop.setSize(250, 250);
        dialog_pop.setVisible(true);
        buttont = btn_1.getText();
    }//GEN-LAST:event_btn_1ActionPerformed

    private void btn_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkActionPerformed
        putColorRed();
    }//GEN-LAST:event_btn_checkActionPerformed


    private void btn_uncheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uncheckActionPerformed
        putColorGreen();
    }//GEN-LAST:event_btn_uncheckActionPerformed

    private void txt_rezervationNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rezervationNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rezervationNameActionPerformed

    private void btn_rezervationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rezervationActionPerformed
        dialog_pop.setVisible(false);
        frame_rezervation.setVisible(true);
        txt_rezervationSto.setText(buttont);
    }//GEN-LAST:event_btn_rezervationActionPerformed

    private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
        dialog_pop.setSize(250, 250);
        dialog_pop.setVisible(true);
        buttont = btn_2.getText();
    }//GEN-LAST:event_btn_2ActionPerformed

    private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed
        dialog_pop.setSize(250, 250);
        dialog_pop.setVisible(true);
        buttont = btn_3.getText();
    }//GEN-LAST:event_btn_3ActionPerformed

    private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed
        dialog_pop.setSize(250, 250);
        dialog_pop.setVisible(true);
        buttont = btn_4.getText();
    }//GEN-LAST:event_btn_4ActionPerformed

    private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
        dialog_pop.setSize(250, 250);
        dialog_pop.setVisible(true);
        buttont = btn_5.getText();
    }//GEN-LAST:event_btn_5ActionPerformed

    private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
        dialog_pop.setSize(250, 250);
        dialog_pop.setVisible(true);
        buttont = btn_6.getText();
    }//GEN-LAST:event_btn_6ActionPerformed

    private void btn_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_7ActionPerformed
        dialog_pop.setSize(250, 250);
        dialog_pop.setVisible(true);
        buttont = btn_7.getText();
    }//GEN-LAST:event_btn_7ActionPerformed

    private void btn_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_8ActionPerformed
        dialog_pop.setSize(250, 250);
        dialog_pop.setVisible(true);
        buttont = btn_8.getText();
    }//GEN-LAST:event_btn_8ActionPerformed

    private void btn_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_10ActionPerformed
        dialog_pop.setSize(250, 250);
        dialog_pop.setVisible(true);
        buttont = btn_10.getText();
    }//GEN-LAST:event_btn_10ActionPerformed

    private void btn_rezervationInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rezervationInsertActionPerformed
        checkInputRezervation();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestoranPU");
        RezervacijaJpaController kontroler = new RezervacijaJpaController(emf);
        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setIme(txt_rezervationName.getText());
        rezervacija.setTelefon(txt_rezervationTelefon.getText());
        rezervacija.setBrojOsoba(Integer.parseInt(txt_rezervationBrOsoba.getText()));
        Timestamp ts = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC+2")));
        // Proveravanje datuma rezervacije
       //Ovde bi trebalo da se proveri datum kako ne bi dolazilo do poklapanja rezervacija
        
        rezervacija.setDatum(ts);
        Sto sto = new Sto();
        rezervacija.setIsactiveR(true);
        sto.setIdSto(Integer.parseInt(txt_rezervationSto.getText()));
        rezervacija.setSto(sto);
        kontroler.create(rezervacija); 
        StoRezervacija storez = new StoRezervacija();
        StoRezervacijaJpaController storezK = new StoRezervacijaJpaController(emf);
        storez.setSto(sto);
        storez.setRezervacija(rezervacija);
       
        try {
            storezK.create(storez);
        } catch (Exception ex) {
            Logger.getLogger(Restoran.class.getName()).log(Level.SEVERE, null, ex);
        }
        clearRezervationFields();
         insertCheck();
         putColorRed();
    }//GEN-LAST:event_btn_rezervationInsertActionPerformed

    private void btn_rezervationDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rezervationDeleteActionPerformed
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestoranPU");
        RezervacijaJpaController kontroler = new RezervacijaJpaController(emf);
        Rezervacija rezervacija = new Rezervacija();
        if((txt_rezervationName.getText().equalsIgnoreCase(rezervacija.getIme()))
            &&(txt_rezervationTelefon.getText().equalsIgnoreCase(rezervacija.getTelefon()))){
            try {
                kontroler.destroy(rezervacija.getIdRez());
            } catch (IllegalOrphanException ex) {
                Logger.getLogger(Restoran.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(Restoran.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
            System.out.println("nesto ne valja");
    }//GEN-LAST:event_btn_rezervationDeleteActionPerformed

    private void btn_rezervationFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rezervationFindActionPerformed

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestoranPU");
        RezervacijaJpaController kontroler = new RezervacijaJpaController(emf);       
        List<Rezervacija>rezervacije = new ArrayList<>();
        rezervacije = kontroler.findRezervacijaEntities();
        for (Rezervacija r : rezervacije){
            if (r.getIme().equalsIgnoreCase(txt_rezervationName.getText())&&(r.getTelefon().equals(txt_rezervationTelefon.getText()))) {
                System.out.println("Nasli smo tu osobu " + r.getIme() + " " + r.getDatum());                 
                txt_findDialogName.setText(r.getIme());
                txt_findDialogPhone.setText(r.getTelefon());
                txt_findDialogPersons.setText(String.valueOf(r.getBrojOsoba()));
                txt_findDialogDate.setText(r.getDatum().toString());
                txt_findDialogTable.setText(String.valueOf(r.getSto()));
                jDialog1Find.setSize(470,400);
                jDialog1Find.setVisible(true);
        }
            System.out.println("NIsmo nasli tu osobu,morate uneti tacne podatke za ime i telefon!!!"); 
    }//GEN-LAST:event_btn_rezervationFindActionPerformed
     
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Restoran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Restoran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Restoran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Restoran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Restoran().setVisible(true);
            }
        });
    }

    public void insertCheck() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestoranPU");
        StoJpaController stoKontroler = new StoJpaController(emf);
        int b = Integer.parseInt(buttont);
        Sto sto = new Sto();
        sto = stoKontroler.vratiSto(b);
        sto.setIsActive(true);
        try {
            stoKontroler.edit(sto);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Restoran.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Restoran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertUnCheck() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestoranPU");
        StoJpaController stoKontroler = new StoJpaController(emf);
        int b = Integer.parseInt(buttont);
        Sto sto = new Sto();
        sto = stoKontroler.vratiSto(b);
        sto.setIsActive(false);
        try {
            stoKontroler.edit(sto);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Restoran.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Restoran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checkInputRezervation() {
        if ((txt_rezervationName.getText() == "")
                || (txt_rezervationTelefon.getText().equalsIgnoreCase(""))
                || (txt_rezervationBrOsoba.getText() == "")
                || (txt_rezervationSto.getText() == "") /* || (jDate_txt_rezervation == null)*/) {
            JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!");
        }
    }

    public void putColorRed() {
        if (buttont.equalsIgnoreCase("1")) {
            btn_1.setBackground(Color.red);
            insertCheck();
        } else if (buttont == "2") {
            btn_2.setBackground(Color.red);
            insertCheck();
        } else if (buttont == "3") {
            btn_3.setBackground(Color.red);
            insertCheck();
        } else if (buttont == "4") {
            btn_4.setBackground(Color.red);
            insertCheck();
        } else if (buttont == "5") {
            btn_5.setBackground(Color.red);
            insertCheck();
        } else if (buttont == "6") {
            btn_6.setBackground(Color.red);
            insertCheck();
        } else if (buttont == "7") {
            btn_7.setBackground(Color.red);
            insertCheck();
        } else if (buttont == "8") {
            btn_8.setBackground(Color.red);
            insertCheck();
        } else if (buttont == "9") {
            btn_9.setBackground(Color.red);
            insertCheck();
        } else if (buttont == "10") {
            btn_10.setBackground(Color.red);
            insertCheck();
        }
    }

    public void putColorGreen() {
        if (buttont.equalsIgnoreCase("1")) {
            btn_1.setBackground(Color.GREEN);
            insertUnCheck();
        } else if (buttont == "2") {
            btn_2.setBackground(Color.GREEN);
            insertUnCheck();
        } else if (buttont == "3") {
            btn_3.setBackground(Color.GREEN);
            insertUnCheck();
        } else if (buttont == "4") {
            btn_4.setBackground(Color.GREEN);
            insertUnCheck();
        } else if (buttont == "5") {
            btn_5.setBackground(Color.GREEN);
            insertUnCheck();
        } else if (buttont == "6") {
            btn_6.setBackground(Color.GREEN);
            insertUnCheck();
        } else if (buttont == "7") {
            btn_7.setBackground(Color.GREEN);
            insertUnCheck();
        } else if (buttont == "8") {
            btn_8.setBackground(Color.GREEN);
            insertUnCheck();
        } else if (buttont == "9") {
            btn_9.setBackground(Color.GREEN);
            insertUnCheck();
        } else if (buttont == "10") {
            btn_10.setBackground(Color.GREEN);
            insertUnCheck();
        }
    }
    public void clearRezervationFields(){
    txt_rezervationName.setText("");
    txt_rezervationTelefon.setText("");
    txt_rezervationBrOsoba.setText("");
    jDate_txt_rezervation.setDate(null);
    txt_rezervationSto.setText("");
    }

    String buttont;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_10;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btn_check;
    private javax.swing.JButton btn_rezervation;
    private javax.swing.JButton btn_rezervationDelete;
    private javax.swing.JButton btn_rezervationEdit;
    private javax.swing.JButton btn_rezervationFind;
    private javax.swing.JButton btn_rezervationInsert;
    private javax.swing.JButton btn_uncheck;
    private javax.swing.JDialog dialog_pop;
    private javax.swing.JFrame frame_rezervation;
    private com.toedter.calendar.JDateChooser jDate_txt_rezervation;
    private javax.swing.JDialog jDialog1Find;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanelDilaogFind;
    private javax.swing.JLabel lbl_FindDate;
    private javax.swing.JLabel lbl_FindName;
    private javax.swing.JLabel lbl_FindNumberPersons;
    private javax.swing.JLabel lbl_FindPhone;
    private javax.swing.JLabel lbl_FindTable;
    private javax.swing.JLabel lbl_check;
    private javax.swing.JLabel lbl_dialogNaslov;
    private javax.swing.JLabel lbl_naslov;
    private javax.swing.JLabel lbl_rezervation;
    private javax.swing.JLabel lbl_rezervationBrOsoba;
    private javax.swing.JLabel lbl_rezervationDatum;
    private javax.swing.JLabel lbl_rezervationName;
    private javax.swing.JLabel lbl_rezervationNaslov;
    private javax.swing.JLabel lbl_rezervationSto;
    private javax.swing.JLabel lbl_rezervationTelefon;
    private javax.swing.JLabel lbl_uncheck;
    private javax.swing.JPanel panel_popDialog;
    private javax.swing.JPanel panel_pozadina;
    private javax.swing.JPanel panel_rezervationForm;
    private javax.swing.JTextField txt_findDialogDate;
    private javax.swing.JTextField txt_findDialogName;
    private javax.swing.JTextField txt_findDialogPersons;
    private javax.swing.JTextField txt_findDialogPhone;
    private javax.swing.JTextField txt_findDialogTable;
    private javax.swing.JTextField txt_rezervationBrOsoba;
    private javax.swing.JTextField txt_rezervationName;
    private javax.swing.JTextField txt_rezervationSto;
    private javax.swing.JTextField txt_rezervationTelefon;
    // End of variables declaration//GEN-END:variables
}
