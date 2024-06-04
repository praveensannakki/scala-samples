SELECT
    'Low Salary' AS category,
    SUM(CASE WHEN income < 20000 THEN 1 ELSE 0 END) AS accounts_count
FROM
    Accounts

UNION
SELECT
    'Average Salary' category,
    SUM(CASE WHEN income >= 20000 AND income <= 50000 THEN 1 ELSE 0 END)
    AS accounts_count
FROM
    Accounts

--Next query
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
     select distinct salary from Employee order by salary desc limit N,1
  );
END

--
select today.id from weather yesterday
join weather today
on yesterday.recorddate=DATE_SUB(today.recorddate, INTERVAL 1 DAY)
and today.temperature > yesterday.temperature;
-- datediff(w1.recorddate,w2.recorddate)=1

--
# Write your MySQL query statement below
WITH cte
AS (
    SELECT
        id,
        request_at AS Day,
        IF(status!='completed', 1, 0) AS Cancelled
    FROM Trips
    WHERE client_id IN (SELECT users_id FROM Users WHERE banned='No')
        AND driver_id IN (SELECT users_id FROM Users WHERE banned='No')
        AND request_at BETWEEN '2013-10-01' AND '2013-10-03'
)

SELECT
    Day,
    ROUND(SUM(Cancelled) / COUNT(id), 2) AS 'Cancellation Rate'
FROM cte
GROUP BY Day

--
# Write your MySQL query statement below
select distinct visited_on, amount, round(amount/7, 2) as average_amount
from (select visited_on,
      sum(amount) over (order by visited_on range between
      interval 6 day preceding and current row) as amount,
      dense_rank() over (order by visited_on) as rk
      from Customer) as t
where rk >= 7
