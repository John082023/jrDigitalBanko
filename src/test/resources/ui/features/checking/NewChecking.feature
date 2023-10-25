Feature: Creating a new checking account

  Scenario: Create a standard individual checking account

    Given the user logged in as "test1234@gmail.com" "passworD1!"
    When the user creates a new checking account with the following data
      | checkingAccountType | accountOwnership | accountName               | initialDepositAmount |
      | Standard Checking   | Individual       | Elon Mush Second Checking | 100000.0             |
    Then the user should see the green confirmation "Confirmation Successfully created new Standard Checking account named Elon Mush Second Checking"
    And the user should see newly added account card
      | accountName               | accountType       | ownership  | accountNumber | interestRate | balance  |
      | Elon Mush Second Checking | Standard Checking | Individual | 486131034     | 0.0%         | 100000.0 |
    And the user should see the following transactions
      | date             | category | description               | amount   | balance  |
      | 2023-08-29 13:56 | Income   | 845321727 (DPT) - Deposit | 100000.0 | 100000.0 |