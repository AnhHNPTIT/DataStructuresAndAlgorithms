package class59;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoang
 */
public class BalancedCourseAssignment {
    static int m; // so giao vien
    static int n; // so khoa hoc
    int[] x; // giao vien x[i] day khoa hoc i
    static boolean[][] conflict= new boolean[10][10]; // khoa hoc i va j xung dot 
    static boolean[][] teach= new boolean[5][10]; // giao vien t day khoa hoc i
    int[] cnt; // dem giao vien day so khoa hoc
    int cnt_x; // dem so cach sap xep
    int[] max; // max khoa hoc duoc day boi 1 giao vien
    int f_max; // max load
    private boolean check(int t, int i){
        if(!teach[t][i]) return false; // giao vien t khong day khoa hoc i
        else {
            for(int j = 1; j < i; j++){ // kiem tra truoc do giao vien co day khoa hoc j nao xung dot voi i khong
                if(x[j] == t && conflict[j][i]){
                    return false;
                }
            }           
        }
        return true;
    }
    public int find_max(int[] arr, int m){
        int max= arr[1];
        for(int i= 1; i<= m; i++){
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }
    public void solution(){
//        // in danh sach giao vien x[i] day khoa hoc i
//        for(int i= 1;i<= n;i++){
//            System.out.print(x[i] + " ");
//        }
//        System.out.println();
        
         //khoi tao mang cnt = 0
        for(int i=1; i<=4;i++){
            cnt[i] = 0;
        }
        
        // dem giao vien x[i] day so khoa hoc
        for(int i=1; i<=4; i++){
            for(int j=1; j<=n;j++){
                if(x[j] == i) cnt[i]++;
            }
        }
        
//        for(int i = 1; i <= 4; i++){
//            System.out.print(cnt[i] + " ");
//        }
//        System.out.println();

        // tim max khoa hoc duoc day boi 1 giao vien
        max[cnt_x]= find_max(cnt,4);
//        System.out.println(max[cnt_x]);        
       
    }
    public void tryValue(int k){
        for(int v = 1; v <= 4; v++){
            if(check(v,k)){
                x[k] = v;
                if( k == n){
                    cnt_x++;
                    solution();
                }
                else tryValue(k+1);
            }
        }  
    }
    public void solve(int m, int n){
        this.m = m;
        this.n = n;
        x = new int[n+1];
        cnt_x = 0;
        cnt = new int[5];    
        max= new int[100];

        tryValue(1);
       // tim max load
        f_max = find_max(max, cnt_x);
        System.out.println(f_max);  
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BalancedCourseAssignment demo = new BalancedCourseAssignment();
        
        while(m < 1 || m > 10 || n < 1 || n > 30){
            m = sc.nextInt();
            n = sc.nextInt();  
        }

        for(int t = 1; t <= m; t++){
            int k = sc.nextInt();
            for(int i = 1; i <= k; i++){
                int temp = sc.nextInt();
                teach[t][temp] = true;
            }
        }
        int k = sc.nextInt();
        for(int x = 1; x <= k; x++){
            int i = sc.nextInt();
            int j= sc.nextInt();
            conflict[i][j] = true;
            conflict[j][i] = true;
        }
        demo.solve(m, n);

}
}