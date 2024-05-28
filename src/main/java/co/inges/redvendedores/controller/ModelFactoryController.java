package co.inges.redvendedores.controller;

import co.inges.redvendedores.model.Producto;
import co.inges.redvendedores.model.RedSocial;
import co.inges.redvendedores.model.Vendedor;
import co.inges.redvendedores.persistencia.Persistencia;
import co.inges.redvendedores.utils.RedSocialUtils;

import java.util.List;

public class ModelFactoryController {

    public RedSocial redSocial;



    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController(){

        cargarResourceXML();

        if(redSocial == null){
            cargarDatosBase();
            guardarResourceXML();
        }
    }

    private void cargarDatosBase(){
        redSocial = RedSocialUtils.inicializarDatos();
    }

    public void guardarResourceXML() {
        Persistencia.guardarRecursoRedSocialXML(redSocial);
    }

    private void cargarResourceXML() {
        redSocial = Persistencia.cargarRecursoRedSocialXML();
    }

    public List<Vendedor> obtenerVendedoresRedSocial() {
        return  redSocial.getListaVendedores();
    }
    public List<Producto> obtenerProductoRedSocial (){
        return  redSocial.getListaProductos();
    }
    public boolean eliminarVendedor(String identificacion) {
        for (Vendedor vendedor : redSocial.getListaVendedores()) {
            if (vendedor.getIdentificacion().equals(identificacion)) {
                redSocial.getListaVendedores().remove(vendedor);
                guardarResourceXML(); // Guardar los cambios en el archivo XML
                return true;
            }
        }
        return false;
    }

    public boolean eliminarProducto(String nombre) {
        for (Producto producto : redSocial.getListaProductos()) {
            if (producto.getNombre().equals(nombre)) {
                redSocial.getListaProductos().remove(producto);
                guardarResourceXML(); // Guardar los cambios en el archivo XML
                return true;
            }
        }
        return false;
    }


}
