
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[][] matriz = new int[4][4];

        Scanner scanner = new Scanner(System.in);

        matriz = preencheMatriz(matriz);

        mostraMatriz(matriz);

        System.out.println("Aperte '8' para mover para cima.\nAperte '2' para mover para baixo.\nAperte '4' para mover para a esquerda.\nAperte '6' para mover para a direita.\nAperte '0' para sair.\n");

        matriz = preencheRandom(matriz, contaVazios(matriz));
        mostraMatriz(matriz);

        int op = 5;

        do {

            op = scanner.nextInt();

            switch (op) {

                case 8:
                    matriz = moveCima(matriz);
                    break;
                case 2:
                    matriz = moveBaixo(matriz);
                    break;
                case 4:
                    matriz = moveEsquerda(matriz);
                    break;
                case 6:
                    matriz = moveDireita(matriz);
                    break;

            }

            if (fimDeJogo(matriz)) {

                System.out.println("FIM DE JOGO");
                op = 0;

            }

        } while (op != 0);

    }

    public static int[][] preencheMatriz(int[][] matriz) {

        for (int l = 0; l < matriz.length; l++) {

            for (int c = 0; c < matriz[0].length; c++) {

                matriz[l][c] = 0;

            }

        }

        return matriz;
    }

    public static void mostraMatriz(int[][] matriz) {

        for (int l = 0; l < matriz.length; l++) {

            for (int c = 0; c < matriz[0].length; c++) {

                System.out.print(matriz[l][c] + "\t");

            }

            System.out.println();

        }

        System.out.println();

    }

    public static int[][] preencheRandom(int[][] matriz, int vazios) {

        Random random = new Random();
        int contador = 0;
        while (contador < 1 && contador < vazios) {
            int l = random.nextInt(4);
            int c = random.nextInt(4);
            if (matriz[l][c] == 0) {

                if (random.nextInt(10) == 0) {

                    matriz[l][c] = 4;

                } else {

                    matriz[l][c] = 2;

                }

                contador++;

            }

        }

        return matriz;

    }

    public static int contaVazios(int matriz[][]) {

        int contaVazios = 0;

        for (int l = 0; l < matriz.length; l++) {

            for (int c = 0; c < matriz[0].length; c++) {

                if (matriz[l][c] == 0) {

                    contaVazios++;

                }

            }

        }

        return contaVazios;
    }

    public static int[][] moveCima(int[][] matriz) {

        int detectaMovimento = 0;

        for (int c = 0; c < matriz.length; c++) {

            for (int l = 0; l < matriz.length; l++) {

                if (l != 0) {

                    int auxCombinacao = 0;

                    if (matriz[l][c] != 0) {

                        int aux = l;

                        while (aux != 0) {

                            if (matriz[aux - 1][c] == 0 || matriz[aux - 1][c] == matriz[aux][c] && auxCombinacao == 0) {

                                if(matriz[aux - 1][c] == matriz[aux][c]){

                                    auxCombinacao++;

                                }

                                matriz[aux - 1][c] += matriz[aux][c];

                                matriz[aux][c] = 0;

                                aux--;

                                detectaMovimento++;

                            } else {

                                aux--;

                            }
                        }
                    }
                }
            }
        }

        if(detectaMovimento != 0) {

            matriz = preencheRandom(matriz, contaVazios(matriz));
            mostraMatriz(matriz);

        }
        return matriz;
    }

    public static int[][] moveBaixo(int[][] matriz) {

        int detectaMovimento = 0;

        for (int c = 0; c < matriz.length; c++) {

            for (int l = matriz.length - 1; l >= 0; l--) {

                if (l != 3) {

                    int auxCombinacao = 0;

                    if (matriz[l][c] != 0) {

                        int aux = l;

                        while (aux != 3) {

                            if (matriz[aux + 1][c] == 0 || matriz[aux + 1][c] == matriz[aux][c] && auxCombinacao == 0) {

                                if(matriz[aux + 1][c] == matriz[aux][c]){

                                    auxCombinacao++;

                                }

                                matriz[aux + 1][c] += matriz[aux][c];

                                matriz[aux][c] = 0;

                                aux++;

                                detectaMovimento++;

                            } else {

                                aux++;

                            }
                        }
                    }
                }
            }
        }

        if(detectaMovimento != 0) {

            matriz = preencheRandom(matriz, contaVazios(matriz));
            mostraMatriz(matriz);

        }
        return matriz;
    }

    public static int[][] moveEsquerda(int[][] matriz) {

        int detectaMovimento = 0;

        for (int l = 0; l < matriz.length; l++) {

            for (int c = 0; c < matriz.length; c++) {

                if (c != 0) {

                    int auxCombinacao = 0;

                    if (matriz[l][c] != 0) {

                        int aux = c;



                        while (aux != 0) {

                            if (matriz[l][aux - 1] == 0 || matriz[l][aux - 1] == matriz[l][aux] && auxCombinacao == 0) {

                                if(matriz[l][aux - 1] == matriz[l][aux]){

                                    auxCombinacao++;

                                }

                                matriz[l][aux - 1] += matriz[l][aux];

                                matriz[l][aux] = 0;

                                aux--;

                                detectaMovimento++;

                            } else {

                                aux--;

                            }
                        }
                    }
                }
            }
        }

        if(detectaMovimento != 0) {

            matriz = preencheRandom(matriz, contaVazios(matriz));
            mostraMatriz(matriz);

        }

        return matriz;
    }

    public static int[][] moveDireita(int[][] matriz) {

        int detectaMovimento = 0;

        for (int l = 0; l < matriz.length; l++) {

            for (int c = matriz.length - 1; c >= 0; c--) {

                if (c != 3) {

                    int auxCombinacao = 0;

                    if (matriz[l][c] != 0) {

                        int aux = c;

                        while (aux != 3) {

                            if (matriz[l][aux + 1] == 0 || matriz[l][aux + 1] == matriz[l][aux] && auxCombinacao == 0) {

                                if(matriz[l][aux + 1] == matriz[l][aux]){

                                    auxCombinacao++;

                                }

                                matriz[l][aux + 1] += matriz[l][aux];

                                matriz[l][aux] = 0;

                                aux++;

                                detectaMovimento++;

                            } else {

                                aux++;

                            }
                        }
                    }
                }
            }
        }
        if(detectaMovimento != 0) {

            matriz = preencheRandom(matriz, contaVazios(matriz));
            mostraMatriz(matriz);

        }

        return matriz;
    }

    public static boolean fimDeJogo(int[][] matriz) {

        int aux = 0, auxRepete = 0;

        for (int l = 0; l < matriz.length; l++) {

            for (int c = 0; c < matriz[0].length; c++) {

                if (matriz[l][c] == 0) {

                    aux++;

                }
            }

        }

        if (aux == 0) {

            for (int l = 0; l < matriz.length; l++) {

                for (int c = 0; c < matriz[0].length; c++) {

                    if (l == 0) {

                        if (c == 0) {

                            if (matriz[l][c] == matriz[l + 1][c] || matriz[l][c] == matriz[l][c + 1]) {

                                auxRepete++;

                            }

                        } else if (c == 3) {

                            if (matriz[l][c] == matriz[l + 1][c] || matriz[l][c] == matriz[l][c - 1]) {

                                auxRepete++;

                            }

                        }

                    } else if (l == 3) {

                        if (c == 0) {

                            if (matriz[l][c] == matriz[l - 1][c] || matriz[l][c] == matriz[l][c + 1]) {

                                auxRepete++;

                            }

                        } else if (c == 3) {

                            if (matriz[l][c] == matriz[l - 1][c] || matriz[l][c] == matriz[l][c - 1]) {

                                auxRepete++;

                            }

                        }

                    } else if (c == 0 && l != 0 && l != 3) {

                        if (matriz[l][c] == matriz[l - 1][c] || matriz[l][c] == matriz[l][c + 1] || matriz[l][c] == matriz[l + 1][c]) {

                            auxRepete++;

                        }

                    } else if (c == 3 && l != 0 && l != 3) {


                        if (matriz[l][c] == matriz[l - 1][c] || matriz[l][c] == matriz[l][c - 1] || matriz[l][c] == matriz[l + 1][c]) {

                            auxRepete++;

                        }

                    } else if (l == 0 && c != 0 && c != 3) {

                        if (matriz[l][c] == matriz[l][c + 1] || matriz[l][c] == matriz[l][c - 1] || matriz[l][c] == matriz[l + 1][c]) {

                            auxRepete++;

                        }

                    } else if (l == 3 && c != 0 && c != 3) {

                        if (matriz[l][c] == matriz[l][c + 1] || matriz[l][c] == matriz[l][c - 1] || matriz[l][c] == matriz[l - 1][c]) {

                            auxRepete++;

                        }

                    } else {

                        if (matriz[l][c] == matriz[l][c + 1] || matriz[l][c] == matriz[l][c - 1] || matriz[l][c] == matriz[l - 1][c] || matriz[l][c] == matriz[l + 1][c]) {

                            auxRepete++;

                        }

                    }
                }

            }

            if (auxRepete == 0) {

                return true;

            } else {

                return false;

            }

        } else {

            return false;

        }

    }
}

