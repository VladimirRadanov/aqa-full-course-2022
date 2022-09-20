Feature: test feature

  Scenario Outline: : test google page
    Given load "<url_to_load>" page
    When my current url is "<url_to_validate>"
    Then quit driver
    Examples:
      | url_to_load           | url_to_validate           |
      | https://google.com/   | https://www.google.com/   |
      | https://amazon.com/   | https://www.amazon.com/   |
      | https://twitter.com/  | https://twitter.com/      |
      | https://facebook.com/ | https://www.facebook.com/ |
