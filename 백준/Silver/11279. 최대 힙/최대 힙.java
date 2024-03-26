import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] heapArr;
    static int size;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int capacity = Integer.parseInt(br.readLine());
        heapArr = new int[capacity];

        for(int i=0; i<capacity; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                sb.append(delete());
                sb.append('\n');
                continue;
            }
            insert(num);
        }

        System.out.println(sb);

    }
    // 힙에서 최대 요소(루트) 삭제
    public static int delete() {
        if (size == 0) {
            return 0;
        }

        int removedItem = heapArr[0]; // 최대 요소 저장
        heapArr[0] = heapArr[size - 1]; // 마지막 요소를 루트로 이동
        size--; // 힙 크기 감소

        fixDown(0); // 힙 속성 유지를 위해 아래로 조정

        return removedItem; // 삭제된 요소 반환
    }

    // 루트 노드에서 아래로 조정하는 메소드
    private static void fixDown(int index) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        // 왼쪽 노드와 오른쪽 노드를 부모 노드와 비교하여 최대값을 가진 노드 체크
        
        if (leftChild < size && heapArr[leftChild] > heapArr[largest]) {
            largest = leftChild;
        }

        if (rightChild < size && heapArr[rightChild] > heapArr[largest]) {
            largest = rightChild;
        }

        // 자식 노드 둘 중 하나의 값이 부모의 값 보다 크다면 부모와 switch
        if (largest != index) {
            swap(index, largest);
            fixDown(largest);
        }
    }

    public static void insert(int value) {
        // full 힙에 insert 시, 예외처리
        if (size == heapArr.length) {
            throw new IndexOutOfBoundsException("heapArr is full");
        }

        heapArr[size] = value;
        fixUp(size);
        size++;
    }

    private static void fixUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (index > 0 && heapArr[index] > heapArr[parentIndex]) {
            swap(index, parentIndex);
            fixUp(parentIndex);
        }
    }

    private static void swap(int index1, int index2) {
        int temp = heapArr[index1];
        heapArr[index1] = heapArr[index2];
        heapArr[index2] = temp;
    }
}
