package com.naresh.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {

        Comparator<String> queueComparator = new VowelComparator();

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(10);

        priorityQueue.add("orange");
        priorityQueue.add("fig");
        priorityQueue.add("watermelon");
        priorityQueue.add("lemon");

        while (priorityQueue.size() != 0) {
            System.out.println(priorityQueue.remove());
        }

        System.out.println("Queue Size : " + priorityQueue.size());

    }

    static class VowelComparator implements Comparator<String> {

        @Override
        public int compare(String x, String y) {
            if (getVowelCount(x) < getVowelCount(y)) {
                return 1;
            } else if (getVowelCount(x) > getVowelCount(y)) {
                return -1;
            }
            return 0;
        }

        public int getVowelCount(String word) {
            int vowel = 0;
            for (int i = 0; i < word.length(); i++) {
                char chr = word.charAt(i);
                if (chr == 'a' || chr == 'A' || chr == 'e' || chr == 'E'
                        || chr == 'i' || chr == 'I' || chr == 'o' || chr == 'O'
                        || chr == 'u' || chr == 'U')
                    vowel++;
            }
            return vowel;
        }
    }

}
