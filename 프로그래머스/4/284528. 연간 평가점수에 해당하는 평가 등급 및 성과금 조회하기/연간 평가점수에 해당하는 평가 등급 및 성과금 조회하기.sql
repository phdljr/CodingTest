WITH EMP_GRADE AS (
    SELECT
        EMP_NO,
        AVG(SCORE) AS GRADE_AVG,
        CASE
            WHEN AVG(SCORE) >= 96 THEN 'S'
            WHEN AVG(SCORE) >= 90 THEN 'A'
            WHEN AVG(SCORE) >= 80 THEN 'B'
            ELSE 'C'
        END AS GRADE,
        CASE
            WHEN AVG(SCORE) >= 96 THEN 0.2
            WHEN AVG(SCORE) >= 90 THEN 0.15
            WHEN AVG(SCORE) >= 80 THEN 0.1
            ELSE 0
        END AS PERCENT
    FROM
        HR_GRADE
    GROUP BY
        EMP_NO
)

SELECT
    E.EMP_NO,
    E.EMP_NAME,
    G.GRADE AS GRADE,
    E.SAL * G.PERCENT AS BONUS
FROM
    HR_EMPLOYEES AS E
    INNER JOIN EMP_GRADE AS G
        ON E.EMP_NO = G.EMP_NO
ORDER BY
    EMP_NO