package sra.param.vo ;

import java.text.DecimalFormat;

import com.cmbc.edw.dao.AbstractPrimaryKey;

public class RowsetKey extends AbstractPrimaryKey {

  private static String table = "T_DEF_ROWSET";
  private static String pk = "RS_CD";
  private static String format = "0000000000";
  private static int offset = 0;

  private static RowsetKey instance = null;

  public static RowsetKey getInstance() {
    if (instance == null) {
      instance = new RowsetKey();
      instance.setWithoutKey(true);
    }
    return instance;
  }

  protected String buildMaxSql() {
    return "select max(" + pk + ") as CURRENT_VALUE FROM " + table;
  }

  protected String firstValue(String key) {
    return format;
  }

  protected void valueAdd(String org) {
    currentValue = new DecimalFormat(format).format(Integer.parseInt(currentValue.substring(offset)) + 1);
  }

}