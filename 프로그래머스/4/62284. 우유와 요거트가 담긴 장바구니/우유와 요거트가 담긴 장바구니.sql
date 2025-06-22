WITH TEMP AS (
    SELECT
        ID,
        CART_ID,
        CASE
            WHEN NAME = 'Milk' THEN 1
            WHEN NAME = 'Yogurt' THEN 2
            ELSE 0
        END AS `CODE`
    FROM
        CART_PRODUCTS
    GROUP BY
        CART_ID, NAME
)

SELECT
    CART_ID
FROM
    TEMP
GROUP BY
    CART_ID
HAVING
    SUM(CODE) = 3
ORDER BY
    CART_ID