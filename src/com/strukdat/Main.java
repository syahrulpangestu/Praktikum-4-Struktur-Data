package com.strukdat;

import java.util.Scanner;

class Stack{
    int length;
    int top = -1;
    char[] chrTmp;

    Stack(int len){
        this.length =len;
        chrTmp = new char[len];
    }

    public boolean isEmpty(){
        return (top<0);
    }

    public void push(char chr){
        if (top>=length){
            System.out.println("data melampaui batas maksimum");
        }else {
            chrTmp[++top] = chr;
        }
    }

    char pop(){
        if (isEmpty()){
            System.out.println("data sudah tampil semua");
            return 0;
        }else {
            return chrTmp[top--];
        }
    }
}

public class Main {

    public static void reverse(String str){
        int len = str.length();
        char[] chr = new char[len];
        String kata;
        Stack stack = new Stack(len);

        for (int i = 0; i < len; i++) {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < len; i++) {
            chr[i] = stack.pop();
        }
        kata = String.valueOf(chr);
        System.out.println("Reverse adalah "+ kata);

    }

    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan Kata : ");
        str = scanner.nextLine();
        reverse(str);
    }
}
