package com.strukdat;

import java.util.Locale;
import java.util.Scanner;

class Queue<T> {
    Node front = null;
    Node rear = null;
    int size = 0;

    private class Node {
        T data;
        Node next;
    }

    public void enqueue(T data) {
        Node prevData = rear;
        rear = new Node();
        rear.data = data;
        if (isEmty()) {
            front = rear;
        } else {
            prevData.next = rear;
        }
        size++;
    }

    public T dequeue() {
        if (isEmty()) {
            return null;
        }
        T data = front.data;
        if (front == rear) {
            rear = rear.next;
        }
        front = front.next;
        size--;
        return data;
    }

    public T peek() {
        return front.data;
    }

    public void showAll() {
        int number = 1;
        Node current = front;
        while (current != null) {
            System.out.println(number + ". " + current.data);
            current = current.next;
            number++;
        }
    }

    public boolean isEmty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}

public class kegiatanDua {
    public static void main(String[] args) {
        String data, nama, confirm;
        Scanner scanner = new Scanner(System.in);
        Queue<String> queue = new Queue<>();
        queue.enqueue("Budi Sudarsono");
        queue.enqueue("Pacho Kenmogne");
        queue.enqueue("Eduard Ivakdalam");
        queue.enqueue("Feri Rotinsulu");
        queue.enqueue("Alexander Pulalo");
        do {
            System.out.println("Daftar Antrian Praktikum");
            queue.showAll();
            System.out.print("Masukan Keyword selesai/tambah/total/next : ");
            data = scanner.nextLine();
            if (data.toLowerCase(Locale.ROOT).contains("tambah")) {
                System.out.print("Masukan Nama : ");
                nama = scanner.nextLine();
                queue.enqueue(nama);
            } else if (data.toLowerCase(Locale.ROOT).equals("selesai")) {
                System.out.println(queue.dequeue());
            } else if (data.toLowerCase(Locale.ROOT).equals("total")) {
                System.out.println(queue.size());
            } else if (data.toLowerCase(Locale.ROOT).equals("next")) {
                System.out.println(queue.peek());
            }
            System.out.println("apakah ingin lanjut? y/n");
            confirm = scanner.nextLine();
            if (confirm.toLowerCase(Locale.ROOT).equals("n")){
                System.exit(0);
            }
        } while (confirm.toLowerCase(Locale.ROOT).equals("y"));
    }
}
