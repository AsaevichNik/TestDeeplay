package org.example;

import java.util.*;

public class Main {
    public static void firstTask() {
        Integer[] array = new Integer[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }

        array[5] = 0;
        array[8] = 0;
        array[11] = 0;

        System.out.println(Arrays.toString(array));

        Arrays.sort(array);
        int[] tempArray = new int[array.length];
        int oddIndex = 0;
        int evenIndex = array.length - 1;

        for (int value : array) {
            if (value % 2 != 0 && value != 0) {
                tempArray[oddIndex] = value;
                oddIndex++;
            } else if (value == 0) {
                continue;
            } else {
                tempArray[evenIndex] = value;
                evenIndex--;
            }
        }
        System.out.println(Arrays.toString(tempArray));

    }

    public static void secondTask() {
        int[] array = {1, 2, 3, 1, 4, 5, 5, 1, 6, 5, 7, 8, 8, 8, 9};
        int[] tempArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    tempArray[i]++;
                }
            }
        }

        int maxValue = tempArray[0];
        for (int i = 1; i < tempArray.length; i++) {
            if (tempArray[i] > maxValue) {
                maxValue = tempArray[i];
            }
        }
        HashSet<Integer> elem = new HashSet<>();
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] == maxValue) {
                elem.add(array[i]);
            }
        }
        System.out.println(elem.toString());
    }

    public static void thirdTask() {
        Random random = new Random();
        List<Integer> player1Sequence = new ArrayList<>(3);
        List<Integer> player2Sequence = new ArrayList<>(3);

        Collections.addAll(player1Sequence, 4, 4, 4);
        Collections.addAll(player2Sequence, 4, 2, 4);

        int numberOfThrows = 100000;
        int numberOfTests = 1000;
        ArrayList<Integer> dices = new ArrayList<>(numberOfThrows);

        int player1Wins = 0;
        int player2Wins = 0;
        int draws = 0;
        int player1Points = 0;
        int player2Points = 0;


        for (int i = 0; i < numberOfTests; i++) {
            for (int j = 0; j < numberOfThrows; j++) {
                dices.add((int) (Math.random() * 6 + 1));
            }
            //System.out.println(dices.toString());

            int sequenceLength = player1Sequence.size();
            int arrayLength = dices.size();

            for (int j = 0; j <= arrayLength - sequenceLength; j++) {
                boolean isSubsequence = true;
                for (int k = 0; k < sequenceLength; k++) {
                    if (!dices.get(j + k).equals(player1Sequence.get(k))) {
                        isSubsequence = false;
                        break;
                    }
                }
                if (isSubsequence) {
                    player1Points++;
                    j += sequenceLength - 1; // Пропустить уже найденную подпоследовательность
                }
            }

            for (int j = 0; j <= arrayLength - sequenceLength; j++) {
                boolean isSubsequence = true;
                for (int k = 0; k < sequenceLength; k++) {
                    if (!dices.get(j + k).equals(player2Sequence.get(k))) {
                        isSubsequence = false;
                        break;
                    }
                }
                if (isSubsequence) {
                    player2Points++;
                    j += sequenceLength - 1; // Пропустить уже найденную подпоследовательность
                }
            }

            if (player1Points > player2Points) {
                player1Wins++;
            } else if (player2Points > player1Points) {
                player2Wins++;
            } else {
                draws++;
            }
            player1Points = 0;
            player2Points = 0;
            dices.clear();
        }

        double player1WinProbability = (double) player1Wins / numberOfTests;
        double player2WinProbability = (double) player2Wins / numberOfTests;
        double drawProbability = (double) draws / numberOfTests;

        System.out.println("Вероятность победы игрока 1: " + player1WinProbability);
        System.out.println("Вероятность победы игрока 2: " + player2WinProbability);
        System.out.println("Вероятность ничьей: " + drawProbability);
    }

    //for task 4
    public static int fact(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
        //firstTask();
        //secondTask();
        //thirdTask();
    }
}





