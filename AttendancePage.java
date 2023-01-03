/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sem3Project;

/**
 *
 * @author kusha
 */

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

public class AttendancePage extends javax.swing.JFrame {

    /**
     * Creates new form AttendancePage
     */
    private String myConnectionPass;
    Connection conn;
    PreparedStatement obj;
    
    
    LocalDate todaysDate = LocalDate.now();
    private int count = 0;
    
    private String course_no;
    public void initValues(String course_no, String myConnectionPass) {
        this.course_no = course_no;
        this.myConnectionPass = myConnectionPass;
    }
    
    public AttendancePage() {
        initComponents();
        
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        giveAttndStudentButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        dateFeild.setText(this.todaysDate.toString());
    }
    public void fetchData(String course_no) {
        DefaultTableModel infoTableModel = (DefaultTableModel) infoTable.getModel();
        infoTableModel.addColumn("SAPID");
        infoTableModel.addColumn("Name");
        
        DefaultTableModel attndTableModel;
        attndTableModel = new DefaultTableModel(new Object[]{"Present"}, 0) {
            @Override
            public Class getColumnClass(int columnIndex) {
                return Boolean.class;
            }
        };
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sem_3_proj?user=kushal&password=" + myConnectionPass);
            obj = conn.prepareStatement("SELECT sapid, student_name FROM students WHERE student_id IN (SELECT DISTINCT student_id FROM course_appointed WHERE cid = (SELECT DISTINCT cid FROM courses WHERE cno = " + course_no + "));");
            
            ResultSet rs = obj.executeQuery();
            
            while(rs.next()) {
               infoTableModel.addRow(new Object[] {rs.getString("sapid"), rs.getString("student_name")});
               attndTableModel.addRow(new Object[]{false});
               count++;
            }
            infoTable.setModel(infoTableModel);
            attndTable.setModel(attndTableModel);
            
        } catch(SQLException e) {
            ShowErrorPage errPage = new ShowErrorPage();
            errPage.init(e.toString());
            errPage.setVisible(true);
            errPage.setLocationRelativeTo(null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        attndTable = new javax.swing.JTable();
        giveAttndStudentButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dateFeild = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        infoTable.setBackground(new java.awt.Color(0, 0, 0));
        infoTable.setForeground(new java.awt.Color(255, 255, 255));
        infoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        infoTable.setAlignmentX(0.0F);
        jScrollPane1.setViewportView(infoTable);

        attndTable.setBackground(new java.awt.Color(0, 0, 0));
        attndTable.setForeground(new java.awt.Color(255, 255, 255));
        attndTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        attndTable.setAlignmentX(0.0F);
        jScrollPane2.setViewportView(attndTable);

        giveAttndStudentButton.setBackground(new java.awt.Color(30, 144, 255));
        giveAttndStudentButton.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        giveAttndStudentButton.setForeground(new java.awt.Color(255, 255, 255));
        giveAttndStudentButton.setText("Give Attendance");
        giveAttndStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giveAttndStudentButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(30, 144, 255));
        backButton.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 102));
        jLabel1.setFont(new java.awt.Font("Simplex_IV50", 0, 30)); // NOI18N
        jLabel1.setText("Attendance Portal");
        jLabel1.setToolTipText("");

        dateFeild.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateFeild.setForeground(new java.awt.Color(255, 255, 255));
        dateFeild.setText("jLabel2");

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(giveAttndStudentButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(backButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(dateFeild, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(155, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addGap(227, 227, 227)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(giveAttndStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(303, 303, 303))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(dateFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(giveAttndStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void giveAttndStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giveAttndStudentButtonActionPerformed
        // TODO add your handling code here:
            try {
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sem_3_proj?user=kushal&password=" + myConnectionPass);
                int i = 0;
                while(i<count) {
                    obj = conn.prepareStatement("INSERT INTO course_" + this.course_no + " VALUES(?, ?, ?)");

                    obj.setString(1, this.todaysDate.toString());
                    obj.setString(2, infoTable.getValueAt(i, 0).toString());
                    obj.setString(3, "true".equals(attndTable.getValueAt(i, 0).toString()) ? "P" : "A");

                    obj.executeUpdate();
                    ++i;
                }
                this.dispose();
            } catch(SQLException e) {
            ShowErrorPage errPage = new ShowErrorPage();
            errPage.init(e.toString());
            errPage.setVisible(true);
            errPage.setLocationRelativeTo(null);
            }
    }//GEN-LAST:event_giveAttndStudentButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AttendancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendancePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attndTable;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel dateFeild;
    private javax.swing.JButton giveAttndStudentButton;
    private javax.swing.JTable infoTable;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
