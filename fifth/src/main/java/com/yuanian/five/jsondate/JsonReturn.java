package com.yuanian.five.jsondate;


import com.yuanian.five.model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：mmzs
 * @date ：Created in 2019/8/29 23:33
 * @description：
 * @modified By：
 * @version: $
 */
public class JsonReturn {
//    public static String excute() {
//        //	String[] type = {"社会","国内","国际"};
//        String url = "http://192.168.51.122:9095/getRole    ";//+type[0];
//        return PureNetUtil.get(url);
//    }

    public static JSONObject JsonGet() throws Exception{
//        String result = excute();
//        System.out.println(result);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("reason","成功的返回");
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateformat.parse("2019-9-1 17:14:08");
        Date date1 = dateformat.parse("2019-9-2 17:14:12");
        Date date2 = dateformat.parse("2019-8-31 17:14:17");

        User user= new User();
        user.setUsercode("3");
        user.setUsername("老三");
        user.setDepartment("武汉技术开发部");
        user.setHiredate(date);
        JSONObject js = new JSONObject();
        js.put("usercode",user.getUsercode());
        js.put("username",user.getUsername());
        js.put("department",user.getDepartment());
        js.put("hiredate",getStringDateShort(user.getHiredate()));

//        User user1 = new User("10011","张三","华东预算事业部","2019-01-05")
        User user1= new User();
        user1.setUsercode("4");
        user1.setUsername("老四");
        user1.setDepartment("华北预算事业部");
        user1.setHiredate(date1);
        JSONObject js1 = new JSONObject();
        js1.put("usercode",user1.getUsercode());
        js1.put("username",user1.getUsername());
        js1.put("department",user1.getDepartment());
        js1.put("hiredate",getStringDateShort(user1.getHiredate()));
        User user2= new User();
        user2.setUsercode("5");
        user2.setUsername("老五");
        user2.setDepartment("北京事业部");
        user2.setHiredate(date2);
        JSONObject js2 = new JSONObject();
        js2.put("usercode",user2.getUsercode());
        js2.put("username",user2.getUsername());
        js2.put("department",user2.getDepartment());
        js2.put("hiredate",getStringDateShort(user2.getHiredate()));
        JSONArray ja = new JSONArray();
        ja.add(js);
        ja.add(js1);
        ja.add(js2);
        JSONObject jb3 = new JSONObject();
        jb3.put("stat","1");
        jb3.put("data",ja);

        result.put("result",jb3);

        JSONObject jsonObject = JSONObject.fromObject(result);
        return jsonObject;
    }

        public static String getStringDateShort(Date currentTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
        }

    public static void main(String[] args)  throws Exception{
        JSONObject o = JsonGet();
        System.out.println(o.toString());
    }
}
