Feature: Gestiune Cos de cumparaturi

  Scenario: Verificare functionalitate Empty Basket
    Given Utilizatorul are cel putin un produs in cos
    And Se afla pe pagina Basket
    When Apasa pe link-ul Empty Basket
    And Confirma alerta de sistem
    Then Cosul este golit si badge-ul din meniu devine 0