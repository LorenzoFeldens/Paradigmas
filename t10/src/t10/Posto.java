package t10;

import java.util.ArrayList;
import t10.db.JDBC;

public class Posto {
    private int idposto;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String bandeira;
    private String endereco;
    private String bairro;
    private String cep;
    private String img;
    private String maps;
    private ArrayList<Preco> valores;

    public Posto(int idposto, String cnpj, String razaoSocial, String nomeFantasia, String bandeira, String endereco, String bairro, String cep, String img, String maps) {
        this.idposto = idposto;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.bandeira = bandeira;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.img = img;
        this.maps = maps;
    }
    
    public String toString(){
        return idposto+" "+nomeFantasia+" "+razaoSocial+" "+bandeira+" "+
                cnpj+" "+endereco+" "+bairro+" "+cep+" "+img+" "+maps+"\n"+valores.toString();
    }

    public void setValores(ArrayList<Preco> valores) {
        this.valores = valores;
    }

    public int getIdposto() {
        return idposto;
    }
    
    

    
    
    
    
    
    
    
}
