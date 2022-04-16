package cn.tangt.com.test7;

import java.util.Scanner;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Test
 * @description : Queue
 * @date : 2022/4/15
 */
public class Queue {
    private int[] element;
    public int size;    // 元素个数
    public int qSize;   // 队列长度

    public Queue() {
        this.element = new int[8];
        this.qSize = 8;
        this.size = 0;
    }

    public void enqueue(int v) {
        if (this.size >= this.qSize) {
            int[] array = new int[this.size * 2];
            System.arraycopy(element, 0, array, 0, this.size);
            this.element = array;
        }
        this.element[this.size++] = v;
    }

    public int dequeue() {
        int temp = this.element[0];
        if (this.size > 1) {
            System.arraycopy(this.element, 1, this.element, 0, size - 1);
        }
        this.size--;
        return temp;
    }

    public boolean empty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }
}

class Array {
    public static void main(String[] args) {
        Queue que = new Queue();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int number = in.nextInt();
        int temp = number;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            while (number % i == 0) {
                que.enqueue(i);
                number /= i;
            }
        }
        if (number > 1) que.enqueue(number);
        System.out.println("The factors for " + temp + " is");
        while (!que.empty()) {
            System.out.print(que.dequeue() + " ");
        }
    }
}