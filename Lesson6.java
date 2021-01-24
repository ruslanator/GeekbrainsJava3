import java.util.Arrays;

public class Lesson6 {


    public static void main(String[] args) {
        int[] arr1 = {1, 4, 6, 7, 8, 9};
        int[] arr2 = {3, 6, 8, 0};
        System.out.println(checkNumber(arr1));
        System.out.println(checkNumber(arr2));
        int[] res2 = checkArray(new int[]{1, 2, 3, 2, 5, 6, 7, 4, 5});
        System.out.println(Arrays.toString(res2));
    }

    public static int[] checkArray(int[] array) {
        if (array.length == 0) {
            return array;
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 4) {
                    int[] newArray = new int[array.length - i - 1];
                    System.arraycopy(array, i + 1, newArray, 0, array.length - i - 1);
                    return newArray;
                }
            }
            throw new RuntimeException("В массиве отсутствует число 4");
        }
    }

    public static boolean checkNumber (int[] inputArr) {
        boolean isTrue = false;
        for(int i = 0; i < inputArr.length; i++){
            if(i == 1){
                isTrue = true;
                break;
            } else {
                isTrue = false;
            }
        }
        for(int i = 0; i < inputArr.length; i++){
            if(i == 4){
                isTrue = true;
                break;
            } else {
                isTrue = false;
            }
        }
        return isTrue;
    }
}