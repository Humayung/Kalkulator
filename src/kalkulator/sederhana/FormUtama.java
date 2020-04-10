/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator.sederhana;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cornoblue
 */
public class FormUtama extends javax.swing.JFrame {

    /**
     * Creates new form FormUtama
     */
    private ArrayList<String> ekspresi = new ArrayList<>();
    private final List<String> operator = Arrays.asList(new String[]{"×", "÷", "+", "−"});
    
    
    public FormUtama() {
        initComponents();
    }
    
    String simbol_terakhir = "";
    boolean ekspresi_terakhir_desimal = false;
    
    private void tambah_expresi(String simbol){
        // Method ini berguna untuk membuat ekspresi dari input yang dimasukkkan
        // Algoritma in bertujuan untuk menghindari kesalahan pemasukan ekspresi saat di evaluasi selanjutnya
        boolean berhasil_ditambahkan = false;
        boolean simbol_terakhir_adalah_operator = operator.contains(simbol_terakhir);
        boolean simbol_adalah_operator = operator.contains(simbol);
        boolean expresi_kosong = ekspresi.isEmpty();
        int index_terakhir_expresi = expresi_kosong ? 0 : ekspresi.size() - 1;
        String expresi_terakhir = expresi_kosong ? "" : ekspresi.get(index_terakhir_expresi);
        
        if(simbol_adalah_operator){
            if(!expresi_kosong){
                if(simbol_terakhir_adalah_operator){
                    ekspresi.set(index_terakhir_expresi, simbol);
                }else{
                    ekspresi.add(simbol);
                }
                berhasil_ditambahkan = true;
            }
        }else{
            if(!expresi_kosong){
                if(!simbol.equals(".")){
                    if(simbol_terakhir_adalah_operator){
                        ekspresi.add(simbol);
                        ekspresi_terakhir_desimal = false;
                    }else{
                        ekspresi.set(index_terakhir_expresi, expresi_terakhir + simbol);
                    }
                    berhasil_ditambahkan = true;
                }else if(!ekspresi_terakhir_desimal){
                    if(simbol_terakhir_adalah_operator){
                        ekspresi.add(simbol);
                        ekspresi_terakhir_desimal = false;
                    }else{
                        ekspresi.set(index_terakhir_expresi, expresi_terakhir + simbol);
                        ekspresi_terakhir_desimal = true;
                    }
                    berhasil_ditambahkan = true;
                }
            }else{
                if(!simbol.equals(".")){
                    ekspresi.add(simbol);
                    berhasil_ditambahkan = true;
                    ekspresi_terakhir_desimal = false;
                }
            }
            
        }
        
        if(berhasil_ditambahkan){
            simbol_terakhir = simbol;
        }
        update_expresi();
    }
    
    private void evaluasi_ekspresi(){
        // Method ini akan mengevaluasi ekspresi matematika secara naif
        // Algoritma ini tidak memeandang precedence dari operator
        // Hasil evaluasi bisa saja tidak sesuai dengan yang diingingkan
        if(ekspresi.size() > 0){
            String operan_a = ekspresi.get(0);
            String operator_ = "";
            String operan_b;
            float hasil = Float.valueOf(operan_a);

            if(!operator.contains(simbol_terakhir)){
                for(int i = 1; i < ekspresi.size(); i++){
                    String simbol = ekspresi.get(i);
                    if(operator.contains(simbol)){
                        operator_ = simbol;
                    }else{
                        operan_b = simbol;
                        hasil = hasil_dari(Float.valueOf(operan_a), Float.valueOf(operan_b), operator_);
                        operan_a = String.valueOf(hasil);
                    }

                }
                boolean punya_desimal = (((int)hasil) - hasil) != 0;
                if(punya_desimal){
                    label_hasil.setText(String.valueOf(hasil));
                }else{
                    label_hasil.setText(String.valueOf((int)hasil)); 
                }
            }
        }else{
            label_hasil.setText("");
        }
    }
    
    float hasil_dari(float operan_a, float operan_b, String operator){
        switch(operator){
            case "×":
                return operan_a * operan_b;
            case "÷":
                return operan_a / operan_b;
            case "+":
                return operan_a + operan_b;
            case "−":
                return operan_a - operan_b;
        }
        return 0;
    }
    
    private void update_expresi(){
        String expresi_gabungan = "";
        for(int i = 0; i < ekspresi.size(); i++){
            expresi_gabungan += ekspresi.get(i);
        }
        label_ekspresi.setText(expresi_gabungan);
        tbl_del.setText("DEL");
        evaluasi_ekspresi();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbl_7 = new javax.swing.JLabel();
        tbl_8 = new javax.swing.JLabel();
        tbl_9 = new javax.swing.JLabel();
        tbl_4 = new javax.swing.JLabel();
        tbl_5 = new javax.swing.JLabel();
        tbl_6 = new javax.swing.JLabel();
        tbl_3 = new javax.swing.JLabel();
        tbl_2 = new javax.swing.JLabel();
        tbl_1 = new javax.swing.JLabel();
        tbl_none_1 = new javax.swing.JLabel();
        tbl_0 = new javax.swing.JLabel();
        tbl_titik = new javax.swing.JLabel();
        tbl_bagi = new javax.swing.JLabel();
        tbl_del = new javax.swing.JLabel();
        tbl_kali = new javax.swing.JLabel();
        tbl_none_2 = new javax.swing.JLabel();
        tbl_minus = new javax.swing.JLabel();
        tbl_none_3 = new javax.swing.JLabel();
        tbl_plus = new javax.swing.JLabel();
        tbl_hasil = new javax.swing.JLabel();
        label_ekspresi = new javax.swing.JLabel();
        label_hasil = new javax.swing.JLabel();
        background_putih = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kalkulator Tiruan Android");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_7.setBackground(new java.awt.Color(68, 68, 68));
        tbl_7.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_7.setForeground(new java.awt.Color(255, 255, 255));
        tbl_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_7.setText("7");
        tbl_7.setOpaque(true);
        tbl_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_7MouseReleased(evt);
            }
        });
        getContentPane().add(tbl_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 110, 70));

        tbl_8.setBackground(new java.awt.Color(68, 68, 68));
        tbl_8.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_8.setForeground(new java.awt.Color(255, 255, 255));
        tbl_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_8.setText("8");
        tbl_8.setOpaque(true);
        tbl_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_8MouseReleased(evt);
            }
        });
        getContentPane().add(tbl_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 110, 70));

        tbl_9.setBackground(new java.awt.Color(68, 68, 68));
        tbl_9.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_9.setForeground(new java.awt.Color(255, 255, 255));
        tbl_9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_9.setText("9");
        tbl_9.setOpaque(true);
        tbl_9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_9MouseReleased(evt);
            }
        });
        getContentPane().add(tbl_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 110, 70));

        tbl_4.setBackground(new java.awt.Color(68, 68, 68));
        tbl_4.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_4.setForeground(new java.awt.Color(255, 255, 255));
        tbl_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_4.setText("4");
        tbl_4.setOpaque(true);
        tbl_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_4MouseReleased(evt);
            }
        });
        getContentPane().add(tbl_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 110, 70));

        tbl_5.setBackground(new java.awt.Color(68, 68, 68));
        tbl_5.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_5.setForeground(new java.awt.Color(255, 255, 255));
        tbl_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_5.setText("5");
        tbl_5.setOpaque(true);
        tbl_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_5MouseReleased(evt);
            }
        });
        getContentPane().add(tbl_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 110, 70));

        tbl_6.setBackground(new java.awt.Color(68, 68, 68));
        tbl_6.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_6.setForeground(new java.awt.Color(255, 255, 255));
        tbl_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_6.setText("6");
        tbl_6.setOpaque(true);
        tbl_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_6MouseReleased(evt);
            }
        });
        getContentPane().add(tbl_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 110, 70));

        tbl_3.setBackground(new java.awt.Color(68, 68, 68));
        tbl_3.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_3.setForeground(new java.awt.Color(255, 255, 255));
        tbl_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_3.setText("3");
        tbl_3.setOpaque(true);
        tbl_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_3MouseReleased(evt);
            }
        });
        getContentPane().add(tbl_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 110, 70));

        tbl_2.setBackground(new java.awt.Color(68, 68, 68));
        tbl_2.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_2.setForeground(new java.awt.Color(255, 255, 255));
        tbl_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_2.setText("2");
        tbl_2.setOpaque(true);
        tbl_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_2MouseReleased(evt);
            }
        });
        getContentPane().add(tbl_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 110, 70));

        tbl_1.setBackground(new java.awt.Color(68, 68, 68));
        tbl_1.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_1.setForeground(new java.awt.Color(255, 255, 255));
        tbl_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_1.setText("1");
        tbl_1.setOpaque(true);
        tbl_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_1MouseReleased(evt);
            }
        });
        getContentPane().add(tbl_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 110, 70));

        tbl_none_1.setBackground(new java.awt.Color(68, 68, 68));
        tbl_none_1.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_none_1.setForeground(new java.awt.Color(255, 255, 255));
        tbl_none_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_none_1.setOpaque(true);
        getContentPane().add(tbl_none_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 110, 70));

        tbl_0.setBackground(new java.awt.Color(68, 68, 68));
        tbl_0.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_0.setForeground(new java.awt.Color(255, 255, 255));
        tbl_0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_0.setText("0");
        tbl_0.setOpaque(true);
        tbl_0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_0MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_0MouseReleased(evt);
            }
        });
        getContentPane().add(tbl_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 110, 70));

        tbl_titik.setBackground(new java.awt.Color(68, 68, 68));
        tbl_titik.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_titik.setForeground(new java.awt.Color(255, 255, 255));
        tbl_titik.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_titik.setText(".");
        tbl_titik.setOpaque(true);
        tbl_titik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_titikMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_titikMouseReleased(evt);
            }
        });
        getContentPane().add(tbl_titik, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 110, 70));

        tbl_bagi.setBackground(new java.awt.Color(99, 99, 99));
        tbl_bagi.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_bagi.setForeground(new java.awt.Color(255, 255, 255));
        tbl_bagi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_bagi.setText("÷");
        tbl_bagi.setOpaque(true);
        tbl_bagi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_bagiMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_bagiMouseReleased(evt);
            }
        });
        getContentPane().add(tbl_bagi, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 110, 70));

        tbl_del.setBackground(new java.awt.Color(99, 99, 99));
        tbl_del.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        tbl_del.setForeground(new java.awt.Color(255, 255, 255));
        tbl_del.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_del.setText("DEL");
        tbl_del.setOpaque(true);
        tbl_del.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_delMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_delMouseReleased(evt);
            }
        });
        getContentPane().add(tbl_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 110, 70));

        tbl_kali.setBackground(new java.awt.Color(99, 99, 99));
        tbl_kali.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_kali.setForeground(new java.awt.Color(255, 255, 255));
        tbl_kali.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_kali.setText("×");
        tbl_kali.setOpaque(true);
        tbl_kali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_kaliMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_kaliMouseReleased(evt);
            }
        });
        getContentPane().add(tbl_kali, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 110, 70));

        tbl_none_2.setBackground(new java.awt.Color(99, 99, 99));
        tbl_none_2.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        tbl_none_2.setForeground(new java.awt.Color(255, 255, 255));
        tbl_none_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_none_2.setOpaque(true);
        getContentPane().add(tbl_none_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 110, 70));

        tbl_minus.setBackground(new java.awt.Color(99, 99, 99));
        tbl_minus.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_minus.setForeground(new java.awt.Color(255, 255, 255));
        tbl_minus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_minus.setText("−");
        tbl_minus.setOpaque(true);
        tbl_minus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_minusMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_minusMouseReleased(evt);
            }
        });
        getContentPane().add(tbl_minus, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 110, 70));

        tbl_none_3.setBackground(new java.awt.Color(99, 99, 99));
        tbl_none_3.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        tbl_none_3.setForeground(new java.awt.Color(255, 255, 255));
        tbl_none_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_none_3.setOpaque(true);
        getContentPane().add(tbl_none_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 110, 70));

        tbl_plus.setBackground(new java.awt.Color(99, 99, 99));
        tbl_plus.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_plus.setForeground(new java.awt.Color(255, 255, 255));
        tbl_plus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_plus.setText("+");
        tbl_plus.setOpaque(true);
        tbl_plus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_plusMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_plusMouseReleased(evt);
            }
        });
        getContentPane().add(tbl_plus, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 110, 70));

        tbl_hasil.setBackground(new java.awt.Color(99, 99, 99));
        tbl_hasil.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        tbl_hasil.setForeground(new java.awt.Color(255, 255, 255));
        tbl_hasil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tbl_hasil.setText("=");
        tbl_hasil.setOpaque(true);
        tbl_hasil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_hasilMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_hasilMouseReleased(evt);
            }
        });
        getContentPane().add(tbl_hasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 110, 70));

        label_ekspresi.setFont(new java.awt.Font("Open Sans", 0, 25)); // NOI18N
        label_ekspresi.setForeground(new java.awt.Color(90, 90, 90));
        label_ekspresi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_ekspresi.setPreferredSize(new java.awt.Dimension(520, 30));
        getContentPane().add(label_ekspresi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, -1, -1));

        label_hasil.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        label_hasil.setForeground(new java.awt.Color(130, 130, 130));
        label_hasil.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_hasil.setPreferredSize(new java.awt.Dimension(520, 60));
        getContentPane().add(label_hasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        background_putih.setBackground(new java.awt.Color(255, 255, 255));
        background_putih.setFont(new java.awt.Font("Open Sans", 0, 30)); // NOI18N
        background_putih.setForeground(new java.awt.Color(99, 99, 99));
        background_putih.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        background_putih.setAlignmentX(3.0F);
        background_putih.setEnabled(false);
        background_putih.setMinimumSize(new java.awt.Dimension(550, 120));
        background_putih.setOpaque(true);
        getContentPane().add(background_putih, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void tbl_7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_7MouseClicked
        
    }//GEN-LAST:event_tbl_7MouseClicked

    private void tbl_7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_7MouseReleased
        tbl_7.setBackground(new Color(68, 68, 68));
        tambah_expresi("7");
    }//GEN-LAST:event_tbl_7MouseReleased

    private void tbl_7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_7MousePressed
        tbl_7.setBackground(new Color(80, 80, 80));
    }//GEN-LAST:event_tbl_7MousePressed

    private void tbl_8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_8MousePressed
        tbl_8.setBackground(new Color(80, 80, 80));
    }//GEN-LAST:event_tbl_8MousePressed

    private void tbl_8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_8MouseReleased
        tbl_8.setBackground(new Color(68, 68, 68));
        tambah_expresi("8");
    }//GEN-LAST:event_tbl_8MouseReleased

    private void tbl_9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_9MouseReleased
        tbl_9.setBackground(new Color(68, 68, 68));
        tambah_expresi("9");
    }//GEN-LAST:event_tbl_9MouseReleased

    private void tbl_9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_9MousePressed
        tbl_9.setBackground(new Color(80, 80, 80));
    }//GEN-LAST:event_tbl_9MousePressed

    private void tbl_4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_4MouseReleased
        tbl_4.setBackground(new Color(68, 68, 68));
        tambah_expresi("4");
    }//GEN-LAST:event_tbl_4MouseReleased

    private void tbl_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_4MousePressed
        tbl_4.setBackground(new Color(80, 80, 80));
    }//GEN-LAST:event_tbl_4MousePressed

    private void tbl_5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_5MouseReleased
        tbl_5.setBackground(new Color(68, 68, 68));
        tambah_expresi("5");
    }//GEN-LAST:event_tbl_5MouseReleased

    private void tbl_5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_5MousePressed
        tbl_5.setBackground(new Color(80, 80, 80));
    }//GEN-LAST:event_tbl_5MousePressed

    private void tbl_6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_6MouseReleased
        tbl_6.setBackground(new Color(68, 68, 68));
        tambah_expresi("6");
    }//GEN-LAST:event_tbl_6MouseReleased

    private void tbl_6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_6MousePressed
        tbl_6.setBackground(new Color(80, 80, 80));
    }//GEN-LAST:event_tbl_6MousePressed

    private void tbl_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_1MouseReleased
        tbl_1.setBackground(new Color(68, 68, 68));
        tambah_expresi("1");
    }//GEN-LAST:event_tbl_1MouseReleased

    private void tbl_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_1MousePressed
        tbl_1.setBackground(new Color(80, 80, 80));
    }//GEN-LAST:event_tbl_1MousePressed

    private void tbl_2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_2MouseReleased
        tbl_2.setBackground(new Color(68, 68, 68));
        tambah_expresi("2");
    }//GEN-LAST:event_tbl_2MouseReleased

    private void tbl_2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_2MousePressed
        tbl_2.setBackground(new Color(80, 80, 80));
    }//GEN-LAST:event_tbl_2MousePressed

    private void tbl_3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_3MouseReleased
        tbl_3.setBackground(new Color(68, 68, 68));
        tambah_expresi("3");
    }//GEN-LAST:event_tbl_3MouseReleased

    private void tbl_3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_3MousePressed
        tbl_3.setBackground(new Color(80, 80, 80));
    }//GEN-LAST:event_tbl_3MousePressed

    private void tbl_titikMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_titikMouseReleased
        tbl_titik.setBackground(new Color(68, 68, 68));
        tambah_expresi(".");
    }//GEN-LAST:event_tbl_titikMouseReleased

    private void tbl_titikMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_titikMousePressed
        tbl_titik.setBackground(new Color(80, 80, 80));
    }//GEN-LAST:event_tbl_titikMousePressed

    private void tbl_0MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_0MouseReleased
        tbl_0.setBackground(new Color(68, 68, 68));
        tambah_expresi("0");
    }//GEN-LAST:event_tbl_0MouseReleased

    private void tbl_0MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_0MousePressed
        tbl_0.setBackground(new Color(80, 80, 80));
    }//GEN-LAST:event_tbl_0MousePressed

    private void tbl_bagiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bagiMouseReleased
        tbl_bagi.setBackground(new Color(99, 99, 99));
        tambah_expresi("÷");
    }//GEN-LAST:event_tbl_bagiMouseReleased

    private void tbl_bagiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bagiMousePressed
        tbl_bagi.setBackground(new Color(111, 111, 111));
    }//GEN-LAST:event_tbl_bagiMousePressed

    private void tbl_delMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_delMouseReleased
        tbl_del.setBackground(new Color(99, 99, 99));
        if(!ekspresi.isEmpty()){
            ekspresi.remove(ekspresi.size() - 1);
            if(ekspresi.size() > 0){
                simbol_terakhir = ekspresi.get(ekspresi.size() - 1);
            }else{
                simbol_terakhir = "";
            }
        }
        update_expresi();
        
    }//GEN-LAST:event_tbl_delMouseReleased

    private void tbl_delMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_delMousePressed
        tbl_del.setBackground(new Color(111, 111, 111));
    }//GEN-LAST:event_tbl_delMousePressed

    private void tbl_kaliMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kaliMouseReleased
        tbl_kali.setBackground(new Color(99, 99, 99));
        tambah_expresi("×");
    }//GEN-LAST:event_tbl_kaliMouseReleased

    private void tbl_kaliMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kaliMousePressed
        tbl_kali.setBackground(new Color(111, 111, 111));
    }//GEN-LAST:event_tbl_kaliMousePressed

    private void tbl_minusMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_minusMouseReleased
        tbl_minus.setBackground(new Color(99, 99, 99));
        tambah_expresi("−");
    }//GEN-LAST:event_tbl_minusMouseReleased

    private void tbl_minusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_minusMousePressed
        tbl_minus.setBackground(new Color(111, 111, 111));
    }//GEN-LAST:event_tbl_minusMousePressed

    private void tbl_plusMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_plusMouseReleased
        tbl_plus.setBackground(new Color(99, 99, 99));
        tambah_expresi("+");
    }//GEN-LAST:event_tbl_plusMouseReleased

    private void tbl_plusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_plusMousePressed
        tbl_plus.setBackground(new Color(111, 111, 111));
    }//GEN-LAST:event_tbl_plusMousePressed

    private void tbl_hasilMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hasilMouseReleased
        tbl_hasil.setBackground(new Color(99, 99, 99));
        ekspresi.clear();
        label_ekspresi.setText(label_hasil.getText());
        ekspresi.add(label_hasil.getText());
        label_hasil.setText("");
        tbl_del.setText("CLR");
    }//GEN-LAST:event_tbl_hasilMouseReleased

    private void tbl_hasilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hasilMousePressed
        tbl_hasil.setBackground(new Color(111, 111, 111));
    }//GEN-LAST:event_tbl_hasilMousePressed

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
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background_putih;
    private javax.swing.JLabel label_ekspresi;
    private javax.swing.JLabel label_hasil;
    private javax.swing.JLabel tbl_0;
    private javax.swing.JLabel tbl_1;
    private javax.swing.JLabel tbl_2;
    private javax.swing.JLabel tbl_3;
    private javax.swing.JLabel tbl_4;
    private javax.swing.JLabel tbl_5;
    private javax.swing.JLabel tbl_6;
    private javax.swing.JLabel tbl_7;
    private javax.swing.JLabel tbl_8;
    private javax.swing.JLabel tbl_9;
    private javax.swing.JLabel tbl_bagi;
    private javax.swing.JLabel tbl_del;
    private javax.swing.JLabel tbl_hasil;
    private javax.swing.JLabel tbl_kali;
    private javax.swing.JLabel tbl_minus;
    private javax.swing.JLabel tbl_none_1;
    private javax.swing.JLabel tbl_none_2;
    private javax.swing.JLabel tbl_none_3;
    private javax.swing.JLabel tbl_plus;
    private javax.swing.JLabel tbl_titik;
    // End of variables declaration//GEN-END:variables
}
