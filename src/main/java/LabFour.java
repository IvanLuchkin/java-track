import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LabFour {

    public static void main(String[] args) {
        List<Integer> list = generateArrayList();
        Collections.sort(list);
        System.out.println("Generated collection: " + list);
        int value = inputValue();
        System.out.println("Furthest value: " + getFurthestValue(list, value));
    }

    private static int getFurthestValue(List<Integer> list, int value) {
        int biggestDiff = Math.abs(list.get(0) - value);
        int nearestIndex = 0;

        for (int i = 1; i < list.size(); i++) {
            int currentDifference = Math.abs(list.get(i) - value);
            if (biggestDiff < currentDifference) {
                biggestDiff = currentDifference;
                nearestIndex = i;
            }
        }
        return list.get(nearestIndex);
    }

    private static int inputValue() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Print value");
            if (input.hasNextInt()) {
                return input.nextInt();
            } else {
                System.out.println("Wrong input");
                input.nextLine();
            }
        }
    }

    private static List<Integer> generateArrayList() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 15; i++) {
            list.add((int) (Math.random() * 100));
        }
        return list;
    }
}