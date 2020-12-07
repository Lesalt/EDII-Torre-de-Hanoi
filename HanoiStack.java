
    import java.util.Scanner;

    public class HanoiStack {

        private  static long start;
        private  static  long finalCount;

        private static long numMov;

        private static void mover(int O, int D) {
            numMov++;
            System.out.println("[" + numMov + "]:" + O + " -> " + D);
        }

        // Método que implementa a recursão
        // O = pino origem
        // D = pino destino
        // T = pino de trabalho
        static void hanoi(int n, int O, int D, int T) {

            if (n > 0) {
                hanoi(n - 1, O, T, D);
                mover(O, D);
                hanoi(n - 1, T, D, O);
            }

        }

        // executando o hanoi
        public static void main(String[] args) {

            int n; // número de discos
            String resul;
            // recebe o número de discos digitado pelo usuário
            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite o número de discos: ");
            n = entrada.nextInt();

            start = System.currentTimeMillis();
            HanoiStack.hanoi(n, 1, 3, 2);
            finalCount  = System.currentTimeMillis() - start;
            resul = String.format("%dhrs : %dmin : %dseg", Integer.parseInt(String.valueOf((finalCount/3600000))), Integer.parseInt(String.valueOf((finalCount/60000) %60)), Integer.parseInt(String.valueOf((finalCount/1000) % 60)));
            System.out.println("Numero de movimentos executados: " + numMov + "\nTempo gasto: " + resul);
        }
    }

