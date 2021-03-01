package tarea4refactorizacion;

import java.util.Scanner;
/**
 *  Este programa contiene una clase para generar todos los numeros primos de 1 hasta número máximo especificado por el usuario
 *  Dado un vector de enteros empezando en 2, se tacha todos los múltiplos de 2.
 *  Se encuentra el siguiente entero y no tachado y se tachan todos sus múltiplos.
 *  Proceso se repite hasta que se pasa de la raíz cuadrada del valor maximo.
 *  Los números que queden sin tachar son los numeros primos.
 * */

public class GeneradorDeNumerosPrimos
{
	
	private static int dim;
	private static boolean esPrimo[];
	private static int primos[];
	
	public static int[] generarPrimos (int max)
	{
		if (max < 2) {
			return new int[0]; // Vector vacio
		} else {
			inicializarCriba(max);
			cribar();
			rellenarPrimos();
			return primos;
		}
	}
private static void inicializarCriba (int max)
{
	int i;
	dim = max + 1;
	esPrimo = new boolean[dim];
	for (i=0; i<dim; i++)
		esPrimo[i] = true;
	esPrimo[0] = esPrimo[1] = false;
}

private static void cribar ()
{
	int i,j;
	for (i=2; i<Math.sqrt(dim)+1; i++) {
		if (esPrimo[i]) {
			// Eliminar los multiplos de i
			for (j=2*i; j<dim; j+=i)
				esPrimo[j] = false;
		}
	}
}
private static void rellenarPrimos ()
{
	int i, j, cuenta;
	// Contar primos
	cuenta = 0;
	for (i=0; i<dim; i++)
		if (esPrimo[i])
			cuenta++;
	// Rellenar el vector de numeros primos
	primos = new int[cuenta];
	for (i=0, j=0; i<dim; i++)
		if (esPrimo[i])
			primos[j++] = i;
}
public static void mostrarPrimos() {
	for (int i = 0; i < primos.length; i++) {
		if (i%10==0) System.out.println();
		System.out.print(primos[i]+"\t");
	}
}
public static void main(String[] args) {
	Scanner teclado=new Scanner(System.in);
	System.out.println("Introduce el numero para la criba de Eratostenes:");
				int dato=teclado.nextInt();
	primos=new int[dato];
	System.out.println("\nVector inicial hasta :"+dato);
	//inicializamos el vector
	for (int i = 0; i < primos.length; i++)
		primos[i]=i+1;
	//mostramos el vector
	mostrarPrimos();
	primos=generarPrimos(dato);
	//mostramos la criba de Eratostenes
	System.out.println("\n\nVector de primos hasta:"+dato);
	mostrarPrimos();
	}
}