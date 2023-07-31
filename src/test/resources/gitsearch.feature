@gitsearch
Feature: Search Git For User

  Scenario Outline: Validate that "<profile>" has the all required information
    When the user searchs the profile "<profile>"
    Then the profile's follower are this many "<follower_no>"
    And the profile's followings are this many "<following_no>"
    And the profile's repos are this many "<repo_no>"
    And the profile's gists are this many "<gist_no>"
    And the profile's location is "<location>"
    And the profile's job is "<job>"
    And the profile's personal website is "<website>"
    And the profile's is followed by "<personal_following>"
    Examples:
      | profile | follower_no | following_no | repo_no | gist_no | location | job | website | personal_following |
      | Smith   |     229     | 192          | 229     | 94      | location | job | website | personal_following |