# jjq
java json query with expression


## Doc
 
 JsonQuery.query(String source, String expression)

- source: json string
- expression: expression separated by dot

## Sample

- source

```json
{
  "a": 1,
  "b": {
    "b1": "b11",
    "c": [
      {
        "d": {
          "e": true
        }
      },
      {
        "f": {
          "g": false
        }
      }
    ]
  }
}
```

- code

```java

JsonQuery.query(source, "a");
// 1

JsonQuery.query(source, "b.b1"); 
// b11

JsonQuery.query(source, "b.c.1.f"); 
// {"g":false}

JsonQuery.query(source, "b.c.1.f.g"); 
// false
```
