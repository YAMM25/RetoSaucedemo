#language: es

Característica: Cargue de productos


  Esquema del escenario:el usuario visualiza los nombres de los productos
    Dado que un usuario se encuentre Autenticado con el "<usuario>" y "<password>"
    Cuando el usuario ingrese a la pagina Home de Souce demo
    Entonces se visualizan los nombres de los articulos

    Ejemplos:
      | usuario       | password     |
      | standard_user | secret_sauce |


  Esquema del escenario: Agregar un producto al carrito
    Dado un usuario en la pagina PRODUCTS de soucedemo
    Cuando el usuario haga clic en el boton ADD TO CART "<producto>"
    Entonces se visualizara en el carrito

    Ejemplos:
      | producto |
      | 1        |

    Escenario: Realizar el logout exititoso
    Dado un usuario ingresa un usuario correcto e ingresa al homepage
    Cuando el usuario desee desloguearse de la aplicacion homepage
    Entonces podra ingresar a las opciones del menu y realizar el Logout


