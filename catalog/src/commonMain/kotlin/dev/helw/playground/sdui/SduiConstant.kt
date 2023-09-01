package dev.helw.playground.sdui

internal val json = """
   {
      "version": 1,
      "root": {
         "type": "list",
         "identifier": "primary_list",
         "contents": [
            {
               "title": {
                  "type": "title",
                  "text": "Salam, World"
               },
               "description": {
                  "type": "description",
                  "text": "Welcome to the world of SDUi"
               },
               "leading": {
                  "type": "letterCircle",
                  "text": "SW",
                  "size": "medium",
                  "typography": "Label.Medium",
                  "backgroundColor": "primary"
               },
               "trailing": {
                  "type": "statusIcon",
                  "icon": "check",
                  "size": "medium"
               },
               "type": "listItem",
               "identifier": "primary_list_item_1"
            }
         ]
      }
   }
""".trimIndent()