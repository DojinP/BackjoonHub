import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input_time = Integer.parseInt(sc.nextLine());

        Stack stack = new Stack(input_time);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<input_time; i++){
            String[] method_type = sc.nextLine().split(" ");

            switch (method_type[0]){
                case "push" :
                    int val = Integer.parseInt(method_type[1]);
                    stack.push(val);
                    break;
                case "top" :
                    sb.append(stack.peek() + "\n");
                    break;
                case "size" :
                    sb.append(stack.getSize() + "\n");
                    break;
                case "empty" :
                    sb.append(stack.isEmpty() + "\n");
                    break;
                case "pop" :
                    sb.append(stack.pop() + "\n");
                    break;
            }
        }

        System.out.println(sb);

    }

    public static class Stack {
        int top;
        int capacity;
        int[] array;

        Stack(int capacity){
            this.top = 0;
            this.capacity = capacity;
            this.array = new int[capacity];
        }

        public boolean isFull(){
            return this.top == this.capacity-1;
        }

        public void push(int val){
            if(isFull()){
                this.capacity *= 2;
                int[] new_array = new int[this.capacity];

                for(int i=0; i<this.array.length; i++){
                    new_array[i] = this.array[i];
                }

                this.array = new_array;
            }

            this.array[this.top] = val;
            this.top++;

        }

        public int peek(){
            if(this.top == 0) return -1;
            return this.array[this.top-1];
        }

        public int getSize(){
            return this.top;
        }

        public int isEmpty(){
            return this.top == 0 ? 1 : 0;
        }

        public int pop(){
            if(this.top == 0) return -1;

            int val = this.array[this.top-1];
            this.array[this.top-1] = 0;
            top--;

            return val;
        }
    } 

}
