import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input_time = Integer.parseInt(br.readLine());
        MyQueue queue = new MyQueue(2000000);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<input_time; i++) {
            String[] tokens = br.readLine().split(" ");

            switch(tokens[0]){
                case "push" :
                    queue.push(Integer.parseInt(tokens[1]));
                    break;

                case "pop" :
                    sb.append(queue.pop());
                    if(i != input_time-1) sb.append('\n');
                    break;

                case "size" :
                    sb.append(queue.size());
                    if(i != input_time-1) sb.append('\n');
                    break;

                case "empty" :
                    sb.append(queue.isEmpty());
                    if(i != input_time-1) sb.append('\n');
                    break;

                case "front" :
                    sb.append(queue.front());
                    if(i != input_time-1) sb.append('\n');
                    break;

                case "back" :
                    sb.append(queue.back());
                    if(i != input_time-1) sb.append('\n');
                    break;

                default:
                    break;
            }
        }
        System.out.print(sb);
    }

    static class MyQueue {
        private int[] array;
        private int array_size;
        private int front;
        private int rear;

        public MyQueue(){
            array_size = 10;
            array = new int[array_size];
            front = 0;
            rear = 0;
        }

        public MyQueue(int size){
            array_size = size;
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
    }
}
