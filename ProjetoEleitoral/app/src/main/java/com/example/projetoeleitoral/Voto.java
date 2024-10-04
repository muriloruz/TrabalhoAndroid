package com.example.projetoeleitoral;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Voto {
    private int cand1=0;
    private int cand2=0;
    private int cand3=0;
    private int cand4=0;
    private int nulo=0;
    private int inde = 0;
    private int branco=0;
    public ArrayList<VotoE> vte = new ArrayList<>();
    public static Voto instance;
     private Voto(){}

    public static Voto getInstance(){
         if(instance == null) instance = new Voto();
         return instance;
    }

    public int getBranco() {
        return branco;
    }

    public void setBranco() {
        this.branco +=1;
    }

    public int getInde() {
        return inde;
    }

    public void setInde() {
        this.inde += 1;
    }

    public int getNulo() {
        return nulo;
    }

    public void setNulo() {
        this.nulo +=1;
    }

    public int getCand1() {
        return cand1;
    }

    public void setCand1() {
        this.cand1 += 1;
    }

    public int getCand2() {
        return cand2;
    }

    public void setCand2( ) {
        this.cand2 += 1;
    }

    public int getCand3() {
        return cand3;
    }

    public void setCand3( ) {
        this.cand3 += 1;
    }

    public int getCand4() {
        return cand4;
    }

    public void setCand4() {
        this.cand4 += 1;
    }

    public Map<String, Integer> contaVotos() {
        Map<String, Integer> contagemVotos = new HashMap<>();

        for (VotoE voto : vte) {
            String nomeCandidato = voto.getNome();

            if (!contagemVotos.containsKey(nomeCandidato)) {
                contagemVotos.put(nomeCandidato, 0);
            }

            contagemVotos.put(nomeCandidato, contagemVotos.get(nomeCandidato) + 1);
        }

        return contagemVotos;
    }
    public String resultados() {
        StringBuilder rst = new StringBuilder();
        Map<String, Integer> resultados = instance.contaVotos();

        for (Map.Entry<String, Integer> entry : resultados.entrySet()) {
            rst.append("Total de votos para ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        return rst.toString();
    }
}
