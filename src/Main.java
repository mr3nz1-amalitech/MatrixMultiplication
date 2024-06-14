import java.util.Scanner;

public class Main {
    //    go through the row line from the console and extract values, parse them to string and populate them into an array that is returned
    int[] getRow(String ln) {
        try {
            String[] numStr = ln.split(" ");
            int[] nums = new int[numStr.length];
            for (int i = 0; i < numStr.length; i++) {
                nums[i] = Integer.parseInt(numStr[i]);
            }
            return nums;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //    get input of the lines that start with Matrix and get the specified dimensions
    int[] getMatrixDims(String str) {
        try {
            String[] dimsAsStr = str.substring(str.lastIndexOf("x") + 5, str.length()).trim().split(",");
            int[] dims = new int[2];
            dims[0] = Integer.parseInt(dimsAsStr[0]);
            dims[1] = Integer.parseInt(dimsAsStr[1]);
            return dims;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //    append each row of the arr and populate them into the a StringBuilder object, which is used to formulate the string
    String renderMat(int[][] arr) {
        try {
            StringBuilder str = new StringBuilder();

            for (int i = 0; i < arr.length; i++) {
                str.append("|");
                for (int j = 0; j < arr[i].length; j++) {
                    str.append(" ");
                    str.append(arr[i][j]);
                    str.append(" ");
                }
                str.append("|\n");
            }

            return str.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //    go over first matrix rows and multiply them to the second matrix colum values
    int[][] multiplyMat(int[][] mat1, int[][] mat2) {
        try {

            int[][] ansMat = new int[mat1.length][mat2[0].length];

            for (int i = 0; i < mat1.length; i++) {
                for (int j = 0; j < mat2[0].length; j++) {
                    ansMat[i][j] = 0;
                    for (int k = 0; k < mat1[0].length; k++) {
                        ansMat[i][j] += mat1[i][k] * mat2[k][j];
                    }
                }
            }

            return ansMat;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Main obj = new Main();
            String ln = scanner.nextLine().toLowerCase();

//        extract matrix 1 dimensions from the console
            int[] mat1Dims = new int[2];
            mat1Dims = obj.getMatrixDims(ln);

//        extract matrix 1 rows from the console
            int[][] mat1 = new int[mat1Dims[0]][mat1Dims[1]];
            for (int i = 0; i < mat1.length; i++) {
                mat1[i] = obj.getRow(scanner.nextLine());
            }

            String x = scanner.nextLine();
            ln = scanner.nextLine().toLowerCase();

//        extract matrix 1 dimensions from the console
            int[] mat2Dims = new int[2];
            mat2Dims = obj.getMatrixDims(ln);

//        extract matrix 2 rows from the console
            int[][] mat2 = new int[mat2Dims[0]][mat2Dims[1]];
            for (int i = 0; i < mat2.length; i++) {
                mat2[i] = obj.getRow(scanner.nextLine());
            }

//        render the answer from multiplyMat method to the console
            if (mat1Dims[1] == mat2Dims[0]) {
                System.out.println("\nMatrix C: \n");
                System.out.println(obj.renderMat(obj.multiplyMat(mat1, mat2)));
            }
        } catch (RuntimeException e) {
            System.out.println("Ensure everything is well structured");
        }
    }
}
