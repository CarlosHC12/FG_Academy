package es.etg.daw.dawes.java.rest.restfull.thym.infraestructure.web.enums;

public enum ThymView {

    MAIN("main"),
    REPORTES_LISTADOS("pfd/listados");

    private final String path;

    ThymView(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}