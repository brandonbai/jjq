# jjq
java json query with expression


## Doc
 
 JsonQuery.query(String source, String expression)

- source: json string
- expression: expression separated by dot

## Sample
```java
String source = "{\"a\": 1,\"b\": {\"b1\": \"b11\", \"c\": [{\"d\": {\"e\": true}}, {\"f\": {\"g\": false}}]}}";

System.out.println("result1= " + JsonQuery.query(source, "a")); 
// 1

System.out.println("result2= " + JsonQuery.query(source, "b.b1")); 
// b11

System.out.println("result3= " + JsonQuery.query(source, "b.c.1.f")); 
// {"g":false}

System.out.println("result3= " + JsonQuery.query(source, "b.c.1.f.g")); 
// false
```