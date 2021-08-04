#language: es

Característica: Login de usuario

  Esquema del escenario: Autenticación éxitosa
  Dado un usuario en la pagina inicial de souce demo
  Cuando el usuario ingresa un "<usuario>" y "<clave>" correctos
  Entonces se autentica en el sitio correctamente

  Ejemplos:
  | usuario       | clave        |
  | standard_user | secret_sauce |

  Esquema del escenario: Autenticación fallida por usuario bloqueado
    Dado un usuario en la pagina inicial de souce demo
    Cuando el usuario ingresa un "<usuario>" y "<clave>" correcto
    Entonces se presenta un mensaje de error por usuario bloqueados

    Ejemplos:
      | usuario       | clave        |
      | locked_out_user | secret_sauce |

  Esquema del escenario: Autenticación fallida por usuario incorrecto
    Dado un usuario en la pagina inicial de souce demo
    Cuando el usuario ingresa un "<usuario>" y "<clave>" incorrecto
    Entonces se presenta un mensaje de error por usuario incorrecto

    Ejemplos:
      | usuario       | clave        |
      | locked_out_user | secret_sau |