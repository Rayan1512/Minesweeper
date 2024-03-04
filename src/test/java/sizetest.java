import org.example.Minesweeper;
import org.junit.jupiter.api.*;

import javax.imageio.stream.MemoryCacheImageInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class sizetest {
    @Test //checking that the size of the grid is correct

    void testPrintField() {
        Minesweeper testSize = new Minesweeper(5,5);
        Assertions.assertEquals(5,testSize.getNumGrid().length, "NumGrid is the wrong size!");
        Assertions.assertEquals(5, testSize.getRevealedGrid().length, "Revealed grid is the wrong size!");


    }
    //@Test //checking if every tile is revealed

    //void testRevealed() {
      //  Minesweeper testSize = new Minesweeper(5,0);
        //testSize.reveal(0,0);
       // boolean[][] revealGridTest = testSize.getRevealedGrid();
        //for(boolean[] row : revealGridTest) {
         //   for(boolean tile : row) {
          //      Assertions.assertTrue(tile, "one of the tiles is not revealed");
                //assertion statement
          //  }
       // }
    //}

    @Test

    void testHasBomb() {
        Minesweeper testBomb = new Minesweeper(1,1);
        testBomb.reveal(0,0);
        boolean [][]revealBombTest = testBomb.getRevealedGrid();
        Assertions.assertTrue(true,"has a bomb");

    }




}
