package fosalgo;

public class Titik {

    int x, y;

    public Titik(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean compare(Titik titik) {
        boolean result = false;
        if (titik.x == x && titik.y == y) {
            result = true;
        }
        return result;
    }

    public String toString() {
        String output = "(" + x + "," + y + ")";
        return output;
    }
}
