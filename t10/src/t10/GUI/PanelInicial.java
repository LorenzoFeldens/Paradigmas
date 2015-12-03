package t10.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import t10.Posto;
import t10.DB.JDBC;

public class PanelInicial extends javax.swing.JFrame {
    JDBC db;
    ArrayList postos;
    ArrayList listPostos;
    PanelChooser pChooser;
    PanelPosto pPosto;
    PanelSalvo pSalvo;
    DefaultListModel model;
    
    public PanelInicial() {
        db = new JDBC();
        postos = getDados();
        listPostos = postos;
        
        initComponents();
        
        updateListPostos();
        
        pChooser = new PanelChooser();
        pPosto = new PanelPosto();
        pSalvo = new PanelSalvo();
        
        setListDoubleClickAction();
    }
    
    private void setListDoubleClickAction(){
        jList1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    openPosto();
                }
            }
        });
    }
    
    private void openPosto(){
        Posto pos = (Posto) listPostos.get(jList1.getSelectedIndex());
        pPosto.openPosto(this, pos);
    }
    
    public void editPosto(String oldCnpj, Posto pos){
        for(int i=0; i<postos.size(); i++){
            Posto p = (Posto) postos.get(i);
            String nCnpj = p.getCnpj().replace(".","").replace("-", "").replace("/","");
            if(nCnpj.equalsIgnoreCase(oldCnpj)){
                ((Posto)postos.get(i)).setCnpj(pos.getCnpj());
                ((Posto)postos.get(i)).setRazaoSocial(pos.getRazaoSocial());
                ((Posto)postos.get(i)).setNomeFantasia(pos.getNomeFantasia());
                ((Posto)postos.get(i)).setBandeira(pos.getBandeira());
                ((Posto)postos.get(i)).setEndereco(pos.getEndereco());
                ((Posto)postos.get(i)).setBairro(pos.getBairro());
                ((Posto)postos.get(i)).setCep(pos.getCep());
                ((Posto)postos.get(i)).setImg(pos.getImg());
                ((Posto)postos.get(i)).setValores(pos.getValores());
                break;
            }
        }
        
        listPostos = postos;
        updateListPostos();
    }
    
    public boolean verifyCnpj(String cnpj){
        for(int i=0; i<postos.size(); i++){
            Posto pos = (Posto) postos.get(i);
            String str = pos.getCnpj();
            str = str.replace(".","").replace("-", "").replace("/","");
            
            if(str.equalsIgnoreCase(cnpj)){
                return true;
            }
        }
        return false;
    }
    
    public void insertPosto(Posto pos){
            postos.add(pos);
            listPostos = postos;
            updateListPostos();
    }
        
    private void updateListPostos(){
       String str = "";
       
       model = new DefaultListModel();
       
       for(int i=0; i<listPostos.size(); i++){
           Posto p = (Posto) listPostos.get(i);
           model.addElement(p.getNomeFantasia());
       }
       
       jList1.setModel(model);
    }
    
    private ArrayList getDados(){
        ArrayList p = db.getPostos();
        
        for(int i=0; i<p.size(); i++){
            Posto pos = (Posto) p.get(i);
            ArrayList pre = db.getPrecos(pos.getCnpj());
            ((Posto)p.get(i)).setValores(pre);
        }
        
        return p;
    }
    
    public void deletPosto(String cnpj){
        for(int i=0; i<postos.size(); i++){
            Posto p = (Posto) postos.get(i);
            if(p.getCnpj().equalsIgnoreCase(cnpj)){
                postos.remove(i);
            }
        }
        
        listPostos = postos;
        updateListPostos();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMinimumSize(new java.awt.Dimension(353, 70));

        jButton1.setText("Carregar Dados");
        jButton1.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jButton1.setMinimumSize(new java.awt.Dimension(200, 32));
        jButton1.setPreferredSize(new java.awt.Dimension(200, 32));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Salvar Dados");
        jButton3.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jButton3.setMinimumSize(new java.awt.Dimension(200, 32));
        jButton3.setPreferredSize(new java.awt.Dimension(200, 32));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Dados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Postos");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Excluir Posto");
        jButton5.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jButton5.setMinimumSize(new java.awt.Dimension(109, 25));
        jButton5.setPreferredSize(new java.awt.Dimension(109, 25));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Inserir Posto");
        jButton6.setMaximumSize(new java.awt.Dimension(32767, 32767));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addGap(67, 67, 67)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(74, 74, 74))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Buscar");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "CNPJ", "Razão Social", "Bandeira", "Rua", "Bairro", "CEP" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        db.updateDB(postos);
        pSalvo.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] strings = pChooser.selecionar().split("[.]");
        String str = strings[0];
        db.setDb_name(str);
        postos = getDados();
        listPostos = postos;
        updateListPostos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList lp = new ArrayList<>();
        String str = jTextField1.getText();
        switch(jComboBox1.getSelectedIndex()){
            case 0:
                for(int i=0; i<postos.size(); i++){
                    Posto p = (Posto) postos.get(i);
                    if(p.getNomeFantasia().toLowerCase().contains(str)){
                        lp.add(p);
                        
                    }
                    System.out.println(p.getNomeFantasia());
                }
            break;
            case 1:
                for(int i=0; i<postos.size(); i++){
                    Posto p = (Posto) postos.get(i);
                    if((p.getCnpj()).replace(".","").replace("-", "").replace("/","")
                        .equalsIgnoreCase(str.replace(".","").replace("-", "").replace("/",""))){
                        lp.add(p);
                    }
                }
            break;
            case 2:
                for(int i=0; i<postos.size(); i++){
                    Posto p = (Posto) postos.get(i);
                    if(p.getRazaoSocial().toLowerCase().contains(str)){
                        lp.add(p);
                    }
                }
            break;
            case 3:
                for(int i=0; i<postos.size(); i++){
                    Posto p = (Posto) postos.get(i);
                    if(p.getBandeira().toLowerCase().contains(str)){
                        lp.add(p);
                    }
                }
            break;
            case 4:
                for(int i=0; i<postos.size(); i++){
                    Posto p = (Posto) postos.get(i);
                    if(p.getEndereco().replace("-", "").equalsIgnoreCase(str.replace("-", str))){
                        lp.add(p);
                    }
                }
            break;
            case 5:
                for(int i=0; i<postos.size(); i++){
                    Posto p = (Posto) postos.get(i);
                    if(p.getBairro().toLowerCase().contains(str)){
                        lp.add(p);
                    }
                }
            break;
            case 6:
                for(int i=0; i<postos.size(); i++){
                    Posto p = (Posto) postos.get(i);
                    if(p.getCep().toLowerCase().contains(str)){
                        lp.add(p);
                    }
                }
            break;                    
        }
        listPostos = lp;
        updateListPostos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        pPosto.insertPosto(this);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String cnpj = ((Posto)listPostos.get(jList1.getSelectedIndex())).getCnpj();

        listPostos.remove(jList1.getSelectedIndex());
        
        deletPosto(cnpj);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
