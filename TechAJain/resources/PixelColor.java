/*
 [Q] Given an image with each pixel having a color and a brightness, how can we find a block of connected pixels of same color having maximum total brightness?
	[[ (A,1), (A,2), (B,1) ],
	 [ (A,3), (B,2), (B,3) ],
	 [ (A,4), (C,2), (A,5) ]]
	 
*/

class Pixel {
  char color;
  int brightness;
}

class PixelColor {

  public int getMaxBrightness(Pixel[][] image) {

    int row = image[0];
    int col = image[0].length;
    int max = Integer.MIN_VALUE;

    boolean[][] visited = new boolean[row][col];
    
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        if(!visited[i][j]) {
          int value = findBrightness(image, row, col, i, j, visited, image[i][j].color);
          max = Math.max(max, value);
        }
      }
    }

    return max;


  }

  int findBrightness(Pixel[][] image, int row, int col, int i, int j, boolean[][] visited, char currentColor) {
    

    //bound check
    if(i < 0 || i > row-1 || j < 0 || j > col-1) {
      return 0;
    }
    int brightness = 0;
    if(!visited[i][j] && currentColor == image[i][j].color) {
      visited[i][j] = true;
      brightness = image[i][j].brightness;

      brightness += findBrightness(image, row, col, i - 1, j, visited, image[i][j].color) + 
                findBrightness(image, row, col, i + 1, j, visited, image[i][j].color) + 
                findBrightness(image, row, col, i, j + 1, visited, image[i][j].color) +   // (0,1)
                findBrightness(image, row, col, i, j - 1, visited, image[i][j].color);  
    }

    return brightness;

  }
}



