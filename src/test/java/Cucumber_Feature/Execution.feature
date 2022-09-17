Feature: Automate our script on desired browser

  Scenario Outline: Add to cart a product with login functionality
    Given Open flipkart site in our desired "<browser>"
    And Login with valid "<UserID>" and "<Password>"
    When Search "<item>" in search field and click on search icon
    Then It will click on first product and collect all related products information
    But It will click on add to cart option
    Then It will proceed further actions
    Examples:
    |browser      |UserID             |Password           |item             |
    |chrome       |9545886693         |Pramod@123         |books            |
