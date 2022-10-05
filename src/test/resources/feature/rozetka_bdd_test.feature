Feature: Rozetka BDD tests

 Background:
 Given load ROZETKA page

 Scenario Outline:
 Given i search for "<search_request>"
 When search is completed
 Then i see at least <search_result_count> search results

 Examples:
 | search_request | search_result_count |
 | iPhone 14 | 14 |
 | Xiaomi | 15 |
 | Dell | 20 |
 | ASUS | 15 |
