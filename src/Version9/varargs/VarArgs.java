package Version9.varargs;

public class VarArgs {

    public static void main(String[] args) {
        System.out.println(min(10, 2, 6, 8, 86, 2, 5, 62, 6, 9, 46, 1, 6, 46, 46));
        System.out.println(max(10, 2, 6, 8, 86, 2, 5, 62, 6, 9, 46, 1, 6, 46, 46));
        System.out.println("Min number: " + minMax(10, true, 2, 6, 8, 86, 2, 5, 62, 6, 9, 46, 1, 6, 46, 46));
        System.out.println("Max number: " + minMax(10, false, 2, 6, 8, 86, 2, 5, 62, 6, 9, 46, 1, 6, 46, 46));
    }

    private static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }

    private static int max(int firstArg, int... remainingArgs) {
        int max = firstArg;
        for (int arg : remainingArgs)
            if (arg > max)
                max = arg;
        return max;
    }

    private static int minMax(int firstArg, boolean min, int... remainingArgs) {
//        int minMax = firstArg;
//        for (int arg : remainingArgs) {
//            if (min) {
//                if (arg < minMax)
//                    minMax = arg;
//            } else {
//                if (arg > minMax) {
//                    minMax = arg;
//                }
//            }
//        }
//        return minMax;
        if (min) return min(firstArg, remainingArgs);
        else return max(firstArg, remainingArgs);
    }


}
