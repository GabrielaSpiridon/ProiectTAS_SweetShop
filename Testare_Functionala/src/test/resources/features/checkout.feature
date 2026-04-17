Feature: Verificare proces Checkout

  Scenario: Verificare campuri obligatorii la Checkout
    Given Utilizatorul are un produs in cos
    And Navigheaza la pagina Basket
    When Apasa pe butonul Checkout
    And Lasa toate campurile goale si apasa Continue to checkout
    Then Sistemul afiseaza mesaje de eroare pentru campurile obligatorii