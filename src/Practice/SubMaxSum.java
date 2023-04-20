package Practice;

import java.util.Arrays;

public class SubMaxSum {
    public static void main(String[] args) {

        // 求出下列数组的最大子序列（连续）和
        int[] arr = {-2, 11, -4, 13, -5, -2};

        System.out.println(Arrays.toString(arr));
        System.out.println("数组最大值为：" + getMax(arr));
        System.out.println("数组最小值为：" + getMin(arr));

















        // 定义两个指针
        int index1 = 0;
        int index2 = 0;

        // 保证从正数开始累加
        while (arr[index1] <= 0) {
            if (index1 == arr.length - 1) {
                break;
            }
            index1++;
            index2++;
        }

        int sum1 = 0;
        int sum2 = 0;
        int max = 0;
        while (index1 < arr.length) {
            while (index2 < arr.length) {
                sum1 += arr[index2++];
                if (sum1 > sum2) {
                    sum2 = sum1;
                }
            }
            if (sum2 > max) {
                max = sum2;
            }
            sum1 = 0;
            index2 = ++index1;
        }

        // 如果max等于0，说明数组内元素均为负数
        if (max == 0) {
            max = getMax(arr);
        }

        System.out.println("--------------------------------");
        System.out.print("最大子序列和为：" + max);

    }

    // 求最大值
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // 求最小值
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}