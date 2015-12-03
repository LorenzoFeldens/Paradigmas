package t10.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import t10.Posto;
import t10.Preco;

public class JDBC {
    private String jdbc_driver = "org.hsqldb.jdbcDriver";
    private String db_name = "postosdb";
    private String db_preurl = "jdbc:hsqldb:file:";
    private String db_url =  db_preurl + db_name;
    private String db_user = "sa";
    private String db_passwd = "";
    private String tab_postos = "posto";
    private String tab_precos = "preco";
    private String[] col_postos = {"nomefantasia","bandeira",
        "razaosocial","cnpj","endereco","bairro","cep","imagem"};
    private String[] col_precos = {"idpreco","tipo","valor","data","cnpj"};
    
    private ArrayList selectPostos() throws ClassNotFoundException, SQLException {
        ArrayList lista = new ArrayList<>();
       
        Class.forName(jdbc_driver);
        Connection c = DriverManager.getConnection(db_url, db_user, db_passwd);
        Statement s = c.createStatement(); 

        ResultSet rs;
        rs = s.executeQuery("SELECT * FROM "+tab_postos);
        while (rs.next())
            lista.add(new Posto(rs.getString(col_postos[0]), rs.getString(col_postos[1]),
            rs.getString(col_postos[2]), rs.getString(col_postos[3]), 
            rs.getString(col_postos[4]), rs.getString(col_postos[5]), 
            rs.getString(col_postos[6]), rs.getString(col_postos[7])));
 
        s.execute("SHUTDOWN");
        s.close();
        c.close();
      
        return lista;
    }
    
    private ArrayList selectPrecos(String cnpj) throws ClassNotFoundException, SQLException {
        ArrayList lista = new ArrayList<>();
       
        Class.forName(jdbc_driver);
        Connection c = DriverManager.getConnection(db_url, db_user, db_passwd);
        Statement s = c.createStatement(); 
      
        ResultSet rs;
        rs = s.executeQuery("SELECT * FROM "+tab_precos+" WHERE "+col_postos[3]+" = '"+cnpj+"'");
        while (rs.next())
            lista.add(new Preco(rs.getString(col_precos[1]),
            rs.getString(col_precos[2]), rs.getString(col_precos[3])));
 
        s.execute("SHUTDOWN");
        s.close();
        c.close();
      
        return lista;
    }
    
    public ArrayList getPostos (){
        ArrayList p = null;
        
        try {
            p = selectPostos();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return p;
    }
    
    public ArrayList getPrecos(String cnpj){
        ArrayList p = null;
        
        try {
            p = selectPrecos(cnpj);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return p;
    }
    
    private void deleteDados() throws ClassNotFoundException, SQLException {
        Class.forName(jdbc_driver);
        Connection c = DriverManager.getConnection(db_url, db_user, db_passwd);
        Statement s = c.createStatement();
      
        s.executeUpdate("DELETE FROM "+tab_precos);
        s.executeUpdate("DELETE FROM "+tab_postos);
      
        s.execute("SHUTDOWN");
        s.close();
        c.close();
    }
    
    private void insertPosto(String nomeFantasia, String bandeira, 
        String razaoSocial, String cnpj, String endereco, String bairro, String cep, 
        String img) throws ClassNotFoundException, SQLException{
       
        Class.forName(jdbc_driver);
        Connection c = DriverManager.getConnection(db_url, db_user, db_passwd);
        Statement s = c.createStatement();
      
        String str = "INSERT INTO "+tab_postos+" VALUES ('"+nomeFantasia
            +"', '"+bandeira+"', '"+razaoSocial+"', '"+cnpj+"', '"+endereco+"', '"+bairro
            +"', '"+cep+"', '"+img+"')";
        s.executeUpdate(str);
      
        s.execute("SHUTDOWN");
        s.close();
        c.close();
    }
   
    private void insertPreco(String tipo, String valor, String data, String cnpj) 
        throws ClassNotFoundException, SQLException{
       
        Class.forName(jdbc_driver);
        Connection c = DriverManager.getConnection(db_url, db_user, db_passwd);
        Statement s = c.createStatement();
      
        String str = "INSERT INTO "+tab_precos+"(tipo, valor, data, cnpj) VALUES ('"+tipo
            +"', '"+valor+"', '"+data+"', '"+cnpj+"')";
      
        s.executeUpdate(str);
      
        s.execute("SHUTDOWN");
        s.close();
        c.close();
    }
    
    public void updateDB(ArrayList postos){
        try {
            deleteDados();
            for(int i=0; i<postos.size(); i++){
                Posto p = (Posto) postos.get(i);
                insertPosto(p.getNomeFantasia(), p.getBandeira(), p.getRazaoSocial(), 
                    p.getCnpj(), p.getEndereco(), p.getBairro(), p.getCep(), p.getImg());
                ArrayList lisprecos = p.getValores();
                for(int j=0; j<lisprecos.size(); j++){
                    Preco q = (Preco) lisprecos.get(j);
                    insertPreco(q.getTipo(), q.getValor(), q.getData(), p.getCnpj());
                }
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getJdbc_driver() {
        return jdbc_driver;
    }

    public void setJdbc_driver(String jdbc_driver) {
        this.jdbc_driver = jdbc_driver;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public String getDb_preurl() {
        return db_preurl;
    }

    public void setDb_preurl(String db_preurl) {
        this.db_preurl = db_preurl;
    }

    public String getDb_url() {
        return db_url;
    }

    public void setDb_url(String db_url) {
        this.db_url = db_url;
    }

    public String getDb_user() {
        return db_user;
    }

    public void setDb_user(String db_user) {
        this.db_user = db_user;
    }

    public String getDb_passwd() {
        return db_passwd;
    }

    public void setDb_passwd(String db_passwd) {
        this.db_passwd = db_passwd;
    }

    public String getTab_postos() {
        return tab_postos;
    }

    public void setTab_postos(String tab_postos) {
        this.tab_postos = tab_postos;
    }

    public String getTab_precos() {
        return tab_precos;
    }

    public void setTab_precos(String tab_precos) {
        this.tab_precos = tab_precos;
    }

    public String[] getCol_postos() {
        return col_postos;
    }

    public void setCol_postos(String[] col_postos) {
        this.col_postos = col_postos;
    }

    public String[] getCol_precos() {
        return col_precos;
    }

    public void setCol_precos(String[] col_precos) {
        this.col_precos = col_precos;
    }
       
}
