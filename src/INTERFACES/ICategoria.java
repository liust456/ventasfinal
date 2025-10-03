package INTERFACES;
import java.util.ArrayList;
import ENTIDADES.Categoria;

public interface ICategoria {
	void guardar(Categoria categoria);
	void modificar(Categoria categoria);
	void borrar(Categoria categoria);
	
	ArrayList<Categoria> cargar();
	ArrayList<Categoria> cargarPorFamilia(int idfamilia);	
	Categoria cargar(int idCategoria);
}
