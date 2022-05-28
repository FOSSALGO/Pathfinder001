package fosalgo;

import java.util.LinkedList;

public class BFS {

    public static void main(String[] args) {
        int[][] maze = {
            {-1, -1, -1, 0, 0, 0, 0, 0},
            {-1, 0, 0, 0, -1, 0, -1, 0},
            {0, 0, 1, -1, -1, 0, -1, 0},
            {0, 0, -1, 0, 0, 0, -1, -1},
            {-1, 0, 0, 0, -1, 0, 0, 0}
        };

        LinkedList<Titik> listTitik = new LinkedList<>();

        Titik start = new Titik(3, 0);
        Titik finish = new Titik(1, 7);

        listTitik.add(start);

        int step = 1;
        maze[start.x][start.y] = step;

        boolean selesai = false;

        pencarian:
        while (!selesai && !listTitik.isEmpty()) {
            Titik center = listTitik.pollFirst();
            int x = center.x;
            int y = center.y;

            step = maze[x][y];
            step++;//increment step;

            //NORT--------------------------------------------------------------
            int i = x - 1;
            int j = y;

            if (i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] == 0) {
                maze[i][j] = step;
                Titik titikBaru = new Titik(i, j);
                listTitik.add(titikBaru);
                if (finish.compare(titikBaru)) {
                    selesai = true;
                    break pencarian;
                }
            }
            //END OF NORT-------------------------------------------------------

            //EAST--------------------------------------------------------------
            i = x;
            j = y + 1;

            if (i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] == 0) {
                maze[i][j] = step;
                Titik titikBaru = new Titik(i, j);
                listTitik.add(titikBaru);
                if (finish.compare(titikBaru)) {
                    selesai = true;
                    break pencarian;
                }
            }
            //END OF EAST-------------------------------------------------------

            //SOUTH-------------------------------------------------------------
            i = x + 1;
            j = y;
            if (i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] == 0) {
                maze[i][j] = step;
                Titik titikBaru = new Titik(i, j);
                listTitik.add(titikBaru);
                if (finish.compare(titikBaru)) {
                    selesai = true;
                    break pencarian;
                }
            }
            //END OF SOUTH------------------------------------------------------

            //WEST--------------------------------------------------------------
            i = x;
            j = y - 1;

            if (i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] == 0) {
                maze[i][j] = step;
                Titik titikBaru = new Titik(i, j);
                listTitik.add(titikBaru);
                if (finish.compare(titikBaru)) {
                    selesai = true;
                    break pencarian;
                }
            }
            //END OF WEST-------------------------------------------------------

        }//End of While

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
