import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Exercise2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner kb = new Scanner(System.in);

        int count = 0;
        int v0;
        int v1;
        File file = new File("f.txt");
        Scanner inputFile = new Scanner(file);

        count = inputFile.nextInt();
        int[][] adj = new int[count][count];;

        while (inputFile.hasNext()) {

         v0 = inputFile.next().charAt(0)-65;
         v1 = inputFile.next().charAt(0)-65;

         adj[v0][v1] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        int[] pred = new int[adj.length];

        for(int i=0; i< adj.length; i++) {
            for (int j=0; j< adj.length; j++) {
                if (adj[j][i] == 1) {
                    pred[i]++;
                }
            }
        }

        for(int i=0; i< adj.length; i++) {
                if (pred[i] == 0) {
                    queue.add(i);
                }
        }

        // Create a vector to store result
        // (A topological ordering of the vertices)
        ArrayList<Integer> topNum = new ArrayList<>();

        while (!queue.isEmpty()) {
            // Extract front of queue
            // (or perform dequeue)
            // and add it to topological order
            int u = queue.remove();
            topNum.add(u);

            for(int i=0;i< adj.length;i++) {
                if (adj[u][i] == 1) {
                    if (--pred[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }

        for(int i: topNum) {
            System.out.print((char)('A'+ i)+" ");
        }
    }
}
