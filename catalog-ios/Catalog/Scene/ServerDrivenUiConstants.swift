//
//  ServerDrivenUiConstants.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/12/23.
//

let fullSampleJson = """
    {
      "version": 1,
      "root": {
        "type": "list",
        "identifier": "primary_list",
        "contents": [
          {
            "title": {
              "type": "title",
              "text": "Kiryu Kazuma"
            },
            "description": {
              "type": "description",
              "text": "Former Yakuza member"
            },
            "leading": {
              "type": "letterCircle",
              "text": "KK",
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
            "identifier": "primary_list_item_0",
            "actions": [
              {
                "type": "onClick_deeplink",
                "deeplink": "https://yakuza.sega.com/kiryu"
              }
            ]
          },
          {
            "title": {
              "type": "title",
              "text": "Majima Goro"
            },
            "description": {
              "type": "description",
              "text": "Mad Dog of Shimano"
            },
            "leading": {
              "type": "letterCircle",
              "text": "MG",
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
            "identifier": "primary_list_item_1",
            "actions": [
              {
                "type": "onClick_deeplink",
                "deeplink": "https://yakuza.sega.com/majima"
              }
            ]
          },
          {
            "title": {
              "type": "title",
              "text": "Akiyama Shun"
            },
            "description": {
              "type": "description",
              "text": "Moneylender with a heart of gold"
            },
            "leading": {
              "type": "letterCircle",
              "text": "AS",
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
            "identifier": "primary_list_item_2",
            "actions": [
              {
                "type": "onClick_deeplink",
                "deeplink": "https://yakuza.sega.com/akiyama"
              }
            ]
          },
          {
            "title": {
              "type": "title",
              "text": "Saejima Taiga"
            },
            "description": {
              "type": "description",
              "text": "Prisoner with incredible strength"
            },
            "leading": {
              "type": "letterCircle",
              "text": "ST",
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
            "identifier": "primary_list_item_3",
            "actions": [
              {
                "type": "onClick_deeplink",
                "deeplink": "https://yakuza.sega.com/saejima"
              }
            ]
          },
          {
            "title": {
              "type": "title",
              "text": "Kazama Shintaro"
            },
            "description": {
              "type": "description",
              "text": "Kiryu's foster father"
            },
            "leading": {
              "type": "letterCircle",
              "text": "KS",
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
            "identifier": "primary_list_item_4",
            "actions": [
              {
                "type": "onClick_deeplink",
                "deeplink": "https://yakuza.sega.com/kazama"
              }
            ]
          },
          {
            "title": {
              "type": "title",
              "text": "Date Makoto"
            },
            "description": {
              "type": "description",
              "text": "Detective and Kiryu's ally"
            },
            "leading": {
              "type": "letterCircle",
              "text": "DM",
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
            "identifier": "primary_list_item_5",
            "actions": [
              {
                "type": "onClick_deeplink",
                "deeplink": "https://yakuza.sega.com/date"
              }
            ]
          },
          {
            "title": {
              "type": "title",
              "text": "Makimura Makoto"
            },
            "description": {
              "type": "description",
              "text": "A mysterious woman"
            },
            "leading": {
              "type": "letterCircle",
              "text": "MM",
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
            "identifier": "primary_list_item_6",
            "actions": [
              {
                "type": "onClick_deeplink",
                "deeplink": "https://yakuza.sega.com/makimura"
              }
            ]
          },
          {
            "title": {
              "type": "title",
              "text": "Nishikiyama Akira"
            },
            "description": {
              "type": "description",
              "text": "Kiryu's childhood friend"
            },
            "leading": {
              "type": "letterCircle",
              "text": "NA",
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
            "identifier": "primary_list_item_7",
            "actions": [
              {
                "type": "onClick_deeplink",
                "deeplink": "https://yakuza.sega.com/nishikiyama"
              }
            ]
          },
          {
            "title": {
              "type": "title",
              "text": "Haruka Sawamura"
            },
            "description": {
              "type": "description",
              "text": "Kiryu's adopted daughter"
            },
            "leading": {
              "type": "letterCircle",
              "text": "HS",
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
            "identifier": "primary_list_item_8",
            "actions": [
              {
                "type": "onClick_deeplink",
                "deeplink": "https://yakuza.sega.com/haruka"
              }
            ]
          },
          {
            "title": {
              "type": "title",
              "text": "Kashiwagi Osamu"
            },
            "description": {
              "type": "description",
              "text": "Kiryu's loyal friend"
            },
            "leading": {
              "type": "letterCircle",
              "text": "KO",
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
            "identifier": "primary_list_item_9",
            "actions": [
              {
                "type": "onClick_deeplink",
                "deeplink": "https://yakuza.sega.com/kashiwagi"
              }
            ]
          }
        ]
      }
    }
"""
