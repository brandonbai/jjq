package io.github.brandonbai.jjq;

import io.github.brandonbai.jjq.exception.JqException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author brandon
 * @since 2019/07/30
 */
public class JsonQuery {

    public static Object query(String source, String expression) {

        validExpression(expression);

        String[] fields = expression.split("\\.");

        JSONObject jsonObj = new JSONObject(source);

        Object object = null;
        int fieldLen = fields.length;
        for (int i = 0; i < fieldLen; i++) {

            String f = fields[i];

            if (object != null) {
                if (object instanceof JSONArray) {
                    if (f.matches("\\d")) {
                        object = ((JSONArray) object).get(Integer.parseInt(f));
                    } else {
                        throw new JqException("Illegal expressions, " + expression);
                    }
                } else if (object instanceof JSONObject) {
                    object = ((JSONObject) object).get(f);
                }
            } else {
                object = jsonObj.get(f);
            }

        }

        return object;
    }


    public static void validExpression(String expression) {

        if (expression == null || expression.length() == 0) {
            throw new JqException("expression can not be null or empty");
        }

        char dot = '.';
        char[] cs = expression.toCharArray();

        int length = cs.length;

        if (length == 0) {
            throw new JqException("Illegal expressions, " + expression);
        }

        boolean isPreDot = false;
        for (char c : cs) {
            if (c == dot) {
                if (isPreDot) {
                    throw new JqException("Illegal expressions, " + expression);
                }
                isPreDot = true;
            } else {
                boolean isAlphaBeta = c <= 'Z' && c >= 'A' || c <= 'z' && c >= 'a' || c <= '9' && c >= '0';
                if (!isAlphaBeta) {
                    throw new JqException("Illegal expressions, " + expression);
                }
                isPreDot = false;
            }
        }

        if (cs[length - 1] == dot) {
            throw new JqException("Illegal expressions, " + expression);
        }

    }

}
