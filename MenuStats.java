import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class MenuStats {
    public Menu() {
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
        float answer = action(len, int[] dataSet, selection);
        System.out.println("-------------------------\n");
        System.out.println("Your answer is:" + answer);
    }
    public float action(len, int[] dataSet, selection) {
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
                if (len % 2 == 0) {
                    temp = dataSet[temp] - dataSet[temp - 1];
                    temp = temp / 2;
                    value = temp;
                } else {
                    temp = Math.round(temp);
                    temp = temp - 1;
                    value = dataSet[temp];
                }
            break;

            case 2: //mode
                int i, j, z, tmp, maxCount, modeValue;
                int[] tally=new int[num_value];
                for(i = 0; i < num_value; i++) {
                    for(j = 0; j < num_value - i; j++) {
                        if(j+1 != num_value) {
                            if(invalue[j]>invalue[j+1]) {
                                tmp=invalue[j];
                                invalue[j]=invalue[j+1];
                                invalue[j+1]=tmp;
                            }
                        }
                    }
                }
                for (i = 0; i < num_value; i++) {
                    for(z=i+1;z<num_value;z++) {
                        if(invalue[i]==invalue[z]) {
                            tally[i]++;
                        }
                    }
                }
                maxCount = 0;
                modeValue = 0;
                for (i = 0; i <num_value; i++) {
                    if (tally[i] > maxCount) {
                        maxCount = tally[i];
                        modeValue = invalue[i];
                    }
                }
                value = modeValue;
            break;

            case 3: //range
                temp = len - 1;
                value = dataSet[temp] - dataSet[0];
            break;
        }
        return value;
    }
    public static void main(String[] args) {
        new MenuStats();
    }
}