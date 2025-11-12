SELECT p.firstName, p.LastName, a.City, a.state
FROM person p 
LEFT JOIN address a
ON p.personId = a.personId
