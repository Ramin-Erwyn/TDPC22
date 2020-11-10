package EXO2;


import java.util.Scanner;

public class prodConso {

//--------------------------------ma version du buffer-----------------------------------------
    private int N ;
    private boolean estPremier[] ;
    private int premier ;
    private int ouvrier ;
    private int nbN ;
    private int nbThreads ;
    private int nbfinThreads ;

    // contabilise les fin de thread ++
    synchronized void increamentfinthread() {
        nbfinThreads++ ;
    }

    class ouvrierThread implements Runnable {
        private int i;
        ouvrierThread( int i ) {
            this.i = i ;
        }

        public void run() {
            int j = i + i ;
            while ( j < nbN ) {
                estPremier[j] = false ;
                j += i ;
            }
            increamentfinthread() ;
        }
    } ;

    final private Thread ouvrierPrin = new Thread() {
        public void run() {
            ouvrier = 0;
            while (true) {
                   if (ouvrier == 1) {
                    nbN = N;
                    estPremier = new boolean[nbN];
                    for (int i = 0; i < nbN; i++) {
                        estPremier[i] = true;
                    }

                    for (int i = 2; i < nbN; i++) {
                        if (estPremier[i] == true) {
                            nbThreads++;
                            if (N != nbN) {
                                break;
                            }
                        }
                    }

// la fin de thread
                    while (nbfinThreads != nbThreads) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // nb de nombre de primaire
                    for (int i = 2; i < nbN; i++) {
                        if (estPremier[i] == true) {
                            premier++;
                        }
                    }


                }
            }
        }
    };

    private Object buffer[];
    private int sizeMax;
    private int lire, ecrire;
    private int nbElmt;

    void ProdCons(int N){
        this.buffer = new Object[N];
        this.sizeMax = N;
        this.lire = this.ecrire = this.nbElmt = 0;
    }
    // -----------------------
     synchronized void Put(Object m){
        while (this.nbElmt == this.sizeMax)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.buffer[this.ecrire++] = m;
        notify();
        this.ecrire %= this.sizeMax;
    }
    synchronized Object Get(){
        while (this.nbElmt == 0)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        Object m = this.buffer[this.lire++];
        this.lire %= this.sizeMax;
        notify();
        return m;
    }
    //-----------mathode filter----------

    public static void main(String[] args) {
System.out.println("\n\n-----EXO2 le crible d’Ératosthène-----");
// balance les filtre de 1 à N et 0 pour finir

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter N");
        int N = myObj.nextInt();  // Read user input
        System.out.println("N est: " + N);  // Output user input
        // ------classe Filtre --------------

    }
}