/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_4;

/**
 *
 * @author CCSST
 */
public class Afd {
    int linhas;
    int colunas;
    String alfabeto;
    String[][] tableafd;
    String token;
    
    public Afd(){
    }
    
    void Alocatable(int li, int col){
        tableafd = new String[li][col];
    }
    
}
