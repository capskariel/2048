class Box {
 
  int x, y , len;
  
  
  Box(int x, int y, int len){
  
    this.x = x;
    this.y = y;
    this.len = len;
    
  }
  
  void show( int cor){
    color cores[] = {#FFFACD, #FFEFD5, #FFDAB9, #FFE4B5, #EEE8AA, #FFE4E1, #D8BFD8, #BC8F8F, #BA55D3, #9932CC, #9400D3, #8A2BE2, #4169E1};
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
