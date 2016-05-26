/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabson2_comp;

import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;
import conversao_infixa_posfixa.Conversao_infixa_posfixa;
import java.util.Collections;





/**
 *
 * @author CCSST
 */
public class Automato {
    ArrayList<Integer> vertice = new ArrayList<>();
    ArrayList<Transicoes> transicao = new ArrayList<>();
    ArrayList<Conj_estados> Conj_Estados = new ArrayList<>();
    private int estado_Final;
    public String[][] tabela;
    public int linhastabela;
    int colunastabela;
    
    String saida;
   
   public Automato(String saida){
       this.saida=saida;
   }
   
   public Automato(){
       
   }
   
   int get_vertice_cont() {
	return vertice.size();
    }
   
   public void set_vertice(int no_vertice) {
	for(int i = 0; i < no_vertice; i++) {
            vertice.add(i);
	}
    }

   public void imprimir(Automato afn){
    Transicoes new_trans = null;
    Conj_estados conj = null;
    //Vector texto = new Vector();
    
       //System.out.println(saida);
    
    String texto="Transições: \n" ;
            for(int i = 0; i < afn.transicao.size(); i++){
                new_trans = afn.transicao.get(i);
                texto+="q" + new_trans.vertice_de + " --> q" + new_trans.vertice_para + " : simbolo = " + new_trans.simbolo_trans+"\n";
            }
            texto+="Estado Final: q" + afn.getEstado_Final();
            JOptionPane.showMessageDialog(null,texto);  
            //Set_Afn(afn);
//            String texto2 = "";
//            for(int i = 0; i < a.Conj_Estados.size(); i++){
//                conj = a.Conj_Estados.get(i);
//                texto2+="q" + conj.de + " --> q" + conj.paraestado1 + ", q" + conj.paraestado2 + " : simbolo = " + conj.simbolo+"\n";
//            }
//            JOptionPane.showMessageDialog(null,texto2);  
   }
   
  public Automato Set_Afn(Automato afn){
      Transicoes new_trans = null;
      Transicoes auxtrans = null;
      Automato result = new Automato();
      int cont = 0;
      int aux1 = 0, aux2 = 0;

        for(int i = 0; i < afn.getEstado_Final(); i++){
          for(int j = 0; j < afn.transicao.size(); j++){
              new_trans = afn.transicao.get(j);
              if(new_trans.vertice_de == i){
                  auxtrans = afn.transicao.get(j);
                  if(cont == 0){
                      aux1 = new_trans.vertice_para;
                      cont++;
                  }else{
                      aux2 = new_trans.vertice_para;
                      cont = 0;
                  }
              }
          }
          if(cont == 1){
              result.set_conjunto_1trasicao(auxtrans.vertice_de, aux1, auxtrans.simbolo_trans);
          }else
            result.set_Conjunto_2trasicao(auxtrans.vertice_de, aux1, aux2);
          cont = 0;
      }
        
        result.set_Conjunto_2trasicao(afn.getEstado_Final(), null, null);
        result.setEstado_Final(afn.getEstado_Final());
        result.saida = saida;
        //set_Tabela(result);
        return result;
        
  }
  
  public void set_Tabela(Automato afn){
      
        Conj_estados conjuntos = null;
        Automato result = new Automato();
        Conversao_infixa_posfixa c = new Conversao_infixa_posfixa();
        String alfabeto = c.getalfabeto(saida);
        alfabeto += "&";
        alfabeto = "a".concat(alfabeto);
        String matriz[][] = new String[afn.getEstado_Final()+1][alfabeto.length()];
  
        for(int i = 0; i <= afn.getEstado_Final() ; i++){
            matriz[i][0] = "q"+i;
        }
        
        for(int i = 0; i <= afn.getEstado_Final(); i++){
            conjuntos = afn.Conj_Estados.get(i);
            for(int j = 1; j < alfabeto.length(); j++){
                if(alfabeto.charAt(j) == conjuntos.simbolo){
                    if(conjuntos.paraestado1 == null && conjuntos.paraestado2 == null)
                        matriz[i][j] = "-";
                    else if(conjuntos.paraestado1 == null)
                        matriz[i][j] = "q" + conjuntos.paraestado2;
                    else if(conjuntos.paraestado2 == null)
                        matriz[i][j] = "q" + conjuntos.paraestado1;
                    else
                        matriz[i][j] = "{q" + conjuntos.paraestado1 + ", " + "q" + conjuntos.paraestado2 + "}";
                }else
                    matriz[i][j] = "-";
            }
        }
        tabela = new String[afn.getEstado_Final()][alfabeto.length()];
        tabela = matriz;
//        for(int i = 0; i <= afn.getEstado_Final(); i++){
//            for(int j = 0; j < alfabeto.length(); j++){
//                System.out.println(tabela[i][j]);
//            }
//        }
        
        linhastabela = afn.getEstado_Final();
        colunastabela = alfabeto.length();
        //System.out.println("Desgraça");
  }

  
  public String Fecho_E(String estado){
      String maisoutroauxiliar;
      ArrayList<String>saidafecho = new ArrayList<>();
      String retorno = estado;
      if (retorno == "-"){
          //System.out.println("entrou hueee");
          return retorno;
      }
      Conversao_infixa_posfixa c = new Conversao_infixa_posfixa();
      //System.out.println("Entrou: " + estado);
      String alfabeto = c.getalfabeto(saida);
      alfabeto += "&";
      alfabeto = "a".concat(alfabeto);
      //Conj_estados conjuntos = null;
      String aux = Conj_Trans(estado);
      aux = aux.replace("{", "");
      aux = aux.replace("}", "");
      aux = aux.replace(", ", "");
      
      //System.out.println("AUX: " + aux);
      
    for(int i=0;i < aux.length();i++){
        int in = i;
        if(aux.charAt(i) == 'q'){
            in++;
            maisoutroauxiliar = "q";
            while(in < aux.length() && aux.charAt(in) != 'q'){
                maisoutroauxiliar += "" + aux.charAt(in);
                in++;  
            }
            saidafecho.add(maisoutroauxiliar);
            //divide2.add(outroauxiliar);
            //outroauxiliar = "";
            in--;
        }
        i = in;
    }
      
//      for(int i = 0; i <= linhastabela; i++){
//          if(aux.contains("q"+i)){ 
//            if(!saidafecho.contains("q"+i))
//                saidafecho.add("q"+i);
//          }
//      }    
      //System.out.print(saidafecho.toString());
      for(int i = 0; i < saidafecho.size() ; i++){
        retorno = UniaoEstados(retorno, Fecho_E(saidafecho.get(i)));   
      }
      
      //System.out.println("Retorno: " + retorno);
    return retorno;
  }
  
  public String Conj_Trans(String estado){
      
      String retorno = "";
      for(int i = 0; i <= linhastabela; i++){
          if(estado.equals(tabela[i][0])){
                retorno = tabela[i][colunastabela-1];
          }
      }
      return retorno;
  }
  
  public String UniaoEstados(String estados, String fecho){
      
      String pegaint = "";
      String retorno = estados + fecho;
      String aux;
      retorno = retorno.replace(", ", "");
      retorno = retorno.replace("]", "");
      retorno = retorno.replace("[", "");
      //System.out.println("Retorno:" + retorno);
      //String maisoutroauxiliar;
      ArrayList<String> quebra = new ArrayList<>();
      ArrayList<Integer> inteiro = new ArrayList<>();
      for(int i=0;i < retorno.length();i++){
        int in = i;
          //System.out.println("charAT" + retorno.charAt(i));
        if(retorno.charAt(i) == 'q'){
            //System.out.println("Entrou");
            in++;
            //maisoutroauxiliar = "q";
            while(in < retorno.length() && retorno.charAt(in) != 'q'){
                //maisoutroauxiliar += "" + retorno.charAt(in);
                pegaint += "" + retorno.charAt(in);
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //TODO: NESSA LINHA PEGAR OS NUMEROS, TRANSFORMAR EM INTEGER, ORDERNAR E DEPOIS IMPRIMIR EM STRING DE NOVO///
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////
                in++;  
            }
            if(!inteiro.isEmpty()){
                boolean w = false;
                for(int j = 0; j < inteiro.size(); j++){
                    if(inteiro.get(j) == Integer.parseInt(pegaint)){
                        //System.out.println("entrou");
                        w = true;//////////ARRUMARRRRRRRRRRRR
                    }
                }
                if(w != true){
                    //System.out.println("entrou");
                    inteiro.add(Integer.parseInt(pegaint));
                }
            }else
                inteiro.add(Integer.parseInt(pegaint));
            //quebra.add(maisoutroauxiliar);
            //divide2.add(outroauxiliar);
            //outroauxiliar = "";
            in--;
            pegaint = "";
        }
        i = in;
    }
      //inteiro.
      Collections.sort(inteiro);
//      for(int i = 0; i < inteiro.size() - 1; i++){
//          for(int j = i + 1; j < inteiro.size(); j++){
//              
//          }
//              
//      }
      //System.out.print("inteiro" + inteiro);
      //System.out.println("Quebra: " + quebra.toString());
//System.out.println("q" + estados + ", " + fecho);
    for(int i = 0; i < inteiro.size(); i++){
        quebra.add("q" + inteiro.get(i).toString());
    }
      aux = quebra.toString();
      //System.out.println("aux : " + aux);
      aux = aux.replace(", ", "");
      aux = aux.replace("]", "");
      aux = aux.replace("[", "");
      //System.out.println("aux : " + aux);
      //System.out.print("aux: " + aux);
      return aux;
  }
    
  
  void set_conjunto_1trasicao(int from, int vertice_para, char simbolo){
      Conj_estados conj = new Conj_estados();
      conj.de = from;
      conj.simbolo = simbolo;
      conj.paraestado1 = vertice_para;
      Conj_Estados.add(conj);
  }
  
  void set_Conjunto_2trasicao(int from, Integer vertice_para1, Integer vertice_para2){
      Conj_estados conj = new Conj_estados();
      conj.de = from;
      conj.simbolo = '&';
      conj.paraestado1 = vertice_para1;
      conj.paraestado2 = vertice_para2;
      Conj_Estados.add(conj);
  }
  
   void set_transition(int vertice_de, int vertice_para, char simbolo_trans) {
        Transicoes nova_trans = new Transicoes();
        nova_trans.vertice_de = vertice_de;
        nova_trans.vertice_para = vertice_para;
        nova_trans.simbolo_trans = simbolo_trans;
        transicao.add(nova_trans);
    }
   
    public int getEstado_Final() {
        return estado_Final;
    }

    public void setEstado_Final(int estado) {
        estado_Final = estado;
    }

    
    public Automato concat(Automato a, Automato b) {
	Automato result = new Automato();
	result.set_vertice(a.get_vertice_cont() + b.get_vertice_cont());
	int i;
	Transicoes new_trans;

	for(i = 0; i < a.transicao.size(); i++) {
		new_trans = a.transicao.get(i);
		result.set_transition(new_trans.vertice_de, new_trans.vertice_para, new_trans.simbolo_trans);
	}

	result.set_transition(a.getEstado_Final(), a.get_vertice_cont(), '&');

	for(i = 0; i < b.transicao.size(); i++) {
		new_trans = b.transicao.get(i);
		result.set_transition(new_trans.vertice_de + a.get_vertice_cont(), new_trans.vertice_para + a.get_vertice_cont(), new_trans.simbolo_trans);
	}

	result.setEstado_Final(a.get_vertice_cont() + b.get_vertice_cont() - 1);

	return result;
}

//public Automato(){
    //return new Automato();
//}
    
public Automato kleene(Automato a) {
	Automato result = new Automato();
	int i;
	Transicoes new_trans;
	
	result.set_vertice(a.get_vertice_cont() + 2);

	result.set_transition(0, 1, '&');

	for(i = 0; i < a.transicao.size(); i++) {
		new_trans = a.transicao.get(i);
		result.set_transition(new_trans.vertice_de + 1, new_trans.vertice_para + 1, new_trans.simbolo_trans);
	}

	result.set_transition(a.get_vertice_cont(), a.get_vertice_cont() + 1, '&');
	result.set_transition(a.get_vertice_cont(), 1, '&');
	result.set_transition(0, a.get_vertice_cont() + 1, '&');

	result.setEstado_Final(a.get_vertice_cont() + 1);

	return result;
}


public Automato uniao(Automato a, Automato b) {
	Automato result = new Automato();
        result.set_vertice(a.get_vertice_cont() + b.get_vertice_cont() + 2);
        int i;
        Transicoes new_trans;
        
        result.set_transition(0, 1, '&');

        for(i = 0; i < a.transicao.size(); i++) {
		new_trans = a.transicao.get(i);
		result.set_transition(new_trans.vertice_de + 1, new_trans.vertice_para + 1, new_trans.simbolo_trans);
                
	}
        
        result.set_transition(0, a.get_vertice_cont() + 1 , '&');
        
        for(i = 0; i < b.transicao.size(); i++) {
		new_trans = b.transicao.get(i);
		result.set_transition(new_trans.vertice_de + a.get_vertice_cont() + 1, new_trans.vertice_para + a.get_vertice_cont() + 1, new_trans.simbolo_trans);
	}
        
        result.set_transition(a.get_vertice_cont(), result.get_vertice_cont() - 1, '&');
        
        result.set_transition(b.get_vertice_cont() + a.get_vertice_cont(), result.get_vertice_cont() - 1, '&');
        
        result.setEstado_Final(a.get_vertice_cont() + b.get_vertice_cont() + 1);
        

	return result;
}

public boolean Eoperador(Character a){
        boolean fodase = false;
        
        if(a == '*' || a == '.' || a == '+' || a == '(' || a == ')')
            fodase = true;
        
        return fodase;
}
     

public Automato er_para_afn(String re) {
    char simbolo;
    //int operadores_cont = 0;
    Stack<Automato> pilha = new Stack<Automato>();
    Automato novo;
    
    for(int i = 0; i < re.length(); i++){
        simbolo = re.charAt(i);
        
        if(!Eoperador(simbolo)){
            novo = new Automato();
            novo.set_vertice(2);
            novo.set_transition(0, 1, simbolo);
            novo.setEstado_Final(1);
            pilha.push(novo);
        }else{
            Automato op1;
            if(simbolo == '*'){
                op1 = pilha.pop();
                pilha.push(kleene(op1));
            }
            else{
                Automato op2;
                op2 = pilha.pop();
                if(pilha.peek() != null){
                    op1 = pilha.pop();
                    if(simbolo == '.'){
                        pilha.push(concat(op1, op2));    
                    }else if(simbolo == '+'){
                        pilha.push(uniao(op1, op2));
                    }
                }
            }
        }
    }
    Automato afn = pilha.pop();
    afn.saida = saida;
    if(pilha.empty()){
        imprimir(afn);
    }
    
    return afn;
}
  
    

//    public static void main(String[] args) {
//       // Automato a = new Automato();
//        
//        //a.er_para_afn("01+*0.");
//        //a.imprimir();
//        
//    }
   
}
