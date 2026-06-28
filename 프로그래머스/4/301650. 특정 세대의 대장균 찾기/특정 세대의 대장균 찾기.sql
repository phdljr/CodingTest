WITH RECURSIVE GEN AS (
    SELECT
        *,
        1 AS DEPTH
    FROM
        ECOLI_DATA 
    WHERE
        PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT
        C.*,
        P.DEPTH + 1
    FROM
        ECOLI_DATA AS C
    INNER JOIN
        GEN AS P
        ON C.PARENT_ID = P.ID
    WHERE
        DEPTH < 3
)

SELECT
    ID
FROM
    GEN
WHERE
    DEPTH = 3