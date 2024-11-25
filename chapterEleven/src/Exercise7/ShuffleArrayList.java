package Exercise7;
import java.util.ArrayList;
import java.util.Collections;
public class ShuffleArrayList {
    // Method to shuffle elements in an ArrayList of integers
    public static void shuffle(ArrayList<Integer> list) {
        Collections.shuffle(list);
    }

    public static void main(String[] args) {
        // Create an ArrayList with some integer values
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i); // Add integers 1 to 10
        }

        // Display original list
        System.out.println("Original list: " + list);

        // Shuffle the list
        shuffle(list);

        // Display shuffled list
        System.out.println("Shuffled list: " + list);
    }
}
