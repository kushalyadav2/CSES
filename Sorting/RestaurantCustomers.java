// // package Sorting;

import java.util.*;

public class RestaurantCustomers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (a,b) -> a[0]-b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int ans = 0;
        
        for(int i=0; i<n; i++){
            while(!pq.isEmpty() && pq.peek() < arr[i][0]){
                pq.poll();
            }
            pq.add(arr[i][1]);

            ans = Math.max(ans, pq.size());
        }

        System.out.println(ans);

        sc.close();
    }
}

// import java.io.*;
// import java.util.*;

// public class RestaurantCustomers {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//         int n = Integer.parseInt(br.readLine());
//         List<int[]> events = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             int arrival = Integer.parseInt(st.nextToken());
//             int departure = Integer.parseInt(st.nextToken());
            
//             events.add(new int[]{arrival, 1});   // arrival = +1 customer
//             events.add(new int[]{departure, -1}); // departure = -1 customer
//         }

//         // Sort by time; if times are equal, departures should come before arrivals
//         events.sort((a, b) -> {
//             if (a[0] != b[0])
//                 return Integer.compare(a[0], b[0]);
//             return Integer.compare(a[1], b[1]); // departure (-1) before arrival (+1)
//         });

//         int current = 0;
//         int maxCustomers = 0;

//         for (int[] event : events) {
//             current += event[1];
//             maxCustomers = Math.max(maxCustomers, current);
//         }

//         System.out.println(maxCustomers);
//     }
// }
