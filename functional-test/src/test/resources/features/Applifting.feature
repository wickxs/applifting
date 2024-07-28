Feature: Applifting Website Testing

  Background:
    Given User is on the homepage
    And Accepts cookies

  Scenario: Check Homepage Content
    Then Homepage is loaded correctly
    And Navigation works correctly

  Scenario Outline: Check Products and Services components at main page
    Given Check "products" in "<products and services>" components on main page
    Examples:
      | products and services  |
      | Applied AI             |
      | Product discovery      |
      | Mobile app development |
      | Software modernization |
      | Software development   |
      | Hybrid teams           |
      | Cloud engineering      |

  Scenario Outline: Check Our Work components at main page
    Given Check "work" in "<our work>" components on main page
    Examples:
      | our work     |
      | erste-locker |
      | investown    |
      | bank-id      |
      | twigsee      |
      | braid        |
      | foedus       |
      | jablotron    |
      | erste        |
      | heureka      |
      | alpiq        |
      | good-access  |
      | leveris      |
      | george-pro   |

  Scenario Outline: Navigate to a page and verify information is displayed
    When User navigates to "<page>" page
    Then Page is displayed with correct information and text "<text>"
    Examples:
      | page     | text                                             |
# This one is failing on purpose, to see how the failed tests are handled in test report :)
      | About us | Meet usss                                        |
      | Careers  | Work for a company, where people lead themselves |
      | Our work | Our work                                         |
      | Contact  | Let's talk                                       |
      | Blog     | Read. Learn. Enjoy.                              |

  Scenario Outline: Navigate to Contact Page and Submit Contact Form
    When User navigates to "Contact" page
    And Fills out the form for mandatory fields "<name>", "<email>", "<message>" and clicks consent
    Then Contact form works correctly
    Examples:
      | name     | email                | message    |
      | John Doe | johnodoe@example.com | Something. |

  Scenario: Navigate to Blog Page and Check Blog Articles
    When User navigates to "Blog" page
    Then Blog articles are displayed correctly