--Total minutes read per child
SELECT child.child_id, child.child_name, SUM(child_book.minutes)
FROM child
        JOIN child_book ON child.child_id = child_book.child_id
WHERE user_id = 1
GROUP BY child.child_id