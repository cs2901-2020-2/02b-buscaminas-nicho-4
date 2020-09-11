import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class buscaminas {

    static final Logger logger = Logger.getLogger(buscaminas.class.getName());

    //int tabla [][];

    //Crea el arreglo de nxn que representa la tabla
    public static void creartabla(int[][] tabla, int n){
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++){
                tabla[i][j] = 0;
            }
        }
        set_minas(tabla, n);
        imprimirtabla(tabla, n);
    }

    //Coloca las minas cambiando 0s por 1s
    public static void set_minas(int[][] tabla, int n){
        Random rand = new Random();
        int cant_minas = rand.nextInt(n+1);
        int rand_x = rand.nextInt(n);
        int rand_y = rand.nextInt(n);
        for (int i = 0; i <= cant_minas; i++){
            if (tabla[rand_x][rand_y] == 0)
                tabla[rand_x][rand_y] = 1;
            else
                rand_x = rand.nextInt(n);
            rand_y = rand.nextInt(n);
        }
    }

    //Imprime la tabla del juego rellenada de o
    public static void imprimirtabla(int[][] tabla, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.println(tabla[i][j]);
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args){
        boolean estado = true;
        logger.info("Ingresa el tamaño de la tabla: ");
        Scanner scannerObj = new Scanner(System.in);
        int n = scannerObj.nextInt();
        int[][] tabla = new int[n][n];
        creartabla(tabla, n);

        while(estado){
            logger.info("Ingresa las coordenadas: ");
            int x = scannerObj.nextInt();
            int y = scannerObj.nextInt();
            if(tabla[x][y]==1){
                estado=false;
            }
            imprimirtabla(tabla,n);
        }
    }

}

