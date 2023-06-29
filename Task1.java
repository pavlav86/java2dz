package HomeWork2;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class Task1 {
    public static void main(String[] args) {
        parse("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");
    }

    static void parse(String json) {

        JSONParser parser = new JSONParser();

        try {
            JSONObject rootJsonObject = (JSONObject) parser.parse(json);
            StringBuilder stringBuilder = new StringBuilder("SELECT * FROM `STUDENTS` WHERE ");
            String name = (String) rootJsonObject.get("name");
            if (!name.equals("null")) {
                stringBuilder.append("name = \'" + name + "\'");
            }
            String country = (String) rootJsonObject.get("country");
            if (!country.equals("null")) {
                stringBuilder.append(" AND ");
                stringBuilder.append("country = \'" + country + "\'");
            }
            String city = (String) rootJsonObject.get("city");
            if (!city.equals("null")) {
                stringBuilder.append(" AND ");
                stringBuilder.append("city = \'" + city + "\'");
            }
            String age = (String) rootJsonObject.get("age");
            System.out.println(age);
            if (!age.equals("null")) {
                stringBuilder.append(" AND ");
                stringBuilder.append("age = \'" + age + "\'");
            }
            String result = stringBuilder.toString();
            System.out.println(result);
        } catch (ParseException e) {
            System.out.println("Parsing error");
        }
    }
}
