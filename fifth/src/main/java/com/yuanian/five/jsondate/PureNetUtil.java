//package com.yuanian.five.jsondate;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Map;
//import java.util.Set;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//public class PureNetUtil {
//
//    public static String get(String url){
//        return post(url,null);
//    }
//
//   public static String post(String  url,Map   param){
//        HttpURLConnection conn=null;
//        try {
//            URL u=new URL(url);
//            conn=(HttpURLConnection) u.openConnection();
//            StringBuffer sb=null;
//            if(param!=null){
//                sb=new StringBuffer();
//
//                conn.setDoOutput(true);
//
//                conn.setRequestMethod("POST");
//
//                OutputStream out=conn.getOutputStream();
//
//                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(out));
//
//                Set<Map.Entry<String, String>> p= param.entrySet();
//                for(Map.Entry s:p){
//                    sb.append(s.getKey()).append("=").append(s.getValue()).append("&");
//                }
//
//                writer.write(sb.deleteCharAt(sb.toString().length()-1).toString());
//                writer.close();
//                sb=null;
//            }
//            conn.connect();
//            sb=new StringBuffer();
//
//            int recode=conn.getResponseCode();
//            BufferedReader reader=null;
//            if(recode==200){
//
//
//                InputStream in=conn.getInputStream();
//
//                reader=new BufferedReader(new InputStreamReader(in));
//                String str=null;
//                sb=new StringBuffer();
//
//                while((str=reader.readLine())!=null){
//                    sb.append(str).append(System.getProperty("line.separator"));
//                }
//
//                reader.close();
//                if (sb.toString().length() == 0) {
//                    return null;
//                }
//                return sb.toString().substring(0,
//                        sb.toString().length() - System.getProperty("line.separator").length());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }finally{
//            if(conn!=null)
//                conn.disconnect();
//        }
//        return null;
//    }
//
//}
