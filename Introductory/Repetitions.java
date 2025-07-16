// package Introductory;

import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int ans = 0;
        int cnt = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) == s.charAt(i))
                cnt++;
            else{
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
        }
        ans = Math.max(ans, cnt);

        System.out.println(ans);
    }
}
