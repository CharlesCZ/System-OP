/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchro;

import java.util.Random;

/**
 *
 * @author Cezary
 */
public class Gnp {
   //t2 -type
       Random rand=new Random();
boolean[][] A;
int n; 
float p;

    public Gnp(int n, float p) {
        this.n = n;
        this.p = p;
        Inicjuj( n,  p);
    }




void Inicjuj(int n, float p)
{
    A=new boolean[n][n];
	int i, j;
	boolean x;
	for (i = 0; i < n; i++)
		A[i][i] = false;
	for (i = 0; i<n - 1; i++)
		for (j = i + 1; j < n; j++)
		{
			x = (rand.nextInt(100) / 100.0) < p;
			A[i][j] = x;
			A[j][i] = x;

		}
}


 
}
