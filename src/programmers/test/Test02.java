package programmers.test;

import java.util.Arrays;

public class Test02 {
    public static void main(String[] args) {
        Test02 sol = new Test02();
        int n = 7;
        int[] price = { 0, 2, 1, 1, 2, 3, 4 };
        System.out.println(sol.solution(n, price));
    }

    public int solution(int n, int[] price) {
        int money = 0;
        int stone = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                money += price[i] * stone;
                break;
            }

            int[] copy = Arrays.copyOfRange(price, i + 1, price.length);
            Arrays.sort(copy);
            int minPrice = copy[0];
            int maxPrice = copy[copy.length - 1];

            if (price[i] == 0) {
                stone++;
                continue;
            } else if (money > 0 && money >= price[i]) {
                if (maxPrice > price[i] && minPrice >= price[i]) {
                    stone++;
                    money -= price[i];
                    continue;
                }
            }

            boolean isSell = false;
            if (stone > 0 && price[i] >= maxPrice) {
                isSell = true;
            } else if (stone > 0 && price[i] > minPrice) {
                isSell = true;
            }

            if (isSell) {
                money += price[i] * stone;
                stone = 0;
            }
        }

        return money;
    }
}
