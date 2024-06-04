with temp as (
select year, sum(case when type='birth' then 1 else -1 end) as total
 from records group by year
),
step2  as(
select t1.year,t1.total, coalesce(sum(t2.total),t1.total) cumulative
from temp t1
left join temp t2
on t1.year>t2.year
group by t1.year
)
select year,coalesce(lead(cumulative) over(order by year),0) cnt
from step2
order by 2 desc,1 
limit 1


select distinct visited_on, amount, round(amount/7, 2) as average_amount
from (select visited_on, 
      sum(amount) over (order by visited_on range between interval 6 day preceding and current row) as amount,
      dense_rank() over (order by visited_on) as rk
      from Customer) as t
where rk >= 7