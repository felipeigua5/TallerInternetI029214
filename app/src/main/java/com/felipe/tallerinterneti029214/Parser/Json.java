package com.felipe.tallerinterneti029214.Parser;


import com.felipe.tallerinterneti029214.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/04/2018.
 */

public class Json {

    public static List<User> getDataJson(String s) throws JSONException {
        JSONArray jsonArray = new JSONArray(s);
        List<User> userList = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);

            User user = new User();
            user.setCodigo(item.getString("codigo"));
            user.setNombre(item.getString("nombre"));
            user.setEdad(item.getString("edad"));
            user.setCorreo(item.getString("correo"));

            userList.add(user);

        }

        return userList;
    }

}
