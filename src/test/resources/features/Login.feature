Feature:  Login

  Background:
    Given the user is on the login page


  @librarian
    Scenario: Login as a librarian
    When I login as a librarian
    Then dashboard should be displayed

   @student
    Scenario: Login as a student
    When I login as a student
    Then books should be displayed
