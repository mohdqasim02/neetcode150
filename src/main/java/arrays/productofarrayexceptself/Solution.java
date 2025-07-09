package arrays.productofarrayexceptself;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int[] leftProduct = getLeftProduct(nums);
        int[] rightProduct = getRightProduct(nums);

        for (int index = 0; index < nums.length; index++) {
            product[index] = leftProduct[index] * rightProduct[index];
        }

        return product;
    }

    private static int[] getLeftProduct(int[] nums) {
        int[] product = new int[nums.length];

        product[0] = 1;

        for (int index = 1; index < nums.length; index++) {
            product[index] = product[index - 1] * nums[index - 1];
        }

        return product;
    }

    private static int[] getRightProduct(int[] nums) {
        int[] product = new int[nums.length];

        product[nums.length - 1] = 1;

        for (int index = nums.length - 2; index >= 0; index--) {
            product[index] = product[index + 1] * nums[index + 1];
        }

        return product;
    }
}


