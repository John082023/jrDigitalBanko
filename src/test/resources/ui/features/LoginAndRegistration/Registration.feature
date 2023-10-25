Feature: Digital Bank Registration Page

  Scenario: As a user, I want to successfully create Digital Bank account (Positive Case)

    Given User navigates to Digital Bank signup page
    When User creates account with the following fields with mocked email and ssn
      | title | firstName | lastName | gender | dob        | password | address    | locality | region | postalCode | country | homePhone | mobilePhone | workPhone |
      | Mr.   | Jack      | Robert   | F      | 12/12/1984 | Test1234 | 12 Main St | City     | CA     | 99921      | US      | 5745789   | 5248954     | 5874136   |
    Then User should be displayed with the message "Success Registration Successful. Please Login."

  Scenario Outline: As a user, I want to make sure users cannot register without providing all valid data (Negative Case)

    Given User navigates to Digital Bank signup page
    When User creates account with the following fields with mocked email and ssn
      | title   | firstName   | lastName   | gender   | dob   | password   | address   | locality   | region   | postalCode   | country   | homePhone   | mobilePhone   | workPhone   |
      | <title> | <firstName> | <lastName> | <gender> | <dob> | <password> | <address> | <locality> | <region> | <postalCode> | <country> | <homePhone> | <mobilePhone> | <workPhone> |
    Then the User should see the "<fieldWithError>" following required field error message "<errorMessage>"

    Examples:
      | title | firstName | lastName | gender | dob | password | address | locality | region | postalCode | country | homePhone | mobilePhone | workPhone | fieldWithError | errorMessage |
      |       |           |          |        |     |          |         |          |        |            |         |           |             |           |                |              |