Feature: Ingresar y validar la cantidad de palabras caracteres de la pagina wordcounter

  @prueba
  Scenario Outline: Escribir y validar una cantidad de palabras y caracteres
    Given Ingresar al sitio wordCounter "<nameTest>"
    Given Escribir en el campo de texto "<frase>"
    And validar cantidad de palabras "<frase>"
    And Validar cantidad de caracteres "<frase>"
    Then Finalizar prueba
    Examples:
      | frase                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | nameTest |
      | Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Elementum eu facilisis sed odio morbi quis commodo odio. Gravida in fermentum et sollicitudin ac orci phasellus egestas. Massa eget egestas purus viverra. Bibendum neque egestas congue quisque egestas diam in arcu. Eu turpis egestas pretium aenean pharetra magna. Diam in arcu cursus euismod quis viverra nibh. Massa vitae tortor condimentum lacinia quis vel. Amet est placerat in egestas erat imperdiet. Laoreet suspendisse interdum consectetur libero. Ut aliquam purus sit amet luctus. Tristique et egestas quis ipsum suspendisse ultrices gravida dictum. Tempor orci dapibus ultrices in. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare. Enim nec dui nunc mattis enim ut. | contador |

#  @prueba
  Scenario Outline: Validar una cantidad de palabras en el primer parrafo
    Given Ingresar al sitio wordCounter "<nameTest>"
    Given Contar las palabas
    Examples:
      | frase | nameTest |
      |       | prueba   |

#  @prueba
  Scenario Outline: Validar una cantidad de palabras en el segundo parrafo
    Given Ingresar al sitio wordCounter "<nameTest>"
    Given Contar las palabas
    Examples:
      | frase | nameTest |
      |       | prueba   |

#  @prueba
  Scenario Outline: Validar una cantidad de palabras en el tercer parrafo
    Given Ingresar al sitio wordCounter "<nameTest>"
    Given Contar las palabas
    Examples:
      | frase | nameTest |
      |       | prueba   |