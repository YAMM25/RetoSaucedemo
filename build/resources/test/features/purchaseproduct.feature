#language: es

Característica: Realizar compra de un porducto

  Escenario: Comprar un producto
    Dado que el cliente se encuentra logueado
    Y el cliente esta en la Home Page
    Cuando el cliente agrega un producto al carrito
    Y el cliente se dirija al carrito
    Y el cliente da click en el boton CHECKOUT
    Y el cliente esta en la pagina CHECKOUT: YOUR INFORMATION
    Y el cliente visualiza el formulario exitosamente, ingresa todos los datos y da click al boton CONTINUE
    Y el cliente esta en la pagina CHECKOUT: OVERVIEW y le da click al boton Finish
    Y el cliente esta en la pagina CHECKOUT: COMPLETE!
    Entonces el cliente visualiza el mensaje "Your order has been dispatched, and will arrive just as fast as the pony can get there!"