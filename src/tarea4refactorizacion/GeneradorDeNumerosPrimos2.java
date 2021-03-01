package tarea4refactorizacion;

import java.util.Scanner;
/**
 *  Este programa contiene una clase para generar todos los numeros primos de 1 hasta número máximo especificado por el usuario
 *  Dado un vector de enteros empezando en 2, se tacha todos los múltiplos de 2.
 *  Se encuentra el siguiente entero y no tachado y se tachan todos sus múltiplos.
 *  Proceso se repite hasta que se pasa de la raíz cuadrada del valor maximo.
 *  Los números que queden sin tachar son los numeros primos.
 * */
/**
 * 
 * @author Verónica
 *
 */
/**
 * Clase que genera primos.
 * 
 */
public class GeneradorDeNumerosPrimos2
{
	private static boolean esPrimo[];
	private static int primos[];
	/**
	 * Metodo control general
	 * @param max valor maximo donde buscaremos los primos.
	 * @return primos Raiz cuadrada del valor maximo.
	 */
	public static int[] generarPrimos (int max)
	{
	if (max < 2) {
	return new int[0];
	} else {
	inicializarCandidatos(max);
	eliminarMultiplos();
	obtenerCandidatosNoEliminados();
	return primos;
	}
}
/**	 
* Inicia el vector de numeros. Donde buscaremos los primos. 
* @param max valor maximo donde buscaremos los primos.
*/
private static void inicializarCandidatos (int max)
	{
	int i;
	esPrimo = new boolean[max+1];
	esPrimo[0] = esPrimo[1] = false;
	for (i=2; i<esPrimo.length; i++)
	esPrimo[i] = true;
}
/**
 * Elimina los multiplos de los numeros primos.
 */
private static void eliminarMultiplos ()
	//Código del antiguo método cribar()
	{
	int i,j;
	for (i=2; i<Math.sqrt(esPrimo.length)+1; i++) {
		if (esPrimo[i]) {
			// Eliminar los múltiplos de i
			for (j=2*i; j<esPrimo.length; j+=i)
				esPrimo[j] = false;
		}
	}
}
/**
 * Busca en el vector los numeros primos y los añade aun Array.
 *
 */
private static void obtenerCandidatosNoEliminados ()
// Código del antiguo método rellenarPrimos()
{
	int i, j, cuenta;
	// Contar primos
	cuenta = 0;
	for (i=0; i<esPrimo.length; i++)
		if (esPrimo[i])
			cuenta++;
	// Rellenar el vector de números primos
	primos = new int[cuenta];
	for (i=0, j=0; i<esPrimo.length; i++)
		if (esPrimo[i])
			primos[j++] = i;
	}
/**
 * Mostrar los numeros Primos del Array.
 */
public static void mostrarPrimos() {
	for (int i = 0; i < primos.length; i++) {
		if (i%10==0) System.out.println();
		System.out.print(primos[i]+"\t");
	}
}	
/**
 * Metodo main.
 * @param args Parametro por defecto
 */
public static void main(String[] args) {
	Scanner teclado=new Scanner(System.in);
	System.out.println("Introduce el número para la criba de Erastótenes:");
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