-- Database
-- Easy

SELECT user_id, MAX(time_stamp) as last_stamp
FROM Logins
WHERE YEAR(time_stamp) = 2020
GROUP BY user_id;

/**
 * 先篩選2020的紀錄，按照user_id分組，用max求每個用戶的最大登錄時間
 **/