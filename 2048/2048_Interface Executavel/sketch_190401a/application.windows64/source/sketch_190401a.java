import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.Random; 
import java.util.Scanner; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_190401a extends PApplet {




int matriz[][] = new int[4][4];
int aux = 0;

public void setup() {

  
  matriz = preencheMatriz(matriz);
  matriz = preencheRandom(matriz, contaVazios(matriz));
  background(255);
}

public void draw() {
  if(aux == 0){
    for (int l = 0; l < 4; l++) {
  
      for (int c = 0; c < 4; c++) {
  
        Box box = new Box(l, c, 100);
  
        box.show(matriz[l][c]);
  
        textAlign(CENTER, CENTER);
        fill(0);
        textSize(32);
        text(matriz[l][c], (l + 1) * 100 +53, (c + 1) * 100 + 48, matriz[l][c]);
      }
    }
  }
}

public void keyPressed() {
  if(key == ' '){
      
      aux = 0;
      background(255);
    
  }
  if(aux == 0){
    if (key == CODED) {
  
      if (keyCode == UP) {    
  
        matriz = moveEsquerda(matriz);
  
        for (int l = 0; l < 4; l++) {
  
          for (int c = 0; c < 4; c++) {
  
            Box box = new Box(l, c, 100);
  
            box.show(matriz[l][c]);
  
            textAlign(CENTER, CENTER);
            fill(0);
            textSize(32);
            text(matriz[l][c], (l + 1) * 100 +53, (c + 1) * 100 + 48);
          }
        }
      } else if (keyCode == DOWN) {
  
        matriz = moveDireita(matriz);
  
        for (int l = 0; l < 4; l++) {
  
          for (int c = 0; c < 4; c++) {
  
            Box box = new Box(l, c, 100);
  
            box.show(matriz[l][c]);
  
            textAlign(CENTER, CENTER);
            fill(0);
            textSize(32);
            text(matriz[l][c], (l + 1) * 100 +53, (c + 1) * 100 + 48);
          }
        }
      } else if (keyCode == LEFT) {
  
        matriz = moveCima(matriz);
  
        for (int l = 0; l < 4; l++) {
  
          for (int c = 0; c < 4; c++) {
  
            Box box = new Box(l, c, 100);
  
            box.show(matriz[l][c]);
  
            textAlign(CENTER, CENTER);
            fill(0);
            textSize(32);
            text(matriz[l][c], (l + 1) * 100 +53, (c + 1) * 100 + 48);
          }
        }
      } else if (keyCode == RIGHT) {
  
        matriz = moveBaixo(matriz);
  
        for (int l = 0; l < 4; l++) {
  
          for (int c = 0; c < 4; c++) {
  
            Box box = new Box(l, c, 100);
  
            box.show(matriz[l][c]);
  
            textAlign(CENTER, CENTER);
            fill(0);
            textSize(32);
            text(matriz[l][c], (l + 1) * 100 +53, (c + 1) * 100 + 48);
          }
        }
  
        if (fimDeJogo(matriz)) {
  
          background(0);
  
          textAlign(CENTER, CENTER);
          fill(255);
          textSize(64);
          text("FIM DE JOGO!", 300, 300);
          textAlign(CENTER, CENTER);
          fill(255);
          textSize(32);
          text("Pressione ESPAÇO para recomeçar!", 300, 400);
          int maior = 0;
          for (int l = 0; l < 4; l++) {
  
            for (int c = 0; c < 4; c++) {
    
              if(l == 0 && c == 0){
                 maior = matriz[l][c]; 
              }else if(matriz[l][c] > maior){
                 maior = matriz[l][c];                
              }
            }
          }
          textAlign(CENTER, CENTER);
          fill(255);
          textSize(32);
          text("O maior valor foi : " + maior + ".",300, 200);
          
          matriz = preencheMatriz(matriz);
          matriz = preencheRandom(matriz, contaVazios(matriz));
          aux = 1;
          
        }
      }
    }
  }
}



public int[][] preencheMatriz(int[][] matriz) {

  for (int l = 0; l < matriz.length; l++) {

    for (int c = 0; c < matriz[0].length; c++) {

      matriz[l][c] = 0;
    }
  }

  return matriz;
}

public int[][] preencheRandom(int[][] matriz, int vazios) {

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

public int contaVazios(int matriz[][]) {

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

public int[][] moveCima(int[][] matriz) {

  int detectaMovimento = 0;

  for (int c = 0; c < matriz.length; c++) {
    
    int auxCombinacao = 0;
    
    for (int l = 0; l < matriz.length; l++) {

      if (l != 0) {

        if (matriz[l][c] != 0) {

          int aux = l;

          while (aux != 0) {

            if (matriz[aux - 1][c] == 0 || matriz[aux - 1][c] == matriz[aux][c] && auxCombinacao == 0) {

              if (matriz[aux - 1][c] == matriz[aux][c]) {

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

  if (detectaMovimento != 0) {

    matriz = preencheRandom(matriz, contaVazios(matriz));
  }
  return matriz;
}

public int[][] moveBaixo(int[][] matriz) {

  int detectaMovimento = 0;

  for (int c = 0; c < matriz.length; c++) {

    int auxCombinacao = 0;
    
    for (int l = matriz.length - 1; l >= 0; l--) {

      if (l != 3) {        

        if (matriz[l][c] != 0) {

          int aux = l;

          while (aux != 3) {

            if (matriz[aux + 1][c] == 0 || matriz[aux + 1][c] == matriz[aux][c] && auxCombinacao == 0) {

              if (matriz[aux + 1][c] == matriz[aux][c]) {

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

  if (detectaMovimento != 0) {

    matriz = preencheRandom(matriz, contaVazios(matriz));
  }
  return matriz;
}

public int[][] moveEsquerda(int[][] matriz) {

  int detectaMovimento = 0;

  for (int l = 0; l < matriz.length; l++) {
    
    int auxCombinacao = 0;

    for (int c = 0; c < matriz.length; c++) {

      if (c != 0) {

        if (matriz[l][c] != 0) {

          int aux = c;

          while (aux != 0) {

            if (matriz[l][aux - 1] == 0 || matriz[l][aux - 1] == matriz[l][aux] && auxCombinacao == 0) {

              if (matriz[l][aux - 1] == matriz[l][aux]) {

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

  if (detectaMovimento != 0) {

    matriz = preencheRandom(matriz, contaVazios(matriz));
  }

  return matriz;
}

public int[][] moveDireita(int[][] matriz) {

  int detectaMovimento = 0;

  for (int l = 0; l < matriz.length; l++) {
    
    int auxCombinacao = 0;

    for (int c = matriz.length - 1; c >= 0; c--) {

      if (c != 3) {        

        if (matriz[l][c] != 0) {

          int aux = c;

          while (aux != 3) {

            if (matriz[l][aux + 1] == 0 || matriz[l][aux + 1] == matriz[l][aux] && auxCombinacao == 0) {

              if (matriz[l][aux + 1] == matriz[l][aux]) {
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
  if (detectaMovimento != 0) {
    matriz = preencheRandom(matriz, contaVazios(matriz));
  }

  return matriz;
}

public boolean fimDeJogo(int[][] matriz) {

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
class Box {
 
  int x, y , len;
  
  
  Box(int x, int y, int len){
  
    this.x = x;
    this.y = y;
    this.len = len;
    
  }
  
  public void show( int cor){
    int cores[] = {0xffFFFACD, 0xffFFEFD5, 0xffFFDAB9, 0xffFFE4B5, 0xffEEE8AA, 0xffFFE4E1, 0xffD8BFD8, 0xffBC8F8F, 0xffBA55D3, 0xff9932CC, 0xff9400D3, 0xff8A2BE2, 0xff4169E1};
    int aux;
    for(aux = 0; cor > 1; aux++){
       
      cor = cor /2;
      
    }
    fill(cores[aux]);
    stroke(0);
    strokeWeight(5);
    pushMatrix();
    rect((x + 1) * 100 +3, (y + 1) * 100 + 3, len , len);
    popMatrix();
  
  }
  
}
  public void settings() {  size(615, 615); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_190401a" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
