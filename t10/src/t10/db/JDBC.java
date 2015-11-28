package t10.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import t10.Posto;
import t10.Preco;

public class JDBC {
   static final String JDBC_DRIVER = "org.hsqldb.jdbcDriver";
   static String db_name;
   static String db_url;// = "jdbc:hsqldb:file:" + DB_NAME;
   static final String DB_USER = "sa";
   static final String DB_PASSWD = "";

    public JDBC(String nome) {
        db_name = nome;
        db_url = "jdbc:hsqldb:file:" + db_name;
    }
   
   

   public ArrayList getPostos() throws ClassNotFoundException, SQLException {
      ArrayList lista = new ArrayList<Posto>();
       
      Class.forName(JDBC_DRIVER);

      Connection c = DriverManager.getConnection(db_url,
                                                 DB_USER,
                                                 DB_PASSWD);

      Statement s = c.createStatement();
//      s.executeUpdate("CREATE TABLE posto (idposto INTEGER GENERATED ALWAYS AS IDENTITY NOT NULL, "
//        + "nomefantasia VARCHAR(255), bandeira VARCHAR(255), razaosocial VARCHAR(255), "
//        + "cnpj VARCHAR(255), endereco VARCHAR(255), bairro VARCHAR(255), cep VARCHAR(255), "
//        + "imagem VARCHAR(255), maps VARCHAR(255), PRIMARY KEY(idposto))");
//      
//      s.executeUpdate("CREATE TABLE preco (idpreco INTEGER GENERATED ALWAYS AS IDENTITY NOT NULL , "
//        + "tipo VARCHAR(255), valor VARCHAR(255), data VARCHAR(255), idposto INTEGER, "
//        + "PRIMARY KEY(idpreco), FOREIGN KEY (idposto) REFERENCES posto (idposto));");
//      
//      s.executeUpdate("INSERT INTO posto (nomefantasia, bandeira, razaosocial, cnpj,"
//        + "endereco, bairro, cep, imagem, maps) VALUES('Posto Hubner', 'Ipiranga', "
//        + "'Posto 01', '11111111111', 'Avenida João Luiz Pozzobon, 2145, Km 3', "
//        + "'Nossa Senhora das Dores', '97095-465', 'postohubner.jpg', "
//        + "'https://goo.gl/maps/PB3owpXAikB2')");
//      s.executeUpdate("INSERT INTO posto (nomefantasia, bandeira, razaosocial, cnpj,"
//        + "endereco, bairro, cep, imagem, maps) VALUES('Posto Camobi II', 'Ipiranga', "
//        + "'Posto 02', '22222222222', 'RS-509, Km 9', 'Camobi', '97095-000', "
//        + "'postocamobiii.jpg', 'https://goo.gl/maps/9KSBVYDQ87t')");
//      s.executeUpdate("INSERT INTO posto (nomefantasia, bandeira, razaosocial, cnpj,"
//        + "endereco, bairro, cep, imagem, maps) VALUES('Auto Posto Shell', 'Shell', "
//        + "'Posto 03', '33333333333', 'BR-158, Km 3', 'Nossa Senhora das Dores', "
//        + "'97095-460', 'autopostoshell.jpg', 'https://goo.gl/maps/xnS9CCadPq32')");
//      s.executeUpdate("INSERT INTO posto (nomefantasia, bandeira, razaosocial, cnpj,"
//        + "endereco, bairro, cep, imagem, maps) VALUES('Posto BR', 'Petrobras', "
//        + "'Posto 04', '44444444444', 'Av. Pref. Evandro Behr, 6705', 'Camobi', "
//        + "'97110-640', 'postobr.jpg', 'https://goo.gl/maps/85ie4gAZmis')");
//      s.executeUpdate("INSERT INTO posto (nomefantasia, bandeira, razaosocial, cnpj,"
//        + "endereco, bairro, cep, imagem, maps) VALUES('Posto Petrobras', 'Petrobras', "
//        + "'Posto 05', '55555555555', 'R. Pinheiro Machado, 2300', 'Centro', "
//        + "'97050-600', 'postopetrobras.jpg', 'https://goo.gl/maps/3KuG7ku3HP42')");
//      s.executeUpdate("INSERT INTO preco (tipo, valor, data, idposto) VALUES ("
//        + "'Gasolina', '3.31', '21/10/2015', 0)");
//      s.executeUpdate("INSERT INTO preco (tipo, valor, data, idposto) VALUES ("
//        + "'Gasolina', '3.26', '23/11/2015', 1)");
//      s.executeUpdate("INSERT INTO preco (tipo, valor, data, idposto) VALUES ("
//        + "'Etanol', '2.95', '15/10/2015', 2)");
//      s.executeUpdate("INSERT INTO preco (tipo, valor, data, idposto) VALUES ("
//        + "'Diesel', '3.56', '11/11/2015', 3)");
//      s.executeUpdate("INSERT INTO preco (tipo, valor, data, idposto) VALUES ("
//        + "'Gasolina', '3.45', '23/10/2015', 4)");
//      s.executeUpdate("INSERT INTO preco (tipo, valor, data, idposto) VALUES ("
//        + "'Gasolina', '3.42', '05/11/2015', 0)");
//      s.executeUpdate("INSERT INTO preco (tipo, valor, data, idposto) VALUES ("
//        + "'Etanol', '3.01', '21/10/2015', 0)");
//      s.executeUpdate("INSERT INTO preco (tipo, valor, data, idposto) VALUES ("
//        + "'Gasolina', '3.39', '15/11/2015', 0)");
//      s.executeUpdate("INSERT INTO preco (tipo, valor, data, idposto) VALUES ("
//        + "'Diesel', '3.53', '21/10/2015', 0)");
      

      ResultSet rs;
      rs = s.executeQuery("SELECT * FROM posto");
      while (rs.next())
         lista.add(new Posto(rs.getInt("idposto"), rs.getString("cnpj"),
         rs.getString("razaosocial"), rs.getString("nomefantasia"), 
         rs.getString("bandeira"), rs.getString("endereco"), rs.getString("bairro"),
         rs.getString("cep"), rs.getString("imagem"), rs.getString("maps")));
 
      s.execute("SHUTDOWN");
      s.close();
      c.close();
      
      return lista;
   }
   
   public ArrayList getPrecos(int idposto) throws ClassNotFoundException, SQLException {
      ArrayList lista = new ArrayList<Posto>();
       
      Class.forName(JDBC_DRIVER);

      Connection c = DriverManager.getConnection(db_url,
                                                 DB_USER,
                                                 DB_PASSWD);

      Statement s = c.createStatement();
      
      ResultSet rs;
      rs = s.executeQuery("SELECT * FROM preco WHERE idposto ="+idposto);
      while (rs.next())
         lista.add(new Preco(rs.getInt("idpreco"), rs.getString("tipo"),
         Float.valueOf(rs.getString("valor")), rs.getString("data")));
 
      s.execute("SHUTDOWN");
      s.close();
      c.close();
      
      return lista;
   }
}