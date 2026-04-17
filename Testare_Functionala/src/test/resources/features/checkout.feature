Feature: Validare Finalizare Comanda

  Scenario: Verificare campuri obligatorii la Checkout
    Given Utilizatorul are un produs in cos [cite: 259, 277]
    And Navigheaza la pagina Basket [cite: 260, 277]
    When Apasa pe butonul Checkout [cite: 278]
    And Lasa toate campurile goale si apasa Continue to checkout [cite: 261, 279, 280]
    Then Sistemul afiseaza mesaje de eroare pentru campurile obligatorii [cite: 262, 281, 282]