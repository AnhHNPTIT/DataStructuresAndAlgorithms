package class59;
import java.io.File;
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
public class Test {
    int m; // so giao vien
    int n; // so khoa hoc
    int z; // giao vien day it nhat z khoa hoc
    int[][] x; // giao vien x[i] day khoa hoc i
    boolean[][] conflict; // khoa hoc i va j xung dot 
    boolean[][] teach; // giao vien t day khoa hoc i
    int[] cnt; // dem giao vien day so khoa hoc
    int cnt_x; // dem so cach sap xep
    int[] max; // max khoa hoc duoc day boi 1 giao vien
    int f_max; // max load
    private boolean check(int t, int i, int k){
        if(!teach[t][i]) return false; // giao vien t khong day khoa hoc i
        else {
            for(int j = 1; j < i; j++){ // kiem tra truoc do giao vien co day khoa hoc j nao xung dot voi i khong
                if(x[k][j] == t && conflict[j][i]){
                    return false;
                }
            }           
        }
        return true;
    }
    private boolean checkCourse(int k){
         //khoi tao mang cnt = 0
        for(int i=1; i<=m;i++){
            cnt[i] = 0;
        }
        
        // dem giao vien x[i] day so khoa hoc
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n;j++){
                if(x[k][j] == i) cnt[i]++;
            }
        }
        
        // kiem tra giao vien da day it nhat z khoa hoc chua?
        for(int i = 1; i <= m; i++){
            if(cnt[i] < z){
                return false;
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
    public void printSolution(){
//        // in danh sach giao vien x[i] day khoa hoc i
//        for(int i= 1;i<= n;i++){
//            System.out.print(x[i] + " ");
//        }
//        System.out.println();
        
//         //khoi tao mang cnt = 0
//        for(int i=1; i<=m;i++){
//            cnt[i] = 0;
//        }
//        
//        // dem giao vien x[i] day so khoa hoc
//        for(int i=1; i<=m; i++){
//            for(int j=1; j<=n;j++){
//                if(x[cnt_x-1][j] == i) cnt[i]++;
//            }
//        }
        
//        for(int i = 1; i <= 4; i++){
//            System.out.print(cnt[i] + " ");
//        }
//        System.out.println();

        // tim max khoa hoc duoc day boi 1 giao vien
        max[cnt_x]= find_max(cnt,m);
//        System.out.println(max[cnt_x]);        
       
    }
    public void tryValue(int k){
        for(int v = 1; v <= m; v++){
            if(check(v,k,cnt_x)){
                x[cnt_x][k] = v;
                if( k == n){
                    if(checkCourse(cnt_x)){
                        cnt_x++;
                        printSolution();                        
                    }

                }
                else tryValue(k+1);
            }
        }  
    }
    public void solve(){
        x = new int[100][n+1];
        cnt_x = 0;
        cnt = new int[m+1];    
        max= new int[100];
        int k = 0;
        tryValue(1);
       // tim max load
       if(cnt_x > 0){
           f_max = find_max(max, cnt_x);
           for(int i= 1; i <= cnt_x; i++){
               if(max[i] == f_max) {
                   k = i;
                   break;
               }
           }
            System.out.println("Max khoa hoc duoc day boi 1 giao vien:" + f_max);  
            for(int j = 1; j <= m; j++){
                System.out.print("Giao vien " + j + ": ");
                for(int i = 1; i <= n; i++){  
                    if(x[k-1][i] == j) System.out.print(i + " ");
                }
                System.out.println();
            }
            System.out.println("");
       }
       else {
           f_max = -1;
           System.out.println("Max khoa hoc duoc day boi 1 giao vien:" + f_max); 
       }

    }
    public void loadData(String filename){
        try{
            Scanner sc = new Scanner(new File(filename));
            m = sc.nextInt();
            n = sc.nextInt();
            z = sc.nextInt();
            conflict= new boolean[n+1][n+1];
            teach= new boolean[m+1][n+1];
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
            sc.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }        

}