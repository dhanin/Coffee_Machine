import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }
        int max = arr[0] * arr[1];
        int temp = 0;
        for (int i = 2; i < num; i++) {
            temp = arr[i] * arr[i - 1];
            max = max > temp ? max : temp;
        }
        System.out.println(max);
    }
}