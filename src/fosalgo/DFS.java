package fosalgo;
import java.util.Stack;

public class DFS {

    public static void main(String[] args) {
        // Buat Array 2D
        int[][] maze = {
            {-1, -1, -1, 0, 0, 0, 0, 0},
            {-1, 0, 0, 0, -1, 0, -1, 0},
            {0, 0, 1, -1, -1, 0, -1, 0},
            {0, 0, -1, 0, 0, 0, -1, -1},
            {-1, 0, 0, 0, -1, 0, 0, 0}
        };
        
        // Cetak Maze 
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + "\t");
            }
            System.out.println();
        }
        
        // Buat Kelas Titik

        // Buat Stack
        Stack<Titik> jejak = new Stack<>();
        // Tentukan Titik Start
        int step = 1;
        Titik start = new Titik(3, 0);
        maze[start.x][start.y] = step;
        jejak.add(start);

        // Menentukan Titik Finish
        Titik finish = new Titik(1, 7);

        // Menentukan Arah
        int arah = 0; // 0 = Utara, 1 = Timur, 2 = Selatan, 3 = Barat

        // Memulai Pencariadn DFS
        while (!jejak.isEmpty()) {
            Titik center = jejak.peek();
            int x = center.x;
            int y = center.y;
            
            //Cek Titik Finish
            if (x == finish.x && y == finish.y) {
                System.out.println("Pencarianpun Berakhir Karna Ku Tlah Temukan Dirimu");
                break;
            }

            // Identifikasi Titik Depan Kanan & Kiri
            Titik depan = null;
            Titik kanan = null;
            Titik kiri = null;
            Titik belakang = null;

            if (arah == 0) {
                depan = new Titik(x - 1, y);
                kanan = new Titik(x, y + 1);
                kiri = new Titik(x, y - 1);
                belakang = new Titik(x + 1, y);
            } else if (arah == 1) {
                depan = new Titik(x, y + 1);
                kanan = new Titik(x + 1, y);
                kiri = new Titik(x - 1, y);
                belakang = new Titik(x, y - 1);
            } else if (arah == 2) {
                depan = new Titik(x + 1, y);
                kanan = new Titik(x, y - 1);
                kiri = new Titik(x, y + 1);
                belakang = new Titik(x - 1, y);
            } else if (arah == 3) {
                depan = new Titik(x, y - 1);
                kanan = new Titik(x - 1, y);
                kiri = new Titik(x + 1, y);
                belakang = new Titik(x, y + 1);
            }

            // Check apakah Bisa Maju
            if (depan != null && depan.x >= 0 && depan.x < maze.length && depan.y >= 0 && depan.y < maze[0].length && maze[depan.x][depan.y] == 0) {
                step++;
                maze[depan.x][depan.y] = step;
                jejak.add(depan);
            } else if (kanan != null && kanan.x >= 0 && kanan.x < maze.length && kanan.y >= 0 && kanan.y < maze[0].length && maze[kanan.x][kanan.y] == 0) {
                step++;
                maze[kanan.x][kanan.y] = step;
                jejak.add(kanan);
                arah = (arah + 1) % 4;
            } else if (kiri != null && kiri.x >= 0 && kiri.x < maze.length && kiri.y >= 0 && kiri.y < maze[0].length && maze[kiri.x][kiri.y] == 0) {
                step++;
                maze[kiri.x][kiri.y] = step;
                jejak.add(kiri);
                arah = (arah + 3) % 4;
            } else if (belakang != null && belakang.x >= 0 && belakang.x < maze.length && belakang.y >= 0 && belakang.y < maze[0].length && maze[belakang.x][belakang.y] == 0) {
                step++;
                maze[belakang.x][belakang.y] = step;
                jejak.add(belakang);
                arah = (arah + 2) % 4;
            } else {
                step--;
                maze[x][y] = -2;
                jejak.pop();
            }
        }//END OF while (!jejak.isEmpty()) 

        // Cetak Maze 
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
