import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class MenuStats {
    public MenuStats() {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is a console menu that you can use to calculate");
        System.out.println("the mean, median, mode, or range of a data set.");
        System.out.println("-------------------------\n");
        System.out.println("How many numbers are in your data set?");
        System.out.println("-------------------------\n");
        len = sc.nextInt();
        int[] dataSet;
        for (int i = 0; i < len; i++) {
            dataSet[i] = sc.nextInt();
        }
        System.out.println("Your data set, in ascending order:");
        Arrays.sort(dataSet);
        int temp = len - 1;
        for (int i = 0; i < len; i++) {
            if (i != temp) {
                System.out.print(dataSet[i] + ", ");
            } else {
                System.out.print(dataSet[i]);
            }
        }
        System.out.println("-------------------------\n");
        System.out.println("Now, choose from the following:");
        System.out.println("0 - Mean");
        System.out.println("1 - Median");
        System.out.println("2 - Mode");
        System.out.println("3 - Range");
    }
    private float action(len, int[] dataSet, selection) {
        float value = 0;
        float temp = 0;
        switch (selection) {
            case 0: //mean
                for (int i = 0; i < len; i++) {
                    value = value + dataSet[i];
                }
                value = value / len;
            break;

            case 1: //median
                temp = len / 2;

            break;

            case 2: //mode

            break;

            case 3: //range
                temp = len - 1;
                value = dataSet[temp] - dataSet[0];
            break;
        }
        return value;
    }
}