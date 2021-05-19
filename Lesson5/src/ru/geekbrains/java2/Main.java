package ru.geekbrains.java2;

public class Main {

    public static void main(String[] args) {
        metod1();
        metod2();
    }
    public static void metod1() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println((System.currentTimeMillis() - a) + " Однопоточный метод");

    }

    public static void metod2() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread thread = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                calculation(a1, i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                calculation(a2, i);
            }
        });

        thread.start();
        thread2.start();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.currentTimeMillis();
        System.out.println((System.currentTimeMillis() - a) + " Двухпоточный метод");

    }

public static float[] calculation(float[] a, int i) {
        a[i] = (float)(a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        return a;
}

}

