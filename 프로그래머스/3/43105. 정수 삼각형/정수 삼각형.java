class Solution {
    public int solution(int[][] triangle) {
        // 원본 보존을 위해 배열 복사
        int[][] copy_triangle = new int[triangle.length][triangle.length];

        // 배열 복사본 초기화
        for(int i=0; i<triangle.length; i++){
            copy_triangle[i] = triangle[i].clone();
        }

        // 마지막 줄부터 계산
        for(int i=copy_triangle.length-1; i>0; i--){
            // 1번째 값부터 마지막 값까지 두 값중 큰 값과 윗 줄의 값을 합산한 결과를 저장 (DP)
            for(int j=0; j<copy_triangle[i].length-1; j++){
                copy_triangle[i-1][j] += Math.max(copy_triangle[i][j], copy_triangle[i][j+1]);
            }
        }

        // 가장 최상단에는 가장 큰 값이 더해진 결과가 저장되어 남게 된다.
        return copy_triangle[0][0];
    }
}