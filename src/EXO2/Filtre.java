package EXO2;

//       ------------------------------------------ FILTRE-------------------------------------------------
class Filtre extends Thread {
    Buffer bufferGauche;
    int element;
    int modulo;
    public static void filter(int N){
        Buffer bufferGauche;
        int element = 0;

        int modulo;
        for (int i =0; i> N;i++){

        }
        public static void filtre(int N){
            Buffer bufferGauche;
            int element;
            int modulo;
            for(int i = 2; i<=100;){
                int premier = 1;
                for(int loop = 2; loop <=i; loop++) {
                    if((i % loop) == 0 && loop!=i) {
                        premier = 0;
                    }
                }
                if (premier != 0){
                    System.out.println(i+" est un nombre premier");
                    i++;
                }
                else
                    i ++;
            }
        }
        }
    }
}