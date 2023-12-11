import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyQueue queue = new MyQueue(1000000);

        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++){
            queue.push(i);
        }

        while(queue.size() != 1){
            queue.pop();
            int temp = queue.pop();
            queue.push(temp);
        }

        System.out.println(queue.pop());
    }
}

class MyQueue {
    private int[] array;
    private int array_size;
    private int front;
    private int rear;


    public MyQueue(){
        array_size = 100001;
        array = new int[array_size];
        front = 0;
        rear = 0;
    }

    public MyQueue(int size){
        array_size = size+1;
        array = new int[array_size];
        front = 0;
        rear = 0;
    }

    public int isEmpty() {
        return front == rear ? 1 : 0;
    }

    public int isFull() {
        return rear - front == array_size ? 1 : 0;
    }

    public void push(int val){
        if(isFull() != 1) {
            array[rear++] = val;
            return;
        }
        System.out.println("큐가 가득 참");
    }

    public int pop() {
        if(isEmpty() != 1) {
            int ret = array[front];
            array[front] = 0;
            front++;
            return ret;
        }
        return -1;
    }

    public int front() {
        if(isEmpty() == 1)
            return -1;

        return array[front];
    }

    public int back() {
        if(isEmpty() == 1)
            return -1;

        return array[rear-1];
    }

    public int size() {
        return rear - front;
    }

    public int getArray_size() {
        return array_size;
    }
}