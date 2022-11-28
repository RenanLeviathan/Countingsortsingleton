/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingsortwithsingleton;

/**
 *
 * @author Renan Duarte
 */
public final class Countingsort {
    private static Countingsort instance;
    private int tempo = 0;
    int[] A;
    int[] B;
    int[] C;
    int k;
    private Countingsort(int[] A, int k){
        this.A = A;
        this.B = new int[A.length+1];
        for(int i=1;i<A.length+1;i++){
            B[i] = A[i-1];
        }
        this.C = new int[k+1];
        this.k = k;
    }
    
    /**
     * Realiza a ordenação do vetor A
     */
    public void sort(){
        for(int i=0;i<=k;i++) C[i]=0;  tempo += 1;//inicializa vetor C
        for(int j=0;j<A.length;j++) C[A[j]]++; tempo += 1;//começa a contagem da frequência dos elementos de A
        for(int i=1;i<=k;i++) C[i] += C[i-1]; tempo += 1;//frequência acumulada
        for(int j=A.length-1;j>=0;j--){
            B[C[A[j]]] = A[j]; tempo += 1;
            C[A[j]]--; tempo += 1;
        }
    }
    
    /**
     * Vetor legível ao usuário
     * @return vetor
     */
    @Override
    public String toString(){
        String vetor;
        vetor = "{";
        for(int i=1;i<B.length-1;i++){
            vetor+=B[i]+",";
        }
        vetor+=B[B.length-1]+"}";
        return vetor;
    }
    
    /**
     * Método inerente a projetos Singleton, que retorna a instância, a qual deve ser única
     * @param A vetor a ser ordenado
     * @param k tamanho do vetor auxiliar
     * @return
     */
    public static synchronized Countingsort getInstance(int[] A, int k){
        if (instance == null){
            instance = new Countingsort(A,k);
        }
        return instance;
    }
    public void exibirTempo(){
        System.out.println("\nTempo de execução: "+tempo+"ms");
    }
}
