## FG:ACADEMY

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

#


# Contexto: 
Hoy en dia los e-sports estan en auge, provocando la aparicion de escuelas de e-sports, para formar a chavales que si ganan pueden obtener mas prestigio y mas chavales querran ir a aprender ahi, el caso es que lo "habitual" en estos casos suele ser: League of legends, valorant, coutter strike 2, vgc pokemon, dota 2 etc...
Sin embargo hay un genero considerado nicho dentro de los e-sports, con potencial y una comunidad dispuesta a aprender para ganar en los torneos.
Los fighing games o juegos de lucha, juegos que tuvieron su edad dorada en la epoca de los arcades, y que ahora son mas accesibles que antes, pero con mecanicas y mas que pueden requerir de algquien te enseñe o muchas horas de practica.

Al ser un sector poco explotado, no existen otras opciones en el mercado, por lo tanto FG_Academy es unico en su especie, siendo la primera herramienta diseñada para la enseñanza del genero. 


# ¿Que es FG_ACADEMY?

FG_academy es una aplicacion web desarrollada con springboot diseñada para el aprendizaje de juegos de lucha.
Gestiona alumnos, profesores, titulos, mandos, [Torneos internos, guias] usando bases de datos. con un entorno agradable para el usuario y estilizado.

# Gestion: 
FG_Academy usara una pagina general a la que requiere una verificacion para alumnos, dicha pagina muestra la lista de alumnos con el profesor asignado y el juego que estan aprendiendo.

Cada alumno tiene asignado UN UNICO profesor, y cada profesor puede estar asignado en varios alumnos, y cada profesor tiene asignado un titulo, y al tener un titulo asignado al profesor el alumno tiene asignado el titulo automaticamente. 

# Funciones.
## Seguridad
La aplicacion dispone  de seguiridad para acceder a los datos mas minimos de sistema, para acceder a la lista de alumnos y ver con que profesor tiene etc solo puedes acceder siempre y cuando accedas como "alumno", y lo mismo para profesor, el cual puede sacar la informacion de los profesores, y el ADMINISTRADOR, el cual puede gestionar todo.












