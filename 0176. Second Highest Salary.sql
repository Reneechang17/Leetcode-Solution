# Write your MySQL query statement below
SELECT max(salary) SecondHighestSalary
FROM Employee
WHERE salary != (SELECT max(salary) FROM Employee);

# 非最大的最大的 => 第二大的
