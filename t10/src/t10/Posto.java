package t10;

import java.util.ArrayList;

public class Posto {
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String bandeira;
    private String endereco;
    private String bairro;
    private String cep;
    private String img;
    private ArrayList<Preco> valores;
    
    public Posto(String nomeFantasia, String bandeira, String razaoSocial, 
        String cnpj, String endereco, String bairro, String cep, String img) {
        this.nomeFantasia = nomeFantasia;
        this.bandeira = bandeira;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.img = img;
        this.valores = new ArrayList<Preco>();
    }
    
    public String toString(){
        return nomeFantasia + " " + valores.toString();
    }
    
    private void ordenaValores(){
        ArrayList l = new ArrayList<Preco>();
        for(int i=0; i<valores.size(); i++){
            l = insertPreco(l,valores.get(i));
        }
        this.valores = l;
    }
    
    private ArrayList insertPreco(ArrayList lis, Preco pre){
        ArrayList lis2 = new ArrayList<Preco>();
        int cont = 0;
        
        if (lis.size() == 0){
            lis2.add(pre);
            return lis2;
        }
        
        while(cont<lis.size() && pre.getData_int()<((Preco)lis.get(cont)).getData_int()){
            lis2.add(lis.get(cont));
            cont++;
        }
        lis2.add(pre);
        for(int i=cont; i<lis.size(); i++){
            lis2.add(lis.get(i));
        }
        return lis2;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public ArrayList<Preco> getValores() {
        return valores;
    }

    public void setValores(ArrayList<Preco> valores) {
        this.valores=valores;
        ordenaValores();
    }
    
    
}
