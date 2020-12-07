
    import java.util.Scanner;

    public class HanoiStack {

        private  static long start;
        private  static  long finalCount;

        private static long numMov;

        private static void moverDiscos(int Origem, int Destino) {
            numMov++;
            System.out.println("[" + numMov + "]:" + Origem + " -> " + Destino);
        }

        static void torreDeHanoi(int num, int Origem, int Destino, int Trabalho) {

            if (num > 0) {
                torreDeHanoi(num - 1, Origem, Trabalho, Destino);
                moverDiscos(Origem, Destino);
                torreDeHanoi(num - 1, Trabalho, Destino, Origem);
            }

        }


        public static void main(String[] args) {

            int numeroDiscos;
            String resul;

            Scanner read = new Scanner(System.in);
            System.out.println("Digite o número de discos: ");
            numeroDiscos = read.nextInt();

            start = System.currentTimeMillis();
            HanoiStack.torreDeHanoi(numeroDiscos, 1, 3, 2);
            finalCount  = System.currentTimeMillis() - start;
            resul = String.format("%dhrs : %dmin : %dseg", Integer.parseInt(String.valueOf((finalCount/3600000))), Integer.parseInt(String.valueOf((finalCount/60000) %60)), Integer.parseInt(String.valueOf((finalCount/1000) % 60)));
            System.out.println("Numero de movimentos executados: " + numMov + "\nTempo gasto: " + resul);
        }
    }

