SELECT SUM(PRICE) AS TOTAL_PRICE
FROM ITEM_INFO
GROUP BY RARITY
HAVING RARITY = "LEGEND"