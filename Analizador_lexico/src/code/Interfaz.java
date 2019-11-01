/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Charly Ponce
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
  analizador_sintactico sintax=new analizador_sintactico();
   static List<String> errores=new ArrayList<>();
    String texto="";
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnAnalizar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        analisis_sintactico = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAnalizar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalizar.setText("Buscar archivo para analizar...");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 48)); // NOI18N
        jLabel1.setText("Analizador Lexico");

        btnAnalizar1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalizar1.setText("Analisis sintactico");
        btnAnalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizar1ActionPerformed(evt);
            }
        });

        analisis_sintactico.setColumns(20);
        analisis_sintactico.setRows(5);
        jScrollPane2.setViewportView(analisis_sintactico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(611, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 1299, Short.MAX_VALUE)
                    .addComponent(btnAnalizar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1299, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnalizar1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     public void guardararchivo(String texto_archivo,String nombre) throws IOException{
     
       String content = texto_archivo;
     Path path = Paths.get(nombre);

    
         BufferedWriter writer = Files.newBufferedWriter(path,StandardCharsets.UTF_8, StandardOpenOption.CREATE);
    {
        writer.write(content);
        writer.flush();
    }
     
     }
     
     
     
     public static String readFileAsString(String fileName)throws Exception 
  { 
    String data = ""; 
    data = new String(Files.readAllBytes(Paths.get(fileName))); 
    return data; 
  } 
  
  
  
    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed

     
       
        
            
        
       
        try {
            JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.showOpenDialog(null);
        File archivo = chooser.getSelectedFile();
        
            FileReader fr=  new FileReader(archivo);
            Reader lector = new BufferedReader(new FileReader(archivo));
            
       texto= readFileAsString(archivo.getAbsolutePath());
        
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            while (true) {
                token_object to=new token_object();
               
                Tokens tokens = lexer.yylex();
                int ultima_columna=lexer.columna+lexer.yylength();
               
                 to.setToken(tokens);
                 to.setLine(lexer.linea);
                 to.setFirst_columnn(lexer.columna);
                 to.setLast_columnn(ultima_columna);
                 sintax.lista_tokens.add(to);
                if (tokens == null) {
                    resultado += "FIN";
                    txtResultado.setForeground(Color.green);
                    txtResultado.setText(resultado);
                      guardararchivo(resultado, archivo.getAbsolutePath().split("\\.")[0]+".out");
                    return;
                }
                switch (tokens) {
                    case ERROR:
                        resultado += "Simbolo no definido en linea: " + lexer.linea + " primera columna: "+lexer.columna +" ultima columna: "+ultima_columna+" para el token: " + lexer.lexeme + "\n\n";
                        break;

                    case Error_de_Identificador:
                        resultado += "Identificador malo , el identificador debe tener 31 caractres o menos, error encontrado en linea: " + lexer.linea +" primera columna: "+lexer.columna + " ultima columna: "+ultima_columna+", token malo " + lexer.lexeme + "\n";
                        resultado += "el Identificador correcto seria asi: " + lexer.lexeme.substring(0, 31) + "\n\n";
                        break;

                    case error_String_no_completado:
                        resultado += "String mal escrito ,falta una comilla simple al final del String ,error en linea: " + lexer.linea +" primera columna: "+lexer.columna +" ultima columna: "+ultima_columna+ ", token malo " + lexer.lexeme + "\n\n";
                      
                        break;

                         case comentario_con_error:
                        resultado += "comentario mal escrito ,terminarlo: " + lexer.linea +" primera columna: "+lexer.columna +" ultima columna: "+ultima_columna+ ", token malo " + lexer.lexeme + "\n\n";
                      
                        break;
                        
                    case Float_malo:
                        resultado += "Float mal escrito ,error en linea: " + lexer.linea +" primera columna: "+lexer.columna + " ultima columna: "+ultima_columna+", token malo " + lexer.lexeme + "\n\n";
                        break;

                    case Identificador:
                    case Reservadas:
                    case String:
                    case Bool:
                    case Float:
                    case suma:
                    case resta:
                    case multiplicacion:
                    case division:
                    case modular:
                    case menor:
                    case menor_igual:
                    case mayor:
                    case mayor_igual:
                    case igual:
                    case comparar:
                    case diferente:
                    case and:
                    case or:
                    case exclamacion:
                    case punto_coma:
                    case coma:
                    case punto:
                    case corchete_derecho:
                    case corchete_izquierdo:
                    case parentesis_izquierdo:
                    case parentesis_derecho:
                    case llave_izquierda:
                    case llave_derecha:
                    case doble_corchete:
                    case doble_parentesis:
                    case doble_llave:
                    case arroba:
                    case numeral:
                    case doble_numeral:
                    case Int:
                        resultado += "linea :"+lexer.linea+" , primera columna: "+lexer.columna +" ultima columna: "+ultima_columna+" , " +lexer.lexeme + ": Es un@" + tokens + "\n\n";
                        break;
                    
                    default:
                        resultado += "Token: " + tokens + " " + lexer.lexeme + "\n\n";
                        break;
                }
               
                   
            } 
              
         
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
      
    }//GEN-LAST:event_btnAnalizarActionPerformed

    public static  void guardar_salidas(String error){
    
    errores.add(error+"\n");
    }
    
    private void btnAnalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizar1ActionPerformed
       
        
        /*token_object t = new token_object();
        t.setToken(Tokens.final_texto);
        sintax.lista_tokens.add(t);
        sintax.analizar();
        JOptionPane.showMessageDialog(null,sintax.lista_errores);*/
        
     
        Sintax s = new Sintax(new code.Lexercup(new StringReader(texto)));
      
        try {
            errores.add("Analisis iniciado \n");
            s.parse();
            errores.add("Analisis finalizado \n");
            
            Color myred = new Color(162, 35, 29);
            analisis_sintactico.setForeground(myred);
            analisis_sintactico.setText(errores.toString());
             
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAnalizar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea analisis_sintactico;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnAnalizar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
