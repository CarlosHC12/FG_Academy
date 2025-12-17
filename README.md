## hola

@startuml Test uml
!include https://raw.githubusercontent.com/plantuml-stdlib/C4-PlantUML/master/C4_Container.puml

Person(admin, "Administrator")
Person(usuario1, "Alumno")
Person(usuario2, "Profesor")

Container(web_app, "FGA_app", "Spring", "Gestiona el alumnado y docencia")

ContainerDb(db, "Database", "H2", "Guarda informacion del alumnado y docencia")


Rel(admin, web_app, "Usa", "HTTPS")
Rel(usuario1, web_app, "Usa", "HTTPS")
Rel(usuario2, web_app, "Usa", "HTTPS")
Rel(web_app, ContainerDb, "Conecta", " ")

@enduml



