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
public class CountingSortWithSingleton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] A = new int[1000];
        //usado para n == 1000
        //for(int i=0;i<1000;i++){
        //    A[i]=(int) (Math.random()*1000)+1;
        //}
        Countingsort c = Countingsort.getInstance(A, 1000);
        System.out.println(c);
        c.sort();
        System.out.println(c);
        c.exibirTempo();
    }
    
}
