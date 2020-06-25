
package negocio;

import persistencia.LeitorDao;

/**
 *
 * @author Gustavo Martini
 */
public class Leitor {
    
    private int codigo;
    private String nome;
    private String email;

    public Leitor(String nome, String email) {
        this.codigo = LeitorDao.tamanho();
        this.nome = nome;
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "--- Nome: " + getNome()
                + "\n--- Email: " + getEmail()
                + "\n";
    }
    
    
    
    
}
