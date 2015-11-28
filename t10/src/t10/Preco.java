package t10;

public class Preco {
    private int idpreco;
    private String tipo;
    private float valor;
    private String data;

    public Preco(int idpreco, String tipo, float valor, String data) {
        this.idpreco = idpreco;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }
    
    public String toString(){
        return "      "+idpreco+" "+tipo+" "+valor+" "+data+"\n";
    }
}
