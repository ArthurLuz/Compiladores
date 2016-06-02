/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversao_infixa_posfixa;

import java.util.ArrayList;
import trabson2_comp.Automato;
import trabson2_comp.Transicoes;
/**
 *
 * @author CCSST
 */
public class Conversao_infixa_posfixa {
    ArrayList<Character> pilhaoperador = new ArrayList<Character>();
    ArrayList<Character> pilhaoperando = new ArrayList<Character>();
    ArrayList<Character> express = new ArrayList<Character>();
    String expressao;
   
    public Conversao_infixa_posfixa(String expressao){
        this.expressao = expressao;
    }
    public Conversao_infixa_posfixa(){
  
    }
    
    public boolean Eoperador(Character a){
        boolean fodase = false;
        
        if(a == '*' || a == '.' || a == '+' || a == '(' || a == ')')
            fodase = true;
        
        return fodase;
    }
    
    public String Arrumar_o_Erro_do_usuario_burro(){
       String arrumada, aux = expressao;
        char simbolo;
        int flag=0;
        int i = 0 ,cont = 0;
        //StringBuffer frase = new StringBuffer(expressao);
        
        for( i = 0; i < aux.length(); i++){
            express.add(expressao.charAt(i));
        }
        if (express.get(0)=='*')
            return "fecho";
        if (express.get(0)==')')
            return "parents";
        for( i =0; i<express.size(); i++){
            simbolo = express.get(i);
           // System.out.println("Satan");
            if(/*!Eoperador(simbolo) &&*/ i-1 > 0 && i+1 < express.size()){// esse aqui é quando ta no meio da string
                if(!Eoperador(express.get(i-1)) && (!Eoperador(simbolo) || express.get(i) == '(')){//    ope.ope   ope.(
                    express.add(i, '.');
                }else if(express.get(i-1) == '*' && (!Eoperador(simbolo) || express.get(i) == '(')){//  *.ope   *.(
                    express.add(i, '.');
                }else if(express.get(i-1) == ')' && (!Eoperador(simbolo) || express.get(i) == '(')){//  ).(   ).ope
                    express.add(i, '.');
                }
                //i--;
            }else if(/*!Eoperador(simbolo) &&*/ i == 0){// esse eh quando ta no inicio
                if(!Eoperador(simbolo) && (!Eoperador(express.get(i+1)) ||  express.get(i+1) == '(')){//  ope.ope   ope.(
                    express.add(i+1, '.');
                }
            }
//------
        }
        //System.out.println("Express: " + express.toString());
        
        for( i =0; i<express.size(); i++){
            simbolo = express.get(i);
           // System.out.println("Satan");
            
            
            if (simbolo=='(')
                flag++;
            else if (simbolo==')')
                flag--;
            //System.out.println(flag);
        }
               
        if(i == express.size()) { // aki eh quando eh no final
                if(!Eoperador(express.get(i-1)) && (!Eoperador(express.get(i-2)) || express.get(i-2) == '*' || express.get(i-2) == ')')){
                    express.add(i-1, '.');
                }
        }
        //System.out.println(flag);
        if (flag>0)
            return "maior";
        else if(flag<0)//////////////
            return "menor";
        arrumada = express.toString();
        arrumada = arrumada.replace(", ", "");
        arrumada = arrumada.replace("[", "");
        arrumada = arrumada.replace("]", "");
        //System.out.println(arrumada);
        
        return arrumada;
    }
    
    
    public String getalfabeto(String expressao){
        String exaux="";
        String cha = "";
        String alfabeto="";
        for(int i=0;i<expressao.length();i++){
            if(expressao.charAt(i)!= '('&& expressao.charAt(i)!= ')'&&expressao.charAt(i)!='*'&&expressao.charAt(i)!='.'&&expressao.charAt(i)!='+'){
                exaux=exaux+expressao.charAt(i);
            }
        }
        //System.out.println(exaux+"satan");
        for(int i=0;i<exaux.length();i++){
            cha=""+ exaux.charAt(i);
            //System.out.println(cha);
            if(exaux.contains(cha)&& !alfabeto.contains(cha)){
                alfabeto=alfabeto+cha;
            }        
        }
        //System.out.println("get   "+alfabeto);
        return alfabeto;
    }
    
    public static int Prioridade (char op){   // devolve a prioridade do operador
        int p = 0;
        switch(op){
        case '(' : p = 1; break;
        case '+' : p = 2; break;
        case '.' : p = 3; break;
        case '*' : p = 4; break;        
        default :
    }
    return (p);
}
   
    public ArrayList<Character> Converte(String arrumada){
      char simbolo, aux;
      int cont = 0;
        for(int i = 0; i<arrumada.length(); i++){
          simbolo = arrumada.charAt(i);
        
          if(simbolo == '+' || simbolo == '.' || simbolo == '(' || simbolo == '*'){
                int prioridade = Prioridade(simbolo);
           
                while(!pilhaoperador.isEmpty() && Prioridade(pilhaoperador.get(pilhaoperador.size()-1)) >= prioridade){
                    if(Prioridade(pilhaoperador.get(pilhaoperador.size()-1)) == 3 && prioridade == 1 ){
                        break;
                    }else if(Prioridade(pilhaoperador.get(pilhaoperador.size()-1)) == 2 && prioridade == 1 ){
                        break;
                    }
                    else if(pilhaoperador.get(pilhaoperador.size()-1) != '('){
                        pilhaoperando.add(pilhaoperador.get(pilhaoperador.size()-1));
                        pilhaoperador.remove(pilhaoperador.size()-1);
                    }
                }
            if(simbolo == '*')
                pilhaoperando.add(simbolo);
            else
                pilhaoperador.add(simbolo);
              
            }else if(simbolo == ')'){
              aux = pilhaoperador.get(pilhaoperador.size()-1);
              while(aux != '('){
                  pilhaoperando.add(aux);
                  pilhaoperador.remove(pilhaoperador.size()-1);
                  aux = pilhaoperador.get(pilhaoperador.size()-1);
                  
              }
              pilhaoperador.remove(pilhaoperador.size()-1);
          }
          else{
              pilhaoperando.add(simbolo);
          }
      }
      
      if(!pilhaoperador.isEmpty()){
          while(pilhaoperador.size()>0){
              //System.out.println(pilhaoperador);
              pilhaoperando.add(pilhaoperador.get(pilhaoperador.size()-1));
              pilhaoperador.remove(pilhaoperador.size()-1);
          }
      }
      
    return pilhaoperando;
    }
    
}

//(A+B)*(A+B)