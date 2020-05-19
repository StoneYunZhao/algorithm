# 查找有重复的 email

SELECT Email From Person GROUP BY Email HAVING count(Email) > 1;