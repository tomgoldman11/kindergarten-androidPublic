package il.co.grauman.kindergarten.models;


public class DatesConversion {

 public static java.sql.Date UtilToSqlDate(java.util.Date uDate) {

     java.sql.Date sDate = new java.sql.Date(uDate.getTime());

     return sDate;

 }
 public static java.sql.Time UtilToSqlTime(java.util.Date uDate) {

     java.sql.Time sDate = new java.sql.Time(uDate.getTime());

     return sDate;

 }}
