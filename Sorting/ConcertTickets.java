import java.io.*;
import java.util.*;

public class ConcertTickets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // number of tickets
        int m = Integer.parseInt(st.nextToken()); // number of customers

        TreeMap<Integer, Integer> tickets = new TreeMap<>();

        // Read ticket prices
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int price = Integer.parseInt(st.nextToken());
            tickets.put(price, tickets.getOrDefault(price, 0) + 1);
        }

        // Read customer offers and process
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int customer = Integer.parseInt(st.nextToken());
            Integer ticket = tickets.floorKey(customer); // max ticket <= customer offer

            if (ticket == null) {
                System.out.println(-1);
            } else {
                System.out.println(ticket);
                if (tickets.get(ticket) == 1) {
                    tickets.remove(ticket);
                } else {
                    tickets.put(ticket, tickets.get(ticket) - 1);
                }
            }
        }
    }
}
