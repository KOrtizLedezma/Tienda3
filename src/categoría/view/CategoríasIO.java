package categoría.view;

import java.util.Iterator; 
import java.util.Scanner;

import categoría.control.Categorías;
import categoría.entity.Categoría;
import categoría.entity.NoExisteCategoría;
import producto.control.Productos;
import view.InputTypes;

public class CategoríasIO {
	
	private Productos productos;
	private Categorías categorías;
	private Scanner scanner;
	
	/****************************
	 * Constructor              *
	 ****************************/
	
	public CategoríasIO(Categorías categorías, Productos productos, Scanner scanner) {
		this.categorías = categorías;
		this.productos = productos;
		this.scanner = scanner;
	}
	
	/****************************
	 * Agregar categorías        *
	 ****************************/
	
	public void add() {
		Categoría categoría = CategoríaIO.ingresar(scanner);
		try {
			categorías.ingresar(categoría);
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("No existe espacio!");
		}
	}
	
	/****************************
	 * Eliminar categorías       
	 * @throws NoExisteCategoría *
	 ****************************/
	
	public void delete() throws NoExisteCategoría {
		int codcategoría = InputTypes.readInt("Código de categoría: ", scanner);
		categorías.eliminar(codcategoría);
	}
	
	/****************************
	 * Listar categorías         *
	 ****************************/
	
	public void list() {
		for (Iterator<Categoría> i = categorías.getCategorías().iterator();
				i.hasNext();) {
			System.out.println(i.next());
		}
	}
	
	public void listProducts() throws NoExisteCategoría{
		int codCategoría = InputTypes.readInt("Código categoría: ", scanner);
		System.out.println(categorías.buscar(codCategoría));
		for (int i = 0; i < productos.getCantidad(); i ++) {
			if (codCategoría == productos.getProductos()[i].getCodCategoría()) {
				System.out.println(productos.getProductos()[i]);
			}
		}
	}
    
	/****************************
	 *   Vector de categorías   *
	 ****************************/
	public Categorías getCategorías() {
		return categorías;
	}
	
}