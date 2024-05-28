package co.inges.redvendedores.persistencia;

import co.inges.redvendedores.model.RedSocial;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Persistencia {

    public static final String RUTA_ARCHIVO_MODELO_REDSOCIAL_BINARIO = "src/main/resources/persistencia/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_REDSOCIAL_XML = "src/main/resources/Archivos/model.xml";



    //------------------------------------SERIALIZACIÓN  y XML


    public static RedSocial cargarRecursoSubastaBinario() {

        RedSocial redSocial = null;

        try {
            redSocial = (RedSocial) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_REDSOCIAL_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return redSocial;
    }

    public static void guardarRecursoSubastaBinario(RedSocial redSocial) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_REDSOCIAL_BINARIO, redSocial);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static RedSocial cargarRecursoRedSocialXML() {

        RedSocial redSocial = null;

        try {
            redSocial = (RedSocial) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_REDSOCIAL_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return redSocial;

    }


    public static void guardarRecursoRedSocialXML(RedSocial redSocial) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_REDSOCIAL_XML, redSocial);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
