# CHAR_LENGTH() returns the length of a string in characters. Write a query to find the tweet_id of all tweets where the content is longer than 15 characters.
# LENGTH() returns the length of a string in bytes. If the string contains multi-byte characters, LENGTH() and CHAR_LENGTH() may return different values.

SELECT tweet_id
FROM Tweets
WHERE CHAR_LENGTH(content) > 15