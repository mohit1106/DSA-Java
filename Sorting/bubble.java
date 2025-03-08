public class bubble {

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 3, 2};
        int n = arr.length;

        for (int turn = 0; turn <= n-2; turn++) {
            for (int j = 0; j <= n-2-turn; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}