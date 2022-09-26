package com.company;

public class Main {
    public static void main(String[] args) {

        Create egg  = (new Create("Яйцо ")); // Создание потока
        Create Chicken = (new Create("Курица "));

        try {
            egg .thread.join();                // Ждет когда будет последним сказано слово "Курица"
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("Первым появилось:");
        if (Chicken.thread.isAlive()){         //возвращает true, если поток активен (будет ждять
            System.out.print(" Яйцо");
        }else{
            System.out.print(" Курица");
        }
    }
}
class Create extends Thread {
    Thread thread;
    public Create(String name) {
        thread = new Thread(this, name);
        thread.start();
    }
    public void run() {                     //Этот метод будет выполняться в побочном потоке
        for (int i = 0; i < 3; i++) {

            try {
                Thread.sleep(300);    //Приостанавливает поток на 3 секунду
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName());

        }
    }
}