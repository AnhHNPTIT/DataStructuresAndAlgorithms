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
public class BCASolver {
    public static void main(String[] args) {
        BCAModel model = new BCAModel();
        model.loadData("demo.txt");
        model.solve();
}    
}
