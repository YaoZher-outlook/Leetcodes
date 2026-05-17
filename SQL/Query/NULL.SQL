#ifnull
SELECT name
 FROM Customer 
 WHERE IFNULL(referee_id, -1) != 2

#IS NULL
SELECT name
 FROM Customer 
 WHERE referee_id != '2' 
 OR referee_id IS NULL;