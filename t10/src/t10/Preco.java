package t10;

public class Preco {
    private String tipo;
    private String valor;
    private String data;   
    private int data_int;
    
    public Preco(String tipo, String valor, String data) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        convData_Int();
    }
    
    private void convData_Int(){
        String s[] = data.split("[/]");
        data_int = Integer.valueOf(s[2])*10000+Integer.valueOf(s[1])*100+Integer.valueOf(s[0]);
    }
    
    public String toString(){
        return tipo + " " + valor + " " + data + " " + data_int  + "\n"; 
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getData_int() {
        return data_int;
    }

    public void setData_int(int data_int) {
        this.data_int = data_int;
    }
    
    
}
