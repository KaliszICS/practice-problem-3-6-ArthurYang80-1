public class PracticeProblem {
    
    public static int searchMazeMoves(String[][] arr) {
        int startRow = arr.length - 1;
        int startCol = 0;
        
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        
        int result = dfsMoves(arr, startRow, startCol, visited);
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private static int dfsMoves(String[][] arr, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length) {
            return Integer.MAX_VALUE;
        }
        
        if (arr[row][col].equals("*")) {
            return Integer.MAX_VALUE;
        }
        
        if (arr[row][col].equals("F")) {
            return 0;
        }
        
        if (visited[row][col]) {
            return Integer.MAX_VALUE;
        }
        
        visited[row][col] = true;
        
        int up = dfsMoves(arr, row - 1, col, visited);
        int right = dfsMoves(arr, row, col + 1, visited);
        
        visited[row][col] = false;
        
        int min = Math.min(up, right);
        
        if (min == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        return min + 1;
    }
    
    public static int noOfPaths(String[][] arr) {
        int startRow = arr.length - 1;
        int startCol = 0;
        
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        
        return countPaths(arr, startRow, startCol, visited);
    }
    
    private static int countPaths(String[][] arr, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length) {
            return 0;
        }
        
        if (arr[row][col].equals("*")) {
            return 0;
        }
        
        if (arr[row][col].equals("F")) {
            return 1;
        }
        
        if (visited[row][col]) {
            return 0;
        }
        
        visited[row][col] = true;
        
        int upPaths = countPaths(arr, row - 1, col, visited);
        int rightPaths = countPaths(arr, row, col + 1, visited);
        
        visited[row][col] = false;
        
        return upPaths + rightPaths;
    }
}