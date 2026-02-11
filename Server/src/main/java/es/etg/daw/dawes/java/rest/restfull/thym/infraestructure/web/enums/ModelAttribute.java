package es.etg.daw.dawes.java.rest.restfull.thym.infraestructure.web.enums;

public enum ModelAttribute {
    
    ALUMNOS("alumnos");

    private final String name;

    ModelAttribute(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}