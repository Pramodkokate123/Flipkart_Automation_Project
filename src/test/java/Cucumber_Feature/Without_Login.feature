  Feature: Automate our script on desired browser

  Scenario Outline: Add to cart a product without login
    Given Open flipkart in our desired "<browser>"
    When Add to cart product without login
    And Search "<item>" in search box and then click on search icon
    Then It will click on first product and print all the products
    Then It will proceed further process of product
    But It will proceed just up to payment option
    Examples:
    |browser      |item       |
    |chrome       |books      |

