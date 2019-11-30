/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class59;

/**
 *
 * @author hoang
 */
public class HoanVi {
    private int n;
    private int[] x;
    private boolean[] xh;
    private boolean check(int v, int k){
        return !xh[v];
    }
    public void solution(){
        for(int i=1; i<=n; i++){
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }
    public void TRY(int k){
        for(int v = 1; v <= n; v++){
            if(check(v,k)){
                x[k] = v;
                xh[v] = true;
                if( k == n) solution();
                else TRY(k+1);
                xh[v] = false;
            }
        }
    }
    public void solve(int n){
        this.n = n;
        x = new int[n+1];
        xh = new boolean[n+1];
        for(int v = 1; v<= n; v++){
            xh[v] = false;
        }
        TRY(1);
    }
    public static void main(String[] args) {
        HoanVi t = new HoanVi();
        t.solve(3);
    }    
}
