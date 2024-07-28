Feature: Applifting Website Testing

  Background:
    Given User is on the homepage

  Scenario: Check Homepage Content
    Then Homepage is loaded correctly
    And Navigation works correctly

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

  Scenario: Navigate to Contact Page and Submit Contact Form
    When User navigates to "Contact" page
    Then Contact form works correctly

  Scenario: Navigate to Blog Page and Check Blog Articles
    When User navigates to "Blog" page
    Then Blog articles are displayed correctly
    And Links to individual blog articles work correctly
