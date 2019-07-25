Feature: Groups

    Scenario: Group creation
        Given a set of groups
        When I create a new group with name xxx
        Then the vew set of groups is equal to the old set with the added group
