Feature: Autentificare utilizator

  Scenario: Login cu date valide
    Given Utilizatorul se afla pe pagina de Login
    When Introduce email-ul "oneorder@sweetshop.local" si parola "qwerty"
    And Apasa butonul de Login
    Then Utilizatorul este redirectionat catre pagina de cont