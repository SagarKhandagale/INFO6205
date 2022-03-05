package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class UFClient {

    public static int count(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n);
        Random random = new Random();
        int count = 0;
        while (uf.components() > 1) {
            int x = random.nextInt(n);
            int y = random.nextInt(n);
            // make sure that if x and y is connected, if is not connected then union x and y
            count++;
            uf.connect(x, y);

        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println("please enter a number from the command line （eg. 100）");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("the number of objects is " + n + ", and the number of connections is " + count(n));

        System.out.println("part 3, test the relationship between m and n");

        for (int i = 1000; i < 160000; i *= 2) {
            int sum = 0;

            for (int j = 0; j < 10; j++) {
                sum += count(i);
            }
            int avgNum = sum / 10;
            System.out.println("the number of objects is " + i + ", and the number of pairs is " + avgNum);
        }
    }
}
