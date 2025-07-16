import java.util.*;

class flightDiscount{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
        for(int i=0; i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<e; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(new long[]{w, v});
        }

        long ans = solve(n, adj);

        System.out.println(ans/2);


        sc.close();

    }

    public static long solve(int n,  ArrayList<ArrayList<long[]>> adj){

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        long parent[] = new long[n+1];
        parent[1] = 1;
        long dist[] = new long[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        long max = 0;

        pq.add(new long[]{0,1});

        while(!pq.isEmpty()){
            long[] top = pq.poll();

            for(long[] neighbour : adj.get((int)top[1])){
                if(top[0]+neighbour[0] < dist[(int)neighbour[1]]){
                    max = Math.max(max, neighbour[0]);
                    dist[(int)neighbour[1]] = top[0]+neighbour[0];
                    parent[(int)neighbour[1]] = top[1];
                    pq.add(new long[]{neighbour[0]+top[0], neighbour[1]});
                }
            }

        }

        int i = n;
        while(parent[i] != i){
            System.out.print(i +"  > ");
            i = (int)parent[i];
        }

        System.out.println();

        return dist[n];



    }
}