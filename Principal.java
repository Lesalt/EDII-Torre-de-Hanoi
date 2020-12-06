import java.util.Stack;
import java.util.Scanner;

public class Principal {


    private static Stack<String> pilha = new Stack<String>();
    private  static long start;
    private  static  long finalCount;

    private static long numMov;


    private static void mover(int O, int D) {
        numMov++;
        System.out.println("[" + numMov + "]:" + O + " -> " + D);
    }


    public static void hanoi(int n) {
        int O = 1; 
        int D = 3;
        int T = 2;

        String comandoAtual = n + "," + O + "," + D + "," + T;

        pilha.push(comandoAtual);


        while (!pilha.empty()) {

            if (n > 1) {


                n--;
                String[] vetAux = comandoAtual.split(",");
                O = Integer.parseInt(vetAux[1]);
                D = Integer.parseInt(vetAux[2]);
                T = Integer.parseInt(vetAux[3]);


                comandoAtual = n + "," + O + "," + T + "," + D;


                pilha.push(comandoAtual);


            } else {


                comandoAtual = pilha.pop();

                String[] vetAux = comandoAtual.split(",");
                n = Integer.parseInt(vetAux[0]);
                O = Integer.parseInt(vetAux[1]);
                D = Integer.parseInt(vetAux[2]);
                T = Integer.parseInt(vetAux[3]);



                mover(O, D);


                if (n > 1) {
                    n--;
                    comandoAtual=n + "," + T + "," + D + "," + O;
                    pilha.push(comandoAtual);
                }

            }

        }

    }


    public static void main(String[] args) {
        int n;
        String resul;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o número de discos: ");
        n = entrada.nextInt();
        start = System.currentTimeMillis();
        Principal.hanoi(n);
        finalCount  = System.currentTimeMillis() - start;
        resul = String.format("%dhrs : %dmin : %dseg", Integer.parseInt(String.valueOf((finalCount/3600000))), Integer.parseInt(String.valueOf((finalCount/60000) %60)), Integer.parseInt(String.valueOf((finalCount/1000) % 60)));
        System.out.println("Numero de movimentos executados: " + numMov + "\nTempo gasto: " + resul);


    }

}