import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class buscaminas {

    static final Logger logger = Logger.getLogger(buscaminas.class.getName());

    //int tabla [][];

    //Crea el arreglo de nxn que representa la tabla
    public static void creartablas(int[][] tabla,string[][] tablajuego , int n){
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++){
                tabla[i][j] = 0;
                tablajuego[i][j] = "o";
            }
        }
        set_minas(tabla, n);
        imprimirtabla(tablajuego,n);
    }


    //Coloca las minas cambiando 0s por 1s
    public static void set_minas(int[][] tabla, int n){
        tabla[n][n] = 1;
        /*Random rand = new Random();
        int cant_minas = rand.nextInt(n+1);
        int rand_x = rand.nextInt(n);
        int rand_y = rand.nextInt(n);
        for (int i = 0; i <= cant_minas; i++){
            if (tabla[rand_x][rand_y] == 0)
                tabla[rand_x][rand_y] = 1;
            else
                rand_x = rand.nextInt(n);
                rand_y = rand.nextInt(n);
        }*/
    }

    //Imprime la tabla del juego rellenada de o
    public static void imprimirtabla(string[][] tabla, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.println(tabla[i][j]);
            }
            System.out.println("\n");
        }
    }

    public static void escoger_casilla(int[][] tabla, string[][] tablajuego,int n, boolean estado){
        int x = scannerObj.nextInt();
        int y = scannerObj.nextInt();
        boolean valid_coord = true;
        while (x > n || y > n){
            logger.info("Ingresa coordenadas validas: ");
            x = scannerObj.nextInt();
            y = scannerObj.nextInt();
        }
        tablajuego[x][y] = tabla[x][y];
        imprimirtabla(tablajuego,n);
        if (tabla[x][y] == 1){
            estado = false;
        }
    }


    public static void main(String[] args){
        boolean estado = true;
        logger.info("Ingresa el tamaño de la tabla: ");
        Scanner scannerObj = new Scanner(System.in);

        int n = scannerObj.nextInt();
        int[][] tabla = new int[n][n];
        string[][] tablajuego = new string[n][n];

        creartablas(tabla, tablajuego, n);

        while (estado=true){
            escoger_casilla(tabla,tablajuego,n,estado);
        }

    }

}

