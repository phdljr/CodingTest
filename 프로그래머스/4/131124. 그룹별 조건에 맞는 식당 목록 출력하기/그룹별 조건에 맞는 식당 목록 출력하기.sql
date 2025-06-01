SELECT 
    P.MEMBER_NAME,
    R.REVIEW_TEXT,
    DATE_FORMAT(R.REVIEW_DATE,'%Y-%m-%d') AS REVIEW_DATE
FROM 
    MEMBER_PROFILE AS P
    INNER JOIN REST_REVIEW AS R
    ON P.MEMBER_ID = R.MEMBER_ID 
    AND P.MEMBER_ID IN (
        SELECT 
            MEMBER_ID 
        FROM (
            SELECT 
                R.MEMBER_ID,
                RANK() OVER (ORDER BY COUNT(*) DESC) as RANKING
            FROM 
                REST_REVIEW AS R
            GROUP BY 
                R.MEMBER_ID
        ) AS RANKED 
        WHERE 
            RANKING = 1
    )
ORDER BY 
    R.REVIEW_DATE ASC, 
    R.REVIEW_TEXT ASC