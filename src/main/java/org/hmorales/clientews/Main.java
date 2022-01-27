package org.hmorales.clientews;

import jakarta.xml.ws.BindingProvider;
import org.hmorales.webapp.jaxws.services.Curso;
import org.hmorales.webapp.jaxws.services.CursoServicioWs;
import org.hmorales.webapp.jaxws.services.CursoServicioWsImplService;


public class Main {
    public static void main(String[] args) {
        CursoServicioWs service = new CursoServicioWsImplService().getCursoServicioWsImplPort();

        ((BindingProvider)service).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        ((BindingProvider)service).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "12345");
        Curso curso = new Curso();
        curso.setNombre("react");
        curso.setDescripcion("react js");
        curso.setDuracion(50D);
        curso.setInstructor("Hector Morales");
        Curso respuesta = service.guardar(curso);
        System.out.println("nuevo curso: " + curso.getId() +", "+ curso.getNombre());

        service.listar().forEach(c -> System.out.println(c.getNombre()));
    }
}
